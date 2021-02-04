/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Peticiones.peticionesUsuarios.PeticionPersona;
import Usuarios.Persona;
import java.io.Console;
import java.util.Scanner;
/**
 *
 * @author ribel
 */
public class PedirContrasenia extends PeticionPersona{

    @Override
    public void realizarPeticion(Persona objetivo) throws ErrorDeDatoException {
        Console consola = System.console();
        String contrasenia;
        System.out.println("Nueva contrasenia: ");
        if(consola != null){
            contrasenia = String.valueOf(consola.readPassword());
        }else{
            Scanner sc = new Scanner(System.in);
            contrasenia = sc.nextLine();
        }
        if(contrasenia.length()<8){
            throw new ErrorDeDatoException("La contrasenia debe tener al menos"
                    + " 8 caracteres");
        }
        objetivo.setContrasena(contrasenia);
    }
    
}
