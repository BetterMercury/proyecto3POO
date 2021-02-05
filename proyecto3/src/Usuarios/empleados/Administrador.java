
package Usuarios.empleados;
import InstanciadoresUsuarios.CrearCuentaAdministrativa;
import InstanciadoresUsuarios.CrearDirector;
import operaciones.ConfirmarPublicacionArticulo;
import operaciones.CrearArticulo;
import operaciones.CrearRevista;
import operaciones.crearUsuario;
import operaciones.DevolverArticuloFolio;
import operaciones.DevolverArticuloNombre;
import operaciones.DevolverEmpleadoPorNumero;
import operaciones.DevolverRevistaPorNumero;
import operaciones.DevolverSuscriptorPorNumero;

import operaciones.PublicarRevista;
import operaciones.RevisarArticulo;

/**
 *
 * @author ribel
 */
public class Administrador extends Empleado {
    public Administrador(){
        super();
        this.operacionesDisponible.add(new crearUsuario());
        this.operacionesDisponible.add(new PublicarRevista());
    }

    @Override
    public String toString() {
        return super.toString() + "\nDATOS DEL ADMINISTRADOR";
    }
    
    
}
