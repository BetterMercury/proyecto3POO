
package Peticiones.peticionesRevista;

import Excepciones.ErrorDeDatoException;
import Revista.Revista;
import java.util.Scanner;

/**
 * Clase que permite asociar un título principal a una revista,
 * dicho título debe ser mayor a 4 caracteres.
 * @author Dante
 */
public class pedirTitulo extends PeticionesRevista{
    
    /**
        * Método implementado de la clase padre que se encarga de asociar
        * un título a un objeto de la clase Revista.
        * @param objetivo Un objeto de la clase Revista, al cual se le 
        * asignará un título.
        **/
    @Override
    public void realizarPeticion(Revista objetivo){
        String title;
        Scanner sc = new Scanner(System.in);
        
        while(true){        
            System.out.print("Título de Revista \n(Mayor a 4 caracteres): ");
            try{
                title = sc.nextLine();
                if(title.length()<4)
                    throw new ErrorDeDatoException("Error: La longitud del título debe ser mayor a 4 caracteres");            
                
            } catch(ErrorDeDatoException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        objetivo.setTitulo(title);
    }    
}
