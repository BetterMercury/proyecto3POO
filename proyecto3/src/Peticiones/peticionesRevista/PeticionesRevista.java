/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesRevista;

import Excepciones.ErrorDeDatoException;
import Revista.Revista;
import Usuarios.empleados.Editor;
import articulo.Articulo;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Dante
 */
public abstract class PeticionesRevista implements Serializable {
    
   public abstract void realizarPeticion(Revista objetivo) throws ErrorDeDatoException;
   
}
