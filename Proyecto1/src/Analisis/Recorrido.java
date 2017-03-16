/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import Extras.Constante;
import Reportes.TablaErrores;

/**
 *
 * @author Jenny
 */
public class Recorrido {
    public static String salida = "";
        public static Nodo raiz;
        public static int cont = 1;
        public static void recorrerArbol(Nodo raiz_arbol)
        {
            raiz = raiz_arbol;
            //Ejecutar Incluye y Define
//            Nodo encabezado = buscarNodo(raiz, Constante.ENCABEZADO);
//            ejecutarEncabezado(encabezado);
//            //CrearTablaSimbolos
//            Nodo ldec = buscarNodo(raiz, Constante.LDEC);
//            TS.AmbitoGlobal(ldec);

            //Buscar metodo principal            
            recorrerInicio(raiz);                        
        }
        private static Nodo buscarNodo (Nodo padre, String nombre)
        {
            for(Nodo hijo : padre.hijos){
                if (hijo.getNombre().equals(nombre))
                {
                    return hijo;
                }
            }
            return null;
        }
        public static Nodo buscarInicio(Nodo lals){
            for(Nodo als : lals.hijos){
                Nodo cuerpo=als.hijos.get(1);
                for(Nodo sent : cuerpo.hijos){
                    if(sent.getNombre().equals(Constante.inicio)){
                        return sent;
                    }                   
                }
            }
            return null;
        }
        public static void recorrerInicio(Nodo raiz){
            //buscar lista de als
            Nodo lals=buscarNodo(raiz,Constante.als);
            //buscar metodo inicio
            Nodo inicio=buscarInicio(lals);
            if(inicio!=null){
                Nodo cuerpo_inicio=inicio.getHijo(0);
                //recorrer las sentencias del cuerpo de inicio
                for(Nodo sent : cuerpo_inicio.hijos){
                    switch(sent.getNombre()){
                        case Constante.asig:
                            SemanticoGraphik.asignacionVar(sent);
                            break;
                    }
                }
            }else{
                //error metodo inicio no existe
                TablaErrores.insertarError("Error semantico, metodo Inicio no fue declarado.", 1, 1);
            }
            
        }
}
