package modelo;

import java.sql.Date;

public class Recepcionista extends Empleado {
    private int idRecepcionista;

    public Recepcionista() {
        super();
    }

    public Recepcionista(int idRecepcionista, int idEmpleado, String nombreCompleto, Date fechaIngreso, 
                         String correoElectronico, String numTelefono, String nombreUsuario, String contrasena) {
        super(idEmpleado, nombreCompleto, fechaIngreso, correoElectronico, numTelefono, nombreUsuario, contrasena);
        this.idRecepcionista = idRecepcionista;
    }

    public int getIdRecepcionista() {
        return idRecepcionista;
    }

    public void setIdRecepcionista(int idRecepcionista) {
        this.idRecepcionista = idRecepcionista;
    }

    @Override
    public String toString() {
        return "Recepcionista{" +
                "idRecepcionista=" + idRecepcionista +
                ", " + super.toString() +
                '}';
    }
}

