/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empresa;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Isaac
 */
public class ClienteVip extends Cliente{
    private boolean isVip = true;
    private final int valorSuscripcion = 120;
    private double pesoKg;
    private int estaturaCm;
    private String horasEjercicioSemanal;
    private String profesion;

    public ClienteVip(double pesoKg, int estaturaCm, String horasEjercicioSemanal, String profesion, String cedula, String nombre, String apellido, String telefono, String correoElectronico, String direccion, Date fechaInicioSuscripcion) {
        super(cedula, nombre, apellido, telefono, correoElectronico, direccion, fechaInicioSuscripcion);
        this.pesoKg = pesoKg;
        this.estaturaCm = estaturaCm;
        this.horasEjercicioSemanal = horasEjercicioSemanal;
        this.profesion = profesion;
    }
    
    /**
     * metodo que calcula el indice de masa corporal
     */  
    public double getInidiceMasaCorporal(){
        return this.estaturaCm/this.pesoKg;
    }
    /**
     * metodo que calcula el final de la mensualidad de la suscripcion
     * 
     */
    

    public boolean isIsVip() {
        return isVip;
    }

    public void setIsVip(boolean isVip) {
        this.isVip = isVip;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public double getEstaturaCm() {
        return estaturaCm;
    }

    public void setEstaturaCm(int estaturaCm) {
        this.estaturaCm = estaturaCm;
    }

    public String getHorasEjercicioSemanal() {
        return horasEjercicioSemanal;
    }

    public void setHorasEjercicioSemanal(String horasEjercicioSemanal) {
        this.horasEjercicioSemanal = horasEjercicioSemanal;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getValorSuscripcion() {
        return valorSuscripcion;
    }
    
    
    
    
    
}

