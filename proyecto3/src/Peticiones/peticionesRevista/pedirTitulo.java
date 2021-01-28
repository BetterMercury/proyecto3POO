/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesRevista;

import Excepciones.ErrorDeDatoException;
import Revista.Revista;
import java.util.Scanner;

/**
 * Clase que permite asociar un título principal a una revista,
 * dicho título debe ser mayor a 4 caracteres.
 * @author Dante
 */
public class pedirTitulo {
    public void realizarPeticion(Revista objetivo){
        String title;
        Scanner sc = new Scanner(System.in);
        
        while(true){        
            System.out.print("Título de Revista \n(Mayor a 4 caracteres): ");
            try{
                title = sc.nextLine();
                if(title.length()<4)
                    throw new ErrorDeDatoException("Error: La longitud del título debe ser mayor a 4 caracteres");            
                break;
            } catch(ErrorDeDatoException e){
                System.out.println(e.getMessage());
            }
        }
        objetivo.setTitulo(title);
    }    
}
