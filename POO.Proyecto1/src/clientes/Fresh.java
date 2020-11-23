/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

/**
 *
 * @author Isaac
 */
public class Fresh extends Cliente {
    private boolean envio;
    
    //metodo
    public Fresh(String cedula, String nombres,String apellidos, String telefono, String correo, String direccion,boolean envio){
        super(cedula,nombres,apellidos,telefono,correo,direccion);
        this.envio=envio;
    }
    
}
