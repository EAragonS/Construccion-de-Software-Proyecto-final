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
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
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
