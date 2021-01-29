/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesArticulos;

import articulo.Articulo;
import datos.Dato;
import Impresiones.imprimirRevisores;
import java.util.Scanner;

/**
 *
 * @author Dante
 */
public class pedirCalificador extends PeticionesArticulo {

    @Override
    public void realizarPeticion(Articulo objetivo) {
        Scanner sc = new Scanner(System.in);        
        int nCuenta;
        Dato datosGenerales = Dato.getInstance();
        imprimirRevisores irev = new imprimirRevisores();
        
        irev.realizarImpresion(datosGenerales);        
        System.out.println("Seleccionar el Numero de Cuenta del Revisor");
        nCuenta = sc.nextInt();
        
        
        
        //Verificacion 0 a 10
        
    }

    /*FALTA DETERMINAR MECANISMO DE CALIFICADOR, ESTO ESTA RELACIONADO CON LA SIGUIENTE SITUACIÓN:
    1. En caso de que el articulo haya sido revisado deben guardarse los datos de al menos un empleado de 
    tipo "Revisor". El artículo puede ser revisado mas de una vez, por lo que deben aguardarse los datos de todos
    los empleados que realicen esta accion, asi como la calificacion que estos le dieron al
    articulo en una escala de 0 a 10.    
    */

}
