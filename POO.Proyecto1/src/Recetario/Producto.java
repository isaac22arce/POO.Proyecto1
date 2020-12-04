/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recetario;
import java.io.Serializable;
/**
 *
 * @author Alexandra Imaicela
 */
public class Producto implements Serializable {
    private String nombre;
    private InformacionNutricional InfoNutricionalx100g;

    public Producto(String nombre, InformacionNutricional InfoNutricionalx100g) {
        this.nombre = nombre;
        this.InfoNutricionalx100g = InfoNutricionalx100g;
    }
    
    public Producto(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public InformacionNutricional getInfoNutricionalx100g() {
        return InfoNutricionalx100g;
    }

    public void setInfoNutricionalx100g(InformacionNutricional InfoNutricionalx100g) {
        this.InfoNutricionalx100g = InfoNutricionalx100g;
    }
    
    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + '}'+"\n";
    }
    
}
