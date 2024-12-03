package modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConsultaTest {

    // A. Pruebas para Constructores

    @Test
    public void testConstructorSinParametrosInicializaValoresPorDefecto() {
        Consulta consulta = new Consulta();
        assertEquals(0, consulta.getIdConsulta());
        assertEquals(0, consulta.getIdCita());
        assertNull(consulta.getMotivo());
        assertNull(consulta.getDiagnostico());
    }

    @Test
    public void testConstructorConParametrosInicializaValoresCorrectos() {
        Consulta consulta = new Consulta(1, 101, "Dolor de cabeza", "Migraña");
        assertEquals(1, consulta.getIdConsulta());
        assertEquals(101, consulta.getIdCita());
        assertEquals("Dolor de cabeza", consulta.getMotivo());
        assertEquals("Migraña", consulta.getDiagnostico());
    }

    // B. Pruebas para Getters y Setters

    @Test
    public void testSetAndGetIdConsulta() {
        Consulta consulta = new Consulta();
        consulta.setIdConsulta(5);
        assertEquals(5, consulta.getIdConsulta());
    }

    @Test
    public void testSetAndGetIdCita() {
        Consulta consulta = new Consulta();
        consulta.setIdCita(50);
        assertEquals(50, consulta.getIdCita());
    }

    @Test
    public void testSetAndGetMotivo() {
        Consulta consulta = new Consulta();
        consulta.setMotivo("Fiebre alta");
        assertEquals("Fiebre alta", consulta.getMotivo());
    }

    @Test
    public void testSetAndGetDiagnostico() {
        Consulta consulta = new Consulta();
        consulta.setDiagnostico("Gripe común");
        assertEquals("Gripe común", consulta.getDiagnostico());
    }

    // C. Pruebas para el Método toString

    @Test
    public void testToStringDevuelveFormatoEsperado() {
        Consulta consulta = new Consulta(3, 103, "Dolor abdominal", "Gastritis");
        String esperado = "Consulta{idConsulta=3, idCita=103, motivo='Dolor abdominal', diagnostico='Gastritis'}";
        assertEquals(esperado, consulta.toString());
    }

    // D. Pruebas de Validación 

    @Test
    public void testSetIdConsultaConValorNegativo() {
        Consulta consulta = new Consulta();
        try {
            consulta.setIdConsulta(-1);
            fail("Se esperaba una excepción para idConsulta negativo.");
        } catch (IllegalArgumentException e) {
            assertEquals("idConsulta no puede ser negativo", e.getMessage());
        }
    }

    @Test
    public void testSetIdCitaConValorNegativo() {
        Consulta consulta = new Consulta();
        try {
            consulta.setIdCita(-1);
            fail("Se esperaba una excepción para idCita negativo.");
        } catch (IllegalArgumentException e) {
            assertEquals("idCita no puede ser negativo", e.getMessage());
        }
    }
}
