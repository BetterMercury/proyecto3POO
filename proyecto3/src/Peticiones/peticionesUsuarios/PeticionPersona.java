package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import java.io.Serializable;

/**
 * Clase abstracta que representa una operación general como 
 * las peticiones para ingresar datos de los tipos de dato 
 * Persona dentro del programa; implementa la interfaz serializable
 * para poder guardar información de esta clase en archivos.
 * @author Equipo 9
 * 
 */
public abstract class PeticionPersona implements Serializable {
    
    /**
     * Método abstracto que se encarga de indicar la petición necesaria
     * que va a implementar cualquier clase hija a su manera.
     * @param objetivo Un objeto de la clase abstracta Persona, con el cual
     * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
     * de su jerarquía.
     * @throws ErrorDeDatoException Esta excepción es usada de forma general
     * para poder tratar condiciones inesperadas en la entrada de datos y mal uso
     * de clases u objetos.
     */
    public abstract void realizarPeticion(Persona objetivo) throws ErrorDeDatoException;
}
