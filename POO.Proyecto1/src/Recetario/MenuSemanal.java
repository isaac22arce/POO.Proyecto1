/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recetario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author AlexandraImaicela
 */
public class MenuSemanal {
    Date fechaInicio;
    Date fechaFin;
    ArrayList<Receta> desayuno;
    ArrayList<Receta> almuerzo;
    ArrayList<Receta> merienda;

    public MenuSemanal(Date fechaInicio) {
        this.fechaInicio = new Date();
        desayuno = new ArrayList<>();
        almuerzo = new ArrayList<>();
        merienda = new ArrayList<>();
    }

    public ArrayList<Receta> getDesayuno() {
        return desayuno;
    }

    public void setDesayuno(ArrayList<Receta> desayuno) {
        this.desayuno = desayuno;
    }

    public ArrayList<Receta> getAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(ArrayList<Receta> almuerzo) {
        this.almuerzo = almuerzo;
    }

    public ArrayList<Receta> getMerienda() {
        return merienda;
    }

    public void setMerienda(ArrayList<Receta> merienda) {
        this.merienda = merienda;
    }
    
    /**
     * metodo que calcula el final del menu semanal
     */
    private void calcularFechaFinal(Date fechaInicio){
        Calendar calendar = Calendar.getInstance();
	
        calendar.setTime(fechaInicio); // Configuramos la fecha que se recibe

        calendar.add(Calendar.DAY_OF_YEAR, 5);  // numero de días a añadir, o restar en caso de días<0
	
        fechaFin = calendar.getTime();
    }
    
}
