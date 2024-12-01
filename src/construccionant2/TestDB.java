package construccionant2;

import dao.RecepcionistaDAO;
import modelo.Recepcionista;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        try (Connection conexion = ConexionDB.getConnection()) { // Usar tu clase para obtener la conexión
            System.out.println("Conexión exitosa a la base de datos");

            // Crear una instancia del DAO
            RecepcionistaDAO recepcionistaDAO = new RecepcionistaDAO(conexion);

            // Probar obtener todos los registros e imprimirlos
            System.out.println("Lista de recepcionistas:");
            for (Recepcionista recepcionista : recepcionistaDAO.obtenerTodos()) {
                System.out.println(recepcionista);
            }

        } catch (Exception e) {
            System.err.println("Error al obtener datos: " + e.getMessage());
        }
    }
}
