
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import Usuarios.empleados.Autor;
import articulo.Articulo;

/**
 * Clase que sirve como operación; sirve para representar la petición 
 * (operación) de incrementar el número de artículos escritos por 
 * Autor, implementando el método realizarPeticion.
 * @author Equipo 9
 * 
 */
public class PedirNumeroArticulosEscritosAutor{
    
    /**
        * Método que se encarga de incrementar
        * el número de artículos escritos por Autor
        * @param aut Un objeto de la clase Autor para poder modificar su
        * atributo numArticulosEscritos.
        * @param articulo Un objeto de la clase Articulo para almacenarlo
        * en la lista de artículos escritos del objeto Autor.
        * 
        */
    public void realizarPeticion(Autor aut, Articulo articulo) {
        
        //incremento en el numero de articulos creados
        int numeroArticulosEscritos = 0;
       
        numeroArticulosEscritos= aut.getNumeroArticulosEscritos() + 1;
        
        aut.setNumeroArticulosEscritos(numeroArticulosEscritos);
        
        //asignacion del articulo creado al autor
        aut.setArticulosEscritos(articulo);
    }
}