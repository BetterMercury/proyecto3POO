
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import java.util.Scanner;

/**
 * Clase que hereda de la clase abstracta PeticionPersona;
 * sirve para representar la petición (operación) de pedirle
 * el atributo correo al usuario, implementando el método
 * realizarPeticion.
 * @author Equipo 9
 * 
 */
public class PedirCorreo extends PeticionPersona{
    
    /**
        * Método implementado de la clase padre que se encarga de pedir
        * el correo de un objeto de la jerarquía de la clase Persona.
        * @param objetivo Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * @throws ErrorDeDatoException Esta excepción es usada para indicar que el 
        * correo ingresado no es correcto por su tamaño.
        */
        @Override
        public void realizarPeticion(Persona objetivo) throws ErrorDeDatoException {
            String nombre;
            Scanner sc = new Scanner(System.in);
            System.out.print("Correo: ");
            nombre = sc.nextLine();
            if(nombre.length()==0){
                throw new ErrorDeDatoException("Debes ingresar un correo"
                        + " obligatoriamente");
            }
            objetivo.setEmail(nombre);
        }
}

