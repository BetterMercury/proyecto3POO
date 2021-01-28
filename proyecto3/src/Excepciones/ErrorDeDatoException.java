package Excepciones;

/**
 * Excepción útil para manejar una correcta entrada
 * de datos, según cada caso se tendrá un mensaje
 * personalizado.
 * @author Ricardo
 */
public class ErrorDeDatoException extends Exception{
    public ErrorDeDatoException(String mensaje) {
        super(mensaje);
    }
}
