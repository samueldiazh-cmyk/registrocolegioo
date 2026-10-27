/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocolegioo.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ColegioTest {

    @Test
    public void testColegioNuevoEstaVacio() {
        Colegio c = new Colegio();
        assertTrue(c.getProfesores().isEmpty());
        assertTrue(c.getEstudiantes().isEmpty());
    }

    @Test
    public void testAgregarProfesoresDeDistintoTipo() {
        Colegio c = new Colegio();
        c.agregarProfesor(new ProfesorPlanta("Ana", "C2", "1", "20/08/1980", "111", "Física", 10000, 100, 5));
        c.agregarProfesor(new ProfesorCatedra("Beto", "C3", "2", "10/01/1990", "222", "Química", 10000, 100, 80000));
        assertEquals(2, c.getProfesores().size());
        assertInstanceOf(ProfesorPlanta.class, c.getProfesores().get(0));
        assertInstanceOf(ProfesorCatedra.class, c.getProfesores().get(1));
    }

    @Test
    public void testAgregarEstudiante() {
        Colegio c = new Colegio();
        Estudiante e = new Estudiante();
        e.setNombre("Luis");
        c.agregarEstudiante(e);
        assertEquals(1, c.getEstudiantes().size());
        assertSame(e, c.getEstudiantes().get(0));
    }
}