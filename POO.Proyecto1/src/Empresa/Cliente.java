/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empresa;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Isaac 
 */
public class Cliente implements Serializable{
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correoElectronico;
    private String direccion;
    private Date fechaInicioSuscripcion;
    private Date fechaFinSuscripcion;
    //fechas 

    public Cliente(String cedula, String nombre, String apellido, String telefono, String correoElectronico, String direccion,
            Date fechaInicioSuscripcion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.fechaInicioSuscripcion=fechaInicioSuscripcion;
        this.getFechaFinSuscripcion();
    }
    /*
    metodo que calcula el fin de la fecha de suscripcion del cliente
    */
    private void getFechaFinSuscripcion(){
        Calendar calendar = Calendar.getInstance();
	
        calendar.setTime(fechaInicioSuscripcion); // Configuramos la fecha que se recibe
        //
        //falta calcular segun el mes cuantos dias pasaran de la suscripcion
        //
        calendar.add(Calendar.DAY_OF_YEAR, 30);  // numero de días a añadir, o restar en caso de días<0
	
        this.fechaFinSuscripcion= calendar.getTime();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaFinSuscripcion(Date fechaFinSuscripcion) {
        this.fechaFinSuscripcion = fechaFinSuscripcion;
    }

    public Date getFechaInicioSuscripcion() {
        return fechaInicioSuscripcion;
    }

    public void setFechaInicioSuscripcion(Date fechaInicioSuscripcion) {
        this.fechaInicioSuscripcion = fechaInicioSuscripcion;
    }
    

    
    
    
    
    
}
