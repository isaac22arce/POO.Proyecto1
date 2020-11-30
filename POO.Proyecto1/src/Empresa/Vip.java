/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empresa;

/**
 *
 * @author Isaac
 */
public class Vip extends Cliente{
    private int peso;
    private int estatura;
    private int hes;
    private String profesion;
    
    //metodos
    public Vip(String cedula, String nombres, String apellidos, String telefono, String correo,String direccion,int peso,int estatura,int hes,String profesion ){
        super(cedula,nombres,apellidos,telefono,correo, direccion);
        this.peso=peso;
        this.estatura=estatura;
        this.hes=hes;
        this.profesion=profesion;
    }
}
