package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.HistorialMedico;

public class HistorialMedicoDAO {
    private final Connection conexion;

    public HistorialMedicoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean insertar(HistorialMedico historial) {
        String sql = "INSERT INTO historialMedico (idPaciente, enfermedadesPrevias, alergias, historialFamiliar, condicionesCronicas, medicacionActual) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, historial.getIdPaciente());
            ps.setString(2, historial.getEnfermedadesPrevias());
            ps.setString(3, historial.getAlergias());
            ps.setString(4, historial.getHistorialFamiliar());
            ps.setString(5, historial.getCondicionesCronicas());
            ps.setString(6, historial.getMedicacionActual());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar historial médico: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(HistorialMedico historial) {
        String sql = "UPDATE historialMedico SET idPaciente = ?, enfermedadesPrevias = ?, alergias = ?, historialFamiliar = ?, condicionesCronicas = ?, medicacionActual = ? " +
                     "WHERE idHistorial = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, historial.getIdPaciente());
            ps.setString(2, historial.getEnfermedadesPrevias());
            ps.setString(3, historial.getAlergias());
            ps.setString(4, historial.getHistorialFamiliar());
            ps.setString(5, historial.getCondicionesCronicas());
            ps.setString(6, historial.getMedicacionActual());
            ps.setInt(7, historial.getIdHistorial());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar historial médico: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int idHistorial) {
        String sql = "DELETE FROM historialMedico WHERE idHistorial = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idHistorial);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar historial médico: " + e.getMessage());
            return false;
        }
    }

    public HistorialMedico obtenerPorId(int idHistorial) {
        String sql = "SELECT * FROM historialMedico WHERE idHistorial = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idHistorial);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new HistorialMedico(
                            rs.getInt("idHistorial"),
                            rs.getInt("idPaciente"),
                            rs.getString("enfermedadesPrevias"),
                            rs.getString("alergias"),
                            rs.getString("historialFamiliar"),
                            rs.getString("condicionesCronicas"),
                            rs.getString("medicacionActual")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener historial médico: " + e.getMessage());
        }
        return null;
    }

    public List<HistorialMedico> obtenerTodos() {
        List<HistorialMedico> historiales = new ArrayList<>();
        String sql = "SELECT * FROM historialMedico";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                historiales.add(new HistorialMedico(
                        rs.getInt("idHistorial"),
                        rs.getInt("idPaciente"),
                        rs.getString("enfermedadesPrevias"),
                        rs.getString("alergias"),
                        rs.getString("historialFamiliar"),
                        rs.getString("condicionesCronicas"),
                        rs.getString("medicacionActual")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener todos los historiales médicos: " + e.getMessage());
        }
        return historiales;
    }
}
