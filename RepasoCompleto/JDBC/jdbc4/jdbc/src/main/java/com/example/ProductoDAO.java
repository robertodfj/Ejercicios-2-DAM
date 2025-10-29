package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductoDAO {
    public static void insertar(Producto p){
        String sql = "INSERT INTO productos (nombre, descripcion, categoria_id, stock) VALUES (?,?,?,?)";
        try (Connection conexion = ConexionBD.getConexion();
            PreparedStatement ps = conexion.prepareStatement(sql)){

                ps.setString(1, p.getNombre());
                ps.setString(2, p.getDescripcion());
                ps.setInt(3, p.getCategoriaId());
                ps.setInt(4, p.getStock());

                ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void borrar(int id){
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection conexion = ConexionBD.getConexion();
            PreparedStatement ps = conexion.prepareStatement(sql)){
                ps.setInt(1, id);
                ps.executeUpdate();

                System.out.println("Elemento borrado");
            
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void actualizar(Producto p) {
    String sql = "UPDATE productos SET nombre = ?, descripcion = ?, categoria_id = ?, stock = ? WHERE id = ?";
    try (Connection conexion = ConexionBD.getConexion();
         PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setString(1, p.getNombre());
        ps.setString(2, p.getDescripcion());
        ps.setInt(3, p.getCategoriaId());
        ps.setInt(4, p.getStock());
        ps.setInt(5, p.getId());

        int filas = ps.executeUpdate();

        if (filas > 0)
            System.out.println("Producto actualizado correctamente.");
        else
            System.out.println("No se encontró producto con ese ID.");

    } catch (Exception e) {
        System.out.println("Error al actualizar el producto: " + e.getMessage());
    }
}
}
