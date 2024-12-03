package modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Date;
import java.sql.Time;

public class ReciboTest {

    // A. Pruebas para Constructores

    @Test
    public void testConstructorSinParametrosInicializaValoresPorDefecto() {
        Recibo recibo = new Recibo();
        assertEquals(0, recibo.getIdRecibo());
        assertEquals(0, recibo.getIdConsulta());
        assertNull(recibo.getFechaGeneracion());
        assertNull(recibo.getHoraGeneracion());
        assertEquals(0.0, recibo.getMontoPagado(), 0.001);
        assertEquals(0.0, recibo.getMontoCambio(), 0.001);
    }

    @Test
    public void testConstructorConParametrosInicializaValoresCorrectos() {
        Date fechaGeneracion = Date.valueOf("2023-12-01");
        Time horaGeneracion = Time.valueOf("10:30:00");
        Recibo recibo = new Recibo(
                1, 101, fechaGeneracion, horaGeneracion, 500.0, 50.0
        );

        assertEquals(1, recibo.getIdRecibo());
        assertEquals(101, recibo.getIdConsulta());
        assertEquals(fechaGeneracion, recibo.getFechaGeneracion());
        assertEquals(horaGeneracion, recibo.getHoraGeneracion());
        assertEquals(500.0, recibo.getMontoPagado(), 0.001);
        assertEquals(50.0, recibo.getMontoCambio(), 0.001);
    }

    // B. Pruebas para Getters y Setters

    @Test
    public void testSetAndGetIdRecibo() {
        Recibo recibo = new Recibo();
        recibo.setIdRecibo(2);
        assertEquals(2, recibo.getIdRecibo());
    }

    @Test
    public void testSetAndGetIdConsulta() {
        Recibo recibo = new Recibo();
        recibo.setIdConsulta(202);
        assertEquals(202, recibo.getIdConsulta());
    }

    @Test
    public void testSetAndGetFechaGeneracion() {
        Recibo recibo = new Recibo();
        Date fechaGeneracion = Date.valueOf("2023-12-02");
        recibo.setFechaGeneracion(fechaGeneracion);
        assertEquals(fechaGeneracion, recibo.getFechaGeneracion());
    }

    @Test
    public void testSetAndGetHoraGeneracion() {
        Recibo recibo = new Recibo();
        Time horaGeneracion = Time.valueOf("15:45:00");
        recibo.setHoraGeneracion(horaGeneracion);
        assertEquals(horaGeneracion, recibo.getHoraGeneracion());
    }

    @Test
    public void testSetAndGetMontoPagado() {
        Recibo recibo = new Recibo();
        recibo.setMontoPagado(1000.0);
        assertEquals(1000.0, recibo.getMontoPagado(), 0.001);
    }

    @Test
    public void testSetAndGetMontoCambio() {
        Recibo recibo = new Recibo();
        recibo.setMontoCambio(50.0);
        assertEquals(50.0, recibo.getMontoCambio(), 0.001);
    }

    // C. Pruebas para el Método toString

    @Test
    public void testToStringDevuelveFormatoEsperado() {
        Date fechaGeneracion = Date.valueOf("2023-12-01");
        Time horaGeneracion = Time.valueOf("10:30:00");
        Recibo recibo = new Recibo(
                1, 101, fechaGeneracion, horaGeneracion, 500.0, 50.0
        );

        String esperado = "Recibo{idRecibo=1, idConsulta=101, fechaGeneracion=2023-12-01, horaGeneracion=10:30:00, montoPagado=500.0, montoCambio=50.0}";
        assertEquals(esperado, recibo.toString());
    }

    // D. Pruebas de Validación 

    @Test
    public void testSetIdReciboConValorNegativo() {
        Recibo recibo = new Recibo();
        try {
            recibo.setIdRecibo(-1);
            fail("Se esperaba una excepción para idRecibo negativo.");
        } catch (IllegalArgumentException e) {
            assertEquals("El idRecibo no puede ser negativo", e.getMessage());
        }
    }

    @Test
    public void testSetMontoPagadoConValorNegativo() {
        Recibo recibo = new Recibo();
        try {
            recibo.setMontoPagado(-100.0);
            fail("Se esperaba una excepción para montoPagado negativo.");
        } catch (IllegalArgumentException e) {
            assertEquals("El monto pagado no puede ser negativo", e.getMessage());
        }
    }

    @Test
    public void testSetMontoCambioConValorNegativo() {
        Recibo recibo = new Recibo();
        try {
            recibo.setMontoCambio(-20.0);
            fail("Se esperaba una excepción para montoCambio negativo.");
        } catch (IllegalArgumentException e) {
            assertEquals("El monto de cambio no puede ser negativo", e.getMessage());
        }
    }
}
