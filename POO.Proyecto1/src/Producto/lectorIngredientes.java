package Producto;
/**
 *
 * @author Alexandra Imaicela
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class lectorIngredientes{
    private ArrayList<ArrayList<String>> datosAlimentos;
    
    public ArrayList<ArrayList<String>> getDatosAlimentos(){
        return datosAlimentos;    
    }
    
    
    public ArrayList<ArrayList<String>> leer(){
        datosAlimentos=new ArrayList<>();
        Path filePath=Paths.get("C:\\Ingredientes1\\Ingredientes.csv"); //Debe colocar la ubicación donde se encuentre su archivo .csv
        try{
            BufferedReader br=Files.newBufferedReader(filePath);
            String linea;
            while ((linea=br.readLine()) != null){
                String[] datosLinea=linea.split(",");
                ArrayList<String> datosTemporal= new ArrayList<>();
                for (String d:datosLinea){
                    datosTemporal.add(d);
                }
                datosAlimentos.add(datosTemporal);
            }
        }
        catch(IOException e){
            e.printStackTrace();            
        }
        return datosAlimentos;
    }

    
}

    

