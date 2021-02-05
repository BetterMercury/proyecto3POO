package operaciones;

import articulo.Articulo;
import Impresiones.*;
public class ImprimirColeccionesEmpleado extends ImprimirColecciones{
    public ImprimirColeccionesEmpleado(){
        super();
        this.ImpresionesDisponibles.add(new imprimirArticuloCompleto());
        this.ImpresionesDisponibles.add(new imprimirAdministrador());
        this.ImpresionesDisponibles.add(new imprimirAutores());
        this.ImpresionesDisponibles.add(new imprimirDirector());
        this.ImpresionesDisponibles.add(new imprimirEditores());
        this.ImpresionesDisponibles.add(new imprimirEmpleadosCompleto());
        this.ImpresionesDisponibles.add(new imprimirRevistas());
        this.ImpresionesDisponibles.add(new imprimirRevistasNoP());
    }
}
