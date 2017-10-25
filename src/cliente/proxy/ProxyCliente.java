package cliente.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.json.JSONException;
import org.json.JSONObject;

public class ProxyCliente {
    
    public String ejecutar(String peticion) {
        
        String hostName = "localhost";
        int portNumber = 4443;
        String respuesta = "cerrar";
        
        try (
                Socket socket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            
            String fromBroker; 
            String servicio = null;
            JSONObject fromUser = null;
            JSONObject output = new JSONObject();
            String ip_cliente = String.valueOf(InetAddress.getLocalHost().getHostAddress());
            
            while ((fromBroker = in.readLine()) != null) {
                
                if (fromBroker.equals("cerrar"))
                    break;

                if (peticion != null) { 
                    fromUser = new JSONObject(peticion);
                    respuesta = fromBroker;
                    servicio = (String) fromUser.get("servicio");
                    System.out.println("User: " + fromUser.toString());
                    System.out.println("Broker: " + respuesta);
                    
                    switch (servicio) {
                        case "votar":
                            output.put("accion", "ejecutar_servicio");
                            output.put("servicio", "votar");
                            output.put("archivo", fromUser.get("archivo"));
                            output.put("lineaTexto", fromUser.get("lineaTexto"));
                            out.println(output.toString());
                            break;
                        case "contar":
                            output.put("accion", "ejecutar_servicio");
                            output.put("servicio", "contar");
                            output.put("archivo", fromUser.get("archivo"));
                            out.println(output.toString());
                            break;
                        case "registrar":
                            output.put("accion", "registrar_usuario");
                            output.put("ip", ip_cliente);
                            out.println(output.toString());
                            break;
                        default:
                            break;
                    }                  
                }
            }
            
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName+ " port " + portNumber);
            e.printStackTrace();
            System.exit(1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
        return respuesta;
        
    }
    
}
