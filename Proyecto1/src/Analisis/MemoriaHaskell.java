/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import Extras.Constante;
import TablaSimbolos.Ambito;
import TablaSimbolos.NodoTS;
import TablaSimbolos.TS;
import TablaSimbolos.TSH;
import java.util.LinkedList;

/**
 *
 * @author Jenny
 */
public class MemoriaHaskell {
    public static Nodo raiz=new Nodo("HK");
    
    public static Nodo buscarFun(String nombre,LinkedList <Valor> par_llamado){            
            for(Nodo sent:raiz.hijos){       
                int cant_par=sent.hijos.get(0).hijos.size();
                if(sent.getValor().equals(nombre) && cant_par==par_llamado.size())  {
                    //se ha encontrado funcion
                    return sent;                    
                }//coincide nombre                
            }//for
            return null;
        }
    
    static Valor llamado(Nodo sent) {
        Valor res=new Valor();
        //buscar funcionhk en nodo incluye de archivo graphik
        boolean incluye=Recorrido.buscarFunIncluye(sent.getValor());
        if(incluye){
            //obtener parametros de llamado
            Nodo lpar=sent.hijos.get(0);
            LinkedList<Valor> par_llamado = new LinkedList<Valor>();
            for(Nodo hijo : lpar.hijos)
            {
                Valor par = SemanticoGraphik.evaluarEXP(hijo);            
                par_llamado.add(par);
            }
            //buscar funcion
            Nodo fun=MemoriaHaskell.buscarFun(sent.getValor(), par_llamado);
            if(fun!=null){
                //agregar ambito de llamado como global
                TS.insertarAmbito(-1);
                //agregar variables al ambito de la funcion que viene en parametros
                Nodo l_par_fun = fun.hijos.get(0);
                for (int i = 0; i < l_par_fun.hijos.size(); i++)
                {
                    String nombre = l_par_fun.hijos.get(i).getValor();                    
                    int tipo = par_llamado.get(i).getTipo();
                    if(tipo==Constante.tnum){
                        tipo=Constante.tdecimal;
                    }
                    String valor = par_llamado.get(i).getValor();
                    NodoTS par = new NodoTS(nombre, tipo, valor);
                    if(par_llamado.get(i).getTipo()==Constante.tid){
                        res=new Valor(Constante.terror, "Error semantico, funcion de haskell no permite tipo ALS como parametros.");                        
                    }else{                                                
                        TS.insertarVariable(par);
                    }
                }            
                //ejecutar sentencias de la funcion
                res=RecorridoHT.ejecutarCuerpo(fun.hijos.get(1));                
                TS.eliminarAmbito();
            }else{
                res=new Valor(Constante.terror, "Error semantico, funcion de haskell "+sent.getValor()+" no ha sido declarada.");
            }
        }else{
            res=new Valor(Constante.terror, "Error semantico, funcion de haskell "+sent.getValor()+" no ha sido incluida a archivo Graphik.");
        }
        return res;
    }
    static Valor llamado_terminal(Nodo sent) {
        Valor res=new Valor();                
        //obtener parametros de llamado
            Nodo lpar=sent.hijos.get(0);
            LinkedList<Valor> par_llamado = new LinkedList<Valor>();
            for(Nodo hijo : lpar.hijos)
            {
                Valor par = RecorridoHT.ejecutarSent(hijo);            
                par_llamado.add(par);
            }
            //buscar funcion
            Nodo fun=MemoriaHaskell.buscarFun(sent.getValor(), par_llamado);
            if(fun!=null){
                //ejecutar sentencias de la funcion
                TS.insertarAmbito(-1);
                //agregar variables al ambito de la funcion que viene en parametros
                Nodo l_par_fun = fun.hijos.get(0);                
                for (int i = 0; i < l_par_fun.hijos.size(); i++)
                {
                    String nombre = l_par_fun.hijos.get(i).getValor();
                    int tipo = par_llamado.get(i).getTipo();
                    String valor = par_llamado.get(i).getValor();
                    NodoTS par = new NodoTS(nombre, tipo, valor);
                    if(par_llamado.get(i).getTipo()==Constante.tid ){
                        res=new Valor(Constante.terror, "Error semantico, funcion de haskell no permite tipo ALS como parametros.");                        
                    }else{                        
                        if(par_llamado.get(i).dimensiones !=null){
                            //es una lista
                            //se agregan valores y dimensiones a variable
                            par.dimensiones=par_llamado.get(i).dimensiones;
                            par.valores=par_llamado.get(i).valores;
                            //se inserta en tabla de simbolos de haskell
                            TSH.insertarVariable(par);
                        }else{                            
                            TS.insertarVariable(par);
                        }
                    }
                }            
                res=RecorridoHT.ejecutarCuerpo(fun.hijos.get(1));                        
                TS.eliminarAmbito();                
            }else{
                res=new Valor(Constante.terror, "Error semantico, funcion de haskell "+sent.getValor()+" no ha sido declarada.");
            }
        return res;
    }
}
