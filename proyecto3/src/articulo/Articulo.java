package articulo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Estado.Estado;
import Excepciones.ErrorDeDatoException;
import Peticiones.peticionesArticulos.PeticionesArticulo;
import Peticiones.peticionesArticulos.*;
import java.util.ArrayList;
import Usuarios.Persona; //Hay que cambiarlo por Autor cuando este
import Usuarios.empleados.Autor;

import Usuarios.empleados.Revisor;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 *
 * @author ribel
 */
public class Articulo implements Estado, Categoria, Serializable, Comparable<Articulo>{ 
    private ArrayList<Autor> autores; //Sólo se puede tener un máximo de 3 autores, verificacion en clase pedirAutores
    private String Titulo;
    private String Snopsis;
    private String categoria;
    private HashMap <Integer, Revisor> revisoresCalificaciones;
    private String estado;
    private String folio; //Clave alfanumerica de 8 digitos
    
    private ArrayList<PeticionesArticulo> peticionesNecesarias;  //lista para hacer las peticiones de forma automática
    
    
    public Articulo(){
        autores = new ArrayList<>();
        peticionesNecesarias = new ArrayList<>();
        peticionesNecesarias.add(new pedirTitulo());
        peticionesNecesarias.add(new pedirSinopsis());
        peticionesNecesarias.add(new pedirCategoria());
        peticionesNecesarias.add(new pedirAutores());
        peticionesNecesarias.add(new GenerarFolio());
        this.estado = Estado.STATER4;   //se auto asigna como pendiente
    }
    
    HashMap <Integer, Integer> mapaCalificaciones;    //La clave es el número de cuenta del Revisor,
                                                      //el valor representa la calificacion puesta
    
    /**
     * Método para la obtención de una parte del Folio por medio
     * de la generación de un HashCode que utiliza cada uno de los
     * atributos de un Articulo
     * 
     */
    
    public void pedirDatos(){
        System.out.println("Por favor ingresa los datos que se te piden \n");
        for(PeticionesArticulo peticion: peticionesNecesarias){
            while(true){
                try{
                    peticion.realizarPeticion(this);
                }catch(ErrorDeDatoException e){
                    System.out.println("Ocurrio un error: "+e.getMessage());
                    continue;
                }
                break;
            }
        }
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.autores);
        hash = 83 * hash + Objects.hashCode(this.Titulo);
        hash = 83 * hash + Objects.hashCode(this.Snopsis);
        hash = 83 * hash + Objects.hashCode(this.categoria);
        hash = 83 * hash + Objects.hashCode(this.revisoresCalificaciones);
        hash = 83 * hash + Objects.hashCode(this.estado);
        hash = 83 * hash + Objects.hashCode(this.folio);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Articulo other = (Articulo) obj;
        return true;
    }

    //METODOS QUE OBTIENEN LAS CATEGORIAS DE LA INTERFAZ CATEGORIA
    public static String getCAT1() {
        return CAT1;
    }
    public static String getCAT2() {
        return CAT2;
    }
    public static String getCAT3() {
        return CAT3;
    }
    public static String getCAT4() {
        return CAT4;
    }
     
    //METODOS QUE OBTIENEN LOS ESTADOS DE LA INTERFAZ ESTADO
    public static String getSTATER3() {
        return STATER3;
    }
    public static String getSTATER4() {
        return STATER4;
    }
    public static String getSTATER5() {
        return STATER5;
    }
    
    //MÉTODOS COMUNES PARA LA CLASE Articulo
    
    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }
    
    public Autor getAutor() {
        if(autores.isEmpty() == false){
            return autores.get(0);
        }else{
            return null;
        }
        
    }
    
    public void setAutor(Autor autor){
        if(autores.size() <= 3){
            autores.add(autor);
        }else{
            System.out.println(" ");
            System.out.println("Ya hay 3 autores asociados a este articulo");

        }
        
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getSnopsis() {
        StringBuilder cadena = new StringBuilder();
        int i;
        for(i=80; i<this.Snopsis.length();i+=80){
            String subCadena;
            subCadena = this.Snopsis.substring(i-80,i+1)+"\n";
            cadena.append(subCadena);
        }
        cadena.append(this.Snopsis.substring(i-80,this.Snopsis.length()));
        cadena.append("\n");
        return cadena.toString();
    }

    public void setSnopsis(String Snopsis) {
        this.Snopsis = Snopsis;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Persona getRevisor(int i) {
        return revisoresCalificaciones.get(i);
    }

    public void setRevisor(Revisor revisor, int i) {
        this.revisoresCalificaciones.put(i, revisor);
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }   

    @Override
    public String toString() {
        StringBuilder infoArticulo = new StringBuilder();
        infoArticulo.append("\nTitulo: ").append(this.Titulo);
        infoArticulo.append("\nAutores: ").append(this.autoresToString());
        infoArticulo.append("\nEstado: ").append(this.estado);
        infoArticulo.append("\nFolio: ").append(this.folio);
        infoArticulo.append("\nSinopsis: ").append(this.getSnopsis());
        return infoArticulo.toString();
    }
    
    /**
     * Método que concatena los nombres de todos los autores
     * contenidos en el ArrayList de autores
     * @return String con los nombres de los autores
     */
    public String autoresToString(){
        StringBuilder autoresCadena = new StringBuilder();
        if(this.autores.isEmpty()){
            return "Sin autores";
        }else{
            for(Autor autor:this.getAutores()){
            autoresCadena.append(autor.getApellidoPaterno())
                    .append(", ").append(autor.getNombre()).append("; ");
        }
        return autoresCadena.toString();
        }
    }
    
    public String revisoresToString(){
        StringBuilder revisoresCadena = new StringBuilder();
        if(this.revisoresCalificaciones.isEmpty()){
            return "Sin Revisores";
        } else {
            for(Map.Entry<Integer, Revisor> entry : this.revisoresCalificaciones.entrySet()){            
                revisoresCadena.append("Revisor").append(entry.getValue().toString()).append(" ; Calificacion : ").append(entry.getKey()).append(" \n");
            }
            return revisoresCadena.toString();
        }         
    }

    @Override
    public int compareTo(Articulo o) {
        // TODO Auto-generated method stub
        return this.Titulo.compareTo(o.getTitulo());
    }
}

