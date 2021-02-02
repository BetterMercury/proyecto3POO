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
        System.out.println("1. " + STATER3);
        System.out.println("2. " + STATER4);
        System.out.println("3. " + STATER5);
        System.out.print("Seleccion : ");
        seleccion = sc.nextInt();
        
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
        }
        
        //FALTAN ALGUNAS VERIFICACIONES EN ESTE METODO        
    }  
}
