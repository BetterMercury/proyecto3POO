/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import Usuarios.Persona;
import datos.Dato;


/**
 *
 * @author Dante
 */
public class PublicarRevista extends Operacion{

    @Override
    public void realizarOperacion(Persona operador) {
        System.out.println("");
        System.out.println("Usted director puede publicar una revista");
        System.out.println("");
        
        Dato datos = Dato.getInstance();  
                
        System.out.println("Seleccione una revista a publicar");
        
        
        
    }
    
    
    
}
