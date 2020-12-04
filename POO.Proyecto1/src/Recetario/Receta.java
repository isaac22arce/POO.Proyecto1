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
    private String clasificacion;
    private ArrayList<Producto> productos; //Lista de productos de la receta
    private ArrayList<Integer> cantidadGramos;
    private String preparacion;

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
    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Integer> getCantidadGramos() {
        return cantidadGramos;
    }

    public void setCantidadGramos(ArrayList<Integer> cantidadGramos) {
        this.cantidadGramos = cantidadGramos;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    @Override
    public String toString() {
        String  msjGramos = "";
        double[] infoN = this.informacionNutricionalReceta();
        String  infoNutriReceta ="calorias: "+infoN[0]+" \n";
        
        for(int i=0;i<cantidadGramos.size();i++){
            Producto p = productos.get(i);
            Integer cantidad = cantidadGramos.get(i);
            msjGramos += p.getNombre()+", Cantidad gramos: "+cantidad+"\n";
        }
        return "Receta{\n" + "clasificacion=" + clasificacion +"\n"+ "productos=\n[\n" + msjGramos + "]\n"+infoNutriReceta+"preparacion=" + preparacion +"\n"+ '}'+ "\n";
    }
    
        
    
    
    
}
