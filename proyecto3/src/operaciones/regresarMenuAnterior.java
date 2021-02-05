
package operaciones;

import Usuarios.Persona;

/**
 *Clase que sirve para poder representar la operación de retornar 
 * al menú anterior de donde se está.
 * @author ribel
 */
public class regresarMenuAnterior extends Operacion{

    /**
        * Método implementado de la clase padre que se encarga de no hacer nada
        * para así poder regresar al menú anterior de donde se está.
        * @param operador Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * 
        */
    @Override
    public void realizarOperacion(Persona operador) {}
    
    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString(){
        return "Regresar al menu anterior";
    }
}
