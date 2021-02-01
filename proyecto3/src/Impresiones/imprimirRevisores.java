/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones;

import Usuarios.empleados.Revisor;
import datos.Dato;
import java.util.Iterator;
import java.util.TreeSet;
/**
 *
 * @author Dante
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
        Iterator <Revisor> iterator = setRevisores.iterator();
        
        System.out.println("Revisores: ");
        while (iterator.hasNext()){
            System.out.println(iterator.toString());
        }
    }            
}
