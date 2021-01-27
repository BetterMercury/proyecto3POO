package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;

public interface PeticionPersona {
    void realizarPeticion(Persona objetivo) throws ErrorDeDatoException;
}
