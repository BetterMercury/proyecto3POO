package datos;

import Estado.Estado;
import Revista.Revista;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Usuarios.empleados.*;
import Usuarios.suscriptor.Suscriptor;
import articulo.Articulo;
import java.util.TreeSet;
import java.io.*;
/**
 * Clase que almacena estructruas (Principalmetne HashMaps) de las
 * revistas, articulos suscritores y empleados.
 * @author equipo 9
 */
public class Dato implements Estado, Serializable {
    
    /**
     *Atributo estático que guarda una referencia a la única instancia de la 
     * clase.
     */
    public static Dato instance;
    private int numeroDeRevistas;
    private final HashMap <Integer, Empleado> mapaEmpleados;
    private final HashMap <Integer, Suscriptor> mapaSuscriptores;
    private final HashMap <Integer, Revista> mapaRevistas;
    private final HashMap <String, Articulo> mapaArticulos; //Se hizo la correcion, el Folio debia ser String... ok
    
    //Conjunto especifios de tipos de Empleados
    private final TreeSet <Autor> setAutores;
    private final TreeSet <Editor> setEditores;
    private final TreeSet <Revisor> setRevisores;
    private final TreeSet<Administrador> setAdministradores;
    private Director directorGeneral;
    //Conjuntos espeficios de tipos de Articulos;
    private final TreeSet<Articulo> setArticulosAceptados;
    private final TreeSet<Articulo> setArticulosPendientes;
    private final TreeSet<Articulo> setArticulosRechazados;
    //Conjuntos especificos de tipos de Revistas
    private final TreeSet<Revista> setRevistasPublicadas;
    private final TreeSet<Revista> setRevistasNoPublicadas;
    /**
     * Costructor por defecto, inicializa los distintos HashMaps. Es privado
     * devido a que esta clase implementa singleton.
     */
    private Dato()  {
        //Mapas de usuarios
        mapaEmpleados = new HashMap<>();
        mapaSuscriptores = new HashMap<>();
        //mapas de productos
        mapaRevistas = new HashMap<>();
        mapaArticulos = new HashMap<>(); 
        
        //Conjuntos de empleados 
        setAutores = new TreeSet<>();
        setEditores = new TreeSet<>();
        setRevisores = new TreeSet<>();
        setAdministradores = new TreeSet<>();
        //conjuntos de Articulos
        setArticulosAceptados = new TreeSet<>();
        setArticulosPendientes = new TreeSet<>();
        setArticulosRechazados = new TreeSet <> ();
        //conjuntos de revistas
        setRevistasPublicadas = new TreeSet<>();
        setRevistasNoPublicadas = new TreeSet<>();
    }
    
    /**
     * Metodo para obtener la instancia de dato. Como esta clase es un singleton
     * el constructor es privado y la única manera de acceder a la instancia es
     * con este método
     * @return Instancia única de Dato
     */
    public static Dato getInstance(){
        if(Dato.instance == null){
            instance = new Dato();
        }
        return instance;
    }
    
    /**
     * Método para devolver un empleado por su número de empleado
     * @param numeroEmpleado Numero de empleado del empleado
     * @return El empleado buscado, si no es encontró devuelve null
     */
    public Empleado buscarNumeroEmpleado(Integer numeroEmpleado){
        return mapaEmpleados.get(numeroEmpleado);    
    }
    /**
     * Método para devolver un empleado por su correo electronico
     * @param correo Correo electronico del empleado
     * @return El empleado buscado, si no es encontró devuelve null
     */
    public Empleado buscarEmpleado(String correo){
        for(Map.Entry<Integer,Empleado> entrada:this.mapaEmpleados.entrySet()){
            Empleado empleadoActual = entrada.getValue();
            if(correo.equals(empleadoActual.getEmail())){
                return empleadoActual;
            }
            
        }
        return null;
    }
    
    /**
     * Método para determinar la existencia de un empleado por medio
     * de su número.
     * @param numeroEmpleado 
     * @return true si existe en el mapa de empleados, false si no.
     */
    public boolean existsNumeroEmpleado(Integer numeroEmpleado){
        if(this.mapaEmpleados.containsKey(numeroEmpleado)){
            return true;
        } else{
            return false;
        }
    }       
    
