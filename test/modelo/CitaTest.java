package modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class CitaTest {

    // A. Pruebas para Constructores

    @Test
    public void testConstructorSinParametrosInicializaValoresPorDefecto() {
        Cita cita = new Cita();
        assertEquals(0, cita.getIdCita());
        assertEquals(0, cita.getIdPaciente());
        assertEquals(0, cita.getIdDoctor());
        assertNull(cita.getFechaHora());
        assertNull(cita.getMotivoConsulta());
        assertNull(cita.getEstado());
    }

    @Test
    public void testConstructorConParametrosInicializaValoresCorrectos() {
        LocalDateTime fechaHora = LocalDateTime.of(2023, 12, 15, 10, 30);
        Cita cita = new Cita(1, 101, 202, fechaHora, "Consulta general", "Pendiente");
        assertEquals(1, cita.getIdCita());
        assertEquals(101, cita.getIdPaciente());
        assertEquals(202, cita.getIdDoctor());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Consulta general", cita.getMotivoConsulta());
        assertEquals("Pendiente", cita.getEstado());
    }

    // B. Pruebas para Getters y Setters

    @Test
    public void testSetAndGetIdCita() {
        Cita cita = new Cita();
        cita.setIdCita(10);
        assertEquals(10, cita.getIdCita());
    }

    @Test
    public void testSetAndGetIdPaciente() {
        Cita cita = new Cita();
        cita.setIdPaciente(15);
        assertEquals(15, cita.getIdPaciente());
    }

    @Test
    public void testSetAndGetIdDoctor() {
        Cita cita = new Cita();
        cita.setIdDoctor(20);
        assertEquals(20, cita.getIdDoctor());
    }

    @Test
    public void testSetAndGetFechaHora() {
        Cita cita = new Cita();
        LocalDateTime fechaHora = LocalDateTime.of(2023, 12, 15, 10, 30);
        cita.setFechaHora(fechaHora);
        assertEquals(fechaHora, cita.getFechaHora());
    }

    @Test
    public void testSetAndGetMotivoConsulta() {
        Cita cita = new Cita();
        cita.setMotivoConsulta("Dolor de cabeza");
        assertEquals("Dolor de cabeza", cita.getMotivoConsulta());
    }

    @Test
    public void testSetAndGetEstado() {
        Cita cita = new Cita();
        cita.setEstado("Confirmada");
        assertEquals("Confirmada", cita.getEstado());
    }

    // C. Pruebas para el Método toString

    @Test
    public void testToStringDevuelveFormatoEsperado() {
        LocalDateTime fechaHora = LocalDateTime.of(2023, 12, 15, 10, 30);
        Cita cita = new Cita(1, 101, 202, fechaHora, "Consulta general", "Pendiente");
        String esperado = "Cita{idCita=1, idPaciente=101, idDoctor=202, fechaHora=2023-12-15T10:30, motivoConsulta='Consulta general', estado='Pendiente'}";
        assertEquals(esperado, cita.toString());
    }

    // D. Pruebas de Validación 

    @Test
    public void testSetIdCitaConValorNegativo() {
        Cita cita = new Cita();
        try {
            cita.setIdCita(-1);
            fail("Se esperaba una excepción para idCita negativo.");
        } catch (IllegalArgumentException e) {
            assertEquals("idCita no puede ser negativo", e.getMessage());
        }
    }

    @Test
    public void testSetEstadoConValorNulo() {
        Cita cita = new Cita();
        try {
            cita.setEstado(null);
            fail("Se esperaba una excepción para estado nulo.");
        } catch (IllegalArgumentException e) {
            assertEquals("El estado no puede ser nulo o vacío", e.getMessage());
        }
    }

    @Test
    public void testSetMotivoConsultaConValorVacio() {
        Cita cita = new Cita();
        try {
            cita.setMotivoConsulta("");
            fail("Se esperaba una excepción para motivoConsulta vacío.");
        } catch (IllegalArgumentException e) {
            assertEquals("El motivo de consulta no puede ser nulo o vacío", e.getMessage());
        }
    }
}
