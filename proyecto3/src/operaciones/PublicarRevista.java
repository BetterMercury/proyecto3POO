/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import Excepciones.ErrorDeDatoException;
import Impresiones.imprimirRevistasNoP;
import Usuarios.Persona;
import datos.Dato;
import java.util.Scanner;
import Revista.Revista;


/**
 *
 * @author Dante
 */
public class PublicarRevista extends Operacion{

    @Override
    public void realizarOperacion(Persona operador) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("");
        System.out.println("Usted director puede publicar una revista");
        System.out.println("");
        
        Dato datos = Dato.getInstance();  
        imprimirRevistasNoP irevNP = new imprimirRevistasNoP();
                
        System.out.println("Revistas No Publicadas");
        irevNP.realizarImpresion(datos);
        
        System.out.println("Ingrese numero de revista: ");
        num = sc.nextInt();
        
        try{
            if(datos.existsFolioNumeroRevista(num)){
                if(datos.buscarFolioNumeroRevista(num).comprobacionCAT() == true){
                    
                    //Poner la revista en estado publicado
                    datos.buscarFolioNumeroRevista(num).setEstado(Revista.STATER1);
                    
            } else{
                    System.out.println("Esta revista no se puede publicar");
                }
                
                
        } else {
            throw new ErrorDeDatoException("Error: Numero de revista incorrecto");
        }
        }catch (ErrorDeDatoException e){
            System.out.println(e.getMessage());
        }                        
        
    }        
    
}
