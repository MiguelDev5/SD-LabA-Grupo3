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
        
        for(String p : productsSelected){
            message+=(p+" ");
        }
        
        return "Compra exitosaaaa de (" + productsSelected.size() + ") " + message + ")";
    }
}
