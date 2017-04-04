/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Analisis.SemanticoHaskell;
import Analisis.Valor;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import proyecto1.Dato;

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
        Runtime r = Runtime.getRuntime(); 
        Process p = null; 
        String comando[] = {"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","C:\\Users\\Jenny\\Desktop\\Errores.html"}; 

        try { 
            p = r.exec(comando); 
        } catch (Exception e) {
        }
        TablaErrores.error=false;
    }
    public static void mostrarDatos(LinkedList<Dato> datos_resultado) {
        String tabla = generarTablaDatos(datos_resultado);
        Date date=new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");        
        String html = "<html><head><title>TABLA DE DATOS</title></head>\n";
        html += "<body>\n <div align =\"center\"> <h2>TABLA DE DATOS</h2> <h3>"+hourdateFormat.format(date).toString()+"</h3>";
        html+=tabla + "</div>\n</body>\n";            
        html += "</html>\n";            
        //generar archivo HTML
        try{            
            FileWriter fw = new FileWriter("C:\\Users\\Jenny\\Desktop\\Datos.html");
            PrintWriter pw = new PrintWriter(fw);
            pw.print(html);
            fw.close();            
        }catch(Exception e){
            System.out.println("No se pudo generar Datos.html");
        }
        Runtime r = Runtime.getRuntime(); 
        Process p = null; 
        String comando[] = {"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","C:\\Users\\Jenny\\Desktop\\Datos.html"}; 

        try { 
            p = r.exec(comando); 
        } catch (Exception e) {
        } 
    }

    private static String generarTablaDatos(LinkedList<Dato> datos_resultado) {
        String ret= "<table border=2>\n";
        for(int i=0;i<datos_resultado.size();i++){
            Dato d=datos_resultado.get(i);
            ret+="<tr>\n";
            for(int j=0;j<d.columnas.size();j++){
                if(i==0){                    
                    ret+="<th>"+d.columnas.get(j).getValor()+"</th>";
                }else{                    
                    ret+="<td>"+d.columnas.get(j).getValor()+"</td>";
                }
            }
            ret += "\n";                    
            ret+="</tr>\n";
        }        
        ret += "</table>\n";
        return ret;
    }
}
