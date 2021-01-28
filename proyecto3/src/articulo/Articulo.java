package articulo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Estado.Estado;
import java.util.ArrayList;
import Usuarios.Persona; //Hay que cambiarlo por Autor cuando este
import Usuarios.empleados.Autor;
<<<<<<< HEAD
=======
import Usuarios.empleados.Revisor;
>>>>>>> 09be6ed3e2690ba3033879065d931359e44edd75

/**
 *
 * @author ribel
 */
<<<<<<< HEAD
public class Articulo {
ArrayList<Autor> autores; //Cambiar por autores
=======
public class Articulo implements Estado{
ArrayList<Autor> autores; //Sólo se puede tener un máximo de 3 autores, verificacion en clase pedirAutores
>>>>>>> 09be6ed3e2690ba3033879065d931359e44edd75
String Titulo;
String Snopsis;
Categoria categoria;
Revisor revisor; 
int calificion;

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
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

}
