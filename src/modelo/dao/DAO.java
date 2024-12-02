package modelo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DAO<T> {
    protected Connection conexion;

    public DAO() {
        this.conexion = crearConexion();
    }

    private Connection crearConexion() {
        try {
            String url = "jdbc:mysql://localhost:3306/Clinica";
            String usuario = "root";
            String contraseña = "";
            return DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al establecer la conexión con la base de datos: " + e.getMessage());
        }
    }

    // Métodos abstractos que los hijos implementarán
    public abstract boolean agregar(T entidad);

    public abstract List<T> consultar();

    public abstract boolean modificar(T entidad);

    public abstract boolean eliminar(int id);

    // Método utilitario para ejecutar consultas con parámetros
    protected boolean ejecutarActualizacion(String query, Object... params) {
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            setParameters(stmt, params);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método utilitario para obtener datos
    protected List<T> ejecutarConsulta(String query, RowMapper<T> mapper, Object... params) {
        List<T> resultados = new ArrayList<>();
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            setParameters(stmt, params);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    resultados.add(mapper.map(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }

    // Configurar parámetros en un PreparedStatement
    private void setParameters(PreparedStatement stmt, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }
    }

    // Interfaz para mapear filas del ResultSet a objetos
    @FunctionalInterface
    public interface RowMapper<T> {
        T map(ResultSet rs) throws SQLException;
    }
}
