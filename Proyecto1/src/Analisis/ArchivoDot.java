/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;
import Analisis.Nodo;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Jenny
 */
public class ArchivoDot {
    public static int contador;
    public static String grafo;

    public static String getGrafo(Nodo raiz)
    {
        grafo = "digraph G{\n";
        grafo += "nodo0 [label=\"" + raiz.getNombre() + "\"];\n";
        contador = 1;
        recorrerAST("nodo0", raiz);
        grafo += "}\n";            
        return grafo;
    }

    private static void recorrerAST(String padre, Nodo nodo)
    {
        for(Nodo hijo: nodo.hijos){        
            String nombre_hijo = "nodo" + contador;
            grafo += nombre_hijo + " [label=\"" + hijo.getNombre() + "\"];\n";
            //relacion
            grafo += padre + "->" + nombre_hijo + ";\n";
            contador++;
            recorrerAST(nombre_hijo, hijo);
        }        
    }
    public static void graficar(Nodo raiz,String nombre) throws IOException{
        String dot=ArchivoDot.getGrafo(raiz);
        //System.out.println(dot);
        try
        {
            FileWriter fw = new FileWriter("C:\\Users\\Jenny\\Desktop\\"+nombre+".dot");
            PrintWriter pw = new PrintWriter(fw);
            pw.print(dot);
            fw.close();

            String dirImagen = "C:\\Users\\Jenny\\Desktop\\"+nombre+".png";
            String dirDot = "C:\\Users\\Jenny\\Desktop\\"+nombre+".dot";
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
