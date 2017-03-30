/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import Extras.Constante;
import Reportes.TablaErrores;
import TablaSimbolos.TS;
import java.util.LinkedList;

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
        public static Nodo buscarClase(String nombre){
            for(Nodo hijo : raiz.hijos.get(1).hijos){
                if (hijo.getValor().equals(nombre))
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
                TS.insertarAmbito(TS.cont_ambito);
                recorrerSent(cuerpo_inicio);
                //TS.eliminarAmbito();
            }else{
                //error metodo inicio no existe
                TablaErrores.insertarError("Error semantico, metodo Inicio no fue declarado.", 1, 1);
            }
            
        }
        public static Nodo buscarFun(String nombre, String nombre_clase,LinkedList par_llamado){
            Nodo funcion=new Nodo("");
            Nodo lals=buscarNodo(raiz,Constante.als);
            if(nombre_clase==null){
                //se debe buscar en clase que tiene metodo principal
                //buscar lista de als
                //buscar clase con metodo inicio
                Nodo clase_inicio=buscarClaseDeInicio(lals);
                if(clase_inicio!=null){                    
                    Nodo cuerpo_inicio=clase_inicio.getHijo(1);
                    //recorrer cuerpo para encontrar funcion
                    funcion=buscarFun(cuerpo_inicio,nombre,par_llamado);
                    if(funcion==null)
                        TablaErrores.insertarError("Error semantico, funcion "+nombre+" no fue declarada.", 1, 1);
                    else
                        return funcion;                    
                }else{
                    //error metodo inicio no existe
                    TablaErrores.insertarError("Error semantico, metodo Inicio no fue declarado.", 1, 1);
                }
            }else{
                //se debe encontrar en el arbol del ALS que contiene esa funcion
                Nodo clase=buscarClase(nombre_clase);
                if(clase!=null){
                    //buscar funcion
                    Nodo cuerpo_clase=clase.getHijo(1);
                    funcion=buscarFun(cuerpo_clase, nombre, par_llamado);
                    if(funcion!=null)
                        return funcion;
                }else{                    
                    TablaErrores.insertarError("Error semantico, la clase "+nombre_clase+" no ha sido declarada.", cont, cont);               
                }

            }
            return null;            
        }
        public static Nodo buscarFun(Nodo cuerpo,String nombre,LinkedList <Valor> par_llamado){            
            for(Nodo sent:cuerpo.hijos){
                if(sent.getNombre().equals(Constante.decfun)){
                  if(sent.getValor().equals(nombre))  {
                      //se ha encontrado funcion
                      //verificar si coinciden los parametros
                        boolean encontrada = true;                             
                        Nodo lpar = sent.hijos.get(0);
                        if(lpar.hijos.size() == par_llamado.size()){
                            //comparar cada parametro
                            for (int i = 0; i < lpar.hijos.size();i++){                                        
                                if (par_llamado.get(i).getTipo() != lpar.hijos.get(i).getTipo()){
                                    encontrada = false;
                                }
                                if(par_llamado.get(i).getTipo()==Constante.tid){
                                    if(! par_llamado.get(i).getTals().equals(lpar.hijos.get(i).getTals())){
                                        encontrada =false;
                                    }
                                }
                            }
                            if (encontrada){
                                return sent;
                            }
                        }//no coincide cantidad de parametros                      
                  }//coincide nombre
                }//es decfun
            }//for
            return null;
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
                        case Constante.llamar:
                            res=SemanticoGraphik.llamar(sent);
                            break;
                        case Constante.retornar:                            
                            res=SemanticoGraphik.evaluarEXP(sent.hijos.get(0));    
                            res.setCat_retorno(Constante.cat_retornar);
                            return res;                            
                        case Constante.continuar:                                                        
                            res.setCat_retorno(Constante.cat_continuar);
                            return res;                            
                        case Constante.terminar:                                                        
                            res.setCat_retorno(Constante.cat_terminar);
                            return res;                            
                        case Constante.si:
                            res=SemanticoGraphik.si(sent);
                            if(res.getCat_retorno()==Constante.cat_retornar || res.getCat_retorno()==Constante.cat_continuar || res.getCat_retorno()==Constante.cat_terminar){
                                return res;
                            }
                            break;
                        case Constante.imprimir:
                            SemanticoGraphik.imprimir(sent);
                            break;
                        case Constante.mientras:
                            res=SemanticoGraphik.mientras(sent);
                            if(res.getCat_retorno()==Constante.cat_retornar || res.getCat_retorno()==Constante.cat_continuar || res.getCat_retorno()==Constante.cat_terminar){
                                return res;
                            }
                            break;
                        case Constante.hacermientras:
                            res=SemanticoGraphik.hacerMientras(sent);
                            if(res.getCat_retorno()==Constante.cat_retornar || res.getCat_retorno()==Constante.cat_continuar || res.getCat_retorno()==Constante.cat_terminar){
                                return res;
                            }
                            break;
                        case Constante.caso:
                            res=SemanticoGraphik.seleccion(sent);
                            if(res.getCat_retorno()==Constante.cat_retornar || res.getCat_retorno()==Constante.cat_continuar || res.getCat_retorno()==Constante.cat_terminar){
                                return res;
                            }
                            break;
                        case Constante.para:
                            res=SemanticoGraphik.para(sent);
                            if(res.getCat_retorno()==Constante.cat_retornar || res.getCat_retorno()==Constante.cat_continuar || res.getCat_retorno()==Constante.cat_terminar){
                                return res;
                            }
                            break;       
                        case Constante.llamado:
                            res=SemanticoGraphik.llamado(sent);
                            if(res.getTipo()==Constante.terror){
                                TablaErrores.insertarError(res.getValor(), 1, 1);
                            }
                            break;
                    }
                }
            return res;
        }        

    static boolean buscarFunIncluye(String valor) {
        Nodo encabezado=raiz.hijos.get(0);
        for(Nodo enc:encabezado.hijos){            
            if(enc.getNombre().equals(Constante.incluir) && enc.hijos.get(0).getValor().equals(valor)){
                return true;
            }
        }
        return false;
    }
}
