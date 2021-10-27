package gestioninmobilaria3;

public class Hotel extends Building{
    private int cantidadEstrellas;

    public Hotel(String idEdificio, String nombreEdificio, String direccionEdificio, String localidadEdificio, String arquitectoEdificio, int cantidadEstrellas) {
        super(idEdificio, nombreEdificio, direccionEdificio, localidadEdificio, arquitectoEdificio);
        this.cantidadEstrellas = cantidadEstrellas;
    }
    
    // funcion que lista los hoteles por estrellas
    
    public void mostrarDepartamento()
    {
        for (Departamento depa : super.getDepartamentos()) {
            if(depa instanceof DepartamentoArrendado){
                DepartamentoArrendado newdepa = (DepartamentoArrendado)depa;
                System.out.println("Id:"+newdepa.getIdDepartamento()+" Numero Dpto: "+newdepa.getNumeroDpto()+", Orientacion: "+newdepa.getOrientacion()+", Valor(UF): "+newdepa.getValorDpto()+", Cantidad de baños: "+newdepa.getCantidadBanos()+", Cantidad de dormitorios: "+newdepa.getCantidadDormitorios()+", Metros cuadrado: "+newdepa.getMetrosCuadrados() +"Días arrendados"+ newdepa.getCantidadDiasArriendo()/*+", Disponibilidad: "+super.getDepartamentos().get(i).getDisponibilidadDpto()*/);                    
           
            }
        } 
    }
    public void estadoDepartamento(){
         for (Departamento departamento : super.getDepartamentos() ) {
            if(departamento instanceof DepartamentoArrendado){
                DepartamentoArrendado newDepartamento = (DepartamentoArrendado)departamento;
                System.out.println("El departamento del Hotel "+super.getNombreEdificio()+" con ID "+newDepartamento.getIdDepartamento()+" se encuentra "+newDepartamento.getInfoEstadoDepartamento());
            }
        }       
    }
    public int getCantidadEstrellas() {return cantidadEstrellas;}

    public void setCantidadEstrellas(int cantidadEstrellas) {this.cantidadEstrellas = cantidadEstrellas;}
    

}
