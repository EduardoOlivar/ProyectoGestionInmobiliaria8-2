package gestioninmobilaria3;

public class Departamento implements InformeDepartamento{
    private String idDepartamento;
    private String numeroPiso;
    private String numeroDpto;
    private String valorDpto;
    private String orientacion;
    private int cantidadBanos;
    private int cantidadDormitorios;
    private double metrosCuadrados;
    private String disponibilidadDpto;
    
    //constructor
    
    public Departamento(String idDepartamento,String numeroPiso,String numeroDpto, String valorDpto, String orientacion, int cantidadBanos, int cantidadDormitorios, double metrosCuadrados, String disponibilidadDpto) {
        this.idDepartamento = idDepartamento;
        this.numeroPiso = numeroPiso;
        this.numeroDpto = numeroDpto;
        this.valorDpto = valorDpto;
        this.orientacion = orientacion;
        this.cantidadBanos = cantidadBanos;
        this.cantidadDormitorios = cantidadDormitorios;
        this.metrosCuadrados = metrosCuadrados;
        this.disponibilidadDpto = disponibilidadDpto;
    }
    @Override
    public String getInfoEstadoDepartamento() {
        if(disponibilidadDpto.equals("Disponible"))
            return "Disponible";
        return "Vendido";
        
    } 
 
    
    
    //getter
    public String getIdDepartamento(){return idDepartamento;}
    public String getNumeroPiso(){return numeroPiso;}
    public String getNumeroDpto(){return numeroDpto;}
    public String getValorDpto(){return valorDpto;}
    public String getOrientacion(){return orientacion;}
    public int getCantidadBanos(){return cantidadBanos;}
    public int getCantidadDormitorios(){return cantidadDormitorios;}
    public double getMetrosCuadrados(){return metrosCuadrados;}
    public String getDisponibilidadDpto(){return disponibilidadDpto;}
    //setter
    public void setIdDepartamento(String idDepartamento){this.idDepartamento = idDepartamento;}
    public void setNumeroPiso(String numeroPiso){this.numeroPiso = numeroPiso;}
    public void setNumeroDpto(String numeroDpto){this.numeroDpto = numeroDpto;}
    public void setValorDpto(String valorDpto){this.valorDpto = valorDpto;}
    public void setOrientacion(String orientacion){this.orientacion = orientacion;}
    public void setCantidadBanos(int cantidadBanos){this.cantidadBanos = cantidadBanos;}
    public void setCantidadDormitorios(int cantidadDormitorios){this.cantidadDormitorios = cantidadDormitorios;}
    public void setMetrosCuadrados(double metrosCuadrados){this.metrosCuadrados = metrosCuadrados;}
    public void setDisponibilidadDpto(String disponibilidadDpto){this.disponibilidadDpto = disponibilidadDpto;}
    
}

