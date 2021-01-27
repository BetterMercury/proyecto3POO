/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios.empleados;

import Usuarios.empleados.Empleado;
/**
 *
 * @author Equipo 9
 */
public class Autor extends Empleado{
    
    public Autor(){
        super();
    }
    
    String institucion;
    int numeroArticulosEscritos;
    
    public String getInstitucion(){
        return institucion;
    }
    
    public void setInstitucion(String institucion){
        this.institucion = institucion;
    }
    
    public int getNumeroArticulosEscritos(){
        return numeroArticulosEscritos;
    }

    public void setNumeroArticulosEscritos(int numeroArticulosEscritos) {
        
        if( (numeroArticulosEscritos >= 0) && (numeroArticulosEscritos < 30) ){   //limite en articulos que se pueden colocar
            this.numeroArticulosEscritos = numeroArticulosEscritos;
        }else{
            System.out.println(" ");
            System.out.println("Numero de articulos escritos invalido");
        }
    }
    
}
