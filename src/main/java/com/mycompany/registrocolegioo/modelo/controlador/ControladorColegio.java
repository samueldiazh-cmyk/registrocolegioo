/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocolegioo.controlador;

import com.mycompany.registrocolegioo.modelo.Colegio;
import com.mycompany.registrocolegioo.modelo.Estudiante;
import com.mycompany.registrocolegioo.modelo.Profesor;
import java.util.ArrayList;

public class ControladorColegio {

    private Colegio colegio = new Colegio();

    public Colegio getColegio() {
        return colegio;
    }

    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }
public String registrarProfesor(String nombre, String direccion, String telefono,
            String fechaNac, String cedula, String area, String salarioHora, String horas) {
        try {
            double salario = Double.parseDouble(salarioHora);
            int numHoras = Integer.parseInt(horas);
            Profesor p = new Profesor(nombre, direccion, telefono, fechaNac,
                    cedula, area, salario, numHoras);
            if (p.calcularEdad() < 18) {
                return "Error: el profesor debe ser mayor de edad.";
            }
            colegio.agregarProfesor(p);
            return "Profesor registrado correctamente.";
        } catch (NumberFormatException e) {
            return "Error: salario y horas deben ser números.";
        } catch (Exception e) {
            return "Error: revise la fecha (formato dd/mm/aaaa).";
        }
    }
public String registrarEstudiante(String nombre, String direccion, String telefono,
            String fechaNac, String codigo, String grado, String acudiente) {
        try {
            Estudiante e = new Estudiante();
            e.setNombre(nombre);
            e.setDireccion(direccion);
            e.setTelefono(telefono);
            e.setFechaNacimiento(fechaNac);
            e.setCodigo(codigo);
            e.setGrado(grado);
            e.setAcudiente(acudiente);
            e.calcularEdad(); // valida la fecha
            colegio.agregarEstudiante(e);
            return "Estudiante registrado correctamente.";
        } catch (Exception ex) {
            return "Error: revise la fecha (formato dd/mm/aaaa).";
        }
    }
public String reporteEstudiantes() {
        ArrayList<Estudiante> lista = colegio.getEstudiantes();
        if (lista.isEmpty()) {
            return "No hay estudiantes registrados.";
        }
        String texto = "===== LISTA DE ESTUDIANTES =====\n\n";
        for (int i = 0; i < lista.size(); i++) {
            texto += (i + 1) + ". " + lista.get(i).mostrarInfo() + "\n";
        }
        texto += "\nTotal estudiantes: " + lista.size();
        return texto;
    }
public String reporteProfesoresPorSalario() {
        ArrayList<Profesor> lista = new ArrayList<>(colegio.getProfesores());
        if (lista.isEmpty()) {
            return "No hay profesores registrados.";
        }

       
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - 1 - i; j++) {
                if (lista.get(j).calcularPago() < lista.get(j + 1).calcularPago()) {
                    Profesor temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }

        String texto = "===== PROFESORES POR SALARIO (MAYOR A MENOR) =====\n\n";
        double totalPagos = 0;
        double totalPrestaciones = 0;
        for (int i = 0; i < lista.size(); i++) {
            Profesor p = lista.get(i);
            texto += (i + 1) + ". " + p.mostrarInfo() + "\n";
            totalPagos += p.calcularPago();
            totalPrestaciones += p.calcularPrestaciones();
        }
        texto += "\nTotal pagado a profesores: $" + String.format("%,.2f", totalPagos);
        texto += "\nTotal prestaciones sociales: $" + String.format("%,.2f", totalPrestaciones);
        return texto;
    }
}
