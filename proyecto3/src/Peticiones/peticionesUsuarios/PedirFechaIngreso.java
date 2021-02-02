/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import Usuarios.empleados.Empleado;
import java.time.LocalDate;
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
        System.out.print("Fecha: ");
        fechaIngreso = sc.nextLine();
        //objetivo.setFechaIngreso(nombre);
        
        Empleado emp = (Empleado)objetivo;
        if((fechaIngreso.charAt(2) == '/') && (fechaIngreso.charAt(5) == '/') ){  //solo si se tiene el formato
            emp.setFechaIngreso( fechaIngreso );//this.fechaIngreso = LocalDate.parse(fechaIngreso, formateador);
        }else{
            System.out.println(" ");
            System.out.println("El formato de fecha es incorrecto. El formato debe ser dd/MM/AAAA");
            throw new ErrorDeDatoException("Ingrese nuevamente con el formato requerido");
        } 
        
        }
    }
