
package Impresiones;

import Usuarios.empleados.Autor;
import datos.Dato;
import java.util.TreeSet;

/**
 *Clase que define la operación de impresión sencilla de autores. Esta operación
 * no hace uso del método toString y solo imprime el número de empleado y el nombre
 * @author Dante
 */
public class imprimirAutoresSencillo extends Imprimir{

    /**
     * Método para imprimir las características y atributos
     * de los sujetos autores, de forma resumida.
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
            System.out.println("Nombre : " + autor.getNombre() + " " + autor.getApellidoPaterno() + " " + autor.getApellidoMaterno());            
            System.out.print("Numero : " + autor.getNumeroEmpleado() + "\n");
            System.out.println("---------------");
        }
    }
}
