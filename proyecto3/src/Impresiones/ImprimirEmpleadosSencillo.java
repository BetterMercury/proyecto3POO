/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Dante
 */
public class ImprimirEmpleadosSencillo extends Imprimir{
    
    @Override
    public void realizarImpresion(Dato datosGenerales) {
        HashMap <Integer, Empleado> mapaEmpleados = datosGenerales.getMapEmpleados();
        
        for(Map.Entry<Integer, Empleado> entry : mapaEmpleados.entrySet()){
            System.out.println("Nombre : " + entry.getValue().getNombre() + entry.getValue().getApellidoPaterno() + entry.getValue().getApellidoPaterno());
            System.out.println("Fecha de Ingreso : " + entry.getValue().getFechaIngreso());
            System.out.println("Puesto : ");
            if(entry.getValue() instanceof Director){
                System.out.print("Director");
            }
            if(entry.getValue() instanceof Autor){
                System.out.print("Autor");
            }
            if(entry.getValue() instanceof Editor){
                System.out.print("Editor");
            }            
            if(entry.getValue() instanceof Revisor){
                System.out.print("Revisor");
            }   
            if(entry.getValue() instanceof Administrador){
                System.out.print("Administrador");
            }                       
            System.out.println("Numero : " + entry.getKey());
            
        }            
    }
    @Override
    public String toString() {
        return "Imprimir lista con informacion basica de empleados";
    }
    
}
