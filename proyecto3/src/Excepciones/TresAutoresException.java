/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 * Esta excepción es lanzada cuando se intentan colocar más de tres
 * autores a un Artículo.
 * @author Dante
 */
public class TresAutoresException extends Exception{

    public TresAutoresException() {
        super("Error: Sólo pueden existir tres autores en un artículo");
    }    
    
}
