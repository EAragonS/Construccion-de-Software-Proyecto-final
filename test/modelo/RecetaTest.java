package modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class RecetaTest {

    // A. Pruebas para Constructores

    @Test
    public void testConstructorSinParametrosInicializaValoresPorDefecto() {
        Receta receta = new Receta();
        assertEquals(0, receta.getIdReceta());
        assertEquals(0, receta.getIdConsulta());
        assertNull(receta.getNombreMedicamento());
        assertNull(receta.getDosis());
        assertNull(receta.getDuracionConsumo());
    }

    @Test
    public void testConstructorConParametrosInicializaValoresCorrectos() {
        Receta receta = new Receta(
                1, 101, "Paracetamol", "500mg cada 8 horas", "5 días"
        );

        assertEquals(1, receta.getIdReceta());
        assertEquals(101, receta.getIdConsulta());
        assertEquals("Paracetamol", receta.getNombreMedicamento());
        assertEquals("500mg cada 8 horas", receta.getDosis());
        assertEquals("5 días", receta.getDuracionConsumo());
    }

    // B. Pruebas para Getters y Setters

    @Test
    public void testSetAndGetIdReceta() {
        Receta receta = new Receta();
        receta.setIdReceta(2);
        assertEquals(2, receta.getIdReceta());
    }

    @Test
    public void testSetAndGetIdConsulta() {
        Receta receta = new Receta();
        receta.setIdConsulta(202);
        assertEquals(202, receta.getIdConsulta());
    }

    @Test
    public void testSetAndGetNombreMedicamento() {
        Receta receta = new Receta();
        receta.setNombreMedicamento("Ibuprofeno");
        assertEquals("Ibuprofeno", receta.getNombreMedicamento());
    }

    @Test
    public void testSetAndGetDosis() {
        Receta receta = new Receta();
        receta.setDosis("200mg cada 12 horas");
        assertEquals("200mg cada 12 horas", receta.getDosis());
    }

    @Test
    public void testSetAndGetDuracionConsumo() {
        Receta receta = new Receta();
        receta.setDuracionConsumo("7 días");
        assertEquals("7 días", receta.getDuracionConsumo());
    }

    // C. Pruebas para el Método toString

    @Test
    public void testToStringDevuelveFormatoEsperado() {
        Receta receta = new Receta(
                1, 101, "Paracetamol", "500mg cada 8 horas", "5 días"
        );

        String esperado = "Receta{idReceta=1, idConsulta=101, nombreMedicamento='Paracetamol', dosis='500mg cada 8 horas', duracionConsumo='5 días'}";
        assertEquals(esperado, receta.toString());
    }

    // D. Pruebas de Validación 

    @Test
    public void testSetIdRecetaConValorNegativo() {
        Receta receta = new Receta();
        try {
            receta.setIdReceta(-1);
            fail("Se esperaba una excepción para idReceta negativo.");
        } catch (IllegalArgumentException e) {
            assertEquals("El idReceta no puede ser negativo", e.getMessage());
        }
    }

    @Test
    public void testSetNombreMedicamentoConValorNulo() {
        Receta receta = new Receta();
        try {
            receta.setNombreMedicamento(null);
            fail("Se esperaba una excepción para nombreMedicamento nulo.");
        } catch (IllegalArgumentException e) {
            assertEquals("El nombre del medicamento no puede ser nulo o vacío", e.getMessage());
        }
    }

    @Test
    public void testSetDosisConValorVacio() {
        Receta receta = new Receta();
        try {
            receta.setDosis("");
            fail("Se esperaba una excepción para dosis vacía.");
        } catch (IllegalArgumentException e) {
            assertEquals("La dosis no puede ser nula o vacía", e.getMessage());
        }
    }
}
