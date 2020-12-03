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
    /*
    metodo que carga la informacion para clientes
    */
    public void cargarDatosCliente(){
        System.out.print("Ingresar cedula: ");
        String cedula=sc.nextLine();
        val.isCedula(cedula);
        System.out.print("Ingresar nombre: ");
        String nombre=sc.nextLine();
        val.isStringCorrecto(nombre);
        System.out.print("Ingresar Apellido: ");
        String Apellido=sc.nextLine();
        val.isStringCorrecto(Apellido);
        System.out.print("Ingresar Telofono: ");
        String telefono=sc.nextLine();
        val.isCedula(telefono); // por que los telefonos tambien usan digitos y tienen 10 caractares
        System.out.print("Ingresar Correo electronico: ");
        String correo=sc.nextLine();
        val.isCorreo(correo);
        System.out.print("Ingresar direccion: ");
        String direccion=sc.nextLine();
        System.out.println("Seleccione opcion para tipo de usuario");
        System.out.println("Es usuario 1.VIP");
        System.out.println("Es usuario 2.FRESH");
        System.out.print("Ingresar Opcion: ");
        String opcionSuscripcion = sc.nextLine();
        int opSuscripcion = val.validaOpcionSuscripcion(opcionSuscripcion);
        Date fechaInicioSuscripcion = new Date();
        
        if(opSuscripcion==1){
            System.out.print("Ingresar Peso Kg: ");
            String peso=sc.nextLine();
            double pesoKg = val.convierteCadenaDouble(peso);
            System.out.print("Ingresar Peso estaturaCm: ");
            String estatura=sc.nextLine();
            int estaturaCm = Integer.parseInt(estatura);
            System.out.print("Ingresar Horas de ejercicio que realiza a la semana: ");
            String horasEjercicioSemanal=sc.nextLine();
            System.out.print("Ingresar Profesion: ");
            String profesion=sc.nextLine();
            
            ClienteVip cv= new ClienteVip(pesoKg, estaturaCm, horasEjercicioSemanal, profesion, cedula, nombre, Apellido
                                           ,telefono, correo, direccion, fechaInicioSuscripcion);
            
            this.clientes.add(cv);
        }else{
            ClienteFresh cv= new ClienteFresh(cedula, nombre, Apellido
                                            ,telefono, correo, direccion, fechaInicioSuscripcion);
            this.clientes.add(cv);
        }
        this.serializarClientes();
    
    }

}