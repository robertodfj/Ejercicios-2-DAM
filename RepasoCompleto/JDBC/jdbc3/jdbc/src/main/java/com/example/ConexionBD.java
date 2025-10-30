package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    static String url = "";
    static String user = "root";
    static String password = "";

    public static Connection conectar(){
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Base de datos conectada de manera correcta");
        } catch (Exception e) {
            System.out.println("Error al conectar con la BD " +e.getMessage());
        }
        return conexion;
    }

    public static void desconectar(Connection connection){
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexion cerrada de manera correcta");
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion");
            }
        }
    }
}
