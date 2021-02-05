/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import Usuarios.Persona;
import Usuarios.suscriptor.Suscriptor;
import datos.Dato;

/**
 *  Clase que realiza el proceso de desuscripción
 * @author ribel
 */
public class Desuscribir extends Operacion {

    @Override
    public void realizarOperacion(Persona operador) {
        Dato accesoDatos = Dato.getInstance();
        if(accesoDatos.eliminarSuscriptor((Suscriptor)operador)){
            System.out.println("Ya no eres un suscriptor, la proxima vez"
                    + " que salgas de tu cuenta no podrás volver a ingresar"
                    + " gracias por usar el servicio");
        }else{
            System.out.println("Ocurrio un error en el proceso de eliminacion"
                    + " de tu cuenta");
        }
    }
    public String toString(){
        return "Eliminar cuenta";
    }
    
}
