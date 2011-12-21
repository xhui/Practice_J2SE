package ex.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IProduct extends Remote {

	public String getName() throws RemoteException;
}
