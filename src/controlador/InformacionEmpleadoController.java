package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.InformacionEmpleado;

public class InformacionEmpleadoController implements ActionListener {
    private InformacionEmpleado vista;
    private VentanaManager manager;

    public InformacionEmpleadoController(VentanaManager manager) {
        this.manager = manager;
    }

    public void setVista(InformacionEmpleado vista) {
        this.vista = vista;
        inicializar();
    }

    private void inicializar() {
        vista.getBtnCancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (vista.getBtnCancelar() == evento.getSource()) {
    manager.mostrarGestionDeEmpleados();
        }

    }
}
