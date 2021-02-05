
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import Usuarios.empleados.Editor;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que hereda de la clase abstracta PeticionPersona;
 * sirve para representar la petición (operación) de pedirle
 * el atributo cédula profesional al usuario, implementando el método
 * realizarPeticion.
 * @author Equipo 9
 * 
 */
public class PedirCedula extends PeticionPersona {
    
     /**
        * Método implementado de la clase padre que se encarga de pedir
        * la cédula de un objeto de la clase Editor.
        * @param objetivo Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * @throws ErrorDeDatoException Esta excepción es usada para indicar que la 
        * cédula ingresada no es correcta por el tipo de dato.
        */
        @Override
        public void realizarPeticion(Persona objetivo) throws ErrorDeDatoException {
        
            
        int numeroCedula;
        Scanner sc = new Scanner(System.in);
        System.out.print("Numero de cedula (5 digitos): ");
        try{
            numeroCedula = sc.nextInt();
        }catch(IllegalArgumentException | InputMismatchException e){
            throw new ErrorDeDatoException("Ingresa nuevamente el numero de cedula, pero ahora solo con numeros");
        }
        Editor ed = (Editor)objetivo;
           
        int cifras;
        int numCed = numeroCedula;
   
        cifras= 0;    //esta variable es el contador de cifras
        while(numCed!=0){             //mientras a numCed le queden cifras
            numCed = numCed/10;         //le quitamos el último dígito
            cifras++;          //sumamos 1 al contador de cifras
        }
        
        if((numCed == 5) ){   //se forza a tener 5 cifras en el numero de cedula
            ed.setNumeroCedula(numeroCedula); 
        }else{
            System.out.println(" ");
            throw new ErrorDeDatoException("El numero de cedula debe ser de 5 digitos");
        }
        
    }
}
