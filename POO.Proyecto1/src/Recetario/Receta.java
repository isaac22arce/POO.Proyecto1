/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recetario;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author Alexandra Imaicela
 */
public class Receta implements Serializable{
    String clasificacion;
    ArrayList<Producto> productos; //Lista de productos de la receta
    ArrayList<Integer> cantidadGramos;
    String preparacion;

    public Receta(String clasificacion, ArrayList<Producto> productos, ArrayList<Integer> cantidadGramos, String preparacion) {
        this.clasificacion = clasificacion;
        this.productos = productos;
        this.cantidadGramos = cantidadGramos;
        this.preparacion=preparacion;
    }
    
    /**
     * metodo que calcula la informacin nutricional de la receta
     */
    public double[] informacionNutricionalReceta(){
        
     double[] vectorInfoNutricional = new double[5]; //[calorias,hidratos,proteinas,grasas,fibras]
        for(int i=0 ;i < productos.size();i++){
            Producto p = productos.get(i);
            int cantidad = cantidadGramos.get(i);
            InformacionNutricional infoN = p.getInfoNutricionalx100g();
            vectorInfoNutricional[0]+= this.regla3(cantidad,infoN.getCalorias());
            vectorInfoNutricional[1]+= this.regla3(cantidad,infoN.getHidratosDeCarbono());
            vectorInfoNutricional[2]+= this.regla3(cantidad,infoN.getProteinas());
            vectorInfoNutricional[3]+= this.regla3(cantidad,infoN.getGrasas());
            vectorInfoNutricional[4]+= this.regla3(cantidad,infoN.getFibras());
        }
        return vectorInfoNutricional;
    }    
    //
    public double regla3(int cantidad,double valor){ 
        return (valor*cantidad)/100;
    
    
    }
        
    
    
    
}
