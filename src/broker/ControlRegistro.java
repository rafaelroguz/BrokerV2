package broker;

import java.util.ArrayList;

public class ControlRegistro {
    private String ARCHIVOREGISTRADOS= "registrados.txt";

    public ControlRegistro() {
    }
    
    public void registrarUsuario(String usuario){
        ManejadorArchivos fileHandler = new ManejadorArchivos();
        if(verificarExistenciaUsuario(usuario) == false){
            fileHandler.escribirArchivo(ARCHIVOREGISTRADOS, usuario);
            System.out.println("¡Registrado!");
        }
    }
    public boolean verificarExistenciaUsuario(String usuario){
        ManejadorArchivos fileHandler = new ManejadorArchivos();
        ArrayList<String> textoArchivo;
        textoArchivo = fileHandler.leerCereales(ARCHIVOREGISTRADOS);
        
        boolean existencia = false;
        for(int i=0; i<textoArchivo.size(); i++){
            if(textoArchivo.get(i).compareTo(usuario) == 0){
                existencia = true;
                System.out.println("¡Ya está registrado ese usuario!.");
            }
                
        }
        return existencia;
    }
    
}
