import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CreditCardImpl extends java.rmi.server.UnicastRemoteObject implements CreditCard {

    double SALDO = 5000;

	public CreditCardImpl() throws java.rmi.RemoteException {
        super();
	}
	public double depositar(double amount) throws java.rmi.RemoteException {
        return SALDO + amount;
	}
	public double retirar(double amount) throws java.rmi.RemoteException {
        return SALDO - amount;
	}
	public double mostrar() throws java.rmi.RemoteException {
        return SALDO;
	}
}