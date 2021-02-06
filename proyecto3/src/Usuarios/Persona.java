
package Usuarios;
import Peticiones.peticionesUsuarios.PedirApellidoMaterno;
import Peticiones.peticionesUsuarios.PeticionPersona;
import Peticiones.peticionesUsuarios.PedirApellidoPaterno;
import Peticiones.peticionesUsuarios.PedirNombre;
import operaciones.*;
import Peticiones.peticionesUsuarios.*;
import java.util.ArrayList;
import java.util.Scanner;
import Excepciones.ErrorDeDatoException;
import Peticiones.peticionesUsuarios.PedirContrasenia;
import java.io.Serializable;
import java.util.InputMismatchException;

/**
*
*Esta clase abstracta se encarga de agrupar el concepto abstracto 
*de los sujetos Persona dentro del programa con todos sus atributos y métodos; 
*Implementa la interfaz Serializable para poder almacenar datos en archivos y,
* también implementa la interfaz Comparable para poder ordenar objetos de esta clase.
* 
* @author Equipo 9
*
**/

public abstract class Persona implements Serializable, Comparable<Persona> {    
    protected ArrayList<Operacion> operacionesDisponible;
    protected ArrayList<PeticionPersona> peticonesNecesarias;
    protected ArrayList<String> novedades;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String email;
    protected String cadenaTodoJunto;
    String contrasena;
    protected boolean esSub = false;

    /**
     * Constructor de la clase abstracta Persona, el cual inicializará 
     * los arreglos de los atributos por medio de polimorfismo, pues se 
     * usan referencias a interfaces; se agregarán nuevos objetos para
     * poder realizar las peticiones de datos por este medio (constructor, 
     * arreglos de objetos y polimorfismo).
     **/
    public Persona(){
        operacionesDisponible = new ArrayList<>();
        peticonesNecesarias = new ArrayList<>();
        novedades = new ArrayList<>();
        operacionesDisponible.add(new regresarMenuAnterior());
        operacionesDisponible.add(new DevolverArticuloFolio());
        peticonesNecesarias.add(new PedirNombre());
        peticonesNecesarias.add(new PedirApellidoPaterno());
        peticonesNecesarias.add(new PedirApellidoMaterno());
        peticonesNecesarias.add(new PedirCorreo());
        peticonesNecesarias.add(new PedirContrasenia());
    }

    /**
     * Método que no recibe parámetros, se encarga de iterar
     * el arreglo de operaciones disponibles y mostrar en 
     * pantalla dichos objetos, los cuales representan operaciones
     * diferentes gracias al polimorfismo (por lo que este método
     * imprime un menú en pantalla de las operaciones disponibles).
     **/
    public void mostrarMenu(){
        int i = 1;
        for(Operacion miOperacion:operacionesDisponible){
            System.out.println(i+".- "+miOperacion.toString());
            i++;
        }
    }
    
    /**
     * Método que se encarga de pedirle al usuario que ingrese un número
     * para poder escoger una opción del menú presentado en pantalla.
     **/
    public void elegirOperacion(){
        Scanner sc = new Scanner(System.in);
        int op;
        
        while(true){
            System.out.print("Ingresa tu eleccion: ");
            try{
                op = sc.nextInt();
            }catch(IllegalArgumentException | InputMismatchException e){
                System.out.println(" ");
                System.out.println("Ingrese un numero, intentelo de nuevo");
                continue;
            }
            break;
        }
        if(op < 1 || op > this.operacionesDisponible.size()){
            System.out.println("Opcion no valida");
        }else{
            this.operacionesDisponible.get(op-1).realizarOperacion(this);
        }
            
    }

    /**
     * Método que recorre el arreglo de objetos para realizar Peticiones diferentes,
     * esto a través del polimorfismo por usar referencias a una interfaz, en otras 
     * palabras, este método es un mecanismo polimorfico para que el usuario ingrese 
     * los datos del objeto Persona, ahorrando líneas de código.
     **/
    public void pedirDatos(){
        System.out.println("Por favor ingresa los datos que se te piden \n");
        for(PeticionPersona peticion: peticonesNecesarias){
            while(true){
                try{
                    peticion.realizarPeticion(this);
                }catch(ErrorDeDatoException e){
                    System.out.println("Ocurrio un error: "+e.getMessage());
                    continue;
                }
                break;
            }
        }
    }
    
