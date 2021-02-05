package operaciones;

import java.util.ArrayList;
import java.util.Scanner;

import Impresiones.*;
import Impresiones.imprimirRevistasP;
import Usuarios.Persona;
import datos.Dato;

public class ImprimirColecciones extends Operacion {
    ArrayList<Imprimir>  ImpresionesDisponibles;

    public ImprimirColecciones(){
        this.ImpresionesDisponibles = new ArrayList<>();
        this.ImpresionesDisponibles.add(new imprimirRevistasP());
        this.ImpresionesDisponibles.add(new imprimirRevistasNoP());
        this.ImpresionesDisponibles.add(new imprimirEmpleadosCompleto());
        this.ImpresionesDisponibles.add(new imprimirArticulos());
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
    
}
