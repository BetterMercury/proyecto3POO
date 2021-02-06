
package Impresiones;

import Usuarios.empleados.Administrador;
import Usuarios.empleados.Autor;
import Usuarios.empleados.Director;
import Usuarios.empleados.Editor;
import Usuarios.empleados.Empleado;
import Usuarios.empleados.Revisor;
import datos.Dato;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/**
 *Clase que imprime datos básicos de todos los empleados Se imprime el nombre,
 * la fecha de ingreso, y el puesto.
 * @author Dante
 */
public class ImprimirEmpleadosSencillo extends Imprimir{
    
    /**
     * Método para imprimir las características y atributos
     * de los sujetos empleado, cuidadndo la impresión de
     * datos confidenciales.
     * @param datosGenerales 
     */
    @Override
    public void realizarImpresion(Dato datosGenerales) {
        HashMap <Integer, Empleado> mapaEmpleados = datosGenerales.getMapEmpleados();
        
        for(Map.Entry<Integer, Empleado> entry : mapaEmpleados.entrySet()){
            System.out.println("Nombre : " + entry.getValue().getNombre() + " " + entry.getValue().getApellidoPaterno() + " " + entry.getValue().getApellidoMaterno());
            System.out.println("Fecha de Ingreso : " + entry.getValue().getFechaIngreso());
            System.out.print("Puesto : ");
            if(entry.getValue() instanceof Director){
                System.out.print("Director\n");
            }
            if(entry.getValue() instanceof Autor){
                System.out.print("Autor\n");
            }
            if(entry.getValue() instanceof Editor){
                System.out.print("Editor\n");
            }            
            if(entry.getValue() instanceof Revisor){
                System.out.print("Revisor\n");
            }   
            if(entry.getValue() instanceof Administrador){
                System.out.print("Administrador\n");
            }                       
            System.out.println("Numero : " + entry.getKey());
            System.out.println("---------------");
        }            
    }
    
    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString() {
        return "Imprimir lista con informacion basica de empleados";
    }
    
}
