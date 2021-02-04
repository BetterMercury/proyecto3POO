
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Peticiones.peticionesUsuarios.PeticionPersona;
import Usuarios.Persona;
import java.io.Console;
import java.util.Scanner;

/**
 * Clase que hereda de la clase abstracta PeticionPersona;
 * sirve para representar la petición (operación) de pedirle
 * el atributo contraseña al usuario, implementando el método
 * realizarPeticion.
 * @author Equipo 9
 * 
 */
public class PedirContrasenia extends PeticionPersona{

    /**
        * Método implementado de la clase padre que se encarga de pedir
        * la contraseña de un objeto de la jerarquía de la clase Persona.
        * @param objetivo Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * @throws ErrorDeDatoException Esta excepción es usada para indicar que la 
        * contraseña ingresada no es correcta por su longitud.
        */
    @Override
    public void realizarPeticion(Persona objetivo) throws ErrorDeDatoException {
        Console consola = System.console();
        String contrasenia;
        System.out.println("Nueva contrasenia: ");
        if(consola != null){
            contrasenia = String.valueOf(consola.readPassword());
        }else{
            Scanner sc = new Scanner(System.in);
            contrasenia = sc.nextLine();
        }
        if(contrasenia.length()<8){
            throw new ErrorDeDatoException("La contrasenia debe tener al menos"
                    + " 8 caracteres");
        }
        objetivo.setContrasena(contrasenia);
    }
    
}
