
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
