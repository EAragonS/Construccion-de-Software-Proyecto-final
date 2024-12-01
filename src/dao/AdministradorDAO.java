package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AdministradorDAO {

    private Connection conexion;

    public AdministradorDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Create: Insertar un administrador
    public boolean insertarAdministrador(int idEmpleado) {
        String query = "INSERT INTO administrador (idAdministrador) VALUES (?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, idEmpleado);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read: Obtener todos los administradores
    public List<Integer> obtenerAdministradores() {
        List<Integer> administradores = new ArrayList<>();
        String query = "SELECT idAdministrador FROM administrador";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                administradores.add(rs.getInt("idAdministrador"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return administradores;
    }

    // Delete: Eliminar un administrador
    public boolean eliminarAdministrador(int idEmpleado) {
        String query = "DELETE FROM administrador WHERE idAdministrador = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, idEmpleado);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
