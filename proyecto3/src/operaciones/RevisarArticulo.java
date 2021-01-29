/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import Impresiones.imprimirRevisores;
import Usuarios.Persona;
import Usuarios.empleados.Revisor;
import datos.Dato;

/**
 *
 * @author Equipo 9
 * Clase que se encarga de que los revisores puedan revisar articulos y calificarlos
 */
public class RevisarArticulo implements Operacion{
    
    public void realizarOperacion(Persona operador){
        Revisor revisor = (Revisor) operador;     
        
        Dato datosGenerales = Dato.getInstance();
        imprimirRevisores irev = new imprimirRevisores();
        irev.realizarImpresion(datosGenerales);
        
        System.out.println("Seleccionar el Numero de Cuenta del Revisor");        
    }    
}
