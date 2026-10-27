/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocolegioo.modelo;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

/**
 *
 * @author cdval
 */

public class PersonaTest {

    @Test
    public void testCalcularEdadRespetaElCumpleanios() {
        Persona p = new Persona();
        p.setFechaNacimiento("15/06/2000");
        
        assertEquals(25, p.calcularEdad(LocalDate.of(2026, 6, 14)));
        
        assertEquals(26, p.calcularEdad(LocalDate.of(2026, 6, 15)));
    }

    @Test
    public void testCalcularEdadConFechaInvalidaLanzaError() {
        Persona p = new Persona();
        p.setFechaNacimiento("2000-06-15");
        assertThrows(Exception.class, () -> p.calcularEdad());
    }

    @Test
    public void testMostrarInfoIncluyeLosDatos() {
        Persona p = new Persona();
        p.setNombre("Ana");
        p.setDireccion("Calle 1");
        p.setTelefono("3001234567");
        p.setFechaNacimiento("15/06/2000");
        String info = p.mostrarInfo();
        assertTrue(info.contains("Ana"));
        assertTrue(info.contains("Calle 1"));
        assertTrue(info.contains("3001234567"));
        assertTrue(info.contains("15/06/2000"));
    }
}
