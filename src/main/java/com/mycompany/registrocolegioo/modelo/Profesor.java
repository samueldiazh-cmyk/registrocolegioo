/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocolegioo.modelo;

public class Profesor extends Persona {

    public static final double PORC_PREPARACION = 0.30;
    public static final double PORC_PRESTACIONES = 0.19;

    private String cedula;
    private String area;
    private double salarioHora;
    private int horasDictadas;
    
        public Profesor(String nombre, String direccion, String telefono, String fechaNacimiento,
            String cedula, String area, double salarioHora, int horasDictadas) {
        setNombre(nombre);
        setDireccion(direccion);
        setTelefono(telefono);
        setFechaNacimiento(fechaNacimiento);
        this.cedula = cedula;
        this.area = area;
        this.salarioHora = salarioHora;
        this.horasDictadas = horasDictadas;
    }
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }

    public int getHorasDictadas() {
        return horasDictadas;
    }

    public void setHorasDictadas(int horasDictadas) {
        this.horasDictadas = horasDictadas;
    }
     public double calcularPago() {
        double base = salarioHora * horasDictadas;
        return base + (base * PORC_PREPARACION);
    }

   
    public double calcularPago(double bonificacion) {
        return calcularPago() + bonificacion;
    }
        
    public double calcularPrestaciones() {
        return calcularPago() * PORC_PRESTACIONES;
    }

    
    @Override
    public String mostrarInfo() {
        return super.mostrarInfo()
                + " | Cédula: " + cedula
                + " | Área: " + area
                + " | Pago: $" + String.format("%,.2f", calcularPago())
                + " | Prestaciones: $" + String.format("%,.2f", calcularPrestaciones());
    }
}