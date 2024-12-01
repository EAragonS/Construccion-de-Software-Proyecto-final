package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.ModificarHistorialMedico;

public class ModificarHistorialMedicoController implements ActionListener {
    private ModificarHistorialMedico vista;
    private VentanaManager manager;

    public ModificarHistorialMedicoController(VentanaManager manager) {
        this.manager = manager;
    }

    public void setVista(ModificarHistorialMedico vista) {
        this.vista = vista;
        inicializar();
    }

    private void inicializar() {
        vista.getBtnGuardar().addActionListener(this);
        vista.getBtnCancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == vista.getBtnGuardar()) {
            guardarCambios();
        } else if (evento.getSource() == vista.getBtnCancelar()) {
            manejarCancelar();
        }
    }

    public void guardarCambios() {
        // Implementa la lógica para guardar los cambios aquí
        System.out.println("Guardando cambios...");
        manager.mostrarDoctorVistaPacientes(); // Regresar a la vista anterior
    }

    public void manejarCancelar() {
        // Lógica para cancelar la operación
        System.out.println("Cancelando operación...");
        manager.mostrarDoctorVistaPacientes(); // Regresar a la vista anterior
    }
}

