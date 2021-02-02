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
 *  Esta clase permite asociar un Título a un Articulo.
 * @author ribel
 */
public class pedirTitulo extends PeticionesArticulo{

    public void realizarPeticion(Articulo objetivo) throws ErrorDeDatoException {
        String title;
        Scanner sc = new Scanner(System.in);
        
        while(true){        
            System.out.print("Título del Articulo \n(Mayor a 4 caracteres): ");
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
    

