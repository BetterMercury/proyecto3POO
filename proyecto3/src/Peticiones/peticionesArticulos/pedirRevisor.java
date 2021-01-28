/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peticiones.peticionesArticulos;

import articulo.Articulo;

/**
 *  
 * @author Dante
 */
public class pedirRevisor extends PeticionesArticulo{

    @Override
    public void realizarPeticion(Articulo objetivo) {
    }
    /*FALTA DETERMINAR FORMA DE ASOCIAR REVISOR, ESTO ESTA RELACIONADO CON LA SIGUIENTE SITUACIÓN:
    1. En caso de que el articulo haya sido revisado deben guardarse los datos de al menos un empleado de 
    tipo "Revisor". El artículo puede ser revisado mas de una vez, por lo que deben aguardarse los datos de todos
    los empleados que realicen esta accion, asi como la calificacion que estos le dieron al
    articulo en una escala de 0 a 10
    */    
}
