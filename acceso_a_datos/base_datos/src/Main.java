
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // Conexion a BD
        
        String url = "jdbc:mysql://localhost:3306/bd_tienda";
        String url1 = "jdbc:mysql://localhost:3306/bd_empleados";
        String user ="root";
        String password = "hemrof-6pyrgi"; 

        try {
            Connection conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion realzada");
            Connection conexion1 = DriverManager.getConnection(url1, user, password);
            System.out.println("Conexion realizada bd 1");

            consultar(conexion);
            insertar(conexion);
            actualizar(conexion);
            eliminar(conexion);

            // cerrar conexionm
            System.out.println("Cerramos conexion");
            conexion.close();
            conexion1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void consultar(Connection conexion) throws SQLException {
        // Opcion 1
        String sql = "SELECT productos.producto_id, productos.nombre AS nombre_producto, " +
                    "productos.descripcion, categorias.nombre AS nombre_categoria " +
                    "FROM productos " +
                    "INNER JOIN categorias ON productos.categoria_id = categorias.categoria_id " +
                    "ORDER BY producto_id";

        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int producto_id = rs.getInt(1);
            String nombre = rs.getString("nombre_producto");
            String descripcion = rs.getString("descripcion");
            String nombreCategoria = rs.getString("nombre_categoria");

            System.out.println(producto_id + " | " + nombre + " | " + descripcion + " | " + nombreCategoria);
        }
        System.out.println();

        rs.close();
        st.close();

        //Opcion 2
        String sql2 = "SELECT categoria_id, nombre "
                        + "FROM categorias "
                        + "WHERE categoria_id = ?";

        PreparedStatement ps = conexion.prepareStatement(sql2);
        ps.setInt(1, 1);

        ResultSet rs2 = ps.executeQuery();

        while (rs2.next()) {
            int categoriaId = rs2.getInt("categoria_id");
            String categoriaNombre = rs2.getString("nombre");
            
            System.out.println("ID categoria: " +categoriaId + ", Nombre Categoria: " +categoriaNombre);
            System.out.println();
        }

        rs2.close();
        ps.close();
    }

    public static void insertar(Connection conexion) throws SQLException{
        // Opcion 1
        String sql = "INSERT INTO productos (nombre, descripcion, categoria_id, stock) "
            + "VALUES ('Camisa Lino', 'Talla XXS, algodon 100%', 1, 20)";

        Statement st = conexion.createStatement();
        st.executeUpdate(sql);
        st.close();

        System.out.println("Insertado correctamente.");

        // Opcion 2 
        String sql2 = "INSERT INTO productos (nombre, descripcion, categoria_id, stock) "
                    +"VALUES (?,?,?,?)";

        PreparedStatement ps = conexion.prepareStatement(sql2);
        ps.setString(1, "Audifonos");
        ps.setString(2, "Auriculares por cable, calidad buena");
        ps.setInt(3, 2);
        ps.setInt(4, 10);

        ps.executeUpdate();
        ps.close();

        System.out.println("Insertado correctamente");
    }

    private static void actualizar(Connection conexion) throws SQLException{
        String sql = "UPDATE productos SET nombre = 'Auriculares colacao' WHERE nombre LIKE 'Audifonos'";
        Statement st = conexion.createStatement();

        int filas = st.executeUpdate(sql);
        st.close();

        System.out.println("Actualizadas: " +filas+ " fila/s");
    }

    public static void eliminar(Connection conexion) throws SQLException{
        String sql = "DELETE FROM productos WHERE nombre LIKE 'CAMISA LINO'";

        Statement st = conexion.createStatement();
        int filas = st.executeUpdate(sql);

        System.out.println("Borradas " +filas+ " fila/s");
    }
}
