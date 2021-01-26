
package Usuarios;
import operaciones.*;
import Peticiones.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Persona {    
    ArrayList<Operacion> operacionesDisponible;
    ArrayList<PeticionPersona> peticonesNecesarias;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String email;

    public Persona(){
        operacionesDisponible = new ArrayList<>();
        peticonesNecesarias = new ArrayList<>();
        operacionesDisponible.add(new Operacion1());
        operacionesDisponible.add(new Operacion2());
        peticonesNecesarias.add(new PedirNombre());
        peticonesNecesarias.add(new PedirApellidoPaterno());
        peticonesNecesarias.add(new PedirApellidoMaterno());
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

    public static void main (String[] args){
        Persona unaPersona = new Persona();
        unaPersona.pedirDatos();
        unaPersona.mostrarMenu();
        unaPersona.elegirOperacion();
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
    
}