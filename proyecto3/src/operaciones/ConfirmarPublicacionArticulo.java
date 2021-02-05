
package operaciones;


import Impresiones.imprimirArticulos;
import Usuarios.Persona;
import Usuarios.empleados.Editor;
import articulo.Articulo;
import datos.Dato;
import java.util.InputMismatchException;
import java.util.Scanner;
import Estado.Estado;

import java.awt.Desktop;
import java.awt.desktop.*;
import java.io.*;

/**
 * Clase que hereda de la clase abstracta Operacion;
 * sirve para representar la operación de confirmar
 * la publicación de un artículo por parte del Editor,
 * implementando el método realizarPeticion.
 * @author Equipo 9
 * 
 */
public class ConfirmarPublicacionArticulo extends Operacion implements Estado{
    
        /**
        * Método implementado de la clase padre que se encarga de confirmar
        * la publicación de un artículo por parte de un objeto de la clase Editor.
        * @param operador Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * 
        */
    @Override
    public void realizarOperacion(Persona operador) {
        try{
            Editor editor = (Editor) operador;   
            int op = 0;
            String folio;
            Scanner sc = new Scanner(System.in);
            Dato datosGenerales = Dato.getInstance();
            String op2;

            //datos de articulos creados
            imprimirArticulos irev = new imprimirArticulos();
            irev.realizarImpresion(datosGenerales);


            System.out.println(" ");
            System.out.println("Usted Editor, acepta o rechaza artículos");
            System.out.println(" ");

            
            

            do{
                if(datosGenerales.getSetArticulosRevisados().isEmpty() ){
                    System.out.print("No hay artículos revisados para aplicar esta operación");
                    break; //Si no hay artículos pendientes o rechazados no continua para que no se cicle. 
                }
                System.out.println(" ");
                System.out.println("Escriba el folio del articulo que aceptara o rechazara");
                
                while(true){
                    folio = sc.nextLine();
                    if(datosGenerales.existsFolioArticulo(folio)){  //si existe el folio
                        
                        Articulo articulo = datosGenerales.buscarFolioArticulo(folio); // pide el articulo
                        String estadoArticulo = articulo.getEstado();  //pide el estado del articulo
                        
                        if(estadoArticulo.equals(STATER6)){ //Verifica que el articulo sea rechazado o pendiente
                            
                            System.out.println("Mostrando el articulo...");
                            
                            if(Desktop.isDesktopSupported()){
                                try{
                                    Desktop.getDesktop().open(articulo.getReferenciaArticulo());
                                }catch (IOException e){
                                    System.out.println("Ocurrio un error al abrir el archivo");
                                }
                            }
                            
                            
                            System.out.println(" ");
                            System.out.println("Escriba A si acepta el articulo o R si lo rechaza");
                            
                            while(true){    
                                try{
                                    op2 = sc.nextLine();
                                    if(!op2.equals("A") && !op2.equals("B")){
                                        throw new IllegalArgumentException();
                                    }
                                }catch(IllegalArgumentException | InputMismatchException i){
                                    System.out.println(" ");
                                    System.out.println("Por favor ingresa A o R");
                                    continue;
                                }
                                break;
                            }
                            //asociacion de revisor y calificacion con articulo
                            if(op2.equals("A")){
                                articulo.setEstado(Estado.STATER3); //cambio de estado del aticulo
                            }else{
                                articulo.setEstado(Estado.STATER5); //cambio de estado del aticulo
                            }
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
                System.out.println("Si desea aceptar o denegar otro articulo, presione '1'");
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
    public String toString(){
        return "Revisar un articulo y aceptarlo o rechazarlo";
    }
}
