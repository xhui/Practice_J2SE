package ex.rmi.server;

import java.rmi.RemoteException;

public class ProductImpl implements IProduct {
	private String name;

	public ProductImpl(String name) throws RemoteException {
		this.name = name;
	}

	public String getName() throws RemoteException {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
