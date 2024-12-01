package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.AñadirEmpleado;

public class AñadirEmpleadoController implements ActionListener {
    private AñadirEmpleado vista;
    private VentanaManager manager;

    public AñadirEmpleadoController(VentanaManager manager) {
        this.manager = manager;
    }

    public void setVista(AñadirEmpleado vista) {
        this.vista = vista;
        inicializar();
    }

    private void inicializar() {
        vista.getBtnCancelar().addActionListener(this);
        vista.getBtnGuardar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (vista.getBtnCancelar() == evento.getSource()) {
            manager.mostrarGestionDeEmpleados();
        }
        // Agrega más lógica aquí para otros eventos
    }
}
