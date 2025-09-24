
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main{
    public static void main(String[] args) {
        // Conexion
        String url = "jdbc:mysql://localhost:3306/bd_tienda";
        String user = "root";
        String password =  "hemrof-6pyrgi";

        try {
            Connection conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado con exito.");

            // Metodos

            consultar(conexion);
            insertar(conexion);
            actualizar(conexion);
            eliminar(conexion);

            // Cerrar conexion
            System.out.println("Bye :( ...");
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en la conexion de la BD" +e.getMessage());
        }
    }

    public static void consultar(Connection connection) throws SQLException {
                 String sql =   "SELECT productos.producto_id, " +
                        "       productos.nombre, " +
                        "       productos.descripcion, " +
                        "       categorias.nombre AS nombre_categoria " +
                        "FROM productos " +
                        "INNER JOIN categorias ON productos.categoria_id = categorias.categoria_id " +
                        "ORDER BY productos.producto_id";
        
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int productosId = rs.getInt(1);
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            String categoria = rs.getString("nombre_categoria");

            System.out.println();
            System.out.println(productosId + "|" +nombre+ "|" +descripcion+ "|" +categoria);
        }

        System.out.println();

        rs.close();
        st.close();
    }

    public static void insertar(Connection connection) throws SQLException{
        String sql = "INSERT INTO productos (nombre, descripcion, categoria_id, stock)" +
                    " VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "Camiseta Real Madrid");
            ps.setString(2, "Camiseta oficial version jugador real madrid firmada");
            ps.setInt(3, 1);
            ps.setInt(4, 10);

            ps.executeUpdate();
            ps.close();

            System.out.println("Insertado correctamente");
        } catch (Exception e) {
            System.out.println("Error al insertar.");
        }
    }

    public static void actualizar(Connection connection) throws SQLException {
        String sql = "UPDATE productos set nombre = 'Camiseta del barsa'" +
                     " ,descripcion = 'Camiseta del barsa' WHERE nombre LIKE 'Camiseta Real Madrid' ";

        Statement st = connection.createStatement();
        int lineas = st.executeUpdate(sql);
        st.close();

        System.out.println("Editado correctamente: " +lineas+ " filas");
    }

    public static void eliminar(Connection connection) throws SQLException {
        String sql = "DELETE from productos WHERE nombre LIKE 'Camiseta del barsa' ";

        Statement st = connection.createStatement();

        int fila = st.executeUpdate(sql);
        st.close();

        System.out.println("Filas eliminadas: " +fila);
    }
}