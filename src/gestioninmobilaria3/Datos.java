
package gestioninmobilaria3;
import java.io.*;

public class Datos{
  /*metodo para agregar edificios por consola*/
  public void agregarEdificio(Administrador administrador, int opcion)throws IOException{
    BufferedReader lectura = new  BufferedReader( new InputStreamReader( System.in));
    if(opcion == 2){
        System.out.println("Ingrese nombre del Hotel");
        String nombreEdificio = lectura.readLine();
        System.out.println("Ingrese direccion del Hotel");
        String direccionEdificio = lectura.readLine();   
        System.out.println("Ingrese localidad del Hotel");
        String localidadEdificio = lectura.readLine();
        System.out.println("Ingrese arquitecto del Hotel");
        String arquitectoEdificio = lectura.readLine();     
        System.out.println("Ingrese la cantidad de ESTRELLAS del Hotel");
        int cantEstrellas = verificacionNumerica();
        if(administrador.agregarEdificioHotel(nombreEdificio, direccionEdificio, localidadEdificio, arquitectoEdificio,cantEstrellas)){
            System.out.println("El Hotel  "+nombreEdificio + " tiene el id: "+administrador.getEdificiosNombre().get(nombreEdificio).getIdEdificio());
        }
        else
            System.out.println("Hotel " + nombreEdificio + " ya existe");
    }
    if(opcion == 3){
        System.out.println("Ingrese nombre del Motel");
        String nombreEdificio = lectura.readLine();
        System.out.println("Ingrese direccion del Motel");
        String direccionEdificio = lectura.readLine();   
        System.out.println("Ingrese localidad del Motel");
        String localidadEdificio = lectura.readLine();
        System.out.println("Ingrese arquitecto del Motel");
        String arquitectoEdificio = lectura.readLine();     
        System.out.println("Ingrese el precio por hora del Motel");
        int precioXHora = verificacionNumerica();
        if(administrador.agregarEdificioMotel(nombreEdificio, direccionEdificio, localidadEdificio, arquitectoEdificio,precioXHora)){
            System.out.println("El Motel  "+nombreEdificio + " tiene el id: "+administrador.getEdificiosNombre().get(nombreEdificio).getIdEdificio());
        }
        else
            System.out.println("Motel " + nombreEdificio + " ya existe");        
    }
    if(opcion == 1){
        System.out.println("Ingrese nombre del Edificio");
        String nombreEdificio = lectura.readLine();
        System.out.println("Ingrese direccion del Edificio");
        String direccionEdificio = lectura.readLine();   
        System.out.println("Ingrese localidad del Edificio");
        String localidadEdificio = lectura.readLine();
        System.out.println("Ingrese arquitecto del Edificio");
        String arquitectoEdificio = lectura.readLine();     
        if(administrador.agregarEdificio(nombreEdificio, direccionEdificio, localidadEdificio, arquitectoEdificio)){
            System.out.println("El Edificio  "+nombreEdificio + " tiene el id: "+administrador.getEdificiosNombre().get(nombreEdificio).getIdEdificio());
        }
        else
            System.out.println("Edificio " + nombreEdificio + " ya existe");           
    }
    
    
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
      int cantidadBanos = Integer.parseInt(lectura.readLine());
      System.out.println("Ingrese cantidad de dormitorios del departamento");
      int cantidadDormitorios = Integer.parseInt(lectura.readLine());
      System.out.println("Ingrese los metros cuadrados del departamento");
      int metrosCuadrados = Integer.parseInt(lectura.readLine());  
      System.out.println("Si el departamento esta disponible escriba: disponible, de lo contrario escriba: vendido :");  
      String disponibilidadDpto = lectura.readLine();          
      administrador.agregarDepartamentoAedificio(idEdificio, numeroPiso, numeroDpto, valorDpto, orientacion, cantidadBanos, cantidadDormitorios, metrosCuadrados,disponibilidadDpto);
      return;
    }
    System.out.println("El edifcio ingresado no existe");
  }


  
    /*muestra la lista de edificios si es que hay*/
  public void mostrarListadoDeEdifcios(Administrador administrador, int opcion) {
    if(administrador.getEdificiosId().isEmpty()){
      System.out.println("No existen Edificios");
      return;
    }
    if (opcion == 1){
      System.out.println("Id:  || Nombre Edificio || Dirección || Localidad || Arquitecto");
      for(Building edificio : administrador.getListaEdificio()){
          if(edificio instanceof Edificio){
             Edificio newedificio = (Edificio)edificio;
            System.out.println(newedificio.getIdEdificio()+": "+newedificio.getNombreEdificio()+" || "+newedificio.getDireccionEdificio()+" || "+newedificio.getLocalidadEdificio()+" || " +newedificio.getArquitectoEdificio());
        }
      }
      return;
    }   
    if (opcion == 2){
      System.out.println("Id:  || Nombre Hotel || Dirección || Localidad || Arquitecto || Cantidad de Estrellas");
      for(Building edificio : administrador.getListaEdificio()){
          if(edificio instanceof Hotel){
             Hotel hotel = (Hotel)edificio;
            System.out.println(hotel.getIdEdificio()+": "+hotel.getNombreEdificio()+" || "+hotel.getDireccionEdificio()+" || "+hotel.getLocalidadEdificio()+" || " +hotel.getArquitectoEdificio() + " || " + hotel.getCantidadEstrellas());
        }
      }
      return;
    }
    if(opcion == 3)
    {
       System.out.println("Id:  || Nombre Motel || Dirección || Localidad || Precio por hora");
       for(Building edificio : administrador.getListaEdificio()){
           if(edificio instanceof Motel){
               Motel motel = (Motel)edificio;
                System.out.println(motel.getIdEdificio()+": "+motel.getNombreEdificio()+" || "+motel.getDireccionEdificio()+" || "+motel.getLocalidadEdificio()+" || " +motel.getPrecioXHora());
        }
      }
      return;
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
//muestra todos los departamentos
  public void mostrarDepartamento(String idDepartamento,Administrador administrador){//Se seguieron las recomendaciones y se movieron al main todas las interacciones con el usuario
    for(int i = 0; i<administrador.getListaEdificio().size();i++){
      if(administrador.getListaEdificio().get(i).getDepartamentosId().containsKey(idDepartamento)){
        System.out.println("id: Numero de piso     numero de departamento            valor en uf                 orientacion               cantidad de baños            cantidad de dormitorios       metro cuadrados       disponibilidad departamento");
        System.out.println("     "+administrador.getListaEdificio().get(i).getDepartamentosId().get(idDepartamento).getIdDepartamento()+":            "+administrador.getListaEdificio().get(i).getDepartamentosId().get(idDepartamento).getNumeroPiso()+ "               "+administrador.getListaEdificio().get(i).getDepartamentosId().get(idDepartamento).getNumeroDpto()+"                              "+administrador.getListaEdificio().get(i).getDepartamentosId().get(idDepartamento).getValorDpto()+"                       "+administrador.getListaEdificio().get(i).getDepartamentosId().get(idDepartamento).getOrientacion()+"                         "+administrador.getListaEdificio().get(i).getDepartamentosId().get(idDepartamento).getCantidadBanos()+"                               "+administrador.getListaEdificio().get(i).getDepartamentosId().get(idDepartamento).getCantidadDormitorios()+"                          "+administrador.getListaEdificio().get(i).getDepartamentosId().get(idDepartamento).getMetrosCuadrados()+"                          "+administrador.getListaEdificio().get(i).getDepartamentosId().get(idDepartamento).getDisponibilidadDpto());  
        return;
      }
    }               
  }
  
  /*funcion para verificar que sea un numero y no un string*/
  public int verificacionNumerica() throws  IOException{
        BufferedReader leer = new  BufferedReader( new InputStreamReader( System.in));
        String numeroString;        
        while(true){
            numeroString = leer.readLine();
            if(numeroString.matches("[+-]?\\d*(\\.\\d+)?") && (numeroString.equals("")==false))
                break;
            else
                System.out.println("Ingrese un numero valido");
        }        
        int numeroInt = Integer.parseInt(numeroString);
        return numeroInt;  
    } 
  
  /*Muestra por pantalla los departamentos en los edificios que esten en un rango especificado por el usuario*/
  public void mostrarDepartamentosPorPrecios(Administrador administrador)throws IOException{
    if(administrador.vacio()){
      System.out.println("No hay Edificios, ingrese Edificios para tener departamentos");
      return;
    }
    if(!administrador.existeDepartamento()){
      System.out.println("No hay departamentos almacenados");
      return;
    }
    System.out.println("Ingrese el primer valor para el rango");
    int valorDpto1 = verificacionNumerica();
    System.out.println("Ingrese el segundo valor para el rango");
    int valorDpto2 = verificacionNumerica();     
    if(valorDpto1 < valorDpto2){
      administrador.mostrarDepartamentosPorPrecios(valorDpto1,valorDpto2);
      return;
    }
    administrador.mostrarDepartamentosPorPrecios(valorDpto2,valorDpto1);
  }
//muestra los departasmentos por orientacion que decida el usuario
  public void mostrarDepartamentosPorOrientacion(Administrador administrador, String orientacionDpto)throws IOException{
    if(administrador.vacio()){
      System.out.println("No hay Edificios, ingrese Edificios para tener departamentos");
      return;
    }
    if(!administrador.existeDepartamento()){
      System.out.println("No hay departamentos almacenados");
      return;
    }
    administrador.mostrarOrientacionDepartamentos(orientacionDpto);
  } 
  
    /* Lista de departamentos predeterminados*/
  public void cargarDepartamentos(Administrador administrador){
    if(administrador.getListaEdificio().size() >=3){
      administrador.agregarDepartamentoAedificio("1", "1","110", "2000", "Sur", 1, 2, 36,"Disponible");
      administrador.agregarDepartamentoAedificio("1", "1","120", "2000", "Sur", 1, 2, 36,"vendido");
      administrador.agregarDepartamentoAedificio("1", "1","130", "2600", "Norte", 2, 3, 45,"vendido");
      administrador.agregarDepartamentoAedificio("1", "1","140", "2600", "NorOeste", 2, 3, 45,"Disponible");
      administrador.agregarDepartamentoAedificio("1", "2","210", "2400", "NorOeste", 2, 2, 40,"vendido");
      administrador.agregarDepartamentoAedificio("1", "2","220", "2400", "Oeste", 2, 2, 40,"vendido");
      administrador.agregarDepartamentoAedificio("1", "2","230", "2890", "Oeste", 2, 3, 45,"vendido");
      administrador.agregarDepartamentoAedificio("2", "2","240", "3290", "Este", 2, 4, 60,"Disponible");
      administrador.agregarDepartamentoAedificio("2", "2","250", "2000", "Este", 1, 2, 36,"Disponible");
      administrador.agregarDepartamentoAedificio("2", "3","110", "2000", "Sur", 1, 2, 36,"Disponible");
      administrador.agregarDepartamentoAedificio("2", "3","120", "2000", "Sur", 1, 2, 36,"vendido");
      administrador.agregarDepartamentoAedificio("2", "3","130", "2600", "Norte", 2, 3, 45,"vendido");
      administrador.agregarDepartamentoAedificio("2", "3","140", "2600", "NorOeste", 2, 3, 45,"Disponible");
      administrador.agregarDepartamentoAedificio("2", "3","210", "2400", "NorOeste", 2, 2, 40,"vendido");
      administrador.agregarDepartamentoAedificio("3", "4","220", "2400", "Oeste", 2, 2, 40,"vendido");
      administrador.agregarDepartamentoAedificio("3", "4","230", "2890", "Oeste", 2, 3, 45,"vendido");
      administrador.agregarDepartamentoAedificio("3", "4","240", "3290", "Este", 2, 4, 60,"Disponible");
      administrador.agregarDepartamentoAedificio("3", "4","250", "2000", "Este", 1, 2, 36,"Disponible");
      administrador.agregarDepartamentoAedificio("3", "1","11", "3500", "SurEste", 2, 3, 56,"vendido");
      administrador.agregarDepartamentoAedificio("3", "1","12", "3500", "SurOeste", 2, 3, 56,"vendido");
      administrador.agregarDepartamentoAedificio("3", "1","13", "3500", "NorEste", 2, 3, 56,"Disponible");
      administrador.agregarDepartamentoAedificio("4", "1","14", "3500", "Norte", 2, 3, 56,"Disponible");
      administrador.agregarDepartamentoAedificio("4", "2","21", "2000", "Sur", 1, 2, 36,"Disponible");
      administrador.agregarDepartamentoAedificio("4", "2","22", "2000", "Sur", 1, 2, 36,"vendido");
      administrador.agregarDepartamentoAedificio("4", "2","23", "2600", "Norte", 2, 3, 45,"vendido");
      administrador.agregarDepartamentoAedificio("4", "2","24", "2600", "NorOeste", 2, 3, 45,"Disponible");
      administrador.agregarDepartamentoAedificio("4", "3","31", "2400", "NorOeste", 2, 2, 40,"vendido");
      administrador.agregarDepartamentoAedificio("4", "3","32", "2400", "Oeste", 2, 2, 40,"vendido");
      administrador.agregarDepartamentoAedificio("5", "3","33", "2890", "Oeste", 2, 3, 45,"vendido");
      administrador.agregarDepartamentoAedificio("5", "3","34", "3290", "Este", 2, 4, 60,"Disponible");
      administrador.agregarDepartamentoAedificio("5", "3","35", "2000", "Este", 1, 2, 36,"Disponible");
      administrador.agregarDepartamentoAedificio("5", "4","41", "2000", "Sur", 1, 2, 36,"Disponible");
      administrador.agregarDepartamentoAedificio("5", "4","42", "2000", "Sur", 1, 2, 36,"vendido");
      administrador.agregarDepartamentoAedificio("5", "4","43", "2600", "Norte", 2, 3, 45,"vendido");
      administrador.agregarDepartamentoAedificio("5", "4","44", "2600", "NorOeste", 2, 3, 45,"Disponible");
      administrador.agregarDepartamentoAedificio("6", "4","51", "2400", "NorOeste", 2, 2, 40,"vendido");
      administrador.agregarDepartamentoAedificio("6", "5","52", "2400", "Oeste", 2, 2, 40,"vendido");
      administrador.agregarDepartamentoAedificio("6", "5","53", "2890", "Oeste", 2, 3, 45,"vendido");
      administrador.agregarDepartamentoAedificio("6", "5","54", "3290", "Este", 2, 4, 60,"Disponible");
      administrador.agregarDepartamentoAedificio("6", "5","55", "2000", "Este", 1, 2, 36,"Disponible");
      administrador.agregarDepartamentoAedificio("6", "1","1", "3420", "Este", 2, 3, 50,"vendido");
      administrador.agregarDepartamentoAedificio("6", "1","2", "3420", "SurOeste", 2, 3, 50,"Disponible");
      administrador.agregarDepartamentoAedificio("7", "1","3", "3420", "NorEste", 2, 3, 50,"vendido");
      administrador.agregarDepartamentoAedificio("7", "1","4", "3420", "NorOeste", 2, 3, 50,"Disponible");
      administrador.agregarDepartamentoAedificio("7", "1","11", "3500", "SurEste", 2, 3, 56,"vendido");
      administrador.agregarDepartamentoAedificio("7", "1","12", "3500", "SurOeste", 2, 3, 56,"vendido");
      administrador.agregarDepartamentoAedificio("7", "2","13", "3500", "NorEste", 2, 3, 56,"Disponible");
      administrador.agregarDepartamentoAedificio("7", "2","14", "3500", "Norte", 2, 3, 56,"Disponible");
      administrador.agregarDepartamentoAedificio("7", "2","15", "2000", "Sur", 1, 2, 36,"Disponible");
      administrador.agregarDepartamentoAedificio("8", "2","16", "2000", "Sur", 1, 2, 36,"vendido");
      administrador.agregarDepartamentoAedificio("8", "2","17", "2600", "Norte", 2, 3, 45,"vendido");
      administrador.agregarDepartamentoAedificio("8", "2","18", "2600", "NorOeste", 2, 3, 45,"Disponible");
      administrador.agregarDepartamentoAedificio("8", "3","20", "2400", "NorOeste", 2, 2, 40,"vendido");
      administrador.agregarDepartamentoAedificio("8", "3","22", "2400", "Oeste", 2, 2, 40,"vendido");
      administrador.agregarDepartamentoAedificio("8", "3","23", "2890", "Oeste", 2, 3, 45,"vendido");
      administrador.agregarDepartamentoAedificio("8", "3","24", "3290", "Este", 2, 4, 60,"Disponible");
      administrador.agregarDepartamentoAedificio("9", "3","25", "2000", "Este", 1, 2, 36,"Disponible");
      administrador.agregarDepartamentoAedificio("9", "4","31", "2000", "Sur", 1, 2, 36,"Disponible");
      administrador.agregarDepartamentoAedificio("9", "4","33", "2000", "Sur", 1, 2, 36,"vendido");
      administrador.agregarDepartamentoAedificio("9", "4","34", "2600", "Norte", 2, 3, 45,"vendido");
      administrador.agregarDepartamentoAedificio("9", "4","36", "2600", "NorOeste", 2, 3, 45,"Disponible");
      administrador.agregarDepartamentoAedificio("9", "4","37", "2400", "NorOeste", 2, 2, 40,"vendido");
      administrador.agregarDepartamentoAedificio("9", "5","45", "2400", "Oeste", 2, 2, 40,"vendido");

      return;
    }
    System.out.println("Crear primero 3 edificios para acceder a esta opcion");
  }

      /*Llenado predeterminado*/
  public void cargarEdificios(Administrador administrador){
    administrador.agregarEdificio("Vista parque","Los Médanos 129","Reñaca","Roberto Rau");
    administrador.agregarEdificio("Bordemar","Las Perlas 2204","Reñaca","Loreto Isla");
    administrador.agregarEdificio("Alto Jardín","av.Antofagasta 105","Reñaca","Ismael Loyi");
    administrador.agregarEdificioHotel("Viana Miramar","Viana 161","Viña del mar","Roberto Rau", 5);
    administrador.agregarEdificioHotel("LADY","15 norte 242","Viña del mar","Mario Castañeda",4);
    administrador.agregarEdificioHotel("10 norte","10 norte 655","Viña del mar","Quiroz y Puelma Arquitectos",13000);
    administrador.agregarEdificioMotel("Motel Sunset","calle Bellavista 947","viña del mar","Oriel Badillo",20000);
    administrador.agregarEdificioMotel("Motel adeux","camino internacional 380","viña del mar","Constanza Arancibia",25000);
    administrador.agregarEdificioMotel("Motel Marina Suit", "11 Nte.760","viña del mar","javier acuña",10000);
  } 
//modifica el nombre de un edificio
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
  //elimina un edificio especifico
  public void eliminarUnEdificio(Administrador administrador)throws IOException{
    if(administrador.vacio()){
      System.out.println("No existen Edificios");
      return;
    }
    BufferedReader lectura = new BufferedReader( new InputStreamReader( System.in));
    System.out.println("Ingrese id del edificio que quiere eliminar");
    String idEdificio = lectura.readLine();
    Building edificioEliminado = administrador.eliminarEdificioDeAdministrador(idEdificio);
      System.out.println("El edificio "+edificioEliminado.getNombreEdificio()+ " ha sido eliminado");
  }

  //elimina un departamendo especifico de un edificio especifico
  public void eliminarUnDepartamento(Administrador administrador)throws IOException, InterruptedException{
    if(administrador.vacio()){
      System.out.println("No existen Edificios");
      return;
    }
    BufferedReader lectura = new BufferedReader( new InputStreamReader( System.in));
    System.out.println("A continuacion se mostraran el listado de edificos con sus departamentos");
    Thread.sleep(500);
    mostrarTodosLosDepartamentos(administrador);
    Thread.sleep(500);
    System.out.println("Ingrese el Id del edificio donde se encuentre el departamento: ");
    String idEdificio = lectura.readLine();
    if(administrador.getEdificiosId().containsKey(idEdificio)){
        System.out.println("Ingre el Id del departamento que quiera eliminar");
        String idDepartamento = lectura.readLine();
        administrador.eliminarDepartamentoEnEdificio(idDepartamento, idEdificio);        
    } else {
        System.out.println("La opcion ingresada no es valida");
      }
  }
}