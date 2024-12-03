package controlador;

import modelo.dao.EmpleadoDAO;
import modelo.dao.DoctorDAO;
import modelo.dao.RecepcionistaDAO;
import modelo.dao.AdministradorDAO;
import modelo.Empleado;
import vistas.Login;

import java.util.Optional;

public class LoginController {
    private Login vista;
    private VentanaManager manager;

    private EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    private DoctorDAO doctorDAO = new DoctorDAO();
    private RecepcionistaDAO recepcionistaDAO = new RecepcionistaDAO();
    private AdministradorDAO administradorDAO = new AdministradorDAO();

    public LoginController(VentanaManager manager) {
        this.manager = manager;
    }

    public void setVista(Login vista) {
        this.vista = vista;
    }

    public void manejarEntrar() {
        // Obtener las credenciales desde la vista directamente
        String nombreUsuario = vista.getCampoUsuario();
        String contrasena = vista.getCampoContraseña();

        // Buscar al empleado con las credenciales
        Optional<Empleado> empleadoOpt = empleadoDAO.consultar().stream()
                .filter(e -> e.getNombreUsuario().equals(nombreUsuario) && e.getContrasena().equals(contrasena))
                .findFirst();

        if (empleadoOpt.isPresent()) {
            Empleado empleado = empleadoOpt.get();
            identificarTipoEmpleado(empleado);
        } else {
            manager.mostrarMensajeLogin("Credenciales incorrectas.");
        }
    }

    private void identificarTipoEmpleado(Empleado empleado) {
        // Verificar si es doctor
        boolean esDoctor = doctorDAO.consultar().stream()
                .anyMatch(d -> d.getIdEmpleado() == empleado.getIdEmpleado());

        if (esDoctor) {
            manager.mostrarDoctorVistaConsultas();
            return;
        }

        // Verificar si es recepcionista
        boolean esRecepcionista = recepcionistaDAO.consultar().stream()
                .anyMatch(r -> r.getIdRecepcionista() == empleado.getIdEmpleado());

        if (esRecepcionista) {
            manager.MostrarAgendaRecepcionista();
            return;
        }

        // Verificar si es administrador
        boolean esAdministrador = administradorDAO.consultar().stream()
                .anyMatch(a -> a.getIdAdministrador() == empleado.getIdEmpleado());

        if (esAdministrador) {
            manager.mostrarGestionDeEmpleados();
            return;
        }

        manager.mostrarMensajeLogin("Tipo de empleado no detectado.");
    }

    public void manejarSalir() {
        System.exit(0);
    }
}