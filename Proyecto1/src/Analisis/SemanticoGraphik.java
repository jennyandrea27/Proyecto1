/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Jenny
 */
public class SemanticoGraphik {
    public static Nodo raiz;
    
    public static void graficar() throws IOException{
        String dot=ArchivoDot.getGrafo(raiz);
        //System.out.println(dot);
        try
        {
            FileWriter fw = new FileWriter("C:\\Users\\Jenny\\Desktop\\Graphik.dot");
            PrintWriter pw = new PrintWriter(fw);
            pw.print(dot);
            fw.close();

            String dirImagen = "C:\\Users\\Jenny\\Desktop\\ASTGraphik.png";
            String dirDot = "C:\\Users\\Jenny\\Desktop\\Graphik.dot";
            ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", dirImagen, dirDot );
            pbuilder.redirectErrorStream( true );
            //Ejecuta el proceso
            pbuilder.start();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}
