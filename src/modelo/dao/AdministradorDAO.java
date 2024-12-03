package modelo.dao;

import modelo.Administrador;
import java.sql.*;
import java.util.List;

public class AdministradorDAO extends DAO<Administrador> {

    public AdministradorDAO() {
        super(); // La conexión ya es gestionada por el padre.
    }

    @Override
    public boolean agregar(Administrador administrador) {
        String sql = "INSERT INTO administrador (idAdministrador) VALUES (?)";
        return ejecutarActualizacion(sql, administrador.getIdAdministrador());
    }

    @Override
    public boolean modificar(Administrador administrador) {
        String sql = "UPDATE administrador SET idAdministrador = ? WHERE idAdministrador = ?";
        return ejecutarActualizacion(sql, administrador.getIdAdministrador(), administrador.getIdAdministrador());
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM administrador WHERE idAdministrador = ?";
        return ejecutarActualizacion(sql, id);
    }

    @Override
    public List<Administrador> consultar() {
        String sql = "SELECT a.idAdministrador, e.idEmpleado, e.nombreCompletoE, e.fechaIngreso, e.correoElectronicoE, " +
                     "e.numTelefonoE, e.nombreUsuario, e.contrasena " +
                     "FROM administrador a " +
                     "JOIN empleado e ON a.idAdministrador = e.idEmpleado";
        return ejecutarConsulta(sql, rs -> new Administrador(
                rs.getInt("idAdministrador"),
                rs.getInt("idEmpleado"),
                rs.getString("nombreCompletoE"),
                rs.getDate("fechaIngreso"),
                rs.getString("correoElectronicoE"),
                rs.getString("numTelefonoE"),
                rs.getString("nombreUsuario"),
                rs.getString("contrasena")
        ));
    }

    public Administrador obtenerPorId(int idAdministrador) {
        String sql = "SELECT a.idAdministrador, e.idEmpleado, e.nombreCompletoE, e.fechaIngreso, e.correoElectronicoE, " +
                     "e.numTelefonoE, e.nombreUsuario, e.contrasena " +
                     "FROM administrador a " +
                     "JOIN empleado e ON a.idAdministrador = e.idEmpleado " +
                     "WHERE a.idAdministrador = ?";
        List<Administrador> resultados = ejecutarConsulta(sql, rs -> new Administrador(
                rs.getInt("idAdministrador"),
                rs.getInt("idEmpleado"),
                rs.getString("nombreCompletoE"),
                rs.getDate("fechaIngreso"),
                rs.getString("correoElectronicoE"),
                rs.getString("numTelefonoE"),
                rs.getString("nombreUsuario"),
                rs.getString("contrasena")
        ), idAdministrador);
        return resultados.isEmpty() ? null : resultados.get(0);
    }
}
