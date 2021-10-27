
package gestioninmobilaria3;


public class DepartamentoArrendado extends Departamento{

    private int cantidadDiasArrendado;

    public DepartamentoArrendado(String idDepartamento, String numeroPiso, String numeroDpto, String valorDpto, String orientacion, int cantidadBanos, int cantidadDormitorios, double metrosCuadrados,String disponibilidadDpto,int cantidadDiasArrendado ) {
        super(idDepartamento, numeroPiso, numeroDpto, valorDpto, orientacion, cantidadBanos, cantidadDormitorios, metrosCuadrados,disponibilidadDpto);
        this.cantidadDiasArrendado = cantidadDiasArrendado;
    }

    @Override
    public String getInfoEstadoDepartamento() {
        if(cantidadDiasArrendado != 0)
            return "Arrendado";
        return "Disponible";
        
    }   
     public int getCantidadDiasArriendo(){return cantidadDiasArrendado;}
     
     public void setCantidadDiasArriendo(int cantidadDiasArriendo){ this.cantidadDiasArrendado = cantidadDiasArrendado;}
     

}
