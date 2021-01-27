/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios.empleados;

import Usuarios.empleados.Empleado;

import java.util.LinkedList;
import java.util.List;
import java.util.Hashtable; //es sincronizada, para multi hilos
/**
 *
 * @author Equipo 9
 */
public class Revisor extends Empleado{
    
    public Revisor(){
        super();
    }
    
    String institucion;
    List<String> listaAreasInteres =new LinkedList<String>();
    Hashtable<String,Integer> areaInteresExperiencia = new Hashtable<>();   //tabla hash que relaciona areas de interes con años de experiencia
    int numeroArticulosRevisados;
    
    public String getInstitucion(){
        return institucion;
    }
    
    public void setInstitucion(String institucion){
        this.institucion = institucion;
    }
    
    public String getInteres(int i){    //recibe un indice, y retorna el interes de ese indice
        if( (i >= 0) && (i < listaAreasInteres.size()) ){
            return listaAreasInteres.get(i);
        }else{
            System.out.println(" ");
            System.out.println("Indice no valido");
        }
        return "Error";
    }
    
    public void setInteres(String interes, int experiencia){     //se agregan los intereses de los revisores
        this.listaAreasInteres.add(interes);
        areaInteresExperiencia.put(interes, experiencia);   //en la tabla hash se coloca el interes y la experiencia
    }
    
    public int getNumeroArticulosRevisados(){
        return numeroArticulosRevisados;
    }

    public void setNumeroArticulosRevisados(int numeroArticulosRevisados) {
        if( (numeroArticulosRevisados >= 0) && (numeroArticulosRevisados < 30) ){   //limite en articulos que se pueden colocar
            this.numeroArticulosRevisados = numeroArticulosRevisados;
        }else{
            System.out.println(" ");
            System.out.println("Numero de articulos revisados invalido");
        }
        
    }
}
