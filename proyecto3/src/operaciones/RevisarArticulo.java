
package operaciones;

import Impresiones.imprimirArticulos;
import Peticiones.peticionesArticulos.pedirEstado;
import Peticiones.peticionesUsuarios.PedirNumeroArticulosRevisadosRevisor;
import Usuarios.Persona;
import Usuarios.empleados.Revisor;
import articulo.Articulo;
import datos.Dato;
import java.util.HashMap;
import java.util.Scanner;
import Estado.Estado;
import Excepciones.ErrorDeDatoException;
import java.util.InputMismatchException;
import java.awt.Desktop;
import java.awt.desktop.*;
import java.io.*;

/**
 * Clase que hereda de la clase abstracta Operacion;
 * sirve para representar la operación de revisar
 * un artículo por parte del Revisor,
 * implementando el método realizarPeticion.
 * @author Equipo 9
 * 
 */
public class RevisarArticulo extends Operacion implements Estado{
    
    /**
        * Método implementado de la clase padre que se encarga de revisar 
        * un artículo por parte de un objeto de la clase Revisor.
        * @param operador Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * 
        */
    @Override
    public void realizarOperacion(Persona operador) {
        try{
            Revisor revisor = (Revisor) operador;   
            int op = 0;
            String folio;
            int calif = 0;  
            Scanner sc = new Scanner(System.in);
            Dato datosGenerales = Dato.getInstance();

            //datos de articulos creados
            imprimirArticulos irev = new imprimirArticulos();
            irev.realizarImpresion(datosGenerales);


            System.out.println(" ");
            System.out.println("Usted revisor, revisara articulos");
            System.out.println(" ");

            
            

            do{
                if(datosGenerales.getSetArticulosPendientes().isEmpty() && datosGenerales.getSetArticulosRechazados().isEmpty() ){
                    System.out.print("No hay artículos pendientes o rechazados para aplicar esta operación");
                    break; //Si no hay artículos pendientes o rechazados no continua para que no se cicle. 
                }
                System.out.println(" ");
                System.out.println("Escriba el folio del articulo que revisara");
                
                while(true){
                    folio = sc.nextLine();
                    if(datosGenerales.existsFolioArticulo(folio)){  //si existe el folio
                        
                        Articulo articulo = datosGenerales.buscarFolioArticulo(folio); // pide el articulo
                        String estadoArticulo = articulo.getEstado();  //pide el estado del articulo
                        
                        if(estadoArticulo.equals(STATER4) || estadoArticulo.equals(STATER5)){ //Verifica que el articulo sea rechazado o pendiente
                            
                            System.out.println("Mostrando el articulo...");
                            
                            if(Desktop.isDesktopSupported()){
                                try{
                                    Desktop.getDesktop().open(articulo.getReferenciaArticulo());
                                }catch (IOException e){
                                    System.out.println("Ocurrio un error al abrir el archivo");
                                }
                            }
                            
                            System.out.println(" ");
                            System.out.println("Escriba la calificacion de este articulo de 0 a 10 en numero entero");
                            
                            while(true){    
                                try{
                                    calif = sc.nextInt();
                                    if(calif<0 || calif>10){
                                        throw new IllegalArgumentException();
                                    }
                                }catch(IllegalArgumentException | InputMismatchException i){
                                    System.out.println(" ");
                                    System.out.println("Ingrese un numero entero de 0 a 10");
                                    sc.nextLine();
                                    continue;
                                }
                                break;
                            }
                            //asociacion de revisor y calificacion con articulo

                            articulo.setRevisor(revisor, calif);
                            articulo.setEstado(Estado.STATER6); //cambio de estado del aticulo
                            PedirNumeroArticulosRevisadosRevisor pedir = new PedirNumeroArticulosRevisadosRevisor();
                            pedir.realizarPeticion(revisor, articulo);  //al revisor se le guarda el articulo leido 
                            datosGenerales.actualizarEstadoArticulo(articulo);             
                        }

                    }else{
                        System.out.println(" ");
                        System.out.println("Ingrese el folio correctamente, intente nuevamente");
                        continue;
                    }
                    break;
                }



                System.out.println(" ");
                System.out.println("Si desea revisar otro articulo (diferente al que ya reviso), presione '1'");
                while(true){
                    try{
                        op = sc.nextInt();

                    }catch(IllegalArgumentException | InputMismatchException ia){
                        System.out.println(" ");
                        System.out.println("Ingrese un numero correctamente, intente nuevamente");
                        continue;
                    }
                    break;
                }
            }while(op == 1);  
        }catch(ClassCastException e){
                System.out.println("No tienes privilegios suficientes para acceder a esta"
                    + " operacion");
        }
    }   
    
    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString() {
        return "Revisar articulo";
    }
}
