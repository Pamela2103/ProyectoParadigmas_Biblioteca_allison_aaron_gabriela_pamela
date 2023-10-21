package com.mycompany.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CConexion {

    
    String User = "root";
    String Password = "Pamela2103";
    String bd = "biblioteca";
    String ip = "localhost";
    String puerto = "3310";
    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;

    public Connection estableceConexion() {
        Connection conectar = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, User, Password);
            System.out.println("Se conecto correctamente a la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("No se conecto correctamente a la base de datos, error: " + e.toString());
        }
        return conectar;
    }
}
