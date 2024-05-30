import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public CalculatorServer() {
        try {
            Calculator c = new CalculatorImpl();
            
            // Intentar crear el registro RMI si no existe
            try {
                LocateRegistry.createRegistry(1099);
                System.out.println("Registro RMI creado en el puerto 1099.");
            } catch (RemoteException e) {
                System.out.println("Registro RMI ya existente: " + e.getMessage());
            }

            Naming.rebind("rmi://localhost:1099/CalculatorService", c);
            System.out.println("CalculatorService está registrado y listo.");
        } catch (Exception e) {
            System.out.println("Problema: " + e);
        }
    }

    public static void main(String args[]) {
        new CalculatorServer();
    }
}
