package controlador;

import vistas.*;

public class VentanaManager {
    // Ventanas principales
    private Login login;
    private GestionDeEmpleados gestionDeEmpleados;
    private DoctorVistaConsultas doctorVistaConsultas;

    // Vistas secundarias de GestionDeEmpleados
    private AñadirEmpleado añadirEmpleado;
    private ModificarInformacionEmpleado modificarInformacionEmpleado;
    private InformacionEmpleado informacionEmpleado;

    // Vistas secundarias de DoctorVistaConsultas
    private DoctorVistaPacientes doctorVistaPacientes;
    private ConsultarHistorialMedico consultarHistorialMedico;
    private ModificarHistorialMedico modificarHistorialMedico; // Nueva vista

    // Controladores
    private LoginController loginController;
    private GestionDeEmpleadosController gestionDeEmpleadosController;
    private DoctorVistaConsultasController doctorVistaConsultasController;

    private AñadirEmpleadoController añadirEmpleadoController;
    private ModificarInformacionEmpleadoController modificarInformacionEmpleadoController;
    private InformacionEmpleadoController informacionEmpleadoController;

    private DoctorVistaPacientesController doctorVistaPacientesController;
    private ConsultarHistorialMedicoController consultarHistorialMedicoController;
    private ModificarHistorialMedicoController modificarHistorialMedicoController;

    public VentanaManager() {
        // Crear controladores
        loginController = new LoginController(this);
        gestionDeEmpleadosController = new GestionDeEmpleadosController(this);
        doctorVistaConsultasController = new DoctorVistaConsultasController(this);

        añadirEmpleadoController = new AñadirEmpleadoController(this);
        modificarInformacionEmpleadoController = new ModificarInformacionEmpleadoController(this);
        informacionEmpleadoController = new InformacionEmpleadoController(this);

        doctorVistaPacientesController = new DoctorVistaPacientesController(this);
        consultarHistorialMedicoController = new ConsultarHistorialMedicoController(this);
        modificarHistorialMedicoController = new ModificarHistorialMedicoController(this);

        // Inicializar vistas principales
        login = new Login(loginController);
        loginController.setVista(login);

        gestionDeEmpleados = new GestionDeEmpleados(gestionDeEmpleadosController);
        gestionDeEmpleadosController.setVista(gestionDeEmpleados);

        doctorVistaConsultas = new DoctorVistaConsultas(doctorVistaConsultasController);
        doctorVistaConsultasController.setVista(doctorVistaConsultas);

        // Inicializar vistas secundarias de GestionDeEmpleados
        añadirEmpleado = new AñadirEmpleado(añadirEmpleadoController);
        añadirEmpleadoController.setVista(añadirEmpleado);

        modificarHistorialMedico = new ModificarHistorialMedico(modificarHistorialMedicoController);
        modificarHistorialMedicoController.setVista(modificarHistorialMedico);

        informacionEmpleado = new InformacionEmpleado(informacionEmpleadoController);
        informacionEmpleadoController.setVista(informacionEmpleado);

        // Inicializar vistas secundarias de DoctorVistaConsultas
        doctorVistaPacientes = new DoctorVistaPacientes(doctorVistaPacientesController);
        doctorVistaPacientesController.setVista(doctorVistaPacientes);

        consultarHistorialMedico = new ConsultarHistorialMedico(consultarHistorialMedicoController);
        consultarHistorialMedicoController.setVista(consultarHistorialMedico);

        modificarHistorialMedico = new ModificarHistorialMedico(modificarHistorialMedicoController);
        modificarHistorialMedicoController.setVista(modificarHistorialMedico);

        // Ocultar todas las ventanas al inicio
        ocultarTodasLasVistas();

        // Iniciar en Login
        mostrarLogin();
    }

    // Métodos para manejar las ventanas principales
    public void mostrarLogin() {
        ocultarTodasLasVistas();
        login.setVisible(true);
    }

    public void mostrarGestionDeEmpleados() {
        ocultarTodasLasVistas();
        gestionDeEmpleados.setVisible(true);
    }

    public void mostrarDoctorVistaConsultas() {
        ocultarTodasLasVistas();
        doctorVistaConsultas.setVisible(true);
    }

    // Métodos para manejar las vistas secundarias
    public void mostrarAñadirEmpleado() {
        ocultarTodasLasVistas();
        añadirEmpleado.setVisible(true);
    }

    public void mostrarModificarInformacionEmpleado() {
        ocultarTodasLasVistas();
        modificarInformacionEmpleado.setVisible(true);
    }

    public void mostrarInformacionEmpleado() {
        ocultarTodasLasVistas();
        informacionEmpleado.setVisible(true);
    }

    public void mostrarDoctorVistaPacientes() {
        ocultarTodasLasVistas();
        doctorVistaPacientes.setVisible(true);
    }

    public void mostrarConsultarHistorialMedico() {
    ocultarTodasLasVistas();
    System.out.println("Mostrando ConsultarHistorialMedico...");
    consultarHistorialMedico.setVisible(true);
}

    public void mostrarModificarHistorialMedico() {
    System.out.println("Ocultando otras vistas...");
    ocultarTodasLasVistas();
    System.out.println("Mostrando ModificarHistorialMedico...");
    modificarHistorialMedico.setVisible(true); // Asegúrate de que este componente está bien inicializado.
}



    // Ocultar todas las ventanas
   private void ocultarTodasLasVistas() {
    System.out.println("Ocultando vistas...");
    if (login != null && login.isVisible()) {
        System.out.println("Ocultando Login...");
        login.setVisible(false);
    }
    if (gestionDeEmpleados != null && gestionDeEmpleados.isVisible()) {
        System.out.println("Ocultando GestionDeEmpleados...");
        gestionDeEmpleados.setVisible(false);
    }
    if (doctorVistaConsultas != null && doctorVistaConsultas.isVisible()) {
        System.out.println("Ocultando DoctorVistaConsultas...");
        doctorVistaConsultas.setVisible(false);
    }
    if (doctorVistaPacientes != null && doctorVistaPacientes.isVisible()) {
        System.out.println("Ocultando DoctorVistaPacientes...");
        doctorVistaPacientes.setVisible(false);
    }
    if (modificarHistorialMedico != null && modificarHistorialMedico.isVisible()) {
        System.out.println("Ocultando ModificarHistorialMedico...");
        modificarHistorialMedico.setVisible(false);
    }
}


}
