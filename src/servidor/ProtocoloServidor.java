package servidor;

public class ProtocoloServidor {
    
    private static final int ESPERANDO = 0;
    private static final int CONECTANDO = 1;
    private static final int EJECUTANDO = 2;
    private int state = ESPERANDO;

    public String processInput(String theInput) {
        
        String theOutput = null;
        
        if (state == ESPERANDO) {
            theOutput = "Conexion exitosa!";
            state = CONECTANDO;
        } else if (state == CONECTANDO) {
            theOutput = theInput;
            state = EJECUTANDO;
        }else if(state == EJECUTANDO){
            theOutput = "cerrar";
        }

        return theOutput;

    }
    
}

