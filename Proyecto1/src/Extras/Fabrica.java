/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extras;
import Analisis.*;
import com.sun.corba.se.impl.orbutil.closure.Constant;

/**
 *
 * @author Jenny
 */
public class Fabrica {    
    public static Nodo crearNodoOp(String op){
        return new Nodo(op);
    }
    public static Nodo crearNodoHoja(String nombre,String valor, String tipo){    
        int tipo_var=-1;
        switch(tipo){
            case Constante.tnum+"":
            case Constante.tdecimal+"":
            case Constante.tbool+"":
            case Constante.tcadena+"":
            case Constante.tcaracter+"":
            case Constante.tvacio+"":
                tipo_var=Integer.parseInt(tipo);
            break;
            default:
                tipo_var=Constante.tid;
            break;
        }
        return new Nodo(nombre, valor, tipo_var,tipo);        
    }
    public static Nodo crearNodoHoja(String nombre,String valor, int tipo,String tals){        
        return new Nodo(nombre, valor, tipo,tals);        
    }
    public static Nodo crearNodoHoja(String nombre,String valor){        
        return new Nodo(nombre, valor);        
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
    public static Nodo crearNodoLlamado(Nodo lid){
        Nodo llamado=new Nodo(Constante.llamar);
        if(lid!=null){
            llamado.insertarHijo(lid);
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
    public static Nodo crearNodoGraphik(Nodo encabezado, Nodo lals){
        Nodo graphik=new Nodo(Constante.graphik);
        if(encabezado!=null){
            graphik.insertarHijo(encabezado);
        }
        if(lals!=null){
            graphik.insertarHijo(lals);
        }
        return graphik;
    }
    public static Nodo crearNodoImportar(Nodo id){
        Nodo importar=new Nodo(Constante.importar);
        if(id!=null){
            importar.insertarHijo(id);
        }
        return importar;
    }
    public static Nodo crearNodoIncluir(Nodo id){
        Nodo incluir=new Nodo(Constante.incluir);
        if(id!=null){
            incluir.insertarHijo(id);
        }
        return incluir;
    }
    public static Nodo crearNodoEnc(Nodo enc1){
        Nodo encabezado=new Nodo(Constante.encabezado);
        if(enc1!=null){               
            encabezado.insertarHijo(enc1);
        }
        return encabezado;
    }
    public static Nodo insertarEnc(Nodo encabezado, Nodo enc){
        if(enc!=null){            
            encabezado.insertarHijo(enc);
        }
        return encabezado;
    }
    public static Nodo crearNodoLALS(Nodo als1){
        Nodo lals=new Nodo(Constante.als);
        if(als1!=null){               
            lals.insertarHijo(als1);
        }
        return lals;
    }
    public static Nodo insertarALS(Nodo lals, Nodo als){
        if(als!=null){            
            lals.insertarHijo(als);
        }
        return lals;
    }
    public static Nodo crearNodoHereda(String valor){
        Nodo hereda=new Nodo(Constante.hereda);
        hereda.setValor(valor);
        return hereda;
    }
    public static Nodo crearNodoALS(String id,Nodo hereda,Integer visibilidad, Nodo cuerpo){
        Nodo als=new Nodo(Constante.als,id);
        als.insertarHijo(hereda);
        als.setVisibilidad(visibilidad);
        als.insertarHijo(cuerpo);
        return als;
    }
    public static Nodo crearNodoInicio(Nodo cuerpo){
        Nodo inicio=new Nodo(Constante.inicio,"",Constante.tvacio);
        inicio.insertarHijo(cuerpo);
        return inicio;
    }
    public static Nodo crearNodoAsignacion(Nodo lid,Nodo valor,Nodo arr){
        Nodo asig = new Nodo(Constante.asig);
        if(lid!=null){
            asig.insertarHijo(lid);
        }
        if(valor!=null){
            asig.insertarHijo(valor);
        }
        if(arr!=null){
            asig.insertarHijo(arr);
        }
        return asig;
    }
    public static Nodo crearNodoDecFun(String tfun,String valor, Nodo pdecfun, Integer visibilidad, Nodo cuerpo){
        int tipo_var=-1;
        switch(tfun){
            case Constante.tnum+"":
            case Constante.tdecimal+"":
            case Constante.tbool+"":
            case Constante.tcadena+"":
            case Constante.tcaracter+"":
            case Constante.tvacio+"":
                tipo_var=Integer.parseInt(tfun);
            break;
            default:
                tipo_var=Constante.tid;
            break;
        }
        Nodo decfun=new Nodo(Constante.decfun,valor,tipo_var,tfun);
        decfun.setVisibilidad(visibilidad);
        decfun.insertarHijo(pdecfun);
        decfun.insertarHijo(cuerpo);       
        return decfun;
    }
    public static Nodo crearNodoNuevo(String valor){      
        return new Nodo(Constante.nuevo,valor);
    }
    public static Nodo crearNodoIDL(Nodo id1){
        Nodo idl=new Nodo(Constante.idl);
        if(idl!=null){               
            idl.insertarHijo(id1);
        }
        return idl;
    }
    public static Nodo insertarIDL(Nodo idl, Nodo id){
        if(id!=null){            
            idl.insertarHijo(id);
        }
        return idl;
    }
    public static Nodo crearNodoLID(Nodo id1){
        Nodo idl=new Nodo(Constante.lid);
        if(idl!=null){               
            idl.insertarHijo(id1);
        }
        return idl;
    }
    public static Nodo insertarLID(Nodo idl, Nodo id){
        if(id!=null){            
            idl.insertarHijo(id);
        }
        return idl;
    }
    public static Nodo crearNodoDeclaracion(String tvar, String valor, Integer visibilidad, Nodo dec){        
        int tipo_var=-1;
        switch(tvar){
            case Constante.tnum+"":
            case Constante.tdecimal+"":
            case Constante.tbool+"":
            case Constante.tcadena+"":
            case Constante.tcaracter+"":
            case Constante.tvacio+"":
                tipo_var=Integer.parseInt(tvar);
            break;
            default:
                tipo_var=Constante.tid;
            break;
        }
        Nodo id=crearNodoHoja(Constante.id,valor,tipo_var,tvar);
        id.setVisibilidad(visibilidad);
        Nodo declaracion=new Nodo(Constante.dec);
        declaracion.insertarHijo(id);
        if(dec!=null){
            declaracion.insertarHijo(dec);
        }
        return declaracion;
    }    
    public static Nodo crearNodoMientras(String tipo_ciclo, Nodo cond, Nodo cuerpo){
        Nodo mientras=new Nodo(tipo_ciclo);
        mientras.insertarHijo(cond);
        mientras.insertarHijo(cuerpo);
        return mientras;
    }
    public static Nodo crearNodoPara(Nodo varpara,Nodo cond,Nodo posterior,Nodo cuerpo){
        Nodo para=new Nodo(Constante.para);
        if(varpara!=null){
            para.insertarHijo(varpara);
        }
        if(cond!=null){
            para.insertarHijo(cond);
        }
        if(posterior!=null){
            para.insertarHijo(posterior);
        }
        if(cuerpo!=null){
            para.insertarHijo(cuerpo);
        }
        return para;
    }
}
