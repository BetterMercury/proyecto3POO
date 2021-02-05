
package Peticiones.peticionesRevista;

import Revista.Revista;
import static Revista.Revista.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que incluye un método para ingresar el estado a una Revista, puede ser
 * publicada o no publicada; se aprovechó la interfaz Estado 
 * para hacer las operaciones de este método.
 * Nota: La interfaz Estado la implementa la Revista objetivo.
 * @author Dante
 */
public class pedirEstado extends PeticionesRevista{ //NOTA: Falta verificación, para que el usuario no ingrese cosas extrañas

    /**
        * Método implementado de la clase padre que se encarga de asignar el
        * estado de una revista según decida el usuario.
        * @param objetivo Un objeto de la clase Revista, al cual se le 
        * asignará un estado.
        **/
    @Override
    public void realizarPeticion(Revista objetivo) {
        Scanner sc = new Scanner(System.in);
        int seleccion;
        System.out.println("Se asignara un estado a la revista");
        System.out.println("Elegir alguna de las siguientes opciones");
        System.out.println("1. " + getSTATER1());
        System.out.println("2. " + getSTATER2());
        
        
        while(true){
            try{
                System.out.print("Ingrese numero: ");
                seleccion = sc.nextInt();
            }catch(IllegalArgumentException | InputMismatchException ie){
                System.out.println(" ");
                System.out.println("Ingrese un numero, intentelo nuevamente");
                continue;
            }
            break;
        }
        
        
        if(seleccion == 1){
            objetivo.setEstado(STATER1);
        } else {
            objetivo.setEstado(STATER2);
        }
        
    }
    
}
