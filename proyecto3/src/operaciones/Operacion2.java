
package operaciones;

import Usuarios.Persona;

public class Operacion2 implements Operacion {
    
    @Override
    public String toString(){
        return "Operacion 2";
    }

    @Override
    public void realizarOperacion(Object operador) {
        System.out.println(" realizando Operacion2");
    }
}
