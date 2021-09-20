package gestioninmobilaria3;
import java.io.*;

public class MostrarDatos{

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
}
