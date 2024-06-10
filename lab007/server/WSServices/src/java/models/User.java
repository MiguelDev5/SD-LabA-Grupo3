package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable{
    
    @XmlElement
    public String name;
    @XmlElement
    public String username;
    
    public static List<User> users = new ArrayList<>(
        Arrays.asList(
            new User("Miguel","migmig"),
            new User("Maxi","maxmax"),
            new User("Mateo","matmat")
        )
    ); 

    public User() {
        // Constructor vacío es necesario para JAXB
    }
    
    public User(String name, String username) {
        super();
        this.name = name;
        this.username = username;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static List<User> getUsers() {
        return users;
    }    
}