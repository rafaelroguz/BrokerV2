package broker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import servidor.proxy.ProxyServidor;

public class ProtocoloBroker {

    public String processInput(String theInput) {

        String theOutput = "";
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
                    case "registrar":
                        theOutput = registrarUsuario(jsonInput);
                        break;
                    case "cerrar":
                        theOutput = "cerrar";
                        break;
                    default:
                        theOutput = validarServicio(jsonInput);
                        break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return theOutput;

    }
    
    private String registrarUsuario(JSONObject json) throws JSONException {
        new ControlRegistro().registrarCliente((String) json.get("ip"));
        System.out.println("Usuario registrado correctamente.");
        
        return "cerrar";
    }
    
    private String validarServicio(JSONObject json) {
        ProxyServidor proxy = new ProxyServidor();
        //Realizar validación del servicio.
        System.out.println("Servicio validado.");
        proxy.ejecutar(json.toString());
        return "cerrar";
    }

}
