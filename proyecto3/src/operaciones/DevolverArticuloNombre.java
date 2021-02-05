/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import Usuarios.Persona;
import articulo.Articulo;
import datos.Dato;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author ribel
 */
public class DevolverArticuloNombre extends Operacion{

    @Override
    public void realizarOperacion(Persona operador) {
        
        Dato accesoDatos = Dato.getInstance();
        Scanner sc = new Scanner(System.in);
        String nombreArticulo;
        Articulo articuloBuscado = null;
        TreeSet<Articulo> articulosDisponibles;
        
        System.out.println("Ingresa el titulo del artículo que "
                + "buscas:");
        nombreArticulo = sc.nextLine();
        articulosDisponibles = accesoDatos.getSetArticulosAceptados();
        for(Articulo actual:articulosDisponibles){
            if(actual.getTitulo().equalsIgnoreCase(nombreArticulo)){
                articuloBuscado = actual;
            }
        }
        
        if(articuloBuscado == null){
            System.out.println("No existe ningun articulo con el titulo"
                    + " proporcionado");
        }else{
            System.out.println("Informacion del artículo: ");
            System.out.println(articuloBuscado.toString()); 
        }
    }
    @Override
    public String toString() {
        return "Mostrar información de un articulo por su Titulo";
    }
    
}
