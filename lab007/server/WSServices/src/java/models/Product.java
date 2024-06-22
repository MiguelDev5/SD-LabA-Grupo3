package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    
    @XmlElement
    public String name;
    
    @XmlElement
    public double price;

    public static List<Product> products = new ArrayList<>(
        Arrays.asList(
            new Product("Pan", 0.30),
            new Product("Queso", 2.5),
            new Product("Galletas", 1.4),
            new Product("Aceituna", 4.0),
            new Product("Jamon", 3.6),
            new Product("Azucar", 5.0),
            new Product("Keke", 1.5)
        )
    ); 
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public static List<Product> getProducts() {
        return products;
    }
}
