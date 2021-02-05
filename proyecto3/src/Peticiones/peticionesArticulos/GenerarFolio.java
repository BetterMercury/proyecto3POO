
package Peticiones.peticionesArticulos;

import articulo.Articulo;
import datos.Dato;
import Excepciones.ErrorDeDatoException;
import static java.lang.Math.abs;
import static java.lang.System.currentTimeMillis;
import java.util.Random;

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
        Random r = new Random();
        boolean ok = false;
        
        int hash = objetivo.hashCode();
        String folio = "ART".concat(String.valueOf(hash));
        
        do{            
            do{
                if(folio.length()>=8){ //Nos aseguramos que sea de al menos 8 caracteres
                    r.setSeed(currentTimeMillis());
                    folio = folio.concat(String.valueOf(abs(r.nextInt())));
                    ok = true;
                }
            }while(ok == false);
                
            folio = folio.substring(0, 8); //Nos aseguramos que sea de 8 caracteres
            
            if(datosGenerales.existsFolioArticulo(folio) == false){
                break;                
            } else {
                String auxiliarStringHash;
                int auxiliarIntHash;
                
                //Obtenemos la parte aleatoria-numerica del folio
                auxiliarStringHash = folio.substring(5, 8);
                
                //Convertimos el String a int
                auxiliarIntHash = Integer.parseInt(auxiliarStringHash);
                auxiliarIntHash += 1; //Solucion lineal de colisiones
                
                //Reestablecemos un nuevo folio
                folio = "ART".concat(String.valueOf(auxiliarIntHash));
            }
        }while(true);
        
        System.out.println("Se ha generado el folio " + folio);        
        
        objetivo.setFolio(folio);
    }
}

