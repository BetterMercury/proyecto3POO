package operaciones;

import Revista.Revista;
import Usuarios.Persona;
import articulo.Articulo;

/**
 * Esta interfaz es útil para mostrar el menú principal y elegir
 * alguna operación.
 * @author Dante
 */
public interface Operacion {
    
    void realizarOperacion(Object operador);
    
    /*
    Esta pudo haber sido una alternativa, pero estamos utilizando una interfaz
    y tendríamos que definir todos los métodos en cada operación.
    
    void realizarOperacion(Persona persona);
    
    void realizarOperacion(Revista operador); 
    
    void realizarOperacion(Articulo articulo);
    */
}
