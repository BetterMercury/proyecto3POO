/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import Usuarios.Persona;
import articulo.Articulo;
import datos.Dato;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ribel
 */
public class BuscarArticuloFolio extends Operacion {

    @Override
    public void realizarOperacion(Persona operador) {
        Dato accesoDatos = Dato.getInstance();
        Scanner sc = new Scanner(System.in);
        String folioArticulo;
        Articulo articuloBuscado;
        System.out.println("Ingresa el folio del artículo que "
                + "buscas:");
        folioArticulo = sc.nextLine();
        articuloBuscado = accesoDatos.buscarFolioArticulo(folioArticulo);
        if(articuloBuscado == null){
            System.out.println("No existe ningun articulo con el folio"
                    + " proporcionado");
        }else{
            System.out.println("Informacion del artículo: ");
            System.out.println(articuloBuscado.toString());
        }
    }
    
}
