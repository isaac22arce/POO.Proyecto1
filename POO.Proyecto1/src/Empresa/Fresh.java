/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empresa;

import java.util.ArrayList;
import poo.proyecto1.Menu;

/**
 *
 * @author Isaac
 */
public class Fresh extends Cliente {
    private boolean envio;
   
    
    //metodo
    public Fresh(String cedula, String nombres,String apellidos, String telefono, String correo, String direccion,ArrayList<Menu> menu,boolean envio){
        super(cedula,nombres,apellidos,telefono,correo,direccion,menu);
        this.envio=envio;
    }
    
}
