package modelo.dao;//Listo

import modelo.Paciente;
import java.util.List;

public class PacienteDAO extends DAO<Paciente> {

    @Override
    public boolean agregar(Paciente paciente) {
        String sql = "INSERT INTO paciente (nombreCompletoP, sexo, fechaNacimiento, correoElectronicoP, " +
                     "numeroTelefonoP, nombreContactoEmergencia, numTelefonoContactoEmergencia) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return ejecutarActualizacion(sql,
            paciente.getNombreCompletoP(),
            paciente.getSexo(),
            new java.sql.Date(paciente.getFechaNacimiento().getTime()),
            paciente.getCorreoElectronicoP(),
            paciente.getNumeroTelefonoP(),
            paciente.getNombreContactoEmergencia(),
            paciente.getNumTelefonoContactoEmergencia()
        );
    }

    @Override
    public boolean modificar(Paciente paciente) {
        String sql = "UPDATE paciente SET nombreCompletoP = ?, sexo = ?, fechaNacimiento = ?, " +
                     "correoElectronicoP = ?, numeroTelefonoP = ?, nombreContactoEmergencia = ?, " +
                     "numTelefonoContactoEmergencia = ? WHERE idPaciente = ?";
        return ejecutarActualizacion(sql,
            paciente.getNombreCompletoP(),
            paciente.getSexo(),
            new java.sql.Date(paciente.getFechaNacimiento().getTime()),
            paciente.getCorreoElectronicoP(),
            paciente.getNumeroTelefonoP(),
            paciente.getNombreContactoEmergencia(),
            paciente.getNumTelefonoContactoEmergencia(),
            paciente.getIdPaciente()
        );
    }

    @Override
    public boolean eliminar(int idPaciente) {
        String sql = "DELETE FROM paciente WHERE idPaciente = ?";
        return ejecutarActualizacion(sql, idPaciente);
    }

    @Override
    public List<Paciente> consultar() {
        String sql = "SELECT * FROM paciente";
        return ejecutarConsulta(sql, rs -> {
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(rs.getInt("idPaciente"));
            paciente.setNombreCompletoP(rs.getString("nombreCompletoP"));
            paciente.setSexo(rs.getString("sexo"));
            paciente.setFechaNacimiento(rs.getDate("fechaNacimiento"));
            paciente.setCorreoElectronicoP(rs.getString("correoElectronicoP"));
            paciente.setNumeroTelefonoP(rs.getString("numeroTelefonoP"));
            paciente.setNombreContactoEmergencia(rs.getString("nombreContactoEmergencia"));
            paciente.setNumTelefonoContactoEmergencia(rs.getString("numTelefonoContactoEmergencia"));
            return paciente;
        });
    }

    // Método adicional para obtener un paciente específico por ID
    public Paciente obtenerPorId(int idPaciente) {
        String sql = "SELECT * FROM paciente WHERE idPaciente = ?";
        List<Paciente> pacientes = ejecutarConsulta(sql, rs -> {
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(rs.getInt("idPaciente"));
            paciente.setNombreCompletoP(rs.getString("nombreCompletoP"));
            paciente.setSexo(rs.getString("sexo"));
            paciente.setFechaNacimiento(rs.getDate("fechaNacimiento"));
            paciente.setCorreoElectronicoP(rs.getString("correoElectronicoP"));
            paciente.setNumeroTelefonoP(rs.getString("numeroTelefonoP"));
            paciente.setNombreContactoEmergencia(rs.getString("nombreContactoEmergencia"));
            paciente.setNumTelefonoContactoEmergencia(rs.getString("numTelefonoContactoEmergencia"));
            return paciente;
        }, idPaciente);
        return pacientes.isEmpty() ? null : pacientes.get(0);
    }
}