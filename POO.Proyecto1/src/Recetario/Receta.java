/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recetario;

import java.util.ArrayList;

/**
 *
 * @author Alexandra Imaicela
 */
public class Receta {
        String clasificacion;
    ArrayList<Producto> productos; //Lista de productos de la receta
    ArrayList<Integer> cantidadGramos;

    public Receta(String clasificacion, ArrayList<Producto> productos, ArrayList<Integer> cantidadGramos) {
        this.clasificacion = clasificacion;
        this.productos = productos;
        this.cantidadGramos = cantidadGramos;
    }
    
    /**
     * metodo que calcula la informacin nutricional de la receta
     */
    public double informacionNutricionalReceta(){
        double calculo=0;
        return calculo;
    }    
    
    
    
}
