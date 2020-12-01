/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recetario;
import java.io.Serializable;
/**
 *
 * @author AlexandraImaicela
 */
public class InformacionNutricional implements Serializable {
    private double calorias;
    private double hidratosDeCarbono;
    private double proteinas; 
    private double grasas;
    private double fibras;

    public InformacionNutricional(double calorias, double hidratosDeCarbono, double proteinas, double grasas, double fibras) {
        this.calorias = calorias;
        this.hidratosDeCarbono = hidratosDeCarbono;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.fibras = fibras;
    }
     public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public double getHidratosDeCarbono() {
        return hidratosDeCarbono;
    }

    public void setHidratosDeCarbono(double hidratosDeCarbono) {
        this.hidratosDeCarbono = hidratosDeCarbono;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getGrasas() {
        return grasas;
    }

    public void setGrasas(double grasas) {
        this.grasas = grasas;
    }

    public double getFibras() {
        return fibras;
    }

    public void setFibras(double fibras) {
        this.fibras = fibras;
    }  
}
