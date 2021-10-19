package gestioninmobilaria3;

import java.util.*;
import java.io.*;

public class Administrador {
    
    private ArrayList<Edificio> listaEdificio; // lista de edificios
    private HashMap<String,Edificio>edificiosId; // Mapa EdificiosId que facilita el buscado de edificio por su clave id   
    private HashMap<String,Edificio>edificiosNombre;// Mapa edificiosNombre, buscamos por nombre de edificio. 
    private int idAdministrador;



    public Administrador() {
        listaEdificio = new ArrayList();
        edificiosId = new HashMap();
        edificiosNombre = new HashMap();
        idAdministrador = 0;

    }
    //metodo privado que agregarEdificios,verifica si ya existe el edificio. si no existe los agrega al mapa edficiosId y listaEdificios
    private boolean agregarEdificio(Edificio edificio){
        if(edificiosNombre.containsKey(edificio.getNombreEdificio())){
            return false;
        }
        listaEdificio.add(edificio);
        edificiosId.put(edificio.getIdEdificio(), edificio);
        edificiosNombre.put(edificio.getNombreEdificio(), edificio);
        return true;
    }
    
    //metodo2 que recive la instancia de un edificio nuevo y lo envia por parametro al agregarEdicios metodo 1;
    public boolean agregarEdificio(String nombre, String direccion, String localidad, String arquitecto,int estrellas){
        this.idAdministrador = this.idAdministrador + 1;
        Edificio nuevoEdificio = new Hotel(String.valueOf(idAdministrador),nombre,direccion,localidad,arquitecto,estrellas);
        if(this.agregarEdificio(nuevoEdificio))
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
    public void agregarDepartamentoAedificio(String idEdificio,String numeroPiso,String numeroDpto, String valorDpto, String orientacion, int cantidadBanos, int cantidadDormitorios, double metrosCuadrados, String disponibilidadDpto){
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
            edificiosId.get(idEdificio).agregarDepartamento(String.valueOf(idDpto),numeroPiso,numeroDpto,valorDpto,orientacion,cantidadBanos,cantidadDormitorios,metrosCuadrados,disponibilidadDpto);
            return;           
        }
    }
    // retorna si esta vacio
    public boolean vacio(){return listaEdificio.isEmpty();}
    // retorna si hay edficio o no 
    public boolean existeEdifcio(String idEdificio){return edificiosId.containsKey(idEdificio);}
    
    // elimina edificio a partir de su id
    public Edificio  eliminarEdificioDeAdministrador(String idEdificio){
        if(!edificiosId.containsKey(idEdificio)){
            System.out.println("No existe un Edificio con el id ingresado");
            return null;

        }
        if(listaEdificio.size()<2){
            System.out.println("no existe otro edificio, por lo que todos los datos seran eliminados");
            Edificio edificioEliminado = edificiosId.remove(idEdificio);
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
        Edificio edificioEliminado = edificiosId.remove(idEdificio);
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
                    System.out.println("Id del edificio: "+listaEdificio.get(i).getIdEdificio()+", Departamentos en el edificio "+listaEdificio.get(i).getNombreEdificio());
                    listaEdificio.get(i).mostrarDepartamento();
            }
        }
    }
    /* Funcion para mostrar los dptos por precio */
    public void mostrarDepartamentosPorPrecios(int valorInicial, int valorFinal)
    {
      for(int i = 0 ; i < listaEdificio.size(); i++)
      {
          System.out.println("En el edificio "+ listaEdificio.get(i).getNombreEdificio());
          listaEdificio.get(i).mostrarDptosPorPrecios(valorInicial, valorFinal);
      }
    }
    //entra a la lista de edificios para buscar los departamentos
    public void mostrarOrientacionDepartamentos(String orientacion)
    {
      for(int i = 0 ;i <  listaEdificio.size();i++)
      {
        System.out.println("En el edificio "+ listaEdificio.get(i).getNombreEdificio());
        listaEdificio.get(i).mostrarDptosPorOrientacion(orientacion);
      }
    }
    
    //getter
    public ArrayList<Edificio> getListaEdificio() {return listaEdificio;}
    public HashMap<String,Edificio>getEdificiosNombre(){return edificiosNombre;}
    public HashMap<String,Edificio>getEdificiosId(){return edificiosId;}
    public int getIdAdministrador() {return idAdministrador;}
    //setter
    public void setIdAdministrador(int idAdministrador) {this.idAdministrador = idAdministrador;}
}