
package Peticiones.peticionesArticulos;

import Excepciones.ErrorDeDatoException;
import articulo.Articulo;
import java.util.Scanner;

/**
 *  Esta clase permite asociar un Título a un Articulo.
 * @author ribel
 */
public class pedirTitulo extends PeticionesArticulo{

    /**
        * Método implementado de la clase padre que se encarga de asignarle
        * un título a un objeto de la clase Articulo.
        * @param objetivo Un objeto de la clase Articulo para poder asignarle
        * un título.
        * @throws ErrorDeDatoException Se usa esta excepción general
        * para poder validar la condición de que el título no 
        * sea menor que 4 caracteres.
        * */
    @Override
    public void realizarPeticion(Articulo objetivo) throws ErrorDeDatoException {
        String title;
        Scanner sc = new Scanner(System.in);
        
        while(true){        
            System.out.print("Título del Articulo \n(Mayor a 4 caracteres): ");
            try{
                title = sc.nextLine();
                if(title.length()<4)
                    throw new ErrorDeDatoException("Error: La longitud del título debe ser mayor a 4 caracteres");            
                break;
            } catch(ErrorDeDatoException e){
                System.out.println(e.getMessage());
            }
        }
        objetivo.setTitulo(title);
    }   
        
}
    

