/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioninmobilaria3;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
/**
 *
 * @author danie
 */
public class GenerarReporte {
    public  void crearReporte(Administrador administrador) {
        if(administrador.vacio()){
            System.out.println("No hay informacion para generar un reporte");
            return;
        }    
        Workbook book = new XSSFWorkbook();
        XSSFSheet sheet =  (XSSFSheet) book.createSheet("Reporte Edificos");
        int i = 0;
        int j = 0;
        int k = 1;
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Id Edificio");
        row.createCell(1).setCellValue("Nombre");
        row.createCell(2).setCellValue("Direccion");
        row.createCell(3).setCellValue("Localidad");
        row.createCell(4).setCellValue("Arquitecto");
        do {
            row = sheet.createRow(k);
            row.createCell(j).setCellValue(administrador.getListaEdificio().get(i).getIdEdificio()); 
            row.createCell(j+1).setCellValue(administrador.getListaEdificio().get(i).getNombreEdificio());  
            row.createCell(j+2).setCellValue(administrador.getListaEdificio().get(i).getDireccionEdificio());            
            row.createCell(j+3).setCellValue(administrador.getListaEdificio().get(i).getLocalidadEdificio());
            row.createCell(j+4).setCellValue(administrador.getListaEdificio().get(i).getArquitectoEdificio());            
            i=i+1;
            k=k+1;           
        } while (i<administrador.getListaEdificio().size());
        XSSFSheet sheetDos =  (XSSFSheet) book.createSheet("Reporte Departamentos");
    
        k=0;
        for (int l = 0; l < administrador.getListaEdificio().size(); l++) {
            i=0;
        Row rowDos = sheetDos.createRow(k);
        rowDos.createCell(0).setCellValue(administrador.getListaEdificio().get(l).getNombreEdificio()); 
        k=k+1;
        rowDos = sheetDos.createRow(k);
        rowDos.createCell(0).setCellValue("Id Departamento");
        rowDos.createCell(1).setCellValue("Numero de piso");
        rowDos.createCell(2).setCellValue("Numero de departamento");
        rowDos.createCell(3).setCellValue("Valor en uf  ");
        rowDos.createCell(4).setCellValue("Orientacion");
        rowDos.createCell(5).setCellValue("Cantidad de baños");
        rowDos.createCell(6).setCellValue("Cantidad de dormitorios ");
        rowDos.createCell(7).setCellValue("Metro cuadrados");
        rowDos.createCell(8).setCellValue("Disponibilidad departamento");               
        k=k+1;
                      
            do {
               rowDos = sheetDos.createRow(k);
               rowDos.createCell(j).setCellValue(administrador.getListaEdificio().get(l).getDepartamentos().get(i).getIdDepartamento());
               rowDos.createCell(j+1).setCellValue(administrador.getListaEdificio().get(l).getDepartamentos().get(i).getNumeroPiso()); 
               rowDos.createCell(j+2).setCellValue(administrador.getListaEdificio().get(l).getDepartamentos().get(i).getNumeroDpto()); 
               rowDos.createCell(j+3).setCellValue(administrador.getListaEdificio().get(l).getDepartamentos().get(i).getValorDpto()); 
               rowDos.createCell(j+4).setCellValue(administrador.getListaEdificio().get(l).getDepartamentos().get(i).getOrientacion()); 
               rowDos.createCell(j+5).setCellValue(administrador.getListaEdificio().get(l).getDepartamentos().get(i).getCantidadBaños()); 
               rowDos.createCell(j+6).setCellValue(administrador.getListaEdificio().get(l).getDepartamentos().get(i).getCantidadDormitorios()); 
               rowDos.createCell(j+7).setCellValue(administrador.getListaEdificio().get(l).getDepartamentos().get(i).getMetrosCuadrados()); 
               rowDos.createCell(j+8).setCellValue(administrador.getListaEdificio().get(l).getDepartamentos().get(i).getDisponibilidadDpto()); 
               i=i+1;
               k=k+1;  
            } while (i<administrador.getListaEdificio().get(l).getDepartamentos().size());                
        }
       
        try {
            FileOutputStream fileout;
            fileout = new FileOutputStream("Reporte_Gestion_Inmobiliaria.xlsx");//Se crea un excel
            book.write(fileout);
            fileout.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo generar el reporte, ya que el archivo EXCEL esta siendo utilizado");
        } catch (IOException ex) {
            Logger.getLogger(GestionInmobilaria3.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("El reporte se ha generado exitosamente");
    }       
}
