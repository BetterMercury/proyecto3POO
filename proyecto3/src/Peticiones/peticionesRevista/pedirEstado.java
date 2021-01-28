/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesRevista;

import Revista.Revista;
import static Revista.Revista.*;
import java.util.Scanner;

/**
 * Clase que incluye un método para ingresar el estado a a una Revista, puede ser
 * publicada o no publicada. Se aprovechó la interfaz Estado 
 * para hacer las operaciones de este método.
 * Nota: La interfaz Estado la implementa la Revista objetivo
 * @author Dante
 */
public class pedirEstado extends PeticionesRevista{ //NOTA: Falta verificación, para que el usuario no ingrese cosas extrañas

    @Override
    public void realizarPeticion(Revista objetivo) {
        Scanner sc = new Scanner(System.in);
        int seleccion;
        System.out.println("Se asignara un estado a la revista");
        System.out.println("Elegir alguna de las siguientes opciones");
        System.out.println("1. " + getSTATER1());
        System.out.println("2. " + getSTATER2());
        System.out.print("Ingrese numero: ");
        seleccion = sc.nextInt();
        
        
        if(seleccion == 1){
            objetivo.setEstado(STATER1);
        } else {
            objetivo.setEstado(STATER2);
        }
        
    }
    
}
