/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import Usuarios.empleados.Editor;
import Usuarios.empleados.Empleado;
import java.util.Scanner;

/**
 *
 * @author Equipo 9
 * 
 * Clase que se encarga de recibir el posgrado
 */
public class PedirPosgrado implements PeticionPersona {
    
        public void realizarPeticion(Persona objetivo) throws ErrorDeDatoException {
        
        
        String posgrado;
        Scanner sc = new Scanner(System.in);
        System.out.print("Posgrado (Doctorado o Maestria): ");
        posgrado = sc.nextLine();
        Editor ed = (Editor)objetivo;
        
        if(posgrado.compareTo("Doctorado") == 0){       //condicion de solo colocar dos posgrados
            ed.setPosgrado(posgrado);
        }else if(posgrado.compareTo("Maestria") == 0){
            ed.setPosgrado(posgrado);
        }else{
            throw new ErrorDeDatoException("No se ha ingreso un posgrado valido, solo 'Doctorado' o 'Maestria'");
        }
        
    }
}