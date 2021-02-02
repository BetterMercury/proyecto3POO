package operaciones;

import Usuarios.Persona;
import java.io.Serializable;

public abstract class Operacion implements Serializable {
    public abstract void realizarOperacion(Persona operador);
}
