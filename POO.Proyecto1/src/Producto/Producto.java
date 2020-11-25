/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producto;

/**
 *
 * @author lenovo
 */
import java.util.*;

public class Producto {
    protected String nombreProducto;
    private ArrayList<String> listaInformacion;
    private ArrayList<String> guardaIng;
    
    public Producto(String nombreProducto){
        this.nombreProducto=nombreProducto;
    }
    
    public ArrayList informacionNutricional(){
        listaInformacion=new ArrayList<>();
        lectorIngredientes leerArchivos=new lectorIngredientes();
        for(int i=0; i<leerArchivos.leer().size();i++){
            List lista1=leerArchivos.leer().get(i);
            String parte=(String) lista1.get(0);
            if (parte.equalsIgnoreCase(nombreProducto)){
                for (int j=0;j<lista1.size();j++){
                    listaInformacion.add((String) lista1.get(j));
            }}}
        return listaInformacion;
        }
}
      

    

