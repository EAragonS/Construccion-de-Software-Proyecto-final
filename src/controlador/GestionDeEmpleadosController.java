package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.GestionDeEmpleados;

public class GestionDeEmpleadosController implements ActionListener {
    private GestionDeEmpleados vista;
    private VentanaManager manager;

    public GestionDeEmpleadosController(VentanaManager manager) {
        this.manager = manager;
    }

    public void setVista(GestionDeEmpleados vista) {
        this.vista = vista;
        inicializar();
    }

    private void inicializar() {
        vista.getBtnAgregarEmpleado().addActionListener(this);
        vista.getBtnConsultarInformacion().addActionListener(this);
        vista.getBtnEditarInformacion().addActionListener(this);
    }
    public void mostrarAñadirEmpleado() {
    manager.mostrarAñadirEmpleado();
}

public void mostrarInformacionEmpleado() {
    manager.mostrarInformacionEmpleado();
}

public void mostrarModificarInformacionEmpleado() {
    manager.mostrarModificarInformacionEmpleado();
}


    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == vista.getBtnAgregarEmpleado()) {
            manager.mostrarAñadirEmpleado();
        } else if (evento.getSource() == vista.getBtnConsultarInformacion()) {
            manager.mostrarInformacionEmpleado();
        } else if (evento.getSource() == vista.getBtnEditarInformacion()) {
            manager.mostrarModificarInformacionEmpleado();
        }
    }
}
