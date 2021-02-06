
package Impresiones;

import datos.Dato;

/**
 *Operación que imprime todos los atributos de un director utilizando el método
 * toString de las operaciones.
 * @author Dante
 */
public class imprimirDirector extends Imprimir{
    
    /**
     * Método para imprimir las características y atributos
     * de los sujetos directores, con algunos atributos.
     * @param datosGenerales 
     */
    @Override
    public void realizarImpresion(Dato datosGenerales){
        System.out.println("Director:");
        System.out.println(datosGenerales.getDirectorGeneral().toString());
    }   
    
    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString() {
        return "Imprimir informacion del director";
    } 
}
