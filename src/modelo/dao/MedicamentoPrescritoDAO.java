package modelo.dao;

import modelo.MedicamentoPrescrito;

import java.util.List;

public class MedicamentoPrescritoDAO extends DAO<MedicamentoPrescrito> {

    @Override
    public boolean agregar(MedicamentoPrescrito medicamento) {
        String sql = "INSERT INTO medicamentoPrescrito (idReceta, idMedicamento, nombreMedicamento, dosis, duracionConsumo) " +
                     "VALUES (?, ?, ?, ?, ?)";
        return ejecutarActualizacion(sql,
            medicamento.getIdReceta(),
            medicamento.getIdMedicamento(),
            medicamento.getNombreMedicamento(),
            medicamento.getDosis(),
            medicamento.getDuracionConsumo()
        );
    }

    @Override
    public boolean modificar(MedicamentoPrescrito medicamento) {
        String sql = "UPDATE medicamentoPrescrito SET nombreMedicamento = ?, dosis = ?, duracionConsumo = ? " +
                     "WHERE idReceta = ? AND idMedicamento = ?";
        return ejecutarActualizacion(sql,
            medicamento.getNombreMedicamento(),
            medicamento.getDosis(),
            medicamento.getDuracionConsumo(),
            medicamento.getIdReceta(),
            medicamento.getIdMedicamento()
        );
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM medicamentoPrescrito WHERE idMedicamento = ?";
        return ejecutarActualizacion(sql, id);
    }

    @Override
    public List<MedicamentoPrescrito> consultar() {
        String sql = "SELECT * FROM medicamentoPrescrito";
        return ejecutarConsulta(sql, rs -> {
            MedicamentoPrescrito medicamento = new MedicamentoPrescrito();
            medicamento.setIdReceta(rs.getInt("idReceta"));
            medicamento.setIdMedicamento(rs.getInt("idMedicamento"));
            medicamento.setNombreMedicamento(rs.getString("nombreMedicamento"));
            medicamento.setDosis(rs.getString("dosis"));
            medicamento.setDuracionConsumo(rs.getString("duracionConsumo"));
            return medicamento;
        });
    }

    // Método adicional: Obtener medicamentos por receta
    public List<MedicamentoPrescrito> obtenerPorReceta(int idReceta) {
        String sql = "SELECT * FROM medicamentoPrescrito WHERE idReceta = ?";
        return ejecutarConsulta(sql, rs -> {
            MedicamentoPrescrito medicamento = new MedicamentoPrescrito();
            medicamento.setIdReceta(rs.getInt("idReceta"));
            medicamento.setIdMedicamento(rs.getInt("idMedicamento"));
            medicamento.setNombreMedicamento(rs.getString("nombreMedicamento"));
            medicamento.setDosis(rs.getString("dosis"));
            medicamento.setDuracionConsumo(rs.getString("duracionConsumo"));
            return medicamento;
        }, idReceta);
    }
}
