package controlador;

import java.awt.event.ActionEvent;
import vistas.AgendaRecepcionista;

public class AgendaRecepcionistaController {
    private AgendaRecepcionista vista;
    private VentanaManager manager;

    public AgendaRecepcionistaController(VentanaManager manager) {
        this.manager = manager;
    }

    public void setVista(AgendaRecepcionista vista) {
        this.vista = vista;
        inicializar();
    }

    private void inicializar() {
        // Aquí se puede inicializar algo adicional si es necesario
    }

    // Métodos que serán llamados desde los ActionPerformed de la vista
    public void manejarSalir() {
        System.exit(0);
    }

    public void manejarCerrarSesion() {
        // Implementar lógica de cerrar sesión si es necesario
        System.out.println("Cerrar sesión no implementado todavía.");
    }

    public void manejarIniciarConsulta() {
        // Cambiar a la vista de DoctorVistaPacientes
        manager.mostrarDoctorVistaPacientes();
    }

}