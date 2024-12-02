package construccionant2;

import modelo.dao.RecepcionistaDAO;
import modelo.dao.DoctorDAO;
import modelo.dao.EmpleadoDAO;
import modelo.Recepcionista;
import modelo.Doctor;
import modelo.Empleado;
import java.sql.Date;
import java.util.List;

public class TestDB {
    public static void main(String[] args) {
        // DAO para empleados y doctores
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        DoctorDAO doctorDAO = new DoctorDAO();

        System.out.println("\n=== Agregando un nuevo Doctor ===");

        // Crear el objeto Doctor con información básica
        Doctor nuevoDoctor = new Doctor(
            0, // El ID será generado automáticamente
            "ABC123",
            "Cardiología",
            1000.0,
            101,
            0, // Relación con empleado se establece después
            "Juan Pérez",
            Date.valueOf("2024-12-01"),
            "docPer@example.com",
            "9992365423",
            "docPerez",
            "password123"
        );

        // Buscar si ya existe un empleado con el mismo correo electrónico
        List<Empleado> empleados = empleadoDAO.consultar();
        Empleado empleadoExistente = empleados.stream()
            .filter(e -> e.getCorreoElectronico().equals(nuevoDoctor.getCorreoElectronico()))
            .findFirst()
            .orElse(null);

        // Si el empleado no existe, se agrega
        if (empleadoExistente == null) {
            Empleado nuevoEmpleado = new Empleado(
                0, // ID generado automáticamente
                nuevoDoctor.getNombreCompleto(),
                nuevoDoctor.getFechaIngreso(),
                nuevoDoctor.getCorreoElectronico(),
                nuevoDoctor.getNumTelefono(),
                nuevoDoctor.getNombreUsuario(),
                nuevoDoctor.getContrasena()
            );

            if (!empleadoDAO.agregar(nuevoEmpleado)) {
                System.out.println("Error al agregar el nuevo empleado.");
                return; // Terminar si falla
            } else {
                System.out.println("Nuevo empleado agregado: " + nuevoEmpleado.getNombreCompleto());

                // Actualizar referencia al nuevo empleado
                empleados = empleadoDAO.consultar();
                empleadoExistente = empleados.stream()
                    .filter(e -> e.getCorreoElectronico().equals(nuevoEmpleado.getCorreoElectronico()))
                    .findFirst()
                    .orElse(null);
            }
        } else {
            System.out.println("El empleado con el correo " + nuevoDoctor.getCorreoElectronico() + " ya existe.");
        }

        // Validar si el empleado fue correctamente identificado o creado
        if (empleadoExistente != null) {
            // Relacionar el empleado con el nuevo doctor
            nuevoDoctor.setIdEmpleado(empleadoExistente.getIdEmpleado());
            nuevoDoctor.setIdDoctor(empleadoExistente.getIdEmpleado()); // Relación idDoctor = idEmpleado

            if (doctorDAO.agregar(nuevoDoctor)) {
                System.out.println("Nuevo doctor agregado: " + nuevoDoctor.getNombreCompleto());
            } else {
                System.out.println("Error al agregar el nuevo doctor.");
            }
        } else {
            System.out.println("Error crítico: No se pudo identificar al empleado asociado.");
        }

        System.out.println("\n=== Lista de Doctores ===");
        // Obtener y mostrar todos los doctores
        List<Doctor> doctores = doctorDAO.consultar();
        for (Doctor doctor : doctores) {
            System.out.println(doctor);
        }
    }
}
