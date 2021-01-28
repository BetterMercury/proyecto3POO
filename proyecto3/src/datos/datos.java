package datos;

import java.util.HashMap; 
import java.util.Map;
import Usuarios.empleados.*;
import Usuarios.suscriptor.Suscriptor;
import java.util.TreeSet;

public class datos {
    HashMap <Integer,Empleado> mapaEmpleados;
    HashMap <Integer, Suscriptor> mapaSuscriptores;
    TreeSet <Autor> setAutores;
    TreeSet <Editor> setEditores;
    TreeSet <Revisor> setRevisores;
    
    
    
    public datos(){
        mapaEmpleados = new HashMap<>();
        mapaSuscriptores = new HashMap<>();
        setAutores = new TreeSet<>();
        setEditores = new TreeSet<>();
        setRevisores = new TreeSet<>();
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

}
