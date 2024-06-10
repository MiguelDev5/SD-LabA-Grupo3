package services;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import models.Product;

@WebService
public interface ProductServiceI {
    
    @WebMethod
    public List<Product> getAllProducts();
}
