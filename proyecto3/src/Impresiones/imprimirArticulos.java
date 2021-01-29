/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones;

import articulo.Articulo;
import datos.Dato;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dante
 */
public class imprimirArticulos extends Imprimir{
    
    @Override
    public void realizarImpresion(Dato datosGenerales){
        HashMap <String, Articulo> mapaArticulos = datosGenerales.getMapaArticulos();
        
        for(Map.Entry<String, Articulo> entry : mapaArticulos.entrySet()){
            System.out.println("Folio : " + entry.getKey() + "; Titulo : " + entry.getValue().getTitulo());
        }
    };
    
}
