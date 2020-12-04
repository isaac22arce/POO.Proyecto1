/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import Recetario.Producto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static nutrifit.Main.PRODUCTOS;

/**
 *
 * @author Isaac
 */
public class Validaciones {
    public static int validaCargaProductos = 0;
    Scanner sc = new Scanner(System.in);
    public static int validaCargaMenu=0;

    public Validaciones() {
    }
    
    
    public boolean isChargedProducts(int validaCargaProductos){     
        return Validaciones.validaCargaProductos>=1;
    }
    /*
    metodo que verifica que una cadena de caracteres sea numerica
    */
    public boolean isNumeric(String cadena){
	try {
            Integer.parseInt(cadena);
            return true;
	} catch (NumberFormatException nfe){
            return false;
        }
    }
    /**
     * Metodo para validar si una cadena es solo de caracteres
     *
     * @param numero
     * @return boolean que define si el int no es valido
     */
    public void isStringCorrecto(String nombre) {
        while (!nombre.matches("[a-zA-z]+")) {
            System.out.println("asegurese de ingresar solo letras");
            System.out.print("Ingresar nombre: ");
            nombre=sc.nextLine();
            
        }
    }
     /**
     * Metodo para validar si un correo tiene una estructura incorrecta
     *
     * @param correo
     * @return boolean que define si el correo no es valido
     */
    public void  isCorreo(String correo) {
        boolean validacion = false;
        
        while(!validacion){
            if (correo.contains("@")) {
                if (correo.split("@")[1].contains(".")) {
                    validacion = true;
                }
            }else{
                System.out.println("ingrese un correo valido");
                System.out.print("Ingresar Correo: ");
                correo=sc.nextLine();
            }
        
        }
    }
   
    /**
    metodo que valida cedula
    */
    public void isCedula(String cedula){
        while(!(isNumeric(cedula) && cedula.length()==10)){
            System.out.println("Asegurse de ingresar 10 digitos nuemericos ");
            System.out.print("Ingresar cedula: ");
            cedula=sc.nextLine();
        
        }
        
    }
    /**
     * metodo que valida la opcion sobre el cliente
     */
    public int validaOpcionSuscripcion(String op){
        while(true){
            if(this.isNumeric(op)){
                int opcion = Integer.parseInt(op);
                if(opcion==1 | opcion ==2){
                    return opcion;
                    
                }else{
                    System.out.println("Ingrese una opcion valida");
                    System.out.println("Es usuario 1.VIP");
                    System.out.println("Es usuarios 2.FRESH");
                    System.out.print("Ingresar Opcion: ");
                    op = sc.nextLine();
                }
            }else{
                System.out.println("Ingrese una opcion valida");
                System.out.println("Es usuario 1.VIP");
                System.out.println("Es usuarios 2.FRESH");
                System.out.print("Ingresar Opcion: ");
                op = sc.nextLine();
            }
        }
        
    
    }
    //
    public Double convierteCadenaDouble(String cadena){
        try {
            double n = Double.parseDouble(cadena);
            return n;
	} catch (NumberFormatException nfe){
            return 0.0;
        }
    }
    //
    public Producto correctProduct(){
        while(true){
            System.out.print("Ingresar nombre del producto: ");
            String producto=sc.nextLine();
            for(Producto p : PRODUCTOS){
                if(p.getNombre().equals(producto.toUpperCase())){
                    return p;
                }
            
            }
            System.out.println("Ingrese un producto que exista");
            
        }
    }
    //
    public Date validDateForMenu(){
        while(true){
            System.out.println("Recuerde escoger un dia que sea lunes");
            System.out.print("Ingresar Fecha en formato MM-dd-yyyy: ");
            String f=sc.nextLine();
      
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");  //("MM-dd-yyyy");
            Calendar calendar = Calendar.getInstance();
            Date fechaCambiada = null;
            try {
                fechaCambiada = dateFormat.parse(f);
            } catch (ParseException ex) {
                Logger.getLogger(Validaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
            calendar.setTime(fechaCambiada);
            System.out.println(calendar.getTime());
            
            if(calendar.get(Calendar.DAY_OF_WEEK)==2){
                
                return fechaCambiada;
            }else{
                System.out.println("ingrese un fecha en donde el dia sea lunes");
            }
            
        }
    
    }
    //
    /*
    metood que compara si una fecha ya ha pasado
    */
    public boolean fechaCaducada(Date fecha1, Date fecha2){
        if( fecha1.before(fecha2)){
            return true;
        }
        return false;
    }
    //
    /**
     * metodo que escoge una opcion de cliente
     */
    public String opcionTipoCliente(){
        String tipo="";
        while(!tipo.equals("1") || !tipo.equals("2")){
            System.out.println("Ingresar opcion del tipo de ciente que desea consultar: ");
            System.out.println("1. VIP   2. FRESH");
            tipo =sc.nextLine();
            
            if(tipo.equals("1")){
                return "VIP";
            }else if (tipo.equals("2")){
                return "FRESH";
            }
        
        }
        return null;
    }
    
    
}
