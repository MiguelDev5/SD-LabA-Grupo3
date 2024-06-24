package com.ocho.miguel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    Connection con;

    public Connection getDBConnection() {

        String myDB = "jdbc:mysql://localhost:3306/proyectosdb?serverTimezone=UTC";
        try{
            System.out.println("Preprando conexión...");
            con = DriverManager.getConnection(myDB, "root", "m5249024");
            System.out.println("Conexión exitosa");
            return con;
        }catch(SQLException e){
            System.out.println("Error de conexión " + e.toString());
        }

        return null;
    }
}
