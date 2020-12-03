/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empresa;

import java.util.Date;

/**
 *
 * @author Isaac Arce
 */
public class ClienteFresh extends Cliente {
    private boolean isVip = false;
    private final int valorSuscripcion = 70;
    private final int cobroDomicilio = 30;

    public ClienteFresh(String cedula, String nombre, String apellido, String telefono, String correoElectronico, String direccion, Date fechaInicioSuscripcion) {
        super(cedula, nombre, apellido, telefono, correoElectronico, direccion, fechaInicioSuscripcion);
    }
    
    
    
    public boolean isIsVip() {
        return isVip;
    }

    public void setIsVip(boolean isVip) {
        this.isVip = isVip;
    }

    public int getValorSuscripcion() {
        return valorSuscripcion;
    }

    public int getCobroDomicilio() {
        return cobroDomicilio;
    }
    
    
}
