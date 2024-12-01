package modelo;

public class Consulta {
    private int idConsulta;
    private int idCita;
    private String motivo;
    private String diagnostico;

    public Consulta() {
    }

    public Consulta(int idConsulta, int idCita, String motivo, String diagnostico) {
        this.idConsulta = idConsulta;
        this.idCita = idCita;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "idConsulta=" + idConsulta +
                ", idCita=" + idCita +
                ", motivo='" + motivo + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                '}';
    }
}
