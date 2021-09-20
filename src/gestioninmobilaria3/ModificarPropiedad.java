package gestioninmobilaria3;
import java.io.*;

public class ModificarPropiedad{

  public void modificarNombreEdificio(Administrador administrador)throws IOException{
    if(administrador.vacio()){
      System.out.println("No existen Edificios");
      return;
    }
    BufferedReader lectura = new  BufferedReader( new InputStreamReader( System.in));
    System.out.println("Ingrese id del edificio que quiere modificar su nombre");
    String idEdificio = lectura.readLine();
    System.out.println("Ingrese el nuevo nombre del Edificio");
    String NombreEdificio = lectura.readLine();
    administrador.modificarNombreEdificio(NombreEdificio, idEdificio);
  }  
} 