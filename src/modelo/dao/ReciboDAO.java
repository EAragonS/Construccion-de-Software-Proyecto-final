package modelo.dao;

import modelo.Recibo;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class ReciboDAO extends DAO<Recibo> {

    @Override
    public boolean agregar(Recibo recibo) {
        String sql = "INSERT INTO reciboConsulta (idConsulta, fechaGeneracion, horaGeneracion, montoPagado, montoCambio) " +
                     "VALUES (?, ?, ?, ?, ?)";
        return ejecutarActualizacion(sql,
            recibo.getIdConsulta(),
            recibo.getFechaGeneracion(),
            recibo.getHoraGeneracion(),
            recibo.getMontoPagado(),
            recibo.getMontoCambio()
        );
    }

    @Override
    public boolean modificar(Recibo recibo) {
        String sql = "UPDATE reciboConsulta SET montoPagado = ?, montoCambio = ? WHERE idRecibo = ?";
        return ejecutarActualizacion(sql,
            recibo.getMontoPagado(),
            recibo.getMontoCambio(),
            recibo.getIdRecibo()
        );
    }

    @Override
    public boolean eliminar(int idRecibo) {
        String sql = "DELETE FROM reciboConsulta WHERE idRecibo = ?";
        return ejecutarActualizacion(sql, idRecibo);
    }

    @Override
    public List<Recibo> consultar() {
        String sql = "SELECT * FROM reciboConsulta";
        return ejecutarConsulta(sql, rs -> {
            Recibo recibo = new Recibo();
            recibo.setIdRecibo(rs.getInt("idRecibo"));
            recibo.setIdConsulta(rs.getInt("idConsulta"));
            recibo.setFechaGeneracion(rs.getDate("fechaGeneracion"));
            recibo.setHoraGeneracion(rs.getTime("horaGeneracion"));
            recibo.setMontoPagado(rs.getDouble("montoPagado"));
            recibo.setMontoCambio(rs.getDouble("montoCambio"));
            return recibo;
        });
    }

    // Método adicional para obtener recibos por ID de consulta
    public List<Recibo> obtenerPorIdConsulta(int idConsulta) {
        String sql = "SELECT * FROM reciboConsulta WHERE idConsulta = ?";
        return ejecutarConsulta(sql, rs -> {
            Recibo recibo = new Recibo();
            recibo.setIdRecibo(rs.getInt("idRecibo"));
            recibo.setIdConsulta(rs.getInt("idConsulta"));
            recibo.setFechaGeneracion(rs.getDate("fechaGeneracion"));
            recibo.setHoraGeneracion(rs.getTime("horaGeneracion"));
            recibo.setMontoPagado(rs.getDouble("montoPagado"));
            recibo.setMontoCambio(rs.getDouble("montoCambio"));
            return recibo;
        }, idConsulta);
    }
}
