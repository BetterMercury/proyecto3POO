
package Peticiones.peticionesRevista;

import Excepciones.ErrorDeDatoException;
import Revista.Revista;
import java.io.Serializable;

/**
 * Clase abstracta que representa una operación general como 
 * las peticiones para ingresar datos de los tipos de dato 
 * Revista dentro del programa; implementa la interfaz serializable
 * para poder guardar información de esta clase en archivos.
 * @author Equipo 9
 * 
 */
public abstract class PeticionesRevista implements Serializable {
    
    /**
     * Método abstracto que se encarga de indicar la petición necesaria
     * que va a implementar cualquier clase hija a su manera.
     * @param objetivo Un objeto de la clase Revista, con el cual
     * se va a trabajar para el llenado de datos de sus atributos.
     * @throws ErrorDeDatoException Esta excepción es usada de forma general
     * para poder tratar condiciones inesperadas en la entrada de datos y mal uso
     * de clases u objetos.
     */
   public abstract void realizarPeticion(Revista objetivo) throws ErrorDeDatoException;
   
}
