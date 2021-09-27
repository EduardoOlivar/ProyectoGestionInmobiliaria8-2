package gestioninmobilaria3;
import java.util.*;


public class Edificio
{
    private String id;
    private String nombre;
    private String direccion;
    private String localidad;
    private String arquitecto;
    private ArrayList<Departamento> listaDepartamentos;
    private HashMap<String,Departamento>departamentosId; //mapa departamentosId que facilita la bisqueda de un departamento por id;

    //constructor
    
    public Edificio(String id ,String nombre, String direccion, String localidad, String arquitecto)
    {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.arquitecto = arquitecto;
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
    public void agregarDepartamento(String idDepartamento,String numeroPiso,String numeroDpto, String valorDpto, String orientacion, int cantidadBaños, int cantidadDormitorios, double metrosCuadrados, String disponibilidadDpto)
    {
        Departamento departamento = new Departamento(idDepartamento,numeroPiso,numeroDpto,valorDpto,orientacion,cantidadBaños,cantidadDormitorios,metrosCuadrados,disponibilidadDpto);
        this.agregarDepartamento(departamento);     
    }   
    
    public void eliminarDepartamento(){
             departamentosId = new HashMap();
             listaDepartamentos = new ArrayList();
    }
    
    public void eliminarDepartamento(String idDepartamento){
        if (!departamentosId.containsKey(idDepartamento)) {
            System.out.println("No existe un departaemento con el id ingresado");
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
    public void mostrarDepartamento(){
        int i;
        for (i = 0; i < listaDepartamentos.size(); i++) {
            System.out.println("Id:"+listaDepartamentos.get(i).getIdDepartamento()+" Numero Dpto: "+listaDepartamentos.get(i).getNumeroDpto()+", Orientacion: "+listaDepartamentos.get(i).getOrientacion()+", Valor(UF): "+listaDepartamentos.get(i).getValorDpto()+", Cantidad de baños: "+listaDepartamentos.get(i).getCantidadBaños()+", Cantidad de dormitorios: "+listaDepartamentos.get(i).getCantidadDormitorios()+", Metros cuadrado: "+listaDepartamentos.get(i).getMetrosCuadrados()+", Disponibilidad: "+listaDepartamentos.get(i).getDisponibilidadDpto());                    
           
        }
        
    }
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
          System.out.println("el departamento, con id "+listaDepartamentos.get(i).getIdDepartamento()+ " tiene el valor de " + listaDepartamentos.get(i).getValorDpto()+"UF");
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
    
    public boolean existeDepartamento(String idDepartamento){return departamentosId.containsKey(idDepartamento);}
    public Departamento buscarDepartamento(String idDepartamento){return departamentosId.get(idDepartamento);}
    public boolean buscarDepartamentoE(String idDepartamento){return departamentosId.containsKey(idDepartamento);}

    //getter
    public String getId(){return id;}    
    public String getNombre(){return nombre;}
    public String getLocalidad(){return localidad;}
    public String getDireccion(){return direccion;}
    public String getArquitecto(){return arquitecto;}
    public HashMap<String,Departamento> getDepartamentosId(){return departamentosId;}
    public ArrayList<Departamento> getDepartamentos(){return listaDepartamentos;}
    //setter
    public void setId(String id){this.id = id;}
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setLocalidad(String localidad){this.localidad = localidad;}
    public void setDireccion(String direccion){this.direccion = direccion;}
    public void setArquitecto(String arquitecto){this.arquitecto = arquitecto;}
    public void setDepartamentos(ArrayList<Departamento>departamentos){this.listaDepartamentos = departamentos;}

}