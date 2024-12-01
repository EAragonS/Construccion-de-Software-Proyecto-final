package controlador;

import vistas.Login;

public class LoginController {
    private Login vista;
    private VentanaManager manager;

    public LoginController(VentanaManager manager) {
        this.manager = manager;
    }

    public void setVista(Login vista) {
        this.vista = vista;
    }

    public void manejarEntrar() {
        // Lógica de autenticación (opcional)
        // Si la autenticación es exitosa, muestra la ventana de gestión de empleados.
        manager.mostrarGestionDeEmpleados();
    }

    public void manejarSalir() {
        // Lógica para cerrar la aplicación
        System.exit(0);
    }
}
