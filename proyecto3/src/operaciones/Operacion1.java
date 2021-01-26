package operaciones;

import Usuarios.Persona;

public class Operacion1 implements Operacion {
    public String toString(){
        return "Operacion 1";
    }

    @Override
    public void realizarOperacion(Persona operador) {
        System.out.println(" realizando Operacion1");

    }
    
}
