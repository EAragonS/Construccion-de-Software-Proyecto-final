package modelo;

public class Receta {
    private int idReceta;
    private int idConsulta;
    private String nombreMedicamento;
    private String dosis;
    private String duracionConsumo;

    // Constructor vacío
    public Receta() {
    }

    // Constructor con todos los atributos
    public Receta(int idReceta, int idConsulta, String nombreMedicamento, String dosis, String duracionConsumo) {
        this.idReceta = idReceta;
        this.idConsulta = idConsulta;
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

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
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
        return "Receta{" +
                "idReceta=" + idReceta +
                ", idConsulta=" + idConsulta +
                ", nombreMedicamento='" + nombreMedicamento + '\'' +
                ", dosis='" + dosis + '\'' +
                ", duracionConsumo='" + duracionConsumo + '\'' +
                '}';
    }
}
