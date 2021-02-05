package articulo;

import Estado.Estado;
import Excepciones.ErrorDeDatoException;
import Peticiones.peticionesArticulos.PeticionesArticulo;
import Peticiones.peticionesArticulos.*;
import java.util.ArrayList;
import Usuarios.Persona; //Hay que cambiarlo por Autor cuando este
import Usuarios.empleados.Autor;

import Usuarios.empleados.Revisor;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * Clase que representa a un Articulo, implementa a la 
 * interfaz Estado para determinar si está publicada o no; 
 * categoria para establecer una categoría; Serializable 
 * para poder almacenar en archivos los objetos de esta clase; y, 
 * Comparable para poder iterar elementos de esta clase.
 * @author Dante
 */
public class Articulo implements Estado, Categoria, Serializable, Comparable<Articulo>{ 
    private ArrayList<Autor> autores; //Sólo se puede tener un máximo de 3 autores, verificacion en clase pedirAutores
    private String Titulo;
    private String Snopsis;
    private String categoria;
    private HashMap <Integer, Revisor> revisoresCalificaciones;
    private String estado;
    private String folio; //Clave alfanumerica de 8 digitos
    private File referenciaArticulo;
    
    private ArrayList<PeticionesArticulo> peticionesNecesarias;  //lista para hacer las peticiones de forma automática
    
    /**
     * Constructor de la clase Articulo, el cual inicializará 
     * los arreglos de los atributos por medio de polimorfismo, pues se 
     * usan referencias a interfaces; se agregarán nuevos objetos para
     * poder realizar las peticiones de datos por este medio (constructor, 
     * arreglos de objetos y polimorfismo).
     **/
    public Articulo(){
        autores = new ArrayList<>();
        peticionesNecesarias = new ArrayList<>();
        peticionesNecesarias.add(new pedirTitulo());
        peticionesNecesarias.add(new pedirSinopsis());
        peticionesNecesarias.add(new pedirCategoria());
        peticionesNecesarias.add(new pedirAutores());
        peticionesNecesarias.add(new GenerarFolio());
        this.estado = Estado.STATER4;   //se auto asigna como pendiente
    }
    
    HashMap <Integer, Integer> mapaCalificaciones;    //La clave es el número de cuenta del Revisor,
                                                      //el valor representa la calificacion puesta
    
    
    /**
     * Método que recorre el arreglo de objetos para realizar Peticiones diferentes,
     * esto a través del polimorfismo por usar referencias a una interfaz, en otras 
     * palabras, este método es un mecanismo polimorfico para que el usuario ingrese 
     * los datos del objeto Persona, ahorrando líneas de código.
     **/
    public void pedirDatos(){
        System.out.println("Por favor ingresa los datos que se te piden \n");
        for(PeticionesArticulo peticion: peticionesNecesarias){
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
     * Método para la obtención de una parte del Folio por medio
     * de la generación de un HashCode que utiliza cada uno de los
     * atributos de un Articulo
     * 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.autores);
        hash = 83 * hash + Objects.hashCode(this.Titulo);
        hash = 83 * hash + Objects.hashCode(this.Snopsis);
        hash = 83 * hash + Objects.hashCode(this.categoria);
        hash = 83 * hash + Objects.hashCode(this.revisoresCalificaciones);
        hash = 83 * hash + Objects.hashCode(this.estado);
        hash = 83 * hash + Objects.hashCode(this.folio);
        return hash;
    }

    /**
     * Método que sobreescribe al método equals
     * para poder comparar objetos de clase Articulo.
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
        final Articulo other = (Articulo) obj;
        return true;
    }

    //METODOS QUE OBTIENEN LAS CATEGORIAS DE LA INTERFAZ CATEGORIA
    
    /**
     * Método de acceso para obtener la categoría 1 de un objeto Articulo.
     * @return Retorna la categoría 1 de este Articulo en cadena.
     **/
    public static String getCAT1() {
        return CAT1;
    }
    
