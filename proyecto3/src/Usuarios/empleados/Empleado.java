/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios.empleados;

import Excepciones.ErrorDeDatoException;
import Peticiones.peticionesUsuarios.GenerarIdentificador;
import Peticiones.peticionesUsuarios.PedirFechaIngreso;
import Peticiones.peticionesUsuarios.PeticionPersona;
import Usuarios.Persona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Equiipo 9
 */
public class Empleado extends Persona implements Comparable<Empleado>{
    static DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");	//se crea un objeto de la clase formateador para localDate
    
    Integer numeroEmpleado;
    LocalDate fechaIngreso;
    
    public Empleado(){
        super();
        this.peticonesNecesarias.add(new GenerarIdentificador());
        this.peticonesNecesarias.add(new PedirFechaIngreso());
    }
    
       //formateador para la fecha ingresada
    
    
    public String getFechaIngreso() {
        return formateador.format(fechaIngreso);    //regresa la cadena con fecha establecida por LocalDate
    }

    public void setFechaIngreso(String fechaIngreso) {  //cadena en formato dd/MM/AAAA
 
        this.fechaIngreso = LocalDate.parse(fechaIngreso, formateador);
        
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

    /**
     * Permite la impresion de los datos de Empleado
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + 
                "Numero de empleado :" + numeroEmpleado + "\n" +
                "Fecha de ingreso: " + formateador.format(fechaIngreso) + "\n";
        
    }
    

    
}
