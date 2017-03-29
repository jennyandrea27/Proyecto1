/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import Extras.Constante;
import Reportes.TablaErrores;
import TablaSimbolos.NodoTS;
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
}
