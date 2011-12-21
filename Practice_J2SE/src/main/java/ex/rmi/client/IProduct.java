package ex.rmi.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IProduct extends Remote {

	public String getName() throws RemoteException;
}
