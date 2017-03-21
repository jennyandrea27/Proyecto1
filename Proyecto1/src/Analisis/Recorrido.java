/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import Extras.Constante;
import Reportes.TablaErrores;
import TablaSimbolos.TS;

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
        public static Nodo buscarClaseDeInicio(Nodo lals){
            for(Nodo als : lals.hijos){
                Nodo cuerpo=als.hijos.get(1);
                for(Nodo sent : cuerpo.hijos){
                    if(sent.getNombre().equals(Constante.inicio)){
                        return als;
                    }                   
                }
            }
            return null;
        }
        public static void recorrerInicio(Nodo raiz){
            //buscar lista de als
            Nodo lals=buscarNodo(raiz,Constante.als);
            //buscar clase con metodo inicio
            Nodo clase_inicio=buscarClaseDeInicio(lals);
            if(clase_inicio!=null){
                //metodo hereda 
                
                //crear ambito de clase que contiene el metodo inicio e inicializar sus varibales
                TS.AmbitoGlobal(clase_inicio);
                //obtener nodo de metodo inicio
                Nodo inicio=buscarNodo(clase_inicio.hijos.get(1), Constante.inicio);
                Nodo cuerpo_inicio=inicio.getHijo(0);
                //recorrer las sentencias del cuerpo de inicio
                recorrerSent(cuerpo_inicio);
            }else{
                //error metodo inicio no existe
                TablaErrores.insertarError("Error semantico, metodo Inicio no fue declarado.", 1, 1);
            }
            
        }
        public static Valor recorrerSent(Nodo cuerpo){
            Valor res=new Valor();
            for(Nodo sent : cuerpo.hijos){
                    switch(sent.getNombre()){
                        case Constante.asig:
                            SemanticoGraphik.asignacionVar(sent);
                            break;
                        case Constante.dec:
                            TS.declararVar(sent);
                            break;
                    }
                }
            return res;
        }        
}
