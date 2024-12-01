package modelo;

import java.sql.Date;

public class Empleado {
    private int idEmpleado;
    private String nombreCompleto;
    private Date fechaIngreso;
    private String correoElectronico;
    private String numTelefono;
    private String nombreUsuario;
    private String contrasena;

    // Constructor vacío
    public Empleado() {
    }

    // Constructor con todos los atributos
    public Empleado(int idEmpleado, String nombreCompleto, Date fechaIngreso, String correoElectronico, 
                    String numTelefono, String nombreUsuario, String contrasena) {
        this.idEmpleado = idEmpleado;
        this.nombreCompleto = nombreCompleto;
        this.fechaIngreso = fechaIngreso;
        this.correoElectronico = correoElectronico;
        this.numTelefono = numTelefono;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", numTelefono='" + numTelefono + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
