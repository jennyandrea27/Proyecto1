/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Analisis.SemanticoHaskell;
import static Reportes.TablaErrores.tabla;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jenny
 */
public class HTML {
    public static void mostrarErrores() {
        String tabla = TablaErrores.generarTablaErrores();
        Date date=new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");        
        String html = "<html><head><title>TABLA DE ERRORES</title></head>\n";
        html += "<body>\n <div align =\"center\"> <h2>TABLA DE ERRORES</h2> <h3>"+hourdateFormat.format(date).toString()+"</h3>";
        html+=tabla + "</div>\n</body>\n";            
        html += "</html>\n";            
        //generar archivo HTML
        try{            
            FileWriter fw = new FileWriter("C:\\Users\\Jenny\\Desktop\\Errores.html");
            PrintWriter pw = new PrintWriter(fw);
            pw.print(html);
            fw.close();            
        }catch(Exception e){
            System.out.println("No se pudo generar Errores.html");
        }
    }
}
