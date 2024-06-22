import models.ConnectionDB;

public class Hola{
    public static void main(String[] args) {
        
        ConnectionDB prueba = new ConnectionDB();
        prueba.getDBConnection();        
    }
}