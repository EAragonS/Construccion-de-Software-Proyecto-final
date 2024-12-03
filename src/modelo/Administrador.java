package modelo;

public class Administrador {
    private int idAdministrador;
    private String nombre;

    // Constructor
    public Administrador(int idAdministrador, String nombre) {
        this.idAdministrador = idAdministrador;
        this.nombre = nombre;
    }

    // Getters y setters
    public int getIdAdministrador() {
        return idAdministrador;
    }

   public void setIdAdministrador(int idAdministrador) {
    if (idAdministrador < 0) {
        throw new IllegalArgumentException("idAdministrador no puede ser negativo");
    }
    this.idAdministrador = idAdministrador;
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
    if (nombre == null || nombre.trim().isEmpty()) {
        throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
    }
    this.nombre = nombre;
}

    @Override
    public String toString() {
        return "Administrador{idAdministrador=" + idAdministrador + ", nombre='" + nombre + "'}";
    }
}
