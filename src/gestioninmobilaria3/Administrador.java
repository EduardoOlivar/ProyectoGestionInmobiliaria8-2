package gestioninmobilaria3;
import java.util.*;

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
    private boolean agregarEdificios(Edificio edificio){
        if(edificiosNombre.containsKey(edificio.getNombre())){
            return false;
        }
        listaEdificio.add(edificio);
        edificiosId.put(edificio.getId(), edificio);
        edificiosNombre.put(edificio.getNombre(), edificio);
        return true;
    }
    
    //metodo2 que recive la instancia de un edificio nuevo y lo envia por parametro al agregarEdicios metodo 1;
    public boolean agregarEdificios(String nombre, String direccion, String localidad, String arquitecto){
        this.idAdministrador = this.idAdministrador + 1;
        Edificio nuevoEdificio = new Edificio(String.valueOf(idAdministrador),nombre,direccion,localidad,arquitecto);
        if(this.agregarEdificios(nuevoEdificio))
            return true;
        return false;
    }
   
    public void modificarNombreEdificio(String nombre, String idEdificio){
        for (int i = 0; i < listaEdificio.size(); i++) {
            if(listaEdificio.get(i).getId().equals(idEdificio)){
                listaEdificio.get(i).setNombre(nombre);
                edificiosId.get(idEdificio).setNombre(nombre);
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
    
    public boolean existeDepartamentos(){
        int i;
        for (i = 0; i < listaEdificio.size(); i++) {
            if(listaEdificio.get(i).existeDepartamento()){
              return true;
            }
        }
        return false;        
    }    

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
    
    public void agregarDepartamentoAedificio(String idEdificio,String numeroPiso,String numeroDpto, String valorDpto, String orientacion, int cantidadBaños, int cantidadDormitorios, double metrosCuadrados, String disponibilidadDpto){
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
          
            Departamento nuevoDepartamento = new Departamento(String.valueOf(idDpto),numeroPiso,numeroDpto,valorDpto,orientacion,cantidadBaños,cantidadDormitorios,metrosCuadrados,disponibilidadDpto);                
            edificiosId.get(idEdificio).agregarDepartamento(String.valueOf(idDpto),numeroPiso,numeroDpto,valorDpto,orientacion,cantidadBaños,cantidadDormitorios,metrosCuadrados,disponibilidadDpto);
            return;           
        }
    }
    // retorna si esta vacio
    public boolean vacio(){return listaEdificio.isEmpty();}
    // retorna si hay edficio o no 
    public boolean existeEdifcio(String idEdificio){return edificiosId.containsKey(idEdificio);}
    
    // elimina edificio a partir de su id
    public Edificio  eliminarEdificio(String idEdificio){
        if(!edificiosId.containsKey(idEdificio)){
            System.out.println("No existe un Edificio con el id ingresado");
            return null;

        }
        if(listaEdificio.size()<2){
            System.out.println("no existe otro edificio, por lo que todos los datos seran eliminados");
            Edificio edificioEliminado = edificiosId.remove(idEdificio);
            int i;
            for (i = 0; i < listaEdificio.size(); i++) {
                if(listaEdificio.get(i).getId().equals(idEdificio)){
                    listaEdificio.remove(i);
                    break;
                }
            }
                listaEdificio.get(i).eliminarDepartamentos();
                this.idAdministrador = 0;
                return edificioEliminado;
            
        }
        Edificio edificioEliminado = edificiosId.remove(idEdificio);
        int i;
        for ( i = 0; i < listaEdificio.size(); i++) {
            //se busca edificio en la lista para luego eliminarlo
            if (listaEdificio.get(i).getId().equals(idEdificio)) {
                listaEdificio.remove(i);//lista
                break;
            }
        }
        return edificioEliminado;
    }
    
    public void eliminarDepartamento(String idDepartamento,String nombreEd){
        for (int i = 0; i < listaEdificio.size(); i++) {
            if(listaEdificio.get(i).getId().equals(nombreEd)){
                listaEdificio.get(i).eliminarDepartamento(idDepartamento);
                return;
            }else{
                    System.out.println("La opcion ingresada no es valida...");
                    break;
                 }   
        }
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
                    System.out.println("Lista de Departamentos del edificio "+listaEdificio.get(i).getNombre());
                    listaEdificio.get(i).mostrarDepartamento();
            }
        }
    }
    /* Funcion para mostrar los dptos por precio */
    public void mostrarDepartamentosPorPrecios(int valorInicial, int valorFinal)
    {
      for(int i = 0 ; i < listaEdificio.size(); i++)
      {
          System.out.println("En el edificio "+ listaEdificio.get(i).getNombre());
          listaEdificio.get(i).mostrarDptosPorPrecios(valorInicial, valorFinal);
      }
    }
    public void mostrarOrientacionDepartamentos(String orientacion)
    {
      for(int i = 0 ;i <  listaEdificio.size();i++)
      {
        System.out.println("En el edificio "+ listaEdificio.get(i).getNombre());
        listaEdificio.get(i).mostrarDptosPorOrientacion(orientacion);
      }
    }


    
    //getter
    public ArrayList<Edificio> getListaEdificio() {return listaEdificio;}
    public HashMap<String,Edificio>getEdificiosNombre(){return edificiosNombre;}
    public HashMap<String,Edificio>getEdificiosId(){return edificiosId;}
    public int getIdAdministrador() {return idAdministrador;}
    //setter
    public void setIdAdministrador(int idEdificio) {this.idAdministrador = idAdministrador;}
}
