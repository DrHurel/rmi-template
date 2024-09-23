package rmi.server;

import rmi.common.RmiInterface;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class RmiServer extends UnicastRemoteObject implements RmiInterface {

    static Logger logger = Logger.getLogger("Server");
    
    protected RmiServer() throws RemoteException {
        super();
    }


    public String sayHello(String name) throws RemoteException {
        return "Hello, " + name + "!";
    }

    public static void main(String[] args) {
        try {
            // Start the RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Bind the remote object to the RMI registry
            Naming.rebind("//localhost/HelloServer", new RmiServer());
            logger.info("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
