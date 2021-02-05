
package Usuarios.empleados;

import Excepciones.ErrorDeDatoException;
import Impresiones.imprimirEmpleados;
import Peticiones.peticionesUsuarios.GenerarIdentificador;
import Peticiones.peticionesUsuarios.PedirFechaIngreso;
import Peticiones.peticionesUsuarios.PeticionPersona;
import Usuarios.Persona;
import operaciones.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa al sujeto Empleado, el cual hereda de Persona;
 * esta clase representa un tipo de dato abstracto; cuenta con características 
 * y atributos propios; y, es útil para englobar tipos especifícos que 
 * heredarán de esta clase.
 * @author Equipo 9
 * 
 */
public class Empleado extends Persona {
    static DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");	//se crea un objeto de la clase formateador para localDate
    
    Integer numeroEmpleado;
    LocalDate fechaIngreso;
    
    
    /**
    * Constructor de la clase Empleado que utiliza el constructor de su clase 
    * padre; se encarga de inicializar las listas de peticiones y operaciones,
    * haciendo uso de objetos y polimorfismo.
    **/
    public Empleado(){
        super();
        this.peticonesNecesarias.add(new GenerarIdentificador());
        this.peticonesNecesarias.add(new PedirFechaIngreso());
        this.operacionesDisponible.add(new ImprimirColeccionesEmpleado());
        this.operacionesDisponible.add(new DevolverArticuloFolio());
        this.operacionesDisponible.add(new DevolverArticuloNombre());
        this.operacionesDisponible.add(new DevolverEmpleadoPorNumero());
        this.operacionesDisponible.add(new DevolverRevistaPorNumero());
        this.operacionesDisponible.add(new DevolverSuscriptorPorNumero());
        this.operacionesDisponible.add(new ImprimirEmpleado());
    }
    
       //formateador para la fecha ingresada
    
    /**
     * Método de acceso para obtener la fecha de ingreso de un objeto Empleado.
     * @return Retorna la fecha de ingreso de este Empleado en cadena.
     **/
    public String getFechaIngreso() {
        return formateador.format(fechaIngreso);    //regresa la cadena con fecha establecida por LocalDate
    }

    /**
     * Método de acceso para establecer la fecha de ingreso de un objeto Empleado.
     * @param fechaIngreso La fecha de ingreso en cadena que se le pondrá al objeto.
     */
    public void setFechaIngreso(String fechaIngreso) {  //cadena en formato dd/MM/AAAA
 
        this.fechaIngreso = LocalDate.parse(fechaIngreso, formateador);
        
    }

    /**
     * Método de acceso para obtener el numero de empleado de un objeto Empleado.
     * @return Retorna el numero de empleado de este Empleado en entero.
     **/
    public Integer getNumeroEmpleado() {
        return numeroEmpleado;
    }

    /**
     * Método de acceso para establecer el numero de empleado de un objeto Empleado.
     * @param numeroEmpleado El numero de empleado en entero que se le pondrá al objeto.
     */
    public void setNumeroEmpleado(Integer numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    
    /**
     * Método compareTo que hace que los sets de los tipos especificos aparescan ordenados automaticamente.
     */


    /**
     * Método toString sobreescrito para poder imprimir las características
     * y atributos principales de un objeto Empleado.
     * @return Una descripción breve de los atributos de un objeto Empleado en cadena.
     */
    @Override
    public String toString() {
        return super.toString() + 
                "Numero de empleado :" + numeroEmpleado + "\n" +
                "Fecha de ingreso: " + formateador.format(fechaIngreso) + "\n";
        
    }
    

    
}
