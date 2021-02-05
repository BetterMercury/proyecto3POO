/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import Usuarios.Persona;
import Usuarios.empleados.Empleado;
import datos.Dato;
import java.util.Scanner;
import java.util.TreeSet;
/**
 *
 * @author ribel
 */
public class busquedaPorCadenaDeEmpleados extends Operacion{

    @Override
    public void realizarOperacion(Persona operador) {
        Scanner sc = new Scanner(System.in);
        String cadenaBuscada;
        Dato datosGenerales = Dato.getInstance();
        TreeSet<Empleado> setDeEmpleados = datosGenerales.getSetDeEmpleados();
        System.out.println("Ingresa la cadena que quieres buscar entre los"
                + "empleados. Debe ser de almenos 4 caracteres");
        cadenaBuscada = sc.nextLine();
        if(cadenaBuscada.length()<4){
            System.out.println("No escribiste una cadena lo suficientemente"
                    + " larga");
        }else{
            for(Empleado iterador : setDeEmpleados){
                int indiceEncontrado;
                int tamanioCadenaBuscada = cadenaBuscada.length();
                cadenaBuscada.replaceAll("\\s",""); //Elimina todos los caracteres no visibles
                String cadenaDeBusqueda = iterador.getCadenaTodoJunto().toLowerCase();
                cadenaBuscada = cadenaBuscada.toLowerCase();
                indiceEncontrado = cadenaDeBusqueda.indexOf(cadenaBuscada);
                if(indiceEncontrado != -1){
                    System.out.print("Coincidencia en el empleado con numero: "+iterador.getNumeroEmpleado());
                    System.out.println("\t"+iterador.getCadenaTodoJunto().substring(indiceEncontrado,
                            indiceEncontrado+tamanioCadenaBuscada-1));
                    System.out.println("");
                }
            }
        }
        
    }
    
}
