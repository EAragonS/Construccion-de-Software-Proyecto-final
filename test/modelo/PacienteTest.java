package modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;

public class PacienteTest {

    // A. Pruebas para Constructores

    @Test
    public void testConstructorSinParametrosInicializaValoresPorDefecto() {
        Paciente paciente = new Paciente();
        assertEquals(0, paciente.getIdPaciente());
        assertNull(paciente.getNombreCompletoP());
        assertNull(paciente.getSexo());
        assertNull(paciente.getFechaNacimiento());
        assertNull(paciente.getCorreoElectronicoP());
        assertNull(paciente.getNumeroTelefonoP());
        assertNull(paciente.getNombreContactoEmergencia());
        assertNull(paciente.getNumTelefonoContactoEmergencia());
    }

    @Test
    public void testConstructorConParametrosInicializaValoresCorrectos() {
        Date fechaNacimiento = new Date(90, 4, 15); // 15 de mayo de 1990
        Paciente paciente = new Paciente(
                1, "Juan Pérez", "Masculino", fechaNacimiento,
                "juan.perez@mail.com", "1234567890",
                "Ana López", "0987654321"
        );

        assertEquals(1, paciente.getIdPaciente());
        assertEquals("Juan Pérez", paciente.getNombreCompletoP());
        assertEquals("Masculino", paciente.getSexo());
        assertEquals(fechaNacimiento, paciente.getFechaNacimiento());
        assertEquals("juan.perez@mail.com", paciente.getCorreoElectronicoP());
        assertEquals("1234567890", paciente.getNumeroTelefonoP());
        assertEquals("Ana López", paciente.getNombreContactoEmergencia());
        assertEquals("0987654321", paciente.getNumTelefonoContactoEmergencia());
    }

    // B. Pruebas para Getters y Setters

    @Test
    public void testSetAndGetIdPaciente() {
        Paciente paciente = new Paciente();
        paciente.setIdPaciente(2);
        assertEquals(2, paciente.getIdPaciente());
    }

    @Test
    public void testSetAndGetNombreCompletoP() {
        Paciente paciente = new Paciente();
        paciente.setNombreCompletoP("María Gómez");
        assertEquals("María Gómez", paciente.getNombreCompletoP());
    }

    @Test
    public void testSetAndGetSexo() {
        Paciente paciente = new Paciente();
        paciente.setSexo("Femenino");
        assertEquals("Femenino", paciente.getSexo());
    }

    @Test
    public void testSetAndGetFechaNacimiento() {
        Paciente paciente = new Paciente();
        Date fechaNacimiento = new Date(95, 11, 25); // 25 de diciembre de 1995
        paciente.setFechaNacimiento(fechaNacimiento);
        assertEquals(fechaNacimiento, paciente.getFechaNacimiento());
    }

    @Test
    public void testSetAndGetCorreoElectronicoP() {
        Paciente paciente = new Paciente();
        paciente.setCorreoElectronicoP("maria.gomez@mail.com");
        assertEquals("maria.gomez@mail.com", paciente.getCorreoElectronicoP());
    }

    @Test
    public void testSetAndGetNumeroTelefonoP() {
        Paciente paciente = new Paciente();
        paciente.setNumeroTelefonoP("123456789");
        assertEquals("123456789", paciente.getNumeroTelefonoP());
    }

    @Test
    public void testSetAndGetNombreContactoEmergencia() {
        Paciente paciente = new Paciente();
        paciente.setNombreContactoEmergencia("Carlos López");
        assertEquals("Carlos López", paciente.getNombreContactoEmergencia());
    }

    @Test
    public void testSetAndGetNumTelefonoContactoEmergencia() {
        Paciente paciente = new Paciente();
        paciente.setNumTelefonoContactoEmergencia("987654321");
        assertEquals("987654321", paciente.getNumTelefonoContactoEmergencia());
    }

    // C. Pruebas para Validaciones 

    @Test
    public void testSetIdPacienteConValorNegativo() {
        Paciente paciente = new Paciente();
        try {
            paciente.setIdPaciente(-1);
            fail("Se esperaba una excepción para idPaciente negativo.");
        } catch (IllegalArgumentException e) {
            assertEquals("El idPaciente no puede ser negativo", e.getMessage());
        }
    }

    @Test
    public void testSetSexoConValorInvalido() {
        Paciente paciente = new Paciente();
        try {
            paciente.setSexo("Otro");
            fail("Se esperaba una excepción para sexo inválido.");
        } catch (IllegalArgumentException e) {
            assertEquals("El sexo debe ser 'Masculino' o 'Femenino'", e.getMessage());
        }
    }

    @Test
    public void testSetCorreoElectronicoPConValorInvalido() {
        Paciente paciente = new Paciente();
        try {
            paciente.setCorreoElectronicoP("invalido");
            fail("Se esperaba una excepción para un correo inválido.");
        } catch (IllegalArgumentException e) {
            assertEquals("El correo electrónico no es válido", e.getMessage());
        }
    }
}
