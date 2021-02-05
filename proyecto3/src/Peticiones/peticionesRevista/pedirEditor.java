
package Peticiones.peticionesRevista;

import Revista.Revista;
import Usuarios.empleados.Editor;

/**
 *  Clase que permite asignarle un editor a una revista,
 *  si la revista esta en STATER1, es decir "Publicada",
 *  se puede asignar, de lo contrario no.
 * @author Equipo 9
 */
public class pedirEditor extends PeticionesRevista{

    /**
        * Método implementado de la clase padre que se encarga de asignar un editor
        * a una revista dada como parámetro.
        * @param objetivo Un objeto de la clase Revista, al cual se le 
        * asignará un editor.
        **/
    @Override
    public void realizarPeticion(Revista objetivo) {
        Editor ed = null;
        if(objetivo.getEstado().equals(Revista.STATER1)){
            objetivo.setEditor(ed);
        } else {
            System.out.println("La revista no ha sido publicada,"
                    + "\nno se le puede asignar un Editor");
        }
    }
    
}
