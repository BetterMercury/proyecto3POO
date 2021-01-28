/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios.empleados;

import Peticiones.peticionesUsuarios.GenerarIdentificador;
import Usuarios.Persona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Equiipo 9
 */
public class Empleado extends Persona implements Comparable<Empleado>{
    Integer numeroEmpleado;
    LocalDate fechaIngreso;
    public Empleado(){
        super();
        this.peticonesNecesarias.add(new GenerarIdentificador());
    }
    
        //formateador para la fecha ingresada
    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");	//se crea un objeto de la clase formateador para localDate
    
   
    
    public String getFechaIngreso() {
        return formateador.format(fechaIngreso);    //regresa la cadena con fecha establecida por LocalDate
    }

    public void setFechaIngreso(String fechaIngreso) {  //cadena en formato dd/MM/AAAA
        if((fechaIngreso.charAt(2) == '/') && (fechaIngreso.charAt(5) == '/') ){  //solo si se tiene el formato
            this.fechaIngreso = LocalDate.parse(fechaIngreso, formateador);
        }else{
            System.out.println(" ");
            System.out.println("El formato de fecha es incorrecto. El formato debe ser dd/MM/AAAA");
        }  
    }

    public Integer getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(Integer numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    
    /**
     * Hace que los sets de los tipos especificos aparescan ordenados automaticamente.
     */
    @Override
    public int compareTo(Empleado arg0) {
        return this.getCadenaTodoJunto().compareTo(arg0.getCadenaTodoJunto()) ; //To change body of generated methods, choose Tools | Templates.
    }
}
