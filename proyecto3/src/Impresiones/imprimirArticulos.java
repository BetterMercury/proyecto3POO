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
 * Clase que recorre los Articulos disponibles, no hace uso del metodo
 * toString(). Imprime el folio y el título de los artículos.
 * @author Dante
 */
public class imprimirArticulos extends Imprimir{
    
    @Override
    public void realizarImpresion(Dato datosGenerales){
        HashMap <String, Articulo> mapaArticulos = datosGenerales.getMapaArticulos();
        
        for(Map.Entry<String, Articulo> entry : mapaArticulos.entrySet()){
            System.out.println("Folio : " + entry.getKey() + " ; Titulo : " + entry.getValue().getTitulo());
            System.out.println("Categoria : " + entry.getValue().getCategoria() + " ; Estado: " + entry.getValue().getEstado());
            System.out.println("---------------");
        }
    };
    @Override
    public String toString() {
        return "Imprimir lista de articulos";
    }
    
}
