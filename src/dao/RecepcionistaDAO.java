package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Recepcionista;

public class RecepcionistaDAO {
    private final Connection conexion;

    public RecepcionistaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean insertar(Recepcionista recepcionista) {
        String sql = "INSERT INTO recepcionista (idRecepcionista) VALUES (?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, recepcionista.getIdRecepcionista());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar recepcionista: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Recepcionista recepcionista) {
        String sql = "UPDATE recepcionista SET idRecepcionista = ? WHERE idRecepcionista = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, recepcionista.getIdRecepcionista());
            ps.setInt(2, recepcionista.getIdRecepcionista());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar recepcionista: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int idRecepcionista) {
        String sql = "DELETE FROM recepcionista WHERE idRecepcionista = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idRecepcionista);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar recepcionista: " + e.getMessage());
            return false;
        }
    }

    public Recepcionista obtenerPorId(int idRecepcionista) {
        String sql = "SELECT r.idRecepcionista, e.idEmpleado, e.nombre, e.apellido, e.correo, e.telefono, e.fechaIngreso, " +
                     "e.nombreUsuario, e.contrasena " +
                     "FROM recepcionista r " +
                     "JOIN empleado e ON r.idRecepcionista = e.idEmpleado " +
                     "WHERE r.idRecepcionista = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idRecepcionista);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Recepcionista(
                            rs.getInt("idRecepcionista"),
                            rs.getInt("idEmpleado"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getDate("fechaIngreso"),
                            rs.getString("correo"),
                            rs.getString("telefono"),
                            rs.getString("nombreUsuario"),
                            rs.getString("contrasena")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener recepcionista: " + e.getMessage());
        }
        return null;
    }

    public List<Recepcionista> obtenerTodos() {
        List<Recepcionista> recepcionistas = new ArrayList<>();
        String sql = "SELECT r.idRecepcionista, e.idEmpleado, e.nombre, e.apellido, e.correo, e.telefono, e.fechaIngreso, " +
                     "e.nombreUsuario, e.contrasena " +
                     "FROM recepcionista r " +
                     "JOIN empleado e ON r.idRecepcionista = e.idEmpleado";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                recepcionistas.add(new Recepcionista(
                        rs.getInt("idRecepcionista"),
                        rs.getInt("idEmpleado"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getDate("fechaIngreso"),
                        rs.getString("correo"),
                        rs.getString("telefono"),
                        rs.getString("nombreUsuario"),
                        rs.getString("contrasena")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener todos los recepcionistas: " + e.getMessage());
        }
        return recepcionistas;
    }
}