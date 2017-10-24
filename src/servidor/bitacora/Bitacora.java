package servidor.bitacora;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import manejadorarchivos.ManejadorArchivos;

public class Bitacora {
    
    private final String BITACORA = "archivos/bitacora.txt";
    
    public void guardarRegistro(String funcion, String nombreClase) {
        
        ManejadorArchivos manejadorArchivo = new ManejadorArchivos();    
        DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date fechaHoraActual = new Date();
        
        String lineaTexto = funcion + " @ " + 
                nombreClase + " -- " + 
                formatoFecha.format(fechaHoraActual) + "\n";
        
        manejadorArchivo.escribirArchivo(BITACORA, lineaTexto);
        
    }
    
}
