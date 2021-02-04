/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones;

import datos.Dato;
import java.io.Serializable;

/**
 *
 * @author Dante
 */
public abstract class Imprimir implements Serializable {
    
    public abstract void realizarImpresion(Dato datosGenerales);
    
}
