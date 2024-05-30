import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CajeroServer {
    public CajeroServer() {
        try {
            CreditCard c = new CreditCardImpl();
            
            // Intentar crear el registro RMI si no existe
            try {
                LocateRegistry.createRegistry(1100);
                System.out.println("Registro RMI creado en el puerto 1100.");
            } catch (RemoteException e) {
                System.out.println("Registro RMI ya existente: " + e.getMessage());
            }

            Naming.rebind("rmi://localhost:1100/CreditCardService", c);
            System.out.println("CreditCardService está registrado y listo.");
        } catch (Exception e) {
            System.out.println("Problema: " + e);
        }
    }

    public static void main(String args[]) {
        new CajeroServer();
    }
}
