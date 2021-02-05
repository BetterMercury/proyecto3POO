
package Peticiones.peticionesRevista;

import Excepciones.ErrorDeDatoException;
import Revista.Revista;
import java.util.Scanner;

/**
 * Clase que hereda de la clase abstracta PeticionRevista;
 * sirve para representar la petición (operación) de pedirle
 * el atributo fecha de publicacion al usuario, implementando el método
 * realizarPeticion.
 * @author Equipo 9
 * 
 */
public class pedirFechaPublicacion extends PeticionesRevista{

     /**
        * Método implementado de la clase padre que se encarga de pedir
        * la fecha de publicación de un objeto de la clase Revista.
        * @param objetivo Un objeto de la clase Revista, al cual se le 
        * asignará una fecha de publicación.
        **/
    @Override
    public void realizarPeticion(Revista objetivo) {
        String fechaIngreso;
        Scanner sc = new Scanner(System.in);
       System.out.println(" ");
       System.out.println("Fecha de publicacion de revista");
        //objetivo.setFechaIngreso(nombre);
        
        while(true){
            try{
                 System.out.print("Fecha en formato dd/MM/yyyy: ");
                 fechaIngreso = sc.nextLine();
               if( !(fechaIngreso.length() == 10) ){
                    System.out.println(" ");
                    System.out.println("El formato de fecha es incorrecto. El formato debe ser dd/MM/AAAA");
                    throw new ErrorDeDatoException("Ingrese nuevamente con el formato requerido");
                } 
               
               if((fechaIngreso.charAt(2) == '/') && (fechaIngreso.charAt(5) == '/') && (fechaIngreso.length() == 10) ){  //solo si se tiene el formato
                    if(comprobar(fechaIngreso)){
                        objetivo.setFechaPublicacion(fechaIngreso);//this.fechaIngreso = LocalDate.parse(fechaIngreso, formateador);
                    }else{
                        System.out.println(" ");
                        System.out.println("El formato de fecha es incorrecto. El formato debe ser dd/MM/AAAA");
                        throw new ErrorDeDatoException("Ingrese nuevamente con el formato requerido");
                    }
                
                }else{
                    System.out.println(" ");
                    System.out.println("El formato de fecha es incorrecto. El formato debe ser dd/MM/AAAA");
                    throw new ErrorDeDatoException("Ingrese nuevamente con el formato requerido");
                }
            }catch(ErrorDeDatoException e){
                continue;
            }
            break;
        } 
        
        
        
    }
    
    /**
        * Método que nos ayuda a determinar si el formato de fecha de ingreso es correcto.
        * @param fecha La cadena en donde se almacenó la fecha ingresada, para
        * trabajar con ella y verificar si el formato es válido.
        * @return Retorna un booleano true si el formato es válido y un false
        * si no lo es.
        * 
        */
    static public boolean comprobar(String fecha){
            
        int i = 0;  //contador para saber si se cumplen los 8 digitos de la fecha
           
       
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
