package modelo;

import java.sql.Date;

public class Doctor extends Empleado {
    private int idDoctor;
    private String cedula;
    private String especialidad;
    private double precioConsulta; // Cambié el tipo de dato a double
    private int numConsultorio; // Cambié el tipo de dato a int

    public Doctor() {
        super();
    }

    public Doctor(int idDoctor, String cedula, String especialidad, double precioConsulta, int numConsultorio, 
                  int idEmpleado, String nombreCompleto, Date fechaIngreso, String correoElectronico, 
                  String numTelefono, String nombreUsuario, String contrasena) {
        super(idEmpleado, nombreCompleto, fechaIngreso, correoElectronico, numTelefono, nombreUsuario, contrasena);
        this.idDoctor = idDoctor;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.precioConsulta = precioConsulta;
        this.numConsultorio = numConsultorio;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
    if (cedula == null || cedula.trim().isEmpty()) {
        throw new IllegalArgumentException("La cédula no puede ser nula o vacía");
    }
    this.cedula = cedula;
}

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getPrecioConsulta() {
        return precioConsulta;
    }

    public void setPrecioConsulta(double precioConsulta) {
    if (precioConsulta < 0) {
        throw new IllegalArgumentException("El precio de consulta no puede ser negativo");
    }
    this.precioConsulta = precioConsulta;
}

    public int getNumConsultorio() {
        return numConsultorio;
    }

    public void setNumConsultorio(int numConsultorio) {
        this.numConsultorio = numConsultorio;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "idDoctor=" + idDoctor +
                ", cedula='" + cedula + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", precioConsulta=" + precioConsulta +
                ", numConsultorio=" + numConsultorio +
                ", idEmpleado=" + getIdEmpleado() +
                ", nombreCompleto='" + getNombreCompleto() + '\'' +
                ", fechaIngreso=" + getFechaIngreso() +
                ", correoElectronico='" + getCorreoElectronico() + '\'' +
                ", numTelefono='" + getNumTelefono() + '\'' +
                ", nombreUsuario='" + getNombreUsuario() + '\'' +
                ", contrasena='" + getContrasena() + '\'' +
                '}';
    }
}