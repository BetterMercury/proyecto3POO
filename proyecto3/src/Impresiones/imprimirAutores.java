/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones;

import Usuarios.empleados.Autor;
import datos.Dato;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Clase que contiene a un método para imprimir todos los
 * autores existentes.
 * @author Dante
 */
public class imprimirAutores extends Imprimir{

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
    @Override
    public String toString() {
        return "Imprimir lista de autores";
    }
}
