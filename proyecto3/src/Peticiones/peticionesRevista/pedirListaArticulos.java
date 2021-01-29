/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesRevista;

import Excepciones.ListaVaciaException;
import Revista.Revista;
import articulo.Articulo;
import java.util.LinkedList;

/**
 * Clase que permite asociar una lista de artículos a una
 * Revista.
 * @author Dante
 */
public class pedirListaArticulos extends PeticionesRevista{

    
    public void realizarPeticion(Revista objetivo) {
        LinkedList<Articulo> articulos = null; //Adaptar, esto debe ser un TreeSet
        System.out.println("Se agregara la lista de articulos a la Revista");
        try{
            if(articulos.isEmpty()){
                throw new ListaVaciaException();
            } else{
                objetivo.setArticulos(articulos);
                System.out.println("La lista se ha asociado exitosamente");
            }
        } catch(ListaVaciaException e){
            System.out.println(e.getMessage());
            System.out.println("No se ha asociado la lista");
        }
    }    
}
