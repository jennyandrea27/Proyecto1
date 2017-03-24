/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import Extras.Constante;
import Reportes.TablaErrores;
import TablaSimbolos.Ambito;
import TablaSimbolos.NodoTS;
import TablaSimbolos.TS;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 *
 * @author Jenny
 */
public class SemanticoGraphik {
    public static Valor evaluarEXP(Nodo op){
        Valor res=new Valor();
        Valor op1=new Valor();
        Valor op2=new Valor();
        switch(op.getNombre()){
            case Constante.suma:
                op1=evaluarEXP(op.getHijo(0));
                op2=evaluarEXP(op.getHijo(1));
                res=Casteo.suma(op1,op2);
                break;
            case Constante.resta:
                //verificar si es resta unaria
                if(op.hijos.size()==1){
                    op1=evaluarEXP(op.getHijo(0));
                    res=Casteo.restaUnaria(op1);
                }else{
                    op1=evaluarEXP(op.getHijo(0));
                    op2=evaluarEXP(op.getHijo(1));
                    res=Casteo.resta(op1,op2);
                }
                break;
            case Constante.mult:
                    op1=evaluarEXP(op.getHijo(0));
                    op2=evaluarEXP(op.getHijo(1));
                    res=Casteo.mult(op1,op2);
                    break;
            case Constante.div:
                    op1=evaluarEXP(op.getHijo(0));
                    op2=evaluarEXP(op.getHijo(1));
                    res=Casteo.division(op1,op2);
                break;
            case Constante.pot:
                    op1=evaluarEXP(op.getHijo(0));
                    op2=evaluarEXP(op.getHijo(1));
                    res=Casteo.potencia(op1,op2);
                    break;
            case Constante.mayor:
                    op1=evaluarEXP(op.getHijo(0));
                    op2=evaluarEXP(op.getHijo(1));
                    res=Casteo.mayor(op1,op2);                
                break;
            case Constante.menor:
                    op1=evaluarEXP(op.getHijo(0));
                    op2=evaluarEXP(op.getHijo(1));
                    res=Casteo.menor(op1,op2);                
                break;
           case Constante.mayorigual:
                    op1=evaluarEXP(op.getHijo(0));
                    op2=evaluarEXP(op.getHijo(1));
                    res=Casteo.mayorigual(op1,op2);                
                break;
           case Constante.menorigual:
                    op1=evaluarEXP(op.getHijo(0));
                    op2=evaluarEXP(op.getHijo(1));
                    res=Casteo.menorigual(op1,op2);                
                break;
           case Constante.igualacion:
                    op1=evaluarEXP(op.getHijo(0));
                    op2=evaluarEXP(op.getHijo(1));
                    res=Casteo.igualacion(op1,op2);                
                break;
            case Constante.distinto:
                    op1=evaluarEXP(op.getHijo(0));
                    op2=evaluarEXP(op.getHijo(1));
                    res=Casteo.distinto(op1,op2);                
                break;
            case Constante.o:
                    op1=evaluarEXP(op.getHijo(0));
                    op2=evaluarEXP(op.getHijo(1));
                    res=Casteo.or(op1,op2);                
                break;
           case Constante.y:
                    op1=evaluarEXP(op.getHijo(0));
                    op2=evaluarEXP(op.getHijo(1));
                    res=Casteo.and(op1,op2);                
                break;
           case Constante.not:               
                    op1=evaluarEXP(op.getHijo(0));
                    res=Casteo.not(op1);                                                  
                break;
           case Constante.xor:
                    op1=evaluarEXP(op.getHijo(0));
                    op2=evaluarEXP(op.getHijo(1));
                    res=Casteo.xor(op1,op2);   
                 break;
           case Constante.lid:
               NodoTS lid=accederLID(op);
               if(lid!=null){
                   res=new Valor(lid.getTipo(),lid.getValor());
                    if(lid.getTipo()== Constante.tid){
                        res.setTals(lid.getTals());
                        res.ambito=(Ambito)lid.ambito;
                    }
               }
               break;
            default://es valor puntual
                return new Valor(op.getTipo(),op.getValor());
        }
        return res;
    }
    public static void asignacionVar(Nodo asig){
        //obtener el valor almacenado en hijos(1)
        Valor res;
        Valor valor = evaluarEXP(asig.hijos.get(1));
        System.out.println("Valor: "+valor.getValor()+" Tipo: "+Casteo.valTipo(valor.getTipo()));
        //obtener id
        String nombre=asig.hijos.get(0).hijos.get(0).getValor();
        if(asig.hijos.get(0).getNombre().equals(Constante.lid)){
                //se tiene una lista de id's llamada a metodo accesoLID
                NodoTS acceso=accederLID(asig.hijos.get(0));
                if(acceso!=null){
                    //se obtuvo valor de la lista de id's
                    Valor valor2 = Casteo.Asignacion(acceso.getTipo(), valor);
                    if(valor2.getTipo()==Constante.terror)
                        TablaErrores.insertarError(valor2.getValor(), 1, 1);
                    else
                        acceso.setValor(valor2.getValor());
                }
            }
        //asigna a variable 
        if(asig.hijos.get(0).hijos.size()==1){//solo tiene un id
            NodoTS variable=TS.buscarVar(nombre, TS.cont_ambito);
            if(variable!=null){
                Valor valor2 = Casteo.Asignacion(variable.getTipo(), valor);
                if(valor2.getTipo() == Constante.terror){                    
                    TablaErrores.insertarError(valor2.getValor(), 1, 1);
                }else{
                    TS.asignarVar(nombre,valor2);                    
                }
            }else{
                TablaErrores.insertarError("Error semantico, la variable "+nombre+" no ha sido declarada.", 0, 0);
            }
        }else{//es un acceso id.id.id
            
        }        
    }    
    public static NodoTS accederLID(Nodo lid){
        //obtener primer id
        NodoTS variable=null;
        boolean salir=false;
        int cont =1;
        String nombre=lid.hijos.get(0).getValor();
        //verificar si el primer id tiene parametros, es una funcion
        Nodo id1=lid.hijos.get(0);
        if(id1.hijos.size()>0){//es una funcion
            //funcion declarada en clase de metodo inicio
            //obtener parametros de funcion
            //generar lista de parametros del llamado
            Nodo lpar = id1.hijos.get(0);
            String p="";
            LinkedList<Valor> par_llamado = new LinkedList<Valor>();
            for(Nodo hijo : lpar.hijos)
            {
                Valor par = SemanticoGraphik.evaluarEXP(hijo);
                p += Casteo.valTipo(par.getTipo())+"_";
                par_llamado.add(par);
            }
            //buscar funcion
            Nodo fun=Recorrido.buscarFun(nombre, null,par_llamado);
            if(fun !=null){
            //ejecutar funcion
            //insertar ambito funcion
            TS.insertarAmbito(-1);
            variable=SemanticoGraphik.ejecutarFun(fun,par_llamado);    
            //eliminar ambito funcion
            TS.eliminarAmbito();
            }else{                
                TablaErrores.insertarError("Error semantico, la funcion "+nombre+"_"+p+" no ha sido declarada.", 0, 0);
                return null;
            }
        }else{
            //es una variable            
            variable=TS.buscarVar(nombre, TS.cont_ambito);            
        }
        while(cont < lid.hijos.size() && !salir){            
            if(variable!=null){                                
                //verficar si variable es tipo id
                if(variable.getTipo() == Constante.tid){
                    //puede tener atributos
                    //verificar si el siguiente es tipo funcion
                    if(lid.hijos.get(cont).hijos.size()>0){//es una funcion
                        String nombre1=nombre;
                        nombre=lid.hijos.get(cont).getValor();
                        id1=lid.hijos.get(cont);
                        Nodo lpar = id1.hijos.get(0);
                        String p="";
                        LinkedList<Valor> par_llamado = new LinkedList<Valor>();
                        for(Nodo hijo : lpar.hijos)
                        {
                            Valor par = SemanticoGraphik.evaluarEXP(hijo);
                            p += Casteo.valTipo(par.getTipo())+"_";
                            par_llamado.add(par);
                        }
                        Nodo fun=Recorrido.buscarFun(nombre, variable.getTals(),par_llamado);
                            if(fun !=null){
                            //ejecutar funcion
                            //agregar ambito de la clase que llama a funcion variable.funcion
                            TS.cont_ambito++;
                            variable.ambito.setAmbito_Actual(TS.cont_ambito);
                            TS.lista_ambitos.add(variable.ambito);
                            //agregar ambito de la funcion
                            TS.insertarAmbito(variable.ambito.getAmbito_Actual());
                            //verificar visibilidad
                            if(fun.getVisibilidad()==Constante.privado || fun.getVisibilidad()==Constante.protegido){
                                salir=true;
                                TablaErrores.insertarError("Error semantico, la visibilidad de la funcion "+nombre+"_"+p+" no permite acceder a ella.", 0, 0);                                
                            }else{
                                variable=SemanticoGraphik.ejecutarFun(fun,par_llamado);    
                            }
                            //eliminar ambito de funcion
                            TS.eliminarAmbito();
                            }else{
                                salir=true;
                                TablaErrores.insertarError("Error semantico, la funcion "+nombre+"_"+p+" no ha sido declarada.", 0, 0);
                            }
                    }else{                        
                        if(variable.ambito!=null){
                            String nombre1=nombre;
                            if(variable.getVisibilidad() == Constante.privado || variable.getVisibilidad() == Constante.protegido){
                                salir=true;
                                TablaErrores.insertarError("Error semantico, la visibilidad de ALS "+nombre1+"  no permite acceder a atributos.", cont, cont);
                            }else{                                
                                nombre=lid.hijos.get(cont).getValor();
                                variable=variable.ambito.buscarVariable(nombre);                            
                                if(variable== null){
                                    salir=true;
                                    TablaErrores.insertarError("Error semantico, ALS "+nombre1+" no contiene atributo "+nombre, cont, cont);
                                }
                            }
                        }else{
                            //variable no ha sido inicializada
                            salir=true;
                            TablaErrores.insertarError("Error semantico, variable "+nombre+" no ha sido inicializada.", 1, 1);
                        }
                    }
                }else{
                    //es atributo
                    salir=true;
                    TablaErrores.insertarError("Error semantico, ariable "+nombre+" no es de tipo ALS.", 1, 1);
                }
            }else{
                //variable no ha sido declarada
                salir=true;
            }
            cont++;
        }
        if(!salir){
            //no hubo errores en acceso
            return variable;
        }
        return null;
    }
    public static Valor llamar(Nodo llamar){
        Valor resultado=new Valor();
            //nodo llamar tiene lista de id's
            //verificar si el ultimo id es una funcion
            Nodo lid=llamar.hijos.get(0);
            int tam_lid=lid.hijos.size();
            Nodo ultimo=lid.hijos.get(tam_lid-1);
            if(ultimo.hijos.size()>0){
                //tiene parametros, es una funcion
                //llamar a metodo accederLID
                NodoTS res=accederLID(lid);
                if(res!=null){                    
                    resultado=new Valor(res.getTipo(), res.getValor(), res.getTals());
                }
            }else{
                //error id al cual se quiere acceder no es una funcion
                TablaErrores.insertarError("El id "+ultimo.getValor()+" no es una funcion.", tam_lid, tam_lid);
            }
            return resultado;
    }
    public static NodoTS ejecutarFun(Nodo funcion,LinkedList<Valor> par_llamado){
        NodoTS res=null;
        //insertar variable de retorno
        NodoTS retorno=new NodoTS(Constante.retornar,funcion.getTipo(),"");
        retorno.setTals(funcion.getTals());
        TS.insertarVariable(retorno);
        //recorrer las variables y agregarlas a ambito
        Nodo l_par_fun = funcion.hijos.get(0);
            for (int i = 0; i < l_par_fun.hijos.size(); i++)
            {
                String nombre = l_par_fun.hijos.get(i).getValor();
                int tipo = par_llamado.get(i).getTipo();
                String valor = par_llamado.get(i).getValor();
                NodoTS par = new NodoTS(nombre, tipo, valor);
                TS.insertarVariable(par);
            }            
        //ejecutar cuerpo funcion
        Valor ret=Recorrido.recorrerSent(funcion.hijos.get(1));
        //verificar si tipo de retorno coincide
        if(retorno.getTipo() == ret.getTipo()){
            //si son tipo objeto verificar que sea el mismo ALS
            if(retorno.getTipo() == Constante.tid){
                if(retorno.getTals().equals(ret.getTals())){
                    res=new NodoTS(funcion.getValor(),ret.getTipo(),ret.getValor());                
                    res.setTals(ret.getTals());
                    res.ambito=(Ambito)ret.ambito;
                }else{
                    TablaErrores.insertarError("Error semantico, la funcion "+funcion.getValor()+" no fue declarada de tipo "+ret.getTals(), 0, 0);                
                }
            }else{
                res=new NodoTS(funcion.getValor(),ret.getTipo(),ret.getValor());                                
            }
        }else{
            TablaErrores.insertarError("Error semantico, la funcion "+funcion.getValor()+" no fue declarada de tipo "+Casteo.valTipo(ret.getTipo()), 0, 0);                            
        }
        return res;
    }
}
