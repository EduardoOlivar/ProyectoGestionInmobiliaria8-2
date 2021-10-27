package gestioninmobilaria3;

public class Motel extends Building{
    private int precioXhora;

    public Motel(String idEdificio, String nombreEdificio, String direccionEdificio, String localidadEdificio, String arquitectoEdificio, int duracionEstancia) {
        super(idEdificio, nombreEdificio, direccionEdificio, localidadEdificio, arquitectoEdificio);
        this.precioXhora = duracionEstancia;
    }
    public void mostrarDepartamento()
    {
        for (Departamento depa : super.getDepartamentos()) {
            if(depa instanceof DepartamentoTematica){
                DepartamentoTematica newdepa = (DepartamentoTematica)depa;
                System.out.println("Id:"+newdepa.getIdDepartamento()+" Numero Dpto: "+newdepa.getNumeroDpto()+", Orientacion: "+newdepa.getOrientacion()+", Valor(UF): "+newdepa.getValorDpto()+", Cantidad de baños: "+newdepa.getCantidadBanos()+", Cantidad de dormitorios: "+newdepa.getCantidadDormitorios()+", Metros cuadrado: "+newdepa.getMetrosCuadrados() +" Tematica de la habitación "+ newdepa.getTematicaDePieza()/*+", Disponibilidad: "+super.getDepartamentos().get(i).getDisponibilidadDpto()*/);                    
           
            }
        }    
    }
    
    public int getPrecioXHora(){ return precioXhora;}
    
    public void setPrecioXHora(int precioXHora){this.precioXhora = precioXhora;}
}
