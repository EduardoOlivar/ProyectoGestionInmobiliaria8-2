
package gestioninmobilaria3;
import java.io.*;

public class Datos{
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


  
    /*muestrra la lista de edificios si es que hay*/
  public void mostrarListadoDeEdifcios(Administrador administrador) {
    if(administrador.getEdificiosId().isEmpty()){
      System.out.println("No existen Edificios");
      return;
    }
    int i;
    System.out.println("Id:  || nombre edifcio || direccion || localidad || arquitecto");
    for(i=0; i<administrador.getListaEdificio().size(); i++){
      System.out.println(administrador.getListaEdificio().get(i).getId()+": "+administrador.getListaEdificio().get(i).getNombre()+" || "+administrador.getListaEdificio().get(i).getDireccion()+" || "+administrador.getListaEdificio().get(i).getLocalidad()+" || " +administrador.getListaEdificio().get(i).getArquitecto());
    }        
  }

  /*muestra todos los departamentos si es que hay*/
  public void mostrarTodosLosDepartamentos(Administrador administrador){
    administrador.mostrarTodosLosDepartamentos();
  }

  /*busca el departamento a partir de la id ingresada*/
  public void buscarDepartamento(Administrador administrador)throws IOException{
    BufferedReader lectura = new  BufferedReader( new InputStreamReader( System.in));
    System.out.println("Ingrese id del departamento que busca");
    String idDepartamento = lectura.readLine();
    System.out.println(idDepartamento.toLowerCase());//convierte los caracteres a minuscula
    if(administrador.BuscarDepartamento(idDepartamento))
      mostrarDepartamento(idDepartamento,administrador);
  } 

  public void mostrarDepartamento(String idDepartamento,Administrador administrador){//Se seguieron las recomendaciones y se movieron al main todas las interacciones con el usuario
    for(int i = 0; i<administrador.getListaEdificio().size();i++){
      if(administrador.getListaEdificio().get(i).getDepartamentosId().containsKey(idDepartamento)){
        System.out.println("codigo: Numero de piso     numero de departamento            valor en uf                 orientacion               cantidad de baños            cantidad de dormitorios       metro cuadrados       disponibilidad departamento");
        System.out.println("     "+administrador.getListaEdificio().get(i).getDepartamentosId().get(idDepartamento).getIdDepartamento()+":            "+administrador.getListaEdificio().get(i).getDepartamentosId().get(idDepartamento).getNumeroPiso()+ "               "+administrador.getListaEdificio().get(i).getDepartamentosId().get(idDepartamento).getNumeroDpto()+"                              "+administrador.getListaEdificio().get(i).getDepartamentosId().get(idDepartamento).getValorDpto()+"                       "+administrador.getListaEdificio().get(i).getDepartamentosId().get(idDepartamento).getOrientacion()+"                         "+administrador.getListaEdificio().get(i).getDepartamentosId().get(idDepartamento).getCantidadBaños()+"                               "+administrador.getListaEdificio().get(i).getDepartamentosId().get(idDepartamento).getCantidadDormitorios()+"                          "+administrador.getListaEdificio().get(i).getDepartamentosId().get(idDepartamento).getMetrosCuadrados()+"                          "+administrador.getListaEdificio().get(i).getDepartamentosId().get(idDepartamento).getDisponibilidadDpto());  
        return;
      }
    }               
  }

  /*Muestra por pantalla los departamentos en los edificios que esten en un rango especificado por el usuario*/
  public void mostrarDepartamentosPorPrecios(Administrador administrador)throws IOException{
    BufferedReader lectura = new  BufferedReader( new InputStreamReader( System.in));
    if(administrador.vacio()){
      System.out.println("No hay Edificios, ingrese Edificios para tener departamentos");
      return;
    }
    if(!administrador.existeDepartamentos()){
      System.out.println("No hay departamentos almacenados");
      return;
    }
    System.out.println("Ingrese el primer valor para el rango");
    int valorDpto1 = Integer.parseInt(lectura.readLine());
    System.out.println("Ingrese el segundo valor para el rango");
    int valorDpto2 = Integer.parseInt(lectura.readLine());     
    if(valorDpto1 < valorDpto2){
      administrador.mostrarDepartamentosPorPrecios(valorDpto1,valorDpto2);
      return;
    }
    administrador.mostrarDepartamentosPorPrecios(valorDpto2,valorDpto1);
  }

  public void mostrarDepartamentosPorOrientacion(Administrador administrador, String orientacionDpto)throws IOException{
    BufferedReader lectura = new  BufferedReader( new InputStreamReader( System.in));
    if(administrador.vacio()){
      System.out.println("No hay Edificios, ingrese Edificios para tener departamentos");
      return;
    }
    if(!administrador.existeDepartamentos()){
      System.out.println("No hay departamentos almacenados");
      return;
    }
    administrador.mostrarOrientacionDepartamentos(orientacionDpto);
  } 
  
    /* Lista de departamentos predeterminados*/
  public void cargarDepartamentos(Administrador administrador){
    if(administrador.getListaEdificio().size() >=3){
      administrador.agregarDepartamentoAedificio("1", "1","1", "2000", "Sur", 1, 2, 36,"Disponible");
      administrador.agregarDepartamentoAedificio("1", "1","2", "2000", "Sur", 1, 2, 36,"vendido");
      administrador.agregarDepartamentoAedificio("1", "2","3", "2000", "Norte", 1, 2, 36,"vendido");
      administrador.agregarDepartamentoAedificio("1", "2","4", "2000", "NorOeste", 1, 2, 36,"Disponible");         
      administrador.agregarDepartamentoAedificio("2", "1","1", "3500", "SurEste", 2, 3, 56,"vendido");
      administrador.agregarDepartamentoAedificio("2", "1","2", "3500", "SurOeste", 2, 3, 56,"vendido");
      administrador.agregarDepartamentoAedificio("2", "2","3", "3500", "NorEste", 2, 3, 56,"Disponible");
      administrador.agregarDepartamentoAedificio("2", "2","4", "3500", "Norte", 2, 3, 56,"Disponible");
      administrador.agregarDepartamentoAedificio("3", "1","1", "3420", "Este", 2, 3, 50,"vendido");
      administrador.agregarDepartamentoAedificio("3", "1","2", "3420", "SurOeste", 2, 3, 50,"Disponible");
      administrador.agregarDepartamentoAedificio("3", "2","3", "3420", "NorEste", 2, 3, 50,"vendido");
      administrador.agregarDepartamentoAedificio("3", "2","4", "3420", "NorOeste", 2, 3, 50,"Disponible");
      return;
    }
    System.out.println("Crear primero 3 edificios para acceder a esta opcion");
  }

      /*Llenado predeterminado*/
  public void cargarEdificios(Administrador administrador){
    administrador.agregarEdificios("Viana Miramar","Viana 161","Viña del mar","Roberto Rau");
    administrador.agregarEdificios("LADY","15 norte 242","Viña del mar","Mario Castañeda");
    administrador.agregarEdificios("10 norte","10 norte 655","Viña del mar","Quiroz y Puelma Arquitectos");
  } 

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