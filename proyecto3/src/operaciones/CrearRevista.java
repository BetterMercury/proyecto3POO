/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import Revista.Revista;
import Usuarios.Persona;
import Usuarios.empleados.Administrador;
import Usuarios.empleados.Director;
import datos.Dato;
import java.util.Scanner;

/**
 *
 * @author Dante
 */
public class CrearRevista extends Operacion{
    //Una revista solo puede ser publicada por el director de la empresa
    //Poder hacer una consulta del estado de un articulo mediante
    //su folio solo disponible para empleados
    
    @Override
    public void realizarOperacion(Persona operador) {
        int op;
        Scanner sc = new Scanner(System.in);
        
        if(operador instanceof Director || operador instanceof Administrador){
                
            System.out.println("");
            System.out.println("Usted Director, puede crear una revista");
            System.out.println("");
            
            if(operador instanceof Administrador){
                System.out.println("Acceso concedido al Administrador");
                System.out.println("");
            }
            
            Dato datos = Dato.getInstance(); 

            //Creacion de la Revista
            String titulo;
            do{
                Revista revistaNueva = new Revista();

                revistaNueva.pedirDatos();

                //almacenamos el articulo en Dato

                if(datos.aniadirRevista(revistaNueva)){
                    System.out.println("");
                    System.out.println("Se ha añadido la revista correctamente");
                } else {
                    System.out.println("");
                    System.out.println("Error: No se ha guardado la revista");
                }

                System.out.println(" ");            
                System.out.println("Si desea crear otra revista, presione '1'");
                while(true){
                    try{
                        op = sc.nextInt();

                    }catch(IllegalArgumentException ia){
                        System.out.println(" ");
                        System.out.println("Ingrese un numero correctamente, intente nuevamente");
                        continue;
                    }
                    break;
                }            
            } while(op==1);

    } else{
            System.out.println("No tienes privilegios suficientes para acceder a esta"
                    + " operacion");
        }            
    }

    
    @Override
    public String toString() {
        
        return "Crear una revista";
    }
    
}
