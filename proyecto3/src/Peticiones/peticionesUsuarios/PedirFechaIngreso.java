/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import Usuarios.empleados.Empleado;
import Usuarios.suscriptor.Suscriptor;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Equipo 9
 * 
 * Clase que se encarga de recibir los datos de fecha de ingreso
 */
public class PedirFechaIngreso extends PeticionPersona {
    
        //formateador para la fecha ingresada
    static DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");	//se crea un objeto de la clase formateador para localDate
    
    public void realizarPeticion(Persona objetivo) throws ErrorDeDatoException {
            
        String fechaIngreso;
        Scanner sc = new Scanner(System.in);
        System.out.print("Fecha en formato dd/MM/yyyy: ");
        fechaIngreso = sc.nextLine();
        //objetivo.setFechaIngreso(nombre);
                
        //depende si llega un empleado o un suscriptor
        if(objetivo instanceof Empleado){    
            Empleado persona = (Empleado)objetivo;
            
            if((fechaIngreso.charAt(2) == '/') && (fechaIngreso.charAt(5) == '/') && comprobar(fechaIngreso) ){  //solo si se tiene el formato
                persona.setFechaIngreso( fechaIngreso );//this.fechaIngreso = LocalDate.parse(fechaIngreso, formateador);
            }else{
                System.out.println(" ");
                System.out.println("El formato de fecha es incorrecto. El formato debe ser dd/MM/AAAA");
                throw new ErrorDeDatoException("Ingrese nuevamente con el formato requerido");
            } 
        }else{
            Suscriptor persona = (Suscriptor)objetivo;
            
            if((fechaIngreso.charAt(2) == '/') && (fechaIngreso.charAt(5) == '/') && comprobar(fechaIngreso) ){  //solo si se tiene el formato
                persona.setFechaIngreso( fechaIngreso );//this.fechaIngreso = LocalDate.parse(fechaIngreso, formateador);
            }else{
                System.out.println(" ");
                System.out.println("El formato de fecha es incorrecto. El formato debe ser dd/MM/AAAA");
                throw new ErrorDeDatoException("Ingrese nuevamente con el formato requerido");
            } 
        }
        
        
        
        
    }
        
    static public boolean comprobar(String fecha){
            
        int i = 0;  //contador para saber si se cumplen los 8 digitos de la fecha
           
        //verificacion de los dias
        int dia = Integer.parseInt(fecha.substring(0, 2));
        if(dia >= 1 && dia <= 31){
            i++;
        }
            
            
        //verificacion del mes, suma otro numero
        int mes = Integer.parseInt(fecha.substring(3, 5));
        if(mes >= 1 && mes <= 12){
            i++;
        }
            
        //verificacio del año, suma otro numero su se cumple
        int anio = Integer.parseInt(fecha.substring(6, 10));
        if(anio >= 1980 && anio <= 2021){
            i++;
        }
            
        //si se cumplen todos los digitos de la fecha (dia, mes y año), se retorna verdadero
        if(i == 3){
            return true;
        }else{
            return false;
        }
            
    }
}
