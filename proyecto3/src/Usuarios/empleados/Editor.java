/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios.empleados;

import Usuarios.empleados.Empleado;

/**
 *
 * @author Equipo 9
 */
public class Editor extends Empleado{
    
    public Editor(){
        super();
    }
    
    String posgrado; //debe ser maestría o doctorado
    int numeroArticulosRevisados;
    int numeroCedula;
    
    public String getPosgrado(){
        return posgrado;
    }

    public void setPosgrado(String posgrado) {
        if(posgrado.compareTo("Doctorado") == 0){       //condicion de solo colocar dos posgrados
            this.posgrado = posgrado;
        }else if(posgrado.compareTo("Maestria") == 0){
            this.posgrado = posgrado;
        }else{
            System.out.println(" ");
            System.out.println("No se ha ingreso un posgrado valido");
        }
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
        int cifras = 0;
        int numCed = numeroCedula;
   
        cifras= 0;    //esta variable es el contador de cifras
        while(numCed!=0){             //mientras a numCed le queden cifras
            numCed = numCed/10;         //le quitamos el último dígito
            cifras++;          //sumamos 1 al contador de cifras
        }
        
        if((numCed == 5) ){   //se forza a tener 5 cifras en el numero de cedula
            this.numeroCedula = numeroCedula;
        }else{
            System.out.println(" ");
            System.out.println("El numero de cedula no es de 5 digitos");
        }
        
    }
    
}
