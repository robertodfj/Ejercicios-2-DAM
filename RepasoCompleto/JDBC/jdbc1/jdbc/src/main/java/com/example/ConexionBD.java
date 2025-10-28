package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Variables estáticas de configuración
    private static final String URL = "jdbc:mysql://localhost:3306/bd_tienda";
    private static final String USER = "root";
    private static final String PASSWORD = "tu_contraseña";

    // Método estático que devuelve una conexión
    public static Connection getConexion() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión establecida correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a la base de datos.");
            e.printStackTrace();
        }
        return conexion;
    }

    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("🔒 Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("⚠️ Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }
}