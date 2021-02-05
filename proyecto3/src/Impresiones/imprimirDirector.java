/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones;

import datos.Dato;

/**
 *
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
