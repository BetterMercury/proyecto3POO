/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Dante
 */
public class ListaVaciaException extends Exception {

    public ListaVaciaException() {
        super("Error: La lista ingresada no tiene ningun elemento");
    }
        
}
