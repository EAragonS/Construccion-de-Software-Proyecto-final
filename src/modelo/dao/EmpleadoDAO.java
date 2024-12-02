package modelo.dao; //Listo

import modelo.Empleado;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class EmpleadoDAO extends DAO<Empleado> {

    public EmpleadoDAO() {
        super(); // La conexión ya es gestionada por el padre.
    }

    @Override
    public boolean agregar(Empleado empleado) {
        String query = "INSERT INTO empleado (nombreCompletoE, fechaIngreso, correoElectronicoE, " +
                       "numTelefonoE, nombreUsuario, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
        return ejecutarActualizacion(query, 
            empleado.getNombreCompleto(), 
            empleado.getFechaIngreso(), 
            empleado.getCorreoElectronico(), 
            empleado.getNumTelefono(), 
            empleado.getNombreUsuario(), 
            empleado.getContrasena());
    }

    @Override
    public List<Empleado> consultar() {
        String query = "SELECT * FROM empleado";
        return ejecutarConsulta(query, rs -> new Empleado(
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
    public boolean modificar(Empleado empleado) {
        String query = "UPDATE empleado SET nombreCompletoE = ?, correoElectronicoE = ?, numTelefonoE = ? " +
                       "WHERE idEmpleado = ?";
        return ejecutarActualizacion(query, 
            empleado.getNombreCompleto(), 
            empleado.getCorreoElectronico(), 
            empleado.getNumTelefono(), 
            empleado.getIdEmpleado());
    }

    @Override
    public boolean eliminar(int id) {
        String query = "DELETE FROM empleado WHERE idEmpleado = ?";
        return ejecutarActualizacion(query, id);
    }
}
