/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesArticulos;

import Usuarios.empleados.Autor;
import articulo.Articulo;
import java.util.ArrayList;


/**
 *
 * @author Dante
 */
public abstract class PeticionesArticulo {
    void realizarPeticion(Articulo objetivo){};
    
    void realizarPeticion(Articulo objetivo, ArrayList<Autor> autores){};
}