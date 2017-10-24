package cliente.test;

import cliente.controlador.ControladorCereal;
import cliente.modelo.ModeloCereal;
import cliente.view.VistaCereal;
import servidor.bitacora.Bitacora;

public class VotacionCereal {
    
    public static void main(String[] args) {
        
        Bitacora bitacora = new Bitacora();
        final String nombreClase = "VotacionCereal";
        
        bitacora.guardarRegistro("main(String[] args)", nombreClase);
        
        bitacora.guardarRegistro("ModeloCereal modelo = new ModeloCereal()", nombreClase);
        ModeloCereal modelo = new ModeloCereal();
        
        bitacora.guardarRegistro("VistaCereal vista = new VistaCereal()", nombreClase);
        VistaCereal vista = new VistaCereal();
        
        bitacora.guardarRegistro("ControladorCereal controlador = new ControladorCereal(modelo, vista)", nombreClase);
        ControladorCereal controlador = new ControladorCereal(modelo, vista);
        
        bitacora.guardarRegistro("controlador.iniciarVista()", nombreClase);
        controlador.iniciarVista();
        
    }
    
}
