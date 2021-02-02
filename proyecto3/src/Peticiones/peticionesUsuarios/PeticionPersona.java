package Peticiones.peticionesUsuarios;

import Excepciones.ErrorDeDatoException;
import Usuarios.Persona;
import java.io.Serializable;

public abstract class PeticionPersona implements Serializable {
    public abstract void realizarPeticion(Persona objetivo) throws ErrorDeDatoException;
}
