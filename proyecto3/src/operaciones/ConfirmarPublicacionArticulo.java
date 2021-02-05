
package operaciones;

import Estado.Estado;
import Excepciones.ErrorDeDatoException;
import Impresiones.imprimirArticulos;
import Peticiones.peticionesArticulos.pedirEstado;
import Peticiones.peticionesUsuarios.PedirNumeroArticulosRevisadosRevisor;
import Revista.Revista;
import Usuarios.Persona;
import Usuarios.empleados.Editor;
import articulo.Articulo;
import datos.Dato;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Clase que hereda de la clase abstracta Operacion;
 * sirve para representar la operación de confirmar
 * la publicación de un artículo por parte del Editor,
 * implementando el método realizarPeticion.
 * @author Equipo 9
 * 
 */
public class ConfirmarPublicacionArticulo extends Operacion{
    
        /**
        * Método implementado de la clase padre que se encarga de confirmar
        * la publicación de un artículo por parte de un objeto de la clase Editor.
        * @param operador Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * 
        */
    @Override
    public void realizarOperacion(Persona operador){
       
        Editor edi = (Editor)operador;
        
        Dato datosGenerales = Dato.getInstance();
        imprimirArticulos irev = new imprimirArticulos();
        irev.realizarImpresion(datosGenerales);
        Scanner sc = new Scanner(System.in);
        pedirEstado pedir = new pedirEstado();
        HashMap<Integer,Revista> mapaRevistas;
        Articulo articulo;
        Revista revista;
        
        System.out.println(" ");
        System.out.println("Usted editor, aceptara o rechazara articulos");
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
                        articulo = datosGenerales.buscarFolioArticulo(folio);  //me traigo el articulo que ya existe, pues que se actualizara solo
                        
                        System.out.println(" ");
                        System.out.println("Lectura del articulo...");
                       
                        //aceptacion o rechazo de articulo por parte del editor
                        
                            System.out.println(" ");
                            System.out.println("Aceptar o rechazar artículo");
                            while(true){
                                try{
                                    pedir.realizarPeticion(articulo);
                                }catch(ErrorDeDatoException e){
                                     System.out.println("Ocurrio un error: "+e.getMessage());
                                        continue;
                                }
                                break;
                            }
                            
                            //el editor guardara el articulo que reviso
                            edi.setArticulosRevisados(articulo);
                        
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
            
            //proceso de dirigir un articulo a una revista
            mapaRevistas = datosGenerales.getMapaRevistas();
            if(!(mapaRevistas.isEmpty()) && articulo.getEstado().compareTo("Aceptado") == 0){   //si no esta vacio el mapa de revistas y si se acepto el articulo
                System.out.println(" ");
                System.out.println("Revistas disponibles");
                System.out.println(" ");
                for (Map.Entry<Integer, Revista> entry : mapaRevistas.entrySet()) {
                    System.out.println("Numero: " + entry.getKey() + ", revista: " + entry.getValue().getTitulo());
                }
                    
                System.out.println(" ");
                System.out.print("Ingrese el numero de la revista a la que quiere asociar el articulo: ");
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
                
                //en teoria se actualiza la referencia, entonces, deberia funcionar
                revista = mapaRevistas.get(op);
                revista.setArticulo(articulo);
                
                System.out.println(" ");
                System.out.println("Se guardo el articulo en la revista especificada");
                
            }else{
                System.out.println(" ");
                System.out.println("No se puede colocar el articulo en una revista");
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
    public String toString(){
        return "Revisar un articulo y aceptarlo o rechazarlo";
    }
}
