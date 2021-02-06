
package Peticiones.peticionesArticulos;

import Excepciones.ErrorDeDatoException;
import articulo.Articulo;
import java.util.Scanner;

/**
 * Esta clase permite añadirle una sinopsis de no mas de 160 caracteres
 * a un Articulo.
 * @author Dante
 */
public class pedirSinopsis extends PeticionesArticulo{

    /**
        * Método implementado de la clase padre que se encarga de asignarle
        * una sinopsis a un objeto de la clase Articulo.
        * @param objetivo Un objeto de la clase Articulo para poder asignarle
        * una sinopsis.
        * @throws ErrorDeDatoException Se usa esta excepción general
        * para poder validar la condición de que la sinopsis no 
        * exceda el limite de 160 caracteres.
        * */
    @Override
    public void realizarPeticion(Articulo objetivo) throws ErrorDeDatoException{
        String sinopsis;
        Scanner sc = new Scanner(System.in);
        
        while(true){        
            System.out.print("Sinopsis del artículo(160 caracteres minimo): ");
            try{
                sinopsis = sc.nextLine();
                if(sinopsis.length()<160)
                    throw new ErrorDeDatoException("Error: La sinopsis debe ser menor a 160 caracteres");            
                break;
            } catch(ErrorDeDatoException e){
                System.out.println(e.getMessage());
            }
        }
        objetivo.setSnopsis(sinopsis);
    }           
}
    

