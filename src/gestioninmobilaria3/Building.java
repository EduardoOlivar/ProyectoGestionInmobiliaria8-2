package gestioninmobilaria3;
import java.util.*;


public abstract class Building
{
    private String idEdificio;
    private String nombreEdificio;
    private String direccionEdificio;
    private String localidadEdificio;
    private String arquitectoEdificio;
    private ArrayList<Departamento> listaDepartamentos;
    private HashMap<String,Departamento>departamentosId; //mapa departamentosId que facilita la bisqueda de un departamento por id;

    //constructor
    public Building(){}
    public Building(String idEdificio ,String nombreEdificio, String direccionEdificio, String localidadEdificio, String arquitectoEdificio)
    {
        this.idEdificio = idEdificio;
        this.nombreEdificio = nombreEdificio;
        this.direccionEdificio = direccionEdificio;
        this.localidadEdificio = localidadEdificio;
        this.arquitectoEdificio = arquitectoEdificio;
        this.listaDepartamentos = new ArrayList(); // por ahora ira asi para poder hacer el entregable 2
        departamentosId = new HashMap();
             
    }

    // metodo privado 1 para agregarDepartamento al mapa y coleccions, privado para que no se llame antes que el metodo 2 agregarDepartamento
    private void agregarDepartamento(Departamento departamento)
    {
        if(departamentosId.containsKey(departamento.getIdDepartamento())){
            System.out.println("El Departamento ya existe");
            return;
        }
        departamentosId.put(departamento.getIdDepartamento(), departamento);
        listaDepartamentos.add(departamento);
    }
    
       /*metodo 2 que que llama 1 al primer metodo agregar departamento para mandarle la instancia de este*/
    public void agregarDepartamentoEdificio(String idDepartamento,String numeroPiso,String numeroDpto, String valorDpto, String orientacion, int cantidadBanos, int cantidadDormitorios, double metrosCuadrados, String disponibilidadDpto)
    {
        Departamento departamento = new Departamento(idDepartamento,numeroPiso,numeroDpto,valorDpto,orientacion,cantidadBanos,cantidadDormitorios,metrosCuadrados,disponibilidadDpto);
        this.agregarDepartamento(departamento);     
    } 
    public void agregarDepartamentoHotel(String idDepartamento,String numeroPiso,String numeroDpto, String valorDpto, String orientacion, int cantidadBanos, int cantidadDormitorios, double metrosCuadrados,String disponibilidadDpto,int cantidadDiasArrendado)
    {
        DepartamentoArrendado departamento = new DepartamentoArrendado(idDepartamento,numeroPiso,numeroDpto,valorDpto,orientacion,cantidadBanos,cantidadDormitorios,metrosCuadrados,disponibilidadDpto,cantidadDiasArrendado);
        this.agregarDepartamento(departamento);     
    }     
    public void agregarDepartamentoMotel(String idDepartamento,String numeroPiso,String numeroDpto, String valorDpto, String orientacion, int cantidadBanos, int cantidadDormitorios, double metrosCuadrados,String disponibilidadDpto ,String tematica)
    {
        DepartamentoTematica departamento = new DepartamentoTematica(idDepartamento,numeroPiso,numeroDpto,valorDpto,orientacion,cantidadBanos,cantidadDormitorios,metrosCuadrados,disponibilidadDpto,tematica);
        this.agregarDepartamento(departamento);     
    } 
    public void eliminarDepartamento(){
             departamentosId = new HashMap();
             listaDepartamentos = new ArrayList();
    }
    
    public void eliminarDepartamento(String idDepartamento){
        if (!departamentosId.containsKey(idDepartamento)) {
            System.out.println("No existe un departamento con el id ingresado");
            return;
        }
        departamentosId.remove(idDepartamento);
        for (int i = 0; i < listaDepartamentos.size(); i++) {
            if (listaDepartamentos.get(i).getIdDepartamento().equals(idDepartamento)) {
                listaDepartamentos.remove(i);
                break;
            }           
        }
   
    }
    //muestra lso departamentos en para cada edificio
    public abstract void mostrarDepartamento();
    
    
    //busca departamentos por el id
    public boolean BuscarDepartamento(String idDepartamento){
        int i;

        for(i = 0; i<listaDepartamentos.size();i++){
            if(listaDepartamentos.get(i).getIdDepartamento().equals(idDepartamento)){
              return true;
            }
        }
        return false;
    }
    //comprueba que si este vacia o no la lista departamento
    public boolean existeDepartamento()
    {
      if(listaDepartamentos.isEmpty()){
        return false;
      }
      return true;
    }
    //muestra los departamentos
    public void mostrarDptosPorPrecios(int valorInicio,int valorFinal)
    {
      int i;
      boolean existe = false;
      for( i = 0; i < listaDepartamentos.size(); i++)
      {
        if((Integer.parseInt(listaDepartamentos.get(i).getValorDpto()) >= valorInicio) && (Integer.parseInt(listaDepartamentos.get(i).getValorDpto()) <= valorFinal))
        {
          System.out.println("El departamento, con id "+listaDepartamentos.get(i).getIdDepartamento()+ " tiene el valor de " + listaDepartamentos.get(i).getValorDpto()+"UF");
          existe = true;
        }
      }
      if(!existe)
      {
        System.out.println("Sin coincidencias en el rango");
      }
    }

    public void mostrarDptosPorOrientacion(String orientacion)
    {
      boolean existe = false;
      for(int i =0; i < listaDepartamentos.size();i++)
      {
        if(listaDepartamentos.get(i).getOrientacion().equals(orientacion))
        {
          System.out.println("Id departamento "+listaDepartamentos.get(i).getIdDepartamento()+", Orientacion: " + listaDepartamentos.get(i).getOrientacion());
          existe = true;
        }
      }
      if(!existe)
      {
        System.out.println("Sin coincidencias");
      }
    }
    // Crear una funcion abstracta para listar los hoteles por sus estrellas
    // Crear una funcion abstracta para listar moteles
    
    public boolean existeDepartamento(String idDepartamento){return departamentosId.containsKey(idDepartamento);}
    public Departamento buscarDepartamento(String idDepartamento){return departamentosId.get(idDepartamento);}
    public boolean buscarDepartamentoE(String idDepartamento){return departamentosId.containsKey(idDepartamento);}

    //getter
    public String getIdEdificio(){return idEdificio;}    
    public String getNombreEdificio(){return nombreEdificio;}
    public String getLocalidadEdificio(){return localidadEdificio;}
    public String getDireccionEdificio(){return direccionEdificio;}
    public String getArquitectoEdificio(){return arquitectoEdificio;}
    public HashMap<String,Departamento> getDepartamentosId(){return departamentosId;}
    public ArrayList<Departamento> getDepartamentos(){return listaDepartamentos;}
    //setter
    public void setIdEdificio(String id){this.idEdificio = idEdificio;}
    public void setNombreEdificio(String nombre){this.nombreEdificio = nombreEdificio;}
    public void setLocalidadEdificio(String localidad){this.localidadEdificio = localidadEdificio;}
    public void setDireccionEdificio(String direccion){this.direccionEdificio = direccionEdificio;}
    public void setArquitectoEdificio(String arquitecto){this.arquitectoEdificio = arquitectoEdificio;}
    public void setDepartamentos(ArrayList<Departamento>departamentos){this.listaDepartamentos = departamentos;}

}
