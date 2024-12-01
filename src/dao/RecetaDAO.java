package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Receta;

public class RecetaDAO {

    private Connection connection;

    public RecetaDAO(Connection connection) {
        this.connection = connection;
    }

    // Create: Insertar una nueva receta
    public boolean insertarReceta(int idConsulta, String nombreMedicamento, String dosis, String duracionConsumo) {
        String query = "INSERT INTO receta (idConsulta, nombreMedicamento, dosis, duracionConsumo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idConsulta);
            stmt.setString(2, nombreMedicamento);
            stmt.setString(3, dosis);
            stmt.setString(4, duracionConsumo);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read: Obtener todas las recetas
    public List<Receta> obtenerRecetas() {
        List<Receta> recetas = new ArrayList<>();
        String query = "SELECT * FROM receta";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Receta receta = new Receta(
                    rs.getInt("idReceta"),
                    rs.getInt("idConsulta"),
                    rs.getString("nombreMedicamento"),
                    rs.getString("dosis"),
                    rs.getString("duracionConsumo")
                );
                recetas.add(receta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recetas;
    }

    // Update: Actualizar una receta
    public boolean actualizarReceta(int idReceta, String nombreMedicamento, String dosis, String duracionConsumo) {
        String query = "UPDATE receta SET nombreMedicamento = ?, dosis = ?, duracionConsumo = ? WHERE idReceta = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nombreMedicamento);
            stmt.setString(2, dosis);
            stmt.setString(3, duracionConsumo);
            stmt.setInt(4, idReceta);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete: Eliminar una receta
    public boolean eliminarReceta(int idReceta) {
        String query = "DELETE FROM receta WHERE idReceta = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idReceta);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
