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
    public static Nodo crearNodoOpLista(String nombre, Nodo vallista){
        Nodo op = new Nodo(nombre);        
        if(vallista!=null){
            for(Nodo hijo: vallista.hijos){                
                op.insertarHijo(hijo);
            }
        }
        return op;
    }
    public static Nodo crearNodoFunHK(String nombre,Nodo parfun){
        Nodo fun_hk=new Nodo(nombre);
        if(parfun!=null){
            fun_hk.insertarHijo(parfun);
        }
        return fun_hk;
    }
    public static Nodo crearNodoLlamado(String nombre,Nodo lpar){
        Nodo llamado=new Nodo(Constante.llamado,nombre);
        if(lpar!=null){
            llamado.insertarHijo(lpar);
        }
        return llamado;
    }
    public static Nodo crearNodoAcceso(Nodo lista,Nodo pos){
        Nodo acceso=new Nodo(Constante.acceso);
        if(lista!=null){
            acceso.insertarHijo(lista);
        }
        if(pos!=null){
            acceso.insertarHijo(pos);
        }
        return acceso;
    }
    public static Nodo crearNodoSi(Nodo cond, Nodo lv, Nodo lf){
        Nodo si = new Nodo(Constante.si);
        if(cond!=null){
            si.insertarHijo(cond);
        }
        if(lv!=null){
            si.insertarHijo(lv);
        }
        if(lf!=null){
            si.insertarHijo(lf);
        }
        return si;
    }
    public static Nodo crearNodoCaso(Nodo valor, Nodo cuerpo){
        Nodo caso=new Nodo(Constante.caso);
        if(valor!=null){
            caso.insertarHijo(valor);
        }
        if(cuerpo!=null){
            caso.insertarHijo(cuerpo);
        }
        return caso;
    }public static Nodo crearNodoLCasos(Nodo  caso1){
        Nodo lcasos=new Nodo(Constante.lcasos);
        if(caso1!=null){
            lcasos.insertarHijo(caso1);
        }
        return lcasos;
    }   
    public static Nodo insertarCaso(Nodo lcasos, Nodo caso){
        if(caso!=null){            
            lcasos.insertarHijo(caso);
        }
        return lcasos;
    }
    public static Nodo crearNodoSentCaso(Nodo val, Nodo lcasos){
        Nodo sent_caso=new Nodo(Constante.caso);
        if(val!=null){
            sent_caso.insertarHijo(val);
        }
        if(lcasos!=null){
            sent_caso.insertarHijo(lcasos);
        }
        return sent_caso;
    }
}
