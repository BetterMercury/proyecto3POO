package operaciones;

import java.util.InputMismatchException;
import java.util.Scanner;

import Usuarios.Persona;
import Usuarios.empleados.Empleado;
import Usuarios.suscriptor.Suscriptor;
import datos.Dato;


public class DevolverSuscriptorPorNumero extends Operacion {

    @Override
    public void realizarOperacion(Persona operador) {
        if(!(operador instanceof Empleado)){
            System.out.println("Esta clase no deberia tener acceso a esta operacion");
        }else{
            int numeroUnico;
            Dato accesoDatos = Dato.getInstance();
            Scanner sc = new Scanner(System.in);
            Suscriptor suscriptor;
            System.out.println("Ingresa el numero unico");
            try{
            numeroUnico = sc.nextInt();  
            }catch (InputMismatchException e){
                System.out.println("Solo se admite un numero entero");
                return;
            }
            suscriptor = accesoDatos.buscarNumeroSuscriptor(numeroUnico);
            if(suscriptor == null){
                System.out.println("No se encontro al suscriptor");
            }else{
                suscriptor.toString();
            }
            
        }

    }
    @Override
    public String toString() {
        return "Mostrar información de un suscriptor por su numero";
    }
}

