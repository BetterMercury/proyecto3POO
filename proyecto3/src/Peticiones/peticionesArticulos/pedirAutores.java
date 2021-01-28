/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesArticulos;

import Excepciones.TresAutoresException;
import Usuarios.empleados.Autor;
import articulo.Articulo;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @author ribel
 */
public class pedirAutores extends PeticionesArticulo {

    @Override
    public void realizarPeticion(Articulo objetivo, ArrayList<Autor> autores) {
        try{
<<<<<<< HEAD
        if(autores.size()>3){ //Solo pueden existir un máximo de tres autores por artículo
=======
        if(autores.size()>3){
>>>>>>> 09be6ed3e2690ba3033879065d931359e44edd75
            throw new TresAutoresException();
        } else {
            objetivo.setAutores(autores);
        }        
        } catch(TresAutoresException e){
            System.out.println(e.getMessage());
        }
        
    }
}
