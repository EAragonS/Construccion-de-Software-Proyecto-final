package modelo.dao;

import java.sql.*;
import java.util.*;

public class PacientesAtendidosDAO extends DAO<Map<String, Object>> {

    @Override
    public boolean agregar(Map<String, Object> entidad) {
        throw new UnsupportedOperationException("La operación agregar no está soportada en PacientesAtendidosDAO.");
    }

    @Override
    public boolean modificar(Map<String, Object> entidad) {
        throw new UnsupportedOperationException("La operación modificar no está soportada en PacientesAtendidosDAO.");
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("La operación eliminar no está soportada en PacientesAtendidosDAO.");
    }

    @Override
    public List<Map<String, Object>> consultar() {
        String sql = "SELECT nombreDoctor, nombreCompletoP FROM pacientesAtendidos";
        return ejecutarConsultaMapa(sql);
    }

    // Método para obtener pacientes atendidos por un doctor específico
    public List<Map<String, Object>> obtenerPorDoctor(String nombreDoctor) {
        String sql = "SELECT nombreDoctor, nombreCompletoP FROM pacientesAtendidos WHERE nombreDoctor = ?";
        return ejecutarConsultaMapa(sql, nombreDoctor);
    }

    // Método genérico para ejecutar consultas y devolver datos como mapas
    private List<Map<String, Object>> ejecutarConsultaMapa(String sql, Object... parametros) {
        List<Map<String, Object>> resultados = new ArrayList<>();
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            // Asignar parámetros si los hay
            for (int i = 0; i < parametros.length; i++) {
                stmt.setObject(i + 1, parametros[i]);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                // Obtener metadatos para las claves del mapa
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (rs.next()) {
                    Map<String, Object> fila = new HashMap<>();
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnLabel(i);
                        Object columnValue = rs.getObject(i);
                        fila.put(columnName, columnValue);
                    }
                    resultados.add(fila);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }
}
 