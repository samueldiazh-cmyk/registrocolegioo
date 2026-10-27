/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrocolegioo;

/**
 *
 * @author cdval
 */


import com.mycompany.registrocolegioo.modelo.controlador.vista.Estudiante;
import com.mycompany.registrocolegioo.modelo.controlador.vista.VentanaPrincipal;

public class Registrocolegioo {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            VentanaPrincipal profesores = new VentanaPrincipal();
            profesores.setTitle("Registro de profesores");
            profesores.setLocation(100, 100);
            profesores.setVisible(true);

            Estudiante estudiantes = new Estudiante();
            estudiantes.setTitle("Registro de estudiantes");
            estudiantes.setLocation(700, 100);
            estudiantes.setVisible(true);
        });
    }
}