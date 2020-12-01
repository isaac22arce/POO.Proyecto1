/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import java.util.ArrayList;
import poo.proyecto1.Menu;

/**
 *
 * @author Isaac
 */
public class Vip extends Cliente{
    private int peso;
    private int estatura;
    private int hes;//horas de ejercicios semanales
    private String profesion;
    
    //metodos
    public Vip(String cedula, String nombres, String apellidos, String telefono, String correo,String direccion,ArrayList<Menu> menu,int peso,int estatura,int hes,String profesion ){
        super(cedula,nombres,apellidos,telefono,correo, direccion,menu);
        this.peso=peso;
        this.estatura=estatura;
        this.hes=hes;
        this.profesion=profesion;
    }
    public double cualcularIMC(int peso,int estatura){
        double indiceIMC=0; 
        indiceIMC= peso/(estatura*estatura);
        return indiceIMC;  
    }
}
