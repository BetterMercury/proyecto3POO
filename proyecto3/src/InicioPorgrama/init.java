/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InicioPorgrama;
import Usuarios.Persona;
import java.util.Scanner;
import datos.Dato;
import InstanciadoresUsuarios.CrearCuentaAdministrativa;
import Usuarios.empleados.Administrador;
import InstanciadoresUsuarios.CrearDirector;
/**
 *
 * @author ribel
 */
public class init {
    public static void main (String [] args){
        Persona usuarioActual = new Administrador();
        String valorSalida = "4";
        String op = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Bien venido al programa de administración\n");
        
        while(!"s".equals(op) && !"n".equals(op)){
            System.out.println("Deseas cargar datos de una ejecución anterior?[s/n]");
            op = sc.nextLine();
            switch(op){
                case "s":
                    cargarDatos();
                    break;
                case "n":
                    Dato.getInstance();
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        
        if(op.equals("n")){
            System.out.println("Primero, debes crear una cuanta administrativa");
            new CrearCuentaAdministrativa().realizarOperacion(usuarioActual);
            new CrearDirector().realizarOperacion(usuarioActual);
        }
        do{
            System.out.println("\tMenu principal\n"
                    + "1.- Ingresar\n"
                    + "2.- Crear cuenta\n"
                    + valorSalida +".- salir\n");
            op = sc.nextLine();
            switch(op){
                case "1":
                    usuarioActual = ingresar();
                    usuarioActual.mostrarMenu();
                    usuarioActual.elegirOperacion();
                    break;
                case "2":
                    crearUsuario();
                    break;
                default:
                    if(op.equals(valorSalida)){
                        break;
                    }else{
                        System.out.println("Opcion no valida\n");
                    }
            }

        }while(!valorSalida.equals(op));


            
    }

    private static void cargarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static Persona ingresar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void crearUsuario() {
        
    }
    

}