    public boolean aniadirEmpleado(Empleado nuevoEmpleado){

        if (mapaEmpleados.containsKey(nuevoEmpleado.getNumeroEmpleado())){
            return false;
        }else{
            mapaEmpleados.put(nuevoEmpleado.getNumeroEmpleado(), nuevoEmpleado);
            this.aniadirListaEspecifica(nuevoEmpleado);
            return true;
        }
    }
    /**
     * Metodo que devuelve un  treeSet de empleados.
     * @return TreeSet con todos los empleados registrados.
     */
    public TreeSet<Empleado> getSetDeEmpleados(){
        return new TreeSet<>(this.mapaEmpleados.values());
    }
    /**
     * Metodo para devolver el mapa de empleados completo
     * @return Mapa de empleados registrados.
     */
    public HashMap<Integer, Empleado> getMapEmpleados(){
        return mapaEmpleados;
    }
    
    
    /**
     * Metodo para añadir a una lista especifica a un usuario dependiendo de
     * su puesto
     * @param empleado Empleado a añadir a una lista específica 
     */
    private void aniadirListaEspecifica(Empleado empleado){
        if (empleado instanceof Autor){
            setAutores.add((Autor)empleado);
        }else if (empleado instanceof Editor){
            setEditores.add((Editor)empleado);
        }else if (empleado instanceof Revisor){
            setRevisores.add((Revisor)empleado);
        }else if (empleado instanceof Administrador){
            setAdministradores.add((Administrador)empleado);
        }else if (empleado instanceof Director){
            if(directorGeneral != null)
                this.mapaEmpleados.remove(this.directorGeneral.getNumeroEmpleado());
            directorGeneral = (Director)empleado;

        }else{
            System.out.println("Esto no deberia de pasar \n aniadirListaEspecifica"
                    + " en la clase dato del paquete dato xd");
        }
    }
    
    //Métodos de clientes
    /**
     * Método para buscar a un suscriptor por su numero único de suscriptor.
     * @param numeroSuscriptor Numero único del suscriptor.
     * @return Suscriptor buscado, null si no se encontró.
     */
    public Suscriptor buscarNumeroSuscriptor(Integer numeroSuscriptor){
        return this.mapaSuscriptores.get(numeroSuscriptor);    
    }
    /**
     * Método para buscar un suscriptor por su correo electrónico
     * @param correo Correo electrónico del usuario
     * @return Suscriptor bsucado, null en caso de no encontrarse.
     */
    public Suscriptor buscarSuscriptor(String correo){
        for(Map.Entry<Integer,Suscriptor> entrada:this.mapaSuscriptores.entrySet()){
            Suscriptor suscriptorActual = entrada.getValue();
            if(correo.equals(suscriptorActual.getEmail())){
                return suscriptorActual;
            }
            
        }
        return null;
    }
    /**
     * Método para añadir un suscriptor a los mapas de la clase.
     * @param nuevoSuscriptor Suscriptor a ser añadido.
     * @return true si se pudo añadir al suscriptor, falso en cualquier otro
     * caso.
     */
    public boolean aniadirSuscriptor(Suscriptor nuevoSuscriptor){
        if (mapaSuscriptores.containsKey(nuevoSuscriptor.getNumeroSuscriptor())){
            return false;
        }else{
            mapaSuscriptores.put(nuevoSuscriptor.getNumeroSuscriptor(), nuevoSuscriptor);
            return true;
        }
    }
    
    /**
     * Devuelve un TreeSet de suscriptores actuales
     * @return Set de suscriptores actualmente suscritos.
     */
    public TreeSet<Suscriptor> getSetDeSuscriptores(){
        return new TreeSet<>(this.mapaSuscriptores.values());
    }
    /**
     * Elimina a un suscriptor de la lista de suscriptores 
     * @param aEliminar Suscriptor a ser eliminado 
     * @return true si la eliminación fue exitosa, false si no.
     */
    public boolean eliminarSuscriptor(Suscriptor aEliminar){
        aEliminar = this.mapaSuscriptores.remove(aEliminar.getNumeroSuscriptor());
        if(aEliminar == null){
            return false;
        }else{
            return true;
        }
    }
    
