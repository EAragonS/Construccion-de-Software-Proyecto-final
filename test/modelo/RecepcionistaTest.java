package modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Date;

public class RecepcionistaTest {

    // A. Pruebas para Constructores

    @Test
    public void testConstructorSinParametrosInicializaValoresPorDefecto() {
        Recepcionista recepcionista = new Recepcionista();
        assertEquals(0, recepcionista.getIdRecepcionista());
        assertEquals(0, recepcionista.getIdEmpleado());
        assertNull(recepcionista.getNombreCompleto());
        assertNull(recepcionista.getFechaIngreso());
        assertNull(recepcionista.getCorreoElectronico());
        assertNull(recepcionista.getNumTelefono());
        assertNull(recepcionista.getNombreUsuario());
        assertNull(recepcionista.getContrasena());
    }

    @Test
    public void testConstructorConParametrosInicializaValoresCorrectos() {
        Date fechaIngreso = Date.valueOf("2023-12-01");
        Recepcionista recepcionista = new Recepcionista(
                1, 10, "Ana Gómez", fechaIngreso, "ana.gomez@mail.com", 
                "1234567890", "anagomez", "password123"
        );

        assertEquals(1, recepcionista.getIdRecepcionista());
        assertEquals(10, recepcionista.getIdEmpleado());
        assertEquals("Ana Gómez", recepcionista.getNombreCompleto());
        assertEquals(fechaIngreso, recepcionista.getFechaIngreso());
        assertEquals("ana.gomez@mail.com", recepcionista.getCorreoElectronico());
        assertEquals("1234567890", recepcionista.getNumTelefono());
        assertEquals("anagomez", recepcionista.getNombreUsuario());
        assertEquals("password123", recepcionista.getContrasena());
    }

    // B. Pruebas para Getters y Setters

    @Test
    public void testSetAndGetIdRecepcionista() {
        Recepcionista recepcionista = new Recepcionista();
        recepcionista.setIdRecepcionista(2);
        assertEquals(2, recepcionista.getIdRecepcionista());
    }

    @Test
    public void testSetAndGetIdEmpleado() {
        Recepcionista recepcionista = new Recepcionista();
        recepcionista.setIdEmpleado(20);
        assertEquals(20, recepcionista.getIdEmpleado());
    }

    @Test
    public void testSetAndGetNombreCompleto() {
        Recepcionista recepcionista = new Recepcionista();
        recepcionista.setNombreCompleto("Carlos López");
        assertEquals("Carlos López", recepcionista.getNombreCompleto());
    }

    @Test
    public void testSetAndGetFechaIngreso() {
        Recepcionista recepcionista = new Recepcionista();
        Date fechaIngreso = Date.valueOf("2023-11-30");
        recepcionista.setFechaIngreso(fechaIngreso);
        assertEquals(fechaIngreso, recepcionista.getFechaIngreso());
    }

    @Test
    public void testSetAndGetCorreoElectronico() {
        Recepcionista recepcionista = new Recepcionista();
        recepcionista.setCorreoElectronico("carlos.lopez@mail.com");
        assertEquals("carlos.lopez@mail.com", recepcionista.getCorreoElectronico());
    }

    @Test
    public void testSetAndGetNumTelefono() {
        Recepcionista recepcionista = new Recepcionista();
        recepcionista.setNumTelefono("987654321");
        assertEquals("987654321", recepcionista.getNumTelefono());
    }

    @Test
    public void testSetAndGetNombreUsuario() {
        Recepcionista recepcionista = new Recepcionista();
        recepcionista.setNombreUsuario("carloslopez");
        assertEquals("carloslopez", recepcionista.getNombreUsuario());
    }

    @Test
    public void testSetAndGetContrasena() {
        Recepcionista recepcionista = new Recepcionista();
        recepcionista.setContrasena("securepassword");
        assertEquals("securepassword", recepcionista.getContrasena());
    }

    // C. Pruebas para el Método toString

    @Test
    public void testToStringDevuelveFormatoEsperado() {
        Date fechaIngreso = Date.valueOf("2023-12-01");
        Recepcionista recepcionista = new Recepcionista(
                1, 10, "Ana Gómez", fechaIngreso, "ana.gomez@mail.com", 
                "1234567890", "anagomez", "password123"
        );

        String esperado = "Recepcionista{idRecepcionista=1, Empleado{idEmpleado=10, nombreCompleto='Ana Gómez', fechaIngreso=2023-12-01, correoElectronico='ana.gomez@mail.com', numTelefono='1234567890', nombreUsuario='anagomez', contrasena='password123'}}";
        assertEquals(esperado, recepcionista.toString());
    }

    // D. Pruebas de Validación 
    @Test
    public void testSetIdRecepcionistaConValorNegativo() {
        Recepcionista recepcionista = new Recepcionista();
        try {
            recepcionista.setIdRecepcionista(-1);
            fail("Se esperaba una excepción para idRecepcionista negativo.");
        } catch (IllegalArgumentException e) {
            assertEquals("El idRecepcionista no puede ser negativo", e.getMessage());
        }
    }

    @Test
    public void testSetCorreoElectronicoConValorInvalido() {
        Recepcionista recepcionista = new Recepcionista();
        try {
            recepcionista.setCorreoElectronico("invalido");
            fail("Se esperaba una excepción para un correo inválido.");
        } catch (IllegalArgumentException e) {
            assertEquals("El correo electrónico no es válido", e.getMessage());
        }
    }
}
