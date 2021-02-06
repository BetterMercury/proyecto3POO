
package Impresiones;

import Usuarios.empleados.Revisor;
import datos.Dato;
import java.util.Iterator;
import java.util.TreeSet;
    /**
     * Metodo que imprime todos los Revisores, aprovecha
     * el metodo toString() personalizado para la clase
     * Revisor
     */
public class imprimirRevisores extends Imprimir{

    /**
     * Metodo que imprime todos los Revisores, aprovecha
     * el metodo toString() personalizado para la clase
     * Revisor
     * @param datosGenerales Todos los datos existentes
     * hasta el momento.
     */
    @Override
    public void realizarImpresion(Dato datosGenerales){        
        TreeSet <Revisor> setRevisores = datosGenerales.getSetDeRevisores();   
        /*
        Iterator <Revisor> iterator = setRevisores.iterator();
        
        System.out.println("Revisores: ");
        while (iterator.hasNext()){
            System.out.println(iterator.toString());
        }
        */
        for(Revisor revisor : setRevisores){
            System.out.println(revisor.toString());
        }
    } 

/**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */    
    @Override
    public String toString() {
        return "Imprimir lista de revisores";
    }       
}
