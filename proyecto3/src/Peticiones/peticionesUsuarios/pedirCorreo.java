/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesUsuarios;

import Peticiones.ErrorDeDatoException;
import Usuarios.Persona;
import java.util.Scanner;

/**
 *
 * @author ribel
 */
public class pedirCorreo {
        public void realizarPeticion(Persona objetivo) throws ErrorDeDatoException {
        String nombre;
        Scanner sc = new Scanner(System.in);
        System.out.print("Correo: ");
        nombre = sc.nextLine();
        objetivo.setEmail(nombre);
    }
}
