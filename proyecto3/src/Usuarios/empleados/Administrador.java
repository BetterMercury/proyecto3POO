/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios.empleados;
import InstanciadoresUsuarios.CrearCuentaAdministrativa;
import InstanciadoresUsuarios.CrearDirector;
import operaciones.CrearUsuario;

/**
 *
 * @author ribel
 */
public class Administrador extends Empleado {
    public Administrador(){
        super();
        this.operacionesDisponible.add(new CrearUsuario());
    }

    @Override
    public String toString() {
        return super.toString() + "\nDATOS DEL ADMINISTRADOR";
    }
    
    
}
