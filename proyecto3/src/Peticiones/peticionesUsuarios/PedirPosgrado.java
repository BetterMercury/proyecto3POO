
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import Usuarios.empleados.Editor;
import Usuarios.empleados.Empleado;
import java.util.Scanner;

/**
 * Clase que hereda de la clase abstracta PeticionPersona;
 * sirve para representar la petición (operación) de pedirle
 * el atributo posgrado al usuario, implementando el método
 * realizarPeticion.
 * @author Equipo 9
 * 
 */
public class PedirPosgrado extends PeticionPersona {
    
        /**
        * Método implementado de la clase padre que se encarga de pedir
        * el posgrado de un objeto Editor.
        * @param objetivo Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía de Persona.
        * @throws ErrorDeDatoException Esta excepción es usada para indicar que el 
        * posgrado ingresado no es el correcto.
        */
    @Override
        public void realizarPeticion(Persona objetivo) throws ErrorDeDatoException {
        
        
        String posgrado;
        Scanner sc = new Scanner(System.in);
        System.out.print("Posgrado (Doctorado o Maestria): ");
        posgrado = sc.nextLine();
        Editor ed = (Editor)objetivo;
        
        if(posgrado.compareTo("Doctorado") == 0){       //condicion de solo colocar dos posgrados
            ed.setPosgrado(posgrado);
        }else if(posgrado.compareTo("Maestria") == 0){
            ed.setPosgrado(posgrado);
        }else{
            throw new ErrorDeDatoException("No se ha ingreso un posgrado valido, solo 'Doctorado' o 'Maestria'");
        }
        
    }
}