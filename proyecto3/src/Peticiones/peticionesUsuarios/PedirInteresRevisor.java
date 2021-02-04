
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import Usuarios.empleados.Revisor;
import java.util.Scanner;

/**
 * Clase que hereda de la clase abstracta PeticionPersona;
 * sirve para representar la petición (operación) de pedirle
 * el atributo área de interés al usuario, implementando el método
 * realizarPeticion.
 * @author Equipo 9
 * 
 */
public class PedirInteresRevisor extends PeticionPersona{
    
    /**
        * Método implementado de la clase padre que se encarga de pedir
        * el área de interés de un objeto de la clase Revisor.
        * @param objetivo Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * @throws ErrorDeDatoException Esta excepción es usada para indicar que el 
        * área de interés ingresado no es correcto por su formato.
        */
    @Override
    public void realizarPeticion(Persona objetivo) throws ErrorDeDatoException {
        String interes;
        Scanner sc = new Scanner(System.in);
        System.out.print("Escriba el interes del revisor (menor a 15 caracteres \ny sin digitos): ");
        interes = sc.nextLine();

        if(interes.length()>15 || !sinNumeros(interes)){
            throw new ErrorDeDatoException("Formato de interes incorrecto");
        }
        Revisor rev = (Revisor)objetivo;
        
        
        int experiencia;
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Ingrese sus anios de experiencia (maximo 2 digitos y en numero entero): ");
        try{
            experiencia = sc1.nextInt();
        }catch(IllegalArgumentException e){
            throw new ErrorDeDatoException("Ingresa nuevamente la experiencia, pero ahora solo con numeros y menor de 3 digitos");
        }
           
        int cifras = 0;
        int numExp = experiencia;
   
        cifras= 0;    //esta variable es el contador de cifras
        while(numExp!=0){             //mientras a numCed le queden cifras
            numExp = numExp/10;         //le quitamos el último dígito
            cifras++;          //sumamos 1 al contador de cifras
        }
        
        if((numExp <= 2  &&  numExp >= 0) ){   //se forza a tener 2 cifras en el numero de cedula
            rev.setInteres(interes,experiencia);     //interes y experiencia
        }else{
            System.out.println(" ");
            throw new ErrorDeDatoException("Ingresa nuevamente la experiencia, pero ahora menor de 3 digitos y mayor o igual que 0");
        }
      
    }
    
    /**
        * Método que nos ayuda a determinar si en el área de interés se ingresó un 
        * caracter inválido como un número.
        * @param cadena La cadena en donde se almacenó el área de interés ingresado, para
        * trabajar con él y verificar si el formato es válido.
        * @return Retorna un booleano true si no se detectaron números y un false
        * si se detectaaron números.
        */
    private boolean sinNumeros(String cadena){
        for(char c: cadena.toCharArray()){
            return !Character.isDigit(c);
        }
        return true;
    }
    
}