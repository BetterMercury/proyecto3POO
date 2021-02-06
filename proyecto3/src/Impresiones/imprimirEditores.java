
package Impresiones;

import Usuarios.empleados.Editor;
import datos.Dato;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Clase que imprime todos los Editores existentes, se aprovecha su metodo
 * toString() personalizado para la clase Editor
 * @author Dante
 */
public class imprimirEditores extends Imprimir{
    
    /**
     * Método para imprimir las colecciones
     * de los sujetos editores, de forma resumida.
     * @param datosGenerales 
     */
    @Override
    public void realizarImpresion(Dato datosGenerales){
        
        TreeSet <Editor> setEditores = datosGenerales.getSetDeEditores();        
        /*
        Iterator <Editor> iterator = setRevisores.iterator();
        
        System.out.println("Editores: ");
        while (iterator.hasNext()){
            System.out.println(iterator.toString());
        } 
        */
        for(Editor editor : setEditores){
            System.out.println(editor.toString());
        }        
        
    }    
    
    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString() {
        return "Imprimir lista de editores";
    }
}
