package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.ModificarInformacionEmpleado;

public class ModificarInformacionEmpleadoController implements ActionListener {
    private ModificarInformacionEmpleado vista;
    private VentanaManager manager;

    public ModificarInformacionEmpleadoController(VentanaManager manager) {
        this.manager = manager;
    }

    public void setVista(ModificarInformacionEmpleado vista) {
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
