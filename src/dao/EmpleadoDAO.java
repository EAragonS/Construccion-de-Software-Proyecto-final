package dao;

/**
 *
 * @author Elias
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;

public class EmpleadoDAO {

    private Connection conexion;

    public EmpleadoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Create: Insertar un nuevo empleado
    public boolean insertarEmpleado(String nombreCompleto, Date fechaIngreso, String correo, 
                                     String telefono, String usuario, String contrasena) {
        String query = "INSERT INTO empleado (nombreCompletoE, fechaIngreso, correoElectronicoE, " +
                       "numTelefonoE, nombreUsuario, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, nombreCompleto);
            stmt.setDate(2, fechaIngreso);
            stmt.setString(3, correo);
            stmt.setString(4, telefono);
            stmt.setString(5, usuario);
            stmt.setString(6, contrasena);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read: Obtener todos los empleados
    public List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleado";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Empleado empleado = new Empleado(
                    rs.getInt("idEmpleado"),
                    rs.getString("nombreCompletoE"),
                    rs.getDate("fechaIngreso"),
                    rs.getString("correoElectronicoE"),
                    rs.getString("numTelefonoE"),
                    rs.getString("nombreUsuario"),
                    rs.getString("contrasena")
                );
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    // Update: Actualizar un empleado
    public boolean actualizarEmpleado(int id, String nombreCompleto, String correo, String telefono) {
        String query = "UPDATE empleado SET nombreCompletoE = ?, correoElectronicoE = ?, numTelefonoE = ? WHERE idEmpleado = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, nombreCompleto);
            stmt.setString(2, correo);
            stmt.setString(3, telefono);
            stmt.setInt(4, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete: Eliminar un empleado
    public boolean eliminarEmpleado(int id) {
        String query = "DELETE FROM empleado WHERE idEmpleado = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}