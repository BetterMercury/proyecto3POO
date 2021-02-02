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
import InstanciadoresUsuarios.CrearSuscriptor;
import java.io.Console;
import java.util.InputMismatchException;
/**
 *
 * @author ribel
 */
public class init {
    public static void main (String [] args){
        Persona usuarioActual = new Administrador();
        Dato referenciaDato = Dato.getInstance();
        String valorSalida = "4";
        String op = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Bien venido al programa de administración\n");
        
        while(!"s".equals(op) && !"n".equals(op)){
            System.out.println("Deseas cargar datos de una ejecución anterior?[s/n]");
            op = sc.nextLine();
            switch(op){
                case "s":
                    referenciaDato.cargarDatos();
                    referenciaDato = Dato.getInstance();
                    break;
                case "n":
                    Dato.getInstance();
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        
        if(op.equals("n")){
            System.out.println("\n\nPrimero, debes crear una cuanta administrativa");
            new CrearCuentaAdministrativa().realizarOperacion(usuarioActual);
            System.out.println("\n\nAhora, debes crear el perfil del director");
            new CrearDirector().realizarOperacion(usuarioActual);
        }
        do{
            System.out.println("\tMenu principal\n"
                    + "1.- Ingresar\n"
                    + "2.- Suscribirse\n"
                    + "3.-Salir y guardar\n"
                    + valorSalida +".- salir\n");
            op = sc.nextLine();
            switch(op){
                case "1":
                    usuarioActual = ingresar();
                    if(usuarioActual == null){
                        break;
                    }
                    usuarioActual.mostrarMenu();
                    usuarioActual.elegirOperacion();
                    break;
                case "2":
                    suscribir(usuarioActual);
                    break;
                case "3":
                    referenciaDato.guardarDatos();
                    op = valorSalida;
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



    private static Persona ingresar() {
        Dato accesoDatos = Dato.getInstance();
        Scanner sc = new Scanner(System.in);
        String op;
        Persona usuario;
        Console consola = System.console();
       
        System.out.println("Sabes tu numero de identificacion unico?[s/n]");
        op = sc.nextLine();
        try{
            if("s".equalsIgnoreCase(op)){
                int numeroUnico;
                String contrasenia;
                System.out.print("Ingresa tu numero unico: ");
                numeroUnico = sc.nextInt();
                sc.nextLine();
                System.out.println("Ingresa tu contrasenia: ");
                if(consola != null){
                    contrasenia = String.valueOf(consola.readPassword());
                }else{
                    contrasenia = sc.nextLine();
                }

                usuario = accesoDatos.buscarNumeroEmpleado(numeroUnico);
                //Si no hay un empleado busca un suscriptor
                if(usuario == null){
                    usuario = accesoDatos.buscarNumeroSuscriptor(numeroUnico);
                //Si no existe devuelve null
                }
                if(usuario!= null && contrasenia.equals(usuario.getContrasena())){
                    return usuario;
                }else{
                    System.out.println("Numero o contrasenia incorrecta");
                    return null;
                }

            }else if ("n".equalsIgnoreCase(op)){
                String correo;
                String contrasenia;
                System.out.print("Ingresa tu correo electronico: ");
                correo = sc.nextLine();
                System.out.println("Ingresa tu contrasenia: ");
                if(consola != null){
                    contrasenia = String.valueOf(consola.readPassword());
                }else{
                    contrasenia = sc.nextLine();
                }

                usuario = accesoDatos.buscarEmpleado(correo);
                //Si no hay un empleado busca un suscriptor
                if(usuario == null){
                    usuario = accesoDatos.buscarSuscriptor(correo);
                //Si no existe devuelve null
                }
                if(usuario != null && contrasenia.equals(usuario.getContrasena())){
                    return usuario;
                }else{
                    System.out.println("Nombre o contrasenia incorrecta");
                    return null;
                }

            }else{
                System.out.println("opcion no valida");
                return null;
            }
        }catch(InputMismatchException e){
            System.out.println("Formato incorrecto");
            return null;
        }
        
    }

    private static void suscribir(Persona usuarioActual) {
        new CrearSuscriptor().realizarOperacion(usuarioActual); 
    }
    
    
}
