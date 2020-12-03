/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutrifit;
import Recetario.InformacionNutricional;
import Recetario.Producto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nicolas Carrasco
 */
public class Main {
 public static ArrayList<Producto> PRODUCTOS = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     LeerArchivoProductos();
        menu();
  
        // TODO code application logic here
    }
     /**
     * metodo que genera el menu 
     */
    public static void menu(){
        String opcion="";
       
        while(!opcion.equals("7")){
              System.out.println("╔                Menu                         ╗");
              System.out.println("║ 1. Subir Productos                          ║");
              System.out.println("║ 2. Registrar Receta                         ║");
              System.out.println("║ 3. Registrar Cliente                        ║");
              System.out.println("║ 4. Creacion Automatica de menu Semanal      ║");
              System.out.println("║ 5. Envio de menu Semanal                    ║");              
              System.out.println("║ 6. Consultar Suscripciones                  ║"); 
              System.out.println("║ 7. Salir                  ║");
              System.out.println("╚                                             ╝");
              System.out.print("Ingrese opcion: ");      
              opcion = sc.nextLine();
            switch (opcion){
                case "1":
                    
                    break;
                case "2":
                   
                    break;
                case "3": 
                    
                    break;
                case "4":    
                    
                    break;
                case "5":
                   
                    break;
                default:
                    System.out.println("Opcion No valida!!");
            }
        }
        System.out.println("Gracias por usar nuestro servicioS");
        sc.close();
    }
    
    /*
    metodo que llena la lista
    */
    public static void LeerArchivoProductos(){
        try(BufferedReader lector = new BufferedReader(new FileReader("Ingredientes.csv"))){
            String linea = "";
            lector.readLine();
            
            while((linea = lector.readLine())!=null){
                String[] datos = linea.split(",");
                String nombre = datos[0];
                double calorias =   Double.parseDouble(datos[1]);
                double hidratos = Double.parseDouble(datos[2]);
                double proteinas = Double.parseDouble(datos[3]);
                double grasas = Double.parseDouble(datos[4]);
                double fibras = Double.parseDouble(datos[5]);
                
                
                Producto p = new Producto(nombre,new InformacionNutricional(calorias,  hidratos,proteinas, grasas,fibras));
                PRODUCTOS.add(p);
                
            }
        }catch(IOException e){
            System.out.println("error al leer el archivo productos "+e);
        }  
    }

}
