/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesArticulos;

import Excepciones.ErrorDeDatoException;
import articulo.Articulo;
import static articulo.Articulo.*;
import static articulo.Categoria.CAT1;
import java.util.Scanner;

/**
 *
 * @author Dante
 */
public class pedirCategoria extends PeticionesArticulo{

    @Override
    public void realizarPeticion(Articulo objetivo) throws ErrorDeDatoException{
        Scanner sc = new Scanner(System.in);
        int seleccion;
        System.out.println("Se asignara una categoria al articulo");
        System.out.println("Elegir alguna de las siguientes opciones");
        System.out.println("1. " + CAT1);
        System.out.println("2. " + CAT2);
        System.out.println("3. " + CAT3);
        System.out.println("4. " + CAT4);        
        System.out.print("Ingrese numero: ");
        
        try{
            seleccion = sc.nextInt();
        }catch(IllegalArgumentException e){
            throw new ErrorDeDatoException("Ingresa nuevamente el numero de categoria, pero ahora solo numero");
        }
        
        
        switch(seleccion){
            case 1:
                objetivo.setCategoria(CAT1);
                break;
            case 2:
                objetivo.setCategoria(CAT2);                
                break;
            case 3:
                objetivo.setCategoria(CAT3);                
                break;
            case 4: 
                objetivo.setCategoria(CAT4);                
                break;
            default:
                throw new ErrorDeDatoException("Ingresa nuevamente el numero de categoria, pero ahora un numero valido");
        }
        
    }


}
