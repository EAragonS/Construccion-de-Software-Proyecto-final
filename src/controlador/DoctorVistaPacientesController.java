package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.DoctorVistaPacientes;

public class DoctorVistaPacientesController implements ActionListener {
    private DoctorVistaPacientes vista;
    private VentanaManager manager;

    public DoctorVistaPacientesController(VentanaManager manager) {
        this.manager = manager;
    }

    public void setVista(DoctorVistaPacientes vista) {
        this.vista = vista;
        inicializar();
    }

    private void inicializar() {
    vista.getBtnSalir().removeActionListener(this);
    vista.getBtnCerrarSesion().removeActionListener(this);
    vista.getBtnConsultarHistorial().removeActionListener(this);
    vista.getBtnEditarHistorial().removeActionListener(this);

    vista.getBtnSalir().addActionListener(this);
    vista.getBtnCerrarSesion().addActionListener(this);
    vista.getBtnConsultarHistorial().addActionListener(this);
    vista.getBtnEditarHistorial().addActionListener(this);
}

   @Override
public void actionPerformed(ActionEvent evento) {
    if (evento.getSource() == vista.getBtnSalir()) {
        System.out.println("Botón Salir presionado.");
        System.exit(0); // Cierra la aplicación
    } else if (evento.getSource() == vista.getBtnCerrarSesion()) {
        System.out.println("Botón Cerrar Sesión presionado.");
        manager.mostrarDoctorVistaConsultas(); // Vuelve a la vista de consultas
    } else if (evento.getSource() == vista.getBtnConsultarHistorial()) {
        System.out.println("Botón Consultar Historial presionado.");
        manejarConsultarHistorial();
    } else if (evento.getSource() == vista.getBtnEditarHistorial()) {
        System.out.println("Botón Editar Historial presionado.");
        manejarEditarHistorial();
    }
}


    // Métodos específicos para manejar acciones
    public void manejarConsultarHistorial() {
        // Abrir la vista de ConsultarHistorialMedico
        manager.mostrarConsultarHistorialMedico();
    }

   public void manejarEditarHistorial() {
    System.out.println("Botón Editar Historial presionado...");
    manager.mostrarModificarHistorialMedico();
}

}
