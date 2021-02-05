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
 * Clase que imprime todos los atributos de un Articulo. Se imprime el folio,
 * autores, categoria, sinopsis y estado. 
 * @author Dante
 */
public class imprimirArticuloCompleto extends Imprimir{
    @Override
    public void realizarImpresion(Dato datosGenerales){
        HashMap <String, Articulo> mapaArticulos = datosGenerales.getMapaArticulos();
        
        for(Map.Entry<String, Articulo> entry : mapaArticulos.entrySet()){
            System.out.println("Folio : " + entry.getKey() + "; Titulo : " + entry.getValue().getTitulo());
            System.out.println("Autores :\n" + entry.getValue().autoresToString());
            System.out.println("Categoria : " + entry.getValue().getCategoria());            
            System.out.println("Sinopsis : " + entry.getValue().getSnopsis());
            System.out.println("Estado : " + entry.getValue().getEstado());
            System.out.println("Revisores :\n" + entry.getValue().revisoresToString());            
        }
    }   
    @Override
    public String toString() {
        return "Imprimir todos los datos de un artículo";
    }
}
