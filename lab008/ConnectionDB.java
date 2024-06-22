package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    Connection con;

    public Connection getDBConnection() {
        
        String myDB = "jdbc:mysql://localhost:3306/pruebasdb08?serverTimezone=UTC";
        try{
            System.out.print("Preprando ccconnection......");
            con = DriverManager.getConnection(myDB, "root", "m5249024");
            System.out.print("Conexión exitosa");
            return con;
        }catch(SQLException e){
            System.out.print("Error " + e.toString());
        }
        
        return null;
    }
}
