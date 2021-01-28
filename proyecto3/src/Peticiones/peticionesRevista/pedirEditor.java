/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesRevista;

import Revista.Revista;
import Usuarios.empleados.Editor;

/**
 *  Clase que permite asignare un editor a una revista,
 *  si la revista esta en STATER1, es decir "Publicada",
 *  se puede asignar, de lo contrario no.
 * @author Dante
 */
public class pedirEditor extends PeticionesRevista{

    void realizarPeticion(Revista objetivo, Editor ed) {
        
        if(objetivo.getEstado().equals(Revista.STATER1)){
            objetivo.setEditor(ed);
        } else {
            System.out.println("La revista no ha sido publicada,"
                    + "\nno se le puede asignar un Editor");
        }
    }
    
}
