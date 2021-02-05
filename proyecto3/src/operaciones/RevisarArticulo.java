
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

/**
 * Clase que hereda de la clase abstracta Operacion;
 * sirve para representar la operación de revisar
 * un artículo por parte del Revisor,
 * implementando el método realizarPeticion.
 * @author Equipo 9
 * 
 */
public class RevisarArticulo extends Operacion{
    
    /**
        * Método implementado de la clase padre que se encarga de revisar 
        * un artículo por parte de un objeto de la clase Revisor.
        * @param operador Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * 
        */
    @Override
    public void realizarOperacion(Persona operador){
        try{
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
                        if(datosGenerales.buscarFolioArticulo(folio).getEstado().equals(Articulo.STATER3)){
                            throw new ErrorDeDatoException("El Articulo ya ha sido utilizado en otra Revista");
                        }
                        if(folios.containsKey(folio)){
                            throw new ErrorDeDatoException("El folio ha sido revisado anteriormente");
                        }
                        if(datosGenerales.existsFolioArticulo(folio)){  //si existe el folio del articulo y si aun no se revisa
                            Articulo articulo = datosGenerales.buscarFolioArticulo(folio);  //me traigo el articulo que ya existe, por lo que se actualizara solo

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
                    catch (ErrorDeDatoException e){
                        System.out.println("");
                        System.out.println(e.getMessage());
                        break;
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
