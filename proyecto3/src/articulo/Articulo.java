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
import java.util.HashMap;
import java.util.Objects;


/**
 *
 * @author ribel
 */
public class Articulo implements Estado, Categoria{
    
    private ArrayList<Autor> autores; //Sólo se puede tener un máximo de 3 autores, verificacion en clase pedirAutores
    private String Titulo;
    private String Snopsis;
    private String categoria;
    private Revisor revisor; 
    private String estado;
    private int calificion;
    private String folio; //Clave alfanumerica de 8 digitos
    
    private ArrayList<PeticionesArticulo> peticionesNecesarias;  //lista para hacer las peticiones de forma automática
    
    
    public Articulo(){
        peticionesNecesarias = new ArrayList<>();
        peticionesNecesarias.add(new pedirTitulo());
        peticionesNecesarias.add(new pedirSinopsis());
        peticionesNecesarias.add(new pedirCategoria());
        peticionesNecesarias.add(new GenerarFolio());
    }
    
    HashMap <Integer, Integer> mapaCalificaciones;    //La clave es el número de cuenta del Revisor,
                                                      //el valor representa la calificacion puesta
    
    /**
     * Método para la obtención de una parte del Folio por medio
     * de la generación de un HashCode que utiliza cada uno de los
     * atributos de un Articulo
     * @return 
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
        hash = 83 * hash + Objects.hashCode(this.revisor);
        hash = 83 * hash + Objects.hashCode(this.estado);
        hash = 83 * hash + this.calificion;
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
        this.autores.add(autor);
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getSnopsis() {
        return Snopsis;
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

    public Persona getRevisor() {
        return revisor;
    }

    public void setRevisor(Revisor revisor) {
        this.revisor = revisor;
    }

    public int getCalificion() {
        return calificion;
    }

    public void setCalificion(int calificion) {
        this.calificion = calificion;
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
    
    
}
