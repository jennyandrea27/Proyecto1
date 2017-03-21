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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
            default:
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
        if(asig.hijos.get(0).hijos.size()==1){//solo tiene un id
            String nombre=asig.hijos.get(0).hijos.get(0).getValor();
            NodoTS variable=TS.buscarVar(nombre, TS.cont_ambito);
            if(variable!=null){
                Valor valor2 = Casteo.Asignacion(variable.getTipo(), valor);
                TS.asignarVar(nombre,valor2);
            }else{
                TablaErrores.insertarError("La variable "+nombre+" no ha sido declarada.", 0, 0);
            }
        }else{//es un acceso id.id.id
            
        }        
    }    
    
    
}
