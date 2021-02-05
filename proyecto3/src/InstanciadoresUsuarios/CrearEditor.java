
package InstanciadoresUsuarios;

import Usuarios.Persona;
import Usuarios.empleados.Administrador;
import Usuarios.empleados.Director;
import Usuarios.empleados.Editor;
import datos.Dato;
import operaciones.Operacion;

/**
 *Clase para la instanciación de nuevos editores. El método realizarOperacion
 *llama a todos los métodos necesarios para agregar al editor a los mapas 
 * correspondientes de dato y para llenar los datos de la misma instancia.
 */
public class CrearEditor extends Instanciador{
    
    /**
        * Método implementado de la clase padre que se encarga de crear 
        * un editor nuevo e ingresarlo al programa.
        * @param operador Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * 
        */
        @Override
    public void realizarOperacion(Persona operador) {
        if(operador instanceof Director || operador instanceof Administrador){
            Editor nuevaInstancia = new Editor();
            nuevaInstancia.pedirDatos();
            Dato accesoDatos = Dato.getInstance();
            if (accesoDatos.aniadirEmpleado(nuevaInstancia)){
                System.out.println("Empleado creado con exito");
                System.out.println("El numero de identificacion unico es "
                    + nuevaInstancia.getNumeroEmpleado());
                System.out.println("Conservalo, se usara para iniciar sesion"
                        + " en el programa");
            }else{
                System.out.println("No se pudo crear sl empleado porque ya "
                        + "existe");
            }
        }else{
            System.out.println("Khe? como lograste entrar aqui?");
        }

    }

    /**
     * Método toString que representa, en forma de cadena, 
     * el nombre de la operación de esta clase.
     * @return El nombre de la operación en cadena.
     */
    @Override
    public String toString() {
    return "Registrar editor";
    }
}
