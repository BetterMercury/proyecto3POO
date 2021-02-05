
package Usuarios.empleados;

import Peticiones.peticionesUsuarios.GenerarIdentificador;
import Peticiones.peticionesUsuarios.PedirCedula;
import Peticiones.peticionesUsuarios.PedirPosgrado;
import Usuarios.empleados.Empleado;
import articulo.Articulo;
import java.util.LinkedList;
import java.util.List;
import operaciones.ConfirmarPublicacionArticulo;

/**
 * Clase que representa al sujeto Editor, el cual hereda de Empleado;
 * cuenta con características y atributos propios como la confirmación de artículos.
 * @author Equipo 9
 * 
 */
public class Editor extends Empleado{
    
    /**
    * Constructor de la clase Editor que utiliza el constructor de su clase 
    * padre; se encarga de inicializar las listas de peticiones y operaciones,
    * haciendo uso de objetos y polimorfismo.
    **/
    public Editor(){
        super();
        this.peticonesNecesarias.add(new PedirPosgrado());
        this.peticonesNecesarias.add(new PedirCedula());    //falta pedir el numero de articulos, relacionado con la operacion asociada
        this.operacionesDisponible.add(new ConfirmarPublicacionArticulo());
    }
    
    String posgrado; //debe ser maestría o doctorado
    int numeroArticulosRevisados;
    int numeroCedula;
    List<Articulo> articulosRevisados = new LinkedList<>();
    
    /**
     * Método de acceso para obtener el posgrado de un objeto Editor.
     * @return Retorna el posgrado de este Editor en cadena.
     **/
    public String getPosgrado(){
        return posgrado;
    }

    /**
     * Método de acceso para establecer el posgrado de un objeto Editor.
     * @param posgrado El posgrado en cadena que se le pondrá al objeto.
     */
    public void setPosgrado(String posgrado) {
            this.posgrado = posgrado;
    }
    
    /**
     * Método de acceso para obtener el numero de artículos revisados de un objeto Editor.
     * @return Retorna el número de artículos revisados de este Editor en entero.
     **/
    public int getNumeroArticulosRevisados(){
        return numeroArticulosRevisados;
    }

    /**
     * Método de acceso para establecer el numero de artículos revisados de un objeto Editor.
     * @param numeroArticulosRevisados El numero de artículos revisados en entero que se le pondrá al objeto.
     */
    public void setNumeroArticulosRevisados(int numeroArticulosRevisados) {
        if(numeroArticulosRevisados >= 0){
            this.numeroArticulosRevisados = numeroArticulosRevisados;
        }else{
            System.out.println(" ");
            System.out.println("No se ha ingreso una cantidad valida");
        }
        
    }
    
    /**
     * Método de acceso para obtener el número de cédula de un objeto Editor.
     * @return Retorna el número de cédula de este Editor en entero.
     **/
    public int getNumeroCedula(){
        return numeroCedula;
    }

    /**
     * Método de acceso para establecer el número de cédula de un objeto Editor.
     * @param numeroCedula El número de cédula en entero que se le pondrá al objeto.
     */
    public void setNumeroCedula(int numeroCedula){
            this.numeroCedula = numeroCedula;
    }
    
    /**
     * Método de acceso para obtener el artículo revisado de un objeto Editor.
     * @return Retorna el artículo revisado de este Editor en Articulo.
     **/
    public Articulo getArticulosRevisados(int i){
        return articulosRevisados.get(i);
    }

    /**
     * Método de acceso para establecer el artículo revisado de un objeto Editor.
     * @param art El artículo revisado en Articulo que se le pondrá al objeto.
     */
    public void setArticulosRevisados(Articulo art) {
            this.articulosRevisados.add(art);
    }

    /**
     * Método toString sobreescrito para poder imprimir las características
     * y atributos principales de un objeto Editor.
     * @return Una descripción breve de los atributos de un objeto Editor en cadena.
     */
    @Override
    public String toString() {
        return super.toString() + 
                "Posgrado : " + posgrado + 
                "\nNumero de articulos revisados : " + numeroArticulosRevisados + 
                "\nNumero de cedula profesional : " + numeroCedula;
    }        
    
}
