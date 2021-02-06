
package Revista;

import Estado.Estado;
import Excepciones.ErrorDeDatoException;
import Peticiones.peticionesRevista.PeticionesRevista;
import Peticiones.peticionesRevista.pedirTitulo;
import Usuarios.empleados.Editor;
import articulo.Articulo;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Clase que representa a una Revista, implementa a la 
 * interfaz Estado para determinar si está publicada o no; y 
 * Comparable para ordenar elementos de esta clase.
 * @author Dante
 */

public class Revista implements Estado, Comparable<Revista>, Serializable{
    /*
    ArrayList<Operacion> operacionesDisponible;
    ArrayList<PeticionRevista> peticionesNecesarias;    
    */
    
    static DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");	//se crea un objeto de la clase formateador para localDate
    public static int conteoRevistas;
    
    private String titulo;
    private LocalDate fechaPublicacion;
    private Editor editor; //Solo puede contener editor si es publicado
    private int numRevista;
    private String Estado;
    
    
    private LinkedList<Articulo> articulos = new LinkedList<>();    
    
    

    public ArrayList<PeticionesRevista> peticionesNecesarias;
    
    /**
     * Constructor de la clase Revista, el cual inicializará 
     * los arreglos de los atributos por medio de polimorfismo, pues se 
     * usan referencias a interfaces; se agregarán nuevos objetos para
     * poder realizar las peticiones de datos por este medio (constructor, 
     * arreglos de objetos y polimorfismo).
     **/

    public Revista(){
        peticionesNecesarias = new ArrayList<>();
        peticionesNecesarias.add(new pedirTitulo());
        conteoRevistas++;
        this.numRevista = conteoRevistas;
        this.Estado = STATER2;   //se auto asigna como NO PUBLICADO
    }    
    
    /**
     * Método que recorre el arreglo de objetos para realizar Peticiones diferentes,
     * esto a través del polimorfismo por usar referencias a una interfaz, en otras 
     * palabras, este método es un mecanismo polimorfico para que el usuario ingrese 
     * los datos del objeto Persona, ahorrando líneas de código.
     **/
    public void pedirDatos(){
        System.out.println("Por favor ingresa los datos que se te piden \n");
        for(PeticionesRevista peticion: peticionesNecesarias){
            while(true){
                try{
                    peticion.realizarPeticion(this);
                }catch(ErrorDeDatoException e){
                    System.out.println("Ocurrio un error: "+e.getMessage());
                    continue;
                }
                break;
            }
        }
    }    

