package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import manejadorarchivos.ManejadorArchivos;
import org.json.JSONException;
import org.json.JSONObject;

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
            JSONObject json = null;
            String servicio = null;
            
            while ((inputLine = in.readLine()) != null) {
                outputLine = protocolo.processInput(inputLine);
                out.println(outputLine);
                
                json = new JSONObject(inputLine);
                servicio = (String) json.get("servicio");
                
                if (outputLine.equals("cerrar")) {
                    out.println("cerrar");
                    break;
                } else {
                    switch (servicio) {
                        case "votar":
                            out.println(votar(json));
                            break;
                        case "contar":
                            out.println(contar(json));
                            break;
                        default:
                            break;
                    }              
                }             
            }

            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException ex) {
            System.out.println("Error de JSON ServidorThread.");
        }

    }
 
    private boolean votar(JSONObject json) {
        
        ManejadorArchivos manejadorArchivo = new ManejadorArchivos();    
        String archivo = null;
        String lineaTexto = null;
        
        try {
            archivo = json.getString("archivo");
            lineaTexto = json.getString("lineaTexto");
            manejadorArchivo.escribirArchivo(archivo, lineaTexto);
            
            return true;
        } catch (JSONException ex) {
            System.out.println("Error de JSON en ProtocoloServidor - votar");
        }
                
        return false;
        
    }
    
    private String contar(JSONObject json) {
        ManejadorArchivos manejadorArchivo = new ManejadorArchivos();    
        String archivo = null;
        int numeroVotos = 0;
        
        try {
            archivo = json.getString("archivo");
            numeroVotos = manejadorArchivo.leerVotos(archivo);
            
            return Integer.toString(numeroVotos);
        } catch (JSONException ex) {
            System.out.println("Error de JSON en ProtocoloServidor - contar.");
        }
        
        return Integer.toString(numeroVotos);
    }
    
}