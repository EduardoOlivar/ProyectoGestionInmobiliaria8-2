package gestioninmobilaria3;

import java.util.*;
import java.io.*;

public class Administrador {
    
    private ArrayList<Building> listaEdificio; // lista de edificios
    private HashMap<String,Building>edificiosId; // Mapa EdificiosId que facilita el buscado de edificio por su clave id   
    private HashMap<String,Building>edificiosNombre;// Mapa edificiosNombre, buscamos por nombre de edificio. 
    private int idAdministrador;



    public Administrador() {
        listaEdificio = new ArrayList();
        edificiosId = new HashMap();
        edificiosNombre = new HashMap();
        idAdministrador = 0;

    }
    //metodo privado que agregarEdificios,verifica si ya existe el edificio. si no existe los agrega al mapa edficiosId y listaEdificios
    private boolean agregarEdificio(Building edificio){
        if(edificiosNombre.containsKey(edificio.getNombreEdificio())){
            return false;
        }
        listaEdificio.add(edificio);
        edificiosId.put(edificio.getIdEdificio(), edificio);
        edificiosNombre.put(edificio.getNombreEdificio(), edificio);
        return true;
    }
    
    //metodo2 que recive la instancia de un edificio nuevo y lo envia por parametro al agregarEdicios metodo 1;
    public boolean agregarEdificioEdificio(String nombre, String direccion, String localidad, String arquitecto,String nombreConserje){
        this.idAdministrador = this.idAdministrador + 1;
        Edificio nuevoEdificio = new Edificio(String.valueOf(idAdministrador),nombre,direccion,localidad,arquitecto,nombreConserje) ;
        if(this.agregarEdificio(nuevoEdificio))
            return true;
        return false;
    }
    
    public boolean agregarEdificioHotel(String nombre, String direccion, String localidad, String arquitecto,int estrellas){
        this.idAdministrador = this.idAdministrador + 1;
        Hotel newhotel = new Hotel(String.valueOf(idAdministrador),nombre,direccion,localidad,arquitecto,estrellas);
        if(this.agregarEdificio(newhotel))
            return true;
        return false;
    }
    
    public boolean agregarEdificioMotel(String nombre, String direccion, String localidad, String arquitecto,int precioPorHoras){
        this.idAdministrador = this.idAdministrador + 1;
        Motel newmotel = new Motel(String.valueOf(idAdministrador),nombre,direccion,localidad,arquitecto,precioPorHoras);
        if(this.agregarEdificio(newmotel))
            return true;
        return false;
    } 
    public void modificarNombreEdificio(String nombre, String idEdificio){
        for (int i = 0; i < listaEdificio.size(); i++) {
            if(listaEdificio.get(i).getIdEdificio().equals(idEdificio)){
                listaEdificio.get(i).setNombreEdificio(nombre);
                edificiosId.get(idEdificio).setNombreEdificio(nombre);
            }
        }
    }
    
    
    public boolean existeDepartamento(String idDepartamento){
        int i;
        for ( i = 0; i < listaEdificio.size(); i++) {
            if(listaEdificio.get(i).existeDepartamento(idDepartamento));
            return true;
        }
        return false;        
    } 
    
    public boolean existeDepartamento(){
        int i;
        for (i = 0; i < listaEdificio.size(); i++) {
            if(listaEdificio.get(i).existeDepartamento()){
              return true;
            }
        }
        return false;        
    }    
//busca departamento para ver si existe o no 
    public boolean BuscarDepartamento(String idDepartamento){
        if(vacio()){
            System.out.println("No existen departamentos");
            return false;
        }
        else{
            int i;
            for(i = 0; i<listaEdificio.size();i++){
                if(listaEdificio.get(i).BuscarDepartamento(idDepartamento))
                  return true;
            }
            return false;
        }
    }
    //agrega departamento a edificio especifico
    public void agregarDepartamentoAEdificio(String idEdificio,String numeroPiso,String numeroDpto, String valorDpto, String orientacion, int cantidadBanos, int cantidadDormitorios, double metrosCuadrados,String disponibilidadDpto){
        if(edificiosId.containsKey(idEdificio)){      
            int idDpto = 0;
            for (int i = 0; i<listaEdificio.size(); i++) {
                for (int j = 0; j < listaEdificio.get(i).getDepartamentos().size(); j++) {
                    if(existeDepartamento(String.valueOf(idDpto))){
                        idDpto = idDpto + 1;
                    }
                    else
                        break;
                }
            }   
            Departamento nuevoDepartamento = new Departamento(String.valueOf(idDpto),numeroPiso,numeroDpto,valorDpto,orientacion,cantidadBanos,cantidadDormitorios,metrosCuadrados,disponibilidadDpto);             
            edificiosId.get(idEdificio).agregarDepartamentoEdificio(String.valueOf(idDpto),numeroPiso,numeroDpto,valorDpto,orientacion,cantidadBanos,cantidadDormitorios,metrosCuadrados,disponibilidadDpto);
            return;           
        }
    }
    
