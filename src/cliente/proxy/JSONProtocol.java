import org.json.JSONException;
import org.json.JSONObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JSONProtocol {

    public String processInput(String theInput) {

        String theOutput = "Esperando comandos...";
        String command = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String response = dateFormat.format(new Date());
        JSONObject jsonOutput = new JSONObject();
        JSONObject jsonInput;

        try {
            if (theInput != null) {
                jsonInput = new JSONObject(theInput);
                command = jsonInput.getString("servicio");

                jsonOutput.put("servicio" , jsonInput.get("servicio"));
                jsonOutput.put("respuesta", response);

                switch (command) {
                    case "register":
                        theOutput = jsonOutput.toString();
                        break;
                    case "close":
                        theOutput = jsonOutput.toString();
                        break;
                    case "Bye.":
                        theOutput = "Bye.";
                        break;
                    default:
                        theOutput = "Comando no valido...";
                        break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return theOutput;

    }

}