    /**
     * Método de acceso para obtener la categoría 2 de un objeto Articulo.
     * @return Retorna la categoría 2 de este Articulo en cadena.
     **/
    public static String getCAT2() {
        return CAT2;
    }
    
    /**
     * Método de acceso para obtener la categoría 3 de un objeto Articulo.
     * @return Retorna la categoría 3 de este Articulo en cadena.
     **/
    public static String getCAT3() {
        return CAT3;
    }
    
   /**
     * Método de acceso para obtener la categoría 4 de un objeto Articulo.
     * @return Retorna la categoría 4 de este Articulo en cadena.
     **/
    public static String getCAT4() {
        return CAT4;
    }
     
    //METODOS QUE OBTIENEN LOS ESTADOS DE LA INTERFAZ ESTADO
    /**
     * Método de acceso para obtener el estado 3 de un objeto Articulo.
     * @return Retorna el estado 3 de este Articulo en cadena.
     **/
    public static String getSTATER3() {
        return STATER3;
    }
    
    /**
     * Método de acceso para obtener el estado 4 de un objeto Articulo.
     * @return Retorna el estado 4 de este Articulo en cadena.
     **/
    public static String getSTATER4() {
        return STATER4;
    }
    
    /**
     * Método de acceso para obtener el estado 5 de un objeto Articulo.
     * @return Retorna el estado 5 de este Articulo en cadena.
     **/
    public static String getSTATER5() {
        return STATER5;
    }
    
    //MÉTODOS COMUNES PARA LA CLASE Articulo
    
    /**
     * Método de acceso para obtener la lista de autores de un objeto Articulo.
     * @return Retorna la lista de autores de este Articulo en Lista.
     **/
    public ArrayList<Autor> getAutores() {
        return autores;
    }

