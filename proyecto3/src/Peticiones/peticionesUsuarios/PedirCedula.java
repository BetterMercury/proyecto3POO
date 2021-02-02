/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import Usuarios.empleados.Editor;
import java.util.Scanner;

/**
 *
 * @author Equipo 9
 * 
 * Clase que se encarga de recibir el numero de cedula de un editor
 */
public class PedirCedula extends PeticionPersona {
    
        public void realizarPeticion(Persona objetivo) throws ErrorDeDatoException {
        
            
        int numeroCedula;
        Scanner sc = new Scanner(System.in);
        System.out.print("Numero de cedula (5 digitos): ");
        try{
            numeroCedula = sc.nextInt();
        }catch(IllegalArgumentException e){
            throw new ErrorDeDatoException("Ingresa nuevamente el numero de cedula, pero ahora solo con numeros");
        }
        Editor ed = (Editor)objetivo;
           
        int cifras = 0;
        int numCed = numeroCedula;
   
        cifras= 0;    //esta variable es el contador de cifras
        while(numCed!=0){             //mientras a numCed le queden cifras
            numCed = numCed/10;         //le quitamos el último dígito
            cifras++;          //sumamos 1 al contador de cifras
        }
        
        if((numCed == 5) ){   //se forza a tener 5 cifras en el numero de cedula
            ed.setNumeroCedula(numeroCedula); 
        }else{
            System.out.println(" ");
            throw new ErrorDeDatoException("El numero de cedula debe ser de 5 digitos");
        }
        
    }
}
