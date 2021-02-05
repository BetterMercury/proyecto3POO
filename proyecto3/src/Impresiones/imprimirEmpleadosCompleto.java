/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    @Override
    public void realizarImpresion(Dato datosGenerales){
        
        TreeSet <Empleado> setEmpleados = datosGenerales.getSetDeEmpleados();        
        Iterator <Empleado> iterator = setEmpleados.iterator();
        
        System.out.println("Empleados: ");
        while (iterator.hasNext()){
            System.out.println(iterator.toString());
        }
    }   
    @Override
    public String toString() {
        return "Imprimir lista con informacion completa de empleados";
    }  
}
