/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    @Override
    public void realizarImpresion(Dato datosGenerales){
        TreeSet <Editor> setRevisores = datosGenerales.getSetDeEditores();        
        Iterator <Editor> iterator = setRevisores.iterator();
        
        System.out.println("Editores: ");
        while (iterator.hasNext()){
            System.out.println(iterator.toString());
        }        
    }     
}