public interface CreditCard extends java.rmi.Remote {
    public double depositar(double amount) throws java.rmi.RemoteException;
    public double retirar(double amount) throws java.rmi.RemoteException;
    public double mostrar() throws java.rmi.RemoteException;
}