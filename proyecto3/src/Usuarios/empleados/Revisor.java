/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios.empleados;

import Peticiones.peticionesUsuarios.PedirInstitucion;
import Peticiones.peticionesUsuarios.PedirInteresRevisor;
import Peticiones.peticionesUsuarios.PedirNumeroArticulosRevisadosRevisor;
import Usuarios.empleados.Empleado;
import articulo.Articulo;
import java.util.Enumeration;

import java.util.LinkedList;
import java.util.List;
import java.util.Hashtable; //es sincronizada, para multi hilos
import java.util.Map;
import java.util.stream.Collectors;
import operaciones.RevisarArticulo;
/**
 *
 * @author Equipo 9
 */
public class Revisor extends Empleado{
    
    public Revisor(){
        super();
        this.peticonesNecesarias.add(new PedirInstitucion());
        this.peticonesNecesarias.add(new PedirInteresRevisor());
        //this.peticonesNecesarias.add(new PedirNumeroArticulosRevisadosRevisor());
        this.operacionesDisponible.add(new RevisarArticulo());
    }
    
    String institucion;
    List<String> listaAreasInteres = new LinkedList<String>();
    Hashtable<String,Integer> areaInteresExperiencia = new Hashtable<>();   //tabla hash que relaciona areas de interes con años de experiencia
    int numeroArticulosRevisados = 0;
    List<Articulo> articulosRevisados = new LinkedList<>(); //lista de articulos revisados
    
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
            this.numeroArticulosRevisados = numeroArticulosRevisados;
    }
    
    public Articulo getArticulosRevisados(int i){
        return articulosRevisados.get(i);
    }

    public void setArticulosRevisados(Articulo art) {
            this.articulosRevisados.add(art);
    }
    
    /**
     * Método que convierte la lista de intereses en un String para
     * su impresion facil. En el metodo toString() de esta clase no 
     * se emplea (hasta ahora).
     * @return 
     */
    private String interesesToString(){
        String list = this.listaAreasInteres.stream().map(n -> String.valueOf(n)).collect(Collectors.joining("\n", "{", "}"));
        return list;
    }
    
    /**
     * Metodo para convertir el Hashtable que asocia las areas
     * de interes con los años de experiancia, a un String util
     * para el metodo toString() de esta clase.
     * @return String con la informacion de areas de interes y años
     * de experiencia
     */
    private String interExpToString(){ //ES IMPORTANTE VERIFICAR EL FUNCIONAMIENTO DE ESTE METODO
        Hashtable<String,Integer> areasExp  = this.areaInteresExperiencia;        
        Enumeration areas = areasExp.keys();
        Enumeration experiencia = areasExp.elements();
        
        String hashString = "Areas de experiencia: \n";
        while(areas.hasMoreElements()){
            hashString +=areas.nextElement() + " ; Años: " + experiencia.nextElement() + "\n";
        }            
        
        return hashString;
    }


    @Override
    public String toString() {
        return super.toString() +
                "Institucion : " + institucion + interExpToString() + 
                "\nNumero de articulos revisados\n" + numeroArticulosRevisados;
    }

    
    
    
}
