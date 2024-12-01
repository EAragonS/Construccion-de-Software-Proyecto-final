package dao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import modelo.Cita;

public class CitaDAO {

    private Connection conexion;

    public CitaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void agregarCita(Cita cita) throws SQLException {
        String query = "INSERT INTO cita (idCita, idPaciente, idDoctor, fechaHora, motivoConsulta, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, cita.getIdCita());
            statement.setInt(2, cita.getIdPaciente());
            statement.setInt(3, cita.getIdDoctor());
            statement.setTimestamp(4, Timestamp.valueOf(cita.getFechaHora()));
            statement.setString(5, cita.getMotivoConsulta());
            statement.setString(6, cita.getEstado());
            statement.executeUpdate();
        }
    }

    public Cita obtenerCitaPorId(int id) throws SQLException {
        String query = "SELECT * FROM cita WHERE idCita = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Cita(
                        resultSet.getInt("idCita"),
                        resultSet.getInt("idPaciente"),
                        resultSet.getInt("idDoctor"),
                        resultSet.getTimestamp("fechaHora").toLocalDateTime(),
                        resultSet.getString("motivoConsulta"),
                        resultSet.getString("estado")
                    );
                }
            }
        }
        return null;
    }

    public List<Cita> obtenerTodasLasCitas() throws SQLException {
        List<Cita> citas = new ArrayList<>();
        String query = "SELECT * FROM cita";
        try (PreparedStatement statement = conexion.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                citas.add(new Cita(
                    resultSet.getInt("idCita"),
                    resultSet.getInt("idPaciente"),
                    resultSet.getInt("idDoctor"),
                    resultSet.getTimestamp("fechaHora").toLocalDateTime(),
                    resultSet.getString("motivoConsulta"),
                    resultSet.getString("estado")
                ));
            }
        }
        return citas;
    }

    public void actualizarCita(Cita cita) throws SQLException {
        String query = "UPDATE cita SET idPaciente = ?, idDoctor = ?, fechaHora = ?, motivoConsulta = ?, estado = ? WHERE idCita = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, cita.getIdPaciente());
            statement.setInt(2, cita.getIdDoctor());
            statement.setTimestamp(3, Timestamp.valueOf(cita.getFechaHora()));
            statement.setString(4, cita.getMotivoConsulta());
            statement.setString(5, cita.getEstado());
            statement.setInt(6, cita.getIdCita());
            statement.executeUpdate();
        }
    }

    public void eliminarCita(int id) throws SQLException {
        String query = "DELETE FROM cita WHERE idCita = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