    public void imprimirNovedades(){
        System.out.println(" ");
        System.out.println("Estas son las novedades que recibe siendo suscriptor\n");
        System.out.println(" ");
        int i = 1;
        if(!novedades.isEmpty()){
            for(String novedad:novedades){
                System.out.println(i+".- "+novedad);
                i++;
            }
        }else{
            System.out.println(" ");
            System.out.println("Usted no tiene novedades...");
        }
        
    }
    
    /**
     * Método de acceso para obtener el nombre de un objeto Persona.
     * @return Retorna el nombre de esta Persona en cadena.
     **/
    public String getNombre() {
        return nombre;
    }

    /**
     * Método de acceso para establecer el nombre de un objeto Persona.
     * @param nombre El nombre en cadena que se le pondrá al objeto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método de acceso para obtener el apellido paterno de un objeto Persona.
     * @return Retorna el apellido paterno de esta Persona en cadena.
     **/
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Método de acceso para establecer el apellido paterno de un objeto Persona.
     * @param apellidoPaterno El apellido paterno en cadena que se le pondrá al objeto.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Método de acceso para obtener el apellido materno de un objeto Persona.
     * @return Retorna el apellido materno de esta Persona en cadena
     **/
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Método de acceso para establecer el apellido materno de un objeto Persona.
     * @param apellidoMaterno El apellido materno en cadena que se le pondrá al objeto.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Método de acceso para obtener el correo electrónico de un objeto Persona.
     * @return Retorna el correo electrónico de esta Persona en cadena
     **/
    public String getEmail() {
        return email;
    }

    /**
     * Método de acceso para establecer el correo electrónico de un objeto Persona.
     * @param email El correo electrónico en cadena que se le pondrá al objeto.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método de acceso para obtener una cadena con algunos atributos concatenados de un objeto Persona.
     * @return Retorna una concatenación de atributos de esta Persona en cadena
     **/
    public String getCadenaTodoJunto() {
        return cadenaTodoJunto;
    }

    /**
     * Método de acceso para obtener la contraseña de un objeto Persona.
     * @return Retorna la contraseña de esta Persona en cadena
     **/
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Método de acceso para establecer la contraseña de un objeto Persona.
     * @param contrasena La contraseña en cadena que se le pondrá al objeto.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Método de acceso para establecer una concatenación con los atributos de un objeto Persona.
     * @param cadenaTodoJunto La concatenación en cadena con base a los atributos que se le pondrá al objeto.
     */
    public void setCadenaTodoJunto(String cadenaTodoJunto) {
        this.cadenaTodoJunto = cadenaTodoJunto;
    }
    
     /**
     * Método de acceso para saber si la Persona es Suscriptor.
     * @return Retorna un valor booleano de esta Persona.
     **/
    public boolean getEsSub() {
        return esSub;
    }
    
    /**
     * Método de acceso para establecer una novedad en cadena de un objeto Persona (suscriptor).
     * @param novedad La novedad en cadena que se le pondrá al objeto.
     */
    public void setNovedades(String novedad){
        
        this.novedades.add(novedad);
    }

    /**
     * Método toString sobreescrito, el cual representa en forma 
     * de cadena una descripción general de los atributos del 
     * objeto.
     * @return Retorna una cadena que muestra una descripción
     * general de las características del objeto.
     */
    @Override
    public String toString() {
        return "Nombre : " + nombre + 
                "\nApellido paterno : " + apellidoPaterno + 
                "\nApellido materno=" + apellidoMaterno + 
                "\nemail :" + email + "\n" ;
                //"contrasena : " + contrasena + "\n";  //temporalmente bloqueado
        //NOTA: ¿LA CONTRASENIA DEBE SER IMPRESA? 
        //SE TIENE QUE ANALIZAR QUIEN ES EL OBJETO Persona RESPONSABLE
        //EN NUESTRO PROYECTO PARA REALIZAR LAS IMPRESIONES
        //SI LAS REALIZA Administrador, NO EXISTE PROBLEMA SI SE IMPRIME
        //LA CONTRASEÑA, EN CASO CONTRARIO SE PODRIA SOBREESCRIBIR
        //ESTE METODO CON UNA VERSION QUE NO MUESTRE LA CONTRASEÑA,
        //REALIZAR ESTO ULTIMO IMPLICA UNA SOBREESCRITURA EN TODAS LAS
        //DEMAS CLASES HIJAS
                
    }
    
        @Override
    public int compareTo(Persona arg0) {
        return this.getCadenaTodoJunto().compareTo(arg0.getCadenaTodoJunto()) ; //To change body of generated methods, choose Tools | Templates.
    }
        
}