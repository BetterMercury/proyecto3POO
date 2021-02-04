
package Usuarios.empleados;
import InstanciadoresUsuarios.CrearCuentaAdministrativa;
import InstanciadoresUsuarios.CrearDirector;
import operaciones.ConfirmarPublicacionArticulo;
import operaciones.CrearArticulo;
import operaciones.CrearRevista;
import operaciones.CrearUsuario;
import operaciones.DevolverArticuloFolio;
import operaciones.DevolverArticuloNombre;
import operaciones.DevolverEmpleadoPorNumero;
import operaciones.DevolverRevistaPorNumero;
import operaciones.DevolverSuscriptorPorNumero;
import operaciones.ImprimirColecciones;
import operaciones.PublicarRevista;
import operaciones.RevisarArticulo;

/**
 *
 * @author ribel
 */
public class Administrador extends Empleado {
    public Administrador(){
        super();
        this.operacionesDisponible.add(new CrearUsuario());
        this.operacionesDisponible.add(new ConfirmarPublicacionArticulo());
        this.operacionesDisponible.add(new CrearArticulo());
        this.operacionesDisponible.add(new CrearRevista());
        this.operacionesDisponible.add(new ImprimirColecciones());
        this.operacionesDisponible.add(new PublicarRevista());
        this.operacionesDisponible.add(new RevisarArticulo());


    }

    @Override
    public String toString() {
        return super.toString() + "\nDATOS DEL ADMINISTRADOR";
    }
    
    
}
