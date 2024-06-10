package services;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import models.Product;

@WebService(serviceName = "ProductService")
public class ProductService implements ProductServiceI{

    @Override
    public List<Product> getAllProducts() {
        return Product.getProducts();
    }
}
