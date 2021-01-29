/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Revista;

import Estado.Estado;
import Usuarios.empleados.Editor;
import articulo.Articulo;
import java.util.Date;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Objects;

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
    
    static int conteoRevistas;
    String titulo;
    Date fechaPublicacion;
    LinkedList<Articulo> articulos = new LinkedList<>();
    Editor editor; //Solo puede contener editor si es publicado
    int numRevista;
    String Estado;


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

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
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
    
    
}
