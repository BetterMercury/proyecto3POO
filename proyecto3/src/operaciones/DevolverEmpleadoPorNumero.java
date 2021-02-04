package operaciones;

import Usuarios.Persona;
import Usuarios.empleados.Empleado;
import datos.Dato;

import java.util.InputMismatchException;
import java.util.Scanner;
public class DevolverEmpleadoPorNumero extends Operacion {

    @Override
    public void realizarOperacion(Persona operador) {
        if(!(operador instanceof Empleado)){
            System.out.println("Esta clase no deberia tener acceso a esta operacion");
        }else{
            int numeroUnico;
            Dato accesoDatos = Dato.getInstance();
            Scanner sc = new Scanner(System.in);
            Empleado empleado;
            System.out.println("Ingresa el numero unico");
            try{
            numeroUnico = sc.nextInt();  
            }catch (InputMismatchException e){
                System.out.println("Solo se admite un numero entero");
                return;
            }
            empleado = accesoDatos.buscarNumeroEmpleado(numeroUnico);
            if(empleado == null){
                System.out.println("No se encontro al empleado");
            }else{
                empleado.toString();
            }
            
        }

    }
    
}
