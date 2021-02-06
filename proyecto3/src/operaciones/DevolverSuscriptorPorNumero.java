
package operaciones;

import java.util.InputMismatchException;
import java.util.Scanner;

import Usuarios.Persona;
import Usuarios.empleados.Empleado;
import Usuarios.suscriptor.Suscriptor;
import datos.Dato;

/**
 *Clase que hereda de la clase abstracta Operacion y sirve 
 * para mostrar información de un suscriptor mediante su número
 * de identificación.
 * @author ribel
 */
public class DevolverSuscriptorPorNumero extends Operacion {

    /**
        * Método implementado de la clase padre que se encarga de mostrar 
        * información de un suscriptor mediante su número de identificación.
        * @param operador Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * 
        */
    @Override
    public void realizarOperacion(Persona operador) {
        if(!(operador instanceof Empleado)){
            System.out.println("Esta clase no deberia tener acceso a esta operacion");
        }else{
            int numeroUnico;
            Dato accesoDatos = Dato.getInstance();
            Scanner sc = new Scanner(System.in);
            Suscriptor suscriptor;
            System.out.println("Ingresa el numero unico");
            try{
            numeroUnico = sc.nextInt();  
            }catch (InputMismatchException e){
                System.out.println("Solo se admite un numero entero");
                return;
            }
            suscriptor = accesoDatos.buscarNumeroSuscriptor(numeroUnico);
            if(suscriptor == null){
                System.out.println("No se encontro al suscriptor");
            }else{
                System.out.println(suscriptor.toString());
            }
            
        }

    }
    
    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString() {
        return "Mostrar información de un suscriptor por su numero";
    }
}

