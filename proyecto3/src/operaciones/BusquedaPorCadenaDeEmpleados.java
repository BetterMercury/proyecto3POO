
package operaciones;

import Usuarios.Persona;
import Usuarios.empleados.Empleado;
import datos.Dato;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *Clase que define la operación de búsqueda de una subcadena en la información
 * de los empleados e imprime información básica del empleado donde se encontró
 * la coincidencia.
 */
public class BusquedaPorCadenaDeEmpleados extends Operacion{
    
    /**
     * Método que realiza la operación de búsqueda de una subcadena en la información
     * de los empleados e imprime información básica del empleado donde se encontró
     * la coincidencia.
     * @param operador Usuario que mandó a llamar a esta operación.
     */
    @Override
    public void realizarOperacion(Persona operador) {
        Scanner sc = new Scanner(System.in);
        String cadenaBuscada;
        Dato datosGenerales = Dato.getInstance();
        TreeSet<Empleado> setDeEmpleados = datosGenerales.getSetDeEmpleados();
        System.out.println("Ingresa la cadena que quieres buscar entre los"
                + "empleados. Debe ser de almenos 4 caracteres");
        cadenaBuscada = sc.nextLine();
        if(cadenaBuscada.length()<4){
            System.out.println("No escribiste una cadena lo suficientemente"
                    + " larga");
        }else{
            for(Empleado iterador : setDeEmpleados){
                int indiceEncontrado;
                int tamanioCadenaBuscada = cadenaBuscada.length();
                cadenaBuscada.replaceAll("\\s",""); //Elimina todos los caracteres no visibles
                String cadenaDeBusqueda = iterador.getCadenaTodoJunto().toLowerCase();
                cadenaBuscada = cadenaBuscada.toLowerCase();
                indiceEncontrado = cadenaDeBusqueda.indexOf(cadenaBuscada);
                if(indiceEncontrado != -1){
                    System.out.print("Coincidencia en el empleado con numero: "+iterador.getNumeroEmpleado());
                    System.out.println("\t"+iterador.getCadenaTodoJunto().substring(indiceEncontrado,
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
        return "Buscar una cadena entre los empleados";
    }
    
}
