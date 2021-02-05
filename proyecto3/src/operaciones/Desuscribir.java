
package operaciones;

import Usuarios.Persona;
import Usuarios.suscriptor.Suscriptor;
import datos.Dato;

/**
 *  Clase que realiza el proceso de desuscripción, por 
 * medio de una referencia a la instancia Dato.
 * @author ribel
 */
public class Desuscribir extends Operacion {

    @Override
    public void realizarOperacion(Persona operador) {
        Dato accesoDatos = Dato.getInstance();
        if(accesoDatos.eliminarSuscriptor((Suscriptor)operador)){
            System.out.println("Ya no eres un suscriptor, la proxima vez"
                    + " que salgas de tu cuenta no podrás volver a ingresar"
                    + " gracias por usar el servicio");
        }else{
            System.out.println("Ocurrio un error en el proceso de eliminacion"
                    + " de tu cuenta");
        }
    }
    
    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString(){
        return "Eliminar cuenta";
    }
    
}
