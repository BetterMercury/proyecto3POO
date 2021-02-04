
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import Usuarios.empleados.Autor;
import Usuarios.empleados.Revisor;
import java.util.Scanner;

/**
 * Clase que hereda de la clase abstracta PeticionPersona;
 * sirve para representar la petición (operación) de pedirle
 * el atributo institución al usuario, implementando el método
 * realizarPeticion.
 * @author Equipo 9
 * 
 */
public class PedirInstitucion extends PeticionPersona{
    
    /**
        * Método implementado de la clase padre que se encarga de pedir
        * la institución de un objeto de la clase Revisor o Autor.
        * @param objetivo Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * @throws ErrorDeDatoException Esta excepción es usada para indicar que la 
        * institución ingresada no es correcta por su formato.
        */
    @Override
    public void realizarPeticion(Persona objetivo) throws ErrorDeDatoException {
        String institucion;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre de la institucion (menor a 15 caracteres \ny sin digitos): ");
        institucion = sc.nextLine();

        if(institucion.length()>15 || !sinNumeros(institucion)){
            throw new ErrorDeDatoException("Formato de nombre de institucion incorrecto");
        }
        
        if(objetivo instanceof Revisor){    
            Revisor rev = (Revisor)objetivo;
            rev.setInstitucion(institucion);
        }else if(objetivo instanceof Autor){
            Autor au = (Autor)objetivo;
            au.setInstitucion(institucion);
        }else{
            throw new ErrorDeDatoException("Solo el autor y el revisor pueden tener atributo institucion");
        }
        
    }

    /**
        * Método que nos ayuda a determinar si en la institución se ingresó un 
        * caracter inválido como un número.
        * @param cadena La cadena en donde se almacenó la institución ingresada, para
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
