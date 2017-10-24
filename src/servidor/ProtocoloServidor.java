package servidor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import manejadorarchivos.ManejadorArchivos;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtocoloServidor {
    
    public String processInput(String theInput) {

        String theOutput = "ProtocoloServidor...";
        String servicio = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String response = dateFormat.format(new Date());
        JSONObject jsonOutput = new JSONObject();
        JSONObject jsonInput;

        try {
            if (theInput != null) {
                jsonInput = new JSONObject(theInput);
                servicio = jsonInput.getString("servicio");

                jsonOutput.put("servicio", jsonInput.get("servicio"));
                jsonOutput.put("respuesta", response);

                switch (servicio) {
                    case "votar":
                        theOutput = votar(jsonInput);
                        break;
                    case "cerrar":
                        theOutput = "cerrar";
                        break;
                    default:
                        theOutput = "cerrar";
                        break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return theOutput;

    }
    
    private String votar(JSONObject json) {
        
        ManejadorArchivos manejadorArchivo = new ManejadorArchivos();    
        String archivo = null;
        String lineaTexto = null;
        
        try {
            archivo = json.getString("archivo");
            lineaTexto = json.getString("lineaTexto");
            manejadorArchivo.escribirArchivo(archivo, lineaTexto);
        } catch (JSONException ex) {
            Logger.getLogger(ProtocoloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return "cerrar";
        
    }
    
}
