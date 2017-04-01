/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import Analisis.HaskellTerminal.TSHT;
import static Analisis.RecorridoHT.porcentaje;
import Extras.Constante;
import Reportes.TablaErrores;
import TablaSimbolos.Ambito;
import TablaSimbolos.NodoTS;
import TablaSimbolos.TS;
import static TablaSimbolos.TS.cont_ambito;
import static TablaSimbolos.TS.lista_ambitos;
import static TablaSimbolos.TS.nuevoALS;
import TablaSimbolos.TSH;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import proyecto1.FormInicio;

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
            case Constante.potencia:
                    op1=evaluarEXP(op.getHijo(0));
                    op2=evaluarEXP(op.getHijo(1));
                    res=Casteo.potencia(op1,op2);
                    break;
            case Constante.mod:
                    op1=evaluarEXP(op.getHijo(0));
                    op2=evaluarEXP(op.getHijo(1));
                    res=Casteo.mod(op1,op2);
                break;
            case Constante.sqrt:
                    op1=evaluarEXP(op.getHijo(0));
                    op2=evaluarEXP(op.getHijo(1));
                    res=Casteo.sqrt(op1,op2);
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
               if(op.hijos.get(op.hijos.size()-1).hijos.size()==0){
                    NodoTS lid=accederLID(op);
                    if(lid!=null){
                        res=new Valor(lid.getTipo(),lid.getValor());
                         if(lid.getTipo()== Constante.tid){
                             res.setTals(lid.getTals());
                             res.ambito=(Ambito)lid.ambito;
                         }
                    }else{
                        String er="";
                        for(Nodo n:op.hijos){
                            er+=n.getValor()+".";
                        }
                        er=er.substring(0,er.length()-1);
                      TablaErrores.insertarError("Error semantio, la variable "+er+" no ha sido declarada.", 0, 0);
                    }
               }else{
                        String er="";
                        for(Nodo n:op.hijos){
                            er+=n.getValor()+".";
                        }
                        er=er.substring(0,er.length()-1);
                        TablaErrores.insertarError("Error semantio, la variable "+er+" no se encuentra dentro de instruccion LLAMAR.", 0, 0);                        
               }
               break;
           case Constante.llamar:
               res=llamar(op);
               break;
            case Constante.porcentaje:
             res=new Valor(porcentaje.getTipo(),porcentaje.getValor());
             break;    
           case Constante.llamado:
               res=MemoriaHaskell.llamado(op);
               if(res.getTipo()==Constante.terror){
                    TablaErrores.insertarError(res.getValor(), 1, 1);
               }
                break;
           case Constante.id:
               NodoTS buscar=TS.buscarVar(op.getValor(), TS.cont_ambito);
               if(buscar!=null){
                   res=new Valor(buscar.getTipo(), buscar.getValor());
               }else{
                   //buscar en la tabla de simbolos de haskell terminal si existe la variable
                   NodoTS buscar2=TSH.buscarVar(op.getValor(), TSH.cont_ambito);
                   if(buscar2!=null){
                       res=new Valor(buscar2.getTipo(), buscar2.getValor());
                       if(buscar2.dimensiones!=null){
                           res.dimensiones=buscar2.dimensiones;                           
                       }
                       if(buscar2.valores!=null){
                           res.valores=buscar2.valores;
                       }
                   }else{
                       res=new Valor(Constante.terror, "La variable "+op.getNombre()+" no ha sido declarada.");
                   }
               }
               break;
           case Constante.calcular:
           case Constante.sum:
           case Constante.product:
           case Constante.max:
           case Constante.length:
           case Constante.acceso:
           case Constante.succ:
           case Constante.dec:
               res=RecorridoHT.ejecutarSent(op);
               break;
            default://es valor puntual
                return new Valor(op.getTipo(),op.getValor());
        }
        return res;
    }
    
    public static void asignacionVar(Nodo asig){
        //obtener el valor almacenado en hijos(1)
        Valor res;
        Valor valor=new Valor();
        NodoTS acceso=accederLID(asig.hijos.get(0));
        if(asig.hijos.get(1).getNombre().equals(Constante.nuevo)){
            //verificar si es tipo id
            if(acceso.getTipo()==Constante.tid){
                //es un objeto, buscar nodo de la clase que se instancia
                    String nombre_obj=asig.hijos.get(1).getValor();
                    Nodo clase=Recorrido.buscarClase(nombre_obj);
                    if(clase!=null){
                        acceso.ambito=new Ambito(-1, cont_ambito);
                        nuevoALS(clase.hijos.get(1),acceso.ambito);                        
                    }else{
                        //clase no ha sido declarada
                        TablaErrores.insertarError("ALS "+nombre_obj+" no ha sido declarado.", 1, 1);
                    }
            }else{
                TablaErrores.insertarError("Variable no ha sido declarada de tipo ALS.", 1, 1);
            }
        }else{            
            valor = evaluarEXP(asig.hijos.get(1));
            //obtener id
            String nombre=asig.hijos.get(0).hijos.get(0).getValor();        
            if(asig.hijos.get(0).getNombre().equals(Constante.lid)){
                    //se tiene una lista de id's llamada a metodo accesoLID
                    if(acceso!=null){
                        //se obtuvo valor de la lista de id's
                        Valor valor2 = Casteo.Asignacion(acceso.getTipo(), valor,acceso.getTals());
                        if(valor2.getTipo()==Constante.terror)
                            TablaErrores.insertarError(valor2.getValor(), 1, 1);
                        else
                        {
                           acceso.setValor(valor2.getValor());
                            if(valor.getTipo()==Constante.tid){
                                acceso.setTals(valor.getTals());
                                acceso.ambito=(Ambito)valor.ambito;
                            }

                        }
                    }
                }      
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
            //insertar ambito funcion
            TS.insertarAmbito(-1);
            //ejecutar funcion
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
                            //eliminar ambito de la variable anterior
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
                    TablaErrores.insertarError("Error semantico, variable "+nombre+" no es de tipo ALS.", 1, 1);
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
                    if(res.getTipo()==Constante.tid){
                        //agregar ambito y tipo als a res
                        resultado.setTals(res.getTals());
                        resultado.ambito=(Ambito)res.ambito;
                    }
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
                if(par_llamado.get(i).getTipo()==Constante.tid){
                    par.ambito=(Ambito)par_llamado.get(i).ambito;
                    par.setTals(par_llamado.get(i).getTals());
                }
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
            TablaErrores.insertarError("Error semantico, la funcion "+funcion.getValor()+"_"+Casteo.valTipo(funcion.getTipo())+" no fue declarada de tipo "+Casteo.valTipo(ret.getTipo()), 0, 0);                            
        }
        return res;
    }
    public static void imprimir(Nodo imprimir){
        Valor val1=evaluarEXP(imprimir.hijos.get(0));
        Valor val_imprimir=Casteo.Asignacion(Constante.tcadena, val1,"");
        if(val_imprimir.getTipo()==Constante.terror || val_imprimir.getTipo()==-1){
            TablaErrores.insertarError("Error semantico, sentencia imprimir no recibe parametro tipo "+Casteo.valTipo(val1.getTipo()),1,1);
        }else{
            FormInicio.texto_salida+=val_imprimir.getValor()+"\n";
        }
    }
    public static Valor si(Nodo si){
        Valor cond=evaluarEXP(si.hijos.get(0));
        Valor res=new Valor();
        if(cond.getTipo()==Constante.tbool){
            if(cond.getValor().equals(Constante.verdadero)){
                //ejecutar sentencias verdaderas
                res=Recorrido.recorrerSent(si.hijos.get(1));
            }else{
                //ejecutar sentencias falsas
                if(si.hijos.size()==3){                    
                    res=Recorrido.recorrerSent(si.hijos.get(2));                    
                }
            }
        }else{
            //la expresion no es de tipo bool
            TablaErrores.insertarError("Error semantico, no puede evaluarse "+Casteo.valTipo(cond.getTipo())+" como condicion en sentencia Si.", 0, 0);
        }
        return res;
    }
    public static Valor seleccion(Nodo seleccion){
        Valor res=new Valor();
        TS.insertarAmbito(TS.cont_ambito);
        //obtener variable de control
        Valor var_sel=evaluarEXP(seleccion.hijos.get(0));
        if(var_sel.getTipo() == Constante.tid){
            TablaErrores.insertarError("Error semantico, no puede evaluarse "+Casteo.valTipo(var_sel.getTipo())+" como variable en sentencia Seleccion.",1, 1);
        }else{            
        //compara con que caso coincide valor de var_sel
        int pos=-1;
        boolean b_pos=false;
        Nodo lcasos=seleccion.hijos.get(1);
        while(!b_pos){
            //se guarda posicion de caso que coincide
            pos++;
            Nodo caso=lcasos.hijos.get(pos);    
            if(!caso.getNombre().equals(Constante.defecto)){                
                Valor val_caso=evaluarEXP(caso.hijos.get(0));
                if(val_caso.getValor().equals(var_sel.getValor())){                
                    break;
                }           
            }else{
                b_pos=true;
            }
            
        }
            //se ejecuta a partir del caso ubicado en pos hasta encontrar break
            boolean ejecuta=true;
            while(ejecuta && pos<lcasos.hijos.size()){                
                Nodo caso=lcasos.hijos.get(pos);
                if(caso.getNombre().equals(Constante.defecto)){
                    //entro a defecto cuerpo esta en posicion 1
                    res=Recorrido.recorrerSent(caso.hijos.get(0));
                }else{                    
                    res=Recorrido.recorrerSent(caso.hijos.get(1));
                }
                  if(res.getCat_retorno()==Constante.cat_continuar || res.getCat_retorno()==Constante.cat_retornar){                    
                    ejecuta=false;
                }else if (res.getCat_retorno()==Constante.cat_terminar){
                    res.setCat_retorno(-1);
                    ejecuta=false;                    
                }
                pos++;
            }            
        }
        TS.eliminarAmbito();
        return res;
    }
    public static Valor para(Nodo para){
        Valor res=new Valor();
        TS.insertarAmbito(TS.cont_ambito);
        if(para.hijos.get(0).getNombre().equals(Constante.dec)){
            //se debe agregar la variable de control al ambito de sentencia para
            TS.declararVar(para.hijos.get(0));
        }else{
            //es una asignacion asignar valor inicial a variable de control 
            asignacionVar(para.hijos.get(0));
        }
        //evaluar si la condicion se cumple
        Valor cond=evaluarEXP(para.hijos.get(1));
        if(cond.getTipo()==Constante.tbool){            
            //ejecutar cuerpo
            while(cond.getValor().equals(Constante.verdadero)){
                res=Recorrido.recorrerSent(para.hijos.get(3));
                if(res.getCat_retorno()==Constante.cat_continuar){
                    res.setCat_retorno(-1);
                }else if (res.getCat_retorno()==Constante.cat_terminar){
                    res.setCat_retorno(-1);
                    break;
                }else if (res.getCat_retorno()==Constante.cat_retornar){
                    break;
                }
                //ejecutar operacion posterio a la variable de control
                asignacionVar(para.hijos.get(2));
                //evaluar nuevamente la condicion
                cond=evaluarEXP(para.hijos.get(1));
            }
        }else{
            TablaErrores.insertarError("Error semantico, no puede evaluarse "+Casteo.valTipo(cond.getTipo())+" como condicoin en sentencia Para.", 1, 1);
        }
        TS.eliminarAmbito();
        return res;
    }
    public static Valor mientras(Nodo mientras){
        Valor cond=evaluarEXP(mientras.hijos.get(0));
        Valor res=new Valor();
        if(cond.getTipo()==Constante.tbool){
            TS.insertarAmbito(TS.cont_ambito);
            while(cond.getValor().equals(Constante.verdadero)){
                res=Recorrido.recorrerSent(mientras.hijos.get(1));
                if(res.getCat_retorno()==Constante.cat_continuar){
                    res.setCat_retorno(-1);
                }else if (res.getCat_retorno()==Constante.cat_terminar){
                    res.setCat_retorno(-1);
                    break;
                }else if (res.getCat_retorno()==Constante.cat_retornar){
                    break;
                }
                cond=evaluarEXP(mientras.hijos.get(0));
            }
            TS.eliminarAmbito();
        }else{
            TablaErrores.insertarError("Error semantico, no puede evaluarse "+Casteo.valTipo(cond.getTipo())+" en sentencia Mientras.", 0, 0);            
        }
        return res;
    }
    public static Valor hacerMientras(Nodo hacer ){
        Valor cond=evaluarEXP(hacer.hijos.get(0));
        Valor res=new Valor();
        if(cond.getTipo()==Constante.tbool){
            TS.insertarAmbito(TS.cont_ambito);
            do{                
                res=Recorrido.recorrerSent(hacer.hijos.get(1));
                if(res.getCat_retorno()==Constante.cat_continuar){
                    res.setCat_retorno(-1);
                }else if (res.getCat_retorno()==Constante.cat_terminar){
                    res.setCat_retorno(-1);
                    break;
                }else if (res.getCat_retorno()==Constante.cat_retornar){
                    break;
                }
                cond=evaluarEXP(hacer.hijos.get(0));}
                while(cond.getValor().equals(Constante.verdadero));
            TS.eliminarAmbito();
        }else{
            TablaErrores.insertarError("Error semantico, no puede evaluarse "+Casteo.valTipo(cond.getTipo())+" en sentencia Hacer-Mientras.", 0, 0);            
        }
        return res;        
    }    

    public static NodoTS asigArr(NodoTS arr,Nodo asig) {        
        Nodo dimensiones=asig.hijos.get(0);
        int total_dim=dimensiones.hijos.size();
        int total_datos=1;
        Nodo valores=asig.hijos.get(1);
        //agregar dimensiones a NodoTS
        for(Nodo dim:dimensiones.hijos){
            Valor d=evaluarEXP(dim);
            if(d.getTipo()==Constante.tnum){
                arr.dimensiones.add(Integer.parseInt(d.getValor()));
                total_datos*=Integer.parseInt(d.getValor());
            }else{
                TablaErrores.insertarError("Error semantico, no puede evaluarse "+Casteo.valTipo(d.getTipo())+" en dimension del arreglo "+arr.getNombre()+".", total_dim, total_dim);
            }
        }
        //metodo que verifica que las dimensiones coincidan con los elementos ingresados
        boolean ingresar=valoresArreglo(arr,valores,total_dim-1);
        if(!ingresar){
            arr.valores.clear();
            for(int i=0;i<total_datos;i++){
                Valor v=new Valor(arr.getTipo(), null);
                arr.valores.add(v);
            }
        }
        
        return arr;
    }
    public static boolean  valoresArreglo(NodoTS arreglo,Nodo valores,int dim){
        boolean b=true;
        if(arreglo.dimensiones.get(dim) == valores.hijos.size()){
            //coincide dimension
            if(valores.getNombre().equals(Constante.lpar)){
                for(Nodo v:valores.hijos){
                    Valor val=evaluarEXP(v);
                    Valor val_casteo=Casteo.Asignacion(arreglo.getTipo(), val, "");
                    if(val_casteo.getTipo()==Constante.terror){
                        TablaErrores.insertarError("Error semantico, el arreglo "+arreglo.getValor()+" fue declarado de tipo "+Casteo.valTipo(arreglo.getTipo()),4 , 4);
                        b=false;                        
                    }else{
                        arreglo.valores.add(val);                        
                    }                    
                }
            }else{
                //se manda recursion
                for(Nodo v:valores.hijos){                    
                    b=valoresArreglo(arreglo,v,dim-1);
                }
            }            
        }else{
            TablaErrores.insertarError("Error semantico, las dimensiones declaradas del arreglo "+arreglo.getNombre()+" no coinciden con los datos ingresados.", dim, dim);
            b=false;
        }
        return b;
    }
    
    
}
