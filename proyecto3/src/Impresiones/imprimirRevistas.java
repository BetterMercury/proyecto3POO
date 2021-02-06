
package Impresiones;

import Revista.Revista;
import datos.Dato;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que puede imprimir a todas las revistas y su estado.
 * @author Dante
 */
public class imprimirRevistas extends Imprimir{
    
    /**
     * Método para imprimir las colecciones
     * de las revistas, de forma resumida.
     * @param datosGenerales 
     */
    @Override
    public void realizarImpresion(Dato datosGenerales){
        HashMap <Integer, Revista> mapaRevistas = datosGenerales.getMapaRevistas();        
        for(Map.Entry<Integer, Revista> entry : mapaRevistas.entrySet()){
            System.out.println("Numero : " + entry.getKey() + "; Titulo : " + entry.getValue().getTitulo());
            System.out.println("Estado: " + entry.getValue().getEstado());
        }        
    }   
    
    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString() {
        return "Imprimir lista de revistas";
    }
}
