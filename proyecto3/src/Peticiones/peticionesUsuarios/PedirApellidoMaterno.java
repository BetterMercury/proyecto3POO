package Peticiones.peticionesUsuarios;
import Excepciones.ErrorDeDatoException;
import java.util.Scanner;
import Usuarios.Persona;

public class PedirApellidoMaterno extends PeticionPersona{

    @Override
    public void realizarPeticion(Persona objetivo) throws ErrorDeDatoException {
        String nombre;
        Scanner sc = new Scanner(System.in);
        System.out.print("Apellido materno (menor a 15 caracteres \ny sin digitos): ");
        nombre = sc.nextLine();

        if((nombre.length()==0) ||nombre.length()>15 || !sinNumeros(nombre)){
            throw new ErrorDeDatoException("Formato de apellido incorrecto");
        }
        objetivo.setApellidoMaterno(nombre);
    }

    private boolean sinNumeros(String cadena){
        for(char c: cadena.toCharArray()){
            return !Character.isDigit(c);
        }
        return true;
    }


}
