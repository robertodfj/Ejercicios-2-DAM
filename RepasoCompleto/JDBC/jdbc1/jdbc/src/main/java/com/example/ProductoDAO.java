package com.example;

import java.sql.Connection;

public class ProductoDAO {

    public void insertarProducto(Producto producto) {
        String sql = "INSERT INTO productos (nombre, descripcion, categoria_id, stock) VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.getConexion();
             var pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, producto.getNombre());
            pstmt.setString(2, producto.getDescripcion());
            pstmt.setInt(3, producto.getCategoriaId());
            pstmt.setInt(4, producto.getStock());

            int filasInsertadas = pstmt.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("✅ Producto insertado correctamente.");
            }
            
        } catch (Exception e) {
            System.out.println("❌ Error al insertar el producto." + e.getMessage());
        }
    }

    public void eliminarProducto(int id){
        String sql = "DELETE FROM productos WHERE id = ?";

        try (Connection conexion = ConexionBD.getConexion();
             var pstmt = conexion.prepareStatement(sql)){

                pstmt.setInt(1, id);
                pstmt.executeUpdate();

                System.out.println("✅ Producto eliminado correctamente.");
            
        } catch (Exception e) {
            System.out.println("❌ Error al eliminar el producto." + e.getMessage());
        }

        
    }

    public void actualizarProducto(Producto producto){
        String sql = "UPDATE productos SET nombre = ?, descripcion = ?, categoria_id = ?, stock = ? WHERE id = ?";

        try (Connection conexion = ConexionBD.getConexion();
             var pstmt = conexion.prepareStatement(sql)){

                pstmt.setString(1, producto.getNombre());
                pstmt.setString(2, producto.getDescripcion());
                pstmt.setInt(3, producto.getCategoriaId());
                pstmt.setInt(4, producto.getStock());
                pstmt.setInt(5, producto.getId());

                pstmt.executeUpdate();

                System.out.println("✅ Producto actualizado correctamente.");
            
        } catch (Exception e) {
            System.out.println("❌ Error al actualizar el producto." + e.getMessage());
        }
    }

    public void mostrarTodos(){
        String sql = "SELECT * FROM productos";

        try (Connection conexion = ConexionBD.getConexion();
             var pstmt = conexion.prepareStatement(sql)){

                var rs = pstmt.executeQuery();

                while(rs.next()){
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String descripcion = rs.getString("descripcion");
                    int categoriaId = rs.getInt("categoria_id");
                    int stock = rs.getInt("stock");

                    Producto producto = new Producto(id, nombre, descripcion, categoriaId, stock);
                    System.out.println(producto);
                }
            
        } catch (Exception e) {
            System.out.println("❌ Error al mostrar los productos." + e.getMessage());
        }
    }
}
