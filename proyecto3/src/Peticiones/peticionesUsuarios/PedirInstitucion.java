/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import Usuarios.empleados.Autor;
import Usuarios.empleados.Revisor;
import java.util.Scanner;

/**
 *
 * @author Equipo 9
 */
public class PedirInstitucion extends PeticionPersona{
    
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

    private boolean sinNumeros(String cadena){
        for(char c: cadena.toCharArray()){
            return !Character.isDigit(c);
        }
        return true;
    }
}
