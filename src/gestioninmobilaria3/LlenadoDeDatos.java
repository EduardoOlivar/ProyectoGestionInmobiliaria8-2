package gestioninmobilaria3;

public class LlenadoDeDatos{

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
}
