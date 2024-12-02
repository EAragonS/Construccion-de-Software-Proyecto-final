package modelo.dao;

import modelo.Receta;
import java.util.List;

public class RecetaDAO extends DAO<Receta> {

    @Override
    public boolean agregar(Receta receta) {
        String sql = "INSERT INTO receta (idConsulta, nombreMedicamento, dosis, duracionConsumo) VALUES (?, ?, ?, ?)";
        return ejecutarActualizacion(sql,
            receta.getIdConsulta(),
            receta.getNombreMedicamento(),
            receta.getDosis(),
            receta.getDuracionConsumo()
        );
    }

    @Override
    public boolean modificar(Receta receta) {
        String sql = "UPDATE receta SET nombreMedicamento = ?, dosis = ?, duracionConsumo = ? WHERE idReceta = ?";
        return ejecutarActualizacion(sql,
            receta.getNombreMedicamento(),
            receta.getDosis(),
            receta.getDuracionConsumo(),
            receta.getIdReceta()
        );
    }

    @Override
    public boolean eliminar(int idReceta) {
        String sql = "DELETE FROM receta WHERE idReceta = ?";
        return ejecutarActualizacion(sql, idReceta);
    }

    @Override
    public List<Receta> consultar() {
        String sql = "SELECT * FROM receta";
        return ejecutarConsulta(sql, rs -> {
            Receta receta = new Receta();
            receta.setIdReceta(rs.getInt("idReceta"));
            receta.setIdConsulta(rs.getInt("idConsulta"));
            receta.setNombreMedicamento(rs.getString("nombreMedicamento"));
            receta.setDosis(rs.getString("dosis"));
            receta.setDuracionConsumo(rs.getString("duracionConsumo"));
            return receta;
        });
    }

    // Método adicional para obtener recetas por ID de consulta
    public List<Receta> obtenerPorIdConsulta(int idConsulta) {
        String sql = "SELECT * FROM receta WHERE idConsulta = ?";
        return ejecutarConsulta(sql, rs -> {
            Receta receta = new Receta();
            receta.setIdReceta(rs.getInt("idReceta"));
            receta.setIdConsulta(rs.getInt("idConsulta"));
            receta.setNombreMedicamento(rs.getString("nombreMedicamento"));
            receta.setDosis(rs.getString("dosis"));
            receta.setDuracionConsumo(rs.getString("duracionConsumo"));
            return receta;
        }, idConsulta);
    }
}
