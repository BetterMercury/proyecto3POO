
package Peticiones.peticionesRevista;

import Excepciones.ListaVaciaException;
import Revista.Revista;
import articulo.Articulo;
import java.util.LinkedList;

/**
 * Clase que permite asociar una lista de artículos a una
 * Revista.
 * @author Dante
 */
public class pedirListaArticulos extends PeticionesRevista{

     /**
        * Método implementado de la clase padre que se encarga de asociar
        * una lista de artículos a un objeto de la clase Revista.
        * @param objetivo Un objeto de la clase Revista, al cual se le 
        * asignará un conjunto de artículos.
        **/
    @Override
    public void realizarPeticion(Revista objetivo) {
        LinkedList<Articulo> articulos = null; //Adaptar, esto debe ser un TreeSet
        System.out.println("Se agregara la lista de articulos a la Revista");
        try{
            if(articulos.isEmpty()){
                throw new ListaVaciaException();
            } else{
                objetivo.setArticulos(articulos);
                System.out.println("La lista se ha asociado exitosamente");
            }
        } catch(ListaVaciaException e){
            System.out.println(e.getMessage());
            System.out.println("No se ha asociado la lista");
        }
    }    
}
