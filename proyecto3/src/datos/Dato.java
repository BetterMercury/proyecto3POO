package datos;

import Estado.Estado;
import Revista.Revista;
import java.util.HashMap; 
import java.util.Map;
import Usuarios.empleados.*;
import Usuarios.suscriptor.Suscriptor;
import articulo.Articulo;
import java.util.TreeSet;

public class Dato implements Estado {
    
    public static Dato instance;
    
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
    
    public static Dato getInstance(){
        if(Dato.instance == null){
            instance = new Dato();
        }
        return instance;
    }
    
    /**
     * 
     * @param numeroEmpleado 
     * @return 
     */
    public Empleado buscarNumeroEmpleado(Integer numeroEmpleado){
        return mapaEmpleados.get(numeroEmpleado);    
    }
    
    public Empleado buscarEmpleado(String correo){
        for(Map.Entry<Integer,Empleado> entrada:this.mapaEmpleados.entrySet()){
            Empleado empleadoActual = entrada.getValue();
            if(correo.equals(empleadoActual.getEmail())){
                return empleadoActual;
            }
            
        }
        return null;
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
    
    public TreeSet<Empleado> getSetDeEmpleados(){
        return new TreeSet<>(this.mapaEmpleados.values());
    }
    
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
            directorGeneral = (Director)empleado;
        }else{
            System.out.println("Esto no deberia de pasar \n aniadirListaEspecifica"
                    + " en la clase dato del paquete dato xd");
        }
    }
    
    //Métodos de clientes
    
    public Suscriptor buscarNumeroSuscriptor(Integer numeroSuscriptor){
        return this.mapaSuscriptores.get(numeroSuscriptor);    
    }
    
    public Suscriptor buscarSuscriptor(String correo){
        for(Map.Entry<Integer,Suscriptor> entrada:this.mapaSuscriptores.entrySet()){
            Suscriptor suscriptorActual = entrada.getValue();
            if(correo.equals(suscriptorActual.getEmail())){
                return suscriptorActual;
            }
            
        }
        return null;
    }
    
    public boolean aniadirSuscriptor(Suscriptor nuevoSuscriptor){
        if (mapaSuscriptores.containsKey(nuevoSuscriptor.getNumeroSuscriptor())){
            return false;
        }else{
            mapaSuscriptores.put(nuevoSuscriptor.getNumeroSuscriptor(), nuevoSuscriptor);
            return true;
        }
    }
    
    public TreeSet<Suscriptor> getSetDeSuscriptores(){
        return new TreeSet<>(this.mapaSuscriptores.values());
    }
    
    public TreeSet<Editor> getSetDeEditores (){
        return setEditores;
    }
    
    public TreeSet<Autor> getSetDeAutores(){
        return setAutores;
    }
    
    public TreeSet<Revisor> getSetDeRevisores(){
        return setRevisores;
    } 
    
    public TreeSet<Administrador> getSetAdministradores(){
        return setAdministradores;
    }

    //Metodos de revistas 
    
    public boolean aniadirArticulo(Articulo nuevoArticulo){
        String folioArticulo = nuevoArticulo.getFolio();
        if(mapaRevistas.containsKey(folioArticulo)){
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
        return (this.mapaArticulos.containsValue(folio));
    }
    
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
    

    private boolean quitarDeConjuntoEspecificoArticulo(Articulo articulo){
        boolean resultado;
        
        if (setArticulosAceptados.remove(articulo)){return true;}
        
        if (setArticulosPendientes.remove(articulo)){return true;}
        
        return setArticulosRechazados.remove(articulo);
    }
    
    public boolean actualizarEstadoArticulo(Articulo articulo){
        boolean a = this.quitarDeConjuntoEspecificoArticulo(articulo);
        boolean b = this.conjuntoEspecificoArticulo(articulo);
        return a && b ;
    }
    public TreeSet<Articulo> getSetArticulosAceptados() {
        return setArticulosAceptados;
    }

    public TreeSet<Articulo> getSetArticulosPendientes() {
        return setArticulosPendientes;
    }

    public TreeSet<Articulo> getSetArticulosRechazados() {
        return setArticulosRechazados;
    }
    
    public Articulo buscarFolioArticulo(String folio){
        return this.mapaArticulos.get(folio);
    }
    

    //Métodos de revistas
    public TreeSet<Revista> getSetRevistasPublicadas() {
        return setRevistasPublicadas;
    }

    public TreeSet<Revista> getSetRevistasNoPublicadas() {
        return setRevistasNoPublicadas;
    }

    public boolean aniadirRevista(Revista nuevaRevista){
        int numeroRevista = nuevaRevista.getNumRevista();
        if(mapaRevistas.containsKey(numeroRevista)){
            this.mapaRevistas.put(numeroRevista,nuevaRevista);
            conjuntoEspecificoRevista(nuevaRevista);
            return true;
        }else{
            System.out.println("De alguna manera dos revistas tienen el "
                    + "mismo numero, esto no debio pasar");
        }
        return false;
    }
    
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
    private boolean quitarDeConjuntoEspecificoRevista(Revista revista){
        boolean resultado;
        
        if (setRevistasNoPublicadas.remove(revista)){return true;}
        return setRevistasPublicadas.remove(revista);
    }
    
    public boolean actualizarEstadoRevista(Revista revista){
        boolean a = this.quitarDeConjuntoEspecificoRevista(revista);
        boolean b = this.conjuntoEspecificoRevista(revista);
        return a && b ;
    }
}
