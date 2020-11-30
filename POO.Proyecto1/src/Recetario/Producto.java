/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recetario;

/**
 *
 * @author Alexandra Imaicela
 */
public class Producto {
    private String nombre;
    private InformacionNutricional InfoNutricionalx100g;

    public Producto(String nombre, InformacionNutricional InfoNutricionalx100g) {
        this.nombre = nombre;
        this.InfoNutricionalx100g = InfoNutricionalx100g;
    }
    
    public Producto(String nombre) {
        this.nombre = nombre;
    }
    
}
