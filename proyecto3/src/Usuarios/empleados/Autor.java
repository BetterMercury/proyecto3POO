/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios.empleados;

import Peticiones.peticionesUsuarios.PedirInstitucion;
import Peticiones.peticionesUsuarios.PedirNumeroArticulosEscritosAutor;
/**
 *
 * @author Equipo 9
 */
public class Autor extends Empleado{
    
    public Autor(){
        super();
        this.peticonesNecesarias.add(new PedirInstitucion());
        this.peticonesNecesarias.add(new PedirNumeroArticulosEscritosAutor());
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
            this.numeroArticulosEscritos = numeroArticulosEscritos;
    }
    
}
