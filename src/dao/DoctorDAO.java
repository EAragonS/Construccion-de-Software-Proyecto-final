package dao;

import modelo.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    private Connection conexion;

    public DoctorDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void agregarDoctor(Doctor doctor) throws SQLException {
        String query = "INSERT INTO doctor (idDoctor, nombre, especialidad, telefono, correo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, doctor.getIdDoctor());
            statement.setString(2, doctor.getNombre());
            statement.setString(3, doctor.getEspecialidad());
            statement.setString(4, doctor.getTelefono());
            statement.setString(5, doctor.getCorreo());
            statement.executeUpdate();
        }
    }

    public Doctor obtenerDoctorPorId(int id) throws SQLException {
        String query = "SELECT * FROM doctor WHERE idDoctor = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Doctor(
                        resultSet.getInt("idDoctor"),
                        resultSet.getString("nombre"),
                        resultSet.getString("especialidad"),
                        resultSet.getString("telefono"),
                        resultSet.getString("correo")
                    );
                }
            }
        }
        return null;
    }

    public List<Doctor> obtenerTodosLosDoctores() throws SQLException {
        List<Doctor> doctores = new ArrayList<>();
        String query = "SELECT * FROM doctor";
        try (PreparedStatement statement = conexion.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                doctores.add(new Doctor(
                    resultSet.getInt("idDoctor"),
                    resultSet.getString("nombre"),
                    resultSet.getString("especialidad"),
                    resultSet.getString("telefono"),
                    resultSet.getString("correo")
                ));
            }
        }
        return doctores;
    }

    public void actualizarDoctor(Doctor doctor) throws SQLException {
        String query = "UPDATE doctor SET nombre = ?, especialidad = ?, telefono = ?, correo = ? WHERE idDoctor = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, doctor.getNombre());
            statement.setString(2, doctor.getEspecialidad());
            statement.setString(3, doctor.getTelefono());
            statement.setString(4, doctor.getCorreo());
            statement.setInt(5, doctor.getIdDoctor());
            statement.executeUpdate();
        }
    }

    public void eliminarDoctor(int id) throws SQLException {
        String query = "DELETE FROM doctor WHERE idDoctor = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
