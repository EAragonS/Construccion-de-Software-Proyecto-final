package modelo.dao; 

import modelo.Administrador;
import java.util.List;

public class AdministradorDAO extends DAO<Administrador> {

    public AdministradorDAO() {
        super(); // La conexión ya es gestionada por el padre.
    }

    @Override
    public boolean agregar(Administrador entidad) {
        // Implementar lógica para agregar un administrador
        String sql = "INSERT INTO administrador (idAdministrador, nombre) VALUES (?, ?)";
        return ejecutarActualizacion(sql, entidad.getIdAdministrador(), entidad.getNombre());
    }

    @Override
    public List<Administrador> consultar() {
        // Implementar lógica para obtener todos los administradores
        String sql = "SELECT idAdministrador, nombre FROM administrador";
        return ejecutarConsulta(sql, rs -> new Administrador(
            rs.getInt("idAdministrador"),
            rs.getString("nombre")
        ));
    }

    @Override
    public boolean modificar(Administrador entidad) {
        // Implementar lógica para modificar un administrador
        String sql = "UPDATE administrador SET nombre = ? WHERE idAdministrador = ?";
        return ejecutarActualizacion(sql, entidad.getNombre(), entidad.getIdAdministrador());
    }

    @Override
    public boolean eliminar(int id) {
        // Implementar lógica para eliminar un administrador
        String sql = "DELETE FROM administrador WHERE idAdministrador = ?";
        return ejecutarActualizacion(sql, id);
    }
}