package broker;

import java.io.IOException;
import java.net.ServerSocket;

public class Broker {
    
    public static void main(String[] args) throws IOException {
        
        System.out.println("~~~~~~BROKER~~~~~~");
        
        int portNumber = 4443;
        boolean listening = true;
        
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) { 
            while (listening) {
	            new BrokerThread(serverSocket.accept()).start();
	        }
	    } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
        
    }
    
}
