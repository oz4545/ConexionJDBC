import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MetodosResultSet {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/nombre_basedatos";
        String usuario = "tu_usuario";
        String contraseña = "tu_contraseña";

        Connection conexion = null;

        try {
            // Paso 1: Establecer la conexión
            conexion = DriverManager.getConnection(url, usuario, contraseña);

            if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos");

                try {
                    Statement statement = conexion.createStatement();

                    // Paso 2: Ejecutar una consulta SQL
                    String consulta = "SELECT id, nombre, salario FROM empleados";
                    ResultSet resultSet = statement.executeQuery(consulta);

                    // Paso 3: Trabajar con el ResultSet
                    
                    if (resultSet.isBeforeFirst()) {
                        resultSet.next(); // Avanzar al primer registro
                        int id = resultSet.getInt("id");
                        String nombre = resultSet.getString("nombre");
                        double salario = resultSet.getDouble("salario");
                        System.out.println("ID: " + id + ", Nombre: " + nombre + ", Salario: " + salario);
                    }

                    if (resultSet.isLast()) {
                        resultSet.previous(); // Retroceder al último registro
                        int id = resultSet.getInt("id");
                        String nombre = resultSet.getString("nombre");
                        double salario = resultSet.getDouble("salario");
                        System.out.println("ID: " + id + ", Nombre: " + nombre + ", Salario: " + salario);
                    }

                    // Iterar a través de los registros
                    while (resultSet.next()) {
                        int id = resultSet.getInt(1); // Índice de columna
                        String nombre = resultSet.getString("nombre");
                        double salario = resultSet.getDouble("salario");
                        System.out.println("ID: " + id + ", Nombre: " + nombre + ", Salario: " + salario);
                    }

                } catch (SQLException e) {
                    System.err.println("Error al ejecutar la consulta: " + e.getMessage());
                } finally {
                    try {
                        if (conexion != null) {
                            conexion.close(); // Paso 4: Cerrar la conexión
                        }
                    } catch (SQLException e) {
                        System.err.println("Error al cerrar la conexión: " + e.getMessage());
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
        }
    }
}
