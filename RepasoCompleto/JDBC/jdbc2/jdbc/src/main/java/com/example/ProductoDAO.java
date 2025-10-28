package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAO {
    public void insertar(Producto producto){
        String sql = "INSERT INTO PRODUCTOS (nombre, descripcion, categoria_id, stock) VALUES (?, ?, ?, ?)";

        try(Connection con = Conexion.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setInt(3, producto.getCategoriaId());
            ps.setInt(4, producto.getStock());

            ps.executeUpdate();
            System.out.println("Insertado correctamente");
            
        } catch (Exception e) {
            System.out.println("Error al inserar" +e.getMessage());
        }
    }

    public void eliminar(int id){
        String sql = "DELETE FROM PRODUCTOS WHERE ID = ?";

        try(Connection con = Conexion.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Eliminado correctamente");
            
        } catch (Exception e) {
            System.out.println("Error al eliminar" +e.getMessage());
        }

    }

    public void mostrar(){
        String sql = "SELECT * FROM productos";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("producto_id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int categoriaId = rs.getInt("categoria_id");
                int stock = rs.getInt("stock");

                Producto producto = new Producto(id, nombre, descripcion, categoriaId, stock);
                System.out.println(producto);
            }

        } catch (SQLException e) {
            System.out.println("Error al mostrar los productos: " + e.getMessage());
        }
    }
}
