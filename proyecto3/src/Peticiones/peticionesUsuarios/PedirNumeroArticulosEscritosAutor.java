/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import Usuarios.empleados.Autor;
import java.util.Scanner;

/**
 *
 * @author Equipo 9
 * 
 * Clase que se encarga de pedir el numero de articulos escritos por autor
 */
public class PedirNumeroArticulosEscritosAutor extends PeticionPersona{
    
    public void realizarPeticion(Persona objetivo) throws ErrorDeDatoException {
        
        int numeroArticulosEscritos;
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Ingrese el numero de articulos escritos (mayor que 0 y menor que 30): ");
        try{
            numeroArticulosEscritos = sc1.nextInt();
        }catch(IllegalArgumentException e){
            throw new ErrorDeDatoException("Ingresa el numero, pero ahora solo con numeros");
        }
        Autor au = (Autor)objetivo;
        
        if( (numeroArticulosEscritos >= 0) && (numeroArticulosEscritos < 30) ){   //limite en articulos que se pueden colocar
            au.setNumeroArticulosEscritos(numeroArticulosEscritos);
        }else{
            throw new ErrorDeDatoException("Numero de articulos escritos invalido (debe ser mayor que 0 y menor que 30)");
        }
    }
}