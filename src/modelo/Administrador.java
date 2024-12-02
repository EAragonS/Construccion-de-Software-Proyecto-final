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
        this.idAdministrador = idAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Administrador{idAdministrador=" + idAdministrador + ", nombre='" + nombre + "'}";
    }
}
