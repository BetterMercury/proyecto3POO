
package Impresiones;

import Usuarios.empleados.Empleado;
import datos.Dato;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *Operación que imprime toda la información compartida de todos los tipos de 
 * usuarios. Aprovecha el método toString de los empleados.
 * @author Dante
 */
public class imprimirEmpleadosCompleto extends Imprimir{
    
    /**
     * Método para imprimir las características y atributos
     * de los sujetos empleado, de forma completa.
     * @param datosGenerales 
     */
    @Override
    public void realizarImpresion(Dato datosGenerales){
        
        TreeSet <Empleado> setEmpleados = datosGenerales.getSetDeEmpleados();        
        Iterator <Empleado> iterator = setEmpleados.iterator();
        
        System.out.println("Empleados: ");
        while (iterator.hasNext()){
            System.out.println(iterator.toString());
        }
    }   
    
    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString() {
        return "Imprimir lista con informacion completa de empleados";
    }  
}