    /**
     * Método de acceso para establecer la lista de autores de un objeto Articulo.
     * @param autores La lista de autores en Lista que se le pondrá al objeto.
     */
    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }
    
    /**
     * Método de acceso para obtener el primer autor de un objeto Articulo.
     * @return Retorna el primer autor de este Articulo en Autor.
     **/
    public Autor getAutor() {
        if(autores.isEmpty() == false){
            return autores.get(0);
        }else{
            return null;
        }
        
    }
    
    /**
     * Método de acceso para establecer un autor de un objeto Articulo.
     * @param autor El autor en Autor que se le pondrá al objeto.
     */
    public void setAutor(Autor autor){
        if(autores.size() <= 3){
            autores.add(autor);
        }else{
            System.out.println(" ");
            System.out.println("Ya hay 3 autores asociados a este articulo");

        }
        
    }

    /**
     * Método de acceso para obtener el título de un objeto Articulo.
     * @return Retorna el título de este Articulo en cadena.
     **/
    public String getTitulo() {
        return Titulo;
    }

    /**
     * Método de acceso para establecer el título de un objeto Articulo.
     * @param Titulo El título en cadena que se le pondrá al objeto.
     */
    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    /**
     * Método de acceso para obtener la sinopsis de un objeto Articulo.
     * @return Retorna la sinopsis de este Articulo en cadena.
     **/
    public String getSnopsis() {
        StringBuilder cadena = new StringBuilder();
        int i;
        for(i=80; i<this.Snopsis.length();i+=80){
            String subCadena;
            subCadena = this.Snopsis.substring(i-80,i+1)+"\n";
            cadena.append(subCadena);
        }
        cadena.append(this.Snopsis.substring(i-80,this.Snopsis.length()));
        cadena.append("\n");
        return cadena.toString();
    }

    /**
     * Método de acceso para establecer la sinopsis de un objeto Articulo.
     * @param Snopsis La sinopsis en cadena que se le pondrá al objeto.
     */
    public void setSnopsis(String Snopsis) {
        this.Snopsis = Snopsis;
    }

    /**
     * Método de acceso para obtener la categoría de un objeto Articulo.
     * @return Retorna la categoría de este Articulo en cadena.
     **/
    public String getCategoria() {
        return categoria;
    }

    /**
     * Método de acceso para establecer la categoria de un objeto Articulo.
     * @param categoria La categoria en cadena que se le pondrá al objeto.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Método de acceso para obtener el revisor de un objeto Articulo.
     * @return Retorna el revissor de este Articulo en Persona.
     **/
    public Persona getRevisor(int i) {
        return revisoresCalificaciones.get(i);
    }

    /**
     * Método de acceso para establecer el revisor de un objeto Articulo.
     * @param revisor El revisor en Revisor que se le pondrá al objeto.
     * @param i La calificacion que este revisor le coloca al artículo.
     */
    public void setRevisor(Revisor revisor, int i) {
        this.revisoresCalificaciones.put(i, revisor);
    }

    /**
     * Método de acceso para obtener el folio de un objeto Articulo.
     * @return Retorna el folio de este Articulo en cadena.
     **/
    public String getFolio() {
        return folio;
    }

    /**
     * Método de acceso para establecer el folio de un objeto Articulo.
     * @param folio El folio en cadena que se le pondrá al objeto.
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }    

    /**
     * Método de acceso para obtener el estado de un objeto Articulo.
     * @return Retorna el estado de este Articulo en cadena.
     **/
    public String getEstado() {
        return estado;
    }

    /**
     * Método de acceso para establecer el estado de un objeto Articulo.
     * @param estado El estado en cadena que se le pondrá al objeto.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }   

    /**
     * Método toString sobreescrito, el cual representa en forma 
     * de cadena una descripción general de los atributos del 
     * objeto.
     * @return Retorna una cadena que muestra una descripción
     * general de las características del objeto.
     */
    @Override
    public String toString() {
        StringBuilder infoArticulo = new StringBuilder();
        infoArticulo.append("\nTitulo: ").append(this.Titulo);
        infoArticulo.append("\nAutores: ").append(this.autoresToString());
        infoArticulo.append("\nEstado: ").append(this.estado);
        infoArticulo.append("\nFolio: ").append(this.folio);
        infoArticulo.append("\nSinopsis: ").append(this.getSnopsis());
        return infoArticulo.toString();
    }
    
    /**
     * Método que concatena los nombres de todos los autores
     * contenidos en el ArrayList de autores
     * @return String con los nombres de los autores
     */
    public String autoresToString(){
        StringBuilder autoresCadena = new StringBuilder();
        if(this.autores.isEmpty()){
            return "Sin autores";
        }else{
            for(Autor autor:this.getAutores()){
            autoresCadena.append(autor.getApellidoPaterno())
                    .append(", ").append(autor.getNombre()).append("; ");
        }
        return autoresCadena.toString();
        }
    }
    
    /**
     * Método que imprime los revisores de este artículo
     * si es que los hay.
     * @return Retorna una cadena con la información
     * de los revisores de este artículo.
     */
    public String revisoresToString(){
        StringBuilder revisoresCadena = new StringBuilder();
        if(this.revisoresCalificaciones.isEmpty()){
            return "Sin Revisores";
        } else {
            for(Map.Entry<Integer, Revisor> entry : this.revisoresCalificaciones.entrySet()){            
                revisoresCadena.append("Revisor").append(entry.getValue().toString()).append(" ; Calificacion : ").append(entry.getKey()).append(" \n");
            }
            return revisoresCadena.toString();
        }         
    }

    /**
     * Método que sobreescribe el método compareTo para
     * poder comparar elementos de esta clase por medio
     * del atributo título.
     * @param o Objeto de la clase Articulo para
     * comparar.
     * @return Se retorna un valor entero tras hacer la
     * comparación entre los títulos.
     */
    @Override
    public int compareTo(Articulo o) {
        // TODO Auto-generated method stub
        return this.Titulo.compareTo(o.getTitulo());
    }

    public File getReferenciaArticulo() {
        return referenciaArticulo;
    }

    public void setReferenciaArticulo(File referenciaArticulo) {
        this.referenciaArticulo = referenciaArticulo;
    }
}

