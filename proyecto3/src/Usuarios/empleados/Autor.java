
package Usuarios.empleados;

import Peticiones.peticionesUsuarios.PedirInstitucion;
import Peticiones.peticionesUsuarios.PedirNumeroArticulosEscritosAutor;
import articulo.Articulo;
import java.util.LinkedList;
import java.util.List;
import operaciones.CrearArticulo;
/**
 * Clase que representa al sujeto Autor, el cual hereda de Empleado;
 * cuenta con características y atributos propios como la creación de artículos.
 * @author Equipo 9
 * 
 */
public class Autor extends Empleado{
    
    /**
    * Constructor de la clase Autor que utiliza el constructor de su clase 
    * padre; se encarga de inicializar las listas de peticiones y operaciones,
    * haciendo uso de objetos y polimorfismo.
    **/
    public Autor(){
        super();
        this.peticonesNecesarias.add(new PedirInstitucion());
        //this.peticonesNecesarias.add(new PedirNumeroArticulosEscritosAutor());
        this.operacionesDisponible.add(new CrearArticulo());
    }
    
    String institucion;
    int numeroArticulosEscritos;
    List<Articulo> articulosEscritos = new LinkedList<>();
    
    /**
     * Método de acceso para obtener la institución de un objeto Autor.
     * @return Retorna la institución de este Autor en cadena.
     **/
    public String getInstitucion(){
        return institucion;
    }
    
     /**
     * Método de acceso para establecer la institución de un objeto Autor.
     * @param institucion La institucion en cadena que se le pondrá al objeto.
     */
    public void setInstitucion(String institucion){
        this.institucion = institucion;
    }
    
    /**
     * Método de acceso para obtener el número de artículos escritos de un objeto Autor.
     * @return Retorna el número de artículos escritos de este Autor en número entero.
     **/
    public int getNumeroArticulosEscritos(){
        return numeroArticulosEscritos;
    }

     /**
     * Método de acceso para establecer el numero de artículos escritos de un objeto Autor.
     * @param numeroArticulosEscritos El numero de artículos escritos en número entero que se le pondrá al objeto.
     */
    public void setNumeroArticulosEscritos(int numeroArticulosEscritos) {
            this.numeroArticulosEscritos = numeroArticulosEscritos;
    }
    
    /**
     * Método de acceso para obtener el artículo escrito de un objeto Autor.
     * @return Retorna el artículo asociado a este Autor en Articulo.
     **/
    public Articulo getArticulosEscritos(int i){
        return articulosEscritos.get(i);
    }

     /**
     * Método de acceso para establecer el artículo de un objeto Autor.
     * @param art El artículo en Articulo que se le pondrá al objeto.
     */
    public void setArticulosEscritos(Articulo art) {
            this.articulosEscritos.add(art);
    }

    /**
     * Método toString sobreescrito para poder imprimir las características
     * y atributos principales de un objeto Autor.
     * @return Una descripción breve de los atributos de un objeto Autor en cadena.
     */
    @Override
    public String toString() {
        return "Institucion : " + institucion + 
                "\nNumero de articulos escritos : " + numeroArticulosEscritos;
    }
    
    
}
