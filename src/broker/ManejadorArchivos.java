package broker;

import manejadorarchivos.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class ManejadorArchivos {
    
    /**
     * Recibe una línea de texto que contiene la fecha y hora de la votación y la
     * agrega al final del archivo de texto. Si el archivo no existe, lo crea primero.
     * @param archivo ruta y nombre el archivo de texto donde se guardarán los votos.
     * @param lineaTexto línea de texto con la fecha y hora del voto.
     */
    public void escribirArchivo(String archivo, String lineaTexto) {
        
        try{
        
            final Path rutaArchivo = Paths.get(archivo); 
            
            if (Files.notExists(rutaArchivo)) {
                Files.createFile(rutaArchivo);
            } 
                
            Files.write(Paths.get(archivo), lineaTexto.getBytes(), StandardOpenOption.APPEND);           
            
        } catch (IOException e) {
            
            System.out.println("Error de escritura del archivo \"" + archivo + "\".");
            
        }
        
    }
    
    /**
     * Abre el archivo de votación y contabiliza el número de línea para sacar
     * la cuenta del número de votos para ese archivo.
     * @param archivo ruta y nombre del archivo de texto donde están guardados los votos.
     * @return numeroVotos el número de votos para ese archivo.
     */
    public int leerVotos(String archivo) {
        
        int numeroVotos = 0;
        
        try{
            
            Scanner fileIn = new Scanner(new FileReader(archivo));
            
            while (fileIn.hasNextLine()){
                
                numeroVotos++;
                fileIn.nextLine();
                
            }
            
            fileIn.close();
            
        } catch(FileNotFoundException e) {
            
            System.out.println("Error de lectura del archivo \"" + archivo + "\".");
            
            return 0;
            
        }
        
        return numeroVotos;
        
    }
    
    public ArrayList<String> leerCereales(String archivo) {
        
        ArrayList<String> cereales = new ArrayList<String>();
        
        try{
            
            Scanner fileIn = new Scanner(new FileReader(archivo));
            
            while (fileIn.hasNextLine()){
                cereales.add(fileIn.nextLine());                
            }
            
            fileIn.close();
            
        } catch(FileNotFoundException e) {
            
            System.out.println("Error de lectura del archivo \"" + archivo + "\".");
            
            System.exit(0);
            
        }
        
        return cereales;
        
    }
    
}
