package gestioninmobilaria3;

public class Motel extends Edificio{
    private int duracionEstancia;

    public Motel(String idEdificio, String nombreEdificio, String direccionEdificio, String localidadEdificio, String arquitectoEdificio, int duracionEstancia) {
        super(idEdificio, nombreEdificio, direccionEdificio, localidadEdificio, arquitectoEdificio);
        this.duracionEstancia = duracionEstancia;
    }
    public void mostrarDepartamento()
    {
        int i;
        for (i = 0; i < super.getDepartamentos().size(); i++) {
            System.out.println("Id:"+super.getDepartamentos().get(i).getIdDepartamento()+" Numero Dpto: "+super.getDepartamentos().get(i).getNumeroDpto()+", Orientacion: "+super.getDepartamentos().get(i).getOrientacion()+", Valor(UF): "+super.getDepartamentos().get(i).getValorDpto()+", Cantidad de baños: "+super.getDepartamentos().get(i).getCantidadBanos()+", Cantidad de dormitorios: "+super.getDepartamentos().get(i).getCantidadDormitorios()+", Metros cuadrado: "+super.getDepartamentos().get(i).getMetrosCuadrados()+", Disponibilidad: "+super.getDepartamentos().get(i).getDisponibilidadDpto());                    
           
        }
    }
    
    public int getDuracionEstancia(){ return duracionEstancia;}
    
    public void setDuracionEstancia(int duracionEstancia){this.duracionEstancia = duracionEstancia;}
}