    //Empleados
    /**
     * Devuelve un TreeSet de editores actuales
     * @return Set de editores actualmente contratados.
     */
    public TreeSet<Editor> getSetDeEditores (){
        return setEditores;
    }
    /**
     * Devuelve un TreeSet de autores actuales
     * @return Set de autores actualmente contratados.
     */
    public TreeSet<Autor> getSetDeAutores(){
        return setAutores;
    }
    /**
     * Devuelve un TreeSet de revisores actuales
     * @return Set de revisores actualmente contratados.
     */
    public TreeSet<Revisor> getSetDeRevisores(){
        return setRevisores;
    } 
    /**
     * Devuelve un TreeSet de administradores actuales
     * @return Set de administradores actualmente contratados.
     */
    public TreeSet<Administrador> getSetAdministradores(){
        return setAdministradores;
    }

    //Metodos de revistas 
    /**
     * Añade un artículo a los mapas del objeto Dato
     * @param nuevoArticulo Articulo a ser añadidio a los mapas.
     * @return true si se pudo añadir correctamenete, false en cualquier otro
     * caso
     */
    public boolean aniadirArticulo(Articulo nuevoArticulo){
        String folioArticulo = nuevoArticulo.getFolio();
        if(!mapaArticulos.containsKey(folioArticulo)){
            this.mapaArticulos.put(folioArticulo,nuevoArticulo);
            conjuntoEspecificoArticulo(nuevoArticulo);
            return true;
        }else{
            System.out.println("De alguna manera el articulo tienen el "
                    + "mismo folio, esto no debio pasar");
        }
        return false;
    }
    
    /**
     * Método booleano que ayuda a determinar la existencia de un folio
     * en el mapa de articulos.
     * @param folio es el Folio a comprobar su existencia.
     * @return true si existe, false si no existe.
     */
    public boolean existsFolioArticulo(String folio){
        return this.mapaArticulos.containsKey(folio);
    }
    /**
     * Añade un artículo a su conjunto específico dependiendo de su estado.
     * @param nuevoArticulo El nuevo articulo a ser añadido a los mapas.
     * @return true si se pudo añadir exitosamente, false en caso contrario.
     */
    private boolean conjuntoEspecificoArticulo(Articulo nuevoArticulo){
        switch (nuevoArticulo.getEstado()) {
            case STATER3:
                return this.setArticulosAceptados.add(nuevoArticulo);
            case STATER4:
                return this.setArticulosPendientes.add(nuevoArticulo);
            case STATER5:
                return this.setArticulosRechazados.add(nuevoArticulo);
            default:
                System.out.println("Error, la revista probablemente tiene un estado"
                        + "invalido o no tiene uno asignado");
                return false;
        }
    }
    /**
     * Quita a un artículo de un conjunto específico cuando cambia de estado 
     * para evitar que se queden en un set que no les corresponde.
     * @param articulo Articulo a ser movido set específico.
     * @return true si se movió correctamente, false en caso contrario.
     */
    private boolean quitarDeConjuntoEspecificoArticulo(Articulo articulo){
        
        if (setArticulosAceptados.remove(articulo)){return true;}
        
        if (setArticulosPendientes.remove(articulo)){return true;}
        
        return setArticulosRechazados.remove(articulo);
    }
    /**
     * Cuando un articulo es cambiado deestado se debe llamar a este método
     * para moverlo de set específico.
     * @param articulo Articulo a ser movido.
     * @return true si se pudo mover exitosamente, false si no.
     */
    public boolean actualizarEstadoArticulo(Articulo articulo){
        boolean a = this.quitarDeConjuntoEspecificoArticulo(articulo);
        boolean b = this.conjuntoEspecificoArticulo(articulo);
        return a && b ;
    }
    /**Devuelve un set de artículos aceptados
     * @return Set de artículos aceptados al momento de llamar al método.
     */
    public TreeSet<Articulo> getSetArticulosAceptados() {
        return setArticulosAceptados;
    }
    
    /**Devuelve un set de artículos pendientes
     * @return Set de artículos pendientes al momento de llamar al método.
     */
    public TreeSet<Articulo> getSetArticulosPendientes() {
        return setArticulosPendientes;
    }
    /**Devuelve un set de artículos rechazados
     * @return Set de artículos rechazados al momento de llamar al método.
     */
    public TreeSet<Articulo> getSetArticulosRechazados() {
        return setArticulosRechazados;
    }
    /**
     * Método para devolver un articulo por su folio.
     * @param folio Folio del artículo.
     * @return Articulo si es que existe, si no, null.
     */
    public Articulo buscarFolioArticulo(String folio){
        return this.mapaArticulos.get(folio);
    }
    

