/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extras;
import Analisis.*;

/**
 *
 * @author Jenny
 */
public class Fabrica {    
    public static Nodo crearNodoOp(String op){
        return new Nodo(op);
    }
    public static Nodo crearNodoHoja(String nombre){
        return new Nodo(nombre);
    }
    public static Nodo crearNodoOperacion(String operador, Nodo operando1,Nodo operando2){
        Nodo op =new Nodo(operador);
        op.insertarHijo(operando1);
        op.insertarHijo(operando2);
        return op;
    }
    public static Nodo crearNodoOperacion(String operador, Nodo operando1){
        Nodo op =new Nodo(operador);
        op.insertarHijo(operando1);
        return op;
    }
    
    public static Nodo crearNodoCuerpo(Nodo sent1){
        Nodo sentencia=new Nodo(Constante.cuerpo);
        if(sent1!=null){               
            sentencia.insertarHijo(sent1);
        }
        return sentencia;
    }
    public static Nodo insertarSentencia(Nodo cuerpo, Nodo sent){
        if(sent!=null){            
            cuerpo.insertarHijo(sent);
        }
        return cuerpo;
    }
    public static Nodo crearNodoFuncion(String id, Nodo lpar, Nodo cuerpo){
        Nodo funcion=new Nodo(Constante.funcion,id);
        funcion.insertarHijo(lpar);
        funcion.insertarHijo(cuerpo);
        return funcion;
    }
    public static Nodo crearNodoLPAR(Nodo par){
        Nodo lpar=new Nodo(Constante.lpar);
        if(par!=null){
            lpar.insertarHijo(par);;
        }
        return lpar;
    }
    
    public static Nodo insertarPar(Nodo lpar,Nodo par){
        if(par!=null){
            lpar.insertarHijo(par);
        }
        return lpar;
    }
    
    public static Nodo crearNodoLFunciones(Nodo  fun1){
        Nodo lfunciones=new Nodo(Constante.lfunciones);
        if(fun1!=null){
            lfunciones.insertarHijo(fun1);
        }
        return lfunciones;
    }
    
    public static Nodo insertarFuncion(Nodo lfunciones, Nodo fun){
        if(fun!=null){            
            lfunciones.insertarHijo(fun);
        }
        return lfunciones;
    }
    public static Nodo crearNodoEXP(Nodo exp){
        Nodo ex=new Nodo(Constante.exp);
        ex.insertarHijo(exp);
        return ex;
    }
    public static Nodo crearNodoLista(String nombre,Nodo asig){
        Nodo lista=new Nodo(Constante.list,nombre);
        if(asig!=null){
            lista.insertarHijo(asig);
        }
        return lista;
    }
    public static Nodo crearNodoConcat(Nodo op1, Nodo op2){
        Nodo concat=new Nodo(Constante.concatenacion);
        concat.insertarHijo(op1);
        concat.insertarHijo(op2);
        return concat;
    }
    public static Nodo crearNodoAsigLista(String valor, Nodo asig){
        Nodo asignacion=new Nodo(Constante.asig,valor);        
        if(asig!=null){
            asignacion.insertarHijo(asig);
        }
        return asignacion;
    }
    public static Nodo insertarAsigLista(Nodo lasig, Nodo asig){
        if(asig!=null){
            lasig.insertarHijo(asig);            
        }
        return lasig;
    }
    
    
}
