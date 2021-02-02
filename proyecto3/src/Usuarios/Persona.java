
package Usuarios;
import Peticiones.peticionesUsuarios.PedirApellidoMaterno;
import Peticiones.peticionesUsuarios.PeticionPersona;
import Peticiones.peticionesUsuarios.PedirApellidoPaterno;
import Peticiones.peticionesUsuarios.PedirNombre;
import operaciones.*;
import Peticiones.peticionesUsuarios.PedirCorreo;
import java.util.ArrayList;
import java.util.Scanner;
import Excepciones.ErrorDeDatoException;
import Peticiones.peticionesUsuarios.PedirContrasenia;
import java.io.Serializable;

public abstract class Persona implements Serializable {    
    protected ArrayList<Operacion> operacionesDisponible;
    protected ArrayList<PeticionPersona> peticonesNecesarias;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String email;
    protected String cadenaTodoJunto;
    String contrasena;

    public Persona(){
        operacionesDisponible = new ArrayList<>();
        peticonesNecesarias = new ArrayList<>();
        operacionesDisponible.add(new regresarMenuAnterior());
        peticonesNecesarias.add(new PedirNombre());
        peticonesNecesarias.add(new PedirApellidoPaterno());
        peticonesNecesarias.add(new PedirApellidoMaterno());
        peticonesNecesarias.add(new PedirCorreo());
        peticonesNecesarias.add(new PedirContrasenia());
    }

    public void mostrarMenu(){
        int i = 1;
        for(Operacion miOperacion:operacionesDisponible){
            System.out.println(i+".- "+miOperacion.toString());
            i++;
        }
    }

    public void elegirOperacion(){
        Scanner sc = new Scanner(System.in);
        int op;
        System.out.print("Ingresa tu eleccion: ");
        op = sc.nextInt();
        
            this.operacionesDisponible.get(op-1).realizarOperacion(this);
    }

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
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCadenaTodoJunto() {
        return cadenaTodoJunto;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setCadenaTodoJunto(String cadenaTodoJunto) {
        this.cadenaTodoJunto = cadenaTodoJunto;
    }

    @Override
    public String toString() {
        return "Nombre : " + nombre + 
                "\nApellido paterno : " + apellidoPaterno + 
                "\nApellido materno=" + apellidoMaterno + 
                "\nemail :" + email + 
                "\ncontrasena : " + contrasena + "\n";
        //NOTA: ¿LA CONTRASENIA DEBE SER IMPRESA? 
        //SE TIENE QUE ANALIZAR QUIEN ES EL OBJETO Persona RESPONSABLE
        //EN NUESTRO PROYECTO PARA REALIZAR LAS IMPRESIONES
        //SI LAS REALIZA Administrador, NO EXISTE PROBLEMA SI SE IMPRIME
        //LA CONTRASEÑA, EN CASO CONTRARIO SE PODRIA SOBREESCRIBIR
        //ESTE METODO CON UNA VERSION QUE NO MUESTRE LA CONTRASEÑA,
        //REALIZAR ESTO ULTIMO IMPLICA UNA SOBREESCRITURA EN TODAS LAS
        //DEMAS CLASES HIJAS
                
    }
    
    
    
}