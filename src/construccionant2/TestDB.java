package construccionant2;

import modelo.dao.RecepcionistaDAO;
import modelo.dao.DoctorDAO;
import modelo.Recepcionista;
import modelo.Doctor;
import java.sql.Date;
import java.util.List;

public class TestDB {
    public static void main(String[] args) {
        // DAO para recepcionistas
        RecepcionistaDAO recepcionistaDAO = new RecepcionistaDAO();

        System.out.println("=== Lista de Recepcionistas ===");
        // Obtener y mostrar todos los recepcionistas
        for (Recepcionista recepcionista : recepcionistaDAO.consultar()) {
            System.out.println(recepcionista);
        }

        // DAO para doctores
        DoctorDAO doctorDAO = new DoctorDAO();

        System.out.println("\n=== Agregando un nuevo Doctor ===");
        // Crear un nuevo doctor y agregarlo
        Doctor nuevoDoctor = new Doctor(0, "ABC123", "Cardiología", 1000.0, 101, 1, "Dr. Juan Pérez", 
                                        Date.valueOf("2023-01-01"), "docPer@example.com", "9992365423", "docPerez", "password123");
        if (doctorDAO.agregar(nuevoDoctor)) {
            System.out.println("Nuevo doctor agregado: " + nuevoDoctor.getNombreCompleto());
        } else {
            System.out.println("Error al agregar el nuevo doctor.");
        }

        System.out.println("\n=== Lista de Doctores ===");
        // Obtener y mostrar todos los doctores
        List<Doctor> doctores = doctorDAO.consultar();
        for (Doctor doctor : doctores) {
            System.out.println(doctor);
        }
    }
}
