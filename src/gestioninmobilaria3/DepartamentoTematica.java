
package gestioninmobilaria3;

public class DepartamentoTematica extends Departamento{
    private String tematicaDePieza;

    public DepartamentoTematica(String idDepartamento, String numeroPiso, String numeroDpto, String valorDpto, String orientacion, int cantidadBanos, int cantidadDormitorios, double metrosCuadrados,String disponibilidadDpto , String tematicaDePieza) {
        super(idDepartamento, numeroPiso, numeroDpto, valorDpto, orientacion, cantidadBanos, cantidadDormitorios, metrosCuadrados,disponibilidadDpto);
        this.tematicaDePieza = tematicaDePieza;
    }
    @Override
    public String getInfoEstadoDepartamento() {
        if(super.getDisponibilidadDpto().equals("Disponible"))
            return "Disponible";
        return "Ocupado";
        
    }  
     
     public String getTematicaDePieza(){return tematicaDePieza;}
     
     public void setTematicaDePieza(String tematicaDePieza){this.tematicaDePieza = tematicaDePieza;}
     
     
}
