package ex.rmi.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiClient {
	private RmiClient() {
	}

	public static void main(String[] args) {

		try {
			Registry registry = LocateRegistry.getRegistry("172.16.15.76");
			IProduct stub = (IProduct) registry.lookup("test");
			String response = stub.getName();
			System.out.println("response: " + response);
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
