
package Excepciones;

/**
 *Clase que representa la excepción personalizada
 * de que una lista está vacía; hereda de la clase
 * Exception.
 * @author Dante
 */
public class ListaVaciaException extends Exception {

    /**
     * Constructor de la clase que, utiliza el 
     * constructor de la clase padre Exception 
     * para imprimir un mensaje de error.
     */
    public ListaVaciaException() {
        super("Error: La lista ingresada no tiene ningun elemento");
    }
        
}
