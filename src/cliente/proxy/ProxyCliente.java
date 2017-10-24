package cliente.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import org.json.JSONException;
import org.json.JSONObject;

public class ProxyCliente {
    
    public String ejecutar(String peticion) {
        
        //4443 para Broker servidor.
        String hostName = "localhost";
        int portNumber = 8080;
        String respuesta = "";
        
        try (
                Socket socket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            
            String fromBroker;    
            JSONObject fromUser = null;
                       
            while ((fromBroker = in.readLine()) != null) {
                System.out.println("Broker: " + fromBroker);

                if (fromBroker.equals("cerrar"))
                    break;

                if (peticion != null) { 
                    fromUser = new JSONObject(peticion);
                    respuesta = fromBroker;

                    System.out.println("ProxyClient: " + fromUser.toString());

                    out.println(fromUser);
                }
            }
            
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
        return respuesta;
        
    }
    
}