    //Métodos de revistas
    /**
     * Método que devuelve un set de revistas publicadas
     * @return set de revistas publicadas.
     */
    public TreeSet<Revista> getSetRevistasPublicadas() {
        return setRevistasPublicadas;
    }
    /**
     * Método que devuelve un set de revistas no publicadas
     * @return set de revistas no publicadas.
     */
    public TreeSet<Revista> getSetRevistasNoPublicadas() {
        return setRevistasNoPublicadas;
    }
    /**
     * Añade una revista a los mapas de la instancia de Dato.
     * @param nuevaRevista revista a ser agregada.
     * @return true si se pudo añadir, false en caso contrario.
     */
    public boolean aniadirRevista(Revista nuevaRevista){
        int numeroRevista = nuevaRevista.getNumRevista();
        if(!mapaRevistas.containsKey(numeroRevista)){
            this.mapaRevistas.put(numeroRevista,nuevaRevista);
            conjuntoEspecificoRevista(nuevaRevista);
            return true;
        }else{
            System.out.println("De alguna manera dos revistas tienen el "
                    + "mismo numero, esto no debio pasar");
        }
        return false;
    }
    /**
     * Método que añade a un conjunto específico de revistas una revista dependiendo
     * de su estado
     * @param nuevaRevista Revista a ser añadida a un conjunto específico.
     * @return verdadero si se pudo añadir, falso en caso contrario.
     */
    private boolean conjuntoEspecificoRevista(Revista nuevaRevista){
        switch (nuevaRevista.getEstado()) {
            case STATER1:
                return this.setRevistasPublicadas.add(nuevaRevista);
            case STATER2:
                return this.setRevistasNoPublicadas.add(nuevaRevista);
            default:
                System.out.println("Error, la revista probablemente tiene un estado"
                        + "invalido o no tiene uno asignado");
                return false;
        }
    }
    /**
     * Elimina una instancia de revista de uno de los conjuntos específicos de la
     * instancia.
     * @param revista Revista a ser quitada de un conjunto específico.
     * @return true si se pudo eliminar, false en cualquier otro caso.
     */
    private boolean quitarDeConjuntoEspecificoRevista(Revista revista){
        
        if (setRevistasNoPublicadas.remove(revista)){return true;}
        return setRevistasPublicadas.remove(revista);
    }
    /**
     * Mueve una instancia de revista de un set específico a otro al actualizar
     * su estado.
     * @param revista
     * @return 
     */
    public boolean actualizarEstadoRevista(Revista revista){
        boolean a = this.quitarDeConjuntoEspecificoRevista(revista);
        boolean b = this.conjuntoEspecificoRevista(revista);
        return a && b ;
    }
    /**
     * Devuelve una revista por su número
     * @param numero El número de la revista.
     * @return La revista si es que existe, en caso contrario null.
     */
    public Revista buscarFolioNumeroRevista(int numero){
        return this.mapaRevistas.get(numero); 
    }
    /**
     * Verifica la existencia de una revista por su número.
     * @param numero numero de la revista
     * @return true si existe, false si no.
     */
    public boolean existsFolioNumeroRevista(int numero){
        if(this.mapaRevistas.containsKey(numero)){
            return true;
        } else {
            return false;
        }
    }    
    /**
     * Devuelve el director general de la empresa.
     * @return Instancia de director general. Nunca debe devolver null, el director
     * general siempre debe existir.
     */
    public Director getDirectorGeneral() {
        return directorGeneral;
    }    
    /**
     * Devuelve el mapa general de artículos
     * @return Mapa general de artículos.
     */
    public HashMap<String, Articulo> getMapaArticulos() {
        return mapaArticulos;
    }
    /**
     * Devuelve el mapa general de revistas.
     * @return  mapa general de revistas.
     */
    public HashMap<Integer, Revista> getMapaRevistas() {
        return mapaRevistas;
    }
    /**
     * Método para cargar los datos en una posterior ejecución del programa.
     * Solo debe ser ejecuatado una vez al inicio del programa. Es la única forma
     * de cambiar la instancia de Dato. Indica al usuario si el archivo no es 
     * compatible.
     * @return 
     */
    public boolean cargarDatos() {
        String nombreArchivo = "guardadoDeDatos.ser";
        try{
            FileInputStream flujoArchivo = new FileInputStream(nombreArchivo);
            ObjectInputStream out = new ObjectInputStream(flujoArchivo);
            Dato.instance = (Dato) out.readObject();
            Revista.conteoRevistas = Dato.instance.numeroDeRevistas;
            System.out.println("Cargado exitoso");
            out.close();
            return true;
        }catch(FileNotFoundException e){
            System.out.println("Parece que no existe un archivo de datos");
            return false;

        }catch (InvalidClassException e){
            System.out.println("Clase incorrecta, probablemente la versión "
                    + "del archivo no es compatible");
            return false;
        }catch (IOException e){
            System.out.println("Ocurrio un error inesperado de I/O");
            return false;
        } catch (ClassNotFoundException ex) {
            System.out.println("Se intentó cargar un objeto incompatible");
            return false;
        }
    }
    /**
     * Guarda los datos de la ejecución utilizando ObjectOutputStream. Le indica al
     * usuario si se pudieron guardar los datos exitosamente.
     */
    public void guardarDatos() {
        String nombreArchivo = "guardadoDeDatos.ser";
        try{
            this.numeroDeRevistas = Revista.conteoRevistas;
            FileOutputStream flujoArchivo = new FileOutputStream(nombreArchivo);
            ObjectOutputStream out = new ObjectOutputStream(flujoArchivo);
            out.writeObject(this);
            System.out.println("Guardado exitoso");
            out.close();
        }catch (InvalidClassException e){
            System.out.println("Clase incorrecta, probablemente la versión "
                    + "del archivo no es compatible");
        }catch(NotSerializableException e){
            System.out.println("No se pudo serializar: "+e.toString());
        }catch (IOException e){
            System.out.println("Ocurrio un error inesperado de I/O");
        }
    }

