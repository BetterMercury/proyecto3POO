/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesArticulos;

import Peticiones.ErrorDeDatoException;
import articulo.Articulo;

/**
 *
 * @author ribel
 */
//Creo que no hay manera de hacerlo obligatorio, pero todas las clases que 
//hereden de esta interfaz deben sobreescribir el método toString y escribir 
//en una linea lo que hace
public interface PeticionArticulo {
    void realizarPeticion(Articulo objetivo) throws ErrorDeDatoException;
    
}
