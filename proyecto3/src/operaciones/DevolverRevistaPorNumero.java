
package operaciones;

import java.util.InputMismatchException;
import java.util.Scanner;

import Revista.Revista;
import Usuarios.Persona;
import datos.Dato;
import articulo.*;

/**
 *Clase que hereda de la clase abstracta Operacion y sirve 
 * para mostrar información de una revista mediante su número.
 * @author ribel
 */
public class DevolverRevistaPorNumero extends Operacion {

    /**
        * Método implementado de la clase padre que se encarga de mostrar 
        * información de una revista mediante su número.
        * @param operador Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * 
        */
    @Override
    public void realizarOperacion(Persona operador) {
        
        Dato accesoDato = Dato.getInstance();
        Scanner sc = new Scanner(System.in);
        int nuemeroRevista;
        Revista revista;
        System.out.println("Ingresa el numero de la revista");
        try{
            nuemeroRevista = sc.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Solo se admiten numeros enteros");
            return ;
        }
        revista = accesoDato.buscarFolioNumeroRevista(nuemeroRevista);
        if(revista == null){
            System.out.println("No hay revista no ese numero");
        }else{
            System.out.println("La información de la revista es la siguiente:");
            imprimirRevista(revista);

        }
        

    }

    /**
     * Método auxiliar para poder imprimir información de una revista.
     * @param revista Objeto de la clase revista por medio del cual
     * se imprimirá la información requerida.
     */
    private void imprimirRevista(Revista revista) {
        System.out.println("Numero : " + revista.getNumRevista()+ "; Titulo : " + revista.getTitulo());
        System.out.println("Estado: " + revista.getEstado());
        System.out.println("Los artículos que se pueden encontrar son: ");
        for(Articulo articulo: revista.getArticulos()){
            System.out.println("Titulo: "+articulo.getTitulo()+" Folio: "+articulo.getFolio());
        }
    }
    
    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString() {
        return "Mostrar información de una revista por su numero";
    }

}
