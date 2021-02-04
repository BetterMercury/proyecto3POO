/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import InstanciadoresUsuarios.*;
import Usuarios.Persona;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ribel
 */
public class CrearUsuario extends Operacion{

    ArrayList<Instanciador> tiposDeUsuario = new ArrayList<>();
    public CrearUsuario(){
        tiposDeUsuario.add(new CrearAutor());
        tiposDeUsuario.add(new CrearCuentaAdministrativa());
        tiposDeUsuario.add(new CrearDirector());
        tiposDeUsuario.add(new CrearEditor());
        tiposDeUsuario.add(new CrearRevisor());
        tiposDeUsuario.add(new CrearSuscriptor());
        
    }
    @Override
    public void realizarOperacion(Persona operador) {
        mostrarMenu();
        elegirOperacion(operador);
    }
    private void mostrarMenu(){
        int i = 1;
        for(Instanciador op : tiposDeUsuario){
            System.out.print(i+".-");
            System.out.println(op.toString());
            i++;
        }
        System.out.println("");
    }
    
    private void elegirOperacion(Persona operador){
        int op;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nTu eleccion: ");
        op = sc.nextInt();
        if(op<1 || op > this.tiposDeUsuario.size()){
            System.out.println("Opcion no valida");
        }else{
            tiposDeUsuario.get(op-1).realizarOperacion(operador);
        }
    }
    
    @Override
    public String toString(){
        return "Crear algun tipo de usuario";
    }
    
}
