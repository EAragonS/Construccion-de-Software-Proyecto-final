package modelo.dao;

import modelo.Cita;
import java.sql.*;
import java.util.List;

public class CitaDAO extends DAO<Cita> {

    @Override
    public boolean agregar(Cita cita) {
        String query = "INSERT INTO cita (idCita, idPaciente, idDoctor, fechaHora, motivoConsulta, estado) VALUES (?, ?, ?, ?, ?, ?)";
        return ejecutarActualizacion(query, 
            cita.getIdCita(), 
            cita.getIdPaciente(), 
            cita.getIdDoctor(), 
            Timestamp.valueOf(cita.getFechaHora()), 
            cita.getMotivoConsulta(), 
            cita.getEstado()
        );
    }

    @Override
    public List<Cita> consultar() {
        String query = "SELECT * FROM cita";
        return ejecutarConsulta(query, rs -> new Cita(
            rs.getInt("idCita"),
            rs.getInt("idPaciente"),
            rs.getInt("idDoctor"),
            rs.getTimestamp("fechaHora").toLocalDateTime(),
            rs.getString("motivoConsulta"),
            rs.getString("estado")
        ));
    }

    @Override
    public boolean modificar(Cita cita) {
        String query = "UPDATE cita SET idPaciente = ?, idDoctor = ?, fechaHora = ?, motivoConsulta = ?, estado = ? WHERE idCita = ?";
        return ejecutarActualizacion(query, 
            cita.getIdPaciente(), 
            cita.getIdDoctor(), 
            Timestamp.valueOf(cita.getFechaHora()), 
            cita.getMotivoConsulta(), 
            cita.getEstado(), 
            cita.getIdCita()
        );
    }

    @Override
    public boolean eliminar(int id) {
        String query = "DELETE FROM cita WHERE idCita = ?";
        return ejecutarActualizacion(query, id);
    }

    // Método adicional para obtener una cita específica por ID
    public Cita obtenerPorId(int id) {
        String query = "SELECT * FROM cita WHERE idCita = ?";
        List<Cita> citas = ejecutarConsulta(query, rs -> new Cita(
            rs.getInt("idCita"),
            rs.getInt("idPaciente"),
            rs.getInt("idDoctor"),
            rs.getTimestamp("fechaHora").toLocalDateTime(),
            rs.getString("motivoConsulta"),
            rs.getString("estado")
        ), id);
        return citas.isEmpty() ? null : citas.get(0);
    }
}