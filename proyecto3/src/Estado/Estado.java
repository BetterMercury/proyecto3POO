/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

/**
 * Esta es una interfaz de estado, útil para definir
 * si alguna revista  o clase extra requiere de alguna constante
 * para que cambie su comportamiento. Por ejemplo,
 * tenemos estados para un objeto Revista, ya que puede
 * ser publicado o no publicado.
 * @author Dante
 */
public interface Estado {
    //Los siguientes estados son validos para Revista
    static String STATER1 = "Publicado";
    static String STATER2 = "No Publicado";
    
    //Los siguientes estados son validos para Articulo
    static String STATER3 = "Aceptado";
    static String STATER4 = "Pendiente";
    static String STATER5 = "Rechazado";
    static String STATER6 = "Revisado";
}
