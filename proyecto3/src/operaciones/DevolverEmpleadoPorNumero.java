
package operaciones;

import Usuarios.Persona;
import Usuarios.empleados.Empleado;
import datos.Dato;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *Clase que hereda de la clase abstracta Operacion y sirve 
 * para mostrar información de un empleado mediante su número 
 * de identificación único.
 * @author ribel
 */
public class DevolverEmpleadoPorNumero extends Operacion {

    /**
        * Método implementado de la clase padre que se encarga de mostrar 
        * información de un empleado mediante su número de identificación 
        * único.
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
            Empleado empleado;
            System.out.println("Ingresa el numero unico");
            try{
            numeroUnico = sc.nextInt();  
            }catch (InputMismatchException e){
                System.out.println("Solo se admite un numero entero");
                return;
            }
            empleado = accesoDatos.buscarNumeroEmpleado(numeroUnico);
            if(empleado == null){
                System.out.println("No se encontro al empleado");
            }else{
                empleado.toString();
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
        return "Mostrar información de un empleado por su numero unico";
    }
}
