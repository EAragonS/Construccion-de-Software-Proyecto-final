package modelo;

import java.sql.Date;
import java.sql.Time;

public class Recibo {
    private int idRecibo;
    private int idConsulta;
    private Date fechaGeneracion;
    private Time horaGeneracion;
    private double montoPagado;
    private double montoCambio;

    // Constructor vacío
    public Recibo() {
    }

    // Constructor con todos los atributos
    public Recibo(int idRecibo, int idConsulta, Date fechaGeneracion, Time horaGeneracion, 
                          double montoPagado, double montoCambio) {
        this.idRecibo = idRecibo;
        this.idConsulta = idConsulta;
        this.fechaGeneracion = fechaGeneracion;
        this.horaGeneracion = horaGeneracion;
        this.montoPagado = montoPagado;
        this.montoCambio = montoCambio;
    }

    // Getters y Setters
    public int getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(int idRecibo) {
    if (idRecibo < 0) {
        throw new IllegalArgumentException("El idRecibo no puede ser negativo");
    }
    this.idRecibo = idRecibo;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public Time getHoraGeneracion() {
        return horaGeneracion;
    }

    public void setHoraGeneracion(Time horaGeneracion) {
        this.horaGeneracion = horaGeneracion;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(double montoPagado) {
    if (montoPagado < 0) {
        throw new IllegalArgumentException("El monto pagado no puede ser negativo");
    }
    this.montoPagado = montoPagado;
    }

    public double getMontoCambio() {
        return montoCambio;
    }

    public void setMontoCambio(double montoCambio) {
    if (montoCambio < 0) {
        throw new IllegalArgumentException("El monto de cambio no puede ser negativo");
    }
    this.montoCambio = montoCambio;
    }

    @Override
    public String toString() {
        return "Recibo{" +
                "idRecibo=" + idRecibo +
                ", idConsulta=" + idConsulta +
                ", fechaGeneracion=" + fechaGeneracion +
                ", horaGeneracion=" + horaGeneracion +
                ", montoPagado=" + montoPagado +
                ", montoCambio=" + montoCambio +
                '}';
    }
}  