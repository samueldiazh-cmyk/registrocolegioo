/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocolegioo.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProfesorTest {

    private Profesor profesor;

    @BeforeEach
    public void setUp() {
        profesor = new Profesor("Carlos", "Calle 5", "3105555555", "15/03/1985",
                "123456", "Matemáticas", 10000, 100);
    }

    @Test
    public void testPagoIncluyeTreintaPorCientoDePreparacion() {
        // 10.000 * 100 = 1.000.000 + 30% = 1.300.000
        assertEquals(1300000, profesor.calcularPago(), 0.01);
    }

    @Test
    public void testPagoSobrecargadoSumaBonificacion() {
        // 1.300.000 + 50.000 = 1.350.000
        assertEquals(1350000, profesor.calcularPago(50000), 0.01);
    }

    @Test
    public void testPrestacionesSonDiecinuevePorCientoDelPago() {
        // 1.300.000 * 19% = 247.000
        assertEquals(247000, profesor.calcularPrestaciones(), 0.01);
    }
}