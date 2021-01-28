/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios.suscriptor;

import Peticiones.peticionesUsuarios.GenerarIdentificador;
import Usuarios.Persona;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Equipo 9
 */
public class Suscriptor extends Persona{
    
    public Suscriptor(){
        super();
        this.peticonesNecesarias.add(new GenerarIdentificador());
    }
    
    //formateador para la fecha ingresada
    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");	//se crea un objeto de la clase formateador para localDate
    LocalDate fechaSuscripcion;
    int numeroSuscriptor;

    public int getNumeroSuscriptor() {
        return numeroSuscriptor;
    }

    public void setNumeroSuscriptor(int numeroSuscriptor) {
        this.numeroSuscriptor = numeroSuscriptor;
    }
    public String getFechaSuscripcion() {
        return formateador.format(fechaSuscripcion);    //regresa la cadena con fecha establecida por LocalDate
    }

    public void setFechaSuscripcion(String fechaSuscripcion) {  //cadena en formato dd/MM/AAAA
        if((fechaSuscripcion.charAt(2) == '/') && (fechaSuscripcion.charAt(5) == '/') ){  //solo si se tiene el formato
            this.fechaSuscripcion = LocalDate.parse(fechaSuscripcion, formateador);
        }else{
            System.out.println(" ");
            System.out.println("El formato de fecha es incorrecto. El formato debe ser dd/MM/AAAA");
        }
        
    }
    
}
