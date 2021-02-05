
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import Usuarios.empleados.Empleado;
import Usuarios.suscriptor.Suscriptor;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Clase que hereda de la clase abstracta PeticionPersona;
 * sirve para representar la petición (operación) de pedirle
 * el atributo fecha de ingreso al usuario, implementando el método
 * realizarPeticion.
 * @author Equipo 9
 * 
 */
public class PedirFechaIngreso extends PeticionPersona {
    
        //formateador para la fecha ingresada
    static DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");	//se crea un objeto de la clase formateador para localDate
    
    /**
        * Método implementado de la clase padre que se encarga de pedir
        * la fecha de ingreso de un objeto de la clase Empleado o Suscriptor.
        * @param objetivo Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * @throws ErrorDeDatoException Esta excepción es usada para indicar que la 
        * fecha de ingreso ingresada no es correcta por su formato.
        */
    @Override
    public void realizarPeticion(Persona objetivo) throws ErrorDeDatoException {
            
        String fechaIngreso;
        Scanner sc = new Scanner(System.in);
        System.out.print("Fecha en formato dd/MM/yyyy: ");
        fechaIngreso = sc.nextLine();
        //objetivo.setFechaIngreso(nombre);
                
        //depende si llega un empleado o un suscriptor
        if(objetivo instanceof Empleado){    
            Empleado persona = (Empleado)objetivo;
            
            if((fechaIngreso.charAt(2) == '/') && (fechaIngreso.charAt(5) == '/') && comprobar(fechaIngreso) && fechaIngreso.length() == 10){  //solo si se tiene el formato
                persona.setFechaIngreso( fechaIngreso );//this.fechaIngreso = LocalDate.parse(fechaIngreso, formateador);
            }else{
                System.out.println(" ");
                System.out.println("El formato de fecha es incorrecto. El formato debe ser dd/MM/AAAA");
                throw new ErrorDeDatoException("Ingrese nuevamente con el formato requerido");
            } 
        }else{
            Suscriptor persona = (Suscriptor)objetivo;
            
            if((fechaIngreso.charAt(2) == '/') && (fechaIngreso.charAt(5) == '/') && comprobar(fechaIngreso) && fechaIngreso.length() == 10){  //solo si se tiene el formato
                persona.setFechaIngreso( fechaIngreso );//this.fechaIngreso = LocalDate.parse(fechaIngreso, formateador);
            }else{
                System.out.println(" ");
                System.out.println("El formato de fecha es incorrecto. El formato debe ser dd/MM/AAAA");
                throw new ErrorDeDatoException("Ingrese nuevamente con el formato requerido");
            } 
        }
        
        
        
        
    }
    
    /**
        * Método que nos ayuda a determinar si el formato de fecha de ingreso es correcto.
        * @param fecha La cadena en donde se almacenó la fecha ingresada, para
        * trabajar con ella y verificar si el formato es válido.
        * @return Retorna un booleano true si el formato es válido y un false
        * si no lo es.
        * @throws ErrorDeDatoException Esta excepción es usada para indicar que la 
        * fecha de ingreso ingresada no es correcta por su formato.
        */
    static public boolean comprobar(String fecha) throws ErrorDeDatoException{
            
        int i = 0;  //contador para saber si se cumplen los 8 digitos de la fecha
           
        if(!(fecha.length() == 10)){
            throw new ErrorDeDatoException("Ingrese la fecha en el formato requerido dd/MM/AAAA");
        }
        //verificacion de los dias
        int dia = Integer.parseInt(fecha.substring(0, 2));
        if(dia >= 1 && dia <= 31){
            i++;
        }
            
            
        //verificacion del mes, suma otro numero
        int mes = Integer.parseInt(fecha.substring(3, 5));
        if(mes >= 1 && mes <= 12){
            i++;
        }
            
        //verificacio del año, suma otro numero su se cumple
        int anio = Integer.parseInt(fecha.substring(6, 10));
        if(anio >= 1980 && anio <= 2021){
            i++;
        }
            
        //si se cumplen todos los digitos de la fecha (dia, mes y año), se retorna verdadero
        if(i == 3){
            return true;
        }else{
            return false;
        }
            
    }
}
