import org.json.JSONException;
import org.json.JSONObject;
import java.io.*;
import java.net.*;

public class KnockKnockClient {
    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.err.println(
                    "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (
                Socket kkSocket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(kkSocket.getInputStream()));
        ) {
            BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;

            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);

                if (fromServer.equals("Bye."))
                    break;

                fromUser = stdIn.readLine();

                if (fromUser != null) {
                    String ip_client = String.valueOf(InetAddress.getLocalHost().getHostAddress());
                    JSONObject json = new JSONObject();

                    json.put("servicio", fromUser);
                    json.put("ip", String.valueOf(InetAddress.getLocalHost().getHostAddress()));

                    System.out.println("Client: " + json);

                    out.println(json);
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

    }
}