import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CnxJdbcConStatement {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mi_basedatos";
        String usuario = "mi_usuario";
        String contraseña = "mi_contraseña";
        
        Connection conexion = null;
        
        //Statement. parametro antes no usado Un Statement en JDBC permite ejecutar consultas SQL 
        //(tanto de selección como de modificación) en una base de datos desde una aplicación Java.
        
        Statement st = null;
        
        try {
            // Paso 1: Establecer la conexión
            conexion = DriverManager.getConnection(url, usuario, contraseña);

            // Paso 2: Crear un objeto Statement
            st = conexion.createStatement();

            // Paso 3: Ejecutar una consulta SQL
            String consulta = "SELECT * FROM empleados";
            ResultSet resultado = st.executeQuery(consulta);

            // Paso 4: Procesar el resultado
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                double salario = resultado.getDouble("salario");
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Salario: " + salario);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                // Paso 5: Cerrar la conexión y el Statement
                if (st != null) {
                    st.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
