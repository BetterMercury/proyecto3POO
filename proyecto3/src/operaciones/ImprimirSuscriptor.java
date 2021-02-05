package operaciones;

import java.util.ArrayList;
import java.util.Scanner;

import Impresiones.*;
import Impresiones.imprimirRevistasP;
import Usuarios.Persona;
import datos.Dato;
import java.util.InputMismatchException;

/**
 *Clase que hereda de la clase abstracta Operacion y sirve 
 * para mostrar información de revistas y artículos
 * para que sean vistas por un suscriptor.
 * @author Equipo 9
 */
public class ImprimirSuscriptor extends Operacion{
    ArrayList<Imprimir>  ImpresionesDisponibles;

    /**
     * Cosntructor de la clase que se encarga de inicializar y 
     * agregar objetos a los arreglos dinámicos de operaciones, para 
     * poder imprimir los diferentes tipos de datos revistas y artículos.
     */
    public ImprimirSuscriptor(){
        this.ImpresionesDisponibles = new ArrayList<>();
        this.ImpresionesDisponibles.add(new imprimirArticulos());
        this.ImpresionesDisponibles.add(new imprimirRevistasP());
    }
    
    /**
        * Método implementado de la clase padre que se encarga de mostrar
        * información de revistas y artículos
        * para que sean vistas por un suscriptor.
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
     * el arreglo de impresiones disponibles y mostrar en 
     * pantalla dichos objetos, los cuales representan operaciones
     * diferentes gracias al polimorfismo (por lo que este método
     * imprime un menú en pantalla de las impresiones disponibles).
     **/
    private void mostrarMenu() {
        System.out.println("Opciones de impresion");
        int i=1;
        for(Imprimir impresor : ImpresionesDisponibles){
            System.out.print(i+".-");
            System.out.println(impresor.toString());
            System.out.println(" ");
            i++;
        }
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
        if(op<1 || op > this.ImpresionesDisponibles.size()){
            System.out.println("Opcion no valida");
        }else{
            ImpresionesDisponibles.get(op-1).realizarImpresion(Dato.getInstance());
        }
    }
    
    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString(){
        return "Imprimir listas diversas";
    }
}