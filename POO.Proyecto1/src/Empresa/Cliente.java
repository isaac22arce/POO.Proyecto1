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
public class Cliente {
    protected String cedula;
    protected String nombres;
    protected String apellidos;
    protected String telefono;
    protected String correo;
    protected String direccion;
    protected ArrayList<Menu> menu= new ArrayList<>();
    
    //metodos
    public Cliente(String cedula, String nombres ,String apellidos, String telefono, String correo, String direccion,ArrayList<Menu> menu){
       this.cedula=cedula;
       this.nombres= nombres;
       this.apellidos= apellidos;
       this.telefono=telefono;
       this.correo=correo;
       this.direccion=direccion;
       this.menu=menu;
    }
    
    public void enviarMenu(){
        System.out.println("El menu de la semana es el siguinete: "+"/n");
        for(Menu n:menu){
            System.out.println(n);
        }
    }
    
}
