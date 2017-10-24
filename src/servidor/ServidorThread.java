package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorThread extends Thread {
    
    private Socket socket = null;

    public ServidorThread(Socket socket) {
        super("ServidorThread");
        this.socket = socket;
    }

    @Override
    public void run() {

        try (
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {

            String inputLine, outputLine;
            ProtocoloServidor protocolo = new ProtocoloServidor();
            outputLine = protocolo.processInput(null);
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                //Petición ya procesada se regresa en json, para enviar al Broker.
                outputLine = protocolo.processInput(inputLine);
                System.out.println("ServidorThread: " + outputLine);
                out.println(outputLine);
                
                if (outputLine.equals("Bye"))
                    break;
            }

            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}