/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios.empleados;

import Peticiones.peticionesUsuarios.GenerarIdentificador;
import Peticiones.peticionesUsuarios.PedirCedula;
import Peticiones.peticionesUsuarios.PedirPosgrado;
import Usuarios.empleados.Empleado;

/**
 *
 * @author Equipo 9
 */
public class Editor extends Empleado{
    
    public Editor(){
        super();
        this.peticonesNecesarias.add(new PedirPosgrado());
        this.peticonesNecesarias.add(new PedirCedula());    //falta pedir el numero de articulos, relacionado con la operacion asociada
    }
    
    String posgrado; //debe ser maestría o doctorado
    int numeroArticulosRevisados;
    int numeroCedula;
    
    public String getPosgrado(){
        return posgrado;
    }

    public void setPosgrado(String posgrado) {
            this.posgrado = posgrado;
    }
    
    public int getNumeroArticulosRevisados(){
        return numeroArticulosRevisados;
    }

    public void setNumeroArticulosRevisados(int numeroArticulosRevisados) {
        if(numeroArticulosRevisados >= 0){
            this.numeroArticulosRevisados = numeroArticulosRevisados;
        }else{
            System.out.println(" ");
            System.out.println("No se ha ingreso una cantidad valida");
        }
        
    }
    
    public int getNumeroCedula(){
        return numeroCedula;
    }

    public void setNumeroCedula(int numeroCedula){
            this.numeroCedula = numeroCedula;
    }

    @Override
    public String toString() {
        return super.toString() + 
                "Posgrado : " + posgrado + 
                "\nNumero de articulos revisados : " + numeroArticulosRevisados + 
                "\nNumero de cedula profesional : " + numeroCedula;
    }        
    
}
