/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesUsuarios;

import Peticiones.ErrorDeDatoException;
import Usuarios.Persona;
import Usuarios.empleados.Empleado;
import Usuarios.suscriptor.Suscriptor;

/**
 *
 * @author ribel
 */
public class GenerarIdentificador implements PeticionPersona{

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
