/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;
import Analisis.Nodo;

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
}
