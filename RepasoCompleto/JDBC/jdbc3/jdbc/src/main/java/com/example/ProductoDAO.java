package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductoDAO {
    public void insertarProducto(Producto p ){
        String sql = "INSERT INTO productos (nombre, descripcion, categoria_id, stock) VALUES (?,?,?,?)";
        try (Connection conexion = ConexionBD.conectar();
                PreparedStatement ps = conexion.prepareStatement(sql)){

                    ps.setString(1, p.getNombre());
                    ps.setString(2, p.getDescripcion());
                    ps.setInt(3, p.getCategoriaId());
                    ps.setInt(4, p.getStock());

                    ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error al insertar lineas");
        }
    }

    public void actualizar(Producto p){
        String sql = "UPDATE productos SET nombre = ?, descripcion = ?, categoria_id = ?, stock = ? WHERE id = ?";
        try (Connection conexion = ConexionBD.conectar();
                PreparedStatement ps = conexion.prepareStatement(sql)){

                    ps.setInt(5, p.getId());

                    ps.setString(1, p.getNombre());
                    ps.setString(2, p.getDescripcion());
                    ps.setInt(3, p.getCategoriaId());
                    ps.setInt(4, p.getStock());

                    ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error al actualizar lineas");
        }
    }

    public void borrar(int id){
        String sql = "DELETE FROM producto WHERE id = ?";
        try (Connection conexion = ConexionBD.conectar();
                PreparedStatement ps = conexion.prepareStatement(sql)){

                    ps.setInt(1, id);
                    ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error al actualizar lineas");
        }

    }
}
