package modelo.dao; 

import modelo.Recepcionista;
import java.sql.*;
import java.util.List;

public class RecepcionistaDAO extends DAO<Recepcionista> {

    public RecepcionistaDAO() {
        super(); // La conexión ya es gestionada por el padre.
    }

    @Override
    public boolean agregar(Recepcionista recepcionista) {
        String sql = "INSERT INTO recepcionista (idRecepcionista) VALUES (?)";
        return ejecutarActualizacion(sql, recepcionista.getIdRecepcionista());
    }

    @Override
    public boolean modificar(Recepcionista recepcionista) {
        String sql = "UPDATE recepcionista SET idRecepcionista = ? WHERE idRecepcionista = ?";
        return ejecutarActualizacion(sql, recepcionista.getIdRecepcionista(), recepcionista.getIdRecepcionista());
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM recepcionista WHERE idRecepcionista = ?";
        return ejecutarActualizacion(sql, id);
    }

    @Override
    public List<Recepcionista> consultar() {
        String sql = "SELECT r.idRecepcionista, e.idEmpleado, e.nombreCompletoE, e.fechaIngreso, e.correoElectronicoE, " +
                     "e.numTelefonoE, e.nombreUsuario, e.contrasena " +
                     "FROM recepcionista r " +
                     "JOIN empleado e ON r.idRecepcionista = e.idEmpleado";
        return ejecutarConsulta(sql, rs -> new Recepcionista(
                rs.getInt("idRecepcionista"),
                rs.getInt("idEmpleado"),
                rs.getString("nombreCompletoE"),
                rs.getDate("fechaIngreso"),
                rs.getString("correoElectronicoE"),
                rs.getString("numTelefonoE"),
                rs.getString("nombreUsuario"),
                rs.getString("contrasena")
        ));
    }

    public Recepcionista obtenerPorId(int idRecepcionista) {
        String sql = "SELECT r.idRecepcionista, e.idEmpleado, e.nombreCompletoE, e.fechaIngreso, e.correoElectronicoE, " +
                     "e.numTelefonoE, e.nombreUsuario, e.contrasena " +
                     "FROM recepcionista r " +
                     "JOIN empleado e ON r.idRecepcionista = e.idEmpleado " +
                     "WHERE r.idRecepcionista = ?";
        List<Recepcionista> resultados = ejecutarConsulta(sql, rs -> new Recepcionista(
                rs.getInt("idRecepcionista"),
                rs.getInt("idEmpleado"),
                rs.getString("nombreCompletoE"),
                rs.getDate("fechaIngreso"),
                rs.getString("correoElectronicoE"),
                rs.getString("numTelefonoE"),
                rs.getString("nombreUsuario"),
                rs.getString("contrasena")
        ), idRecepcionista);
        return resultados.isEmpty() ? null : resultados.get(0);
    }
}
