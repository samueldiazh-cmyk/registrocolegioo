/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocolegioo.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProfesorPlantaTest {

    private ProfesorPlanta planta;

    @BeforeEach
    public void setUp() {
        planta = new ProfesorPlanta("Ana", "Calle 2", "3002222222", "20/08/1980",
                "111", "Física", 10000, 100, 5);
    }

    @Test
    public void testPagoIncluyeBonificacionPorAntiguedad() {
        
        assertEquals(130000, planta.calcularBonificacion(), 0.01);
        assertEquals(1430000, planta.calcularPago(), 0.01);
    }

    @Test
    public void testBonificacionSobrecargadaConPagoBase() {
        // 1.000.000 * 2% * 5 = 100.000
        assertEquals(100000, planta.calcularBonificacion(1000000), 0.01);
    }

    @Test
    public void testPolimorfismoPrestacionesUsanElPagoDePlanta() {
        Profesor p = planta;
        
        assertEquals(271700, p.calcularPrestaciones(), 0.01);
        assertTrue(p.mostrarInfo().contains("Planta"));
    }
}