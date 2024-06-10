package services;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import models.User;

@WebService(serviceName = "SalesService")
public class SalesService implements SalesServiceI{

    @WebMethod(operationName = "sale")
    public String sale(@WebParam(name = "productsList") List<String> productsSelected) {
        String message = "( ";
        double total = 0;
        
        for(String p : productsSelected){
            message+=(p+" ");
            total += getProductPrice(message);
        }
        
        // Retorna la compra exitosa y el costo final de los productos en un solo mensaje
        return "Compra exitosaaaa de (" + productsSelected.size() + ") " + message + "| Costo: " + total + " soles)";
    }

    // Retorna el precio del producto
    public double getProductPrice(String productoPrecio){
        String number = productoPrecio.substring(productoPrecio.lastIndexOf(" "));
        return Double.parseDouble(number);
    }
}
