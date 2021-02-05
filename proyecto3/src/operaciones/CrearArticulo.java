
package operaciones;

import Peticiones.peticionesUsuarios.PedirNumeroArticulosEscritosAutor;
import Usuarios.Persona;
import Usuarios.empleados.Autor;
import articulo.Articulo;
import datos.Dato;
import java.util.Scanner;

/**
 * Clase que hereda de la clase abstracta Operacion;
 * sirve para representar la operación de crear
 * un artículo por parte del Autor,
 * implementando el método realizarPeticion.
 * @author Equipo 9
 * 
 */
public class CrearArticulo extends Operacion{
    
    /**
        * Método implementado de la clase padre que se encarga de crear 
        * un artículo por parte de un objeto de la clase Autor.
        * @param objetivo Un objeto de la jerarquía de la clase abstracta Persona, con el cual
        * se hará uso del polimorfismo para trabajar con un tipo de dato necesario
        * de la jerarquía.
        * 
        */
    @Override
    public void realizarOperacion(Persona objetivo){
        System.out.println(" ");
        System.out.println("Usted autor, creara articulos");
        System.out.println(" ");
        
        //creacion de articulo
        Autor autor = (Autor)objetivo;
        Scanner sc = new Scanner(System.in);
        int op = 0;
        PedirNumeroArticulosEscritosAutor pedir = new PedirNumeroArticulosEscritosAutor();
        Dato datos = Dato.getInstance();
        Articulo articuloNuevo;
        
        do{        
        
            articuloNuevo = new Articulo();
                
            //asignamos el autor al articulo creado
            articuloNuevo.setAutor(autor);
            //se piden los datos del articulo
            articuloNuevo.pedirDatos();
        
            //almacenaremos el articulo en Dato
            
            pedir.realizarPeticion(autor, articuloNuevo);   //incrementa el numero de articulos creados, y al autor se le asigna su articulo
            System.out.println(" ");
            System.out.println("Se almacenara el articulo en memoria");
            
            if(datos.aniadirArticulo(articuloNuevo)){
                System.out.println(" ");
                System.out.println("Se guardo el articulo exitosamente");
            }else{
                System.out.println(" ");
                System.out.println("No se pudo almacenar el articulo");
            }
        
        
            System.out.println(" ");
            System.out.println("Si desea crear otro articulo, presione '1'");
            while(true){
                try{
                    op = sc.nextInt();
                    
                }catch(IllegalArgumentException ia){
                    System.out.println(" ");
                    System.out.println("Ingrese un numero correctamente, intente nuevamente");
                    continue;
                }
                break;
            }
        }while(op == 1);
        
    }
    public String toString(){
        return "Crear un articulo";
    }
}
