/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocolegioo.modelo;

/**
 *
 * @author cdval
 */


public class ProfesorPlanta extends Profesor {

    public static final double PORC_ANTIGUEDAD = 0.02; // 2% por cada año

    private int aniosAntiguedad;

    public ProfesorPlanta(String nombre, String direccion, String telefono, String fechaNacimiento,
            String cedula, String area, double salarioHora, int horasDictadas, int aniosAntiguedad) {
        super(nombre, direccion, telefono, fechaNacimiento, cedula, area, salarioHora, horasDictadas);
        this.aniosAntiguedad = aniosAntiguedad;
    }

    public int getAniosAntiguedad() {
        return aniosAntiguedad;
    }

    public void setAniosAntiguedad(int aniosAntiguedad) {
        this.aniosAntiguedad = aniosAntiguedad;
    }

    
    public double calcularBonificacion() {
        return calcularBonificacion(super.calcularPago());
    }

    
    public double calcularBonificacion(double pagoBase) {
        return pagoBase * PORC_ANTIGUEDAD * aniosAntiguedad;
    }

    
    @Override
    public double calcularPago() {
        double base = super.calcularPago();
        return base + calcularBonificacion(base);
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo()
                + " | Tipo: Planta"
                + " | Años de antigüedad: " + aniosAntiguedad;
    }
}
