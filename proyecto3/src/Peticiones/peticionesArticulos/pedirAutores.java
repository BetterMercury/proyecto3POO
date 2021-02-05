/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesArticulos;

import Excepciones.TresAutoresException;
import Impresiones.imprimirAutoresSencillo;
import Usuarios.empleados.Autor;
import articulo.Articulo;
import datos.Dato;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Clase que permite asociar una lista de maximo 3 autores a un Articulo.
 * @author ribel
 */
public class pedirAutores extends PeticionesArticulo {

    @Override
    public void realizarPeticion(Articulo objetivo) {
        Dato datosGenerales = Dato.getInstance();      
        Scanner sc = new Scanner(System.in);  
        int numEmpleado; //Numero de empleado - autor
        int op=2;
            
        if(datosGenerales.getSetDeAutores().isEmpty()){
            System.out.println("No existen autores creados");
            System.out.println("... no se pueden asignar autores a un Artículo");
        } else {
            do{
                boolean ok = false;

                System.out.println("Se asignaran autores a un Articulo");
                System.out.println("Nota: Maximo tres autores por articulo");

                System.out.println("Autores disponibles: ");    
                imprimirAutoresSencillo impAS = new imprimirAutoresSencillo();
                impAS.realizarImpresion(datosGenerales);
                System.out.println("");        

                do {
                    System.out.println("Elegir numero de autor : ");
                    numEmpleado = sc.nextInt();                
                    if(datosGenerales.existsNumeroEmpleado(numEmpleado)){
                        objetivo.setAutor((Autor) datosGenerales.buscarNumeroEmpleado(numEmpleado));
                        System.out.println("Autor asignado correctamente");
                        System.out.println("");
                        ok = true;
                    } else {
                        System.out.println("El numero de empleado no existe, ingrese uno valido");
                        System.out.println("");
                    }
                } while (ok == false);

                System.out.println("");            
                System.out.println("Desea ingresar un nuevo autor, ingrese 1");
                while(true){
                    try{
                        op = sc.nextInt();

                    }catch(InputMismatchException im){
                        System.out.println("");
                        System.out.println("Necesita ingresar un dato numérico, intente nuevamente");
                    }catch(IllegalArgumentException ia){
                        System.out.println(" ");
                        System.out.println("Ingrese un numero correctamente, intente nuevamente");
                        continue;
                    }
                    break;
                }               
            }while(op==1);
        }
    }
}

    

