/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Equipo 9
 * Clase que se encarga de que los revisores puedan revisar articulos y calificarlos
 */
public class RevisarArticulo extends Operacion{
    
    public void realizarOperacion(Persona operador){
        Revisor revisor = (Revisor) operador;     
        
        //datos de articulos creados
        Dato datosGenerales = Dato.getInstance();
        imprimirArticulos irev = new imprimirArticulos();
        irev.realizarImpresion(datosGenerales);
        Scanner sc = new Scanner(System.in);
        
        System.out.println(" ");
        System.out.println("Usted revisor, revisara articulos");
        System.out.println(" ");
        
        int op = 0;
        String folio;
        int calif = 0;
        int k = 0;
        
        HashMap<String,Integer> folios = new HashMap<>();   //mapa temporal para no volver a ver el mismo articulo
        
        do{
            System.out.println(" ");
            System.out.println("Escriba el folio del articulo que revisara");
            while(true){
                try{
                    folio = sc.nextLine();
                    if(datosGenerales.existsFolioArticulo(folio) && !(folios.containsKey(folio)) ){  //si existe el folio del articulo y si aun no se revisa
                        Articulo articulo = datosGenerales.buscarFolioArticulo(folio);  //me traigo el articulo que ya existe, por lo que se actualizara solo
                        
                        System.out.println(" ");
                        System.out.println("Escriba la calificacion de este articulo de 0 a 10 en numero entero");
                        while(true){    
                            try{
                                calif = sc.nextInt();
                                if(calif<0 || calif>10){
                                    throw new IllegalArgumentException();
                                }
                            }catch(IllegalArgumentException i){
                                System.out.println(" ");
                                System.out.println("Ingrese un numero entero de 0 a 10");
                                continue;
                            }
                            break;
                        }
                        //asociacion de revisor y calificacion con articulo
                        
                        articulo.setRevisor(revisor, calif);
                        articulo.setEstado(Estado.STATER6); //cambio de estado del aticulo
                        PedirNumeroArticulosRevisadosRevisor pedir = new PedirNumeroArticulosRevisadosRevisor();
                        pedir.realizarPeticion(revisor, articulo);  //al revisor se le guarda el articulo leido
                        
                    }else{
                        throw new IllegalArgumentException();
                    }
                }catch(IllegalArgumentException e){
                    System.out.println(" ");
                    System.out.println("Ingrese el folio correctamente, intente nuevamente");
                    continue;
                }
                break;
            }
            
            folios.put(folio, k);
            k++;
            
            
            System.out.println(" ");
            System.out.println("Si desea revisar otro articulo (diferente al que ya reviso), presione '1'");
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
        }while(op == 1);
        
        
        
    }    
}
