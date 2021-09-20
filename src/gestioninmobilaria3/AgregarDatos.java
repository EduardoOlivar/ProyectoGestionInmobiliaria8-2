package gestioninmobilaria3;
import java.io.*;
public class AgregarDatos{
  /*metodo para agregar edificios por consola*/
  public void agregarEdificio(Administrador administrador)throws IOException{
    BufferedReader lectura = new  BufferedReader( new InputStreamReader( System.in));
        
    System.out.println("Ingrese nombre del edificio");
    String nombreEdificio = lectura.readLine();
    System.out.println("Ingrese direccion del edificio");
    String direccionEdificio = lectura.readLine();   
    System.out.println("Ingrese localidad del edificio");
    String localidadEdificio = lectura.readLine();
    System.out.println("Ingrese arquitecto del edificio");
    String arquitectoEdificio = lectura.readLine();         
    if(administrador.agregarEdificios(nombreEdificio, direccionEdificio, localidadEdificio, arquitectoEdificio)){
      System.out.println("El edificio  "+nombreEdificio + " tiene el id: "+administrador.getEdificiosNombre().get(nombreEdificio).getId());
    }
    else
      System.out.println("Edificio " + nombreEdificio + " ya existe");
  }

    /* agrega departamentos a edificios*/
  public void agregarDepartamento(Administrador administrador) throws IOException{
    /*comprueba si es que hay o no edificios*/
    if(administrador.vacio()){
      System.out.println("No existen edificios, no se agregaran departamentos");
      return;
    }
    BufferedReader lectura = new  BufferedReader( new InputStreamReader( System.in));
    /*Por id se le asignan los departamentos al edificio*/
    System.out.println("Ingrese el id del edificio al que pertenece el departamento");
    String idEdificio = lectura.readLine();
    /*Se comprueba que exista el edificio y se le agrega departamento al edificio buscado por id*/
    if(administrador.existeEdifcio(idEdificio)){
      System.out.println("Ingrese numero de piso en el que se encuentra el departamento");
      String numeroPiso = lectura.readLine();        
      System.out.println("Ingrese numero de departamento");
      String numeroDpto = lectura.readLine();     
      System.out.println("Ingrese valor en uf del departamento");
      String valorDpto = lectura.readLine();
      System.out.println("Ingrese orientacion del departamento");
      String orientacion = lectura.readLine();
      System.out.println("Ingrese cantidad de banos del departamento");
      int cantidadBaños = Integer.parseInt(lectura.readLine());
      System.out.println("Ingrese cantidad de dormitorios del departamento");
      int cantidadDormitorios = Integer.parseInt(lectura.readLine());
      System.out.println("Ingrese los metros cuadrados del departamento");
      int metrosCuadrados = Integer.parseInt(lectura.readLine());  
      System.out.println("Si el departamento esta disponible escriba: disponible, de lo contrario escriba: vendido :");  
      String disponibilidadDpto = lectura.readLine();          
      administrador.agregarDepartamentoAedificio(idEdificio, numeroPiso, numeroDpto, valorDpto, orientacion, cantidadBaños, cantidadDormitorios, metrosCuadrados,disponibilidadDpto);
      return;
    }
    System.out.println("El edifcio ingresado no existe");
  }    
}    

