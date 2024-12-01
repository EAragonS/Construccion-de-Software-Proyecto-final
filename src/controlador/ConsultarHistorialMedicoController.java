package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.ConsultarHistorialMedico;

public class ConsultarHistorialMedicoController implements ActionListener {
    private ConsultarHistorialMedico vista;
    private VentanaManager manager;

    public ConsultarHistorialMedicoController(VentanaManager manager) {
        this.manager = manager;
    }

    public void setVista(ConsultarHistorialMedico vista) {
        this.vista = vista;
        inicializar();
    }

    private void inicializar() {
        // Vincular el botón "Cancelar" de la vista al controlador
        vista.getBtnCancelar().addActionListener(this); // Botón para cancelar y volver a la vista anterior
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == vista.getBtnCancelar()) {
            manejarVolver();
        }
    }

    // Método para manejar el botón "Cancelar"
    public void manejarVolver() {
        // Volver a la vista de pacientes
        manager.mostrarDoctorVistaPacientes();
    }
}
