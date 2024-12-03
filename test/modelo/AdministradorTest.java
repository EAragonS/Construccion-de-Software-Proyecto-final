package modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class AdministradorTest {

    // A. Pruebas para Constructores

    @Test
    public void testConstructorInicializaValoresCorrectos() {
        Administrador admin = new Administrador(1, "Juan Pérez");
        assertEquals(1, admin.getIdAdministrador());
        assertEquals("Juan Pérez", admin.getNombre());
    }

    // B. Pruebas para Getters y Setters

    @Test
    public void testSetAndGetIdAdministrador() {
        Administrador admin = new Administrador(0, "");
        admin.setIdAdministrador(10);
        assertEquals(10, admin.getIdAdministrador());
    }

    @Test
    public void testSetAndGetNombre() {
        Administrador admin = new Administrador(0, "");
        admin.setNombre("Ana Gómez");
        assertEquals("Ana Gómez", admin.getNombre());
    }

    // C. Pruebas para el Método toString

    @Test
    public void testToStringDevuelveFormatoEsperado() {
        Administrador admin = new Administrador(2, "Carlos López");
        String esperado = "Administrador{idAdministrador=2, nombre='Carlos López'}";
        assertEquals(esperado, admin.toString());
    }

    // D. Pruebas de Validación

    @Test
    public void testSetIdAdministradorConValorNegativo() {
        Administrador admin = new Administrador(0, "Test");
        try {
            admin.setIdAdministrador(-1);
            fail("Se esperaba una excepción para idAdministrador negativo.");
        } catch (IllegalArgumentException e) {
            assertEquals("idAdministrador no puede ser negativo", e.getMessage());
        }
    }

    @Test
    public void testSetNombreConValorNulo() {
        Administrador admin = new Administrador(0, "Test");
        try {
            admin.setNombre(null);
            fail("Se esperaba una excepción para nombre nulo.");
        } catch (IllegalArgumentException e) {
            assertEquals("El nombre no puede ser nulo o vacío", e.getMessage());
        }
    }

    @Test
    public void testSetNombreConValorVacio() {
        Administrador admin = new Administrador(0, "Test");
        try {
            admin.setNombre("");
            fail("Se esperaba una excepción para nombre vacío.");
        } catch (IllegalArgumentException e) {
            assertEquals("El nombre no puede ser nulo o vacío", e.getMessage());
        }
    }
}
