package modelo;

import java.util.Date;

public class Paciente {
    private int idPaciente;
    private String nombreCompletoP;
    private String sexo; // Masculino o Femenino
    private Date fechaNacimiento;
    private String correoElectronicoP;
    private String numeroTelefonoP;
    private String nombreContactoEmergencia;
    private String numTelefonoContactoEmergencia;

    // Constructor vacío
    public Paciente() {}

    // Constructor con todos los atributos
    public Paciente(int idPaciente, String nombreCompletoP, String sexo, Date fechaNacimiento, 
                    String correoElectronicoP, String numeroTelefonoP, 
                    String nombreContactoEmergencia, String numTelefonoContactoEmergencia) {
        this.idPaciente = idPaciente;
        this.nombreCompletoP = nombreCompletoP;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronicoP = correoElectronicoP;
        this.numeroTelefonoP = numeroTelefonoP;
        this.nombreContactoEmergencia = nombreContactoEmergencia;
        this.numTelefonoContactoEmergencia = numTelefonoContactoEmergencia;
    }

    // Getters y Setters
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombreCompletoP() {
        return nombreCompletoP;
    }

    public void setNombreCompletoP(String nombreCompletoP) {
        this.nombreCompletoP = nombreCompletoP;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronicoP() {
        return correoElectronicoP;
    }

    public void setCorreoElectronicoP(String correoElectronicoP) {
        this.correoElectronicoP = correoElectronicoP;
    }

    public String getNumeroTelefonoP() {
        return numeroTelefonoP;
    }

    public void setNumeroTelefonoP(String numeroTelefonoP) {
        this.numeroTelefonoP = numeroTelefonoP;
    }

    public String getNombreContactoEmergencia() {
        return nombreContactoEmergencia;
    }

    public void setNombreContactoEmergencia(String nombreContactoEmergencia) {
        this.nombreContactoEmergencia = nombreContactoEmergencia;
    }

    public String getNumTelefonoContactoEmergencia() {
        return numTelefonoContactoEmergencia;
    }

    public void setNumTelefonoContactoEmergencia(String numTelefonoContactoEmergencia) {
        this.numTelefonoContactoEmergencia = numTelefonoContactoEmergencia;
    }
}
