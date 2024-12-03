package modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Date;

public class DoctorTest {

    // A. Pruebas para Constructores

    @Test
    public void testConstructorSinParametrosInicializaValoresPorDefecto() {
        Doctor doctor = new Doctor();
        assertEquals(0, doctor.getIdDoctor());
        assertNull(doctor.getCedula());
        assertNull(doctor.getEspecialidad());
        assertEquals(0.0, doctor.getPrecioConsulta(), 0.001);
        assertEquals(0, doctor.getNumConsultorio());
        assertEquals(0, doctor.getIdEmpleado());
        assertNull(doctor.getNombreCompleto());
        assertNull(doctor.getFechaIngreso());
        assertNull(doctor.getCorreoElectronico());
        assertNull(doctor.getNumTelefono());
        assertNull(doctor.getNombreUsuario());
        assertNull(doctor.getContrasena());
    }

    @Test
    public void testConstructorConParametrosInicializaValoresCorrectos() {
        Date fechaIngreso = Date.valueOf("2023-12-01");
        Doctor doctor = new Doctor(
                1, "123456789", "Cardiología", 500.0, 101, 
                10, "Dr. Juan Pérez", fechaIngreso, "juan.perez@mail.com", 
                "1234567890", "j.perez", "password123"
        );

        assertEquals(1, doctor.getIdDoctor());
        assertEquals("123456789", doctor.getCedula());
        assertEquals("Cardiología", doctor.getEspecialidad());
        assertEquals(500.0, doctor.getPrecioConsulta(), 0.001);
        assertEquals(101, doctor.getNumConsultorio());
        assertEquals(10, doctor.getIdEmpleado());
        assertEquals("Dr. Juan Pérez", doctor.getNombreCompleto());
        assertEquals(fechaIngreso, doctor.getFechaIngreso());
        assertEquals("juan.perez@mail.com", doctor.getCorreoElectronico());
        assertEquals("1234567890", doctor.getNumTelefono());
        assertEquals("j.perez", doctor.getNombreUsuario());
        assertEquals("password123", doctor.getContrasena());
    }

    // B. Pruebas para Getters y Setters

    @Test
    public void testSetAndGetIdDoctor() {
        Doctor doctor = new Doctor();
        doctor.setIdDoctor(2);
        assertEquals(2, doctor.getIdDoctor());
    }

    @Test
    public void testSetAndGetCedula() {
        Doctor doctor = new Doctor();
        doctor.setCedula("987654321");
        assertEquals("987654321", doctor.getCedula());
    }

    @Test
    public void testSetAndGetEspecialidad() {
        Doctor doctor = new Doctor();
        doctor.setEspecialidad("Pediatría");
        assertEquals("Pediatría", doctor.getEspecialidad());
    }

    @Test
    public void testSetAndGetPrecioConsulta() {
        Doctor doctor = new Doctor();
        doctor.setPrecioConsulta(300.0);
        assertEquals(300.0, doctor.getPrecioConsulta(), 0.001);
    }

    @Test
    public void testSetAndGetNumConsultorio() {
        Doctor doctor = new Doctor();
        doctor.setNumConsultorio(102);
        assertEquals(102, doctor.getNumConsultorio());
    }

    // C. Pruebas para el Método toString

    @Test
    public void testToStringDevuelveFormatoEsperado() {
        Date fechaIngreso = Date.valueOf("2023-12-01");
        Doctor doctor = new Doctor(
                1, "123456789", "Cardiología", 500.0, 101, 
                10, "Dr. Juan Pérez", fechaIngreso, "juan.perez@mail.com", 
                "1234567890", "j.perez", "password123"
        );

        String esperado = "Doctor{idDoctor=1, cedula='123456789', especialidad='Cardiología', precioConsulta=500.0, " +
                          "numConsultorio=101, idEmpleado=10, nombreCompleto='Dr. Juan Pérez', fechaIngreso=2023-12-01, " +
                          "correoElectronico='juan.perez@mail.com', numTelefono='1234567890', nombreUsuario='j.perez', " +
                          "contrasena='password123'}";
        assertEquals(esperado, doctor.toString());
    }

    // D. Pruebas de Validación 

    @Test
    public void testSetPrecioConsultaConValorNegativo() {
        Doctor doctor = new Doctor();
        try {
            doctor.setPrecioConsulta(-100.0);
            fail("Se esperaba una excepción para precioConsulta negativo.");
        } catch (IllegalArgumentException e) {
            assertEquals("El precio de consulta no puede ser negativo", e.getMessage());
        }
    }

    @Test
    public void testSetCedulaConValorNulo() {
        Doctor doctor = new Doctor();
        try {
            doctor.setCedula(null);
            fail("Se esperaba una excepción para cédula nula.");
        } catch (IllegalArgumentException e) {
            assertEquals("La cédula no puede ser nula o vacía", e.getMessage());
        }
    }
}
