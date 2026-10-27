/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocolegioo.controlador;

import static org.junit.jupiter.api.Assertions.*;

import com.mycompany.registrocolegioo.modelo.Colegio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControladorColegioTest {

    private ControladorColegio controlador;

    @BeforeEach
    public void setUp() {
       
        controlador = new ControladorColegio(new Colegio());
    }

    @Test
    public void testRegistrarProfesorDePlanta() {
        String msg = controlador.registrarProfesor("Ana", "C2", "1", "20/08/1980",
                "111", "Física", "10000", "100", "Planta", "5");
        assertEquals("Profesor registrado correctamente.", msg);
        assertEquals(1, controlador.getColegio().getProfesores().size());
    }

    @Test
    public void testRegistrarProfesorDeCatedra() {
        String msg = controlador.registrarProfesor("Beto", "C3", "2", "10/01/1990",
                "222", "Química", "10000", "100", "Catedra", "80000");
        assertEquals("Profesor registrado correctamente.", msg);
        assertEquals(1, controlador.getColegio().getProfesores().size());
    }

    @Test
    public void testNoRegistraProfesorMenorDeEdad() {
        String msg = controlador.registrarProfesor("Juan", "C1", "3", "01/01/2015",
                "333", "Arte", "10000", "100", "Planta", "1");
        assertEquals("Error: el profesor debe ser mayor de edad.", msg);
        assertTrue(controlador.getColegio().getProfesores().isEmpty());
    }

    @Test
    public void testNoRegistraProfesorConSalarioNoNumerico() {
        String msg = controlador.registrarProfesor("Ana", "C2", "1", "20/08/1980",
                "111", "Física", "diez mil", "100", "Planta", "5");
        assertTrue(msg.startsWith("Error"));
        assertTrue(controlador.getColegio().getProfesores().isEmpty());
    }

    @Test
    public void testNoRegistraEstudianteConFechaInvalida() {
        String msg = controlador.registrarEstudiante("Luis", "C8", "300",
                "2012-05-10", "E001", "8B", "Pedro");
        assertEquals("Error: revise la fecha (formato dd/mm/aaaa).", msg);
        assertTrue(controlador.getColegio().getEstudiantes().isEmpty());
    }

    @Test
    public void testReporteEstudiantesListaLosRegistrados() {
        assertEquals("No hay estudiantes registrados.", controlador.reporteEstudiantes());
        controlador.registrarEstudiante("Luis", "C8", "300", "10/05/2012", "E001", "8B", "Pedro");
        controlador.registrarEstudiante("Ana", "C9", "301", "11/06/2013", "E002", "7A", "Rosa");
        String reporte = controlador.reporteEstudiantes();
        assertTrue(reporte.contains("Luis"));
        assertTrue(reporte.contains("Ana"));
        assertTrue(reporte.contains("Total estudiantes: 2"));
    }

    @Test
    public void testReporteProfesoresOrdenadoDeMayorAMenorSalario() {
        // Se registran en desorden a propósito
        controlador.registrarProfesor("Beto", "C3", "2", "10/01/1990",
                "222", "Química", "10000", "100", "Catedra", "80000");   
        controlador.registrarProfesor("Carlos", "C4", "4", "15/03/1985",
                "444", "Arte", "10000", "50", "Planta", "0");           
        controlador.registrarProfesor("Ana", "C2", "1", "20/08/1980",
                "111", "Física", "10000", "100", "Planta", "5");          
        String reporte = controlador.reporteProfesoresPorSalario();
        int posAna = reporte.indexOf("Nombre: Ana");
        int posBeto = reporte.indexOf("Nombre: Beto");
        int posCarlos = reporte.indexOf("Nombre: Carlos");
        assertTrue(posAna >= 0 && posAna < posBeto && posBeto < posCarlos);
    }

    @Test
    public void testReporteProfesoresIncluyeTotalDePrestaciones() {
        controlador.registrarProfesor("Ana", "C2", "1", "20/08/1980",
                "111", "Física", "10000", "100", "Planta", "5");          
        controlador.registrarProfesor("Beto", "C3", "2", "10/01/1990",
                "222", "Química", "10000", "100", "Catedra", "80000");   
        String reporte = controlador.reporteProfesoresPorSalario();
        assertTrue(reporte.contains("Total prestaciones sociales: $" + String.format("%,.2f", 533900.0)));
    }
}