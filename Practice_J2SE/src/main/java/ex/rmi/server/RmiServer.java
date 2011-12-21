package ex.rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiServer {
	public static void main(String args[]) {
		try {
			ProductImpl impl = new ProductImpl("TestProduct");

			IProduct stub = (IProduct) UnicastRemoteObject
					.exportObject(impl, 0);

			Registry registry = LocateRegistry.getRegistry();
			registry.bind("test", stub);

			System.err.println("Server ready");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
