/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocolegioo.modelo;

import java.time.LocalDate;

public class Persona {

    private String nombre;
    private String direccion;
    private String telefono;
    private String fechaNacimiento; // formato dd/mm/aaaa


public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
 public int calcularEdad() {
        String[] partes = fechaNacimiento.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);

        LocalDate hoy = LocalDate.now();
        int edad = hoy.getYear() - anio;
        if (hoy.getMonthValue() < mes
                || (hoy.getMonthValue() == mes && hoy.getDayOfMonth() < dia)) {
            edad--;
        }
        return edad;
    }
    
    }