
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import Usuarios.empleados.Empleado;
import Usuarios.suscriptor.Suscriptor;

/**
 * Clase que hereda de la clase abstracta PeticionPersona;
 * sirve para representar la petición (operación) de generar
 * el atributo numeroEmpleado o numeroSuscriptor, implementando el método
 * realizarPeticion.
 * @author Equipo 9
 * 
 */
public class GenerarIdentificador extends PeticionPersona{

    /**
        * Método implementado de la clase padre que se encarga de generar
        * el número de identificación de un objeto de la clase Empleado o Suscriptor.
        * @param objetivo Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * @throws ErrorDeDatoException Esta excepción es usada para indicar que el 
        * formato del número de identificación no es correcto.
        */
    @Override
    public void realizarPeticion(Persona objetivo) throws ErrorDeDatoException {
        String cadenaTodoJunto = objetivo.getNombre() + objetivo.getApellidoPaterno() + objetivo.getApellidoMaterno();
        objetivo.setCadenaTodoJunto(cadenaTodoJunto);
        int nuevoNumero = cadenaTodoJunto.hashCode();
        if(objetivo instanceof Empleado){    
            Empleado empleadoObjetivo = (Empleado)objetivo;
            empleadoObjetivo.setNumeroEmpleado(nuevoNumero);
        }else{
            Suscriptor suscriptorObjetivo = (Suscriptor)objetivo;
            suscriptorObjetivo.setNumeroSuscriptor(nuevoNumero);
        }
    }
    
}
