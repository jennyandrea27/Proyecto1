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
        sentencia.insertarHijo(sent1);
        return sentencia;
    }
    public static Nodo insertarSentencia(Nodo cuerpo, Nodo sent){
        cuerpo.insertarHijo(sent);
        return cuerpo;
    }
    public static Nodo crearNodoFunciones(Nodo fun1){
        Nodo funcion=new Nodo(Constante.funcion);
        funcion.insertarHijo(fun1);
        return funcion;
    }
    public static Nodo insertarFuncion(Nodo funcion, Nodo fun){
        funcion.insertarHijo(fun);
        return funcion;
    }
    
}
