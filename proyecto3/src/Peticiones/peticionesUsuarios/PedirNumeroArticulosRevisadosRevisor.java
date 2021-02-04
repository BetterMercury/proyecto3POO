
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import Usuarios.empleados.Revisor;
import articulo.Articulo;
import java.util.Scanner;

/**
 * Clase que sirve como operación; sirve para representar la petición 
 * (operación) de incrementar el númmero de artículos revisados por 
 * Revisor, implementando el método realizarPeticion.
 * @author Equipo 9
 * 
 */
public class PedirNumeroArticulosRevisadosRevisor{
    
    /**
        * Método que se encarga de incrementar
        * el número de artículos revisados por Revisor
        * @param revi Un objeto de la clase Revisor para poder modificar su
        * atributo numArticulosRevisados.
        * @param articulo Un objeto de la clase Articulo para almacenarlo
        * en la lista de artículos revisados del objeto Revisor.
        * 
        */
    public void realizarPeticion(Revisor revi, Articulo articulo) {
        
        //incremento en el numero de articulos revisados
        int numeroArticulosRevisados = 0;
       
        numeroArticulosRevisados = revi.getNumeroArticulosRevisados() + 1;
        
        revi.setNumeroArticulosRevisados(numeroArticulosRevisados);
        
        //asignacion del articulo revisado al revisor
        revi.setArticulosRevisados(articulo);
        
    }
}