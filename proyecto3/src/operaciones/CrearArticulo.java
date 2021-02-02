/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import Usuarios.Persona;
import Usuarios.empleados.Autor;
import articulo.Articulo;
import datos.Dato;

/**
 *
 * @author Equipo 9
 */
public class CrearArticulo implements Operacion{
    
    public void realizarOperacion(Persona objetivo){
        
        //creacion de articulo
        Autor autor = (Autor)objetivo;
        Articulo articuloNuevo = new Articulo();
        System.out.println(" ");
        System.out.println("Usted autor, creara un articulo");
        System.out.println(" ");
        
        //asignamos el autor al articulo creado
        articuloNuevo.setAutor(autor);
        //se piden los datos del articulo
        articuloNuevo.pedirDatos();
        
        //almacenaremos el articulo en Dato
        Dato datos = Dato.getInstance();
        
        datos.aniadirArticulo(articuloNuevo);
        
    }
}
