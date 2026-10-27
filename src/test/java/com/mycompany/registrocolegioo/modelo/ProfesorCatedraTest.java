/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocolegioo.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProfesorCatedraTest {

    private ProfesorCatedra catedra;

    @BeforeEach
    public void setUp() {
        catedra = new ProfesorCatedra("Beto", "Calle 3", "3003333333", "10/01/1990",
                "222", "Química", 10000, 100, 80000);
    }

    @Test
    public void testPagoSumaAuxilioDeTransporte() {
       
        assertEquals(80000, catedra.getAuxilioTransporte(), 0.01);
        assertEquals(1380000, catedra.calcularPago(), 0.01);
    }

    @Test
    public void testPolimorfismoPrestacionesUsanElPagoDeCatedra() {
        Profesor p = catedra;
        
        assertEquals(262200, p.calcularPrestaciones(), 0.01);
        assertTrue(p.mostrarInfo().contains("Cátedra"));
    }
}