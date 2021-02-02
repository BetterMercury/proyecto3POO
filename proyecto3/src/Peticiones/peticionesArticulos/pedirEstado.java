/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesArticulos;

import static Estado.Estado.*;
import articulo.Articulo;
import java.util.Scanner;
import Excepciones.ErrorDeDatoException;
/**
 *  Clase que permite asignarle un estado a un artículo, lo ideal
 * es que un Revisor sea el único con acceso a el método incluido.
 * @author Dante
 */
public class pedirEstado extends PeticionesArticulo{
    
    @Override
    public void realizarPeticion(Articulo objetivo) throws ErrorDeDatoException{  //ESTE MÉTODO SOLO LO PUEDE HACER UN Revisor
        Scanner sc = new Scanner(System.in);
        int seleccion;
        
        System.out.println("Se asignara un estado al Articulo");
        System.out.println("1. " + STATER3);    //aceptado
        System.out.println("2. " + STATER4);       //pendiente
        System.out.println("3. " + STATER5);    //rechazado
        System.out.print("Seleccion : ");
        
        while(true){
                try{
                    seleccion = sc.nextInt();
                }catch(IllegalArgumentException e){
                    System.out.println(" ");
                    System.out.println("Ingrese un numero, intente nuevamente");
                    continue;
                }
                break;
        }
        
        
        switch(seleccion){
            case 1:
                objetivo.setEstado(STATER3);
                break;
            case 2:
                objetivo.setEstado(STATER4);
                break;
            case 3:
                objetivo.setEstado(STATER5);
                break;  
            default:
                throw new ErrorDeDatoException("Ingrese un estado valido");
        }
        
        //FALTAN ALGUNAS VERIFICACIONES EN ESTE METODO        
    }  
}
