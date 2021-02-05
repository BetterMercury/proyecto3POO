package operaciones;

import java.util.ArrayList;
import java.util.Scanner;

import Impresiones.*;
import Impresiones.imprimirRevistasP;
import Usuarios.Persona;
import datos.Dato;

public class ImprimirEmpleado extends Operacion {
    ArrayList<Imprimir>  ImpresionesDisponibles;

    public ImprimirEmpleado(){
        this.ImpresionesDisponibles = new ArrayList<>();
        this.ImpresionesDisponibles.add(new ImprimirEmpleadosSencillo());
        this.ImpresionesDisponibles.add(new imprimirArticulos());
        this.ImpresionesDisponibles.add(new imprimirRevistas());
    }
    @Override
    public void realizarOperacion(Persona operador) {
       mostrarMenu();
        elegirOperacion(operador);
    }

    private void mostrarMenu() {
        System.out.println("Opciones de impresion");
        int i=1;
        for(Imprimir impresor : ImpresionesDisponibles){
            System.out.print(i+".-");
            System.out.println(impresor.toString());
            System.out.println(" ");
            i++;
        }
    }

    private void elegirOperacion(Persona operador){
        int op;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nTu eleccion: ");
        op = sc.nextInt();
        if(op<1 || op > this.ImpresionesDisponibles.size()){
            System.out.println("Opcion no valida");
        }else{
            ImpresionesDisponibles.get(op-1).realizarImpresion(Dato.getInstance());
        }
    }
    @Override
    public String toString() {
        return "Imprimir listas diversas";
    }
    
}