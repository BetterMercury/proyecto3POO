/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstanciadoresUsuarios;

import Usuarios.Persona;
import java.io.Serializable;

/**
 * Clase abstracta que sirve para que todos los instanciadores se puedan almancenar
 * en una misma colección. Implementa serializabe para que pueda los objetos
 * que la implementan puedan ser guardados en un archivo.
 * @author ribel
 */
public abstract class Instanciador implements Serializable {
    public abstract void realizarOperacion(Persona creador);
    
}
