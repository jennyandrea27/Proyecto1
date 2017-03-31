/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import Extras.Constante;
import Reportes.TablaErrores;
import TablaSimbolos.NodoTS;
import TablaSimbolos.TS;
import TablaSimbolos.TSH;
import proyecto1.FormInicio;

/**
 *
 * @author Jenny
 */
public class RecorridoHT {
    public static Nodo raiz;
    public static Valor porcentaje=new Valor();
    
    public static Valor ejecutarSent(Nodo r){
        Valor res=new Valor();
        switch(r.getNombre()){            
            case Constante.caracter:
                res=SemanticoGraphik.evaluarEXP(r);
                break;
            case Constante.calcular:
                res=SemanticoGraphik.evaluarEXP(r.hijos.get(0));
            break;
            case Constante.id:
                //buscar en la tabla de simbolos de haskell terminal si existe la variable
                NodoTS buscar2=TSH.buscarVar(r.getValor(), TSH.cont_ambito);
                if(buscar2!=null){
                    res=new Valor(buscar2.getTipo(), buscar2.getValor());
                    if(buscar2.dimensiones!=null){
                        res.dimensiones=buscar2.dimensiones;                           
                    }
                    if(buscar2.valores!=null){
                        res.valores=buscar2.valores;
                    }
                }else{
                    res=new Valor(Constante.terror, "La lista "+r.getValor()+" no ha sido declarada.");
                }                              
               break;
            case Constante.succ:
                res=SemanticoHaskell.succ(r);
                break;
            case Constante.decc:
                res=SemanticoHaskell.decc(r);
                break;
            case Constante.porcentaje:
                res=porcentaje;                
                break;
            case Constante.list:
                res=SemanticoHaskell.list(r);
                if(res.getTipo()!=Constante.terror){
                    NodoTS var=new NodoTS(res.getValor(),res.getTipo(),"");
                    var.dimensiones=res.dimensiones;
                    var.valores=res.valores;
                    TSH.insertarVariable(var);
                }else{
                    TablaErrores.insertarError(res.getValor(), 2, 2);
                }
                break;
            case Constante.sum:
                res=SemanticoHaskell.sum(r);
                break;
           case Constante.product:
                res=SemanticoHaskell.product(r);
                break;
            case Constante.max:
                res=SemanticoHaskell.max(r);
                break;
           case Constante.length:
                res=SemanticoHaskell.length(r);
                break;      
           case Constante.acceso:
               res=SemanticoHaskell.acceso(r);
               break;
           case Constante.llamado:
               res=MemoriaHaskell.llamado_terminal(r);
               break;
           case Constante.si:
               res=SemanticoHaskell.si(r);
               break;
        }
        return res;
    }
    
    public static void recorrerArbol(Nodo r){
        raiz=r;
        porcentaje=ejecutarSent(raiz);
        if(porcentaje.getTipo()!=Constante.terror){            
            if(porcentaje.valores!=null){                
                 String s="[";
                for(Valor d:porcentaje.valores){
                    if(d.valores!=null){
                        s+="[";
                        for(Valor v: d.valores){
                            s+=v.getValor()+",";
                        }
                        s=s.substring(0,s.length()-1);
                        s+="]";
                    }else{                        
                        s+=d.getValor();
                    }
                    s+=",";
                }
                s=s.substring(0, s.length()-1);
                s+="]";
                FormInicio.texto_salida+=">"+s;
            }else{            
                FormInicio.texto_salida+=">"+porcentaje.getValor();                
            }
        }
    }

    static Valor ejecutarCuerpo(Nodo cuerpo) {
        Valor res=new Valor();
        for(Nodo sent:cuerpo.hijos){
            res=ejecutarSent(sent);
        }
        return res;
    }
}
