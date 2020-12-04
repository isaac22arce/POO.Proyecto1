/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutrifit;

import Empresa.Cliente;
import Empresa.ClienteFresh;
import Empresa.ClienteVip;
import Mail.Correo;
import Recetario.InformacionNutricional;
import Recetario.MenuSemanal;
import Recetario.Producto;
import Recetario.Receta;
import Validaciones.Validaciones;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @Nicolas Carrasco
 */
public class Main {
    
    public static ArrayList<Producto> PRODUCTOS = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Receta> recetas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    Validaciones val = new Validaciones();
    MenuSemanal menuSemanal;
    Correo cor = new Correo();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Main m = new Main();
        m.obtenerRecetas();
        m.obtenerClientes();
        m.menu();
    }
    /**
     * metodo que genera el menu 
     */
    public void menu(){
        String opcion="";
       
        while(!opcion.equals("7")){
              System.out.println("╔                Menu                         ╗");
              System.out.println("║ 1. Subir Productos                          ║");
              System.out.println("║ 2. Registrar Receta                         ║");
              System.out.println("║ 3. Registrar Cliente                        ║");
              System.out.println("║ 4. Creacion Automatica de menu Semanal      ║");
              System.out.println("║ 5. Envio de menu Semanal                    ║");              
              System.out.println("║ 6. Consultar Suscripciones                  ║"); 
              System.out.println("║ 7. Salir                                    ║");
              System.out.println("╚                                             ╝");
              System.out.print("Ingrese opcion: ");      
              opcion = sc.nextLine();
            switch (opcion){
                case "1":
                    LeerArchivoProductos();
                    val.validaCargaProductos++; 
                    System.out.println("Productos guardados");
                    break;
                case "2":
                    if(val.isChargedProducts(val.validaCargaProductos)){
                        this.crearReceta();
                    }else{
                        System.out.println("primero ingrese a la opcion 1");
                    }
                    break;
                case "3":
                    this.cargarDatosCliente();
                    
                    break;
                case "4":   
                    this.crearMenuSemanal();
                    
                    break;
                case "5":
                    this.enviarCorreo();
                   
                    break;
                    
                case "6":
                    System.out.println(clientes);
                    this.consultaSuscripciones();
                    break;
                case "7":
                    System.out.println("Gracias por usar nuestro servicioS");
                    break;
                    
                default:
                    System.out.println("Opcion No valida!!");
            }
        }
        sc.close();
    }
    
    /*
    metodo que llena la lista Productos
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
    //
    public void crearReceta(){
        System.out.println(recetas);
        String op = "";
        String clasificacion = this.clasificacionReceta();
        ArrayList<Producto> productosReceta = new ArrayList<>();
        ArrayList<Integer> gramosProducto = new ArrayList<>();
        while(!op.equals("n") && !op.equals("N")){
            
            Producto producto = val.correctProduct();
            System.out.print("Ingresar cantidad en gramos: ");
            String cantidadGramos=sc.nextLine();
            System.out.println("Desea agregar mas productos? ");
            System.out.println("Si: s    No: n");
            productosReceta.add(producto);
            gramosProducto.add(Integer.parseInt(cantidadGramos));
            System.out.print("rt: ");
            op=sc.nextLine();
        }
        System.out.println("Ingrese metodo de preparacion: ");
        String preparacion=sc.nextLine();
        Receta rec = new Receta(clasificacion, productosReceta, gramosProducto, preparacion);
        recetas.add(rec);
        System.out.println(recetas);
        serializarRecetas();
    }
    
    //
    public String clasificacionReceta(){
        while(true){
            System.out.println("Seleccione una opcion para la clasificacion para la receta: ");
            System.out.println("1. Desayuno");
            System.out.println("2. Almuerzo");
            System.out.println("3. Cena");
            String op =sc.nextLine();
            if(op.equals("1")){
                return "Desayuno";
            }else if( op.equals("2")){
                return "Almuerzo";
            }else if(op.equals("3")){
                return "Cena";
            }
            
        }
    }
    //
    public void crearMenuSemanal(){
        if (val.validaCargaMenu>0){
        Date fechaInicio = val.validDateForMenu();
        menuSemanal = new MenuSemanal(fechaInicio);
        menuSemanal.crearMenu("Desayuno", recetas);
        menuSemanal.crearMenu("Almuerzo", recetas);
        menuSemanal.crearMenu("Cena", recetas);
        System.out.println(menuSemanal.getDesayuno());    
    } else {
            System.out.println("Primero ingrese a la opcion 4");
        }}
    //
    /**
     * metodo que envia el correo al cliente
     */
    public void enviarCorreo(){
        System.out.print("Ingresar correo cliente: ");
        String correo = sc.nextLine();
        
        cor.enviarCorreo(correo, "Menu Semanal para su dieta", this.generarMensaje());
        
    }
    //
    private String generarMensaje(){
        String msj = "";
        for(int i=0;i<5;i++){
            msj += "Dia: \n";
            msj += "Desayuno: "+ this.menuSemanal.getDesayuno().get(i).toString()+"\n";
            msj += "Almuerzo: "+ this.menuSemanal.getAlmuerzo().get(i).toString()+"\n";
            msj += "Cena: "+ this.menuSemanal.getMerienda().get(i).toString()+"\n";
            msj += "Que tenga una excelente semana";
        }
        System.out.println(msj);
        return msj;
    }
    /*
    metodo que consulta Suscripciones
    */
    public void consultaSuscripciones(){
        System.out.println("Consultando suscripciones activas...");
        Date fechaActual = new Date();
        String tipo = val.opcionTipoCliente();
        for(Cliente c: clientes){
            if(!val.fechaCaducada(fechaActual, c.getFechaInicioSuscripcion())){
                if( tipo.equals("VIP") && c instanceof ClienteVip){
                    System.out.println("*****************************");
                    ClienteVip cv = (ClienteVip) c;
                    System.out.println("Nombre: "+cv.getNombre());
                    System.out.println("Correo: "+cv.getCorreoElectronico());
                    System.out.println("Fecha de inicio: "+cv.getFechaInicioSuscripcion());
                    System.out.println("Fecha de Fin: "+cv.getFechaFinSuscripcion());
                    System.out.println("Peso KG: "+cv.getPesoKg());
                    System.out.println("Estatura: "+ cv.getEstaturaCm());
                    System.out.println("Horas de ejercicio semanal: "+cv.getHorasEjercicioSemanal());
                    System.out.println("Profesion: "+cv.getProfesion());
                    System.out.println("IMC: "+cv.getInidiceMasaCorporal());
                    System.out.println("*****************************");

                }else{
                    System.out.println("*****************************");
                    ClienteFresh cv = (ClienteFresh) c;
                    System.out.println("Nombre: "+cv.getNombre());
                    System.out.println("Correo: "+cv.getCorreoElectronico());
                    System.out.println("Fecha de inicio: "+cv.getFechaInicioSuscripcion());
                    System.out.println("*****************************");

                
                
                }
            
            }
            
        }
        
    
    }
    /*
    metodo que serializa los datos de las recetas    
    */
    public void serializarRecetas(){
        try(ObjectOutputStream serializador = new ObjectOutputStream(new FileOutputStream("recetas.dat"))){
            serializador.writeObject(recetas);
        }catch(IOException e){
            System.out.println("error al guardar la receta "+e);
        }
    }
    //
    /*
    metodo que deserializa las recetas
    */
    public void obtenerRecetas(){
        File f = new File("recetas.dat");
        if(f.exists()){
            try(ObjectInputStream deser = new ObjectInputStream(new FileInputStream(f))){
                ArrayList<Receta> recetasRecuparadas = (ArrayList<Receta>) deser.readObject();
                recetas = recetasRecuparadas;
            }catch(IOException e){
                System.out.println("error al recuperar la informacion de recetas"+e);
            } catch (ClassNotFoundException ex) {
                System.out.println("error al encontrar el archivo recetas.dat"+ex);
            }  
        }
    }
    //
    //
    /*
    metodo que serializa los datos de las recetas    
    */
    public void serializarClientes(){
        try(ObjectOutputStream serializador = new ObjectOutputStream(new FileOutputStream("clientes.dat"))){
            serializador.writeObject(clientes);
        }catch(IOException e){
            System.out.println("error al guardar clientes "+e);
        }
    }
    //
    /*
    metodo que deserializa las recetas
    */
    public void obtenerClientes(){
        File f = new File("clientes.dat");
        if(f.exists()){
            try(ObjectInputStream deser = new ObjectInputStream(new FileInputStream(f))){
                ArrayList<Cliente> clientesRecuparados = (ArrayList<Cliente>) deser.readObject();
                clientes = clientesRecuparados;
            }catch(IOException e){
                System.out.println("error al recuperar la informacion de clientes");
            } catch (ClassNotFoundException ex) {
                System.out.println("error al encontrar el archivo clientes.dat");
            }  
        }
            
    }
}
