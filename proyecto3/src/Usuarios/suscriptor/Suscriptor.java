
package Usuarios.suscriptor;

import Peticiones.peticionesUsuarios.GenerarIdentificador;
import Peticiones.peticionesUsuarios.PedirFechaIngreso;
import Usuarios.Persona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import operaciones.*;

/**
 * Clase que representa al sujeto Suscriptor, el cual hereda de Persona;
 * cuenta con características y atributos propios como ser el usuario de la aplicación.
 * @author Equipo 9
 * 
 */
public class Suscriptor extends Persona{
    
    /**
    * Constructor de la clase Suscriptor que utiliza el constructor de su clase 
    * padre; se encarga de inicializar las listas de peticiones y operaciones,
    * haciendo uso de objetos y polimorfismo.
    **/
    public Suscriptor(){
        super();
        this.peticonesNecesarias.add(new GenerarIdentificador());
        this.peticonesNecesarias.add(new PedirFechaIngreso());
        this.operacionesDisponible.add(new ImprimirSuscriptor());
        this.operacionesDisponible.add(new BusquedaCadenaSinopsis());
        this.esSub = true;
    }
    
    //formateador para la fecha ingresada
    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");	//se crea un objeto de la clase formateador para localDate
    LocalDate fechaSuscripcion;
    int numeroSuscriptor;

    /**
     * Método de acceso para obtener el número de suscriptor de un objeto Suscriptor.
     * @return Retorna el número de suscriptor de este Suscriptor en entero.
     **/
    public int getNumeroSuscriptor() {
        return numeroSuscriptor;
    }

    /**
     * Método de acceso para establecer el número de suscriptor de un objeto Suscriptor.
     * @param numeroSuscriptor El número de suscriptor en entero que se le pondrá al objeto.
     */
    public void setNumeroSuscriptor(int numeroSuscriptor) {
        this.numeroSuscriptor = numeroSuscriptor;
    }
    
    /**
     * Método de acceso para obtener la fecha de suscripción de un objeto Suscriptor.
     * @return Retorna la fecha de suscripciónr de este Suscriptor en cadena.
     **/
    public String getFechaIngreso() {
        return formateador.format(fechaSuscripcion);    //regresa la cadena con fecha establecida por LocalDate
    }

    /**
     * Método de acceso para establecer la fecha de suscripción de un objeto Suscriptor.
     * @param fechaSuscripcion La fecha de suscripción en cadena que se le pondrá al objeto.
     */
    public void setFechaIngreso(String fechaSuscripcion) {  //cadena en formato dd/MM/AAAA
        if((fechaSuscripcion.charAt(2) == '/') && (fechaSuscripcion.charAt(5) == '/') ){  //solo si se tiene el formato
            this.fechaSuscripcion = LocalDate.parse(fechaSuscripcion, formateador);
        }else{
            System.out.println(" ");
            System.out.println("El formato de fecha es incorrecto. El formato debe ser dd/MM/AAAA");
        }
        
    }
    
}
