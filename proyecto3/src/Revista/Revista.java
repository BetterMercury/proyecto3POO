/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Revista;

import Estado.Estado;
import Excepciones.ErrorDeDatoException;
import Peticiones.peticionesRevista.PeticionesRevista;
import Peticiones.peticionesRevista.pedirTitulo;
import Usuarios.empleados.Editor;
import articulo.Articulo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Clase que representa a una Revista, implementa a la 
 * interfaz Estado para determinar si está publicada o no.
 * @author Dante
 */

public class Revista implements Estado{
    /*
    ArrayList<Operacion> operacionesDisponible;
    ArrayList<PeticionRevista> peticionesNecesarias;    
    */
    
    static DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");	//se crea un objeto de la clase formateador para localDate
    public static int conteoRevistas;
    
    private String titulo;
    private LocalDate fechaPublicacion;
    private Editor editor; //Solo puede contener editor si es publicado
    private int numRevista;
    private String Estado;
    
    
    private LinkedList<Articulo> articulos = new LinkedList<>();    
    
    

    public ArrayList<PeticionesRevista> peticionesNecesarias;
    
    public Revista(){
        peticionesNecesarias = new ArrayList<>();
        peticionesNecesarias.add(new pedirTitulo());
        conteoRevistas++;
        this.Estado = STATER2;   //se auto asigna como NO PUBLICADO
    }    
    
    public void pedirDatos(){
        System.out.println("Por favor ingresa los datos que se te piden \n");
        for(PeticionesRevista peticion: peticionesNecesarias){
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
        final Revista other = (Revista) obj;
        return true;
    }    
    

    public String getEstado() {
        return Estado;
    }

    public static String getSTATER1() {
        return STATER1;
    }

    public static String getSTATER2() {
        return STATER2;
    }
    
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public static int getConteoRevistas() {
        return conteoRevistas;
    }

    public static void setConteoRevistas(int conteoRevistas) {
        Revista.conteoRevistas = conteoRevistas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Método de acceso para obtener la fecha de publicación de un objeto Revista.
     * @return Retorna la fecha de publicación de esta Revista en cadena.
     **/
    public String getFechaPublicacion() {
        return formateador.format(fechaPublicacion);    //regresa la cadena con fecha establecida por LocalDate
    }

    /**
     * Método de acceso para establecer la fecha de publicación de un objeto Revista.
     * @param fechaPublicacion La fecha de publicacion en cadena que se le pondrá al objeto.
     */
    public void setFechaPublicacion(String fechaPublicacion) {  //cadena en formato dd/MM/AAAA
 
        this.fechaPublicacion = LocalDate.parse(fechaPublicacion, formateador);
        
    }

    public LinkedList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(LinkedList<Articulo> articulos) {
        this.articulos = articulos;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public int getNumRevista() {
        return numRevista;
    }

    public void setNumRevista(int numRevista) {
        this.numRevista = numRevista;
    }
    
    public void setArticulo(Articulo art){
        this.articulos.add(art);
    }
    
    /**
     * Metodo que nos sirve para definir si una revista
     * incluye al menos dos articulos de cada categoria.
     */
    public boolean comprobacionCAT(){
        /*
        NOTA:
        CAT1 = "Inteligencia Artificial";   
        CAT2 = "Analisis de Sistemas de Software";    
        CAT3 = "Bases de Datos";    
        CAT4 = "Hardware";    
        */
        
        int contCAT1 = 0;
        int contCAT2 = 0;
        int contCAT3 = 0;
        int contCAT4 = 0;        
        int need;
        
        //Recorremos la lista de Articulos
        for(Articulo art : this.articulos){
            if(art.getCategoria().equals(Articulo.CAT1)){
                contCAT1++;
            }
            if(art.getCategoria().equals(Articulo.CAT2)){
                contCAT2++;
            }
            if(art.getCategoria().equals(Articulo.CAT3)){
                contCAT3++;
            }
            if(art.getCategoria().equals(Articulo.CAT4)){
                contCAT4++;
            }            
        }
        
        boolean puedePublicarse = true;
        
        if(contCAT1 < 2){
            need = 2 - contCAT1;
            System.out.println("A esta revista le faltan " + need +
                    " articulos de " + Articulo.CAT1);
            puedePublicarse = false;
        }
        
        if(contCAT2 < 2){
            need = 2 - contCAT1;
            System.out.println("A esta revista le faltan " + need +
                    " articulos de " + Articulo.CAT2);
            puedePublicarse = false;
            
        }
        
        if(contCAT3 < 2){
            need = 2 - contCAT1;
            System.out.println("A esta revista le faltan " + need +
                    " articulos de " + Articulo.CAT3);
            puedePublicarse = false;
            
        }

        if(contCAT4 < 2){
            need = 2 - contCAT1;
            System.out.println("A esta revista le faltan " + need +
                    " articulos de " + Articulo.CAT4);
            puedePublicarse = false;
            
        }        
        
        return puedePublicarse;

    }
    
}
