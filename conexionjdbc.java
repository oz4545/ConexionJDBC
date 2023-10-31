//Paso 1: Importar las clases necesarias

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Paso 2: definir parametros de login

public class ConexionBD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/nombre_basedatos";
        String usuario = "tu_usuario";
        String contraseña = "tu_contraseña";

// nota: Cargar el controlador de MySQLAsegúrate de reemplazar "nombre_basedatos", 
//"tu_usuario", y "tu_contraseña" con los valores apropiados para tu base de datos.  

        //Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
        Connection conexion = null; //como no hay conexion se deja null de lo contrario usar el parametro anterior

// Paso 3: Aquí puedes realizar consultas y operaciones en la base de datos

        try {
            // Paso 2: Cargar el controlador de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Paso 3: Establecer la conexión
            conexion = DriverManager.getConnection(url, usuario, contraseña);

            if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos");
                // Aquí puedes realizar consultas y operaciones en la base de datos
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
        } finally {

// Paso 5: Cerrar la conexión
                }            
            try {
                if (conexion != null) {
                    conexion.close(); 
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}