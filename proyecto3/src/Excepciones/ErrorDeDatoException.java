package Excepciones;

/**
 * Excepción útil para manejar una correcta entrada
 * de datos, según cada caso se tendrá un mensaje
 * personalizado.
 * @author Ricardo
 */
public class ErrorDeDatoException extends Exception{
    /**
     * Constructor de la clase que, utiliza el 
     * constructor de la clase padre Exception 
     * para imprimir un mensaje de error personalizado.
     * @param mensaje Mensaje de error personalizado, el 
     * cual se lanzará cuando ocurrá una excepción de 
     * este tipo.
     */
    public ErrorDeDatoException(String mensaje) {
        super(mensaje);
    }
}
