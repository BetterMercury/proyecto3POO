package Peticiones.peticionesArticulos;

import java.io.File;
import java.util.Scanner;

import Excepciones.ErrorDeDatoException;
import articulo.Articulo;
import datos.Dato;

public class PedirPDF extends PeticionesArticulo {

    @Override
    public void realizarPeticion(Articulo objetivo) throws ErrorDeDatoException {
        Scanner sc = new Scanner(System.in);
        Dato accesoDatos = Dato.getInstance();
        String ruta;
        File archivo;
        System.out.println("Ingresa la ruta absoluta del articulo en formato pdf");
        ruta = sc.nextLine();
        archivo = accesoDatos.copiarPDF(ruta);
        if (archivo == null){ //si es null significa que no se pudo copiar
            throw new ErrorDeDatoException("Algo salio mal, intentalo de nuevo");
        }else{
            objetivo.setReferenciaArticulo(archivo);
        }

    }
    
}
