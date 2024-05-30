import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

public class CajeroClient {
public static void main(String[] args) {
    double num1 = Double.parseDouble(args[0]);

    try {
        System.out.println( "Depositando "+num1 );
        CreditCard c = (CreditCard) Naming.lookup("rmi://localhost/CreditCardService");
        System.out.println( "Depositado ");
        c.depositar(num1);
        System.out.println( "Saldo final es: "+c.mostrar() );
    }
    catch (MalformedURLException murle) {
        System.out.println();
        System.out.println("MalformedURLException");
        System.out.println(murle);
    }
    catch (RemoteException re) {
        System.out.println();
        System.out.println("RemoteException");
        System.out.println(re);
    }
    catch (NotBoundException nbe) {
        System.out.println();
        System.out.println("NotBoundException");
        System.out.println(nbe);
    }
    catch (java.lang.ArithmeticException ae) {
        System.out.println();
        System.out.println("java.lang.ArithmeticException");
        System.out.println(ae);
    }
}
}