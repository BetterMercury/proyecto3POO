
package operaciones;

import Usuarios.Persona;
import articulo.Articulo;
import datos.Dato;
import java.util.Scanner;

/**
 *Clase que hereda de la clase abstracta Operacion y sirve 
 * para mostrar información de un artículo mediante su folio.
 * @author ribel
 */
public class DevolverArticuloFolio extends Operacion {

    /**
        * Método implementado de la clase padre que se encarga de mostrar 
        * información de un artículo mediante su folio.
        * @param operador Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * 
        */
    @Override
    public void realizarOperacion(Persona operador) {
        
        Dato accesoDatos = Dato.getInstance();
        Scanner sc = new Scanner(System.in);
        String folioArticulo;
        Articulo articuloBuscado;
        System.out.println("Ingresa el folio del artículo que "
                + "buscas:");
        folioArticulo = sc.nextLine();
        articuloBuscado = accesoDatos.buscarFolioArticulo(folioArticulo);
        if(articuloBuscado == null){
            System.out.println("No existe ningun articulo con el folio"
                    + " proporcionado");
        }else{
            System.out.println("Informacion del artículo: ");
            System.out.println(articuloBuscado.toString());
        }
    }
    
    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString(){
        return "Mostrar informacion de un articulo con su folio";
    }
    
}
