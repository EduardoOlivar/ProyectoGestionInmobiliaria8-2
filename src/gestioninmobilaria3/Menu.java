package gestioninmobilaria3;
import java.io.*;
import javax.swing.JFrame;

public class Menu extends JFrame{
  Administrador administrador = new Administrador();
  Datos gestionDatos = new Datos();
  GenerarReporte generarReporte = new GenerarReporte();
  public void menuPrincipal(int opc)throws IOException, InterruptedException{
    BufferedReader lectura = new BufferedReader(new InputStreamReader( System.in ));
    boolean mostrarMenu = true;
    int opcion;
    gestionDatos.cargarEdificios(administrador);
    gestionDatos.cargarDepartamentos(administrador);    
        
    System.out.println("Bienvenido, ingrese la opcion que desee utilizar");
        
    while(mostrarMenu){
      System.out.println("(1)  Agregar Edificio");
      System.out.println("(2)  Agregar Departamento");
      System.out.println("(3)  Mostrar listado de Edificios");
      System.out.println("(4)  Mostrar listado de departamentos en Edificio ");
      System.out.println("(5)  Eliminar Edificio");
      System.out.println("(6)  Buscar Departamento");
      System.out.println("(7)  Modificar nombre de Edificio");
      System.out.println("(8)  Mostrar Departamentos por rango de precios");
      System.out.println("(9)  Mostrar Departamentos por Orientacion");
      System.out.println("(10) Eliminar Departamento");
      System.out.println("(11) Informes de disponiblilidad de Departamentos");
      System.out.println("presione x para salir");
            
      String eleccion = lectura.readLine();
            
      switch(eleccion){
        case "1":
          do {
              System.out.println("Ingrese la opción que desea agregar");
              System.out.println("(1)  Edificios");
              System.out.println("(2)  Hoteles");
              System.out.println("(3)  Moteles");
              System.out.println("(4)  Salir");
              opcion = Integer.parseInt(lectura.readLine());
          switch(opcion){
              case 1: 
                    gestionDatos.agregarEdificio(administrador,1);
                    break;
              case 2: 
                    gestionDatos.agregarEdificio(administrador,2);
                    break;
              case 3:
                    gestionDatos.agregarEdificio(administrador,3);
                    break;
              case 4:
                    System.out.println("Volviendo al menu principal");
                    break;
              default:          
                    System.out.println("La opcion ingresada no es valida");              
                    break;
            }          
            }while (opcion != 4);
          break;
        case "2":
           do {
              System.out.println("Ingrese la opción que desea agregar");
              System.out.println("(1)  Departamentos a Edificios");
              System.out.println("(2)  Departamentos a Hoteles");
              System.out.println("(3)  Departamentos a Moteles");
              System.out.println("(4)  Salir al menú principal");
              opcion = Integer.parseInt(lectura.readLine());
          switch(opcion){
              case 1: 
                    gestionDatos.agregarDepartamento(administrador,1);
                    break;
              case 2: 
                    gestionDatos.agregarDepartamento(administrador,2);
                    break;
              case 3:
                    gestionDatos.agregarDepartamento(administrador,3);
                    break;
              case 4:
                    System.out.println("Volviendo al menú principal");
                    break;
              default:          
                    System.out.println("La opcion ingresada no es valida");              
                    break;
            }          
            }while (opcion != 4);
          break;
        case "3":
          do {
              System.out.println("--Menu de Edificios, Hoteles y Moteles");
              System.out.println("(1)  Edificios");
              System.out.println("(2)  Hoteles");
              System.out.println("(3)  Moteles");
              System.out.println("(4)  Volver al menú principal");
              opcion = Integer.parseInt(lectura.readLine());
          switch(opcion){
              case 1: 
                    gestionDatos.mostrarListadoDeEdifcios(administrador,1);
                    break;
              case 2: 
                    gestionDatos.mostrarListadoDeEdifcios(administrador,2);
                    break;
              case 3:
                    gestionDatos.mostrarListadoDeEdifcios(administrador,3);
                    break;
              case 4:
                    System.out.println("Volviendo al menú principal");
                    break;
              default:          
                    System.out.println("La opcion ingresada no es valida");              
                    break;
            }          
        }while (opcion != 4);
          break;
        case "4":
          do{
              System.out.println("Menu de Edificios, Hoteles y Moteles");
              System.out.println("(1)  Lista de departamentos en Edificios");
              System.out.println("(2)  Lista de departamentos en Hoteles");
              System.out.println("(3)  Lista de departamentos en Moteles");
              System.out.println("(4)  Volver al menú principal");
              opcion = Integer.parseInt(lectura.readLine());
          switch(opcion){
              case 1: 
                    gestionDatos.mostrarTodosLosDepartamentos(administrador,1);
                    break;
              case 2: 
                    gestionDatos.mostrarTodosLosDepartamentos(administrador,2);
                    break;
              case 3:
                    gestionDatos.mostrarTodosLosDepartamentos(administrador,3);
                    break;
              case 4:
                    System.out.println("Volviendo al menú principal");
                    break;
              default:          
                    System.out.println("La opcion ingresada no es valida");              
                    break;
            }          
        }while (opcion != 4);
          break;
        case "5":
          gestionDatos.eliminarUnEdificio(administrador);
          break;
        case "6":
          gestionDatos.buscarDepartamento(administrador);
          break;
        case "7":
          gestionDatos.modificarNombreEdificio(administrador);
          break;
        case "8":
          gestionDatos.mostrarDepartamentosPorPrecios(administrador);
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
            System.out.println("(9)  Devolverse al menú anterior");
            opcion = Integer.parseInt(lectura.readLine());
          
          switch(opcion){
            case 1:
                gestionDatos.mostrarDepartamentosPorOrientacion(administrador,"Norte");
              break;
            case 2:
              gestionDatos.mostrarDepartamentosPorOrientacion(administrador,"NorOeste");
              break;
            case 3:
              gestionDatos.mostrarDepartamentosPorOrientacion(administrador,"NorEste");
              break;
            case 4:
              gestionDatos.mostrarDepartamentosPorOrientacion(administrador,"Oeste");
              break;
            case 5:
              gestionDatos.mostrarDepartamentosPorOrientacion(administrador,"Este");
              break;
            case 6:
              gestionDatos.mostrarDepartamentosPorOrientacion(administrador,"Sur");
              break;
            case 7:
              gestionDatos.mostrarDepartamentosPorOrientacion(administrador,"SurOeste");
              break;
            case 8:
              gestionDatos.mostrarDepartamentosPorOrientacion(administrador,"SurEste");
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
            gestionDatos.eliminarUnDepartamento(administrador);
            break;
        case "11":
          do {
            System.out.println("--Menu de informes Edificios, Hoteles y Moteles--");
            System.out.println("(1)  Informe disponibilidad en Edificios");
            System.out.println("(2)  Informe disponibilidad en Hoteles");
            System.out.println("(3)  Informe disponibilidad en Moteles");              
            System.out.println("(4)  Salir al menú principal");
            opcion = Integer.parseInt(lectura.readLine());
          switch(opcion){
              case 1: 
                    gestionDatos.infoDisponiblidad(administrador, 1);
                    break;
              case 2: 
                    gestionDatos.infoDisponiblidad(administrador,2);
                    break;
              case 3:
                    gestionDatos.infoDisponiblidad(administrador,3);
                    break;
              case 4:
                    System.out.println("Volviendo al menu principal");
                    break;                    
              default:          
                    System.out.println("La opcion ingresada no es valida");              
                    break;
            }          
        }while (opcion != 4);
        break;            
        case "x":
          System.out.println("Nos vemos!");
          generarReporte.crearReporte(administrador);
          mostrarMenu = false;
          break;
        default:
          System.out.println("La opcion ingresada no es valida");
          break;
      }
    }    
  }
}