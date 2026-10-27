/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocolegioo.modelo;

/**
 *
 * @author cdval
 */


public class ProfesorCatedra extends Profesor {

    private double auxilioTransporte;

    public ProfesorCatedra(String nombre, String direccion, String telefono, String fechaNacimiento,
            String cedula, String area, double salarioHora, int horasDictadas, double auxilioTransporte) {
        super(nombre, direccion, telefono, fechaNacimiento, cedula, area, salarioHora, horasDictadas);
        this.auxilioTransporte = auxilioTransporte;
    }

    public double getAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(double auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

    
    @Override
    public double calcularPago() {
        return super.calcularPago() + auxilioTransporte;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo()
                + " | Tipo: Cátedra"
                + " | Auxilio de transporte: $" + String.format("%,.2f", auxilioTransporte);
    }
}
