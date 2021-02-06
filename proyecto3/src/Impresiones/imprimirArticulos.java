
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
    
    
    /**
     * Método para imprimir las características y atributos
     * de los artículos, de forma resumida.
     * @param datosGenerales 
     */
    @Override
    public void realizarImpresion(Dato datosGenerales){
        HashMap <String, Articulo> mapaArticulos = datosGenerales.getMapaArticulos();
        
        for(Map.Entry<String, Articulo> entry : mapaArticulos.entrySet()){
            System.out.println("Folio : " + entry.getKey() + " ; Titulo : " + entry.getValue().getTitulo());
            System.out.println("Categoria : " + entry.getValue().getCategoria() + " ; Estado: " + entry.getValue().getEstado());
            System.out.println("---------------");
        }
    };
    
    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString() {
        return "Imprimir lista de articulos";
    }
    
}
