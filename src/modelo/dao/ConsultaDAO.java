package modelo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Consulta;

public class ConsultaDAO {
    private final Connection conexion;

    public ConsultaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean insertar(Consulta consulta) {
        String sql = "INSERT INTO consulta (idCita, motivo, diagnostico) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, consulta.getIdCita());
            ps.setString(2, consulta.getMotivo());
            ps.setString(3, consulta.getDiagnostico());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar consulta: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Consulta consulta) {
        String sql = "UPDATE consulta SET idCita = ?, motivo = ?, diagnostico = ? WHERE idConsulta = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, consulta.getIdCita());
            ps.setString(2, consulta.getMotivo());
            ps.setString(3, consulta.getDiagnostico());
            ps.setInt(4, consulta.getIdConsulta());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar consulta: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int idConsulta) {
        String sql = "DELETE FROM consulta WHERE idConsulta = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idConsulta);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar consulta: " + e.getMessage());
            return false;
        }
    }

    public Consulta obtenerPorId(int idConsulta) {
        String sql = "SELECT * FROM consulta WHERE idConsulta = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idConsulta);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Consulta(
                            rs.getInt("idConsulta"),
                            rs.getInt("idCita"),
                            rs.getString("motivo"),
                            rs.getString("diagnostico")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener consulta: " + e.getMessage());
        }
        return null;
    }

    public List<Consulta> obtenerTodos() {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM consulta";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                consultas.add(new Consulta(
                        rs.getInt("idConsulta"),
                        rs.getInt("idCita"),
                        rs.getString("motivo"),
                        rs.getString("diagnostico")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener todas las consultas: " + e.getMessage());
        }
        return consultas;
    }
}
