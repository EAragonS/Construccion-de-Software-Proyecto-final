package modelo.dao;

import modelo.HistorialMedico;
import java.util.List;

public class HistorialMedicoDAO extends DAO<HistorialMedico> {

    @Override
    public boolean agregar(HistorialMedico historial) {
        String sql = "INSERT INTO historialMedico (idPaciente, enfermedadesPrevias, alergias, historialFamiliar, condicionesCronicas, medicacionActual) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        return ejecutarActualizacion(sql,
            historial.getIdPaciente(),
            historial.getEnfermedadesPrevias(),
            historial.getAlergias(),
            historial.getHistorialFamiliar(),
            historial.getCondicionesCronicas(),
            historial.getMedicacionActual()
        );
    }

    @Override
    public boolean modificar(HistorialMedico historial) {
        String sql = "UPDATE historialMedico SET idPaciente = ?, enfermedadesPrevias = ?, alergias = ?, historialFamiliar = ?, condicionesCronicas = ?, medicacionActual = ? " +
                     "WHERE idHistorial = ?";
        return ejecutarActualizacion(sql,
            historial.getIdPaciente(),
            historial.getEnfermedadesPrevias(),
            historial.getAlergias(),
            historial.getHistorialFamiliar(),
            historial.getCondicionesCronicas(),
            historial.getMedicacionActual(),
            historial.getIdHistorial()
        );
    }

    @Override
    public boolean eliminar(int idHistorial) {
        String sql = "DELETE FROM historialMedico WHERE idHistorial = ?";
        return ejecutarActualizacion(sql, idHistorial);
    }

    @Override
    public List<HistorialMedico> consultar() {
        String sql = "SELECT * FROM historialMedico";
        return ejecutarConsulta(sql, rs -> new HistorialMedico(
            rs.getInt("idHistorial"),
            rs.getInt("idPaciente"),
            rs.getString("enfermedadesPrevias"),
            rs.getString("alergias"),
            rs.getString("historialFamiliar"),
            rs.getString("condicionesCronicas"),
            rs.getString("medicacionActual")
        ));
    }

    // Método adicional para obtener un historial médico específico por ID
    public HistorialMedico obtenerPorId(int idHistorial) {
        String sql = "SELECT * FROM historialMedico WHERE idHistorial = ?";
        List<HistorialMedico> historiales = ejecutarConsulta(sql, rs -> new HistorialMedico(
            rs.getInt("idHistorial"),
            rs.getInt("idPaciente"),
            rs.getString("enfermedadesPrevias"),
            rs.getString("alergias"),
            rs.getString("historialFamiliar"),
            rs.getString("condicionesCronicas"),
            rs.getString("medicacionActual")
        ), idHistorial);
        return historiales.isEmpty() ? null : historiales.get(0);
    }
}
