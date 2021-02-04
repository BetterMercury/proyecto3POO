
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import java.util.Scanner;
import Usuarios.Persona;

/**
 * Clase que hereda de la clase abstracta PeticionPersona;
 * sirve para representar la petición (operación) de pedirle
 * el atributo apellido materno al usuario, implementando el método
 * realizarPeticion.
 * @author Equipo 9
 * 
 */
public class PedirApellidoMaterno extends PeticionPersona{

    /**
        * Método implementado de la clase padre que se encarga de pedir
        * el apellido materno de un objeto de la jerarquía de la clase Persona.
        * @param objetivo Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * @throws ErrorDeDatoException Esta excepción es usada para indicar que el 
        * formato del apellido materno ingresado no es correcto.
        */
    @Override
    public void realizarPeticion(Persona objetivo) throws ErrorDeDatoException {
        String nombre;
        Scanner sc = new Scanner(System.in);
        System.out.print("Apellido materno (menor a 15 caracteres \ny sin digitos): ");
        nombre = sc.nextLine();

        if((nombre.length()==0) ||nombre.length()>15 || !sinNumeros(nombre)){
            throw new ErrorDeDatoException("Formato de apellido incorrecto");
        }
        objetivo.setApellidoMaterno(nombre);
    }

    /**
        * Método que nos ayuda a determinar si en el apellido materno se ingresó un 
        * caracter inválido como un número.
        * @param cadena La cadena en donde se almacenó el apellido materno ingresado, para
        * trabajar con él y verificar si el formato es válido.
        * @return Retorna un booleano true si no se detectaron números y un false
        * si se detectaron números.
        */
    private boolean sinNumeros(String cadena){
        for(char c: cadena.toCharArray()){
            return !Character.isDigit(c);
        }
        return true;
    }


}
