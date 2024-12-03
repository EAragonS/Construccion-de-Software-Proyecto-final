package modelo;

public class MedicamentoPrescrito {

    private int idReceta;
    private int idMedicamento;
    private String nombreMedicamento;
    private String dosis;
    private String duracionConsumo;

    // Constructor vacío
    public MedicamentoPrescrito() {
    }

    // Constructor completo
    public MedicamentoPrescrito(int idReceta, int idMedicamento, String nombreMedicamento, String dosis, String duracionConsumo) {
        this.idReceta = idReceta;
        this.idMedicamento = idMedicamento;
        this.nombreMedicamento = nombreMedicamento;
        this.dosis = dosis;
        this.duracionConsumo = duracionConsumo;
    }

    // Getters y Setters
    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
    if (idReceta < 0) {
        throw new IllegalArgumentException("El idReceta no puede ser negativo");
    }
    this.idReceta = idReceta;
}

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
    if (nombreMedicamento == null || nombreMedicamento.trim().isEmpty()) {
        throw new IllegalArgumentException("El nombre del medicamento no puede ser nulo o vacío");
    }
    this.nombreMedicamento = nombreMedicamento;
}

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
    if (dosis == null || dosis.trim().isEmpty()) {
        throw new IllegalArgumentException("La dosis no puede ser nula o vacía");
    }
    this.dosis = dosis;
}

    public String getDuracionConsumo() {
        return duracionConsumo;
    }

    public void setDuracionConsumo(String duracionConsumo) {
        this.duracionConsumo = duracionConsumo;
    }

    @Override
    public String toString() {
        return "MedicamentoPrescrito{" +
                "idReceta=" + idReceta +
                ", idMedicamento=" + idMedicamento +
                ", nombreMedicamento='" + nombreMedicamento + '\'' +
                ", dosis='" + dosis + '\'' +
                ", duracionConsumo='" + duracionConsumo + '\'' +
                '}';
    }
}
