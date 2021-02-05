
package Peticiones.peticionesArticulos;

import Excepciones.ErrorDeDatoException;
import articulo.Articulo;
import static articulo.Articulo.*;
import static articulo.Categoria.CAT1;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *Clase que se encarga de asignarle una categoría a 
 * un artículo dado.
 * @author Dante
 */
public class pedirCategoria extends PeticionesArticulo{

    /**
        * Método implementado de la clase padre que se encarga de asignarle
        * una categoría a un objeto de la clase Articulo.
        * @param objetivo Un objeto de la clase Articulo para poder asignarle
        * una categoría.
        * @throws ErrorDeDatoException Se usa esta excepción general
        * para poder validar la condición de números o de opciones 
        * limitadas por los casos de la estructura switch-case.
        * */
    @Override
    public void realizarPeticion(Articulo objetivo) throws ErrorDeDatoException{
        Scanner sc = new Scanner(System.in);
        int seleccion;
        System.out.println("Se asignara una categoria al articulo");
        System.out.println("Elegir alguna de las siguientes opciones");
        System.out.println("1. " + CAT1);
        System.out.println("2. " + CAT2);
        System.out.println("3. " + CAT3);
        System.out.println("4. " + CAT4);        
        
        
        try{
            System.out.print("Ingrese numero: ");
            seleccion = sc.nextInt();
        }catch(IllegalArgumentException | InputMismatchException e){
            throw new ErrorDeDatoException("Ingresa nuevamente el numero de categoria, pero ahora solo numero");
        }
        
        
        switch(seleccion){
            case 1:
                objetivo.setCategoria(CAT1);
                break;
            case 2:
                objetivo.setCategoria(CAT2);                
                break;
            case 3:
                objetivo.setCategoria(CAT3);                
                break;
            case 4: 
                objetivo.setCategoria(CAT4);                
                break;
            default:
                throw new ErrorDeDatoException("Ingresa nuevamente el numero de categoria, pero ahora un numero valido");
        }
        
    }


}
