
package Impresiones;

import datos.Dato;
import java.io.Serializable;

/**
 *Clase abstracta que permite que las impresiones de diferentes estructuras presentes
 * en Dato compartan una misma estructura.
 * @author Dante
 */
public abstract class Imprimir implements Serializable {
    /**
     * Método abstraacto para unificar la manera en que se mandan a llamar las 
     * impresiones de las diferentes estructuras.
     * @param datosGenerales 
     */
    public abstract void realizarImpresion(Dato datosGenerales);
    
}