    /**
     * Método que sobreescribe al método equals
     * para poder comparar objetos de clase Revista.
     * @param obj Objeto general hijo de la clase Object
     * @return Retorna un valor booleano si se cumplen
     * o no las condiciones.
     **/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Revista other = (Revista) obj;
        return true;
    }    
    
    /**
     * Método de acceso para obtener el estado de un objeto Revista.
     * @return Retorna el estado de esta Revista en cadena.
     **/
    public String getEstado() {
        return Estado;
    }

    /**
     * Método de acceso para obtener el estado 1 de un objeto Revista.
     * @return Retorna el estado 1 de esta Revista en cadena.
     **/
    public static String getSTATER1() {
        return STATER1;
    }

    /**
     * Método de acceso para obtener el estado 2 de un objeto Revista.
     * @return Retorna el estado 2 de esta Revista en cadena.
     **/
    public static String getSTATER2() {
        return STATER2;
    }
    
    /**
     * Método de acceso para establecer el estado de un objeto Revista.
     * @param Estado El estado en cadena que se le pondrá al objeto.
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * Método de acceso para obtener el conteo de revistas de la clase Revista.
     * @return Retorna el conteo de revistas de esta clase Revista en número.
     **/
    public static int getConteoRevistas() {
        return conteoRevistas;
    }

    /**
     * Método de acceso para establecer el conteo de revistas de la clase Revista.
     * @param conteoRevistas El conteo de revistas en entero que se le pondrá al atributo estático.
     */
    public static void setConteoRevistas(int conteoRevistas) {
        Revista.conteoRevistas = conteoRevistas;
    }

    /**
     * Método de acceso para obtener el título de un objeto Revista.
     * @return Retorna el título de esta Revista en cadena.
     **/
    public String getTitulo() {
        return titulo;
    }

    /**
     * Método de acceso para establecer el título de un objeto Revista.
     * @param titulo El título en cadena que se le pondrá al objeto.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Método de acceso para obtener la fecha de publicación de un objeto Revista.
     * @return Retorna la fecha de publicación de esta Revista en cadena.
     **/
    public String getFechaPublicacion() {
        return formateador.format(fechaPublicacion);    //regresa la cadena con fecha establecida por LocalDate
    }

    /**
     * Método de acceso para establecer la fecha de publicación de un objeto Revista.
     * @param fechaPublicacion La fecha de publicacion en cadena que se le pondrá al objeto.
     */
    public void setFechaPublicacion(String fechaPublicacion) {  //cadena en formato dd/MM/AAAA
 
        this.fechaPublicacion = LocalDate.parse(fechaPublicacion, formateador);
        
    }

    /**
     * Método de acceso para obtener la lista de artículos de un objeto Revista.
     * @return Retorna la lista de artículos asociados a esta Revista en Lista.
     **/
    public LinkedList<Articulo> getArticulos() {
        return articulos;
    }

    /**
     * Método de acceso para establecer una lista de artículos a un objeto Revista.
     * @param articulos Los artículos en Lista que se le pondrán al objeto.
     */
    public void setArticulos(LinkedList<Articulo> articulos) {
        this.articulos = articulos;
    }

    /**
     * Método de acceso para obtener el editor de un objeto Revista.
     * @return Retorna el editpr de esta Revista en Editor.
     **/
    public Editor getEditor() {
        return editor;
    }

    /**
     * Método de acceso para establecer el editor de un objeto Revista.
     * @param editor El editor en Editor que se le pondrá al objeto.
     */
    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    /**
     * Método de acceso para obtener el número de revista de un objeto Revista.
     * @return Retorna el número de esta Revista en entero.
     **/
    public int getNumRevista() {
        return numRevista;
    }

    /**
     * Método de acceso para establecer el número de un objeto Revista.
     * @param numRevista El número de revista en entero que se le pondrá al objeto.
     */
    public void setNumRevista(int numRevista) {
        this.numRevista = numRevista;
    }
    
    /**
     * Método de acceso para establecer un artículo a un objeto Revista.
     * @param art El artículo en Articulo que se le pondrá al objeto.
     */
    public void setArticulo(Articulo art){
        this.articulos.add(art);
    }
    
    /**
     * Metodo que nos sirve para definir si una revista
     * incluye al menos dos articulos de cada categoria.
     */
    public boolean comprobacionCAT(){
        /*
        NOTA:
        CAT1 = "Inteligencia Artificial";   
        CAT2 = "Analisis de Sistemas de Software";    
        CAT3 = "Bases de Datos";    
        CAT4 = "Hardware";    
        */
        
        int contCAT1 = 0;
        int contCAT2 = 0;
        int contCAT3 = 0;
        int contCAT4 = 0;        
        int need;
        
        //Recorremos la lista de Articulos
        for(Articulo art : this.articulos){
            if(art.getCategoria().equals(Articulo.CAT1)){
                contCAT1++;
            }
            if(art.getCategoria().equals(Articulo.CAT2)){
                contCAT2++;
            }
            if(art.getCategoria().equals(Articulo.CAT3)){
                contCAT3++;
            }
            if(art.getCategoria().equals(Articulo.CAT4)){
                contCAT4++;
            }            
        }
        
        boolean puedePublicarse = true;
        
        if(contCAT1 < 2){
            need = 2 - contCAT1;
            System.out.println("A esta revista le faltan " + need +
                    " articulos de " + Articulo.CAT1);
            puedePublicarse = false;
        }
        
        if(contCAT2 < 2){
            need = 2 - contCAT1;
            System.out.println("A esta revista le faltan " + need +
                    " articulos de " + Articulo.CAT2);
            puedePublicarse = false;
            
        }
        
        if(contCAT3 < 2){
            need = 2 - contCAT1;
            System.out.println("A esta revista le faltan " + need +
                    " articulos de " + Articulo.CAT3);
            puedePublicarse = false;
            
        }

        if(contCAT4 < 2){
            need = 2 - contCAT1;
            System.out.println("A esta revista le faltan " + need +
                    " articulos de " + Articulo.CAT4);
            puedePublicarse = false;
            
        }        
        
        return puedePublicarse;

    }

    /**
     * Método que sobreescribe el método compareTo para
     * poder comparar elementos de esta clase por medio
     * del atributo numero de revista.
     * @param o Objeto de la clase Revista para
     * comparar.
     * @return Se retorna un valor entero tras hacer la
     * comparación entre los números de revista.
     */
    @Override
    public int compareTo(Revista o) {
        return Integer.compare(numRevista, o.getNumRevista());
    }
    
}
