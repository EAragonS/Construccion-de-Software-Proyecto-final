package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Paciente;

public class PacienteDAO {
    private Connection conexion;

    public PacienteDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public List<Paciente> obtenerTodos() throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM paciente";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setNombreCompletoP(rs.getString("nombreCompletoP"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                paciente.setCorreoElectronicoP(rs.getString("correoElectronicoP"));
                paciente.setNumeroTelefonoP(rs.getString("numeroTelefonoP"));
                paciente.setNombreContactoEmergencia(rs.getString("nombreContactoEmergencia"));
                paciente.setNumTelefonoContactoEmergencia(rs.getString("numTelefonoContactoEmergencia"));

                pacientes.add(paciente);
            }
        }

        return pacientes;
    }

    public Paciente obtenerPorId(int idPaciente) throws SQLException {
        String sql = "SELECT * FROM paciente WHERE idPaciente = ?";
        Paciente paciente = null;

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idPaciente);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    paciente = new Paciente();
                    paciente.setIdPaciente(rs.getInt("idPaciente"));
                    paciente.setNombreCompletoP(rs.getString("nombreCompletoP"));
                    paciente.setSexo(rs.getString("sexo"));
                    paciente.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                    paciente.setCorreoElectronicoP(rs.getString("correoElectronicoP"));
                    paciente.setNumeroTelefonoP(rs.getString("numeroTelefonoP"));
                    paciente.setNombreContactoEmergencia(rs.getString("nombreContactoEmergencia"));
                    paciente.setNumTelefonoContactoEmergencia(rs.getString("numTelefonoContactoEmergencia"));
                }
            }
        }

        return paciente;
    }

    public void insertar(Paciente paciente) throws SQLException {
        String sql = "INSERT INTO paciente (nombreCompletoP, sexo, fechaNacimiento, correoElectronicoP, " +
                     "numeroTelefonoP, nombreContactoEmergencia, numTelefonoContactoEmergencia) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNombreCompletoP());
            stmt.setString(2, paciente.getSexo());
            stmt.setDate(3, new java.sql.Date(paciente.getFechaNacimiento().getTime()));
            stmt.setString(4, paciente.getCorreoElectronicoP());
            stmt.setString(5, paciente.getNumeroTelefonoP());
            stmt.setString(6, paciente.getNombreContactoEmergencia());
            stmt.setString(7, paciente.getNumTelefonoContactoEmergencia());

            stmt.executeUpdate();
        }
    }

    public void actualizar(Paciente paciente) throws SQLException {
        String sql = "UPDATE paciente SET nombreCompletoP = ?, sexo = ?, fechaNacimiento = ?, " +
                     "correoElectronicoP = ?, numeroTelefonoP = ?, nombreContactoEmergencia = ?, " +
                     "numTelefonoContactoEmergencia = ? WHERE idPaciente = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNombreCompletoP());
            stmt.setString(2, paciente.getSexo());
            stmt.setDate(3, new java.sql.Date(paciente.getFechaNacimiento().getTime()));
            stmt.setString(4, paciente.getCorreoElectronicoP());
            stmt.setString(5, paciente.getNumeroTelefonoP());
            stmt.setString(6, paciente.getNombreContactoEmergencia());
            stmt.setString(7, paciente.getNumTelefonoContactoEmergencia());
            stmt.setInt(8, paciente.getIdPaciente());

            stmt.executeUpdate();
        }
    }

    public void eliminar(int idPaciente) throws SQLException {
        String sql = "DELETE FROM paciente WHERE idPaciente = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idPaciente);
            stmt.executeUpdate();
        }
    }
}
