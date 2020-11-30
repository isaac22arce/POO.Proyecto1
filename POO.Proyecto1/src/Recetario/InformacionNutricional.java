/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recetario;

/**
 *
 * @author lenovo
 */
public class InformacionNutricional {
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
    
}