    public void agregarDepartamentoAHotel(String idEdificio,String numeroPiso,String numeroDpto, String valorDpto, String orientacion, int cantidadBanos, int cantidadDormitorios, double metrosCuadrados,String disponibilidadDpto,int cantidadDiasArrendado){
        if(edificiosId.containsKey(idEdificio)){      
            int idDpto = 0;
            for (int i = 0; i<listaEdificio.size(); i++) {
                for (int j = 0; j < listaEdificio.get(i).getDepartamentos().size(); j++) {
                    if(existeDepartamento(String.valueOf(idDpto))){
                        idDpto = idDpto + 1;
                    }
                    else
                        break;
                }
            }
          
            DepartamentoArrendado nuevoDepartamento = new DepartamentoArrendado(String.valueOf(idDpto),numeroPiso,numeroDpto,valorDpto,orientacion,cantidadBanos,cantidadDormitorios,metrosCuadrados,disponibilidadDpto,cantidadDiasArrendado);            
            edificiosId.get(idEdificio).agregarDepartamentoHotel(String.valueOf(idDpto), numeroPiso, numeroDpto, valorDpto, orientacion, cantidadBanos, cantidadDormitorios, metrosCuadrados,disponibilidadDpto ,cantidadDiasArrendado);
            return;           
        }
    }
    public void agregarDepartamentoAMotel(String idEdificio,String numeroPiso,String numeroDpto, String valorDpto, String orientacion, int cantidadBanos, int cantidadDormitorios, double metrosCuadrados,String disponibilidadDpto, String tematica){
        if(edificiosId.containsKey(idEdificio)){      
            int idDpto = 0;
            for (int i = 0; i<listaEdificio.size(); i++) {
                for (int j = 0; j < listaEdificio.get(i).getDepartamentos().size(); j++) {
                    if(existeDepartamento(String.valueOf(idDpto))){
                        idDpto = idDpto + 1;
                    }
                    else
                        break;
                }
            }
          
            DepartamentoTematica nuevoDepartamento = new DepartamentoTematica(String.valueOf(idDpto),numeroPiso,numeroDpto,valorDpto,orientacion,cantidadBanos,cantidadDormitorios,metrosCuadrados,disponibilidadDpto,tematica);                
            edificiosId.get(idEdificio).agregarDepartamentoMotel(String.valueOf(idDpto),numeroPiso,numeroDpto,valorDpto,orientacion,cantidadBanos,cantidadDormitorios,metrosCuadrados, disponibilidadDpto,tematica);
            return;           
        }
    }
    // retorna si esta vacio
    public boolean vacio(){return listaEdificio.isEmpty();}
    // retorna si hay edficio o no 
    public boolean existeEdifcio(String idEdificio){return edificiosId.containsKey(idEdificio);}
    
