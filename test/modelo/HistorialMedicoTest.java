package modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class HistorialMedicoTest {

    // A. Pruebas para Constructores

    @Test
    public void testConstructorSinParametrosInicializaValoresPorDefecto() {
        HistorialMedico historial = new HistorialMedico();
        assertEquals(0, historial.getIdHistorial());
        assertEquals(0, historial.getIdPaciente());
        assertNull(historial.getEnfermedadesPrevias());
        assertNull(historial.getAlergias());
        assertNull(historial.getHistorialFamiliar());
        assertNull(historial.getCondicionesCronicas());
        assertNull(historial.getMedicacionActual());
    }

    @Test
    public void testConstructorConParametrosInicializaValoresCorrectos() {
        HistorialMedico historial = new HistorialMedico(
                1, 100, "Diabetes", "Polen", "Hipertensión", 
                "Artritis", "Metformina"
        );

        assertEquals(1, historial.getIdHistorial());
        assertEquals(100, historial.getIdPaciente());
        assertEquals("Diabetes", historial.getEnfermedadesPrevias());
        assertEquals("Polen", historial.getAlergias());
        assertEquals("Hipertensión", historial.getHistorialFamiliar());
        assertEquals("Artritis", historial.getCondicionesCronicas());
        assertEquals("Metformina", historial.getMedicacionActual());
    }

    // B. Pruebas para Getters y Setters

    @Test
    public void testSetAndGetIdHistorial() {
        HistorialMedico historial = new HistorialMedico();
        historial.setIdHistorial(5);
        assertEquals(5, historial.getIdHistorial());
    }

    @Test
    public void testSetAndGetIdPaciente() {
        HistorialMedico historial = new HistorialMedico();
        historial.setIdPaciente(200);
        assertEquals(200, historial.getIdPaciente());
    }

    @Test
    public void testSetAndGetEnfermedadesPrevias() {
        HistorialMedico historial = new HistorialMedico();
        historial.setEnfermedadesPrevias("Asma");
        assertEquals("Asma", historial.getEnfermedadesPrevias());
    }

    @Test
    public void testSetAndGetAlergias() {
        HistorialMedico historial = new HistorialMedico();
        historial.setAlergias("Gluten");
        assertEquals("Gluten", historial.getAlergias());
    }

    @Test
    public void testSetAndGetHistorialFamiliar() {
        HistorialMedico historial = new HistorialMedico();
        historial.setHistorialFamiliar("Cáncer");
        assertEquals("Cáncer", historial.getHistorialFamiliar());
    }

    @Test
    public void testSetAndGetCondicionesCronicas() {
        HistorialMedico historial = new HistorialMedico();
        historial.setCondicionesCronicas("Hipotiroidismo");
        assertEquals("Hipotiroidismo", historial.getCondicionesCronicas());
    }

    @Test
    public void testSetAndGetMedicacionActual() {
        HistorialMedico historial = new HistorialMedico();
        historial.setMedicacionActual("Ibuprofeno");
        assertEquals("Ibuprofeno", historial.getMedicacionActual());
    }

    // C. Pruebas para el Método toString

    @Test
    public void testToStringDevuelveFormatoEsperado() {
        HistorialMedico historial = new HistorialMedico(
                1, 100, "Diabetes", "Polen", "Hipertensión", 
                "Artritis", "Metformina"
        );

        String esperado = "HistorialMedico{idHistorial=1, idPaciente=100, enfermedadesPrevias='Diabetes', alergias='Polen', historialFamiliar='Hipertensión', condicionesCronicas='Artritis', medicacionActual='Metformina'}";
        assertEquals(esperado, historial.toString());
    }

    // D. Pruebas de Validación 

    @Test
    public void testSetIdHistorialConValorNegativo() {
        HistorialMedico historial = new HistorialMedico();
        try {
            historial.setIdHistorial(-1);
            fail("Se esperaba una excepción para idHistorial negativo.");
        } catch (IllegalArgumentException e) {
            assertEquals("El idHistorial no puede ser negativo", e.getMessage());
        }
    }

    @Test
    public void testSetEnfermedadesPreviasConValorNulo() {
        HistorialMedico historial = new HistorialMedico();
        try {
            historial.setEnfermedadesPrevias(null);
            fail("Se esperaba una excepción para enfermedadesPrevias nulo.");
        } catch (IllegalArgumentException e) {
            assertEquals("Las enfermedades previas no pueden ser nulas o vacías", e.getMessage());
        }
    }
}
