package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    static String url = "jdbc:mysql://localhost:3306/bd_tienda";
    static String user = "root";
    static String password = "1234";

    public static Connection getConnection(){
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion realizada con exito");
        } catch (Exception e) {
            System.out.println("Conexion no realizada" +e.getMessage());
        }
        return conexion;
    }

    public Connection getDisconnection(Connection conexion){
        if (conexion!= null) {
            try {
                conexion.close();
                System.out.println("Desconectando BD :(");
            } catch (Exception e) {
                System.out.println("Error al desconectar BD" +e.getMessage());
            }
        }
        return conexion;
    }
}
