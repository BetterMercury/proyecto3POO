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
 * Clase que se encarga de pedir el numero de articulos revisados por revisor
 */
public class PedirNumeroArticulosRevisadosRevisor implements PeticionPersona{
    
    public void realizarPeticion(Persona objetivo) throws ErrorDeDatoException {
        
        int numeroArticulosRevisados;
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Ingrese el numero de articulos revisados (mayor que 0 y menor que 30): ");
        try{
            numeroArticulosRevisados = sc1.nextInt();
        }catch(IllegalArgumentException e){
            throw new ErrorDeDatoException("Ingresa el numero, pero ahora solo con numeros");
        }
        Revisor rev = (Revisor)objetivo;
        
        if( (numeroArticulosRevisados >= 0) && (numeroArticulosRevisados < 30) ){   //limite en articulos que se pueden colocar
            rev.setNumeroArticulosRevisados(numeroArticulosRevisados);
        }else{
            throw new ErrorDeDatoException("Numero de articulos revisados invalido (debe ser mayor que 0 y menor que 30)");
        }
    }
}