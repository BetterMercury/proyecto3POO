package Peticiones.peticionesUsuarios;

import Peticiones.ErrorDeDatoException;
import Usuarios.Persona;

public interface PeticionPersona {
    void realizarPeticion(Persona objetivo) throws ErrorDeDatoException;
}
