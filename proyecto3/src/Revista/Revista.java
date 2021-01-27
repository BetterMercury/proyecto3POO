/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Revista;

import Estado.Estado;
import Usuarios.empleados.Editor;
import articulo.Articulo;
import java.util.Date;
import java.util.Calendar;
import java.util.LinkedList;

/**
 *
 * @author Dante
 */

public class Revista implements Estado{
    /*
    ArrayList<Operacion> operacionesDisponible;
    ArrayList<PeticionRevista> peticionesNecesarias;    
    */
    static int conteoRevistas;
    String titulo;
    Date fecha;
    LinkedList<Articulo> articulos = new LinkedList<>();
    Editor editor; //Solo puede contener editor si es publicado
    int numRevista;
    
}
