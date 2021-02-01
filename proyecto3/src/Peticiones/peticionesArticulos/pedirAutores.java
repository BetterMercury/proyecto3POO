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
 * Clase que permite asociar una lista de maximo 3 autores a un Articulo.
 * @author ribel
 */
public class pedirAutores extends PeticionesArticulo {

    @Override
    public void realizarPeticion(Articulo objetivo) {
        ArrayList<Autor> autores = null; //Adaptar el TreeSet que se tomará desde Datos
        try{
        if(autores.size()>3){ //Solo pueden existir un máximo de tres autores por artículo
            throw new TresAutoresException();
        } else {
            objetivo.setAutores(autores);
        }        
        } catch(TresAutoresException e){
            System.out.println(e.getMessage());
        }
        
    }
}
