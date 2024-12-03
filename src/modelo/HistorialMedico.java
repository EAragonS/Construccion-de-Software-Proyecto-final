package modelo;

public class HistorialMedico {
    private int idHistorial;
    private int idPaciente;
    private String enfermedadesPrevias;
    private String alergias;
    private String historialFamiliar;
    private String condicionesCronicas;
    private String medicacionActual;

    public HistorialMedico() {
    }

    public HistorialMedico(int idHistorial, int idPaciente, String enfermedadesPrevias, String alergias, 
                           String historialFamiliar, String condicionesCronicas, String medicacionActual) {
        this.idHistorial = idHistorial;
        this.idPaciente = idPaciente;
        this.enfermedadesPrevias = enfermedadesPrevias;
        this.alergias = alergias;
        this.historialFamiliar = historialFamiliar;
        this.condicionesCronicas = condicionesCronicas;
        this.medicacionActual = medicacionActual;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
    if (idHistorial < 0) {
        throw new IllegalArgumentException("El idHistorial no puede ser negativo");
    }
    this.idHistorial = idHistorial;
}
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getEnfermedadesPrevias() {
        return enfermedadesPrevias;
    }

    public void setEnfermedadesPrevias(String enfermedadesPrevias) {
    if (enfermedadesPrevias == null || enfermedadesPrevias.trim().isEmpty()) {
        throw new IllegalArgumentException("Las enfermedades previas no pueden ser nulas o vacías");
    }
    this.enfermedadesPrevias = enfermedadesPrevias;
}

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getHistorialFamiliar() {
        return historialFamiliar;
    }

    public void setHistorialFamiliar(String historialFamiliar) {
        this.historialFamiliar = historialFamiliar;
    }

    public String getCondicionesCronicas() {
        return condicionesCronicas;
    }

    public void setCondicionesCronicas(String condicionesCronicas) {
        this.condicionesCronicas = condicionesCronicas;
    }

    public String getMedicacionActual() {
        return medicacionActual;
    }

    public void setMedicacionActual(String medicacionActual) {
        this.medicacionActual = medicacionActual;
    }

    @Override
    public String toString() {
        return "HistorialMedico{" +
                "idHistorial=" + idHistorial +
                ", idPaciente=" + idPaciente +
                ", enfermedadesPrevias='" + enfermedadesPrevias + '\'' +
                ", alergias='" + alergias + '\'' +
                ", historialFamiliar='" + historialFamiliar + '\'' +
                ", condicionesCronicas='" + condicionesCronicas + '\'' +
                ", medicacionActual='" + medicacionActual + '\'' +
                '}';
    }
}
