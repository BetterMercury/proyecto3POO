package operaciones;

import Usuarios.Persona;

public class Operacion1 implements Operacion {
    
    @Override 
    public String toString(){
        return "Operacion 1";
    }

    @Override
    public void realizarOperacion(Object operador) {
        System.out.println(" realizando Operacion1");

    }
    
}
