
package Usuarios.empleados;

import Peticiones.peticionesUsuarios.PedirInstitucion;
import Peticiones.peticionesUsuarios.PedirInteresRevisor;
import Peticiones.peticionesUsuarios.PedirNumeroArticulosRevisadosRevisor;
import Usuarios.empleados.Empleado;
import articulo.Articulo;
import java.util.Enumeration;

import java.util.LinkedList;
import java.util.List;
import java.util.Hashtable; //es sincronizada, para multi hilos
import java.util.Map;
import java.util.stream.Collectors;
import operaciones.RevisarArticulo;

/**
 * Clase que representa al sujeto Revisor, el cual hereda de Empleado;
 * cuenta con características y atributos propios como la revisión de artículos.
 * @author Equipo 9
 * 
 */
public class Revisor extends Empleado{
    
    /**
    * Constructor de la clase Revisor que utiliza el constructor de su clase 
    * padre; se encarga de inicializar las listas de peticiones y operaciones,
    * haciendo uso de objetos y polimorfismo.
    **/
    public Revisor(){
        super();
        this.peticonesNecesarias.add(new PedirInstitucion());
        this.peticonesNecesarias.add(new PedirInteresRevisor());
        //this.peticonesNecesarias.add(new PedirNumeroArticulosRevisadosRevisor());
        this.operacionesDisponible.add(new RevisarArticulo());
    }
    
    String institucion;
    List<String> listaAreasInteres = new LinkedList<String>();
    Hashtable<String,Integer> areaInteresExperiencia = new Hashtable<>();   //tabla hash que relaciona areas de interes con años de experiencia
    int numeroArticulosRevisados = 0;
    List<Articulo> articulosRevisados = new LinkedList<>(); //lista de articulos revisados
    
    /**
     * Método de acceso para obtener la institución de un objeto Revisor.
     * @return Retorna la institución de este Revisor en cadena.
     **/
    public String getInstitucion(){
        return institucion;
    }
    
    /**
     * Método de acceso para establecer la institución de un objeto Revisor.
     * @param institucion La institucion en cadena que se le pondrá al objeto.
     */
    public void setInstitucion(String institucion){
        this.institucion = institucion;
    }
    
    /**
     * Método de acceso para obtener el área de interés de un objeto Revisor.
     * @return Retorna el área de interés de este Revisor en cadena.
     **/
    public String getInteres(int i){    //recibe un indice, y retorna el interes de ese indice
        if( (i >= 0) && (i < listaAreasInteres.size()) ){
            return listaAreasInteres.get(i);
        }else{
            System.out.println(" ");
            System.out.println("Indice no valido");
        }
        return "Error";
    }
    
    /**
     * Método de acceso para establecer el área de interés de un objeto Revisor.
     * @param interes El área de interés en cadena que se le pondrá al objeto.
     * @param experiencia Los años de experiencia en entero que se le pondrá al área de interés.
     */
    public void setInteres(String interes, int experiencia){     //se agregan los intereses de los revisores
        this.listaAreasInteres.add(interes);
        areaInteresExperiencia.put(interes, experiencia);   //en la tabla hash se coloca el interes y la experiencia
    }
    
    /**
     * Método de acceso para obtener el número de artículos revisados de un objeto Revisor.
     * @return Retorna el número de artículos revisados de este Revisor en entero.
     **/
    public int getNumeroArticulosRevisados(){
        return numeroArticulosRevisados;
    }

    /**
     * Método de acceso para establecer el número de artículos revisados de un objeto Revisor.
     * @param numeroArticulosRevisados El número de artículos revisados en entero que se le pondrá al objeto.
     */
    public void setNumeroArticulosRevisados(int numeroArticulosRevisados) {
            this.numeroArticulosRevisados = numeroArticulosRevisados;
    }
    
    /**
     * Método de acceso para obtener artículos revisados de un objeto Revisor.
     * @return Retorna el artículo revisado de este Revisor en Articulo.
     **/
    public Articulo getArticulosRevisados(int i){
        return articulosRevisados.get(i);
    }

    /**
     * Método de acceso para establecer artículos revisados de un objeto Revisor.
     * @param art El artículo revisado en Articulo que se le pondrá al objeto.
     */
    public void setArticulosRevisados(Articulo art) {
            this.articulosRevisados.add(art);
    }
    
    /**
     * Método que convierte la lista de intereses en un String para
     * su impresion facil. En el metodo toString() de esta clase no 
     * se emplea (hasta ahora).
     * @return Retorna una cadena con los intereses de este Revisor.
     */
    private String interesesToString(){
        String list = this.listaAreasInteres.stream().map(n -> String.valueOf(n)).collect(Collectors.joining("\n", "{", "}"));
        return list;
    }
    
    /**
     * Metodo para convertir el Hashtable que asocia las areas
     * de interes con los años de experiancia, a un String util
     * para el metodo toString() de esta clase.
     * @return Retorna una cadena con la informacion de areas de interes y años
     * de experiencia
     */
    private String interExpToString(){ //ES IMPORTANTE VERIFICAR EL FUNCIONAMIENTO DE ESTE METODO
        Hashtable<String,Integer> areasExp  = this.areaInteresExperiencia;        
        Enumeration areas = areasExp.keys();
        Enumeration experiencia = areasExp.elements();
        
        String hashString = "Areas de experiencia: \n";
        while(areas.hasMoreElements()){
            hashString +=areas.nextElement() + " ; Años: " + experiencia.nextElement() + "\n";
        }            
        
        return hashString;
    }


    /**
     * Método toString sobreescrito para poder imprimir las características
     * y atributos principales de un objeto Revisor.
     * @return Una descripción breve de los atributos de un objeto Revisor en cadena.
     */
    @Override
    public String toString() {
        return super.toString() +
                "Institucion : " + institucion + interExpToString() + 
                "\nNumero de articulos revisados\n" + numeroArticulosRevisados;
    }

    
    
    
}
