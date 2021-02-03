/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import Usuarios.empleados.Revisor;
import articulo.Articulo;
import java.util.Scanner;

/**
 *
 * @author Equipo 9
 * 
 * Clase que se encarga de pedir el numero de articulos revisados por revisor
 */
public class PedirNumeroArticulosRevisadosRevisor{
    
    public void realizarPeticion(Revisor revi, Articulo articulo) {
        
        //incremento en el numero de articulos revisados
        int numeroArticulosRevisados = 0;
       
        numeroArticulosRevisados = revi.getNumeroArticulosRevisados() + 1;
        
        revi.setNumeroArticulosRevisados(numeroArticulosRevisados);
        
        //asignacion del articulo revisado al revisor
        revi.setArticulosRevisados(articulo);
        
    }
}