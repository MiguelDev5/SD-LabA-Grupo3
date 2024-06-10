package services;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import models.User;

@WebService
public interface SalesServiceI {

    @WebMethod
    public String sale(@WebParam(name = "products") List<String> productsSelected);
}
