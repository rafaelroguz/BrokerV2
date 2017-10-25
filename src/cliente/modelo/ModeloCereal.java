package cliente.modelo;

import cliente.proxy.ProxyCliente;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import manejadorarchivos.ManejadorArchivos;
import org.json.JSONException;
import org.json.JSONObject;
import servidor.bitacora.Bitacora;

public class ModeloCereal {
    
    private final String ARCHIVO_CEREALES = "cereales.txt";
    private final String PREFIJO_RUTA_ARCHIVOS = "archivos/";
    private final String NOMBRE_CLASE = "ModeloCereal";
    private final int NUMERO_CORRECTO_CEREALES = 3;
    private Bitacora bitacora;
    private int votosCerealA;
    private int votosCerealB;
    private int votosCerealC;
    private String cerealA;
    private String cerealB;
    private String cerealC;
            
    public ModeloCereal() {
        
        bitacora = new Bitacora();
        bitacora.guardarRegistro("ModeloCereal()", NOMBRE_CLASE);
        leerCereales(PREFIJO_RUTA_ARCHIVOS + ARCHIVO_CEREALES);
        
        votosCerealA = leerVotos(PREFIJO_RUTA_ARCHIVOS + cerealA + ".txt");
        votosCerealB = leerVotos(PREFIJO_RUTA_ARCHIVOS + cerealB + ".txt");
        votosCerealC = leerVotos(PREFIJO_RUTA_ARCHIVOS + cerealC + ".txt");
        
    }
    
    public void votoCerealA() {
        bitacora.guardarRegistro("votoCerealA()", NOMBRE_CLASE);
        votosCerealA++;
        guardaVoto(PREFIJO_RUTA_ARCHIVOS + cerealA + ".txt");
    }
    
    public void votoCerealB() {
        bitacora.guardarRegistro("votoCerealB()", NOMBRE_CLASE);
        votosCerealB++;
        guardaVoto(PREFIJO_RUTA_ARCHIVOS + cerealB + ".txt");
    }
    
    public void votoCerealC() {
        bitacora.guardarRegistro("votoCerealC()", NOMBRE_CLASE);
        votosCerealC++;
        guardaVoto(PREFIJO_RUTA_ARCHIVOS + cerealC + ".txt");
    }

    public int getVotosCerealA() {
        bitacora.guardarRegistro("getVotosCerealA()", NOMBRE_CLASE);
        return votosCerealA;
    }

    public int getVotosCerealB() {
        bitacora.guardarRegistro("getVotosCerealB()", NOMBRE_CLASE);
        return votosCerealB;
    }

    public int getVotosCerealC() {
        bitacora.guardarRegistro("getVotosCerealC()", NOMBRE_CLASE);
        return votosCerealC;
    }

    public String getCerealA() {
        bitacora.guardarRegistro("getCerealA()", NOMBRE_CLASE);
        return cerealA;
    }

    public String getCerealB() {
        bitacora.guardarRegistro("getCerealB()", NOMBRE_CLASE);
        return cerealB;
    }

    public String getCerealC() {
        bitacora.guardarRegistro("getCerealC()", NOMBRE_CLASE);
        return cerealC;
    }
    
    private void guardaVoto(String archivo) {
        
        bitacora.guardarRegistro("guardaVoto(String archivo)", NOMBRE_CLASE);
        
        //ManejadorArchivos manejadorArchivo = new ManejadorArchivos();    
        DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date fechaHoraActual = new Date();
        String lineaTexto = formatoFecha.format(fechaHoraActual) + "\n";
        
        //manejadorArchivo.escribirArchivo(archivo, lineaTexto);
        ProxyCliente proxy = new ProxyCliente();
        
        try {
            JSONObject json = new JSONObject();
            
            json.put("servicio", "votar");
            json.put("archivo", archivo);
            json.put("lineaTexto", lineaTexto);
            
            proxy.ejecutar(json.toString());
        } catch (JSONException ex) {
            System.out.println("Error de JSON en ModeloCereal.guardaVoto");
        }
                
    }
    
    private int leerVotos(String archivo) {
        
        bitacora.guardarRegistro("leerVotos(String archivo)", NOMBRE_CLASE);
         
        ProxyCliente proxy = new ProxyCliente();
        int numeroVotos = 0;
        
        try {
            JSONObject json = new JSONObject();
            
            json.put("servicio", "contar");
            json.put("archivo", archivo);
            String cadena = proxy.ejecutar(json.toString());            
                        
            if (cadena != null) {
                if (!cadena.equals(""))
                    numeroVotos = Integer.parseInt(cadena);
            }            
        } catch (JSONException ex) {
            System.out.println("Error de JSON en ModeloCereal.guardaVoto");
        }
        
        return numeroVotos;
        
    }
    
    private void leerCereales(String archivo) {
        
        bitacora.guardarRegistro("leerCereales(String archivo)", NOMBRE_CLASE);
        
        ManejadorArchivos manejadorArchivo = new ManejadorArchivos();
        ArrayList<String> cereales = new ArrayList<String>();
        
        cereales = manejadorArchivo.leerCereales(archivo);
        
        if (cereales.size() == NUMERO_CORRECTO_CEREALES) {
            
            cerealA = cereales.get(0);
            cerealB = cereales.get(1);
            cerealC = cereales.get(2);
            
        } else {
            
            System.out.println("Error en el número de cereales en el archivo " + 
                    PREFIJO_RUTA_ARCHIVOS + ARCHIVO_CEREALES);
            System.exit(0);
                        
        }        
        
    }
    
}
