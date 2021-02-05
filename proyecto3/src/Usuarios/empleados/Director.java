/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios.empleados;
import InstanciadoresUsuarios.CrearCuentaAdministrativa;
import operaciones.crearUsuario;

/**
 *
 * @author ribel
 */
public class Director extends Empleado {
    public Director(){
        super();
        this.operacionesDisponible.add(new crearUsuario());
    
    }

    /**
     * Este sera el metodo para imprimir al director
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + "\nDATOS DEL DIRECTOR";
    }
    
    
}
