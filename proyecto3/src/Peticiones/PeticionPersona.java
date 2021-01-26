package Peticiones;

import Usuarios.Persona;

public interface PeticionPersona {
    void realizarPeticion(Persona objetivo) throws ErrorDeDatoException;
}
