
package Excepciones;

/**
 * Esta excepción es lanzada cuando se intentan colocar más de tres
 * autores a un Artículo.
 * @author Dante
 */
public class TresAutoresException extends Exception{

    /**
     * Constructor de la clase que, utiliza el 
     * constructor de la clase padre Exception 
     * para imprimir un mensaje de error.
     */
    public TresAutoresException() {
        super("Error: Sólo pueden existir tres autores en un artículo");
    }    
    
}
