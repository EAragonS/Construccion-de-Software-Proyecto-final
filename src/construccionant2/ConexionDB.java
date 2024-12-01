package construccionant2;

/**
 *
 * @author Elias
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/Clinica";
    private static final String USUARIO = "root"; // Cambia si tienes otro usuario
    private static final String PASSWORD = ""; // Añade tu contraseña si aplica

    public static Connection getConnection() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar con la base de datos.");
        }
        return conexion;
    }
}
