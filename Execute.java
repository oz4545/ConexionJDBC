import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConexionBD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/nombre_basedatos";
        String usuario = "tu_usuario";
        String contraseña = "tu_contraseña";

        Connection conexion = null;

        try {
            // Paso 2: Cargar el controlador de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Paso 3: Establecer la conexión
            conexion = DriverManager.getConnection(url, usuario, contraseña);

            if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos");

                try {
                    Statement statement = conexion.createStatement();
                    
                    // Ejemplo de executeQuery (selección)
                    ResultSet resultSet = statement.executeQuery("SELECT nombre FROM empleados");
                    while (resultSet.next()) {
                        String nombre = resultSet.getString("nombre");
                        System.out.println("Nombre: " + nombre);
                    }

                    // Ejemplo de executeUpdate (modificación)
                    int filasAfectadas = statement.executeUpdate("UPDATE empleados SET salario = salario * 1.1 WHERE edad > 30");
                    System.out.println("Filas afectadas: " + filasAfectadas);

                    // Ejemplo de execute (cualquier consulta)
                    boolean result = statement.execute("DELETE FROM empleados WHERE salario < 1000");
                    if (result) {
                        ResultSet deletedRows = statement.getResultSet();
                        // Procesar los resultados si es una consulta de selección
                    }

                } catch (SQLException e) {
                    System.err.println("Error al ejecutar la consulta: " + e.getMessage());
                } finally {
                    try {
                        if (conexion != null) {
                            conexion.close(); // Paso 5: Cerrar la conexión
                        }
                    } catch (SQLException e) {
                        System.err.println("Error al cerrar la conexión: " + e.getMessage());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
        }
    }
}
