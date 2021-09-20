package gestioninmobilaria3;
import java.io.*;

public class Menu{
  Administrador administrador = new Administrador();
  AgregarDatos agregarDatos = new AgregarDatos();
  MostrarDatos mostrarDatos = new MostrarDatos();
  ModificarPropiedad modificarPropiedad = new ModificarPropiedad();
  EliminarPropiedad eliminarPropiedad = new EliminarPropiedad();
  LlenadoDeDatos llenadoDeDatos = new LlenadoDeDatos();
  GenerarReporte generarReporte = new GenerarReporte();
  public void menuPrincipal(int opc)throws IOException{
    BufferedReader lectura = new BufferedReader(new InputStreamReader( System.in ));
    boolean mostrarMenu = true;
    int opcion;
    llenadoDeDatos.cargarEdificios(administrador);
    llenadoDeDatos.cargarDepartamentos(administrador);    
        
    System.out.println("Bienvenido, ingrese la opcion que desee utilizar");
        
    while(mostrarMenu){
      System.out.println("(1)  Agregar Edificio");
      System.out.println("(2)  Agregar Departamento");
      System.out.println("(3)  Mostrar listado de Edificios");
      System.out.println("(4)  Mostrar todos los departamentos");
      System.out.println("(5)  Eliminar Edificio");
      System.out.println("(6)  Buscar Departamento");
      System.out.println("(7)  Modificar nombre de Edificio");
      System.out.println("(8) Mostrar Departamentos por rango de precios");
      System.out.println("(9) Mostrar Departamentos por Orientacion");
      System.out.println("(10) Generar reporte de Edificios y Departamentos");
      System.out.println("presione x para salir");
            
      String eleccion = lectura.readLine();
            
      switch(eleccion){
        case "1":
          agregarDatos.agregarEdificio(administrador);
          break;
        case "2":
          agregarDatos.agregarDepartamento(administrador);
          break;
        case "3":
          mostrarDatos.mostrarListadoDeEdifcios(administrador);
          break;
        case "4":
          mostrarDatos.mostrarTodosLosDepartamentos(administrador);   
          break;
        case "5":
          eliminarPropiedad.eliminarEdificio(administrador);
          break;
        case "6":
          mostrarDatos.buscarDepartamento(administrador);
          break;
        case "7":
          modificarPropiedad.modificarNombreEdificio(administrador);
          break;
        case "8":
          mostrarDatos.mostrarDepartamentosPorPrecios(administrador);
          break;
        case "9":
          do {
            System.out.println("--Menu para mostrar departamentos por Orientacion--");
            System.out.println("Elije la opcion deseada: ");
            System.out.println("(1)  Norte");
            System.out.println("(2)  NorOeste");
            System.out.println("(3)  NorEste");
            System.out.println("(4)  Oeste");
            System.out.println("(5)  Este");
            System.out.println("(6)  Sur");
            System.out.println("(7)  SurOeste");
            System.out.println("(8)  SurEste");
            System.out.println("(9)  Devolverse al menu anterior");
            opcion = Integer.parseInt(lectura.readLine());
          
          switch(opcion){
            case 1:
                mostrarDatos.mostrarDepartamentosPorOrientacion(administrador,"Norte");
              break;
            case 2:
              mostrarDatos.mostrarDepartamentosPorOrientacion(administrador,"NorOeste");
              break;
            case 3:
              mostrarDatos.mostrarDepartamentosPorOrientacion(administrador,"NorEste");
              break;
            case 4:
              mostrarDatos.mostrarDepartamentosPorOrientacion(administrador,"Oeste");
              break;
            case 5:
              mostrarDatos.mostrarDepartamentosPorOrientacion(administrador,"Este");
              break;
            case 6:
              mostrarDatos.mostrarDepartamentosPorOrientacion(administrador,"Sur");
              break;
            case 7:
              mostrarDatos.mostrarDepartamentosPorOrientacion(administrador,"SurOeste");
              break;
            case 8:
              mostrarDatos.mostrarDepartamentosPorOrientacion(administrador,"SurEste");
              break;
            case 9:
              System.out.println("Gracias por buscar departamentos");
              break;
            default:          
              System.out.println("La opcion ingresada no es valida");              
              break;
            }
        } while (opcion!=9);
        break;
        case "10":
            generarReporte.crearReporte(administrador);
            break;
        case "x":
          System.out.println("Nos vemos!");
          mostrarMenu = false;
          break;
        default:
          System.out.println("La opcion ingresada no es valida");
          break;
      }
    }    
  }
}