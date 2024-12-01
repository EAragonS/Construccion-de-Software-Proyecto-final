package modelo;

import java.sql.Date;
import java.sql.Time;

public class ReciboConsulta {
    private int idReciboConsulta;
    private int idConsulta;
    private Date fechaGeneracion;
    private Time horaGeneracion;
    private double montoPagado;
    private double montoCambio;

    // Constructor vacío
    public ReciboConsulta() {
    }

    // Constructor con todos los atributos
    public ReciboConsulta(int idReciboConsulta, int idConsulta, Date fechaGeneracion, Time horaGeneracion, 
                          double montoPagado, double montoCambio) {
        this.idReciboConsulta = idReciboConsulta;
        this.idConsulta = idConsulta;
        this.fechaGeneracion = fechaGeneracion;
        this.horaGeneracion = horaGeneracion;
        this.montoPagado = montoPagado;
        this.montoCambio = montoCambio;
    }

    // Getters y Setters
    public int getIdReciboConsulta() {
        return idReciboConsulta;
    }

    public void setIdReciboConsulta(int idReciboConsulta) {
        this.idReciboConsulta = idReciboConsulta;
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
        this.montoPagado = montoPagado;
    }

    public double getMontoCambio() {
        return montoCambio;
    }

    public void setMontoCambio(double montoCambio) {
        this.montoCambio = montoCambio;
    }

    @Override
    public String toString() {
        return "ReciboConsulta{" +
                "idReciboConsulta=" + idReciboConsulta +
                ", idConsulta=" + idConsulta +
                ", fechaGeneracion=" + fechaGeneracion +
                ", horaGeneracion=" + horaGeneracion +
                ", montoPagado=" + montoPagado +
                ", montoCambio=" + montoCambio +
                '}';
    }
}
