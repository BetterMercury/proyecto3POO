/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesRevista;

import Revista.Revista;

/**
 *
 * @author Dante
 */
public class pedirNumero extends PeticionesRevista{

    @Override
    public void realizarPeticion(Revista objetivo) { //NOTA: Crear un mecanismo para que los numeros no se repitan
        System.out.println("Ingresar numero de Revista");
        
    }
    
}

/**
 * FALTA DETERMINAR COMO SE ASIGNARA UN NUMERO A UNA REVISTA. OPCIONES DISPONIBLES:
 * 1. Que la revista instanciada reciba el número del conteo de revistas instanciadas hasta el momento.
 * 2. Que el número sea ingresado por el usuario.
 * 3. Obtener algún código hash.
 */
