package modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Date;

public class EmpleadoTest {

    // A. Pruebas para Constructores

    @Test
    public void testConstructorSinParametrosInicializaValoresPorDefecto() {
        Empleado empleado = new Empleado();
        assertEquals(0, empleado.getIdEmpleado());
        assertNull(empleado.getNombreCompleto());
        assertNull(empleado.getFechaIngreso());
        assertNull(empleado.getCorreoElectronico());
        assertNull(empleado.getNumTelefono());
        assertNull(empleado.getNombreUsuario());
        assertNull(empleado.getContrasena());
    }

    @Test
    public void testConstructorConParametrosInicializaValoresCorrectos() {
        Date fechaIngreso = Date.valueOf("2023-12-01");
        Empleado empleado = new Empleado(
                1, "Juan Pérez", fechaIngreso, "juan.perez@mail.com", 
                "1234567890", "juanperez", "password123"
        );

        assertEquals(1, empleado.getIdEmpleado());
        assertEquals("Juan Pérez", empleado.getNombreCompleto());
        assertEquals(fechaIngreso, empleado.getFechaIngreso());
        assertEquals("juan.perez@mail.com", empleado.getCorreoElectronico());
        assertEquals("1234567890", empleado.getNumTelefono());
        assertEquals("juanperez", empleado.getNombreUsuario());
        assertEquals("password123", empleado.getContrasena());
    }

    // B. Pruebas para Getters y Setters

    @Test
    public void testSetAndGetIdEmpleado() {
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(2);
        assertEquals(2, empleado.getIdEmpleado());
    }

    @Test
    public void testSetAndGetNombreCompleto() {
        Empleado empleado = new Empleado();
        empleado.setNombreCompleto("Ana Gómez");
        assertEquals("Ana Gómez", empleado.getNombreCompleto());
    }

    @Test
    public void testSetAndGetFechaIngreso() {
        Empleado empleado = new Empleado();
        Date fechaIngreso = Date.valueOf("2023-12-15");
        empleado.setFechaIngreso(fechaIngreso);
        assertEquals(fechaIngreso, empleado.getFechaIngreso());
    }

    @Test
    public void testSetAndGetCorreoElectronico() {
        Empleado empleado = new Empleado();
        empleado.setCorreoElectronico("ana.gomez@mail.com");
        assertEquals("ana.gomez@mail.com", empleado.getCorreoElectronico());
    }

    @Test
    public void testSetAndGetNumTelefono() {
        Empleado empleado = new Empleado();
        empleado.setNumTelefono("987654321");
        assertEquals("987654321", empleado.getNumTelefono());
    }

    @Test
    public void testSetAndGetNombreUsuario() {
        Empleado empleado = new Empleado();
        empleado.setNombreUsuario("anagomez");
        assertEquals("anagomez", empleado.getNombreUsuario());
    }

    @Test
    public void testSetAndGetContrasena() {
        Empleado empleado = new Empleado();
        empleado.setContrasena("securepassword");
        assertEquals("securepassword", empleado.getContrasena());
    }

    // C. Pruebas para el Método toString

    @Test
    public void testToStringDevuelveFormatoEsperado() {
        Date fechaIngreso = Date.valueOf("2023-12-01");
        Empleado empleado = new Empleado(
                1, "Juan Pérez", fechaIngreso, "juan.perez@mail.com", 
                "1234567890", "juanperez", "password123"
        );

        String esperado = "Empleado{idEmpleado=1, nombreCompleto='Juan Pérez', fechaIngreso=2023-12-01, correoElectronico='juan.perez@mail.com', numTelefono='1234567890', nombreUsuario='juanperez', contrasena='password123'}";
        assertEquals(esperado, empleado.toString());
    }

    // D. Pruebas de Validación 

    @Test
    public void testSetCorreoElectronicoConValorInvalido() {
        Empleado empleado = new Empleado();
        try {
            empleado.setCorreoElectronico("invalido");
            fail("Se esperaba una excepción para un correo inválido.");
        } catch (IllegalArgumentException e) {
            assertEquals("El correo electrónico no es válido", e.getMessage());
        }
    }

    @Test
    public void testSetContrasenaConValorVacio() {
        Empleado empleado = new Empleado();
        try {
            empleado.setContrasena("");
            fail("Se esperaba una excepción para contraseña vacía.");
        } catch (IllegalArgumentException e) {
            assertEquals("La contraseña no puede ser nula o vacía", e.getMessage());
        }
    }
}
