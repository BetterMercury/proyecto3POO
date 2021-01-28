/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesRevista;

import Revista.Revista;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

/**
 * Esta clase solicita la fecha de publicación.
 * @author Dante
 */
public class pedirFechaPublicacion extends PeticionesRevista{

    @Override
    public void realizarPeticion(Revista objetivo) {
        Scanner sc = new Scanner(System.in);
        String fecha;
        SimpleDateFormat objFecha = null;
        Date date=null;
        
        while(true){
            System.out.println("Ingrese la fecha de publicacion en formato \"dd-mm-yyyy\"");
            fecha = sc.nextLine();
            try {
                date = objFecha.parse(fecha);
                break;
            } catch (ParseException ex) {
                System.out.println("La fecha ingresada no tiene formato correcto");
            }
        }
        
        objetivo.setFechaPublicacion(date);
    }
    
}
