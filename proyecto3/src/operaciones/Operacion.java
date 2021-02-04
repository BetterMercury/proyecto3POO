package operaciones;

import Usuarios.Persona;
import java.io.Serializable;

/**
 * Clase abstracta que representa una operación general como 
 * las que realizan los tipos de dato que heredan de Persona 
 * dentro del programa; implementa la interfaz serializable
 * para poder guardar información de esta clase en archivos.
 * @author Equipo 9
 * 
 */
public abstract class Operacion implements Serializable {
    
    /**
     * Método abstracto que se encarga de indicar la operación necesaria
     * que va a implementar cualquier clase hija a su manera.
     * @param operador Un objeto de la clase abstracta Persona, con el cual
     * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
     * de su jerarquía.
     * 
     */
    public abstract void realizarOperacion(Persona operador);
}
