/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import Usuarios.empleados.Autor;
import articulo.Articulo;

/**
 *
 * @author Equipo 9
 * 
 * Clase que se encarga de pedir el numero de articulos escritos por autor
 */
public class PedirNumeroArticulosEscritosAutor{
    
    public void realizarPeticion(Autor aut, Articulo articulo) {
        
        //incremento en el numero de articulos creados
        int numeroArticulosEscritos = 0;
       
        numeroArticulosEscritos= aut.getNumeroArticulosEscritos() + 1;
        
        aut.setNumeroArticulosEscritos(numeroArticulosEscritos);
        
        //asignacion del articulo creado al autor
        aut.setArticulosEscritos(articulo);
    }
}