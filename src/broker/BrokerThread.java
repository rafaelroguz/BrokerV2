package broker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.json.JSONException;
import org.json.JSONObject;
import servidor.ProtocoloServidor;
import servidor.proxy.ProxyServidor;

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
            ProtocoloServidor protocolo = new ProtocoloServidor();
            outputLine = protocolo.processInput(null);
            out.println(outputLine);
            JSONObject json = null;
            String accion = null;
            
            while ((inputLine = in.readLine()) != null) {        
                outputLine = protocolo.processInput(inputLine);
                out.println(outputLine);
                
                json = new JSONObject(inputLine);
                accion = (String) json.get("accion");
                    
                switch (accion) {
                    case "registrar_servicio":
                        new ControlRegistro().registrarCliente((String) json.get("ip"));
                        System.out.println("Pos... se registró");
                        out.println(registrarServicio(json));
                        break;
                    case "registrar_usuario":
                        out.println(registrarUsuario(json));
                        break;
                    case "ejecutar_servicio":
                        json.remove("accion");
                        out.println(ejecutarServicio(json));
                        break;
                    default:
                        break;
                }
                
                if (outputLine.equals("cerrar"))                  
                    break;
            }

            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException ex) {
            System.out.println("Error de JSON ServidorThread.");
        }

    }

    private boolean registrarServicio(JSONObject json) {
        System.out.println("Usuario registrado correctamente.");
        return true;
    }

    private boolean registrarUsuario(JSONObject json) throws JSONException {
        new ControlRegistro().registrarCliente((String) json.get("ip"));
        System.out.println("Usuario registrado correctamente.");
        return true;
    }

    private String ejecutarServicio(JSONObject json) throws JSONException {    
        ProxyServidor proxy = new ProxyServidor();
        //Realizar validación del accion.
        System.out.println("Servicio validado.");
        return proxy.ejecutar(json.toString());
    }
    
}
