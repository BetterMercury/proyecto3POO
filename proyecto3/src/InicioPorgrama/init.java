
package InicioPorgrama;
import Usuarios.Persona;
import java.util.Scanner;
import datos.Dato;
import InstanciadoresUsuarios.CrearCuentaAdministrativa;
import Usuarios.empleados.Administrador;
import InstanciadoresUsuarios.CrearDirector;
import InstanciadoresUsuarios.CrearSuscriptor;
import operaciones.BusquedaCadenaSinopsis;
import java.io.Console;
import java.util.InputMismatchException;
/**
 * Clase que inicia el programa y que contiene el main
 * contiene métodos para crear suscriptores nuevos y para ingresar
 * como usario registrado, también debe permitir hacer búsqudas sin ingresar
 */
public class init {
    /**
     * Método que carga los datos de ejecuciones anteriores si es necesario y 
     * crea un usuario administrador temporal para poder crear al primer 
     * administrador creado por el usuario y al director. Proporciona la
     * secuencia básica de ejeción, que es iniciar sesión, mostrar menu,
     * elegir una opción y cerrar sesión.
     * @param args Arguemtos de la linea de comandos, no utilizado.
     */
    public static void main (String [] args){
        Persona usuarioActual = new Administrador();
        Dato referenciaDato = Dato.getInstance();
        String valorSalida = "5";
        String op = "";
        String op2 = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al programa de administracion\n");
        
        while(!"s".equals(op) && !"n".equals(op)){
            System.out.println("Deseas cargar datos de una ejecución anterior?[s/n]");
            op = sc.nextLine();
            switch(op){
                case "s":
                    if(!referenciaDato.cargarDatos()){
                        System.out.println("No se pudo cargar el archivo, "
                                + "el programa continuara sin cargar datos");
                        op="n";
                    }
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
            System.out.println("\n\nPrimero, debes crear una cuenta administrativa");
            new CrearCuentaAdministrativa().realizarOperacion(usuarioActual);
            System.out.println("\n\nAhora, debes crear el perfil del director");
            new CrearDirector().realizarOperacion(usuarioActual);
        }
        do{
            System.out.println("\tMenu principal\n"
                    + "1.- Ingresar\n"
                    + "2.- Suscribirse\n"
                    + "3.- Busqueda entre los articulos"
                    + "4.-Salir y guardar\n"
                    + valorSalida +".- salir\n");
            op = sc.nextLine();
            switch(op){
                case "1":
                    boolean otraOperacion = false ;
                    usuarioActual = ingresar();
                    if(usuarioActual == null){
                        break;
                    }
                    do{
                        
                        if(usuarioActual.getEsSub()){
                            usuarioActual.imprimirNovedades();
                        }
                        usuarioActual.mostrarMenu();
                        usuarioActual.elegirOperacion();
                        do{
                            System.out.println("Quieres realizar otra operacion?");
                            op2 = sc.nextLine();
                            if(op2.equalsIgnoreCase("s")){
                                otraOperacion = true;
                            }else if (op2.equalsIgnoreCase("n")){
                                otraOperacion = false;
                            }else{
                                System.out.println("Opcion no valida");
                            }
                        }while(!op2.equalsIgnoreCase("s")  && !op2.equalsIgnoreCase("n"));
                        
                    }while(otraOperacion);
                    
                    break;
                case "2":
                    suscribir(usuarioActual);
                    break;
                case "3":
                    buscarEnArticulo(usuarioActual);
                    break;
                case "4":
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


    /**
     * Metodo para iniciar sesión en el programa. Permite iniciar sesión con el
     * número único de cada usuario o con el correo electrónico proporcionado
     * al crear el usuario. Si se ejecutael programa desde netbeans utiliza Scanner,
     * se se utiliza desde la terminal utiliza Console.
     * @return Usuaro si es que existe y colocó su nombre de usuario y contraseña correctamente. Null en cualquier otro caso     */
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
                System.out.println("0pcion no valida");
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

    private static void buscarEnArticulo(Persona operador) {
        new BusquedaCadenaSinopsis().realizarOperacion(operador);
    }
    
    
}
