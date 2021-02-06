
package Impresiones;

import Revista.Revista;
import datos.Dato;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que permite imprimir Revistas en estado No Publicado
 * @author Dante
 */
public class imprimirRevistasNoP extends Imprimir{
    
    /**
     * Método para imprimir las características y atributos
     * de las revistas no publicadas, de forma resumida.
     * @param datosGenerales 
     */
    @Override
    public void realizarImpresion(Dato datosGenerales){
        int count=0;
        HashMap <Integer, Revista> mapaRevistas = datosGenerales.getMapaRevistas();        
        for(Map.Entry<Integer, Revista> entry : mapaRevistas.entrySet()){
            if(entry.getValue().getEstado().equals(Revista.STATER2)){ //Solo imprimir Revistas No Publicadas
                System.out.println("Numero : " + entry.getKey() + "; Titulo : " + entry.getValue().getTitulo());
                System.out.println("Estado: " + entry.getValue().getEstado());
                count++;
            }
        }
        if(count == 0){
            System.out.println("...no existen revistas para ser publicadas");
        } else {
            System.out.println("Existen " + count + " Revistas sin publicar");
        }
    }    
    
    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString() {
        return "Imprimir lista de revistas no publicadas";
    }
}
