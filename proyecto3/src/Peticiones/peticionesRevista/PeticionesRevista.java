/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesRevista;

import Revista.Revista;
import Usuarios.empleados.Editor;
import articulo.Articulo;
import java.util.LinkedList;

/**
 *
 * @author Dante
 */
public abstract class PeticionesRevista {
    void realizarPeticion(Revista objetivo){};
    
   void realizarPeticion(Revista objetivo, LinkedList<Articulo> articulos){};    
   
   void realizarPeticion(Revista objetivo, Editor ed){};     
}
