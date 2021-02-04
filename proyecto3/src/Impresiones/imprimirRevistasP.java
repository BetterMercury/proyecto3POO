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
 * Clase que permite imprimir las Revistas Publicadas
 * @author Dante
 */
public class imprimirRevistasP extends Imprimir{
    @Override
    public void realizarImpresion(Dato datosGenerales){
        int count=0;
        HashMap <Integer, Revista> mapaRevistas = datosGenerales.getMapaRevistas();        
        for(Map.Entry<Integer, Revista> entry : mapaRevistas.entrySet()){
            if(entry.getValue().getEstado().equals(Revista.STATER1)){ //Solo imprimir Revistas Publicadas
                System.out.println("Numero : " + entry.getKey() + "; Titulo : " + entry.getValue().getTitulo());
                System.out.println("Estado: " + entry.getValue().getEstado());
                count++;
            }
        }
        if(count == 0){
            System.out.println("");
            System.out.println("No existen revistas publicadas");
        } else {
            System.out.println("");
            System.out.println("Existen " + count + " Revistas publicadas");
        }
    }    
}