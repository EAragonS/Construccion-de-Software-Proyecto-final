package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.ReciboConsulta;

public class ReciboConsultaDAO {

    private Connection conexion;

    public ReciboConsultaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Create: Insertar un nuevo recibo de consulta
    public boolean insertarReciboConsulta(int idConsulta, Date fechaGeneracion, Time horaGeneracion, 
                                          double montoPagado, double montoCambio) {
        String query = "INSERT INTO reciboConsulta (idConsulta, fechaGeneracion, horaGeneracion, montoPagado, montoCambio) " +
                       "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, idConsulta);
            stmt.setDate(2, fechaGeneracion);
            stmt.setTime(3, horaGeneracion);
            stmt.setDouble(4, montoPagado);
            stmt.setDouble(5, montoCambio);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read: Obtener todos los recibos de consulta
    public List<ReciboConsulta> obtenerRecibosConsulta() {
        List<ReciboConsulta> recibos = new ArrayList<>();
        String query = "SELECT * FROM reciboConsulta";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                ReciboConsulta recibo = new ReciboConsulta(
                    rs.getInt("idReciboConsulta"),
                    rs.getInt("idConsulta"),
                    rs.getDate("fechaGeneracion"),
                    rs.getTime("horaGeneracion"),
                    rs.getDouble("montoPagado"),
                    rs.getDouble("montoCambio")
                );
                recibos.add(recibo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recibos;
    }

    // Update: Actualizar un recibo de consulta
    public boolean actualizarReciboConsulta(int idReciboConsulta, double montoPagado, double montoCambio) {
        String query = "UPDATE reciboConsulta SET montoPagado = ?, montoCambio = ? WHERE idReciboConsulta = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setDouble(1, montoPagado);
            stmt.setDouble(2, montoCambio);
            stmt.setInt(3, idReciboConsulta);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete: Eliminar un recibo de consulta
    public boolean eliminarReciboConsulta(int idReciboConsulta) {
        String query = "DELETE FROM reciboConsulta WHERE idReciboConsulta = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, idReciboConsulta);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
