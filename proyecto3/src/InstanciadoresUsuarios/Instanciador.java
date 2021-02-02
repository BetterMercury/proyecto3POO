/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstanciadoresUsuarios;

import Usuarios.Persona;
import java.io.Serializable;

/**
 *
 * @author ribel
 */
public abstract class Instanciador implements Serializable {
    public abstract void realizarOperacion(Persona creador);
}
