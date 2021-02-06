
package Impresiones;

import Usuarios.empleados.Autor;
import datos.Dato;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Clase que contiene a un método para imprimir todos los
 * autores existentes. Esta operación utiliza el método toString de los autores
 * @author Dante
 */
public class imprimirAutores extends Imprimir{

    /**
     * Método para imprimir las colecciones
     * de los sujetos autores, mostrando algunos atributos.
     * @param datosGenerales 
     */
    @Override
    public void realizarImpresion(Dato datosGenerales){
        /*
        TreeSet <Autor> setAutores = datosGenerales.getSetDeAutores(); 
        Iterator <Autor> iterator = setAutores.iterator();
        
        System.out.println("Autores: ");
        while (iterator.hasNext()){
            System.out.println(iterator.toString());
        } 
        */
        
        TreeSet <Autor> setAutores = datosGenerales.getSetDeAutores(); 
        for(Autor autor : setAutores){
            System.out.println(autor.toString());
        }

    }   
    
    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString() {
        return "Imprimir lista de autores";
    }
}
