package modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class MedicamentoPrescritoTest {

    // A. Pruebas para Constructores

    @Test
    public void testConstructorSinParametrosInicializaValoresPorDefecto() {
        MedicamentoPrescrito medicamento = new MedicamentoPrescrito();
        assertEquals(0, medicamento.getIdReceta());
        assertEquals(0, medicamento.getIdMedicamento());
        assertNull(medicamento.getNombreMedicamento());
        assertNull(medicamento.getDosis());
        assertNull(medicamento.getDuracionConsumo());
    }

    @Test
    public void testConstructorConParametrosInicializaValoresCorrectos() {
        MedicamentoPrescrito medicamento = new MedicamentoPrescrito(
                1, 101, "Paracetamol", "500mg cada 8 horas", "5 días"
        );

        assertEquals(1, medicamento.getIdReceta());
        assertEquals(101, medicamento.getIdMedicamento());
        assertEquals("Paracetamol", medicamento.getNombreMedicamento());
        assertEquals("500mg cada 8 horas", medicamento.getDosis());
        assertEquals("5 días", medicamento.getDuracionConsumo());
    }

    // B. Pruebas para Getters y Setters

    @Test
    public void testSetAndGetIdReceta() {
        MedicamentoPrescrito medicamento = new MedicamentoPrescrito();
        medicamento.setIdReceta(2);
        assertEquals(2, medicamento.getIdReceta());
    }

    @Test
    public void testSetAndGetIdMedicamento() {
        MedicamentoPrescrito medicamento = new MedicamentoPrescrito();
        medicamento.setIdMedicamento(202);
        assertEquals(202, medicamento.getIdMedicamento());
    }

    @Test
    public void testSetAndGetNombreMedicamento() {
        MedicamentoPrescrito medicamento = new MedicamentoPrescrito();
        medicamento.setNombreMedicamento("Ibuprofeno");
        assertEquals("Ibuprofeno", medicamento.getNombreMedicamento());
    }

    @Test
    public void testSetAndGetDosis() {
        MedicamentoPrescrito medicamento = new MedicamentoPrescrito();
        medicamento.setDosis("200mg cada 12 horas");
        assertEquals("200mg cada 12 horas", medicamento.getDosis());
    }

    @Test
    public void testSetAndGetDuracionConsumo() {
        MedicamentoPrescrito medicamento = new MedicamentoPrescrito();
        medicamento.setDuracionConsumo("7 días");
        assertEquals("7 días", medicamento.getDuracionConsumo());
    }

    // C. Pruebas para el Método toString

    @Test
    public void testToStringDevuelveFormatoEsperado() {
        MedicamentoPrescrito medicamento = new MedicamentoPrescrito(
                1, 101, "Paracetamol", "500mg cada 8 horas", "5 días"
        );

        String esperado = "MedicamentoPrescrito{idReceta=1, idMedicamento=101, nombreMedicamento='Paracetamol', dosis='500mg cada 8 horas', duracionConsumo='5 días'}";
        assertEquals(esperado, medicamento.toString());
    }

    // D. Pruebas de Validación 
    @Test
    public void testSetIdRecetaConValorNegativo() {
        MedicamentoPrescrito medicamento = new MedicamentoPrescrito();
        try {
            medicamento.setIdReceta(-1);
            fail("Se esperaba una excepción para idReceta negativo.");
        } catch (IllegalArgumentException e) {
            assertEquals("El idReceta no puede ser negativo", e.getMessage());
        }
    }

    @Test
    public void testSetNombreMedicamentoConValorNulo() {
        MedicamentoPrescrito medicamento = new MedicamentoPrescrito();
        try {
            medicamento.setNombreMedicamento(null);
            fail("Se esperaba una excepción para nombreMedicamento nulo.");
        } catch (IllegalArgumentException e) {
            assertEquals("El nombre del medicamento no puede ser nulo o vacío", e.getMessage());
        }
    }

    @Test
    public void testSetDosisConValorVacio() {
        MedicamentoPrescrito medicamento = new MedicamentoPrescrito();
        try {
            medicamento.setDosis("");
            fail("Se esperaba una excepción para dosis vacía.");
        } catch (IllegalArgumentException e) {
            assertEquals("La dosis no puede ser nula o vacía", e.getMessage());
        }
    }
}

