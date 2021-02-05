
package operaciones;

import InstanciadoresUsuarios.*;
import Usuarios.Persona;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que hereda de la clase abstracta Operacion;
 * sirve para representar la operación de crear
 * un usuario por parte del tipo de usuario ingresado,
 * implementando el método realizarPeticion.
 * @author Equipo 9
 * 
 */
public class crearUsuario extends Operacion{

    ArrayList<Instanciador> tiposDeUsuario = new ArrayList<>();
    
    /**
     * Cosntructor de la clase que se encarga de inicializar y 
     * agregar objetos a los arreglos dinámicos de tipos de usuario, para 
     * poder crear los diferentes tipos de usuario.
     */
    public crearUsuario(){
        tiposDeUsuario.add(new CrearAutor());
        tiposDeUsuario.add(new CrearCuentaAdministrativa());
        tiposDeUsuario.add(new CrearDirector());
        tiposDeUsuario.add(new CrearEditor());
        tiposDeUsuario.add(new CrearRevisor());
        tiposDeUsuario.add(new CrearSuscriptor());
        
    }
    
    /**
        * Método implementado de la clase padre que se encarga de mostrar 
        * los tipos de usuario disponibles para crear, así como de dar
        * la opción de crear uno.
        * @param operador Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * 
        */
    @Override
    public void realizarOperacion(Persona operador) {
        mostrarMenu();
        elegirOperacion(operador);
    }
    
    /**
     * Método que no recibe parámetros, se encarga de iterar
     * el arreglo de creaciones disponibles y mostrar en 
     * pantalla dichos objetos, los cuales representan operaciones
     * diferentes gracias al polimorfismo (por lo que este método
     * imprime un menú en pantalla de las creaciones disponibles).
     **/
    private void mostrarMenu(){
        int i = 1;
        for(Instanciador op : tiposDeUsuario){
            System.out.print(i+".-");
            System.out.println(op.toString());
            i++;
        }
        System.out.println("");
    }
    
    /**
     * Método que se encarga de pedirle al usuario que ingrese un número
     * para poder escoger una opción del menú presentado en pantalla.
     **/
    private void elegirOperacion(Persona operador){
        int op;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Ingresa tu eleccion: ");
            try{
                op = sc.nextInt();
            }catch(IllegalArgumentException | InputMismatchException e){
                System.out.println(" ");
                System.out.println("Ingrese un numero, intentelo de nuevo");
                continue;
            }
            break;
        }
        if(op<1 || op > this.tiposDeUsuario.size()){
            System.out.println("Opcion no valida");
        }else{
            tiposDeUsuario.get(op-1).realizarOperacion(operador);
        }
    }
    
    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString(){
        return "Crear algun tipo de usuario";
    }
    
}
