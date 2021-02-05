package operaciones;

import java.util.InputMismatchException;
import java.util.Scanner;

import Revista.Revista;
import Usuarios.Persona;
import datos.Dato;
import articulo.*;
public class DevolverRevistaPorNumero extends Operacion {

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

    private void imprimirRevista(Revista revista) {
        System.out.println("Numero : " + revista.getNumRevista()+ "; Titulo : " + revista.getTitulo());
        System.out.println("Estado: " + revista.getEstado());
        System.out.println("Los artículos que se pueden encontrar son: ");
        for(Articulo articulo: revista.getArticulos()){
            System.out.println("Titulo: "+articulo.getTitulo()+" Folio: "+articulo.getFolio());
        }
    }
    @Override
    public String toString() {
        return "Mostrar información de una revista por su numero";
    }

}
