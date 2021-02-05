/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones;

import Usuarios.empleados.Autor;
import datos.Dato;
import java.util.TreeSet;

/**
 *
 * @author Dante
 */
public class imprimirAutoresSencillo extends Imprimir{

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
            System.out.println("Numero : " + autor.getNumeroEmpleado());
            System.out.print(" ; Nombre : " + autor.getNombre() + autor.getApellidoPaterno() + autor.getApellidoMaterno() + "\n");
        }
    }
}
