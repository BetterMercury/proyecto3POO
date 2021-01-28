/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesArticulos;

import Excepciones.ErrorDeDatoException;
import articulo.Articulo;
import java.util.Scanner;

/**
 * Esta clase permite aniadir una sinopsis de no mas de 160 caracteres
 * a un Articulo.
 * @author Dante
 */
public class pedirSinopsis implements PeticionesArticulo{

    @Override
    public void realizarPeticion(Articulo objetivo) {
        String sinopsis;
        Scanner sc = new Scanner(System.in);
        
        while(true){        
            System.out.print("Título de Revista \n(Mayor a 4 caracteres): ");
            try{
                sinopsis = sc.nextLine();
                if(sinopsis.length()>160)
                    throw new ErrorDeDatoException("Error: La sinopsis debe ser menor a 160 caracteres");            
                break;
            } catch(ErrorDeDatoException e){
                System.out.println(e.getMessage());
            }
        }
        objetivo.setSnopsis(sinopsis);
    }           
}
    

