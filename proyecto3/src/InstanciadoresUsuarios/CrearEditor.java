/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstanciadoresUsuarios;

import Usuarios.Persona;
import Usuarios.empleados.Administrador;
import Usuarios.empleados.Director;
import Usuarios.empleados.Editor;
import datos.Dato;
import operaciones.Operacion;

/**
 *
 * @author ribel
 */
public class CrearEditor implements Instanciador{
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
}