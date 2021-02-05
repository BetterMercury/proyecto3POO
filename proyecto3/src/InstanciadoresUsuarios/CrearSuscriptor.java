
package InstanciadoresUsuarios;

import Usuarios.Persona;
import Usuarios.suscriptor.Suscriptor;
import datos.Dato;
import operaciones.Operacion;

/**
 *Clase para la instanciación de nuevos suscriptores. El método realizarOperacion
 *llama a todos los métodos necesarios para agregar al suscriptor a los mapas 
 * correspondientes de dato y para llenar los datos de la misma instancia.
 */
public class CrearSuscriptor extends Instanciador{

    /**
        * Método implementado de la clase padre que se encarga de crear 
        * un suscriptor nuevo e ingresarlo al programa.
        * @param operador Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * 
        */
    @Override
    public void realizarOperacion(Persona operador) {
        Suscriptor nuevaInstancia = new Suscriptor();
        nuevaInstancia.pedirDatos();
        Dato accesoDatos = Dato.getInstance();
        if (accesoDatos.aniadirSuscriptor(nuevaInstancia)){
            System.out.println("Suscriptor creado con exito");
            System.out.println("El numero de identificacion unico es "
                + nuevaInstancia.getNumeroSuscriptor());
            System.out.println("Conservalo, lo usaras para iniciar sesion"
                + " en el programa");
        }else{
            System.out.println("No se pudo crear sal suscriptor porque ya "
                    + "existe");
        }
    }
    
    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString() {
        return "Registrar suscriptor";
        
    }
}
