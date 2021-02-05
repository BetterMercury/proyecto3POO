
package Peticiones.peticionesArticulos;

import articulo.Articulo;
import datos.Dato;
import Excepciones.ErrorDeDatoException;

/**
 *  Clase para la generación de una clave alfanumérica
 *  de 8 dígitos, con solución de colisiones lineal.
 * @author Dante
 */
public class GenerarFolio extends PeticionesArticulo{
    
    /**
        * Método implementado de la clase padre que se encarga de generar
        * una clave alfanumérica de un objeto de la clase Articulo.
        * @param objetivo Un objeto de la clase Articulo para poder generarle
        * un identificador.
        * @throws ErrorDeDatoException Esta excepción es usada para indicar que 
        * es posible que se genere una excepción personalizada.
        */
    @Override
    public void realizarPeticion(Articulo objetivo) throws ErrorDeDatoException{  
        Dato datosGenerales = Dato.getInstance();
        
        int hash = objetivo.hashCode();
        String folio = "ARTIC".concat(String.valueOf(hash));
        
        do{            
            folio = folio.substring(0, 7); //Nos aseguramos que sea de 8 caracteres
            
            if(datosGenerales.existsFolioArticulo(folio) == false){
                break;                
            } else {
                String auxiliarStringHash;
                int auxiliarIntHash;
                
                //Obtenemos la parte numerica del folio
                auxiliarStringHash = folio.substring(5, 7);
                
                //Convertimos el String a int
                auxiliarIntHash = Integer.parseInt(auxiliarStringHash);
                auxiliarIntHash += 1; //Solucion lineal de colisiones
                
                //Reestablecemos un nuevo folio
                folio = "ARTIC".concat(String.valueOf(auxiliarIntHash));
            }
        }while(true);
        
        System.out.println("Se ha generado el folio " + folio);        
        
        objetivo.setFolio(folio);
    }
}

