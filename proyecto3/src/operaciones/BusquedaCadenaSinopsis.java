
package operaciones;

import Usuarios.Persona;
import articulo.Articulo;
import datos.Dato;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Clase que define la operación de búsqueda de una subcadena en la sinopsis 
 * de los artículos.
 * @author Equipo 9
 */
public class BusquedaCadenaSinopsis extends Operacion{
/**
 * Método que realiza la operación de búsqueda de una subcadena en la sinopsis
 * de los artículos.
 * @param operador Usuario que mandó a llamar a la operación.
 */
    @Override
    public void realizarOperacion(Persona operador) {
        Scanner sc = new Scanner(System.in);
        String cadenaBuscada;
        Dato datosGenerales = Dato.getInstance();
        TreeSet<Articulo> setDeEmpleados = datosGenerales.getSetArticulosAceptados();
        System.out.println("Ingresa la cadena que quieres buscar entre los"
                + " articulos. Debe ser de almenos 4 caracteres");
        cadenaBuscada = sc.nextLine();
        if(cadenaBuscada.length()<4){
            System.out.println("No escribiste una cadena lo suficientemente"
                    + " larga");
        }else{
            for(Articulo iterador : setDeEmpleados){
                int indiceEncontrado;
                int tamanioCadenaBuscada = cadenaBuscada.length();
                cadenaBuscada.replaceAll("\\s",""); //Elimina todos los caracteres no visibles
                String cadenaDeBusqueda = iterador.getSnopsis().toLowerCase();
                cadenaBuscada = cadenaBuscada.toLowerCase();
                indiceEncontrado = cadenaDeBusqueda.indexOf(cadenaBuscada);
                if(indiceEncontrado != -1){
                    System.out.print("Coincidencia en el artículo con folio: "+iterador.getFolio());
                    System.out.println("\t"+iterador.getSnopsis().substring(indiceEncontrado,
                            indiceEncontrado+tamanioCadenaBuscada-1));
                    System.out.println("");
                }
            }
        }
        
    }
    
    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString(){
        return "Buscar una cadena entre los articulos";
    }
    
    
}
