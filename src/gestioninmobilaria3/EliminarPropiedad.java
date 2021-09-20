package gestioninmobilaria3;
import java.io.*;

public class EliminarPropiedad{ 
  
  public void eliminarEdificio(Administrador administrador)throws IOException{
    if(administrador.vacio()){
      System.out.println("No existen Edificios");
      return;
    }
    BufferedReader lectura = new BufferedReader( new InputStreamReader( System.in));
    System.out.println("Ingrese id del edificio que quiere eliminar");
    String idEdificio = lectura.readLine();
    administrador.eliminarEdificio(idEdificio);
  }   
}