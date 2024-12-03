package modelo;

import java.time.LocalDateTime;

public class Cita {
    private int idCita;
    private int idPaciente;
    private int idDoctor;
    private LocalDateTime fechaHora;
    private String motivoConsulta;
    private String estado;

    public Cita() {}

    public Cita(int idCita, int idPaciente, int idDoctor, LocalDateTime fechaHora, String motivoConsulta, String estado) {
        this.idCita = idCita;
        this.idPaciente = idPaciente;
        this.idDoctor = idDoctor;
        this.fechaHora = fechaHora;
        this.motivoConsulta = motivoConsulta;
        this.estado = estado;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
    if (idCita < 0) {
        throw new IllegalArgumentException("idCita no puede ser negativo");
    }
    this.idCita = idCita;
}

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
    if (motivoConsulta == null || motivoConsulta.trim().isEmpty()) {
        throw new IllegalArgumentException("El motivo de consulta no puede ser nulo o vacío");
    }
    this.motivoConsulta = motivoConsulta;
}

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
    if (estado == null || estado.trim().isEmpty()) {
        throw new IllegalArgumentException("El estado no puede ser nulo o vacío");
    }
    this.estado = estado;
}

    @Override
    public String toString() {
        return "Cita{" +
                "idCita=" + idCita +
                ", idPaciente=" + idPaciente +
                ", idDoctor=" + idDoctor +
                ", fechaHora=" + fechaHora +
                ", motivoConsulta='" + motivoConsulta + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
