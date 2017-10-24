package broker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BrokerThread extends Thread {
    
    private Socket socket = null;

    public BrokerThread(Socket socket) {
        super("BrokerThread");
        this.socket = socket;
    }

    @Override
    public void run() {

        try (
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {

            String inputLine, outputLine;
            ProtocoloBroker protocolo = new ProtocoloBroker();
            outputLine = protocolo.processInput(null);
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                //Petición ya procesada se regresa en json, para enviar al cliente.
                outputLine = protocolo.processInput(inputLine);
                System.out.println("BrokerThread: " + outputLine);
                out.println(outputLine);
                
                if (outputLine.equals("cerrar"))
                    break;
       
            }

            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}
