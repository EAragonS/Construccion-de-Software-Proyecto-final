package modelo;

import java.sql.Date;

public class Administrador extends Empleado {
    private int idAdministrador;

    public Administrador() {
        super();
    }

    public Administrador(int idAdministrador, int idEmpleado, String nombreCompleto, Date fechaIngreso, 
                         String correoElectronico, String numTelefono, String nombreUsuario, String contrasena) {
        super(idEmpleado, nombreCompleto, fechaIngreso, correoElectronico, numTelefono, nombreUsuario, contrasena);
        this.idAdministrador = idAdministrador;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "idAdministrador=" + idAdministrador +
                ", " + super.toString() +
                '}';
    }
}