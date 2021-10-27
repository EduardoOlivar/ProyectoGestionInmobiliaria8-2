
package gestioninmobilaria3;

public class Edificio extends Building{    
    String nombreConserje;

    public Edificio(String idEdificio, String nombreEdificio, String direccionEdificio, String localidadEdificio, String arquitectoEdificio,String nombreConserje) {
        super(idEdificio, nombreEdificio, direccionEdificio, localidadEdificio, arquitectoEdificio);
        this.nombreConserje = nombreConserje;
    }



    public void mostrarDepartamento() 
    {
        for (Departamento depa : super.getDepartamentos()) {
              if(depa instanceof Departamento){
                Departamento newdepa = (Departamento)depa;
                System.out.println("Id:"+newdepa.getIdDepartamento()+" Numero Dpto: "+newdepa.getNumeroDpto()+", Orientacion: "+newdepa.getOrientacion()+", Valor(UF): "+newdepa.getValorDpto()+", Cantidad de baños: "+newdepa.getCantidadBanos()+", Cantidad de dormitorios: "+newdepa.getCantidadDormitorios()+", Metros cuadrado: "+newdepa.getMetrosCuadrados()/*+", Disponibilidad: "+super.getDepartamentos().get(i).getDisponibilidadDpto()*/);                    
           
            }
        } 
    }

    public String getNombreConserje() {
        return nombreConserje;
    }

    public void setNombreConserje(String nombreConserje) {
        this.nombreConserje = nombreConserje;
    }
    
    
}
