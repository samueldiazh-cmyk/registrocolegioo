/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.registrocolegioo.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EstudianteTest {

    @Test
    public void testGettersDevuelvenLosDatos() {
        Estudiante e = new Estudiante();
        e.setCodigo("E001");
        e.setGrado("10A");
        e.setAcudiente("María López");
        assertEquals("E001", e.getCodigo());
        assertEquals("10A", e.getGrado());
        assertEquals("María López", e.getAcudiente());
    }

    @Test
    public void testEstudianteHeredaDePersona() {
        Persona p = new Estudiante();
        assertInstanceOf(Estudiante.class, p);
    }

    @Test
    public void testMostrarInfoIncluyeDatosDePersonaYDeEstudiante() {
        Estudiante e = new Estudiante();
        e.setNombre("Luis");
        e.setFechaNacimiento("10/05/2012");
        e.setCodigo("E001");
        e.setGrado("8B");
        e.setAcudiente("Pedro");
        String info = e.mostrarInfo();
        assertTrue(info.contains("Luis"));
        assertTrue(info.contains("E001"));
        assertTrue(info.contains("8B"));
        assertTrue(info.contains("Pedro"));
    }
}