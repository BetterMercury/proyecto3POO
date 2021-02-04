/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstanciadoresUsuarios;

import Usuarios.Persona;
import Usuarios.suscriptor.Suscriptor;
import datos.Dato;
import operaciones.Operacion;

/**
 *
 * @author ribel
 */
public class CrearSuscriptor extends Instanciador{

    @Override
    public void realizarOperacion(Persona operador) {
        Suscriptor nuevaInstancia = new Suscriptor();
        nuevaInstancia.pedirDatos();
        Dato accesoDatos = Dato.getInstance();
        if (accesoDatos.aniadirSuscriptor(nuevaInstancia)){
            System.out.println("Suscriptor creado con exito");
            System.out.println("El numero de identificacion unico es "
                + nuevaInstancia.getNumeroSuscriptor());
            System.out.println("Conservalo, lo usaras para iniciar sesion"
                + " en el programa");
        }else{
            System.out.println("No se pudo crear sal suscriptor porque ya "
                    + "existe");
        }
    }
    @Override
    public String toString() {
        return "Registrar suscriptor";
        
    }
}