    /**
     * Método que copia un archivo pdf a directorio seguro dentro del programa para
     * poder ser utilizado posteriormente.
     * @param ruta String de la ruta absoluta al archivo
     * @return Objeto de tipo File apuntando al archivo dentro del directorio seguro. null en caso
     * de que no se haya podido copiar el archivo. 
     */


    public File copiarPDF(String ruta){
        Scanner sc = new Scanner(System.in);
        String extension;
        File archivoDatos;
        File directorioPDFs = new File("archivos");
        File archivoEscritura;
        int ultimoPunto;
           
        archivoDatos = new File(ruta);
        ultimoPunto = ruta.lastIndexOf('.');
        extension = ruta.substring(ultimoPunto+1,ruta.length());
        //Si no tiene extensión o la extensión es diferente a pdf
        if(ultimoPunto ==-1 || !extension.equals("pdf") ){
            System.out.println("La extension no es correcta");
            return null;
        }
            

        if(!directorioPDFs.exists()){
            if(directorioPDFs.mkdir()){
                System.out.println("Se creo el directorio de archivos exitosamente");
            }else{
                System.out.println("No se pudo crear el directorio de archivos");
                return null;
            }
        }
        archivoEscritura = new File (directorioPDFs.toString()+archivoDatos.getName());
        
        if(!archivoEscritura.exists()){
            try{
                archivoEscritura.createNewFile();
            }catch(IOException e){
                System.out.println("Ocurrio un error al crear el archivo de texto");
                return null;
            }
        }else{
            System.out.println("El archivo ya existe en los datos");
            return null;
        }
        
        FileInputStream lector;
        FileOutputStream escritor;
        try{
            lector = new FileInputStream(archivoDatos);
            escritor = new FileOutputStream(archivoEscritura);
        }catch(FileNotFoundException e){
            System.out.println("No se encontró el archivo de entrada");
            return null;
        }
        try{
            int caracter = lector.read();
            while(caracter != -1){
                escritor.write(caracter);
                caracter = lector.read();
            }
            
        }catch(IOException e){
            System.out.println("Error al trasformar los datos");
            return null;
        }finally{
            try{
            lector.close();
            escritor.close();
            }catch(IOException e){
                System.out.println("Error al cerrar los archivos");
                return null;
            }

        }
        return archivoEscritura;

    }
}
