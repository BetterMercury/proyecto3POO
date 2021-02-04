/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones;

import Revista.Revista;
import datos.Dato;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que puede imprimir a todas las revistas, tambien su estado.
 * @author Dante
 */
public class imprimirRevistas extends Imprimir{
    @Override
    public void realizarImpresion(Dato datosGenerales){
        HashMap <Integer, Revista> mapaRevistas = datosGenerales.getMapaRevistas();        
        for(Map.Entry<Integer, Revista> entry : mapaRevistas.entrySet()){
            System.out.println("Numero : " + entry.getKey() + "; Titulo : " + entry.getValue().getTitulo());
            System.out.println("Estado: " + entry.getValue().getEstado());
        }        
    }    
}
