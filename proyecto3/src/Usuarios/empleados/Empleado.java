/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios.empleados;

import Usuarios.Persona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Equiipo 9
 */
public class Empleado extends Persona{
    
    public Empleado(){
        super();
    }
    
        //formateador para la fecha ingresada
    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");	//se crea un objeto de la clase formateador para localDate
    
    int numeroEmpleado;
    LocalDate fechaIngreso;
    
    public int getNumeroEmpleado(){
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        int cifras = 0;
        int numEm = numeroEmpleado;
   
        cifras= 0;    //esta variable es el contador de cifras
        while(numEm!=0){             //mientras a numCed le queden cifras
            numEm = numEm/10;         //le quitamos el último dígito
            cifras++;          //sumamos 1 al contador de cifras
        }
        
        if((numEm == 8) ){   //se forza a tener 8 cifras en el numero de empleado
            this.numeroEmpleado = numeroEmpleado;
        }else{
            System.out.println(" ");
            System.out.println("El numero de empleado no es de 8 digitos");
        }
        
    }
    
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
}
