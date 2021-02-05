
package InstanciadoresUsuarios;

import Usuarios.Persona;
import java.io.Serializable;

/**
 * Clase abstracta que sirve para que todos los instanciadores se puedan almacenar
 * en una misma colección. Implementa serializabe para que los objetos
 * que la implementan puedan ser guardados en un archivo.
 * @author ribel
 */
public abstract class Instanciador implements Serializable {
    
    /**
        * Método abstracto que se encarga de establecer la 
        * operación de creación de sujetos Persona.
        * @param creador Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * 
        */
    public abstract void realizarOperacion(Persona creador);
    
}
