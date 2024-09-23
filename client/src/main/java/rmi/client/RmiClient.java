package rmi.client;

import rmi.common.RmiInterface;

import java.rmi.Naming;
import java.util.logging.Logger;
import java.util.logging.Level;
public class RmiClient {

    static Logger logger = Logger.getLogger("Server");
    
    public static void main(String[] args) {
        try {
            // Lookup the remote object in the RMI registry
            RmiInterface hello = (RmiInterface) Naming.lookup("//localhost/HelloServer");

            // Call the remote method
            String response = hello.sayHello("World");
            logger.log(Level.INFO,"Response from server: {0}",response);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }
}
