
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

    /**
        * Método implementado de la clase padre que se encarga de asociar
        * tres objetos Autor a un objeto de la clase Articulo.
        * @param objetivo Un objeto de la clase Articulo para poder asociarle
        * como máximo tres autores.
        * */
    @Override
    public void realizarPeticion(Articulo objetivo) {
        
        Dato datosGenerales = Dato.getInstance();      
        Scanner sc = new Scanner(System.in);  
        int numEmpleado = 0; //Numero de empleado - autor
        int op = 1;
        boolean ok = true;
        
        do{
            System.out.println("");            
            System.out.println("Desea ingresar un nuevo autor además de usted?, ingrese 1");
            
            while(ok == true){
                try{
                    
                    op = sc.nextInt();
                    
                    
                    ok = false;

                }catch(InputMismatchException im){
                    sc.nextLine();
                    System.out.println("");
                    System.out.println("Necesita ingresar un dato numérico, intente nuevamente");
                }catch(IllegalArgumentException ia){
                    System.out.println(" ");
                    System.out.println("Ingrese un numero correctamente, intente nuevamente");
                }
            }
        
            
            if(op == 1){                           
                if(datosGenerales.getSetDeAutores().isEmpty()){
                    System.out.println("No existen autores creados");
                    System.out.println("... no se pueden asignar autores a un Artículo");
                    op = 2;
                } else {                
                    ok = false;

                    System.out.println("Se asignaran autores a un Articulo");
                    System.out.println("Nota: Maximo tres autores por articulo");
                    
                    System.out.println("Autores disponibles: ");    
                    imprimirAutoresSencillo impAS = new imprimirAutoresSencillo();
                    impAS.realizarImpresion(datosGenerales);
                    System.out.println("");
                    
                    do {
                        System.out.println("Elegir numero de autor : ");

                        while(true){
                            try{
                                numEmpleado = sc.nextInt();
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
                        
                        if(datosGenerales.existsNumeroEmpleado(numEmpleado)){

                            if(objetivo.getAutor().equals(datosGenerales.buscarNumeroEmpleado(numEmpleado))){
                                System.out.println("");
                                System.out.println("No te puedes seleccionar a ti mismo, ya estas"
                                        + " registrado");
                                ok = true;
                            }  else{                                                  
                                objetivo.setAutor((Autor) datosGenerales.buscarNumeroEmpleado(numEmpleado));
                                System.out.println("Autor asignado correctamente");
                                System.out.println("");
                                ok = true;
                            }

                        } else {
                            System.out.println("El numero de empleado no existe, ingrese uno valido");
                            System.out.println("");
                        }
                    } while (ok == false);                                
                }
            }else{
                System.out.println("");
                System.out.println("... saliendo de operacion");
            }
            
        }while(op == 1);
    }
}


        /*
        if(op == 1){                                    
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
        } else {
            
        }
    }
}
*/
    

