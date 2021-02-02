/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import Usuarios.empleados.Revisor;
import java.util.Scanner;

/**
 *
 * @author Equipo 9
 * 
 * Clase que se encarga de pedir el interes y la experiencia de los revisores
 */
public class PedirInteresRevisor extends PeticionPersona{
    
    public void realizarPeticion(Persona objetivo) throws ErrorDeDatoException {
        String interes;
        Scanner sc = new Scanner(System.in);
        System.out.print("Escriba el interes del revisor (menor a 15 caracteres \ny sin digitos): ");
        interes = sc.nextLine();

        if(interes.length()>15 || !sinNumeros(interes)){
            throw new ErrorDeDatoException("Formato de interes incorrecto");
        }
        Revisor rev = (Revisor)objetivo;
        
        
        int experiencia;
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Ingrese sus anios de experiencia (maximo 2 digitos y en numero entero): ");
        try{
            experiencia = sc1.nextInt();
        }catch(IllegalArgumentException e){
            throw new ErrorDeDatoException("Ingresa nuevamente la experiencia, pero ahora solo con numeros y menor de 3 digitos");
        }
           
        int cifras = 0;
        int numExp = experiencia;
   
        cifras= 0;    //esta variable es el contador de cifras
        while(numExp!=0){             //mientras a numCed le queden cifras
            numExp = numExp/10;         //le quitamos el último dígito
            cifras++;          //sumamos 1 al contador de cifras
        }
        
        if((numExp <= 2  &&  numExp >= 0) ){   //se forza a tener 2 cifras en el numero de cedula
            rev.setInteres(interes,experiencia);     //interes y experiencia
        }else{
            System.out.println(" ");
            throw new ErrorDeDatoException("Ingresa nuevamente la experiencia, pero ahora menor de 3 digitos y mayor o igual que 0");
        }
      
    }
    
    private boolean sinNumeros(String cadena){
        for(char c: cadena.toCharArray()){
            return !Character.isDigit(c);
        }
        return true;
    }
    
}