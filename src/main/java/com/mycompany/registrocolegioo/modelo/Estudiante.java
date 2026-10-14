/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocolegioo.modelo;

public class Estudiante extends Persona {

    private String codigo;
    private String grado;
    private String acudiente;
 public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(String acudiente) {
        this.acudiente = acudiente;
    }
        @Override
    public String mostrarInfo() {
        return super.mostrarInfo()
                + " | Código: " + codigo
                + " | Grado: " + grado
                + " | Acudiente: " + acudiente;
    }
}