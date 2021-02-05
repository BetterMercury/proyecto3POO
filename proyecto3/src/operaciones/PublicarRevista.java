
package operaciones;

import Excepciones.ErrorDeDatoException;
import Impresiones.imprimirRevistasNoP;
import Peticiones.peticionesRevista.pedirFechaPublicacion;
import Usuarios.Persona;
import datos.Dato;
import java.util.Scanner;
import Revista.Revista;
import Usuarios.empleados.Administrador;
import Usuarios.empleados.Director;
import Usuarios.suscriptor.Suscriptor;
import java.util.InputMismatchException;
import java.util.TreeSet;
import java.util.Iterator;


/**
 *Clase que hereda de la clase abstracta Operacion;
 * sirve para representar la operación de publicar
 * una revista por parte del Director o Administrador,
 * implementando el método realizarPeticion.
 * @author Dante
 */
public class PublicarRevista extends Operacion{

    /**
        * Método implementado de la clase padre que se encarga de publicar 
        * una revista por parte de un objeto de la clase Director o Administrador.
        * @param operador Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * 
        */
    @Override
    public void realizarOperacion(Persona operador) {
        
        if(operador instanceof Director || operador instanceof Administrador){
            Scanner sc = new Scanner(System.in);
            int num;
            TreeSet<Suscriptor> mapaSuscriptores;

            System.out.println("");
            System.out.println("Usted director puede publicar una revista");
            System.out.println("");

            if(operador instanceof Administrador){
                System.out.println("Acceso concedido al Administrador");
                System.out.println("");
            }

            Dato datos = Dato.getInstance();  
            imprimirRevistasNoP irevNP = new imprimirRevistasNoP();
            pedirFechaPublicacion pedir = new pedirFechaPublicacion();

            System.out.println("Revistas No Publicadas");
            irevNP.realizarImpresion(datos);

            if(!datos.getSetRevistasNoPublicadas().isEmpty()){

                System.out.println(" ");
                System.out.print("Ingrese numero de revista: ");

                while(true){
                    try{
                        num = sc.nextInt();
                    }catch(IllegalArgumentException | InputMismatchException e){
                        System.out.println(" ");
                        System.out.println("Formato incorrecto, ingrese un numero");
                        continue;
                    }   
                    break;
                }


                try{
                    if(datos.existsFolioNumeroRevista(num)){
                        if(datos.buscarFolioNumeroRevista(num).comprobacionCAT() == true){

                            //Poner la revista en estado publicado
                            datos.buscarFolioNumeroRevista(num).setEstado(Revista.STATER1);
                            pedir.realizarPeticion(datos.buscarFolioNumeroRevista(num)); //con esto se pide la fecha de publicacion de la revista
                            
                            //una vez publicada la revista, se le notificará a los suscriptores
                            //me traigo a los suscriptores y les guardo un mensaje de nueva revista
                            mapaSuscriptores = datos.getSetDeSuscriptores();
                            Iterator<Suscriptor> iterator = mapaSuscriptores.iterator();
                            while (iterator.hasNext()){
                                iterator.next().setNovedades("Se ha publicado la revista de titulo: '"+ datos.buscarFolioNumeroRevista(num).getTitulo() + "'");
                            }

                    } else{
                            System.out.println("Esta revista no se puede publicar");
                        }


                } else {
                    throw new ErrorDeDatoException("Error: Numero de revista incorrecto");
                }
                }catch (ErrorDeDatoException e){
                    System.out.println(e.getMessage());
                }
            } else {
                
                System.out.println("... saliendo de operacion\n");
            }

        } else {
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
        return "Publicar una revista";
    }
    
}
