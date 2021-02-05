/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones;

import datos.Dato;

/**
 *Operación que imprime todos los atributos de un director utilizando el método
 * toString de las operaciones.
 * @author Dante
 */
public class imprimirDirector extends Imprimir{
    
    @Override
    public void realizarImpresion(Dato datosGenerales){
        System.out.println("Director:");
        System.out.println(datosGenerales.getDirectorGeneral().toString());
    }    
    @Override
    public String toString() {
        return "Imprimir informacion del director";
    } 
}
