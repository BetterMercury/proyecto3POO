
package operaciones;

import Usuarios.Persona;
import articulo.Articulo;
import datos.Dato;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *Clase que hereda de la clase abstracta Operacion y sirve 
 * para mostrar información de un artículo mediante su título.
 * @author ribel
 */
public class DevolverArticuloNombre extends Operacion{

    /**
        * Método implementado de la clase padre que se encarga de mostrar 
        * información de un artículo mediante su título.
        * @param operador Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * 
        */
    @Override
    public void realizarOperacion(Persona operador) {
        
        Dato accesoDatos = Dato.getInstance();
        Scanner sc = new Scanner(System.in);
        String nombreArticulo;
        Articulo articuloBuscado = null;
        TreeSet<Articulo> articulosDisponibles;
        
        System.out.println("Ingresa el titulo del artículo que "
                + "buscas:");
        nombreArticulo = sc.nextLine();
        articulosDisponibles = accesoDatos.getSetArticulosAceptados();
        for(Articulo actual:articulosDisponibles){
            if(actual.getTitulo().equalsIgnoreCase(nombreArticulo)){
                articuloBuscado = actual;
            }
        }
        
        if(articuloBuscado == null){
            System.out.println("No existe ningun articulo con el titulo"
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
    public String toString() {
        return "Mostrar información de un articulo por su Titulo";
    }
    
}
