/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesArticulos;

import Usuarios.empleados.Autor;
import articulo.Articulo;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author Dante
 */
public abstract class PeticionesArticulo implements Serializable{
    void realizarPeticion(Articulo objetivo){};

}