    // elimina edificio a partir de su id
    public Building  eliminarEdificioDeAdministrador(String idEdificio){
        if(!edificiosId.containsKey(idEdificio)){
            System.out.println("No existe un Edificio con el id ingresado");
            return null;

        }
        if(listaEdificio.size()<2){
            System.out.println("no existe otro edificio, por lo que todos los datos seran eliminados");
            Building edificioEliminado = edificiosId.remove(idEdificio);
            int i;
            for (i = 0; i < listaEdificio.size(); i++) {
                if(listaEdificio.get(i).getIdEdificio().equals(idEdificio)){
                    listaEdificio.remove(i);
                    break;
                }
            }
                listaEdificio.get(i).eliminarDepartamento();
                this.idAdministrador = 0;
                return edificioEliminado;
            
        }
        Building edificioEliminado = edificiosId.remove(idEdificio);
        int i;
        for ( i = 0; i < listaEdificio.size(); i++) {
            //se busca edificio en la lista para luego eliminarlo
            if (listaEdificio.get(i).getIdEdificio().equals(idEdificio)) {
                listaEdificio.remove(i);//lista
                break;
            }
        }
        return edificioEliminado;
    }
    // entra a la lista de edificios y busca el departamento a eliminar
    public void eliminarDepartamentoEnEdificio(String idDepartamento,String idEdificio){
        for (int i = 0; i < listaEdificio.size(); i++) {
            if(listaEdificio.get(i).getIdEdificio().equals(idEdificio)){
                listaEdificio.get(i).eliminarDepartamento(idDepartamento);
                return;
            } 
        }
        System.out.println("La opcion ingresada no es valida...");

    }
    
        //muestra todos los departamentos en la lista
    public void mostrarTodosLosDepartamentos(){
        if(listaEdificio.isEmpty() ){
            System.out.println("No existen departamentos");
        }
        else{
            for (int i = 0; i < listaEdificio.size(); i++) {
                if(listaEdificio.get(i).getDepartamentos().isEmpty()){
                    System.out.println("La lista de Departamentos está vacía");
                    return;
                }
                    System.out.println("Id: "+listaEdificio.get(i).getIdEdificio()+", Departamentos en "+listaEdificio.get(i).getNombreEdificio());
                    listaEdificio.get(i).mostrarDepartamento();
            }
        }
    }
    
    //muestra todos lso departamentos que hay dentro de la lista a la que se llama puede ser edificio, hotel, o motel.
    public void mostrarTodosLosDepartamentos(int opcion)
    {
        if(listaEdificio.isEmpty() ){
            System.out.println("No existen departamentos");
        }
        else
        {
            if (opcion == 1)
            {
                for (Building edificio : listaEdificio) 
                {                    
                    if(edificio instanceof Edificio)
                    {
                        Edificio newedificio = (Edificio)edificio;
                        System.out.println("Id: "+newedificio.getIdEdificio()+", Departamentos en "+newedificio.getNombreEdificio());
                        newedificio.mostrarDepartamento();
                    }
                }
            }
            if (opcion == 2)
            {
                for (Building edificio : listaEdificio) 
                {
                    if(edificio instanceof Hotel)
                    {
                        Hotel hotel = (Hotel)edificio;
                        System.out.println("Id: "+hotel.getIdEdificio()+", Departamentos en "+hotel.getNombreEdificio());
                        hotel.mostrarDepartamento();
                    }
                }
            }
            if (opcion == 3)
            {
                for (Building edificio : listaEdificio) 
                {
                    if(edificio instanceof Motel)
                    {
                        Motel motel = (Motel)edificio;
                        System.out.println("Id: "+motel.getIdEdificio()+", Departamentos en "+motel.getNombreEdificio());
                        motel.mostrarDepartamento();
                    }
                  }
            }                       
        }
    }
    /* Funcion para mostrar los dptos por precio */
    public void mostrarDepartamentosPorPrecios(int valorInicial, int valorFinal)
    {
      for(int i = 0 ; i < listaEdificio.size(); i++)
      {
          System.out.println("En "+ listaEdificio.get(i).getNombreEdificio());
          listaEdificio.get(i).mostrarDptosPorPrecios(valorInicial, valorFinal);
      }
    }
    //entra a la lista de edificios para buscar los departamentos
    public void mostrarOrientacionDepartamentos(String orientacion)
    {
      for(int i = 0 ;i <  listaEdificio.size();i++)
      {
        System.out.println("En "+ listaEdificio.get(i).getNombreEdificio());
        listaEdificio.get(i).mostrarDptosPorOrientacion(orientacion);
      }
    }    

    //getter
    public ArrayList<Building> getListaEdificio() {return listaEdificio;}
    public HashMap<String,Building>getEdificiosNombre(){return edificiosNombre;}
    public HashMap<String,Building>getEdificiosId(){return edificiosId;}
    public int getIdAdministrador() {return idAdministrador;}
    //setter
    public void setIdAdministrador(int idAdministrador) {this.idAdministrador = idAdministrador;}
}