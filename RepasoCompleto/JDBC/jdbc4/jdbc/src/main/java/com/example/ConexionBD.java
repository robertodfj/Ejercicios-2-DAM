package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    static String url = "";
    static String user = "root";
    static String password = "1234";

    public static Connection getConexion(){
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion realizada");
        } catch (Exception e) {
            System.out.println("Conexion fallida " +e.getMessage());
        }
        return conexion;
    }

    public void desconexion(Connection conexion){
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexion cerrada BYE ;(");
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion " + e.getMessage());
            }

        }
    }
}
