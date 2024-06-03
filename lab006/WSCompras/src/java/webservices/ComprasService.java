package webservices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author angel
 */
@WebService(serviceName = "ComprasService")
public class ComprasService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "a-prueba")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "comprar")
    public String compraProductos(
        @WebParam(name = "cantidadPan") int cantidadPan, 
        @WebParam(name = "cantidadQueso") int cantidadQueso, 
        @WebParam(name = "cantidadPlatanos") int cantidadPlatanos, 
        @WebParam(name = "cantidadNaranjas") int cantidadNaranjas
    ){
        String message = "";
        double total = 0.0;

        if (cantidadPan < 1 || cantidadQueso < 1 || cantidadPlatanos < 1 || cantidadNaranjas < 1) {
            message = "Las cantidades son incorrectas";
        } else {
            message = "Correcto\n";
            total += cantidadPan * 0.50;
            message += "Pan: " + cantidadPan + " unidades -> subTotal = " + cantidadPan * 0.50 + "\n";

            total += cantidadQueso * 2.50;
            message += "Queso: " + cantidadQueso + " unidades -> subTotal = " + cantidadQueso * 2.50 + "\n";

            total += cantidadPlatanos * 0.40;
            message += "Plátano: " + cantidadPlatanos + " unidades -> subTotal = " + cantidadPlatanos * 0.40 + "\n";

            total += cantidadNaranjas * 0.40;
            message += "Naranja: " + cantidadNaranjas + " unidades -> subTotal = " + cantidadNaranjas * 0.40 + "\n";
        }

        return message;
    }
}
