
package operaciones;

import Usuarios.Persona;

public class Operacion2 implements Operacion {
    public String toString(){
        return "Operacion 2";
    }

    @Override
    public void realizarOperacion(Persona operador) {
        System.out.println(" realizando Operacion2");
    }
    
}
