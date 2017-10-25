package servidor.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import org.json.JSONException;
import org.json.JSONObject;

public class ProxyServidor {
    
    public String ejecutar(String peticion) {
        
        String hostName = "localhost";
        int portNumber = 4444;
        String respuesta = "cerrar";
        
        try (
                Socket socket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            
            String fromServer;
            JSONObject fromBroker = null;
            
            if (peticion != null) {
                fromBroker = new JSONObject(peticion);
                
                while ((fromServer = in.readLine()) != null) {
                    if (fromServer.equals("cerrar"))
                        break;

                    respuesta = fromServer;
                    out.println(fromBroker);    
                    
                    System.out.println("Broker: " + fromBroker.toString());
                    System.out.println("Server: " + respuesta);
                }
            }
            
            
                   
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName + " port " + portNumber);
            e.printStackTrace();
            System.exit(1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
        return respuesta;
        
    }
    
}
