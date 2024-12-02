package modelo.dao;

import modelo.Doctor;
import java.util.List;

public class DoctorDAO extends DAO<Doctor> {

    @Override
    public boolean agregar(Doctor doctor) {
        String query = "INSERT INTO doctor (idDoctor, cedula, especialidad, precioConsulta, numConsultorio) VALUES (?, ?, ?, ?, ?)";
        return ejecutarActualizacion(query, 
            doctor.getIdDoctor(), 
            doctor.getCedula(), 
            doctor.getEspecialidad(), 
            doctor.getPrecioConsulta(), 
            doctor.getNumConsultorio()
        );
    }

    @Override
    public List<Doctor> consultar() {
        String sql = "SELECT d.idDoctor, d.cedula, d.especialidad, d.precioConsulta, d.numConsultorio, " +
                     "e.idEmpleado, e.nombreCompletoE, e.fechaIngreso, e.correoElectronicoE, " +
                     "e.numTelefonoE, e.nombreUsuario, e.contrasena " +
                     "FROM doctor d " +
                     "JOIN empleado e ON d.idDoctor = e.idEmpleado";
        return ejecutarConsulta(sql, rs -> new Doctor(
            rs.getInt("idDoctor"),
            rs.getString("cedula"),
            rs.getString("especialidad"),
            rs.getDouble("precioConsulta"),
            rs.getInt("numConsultorio"),
            rs.getInt("idEmpleado"), 
            rs.getString("nombreCompletoE"), 
            rs.getDate("fechaIngreso"), 
            rs.getString("correoElectronicoE"),
            rs.getString("numTelefonoE"),
            rs.getString("nombreUsuario"),
            rs.getString("contrasena")
        ));
    }


    @Override
    public boolean modificar(Doctor doctor) {
        String query = "UPDATE doctor SET cedula = ?, especialidad = ?, precioConsulta = ?, numConsultorio = ? WHERE idDoctor = ?";
        return ejecutarActualizacion(query, 
            doctor.getCedula(), 
            doctor.getEspecialidad(), 
            doctor.getPrecioConsulta(), 
            doctor.getNumConsultorio(), 
            doctor.getIdDoctor()
        );
    }

    @Override
    public boolean eliminar(int id) {
        String query = "DELETE FROM doctor WHERE idDoctor = ?";
        return ejecutarActualizacion(query, id);
    }

    // Método adicional para obtener un doctor específico por ID
    public Doctor obtenerPorId(int id) {
        String query = "SELECT * FROM doctor WHERE idDoctor = ?";
        List<Doctor> doctores = ejecutarConsulta(query, rs -> new Doctor(
            rs.getInt("idDoctor"),
            rs.getString("cedula"),
            rs.getString("especialidad"),
            rs.getDouble("precioConsulta"),
            rs.getInt("numConsultorio"),
            rs.getInt("idEmpleado"), 
            rs.getString("nombreCompleto"), 
            rs.getDate("fechaIngreso"), 
            rs.getString("correoElectronico"),
            rs.getString("numTelefono"),
            rs.getString("nombreUsuario"),
            rs.getString("contrasena")
        ), id);
        return doctores.isEmpty() ? null : doctores.get(0);
    }
}
