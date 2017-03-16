/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import Extras.Constante;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Jenny
 */
public class SemanticoGraphik {
    public static Valor evaluarEXP(Nodo op){
        switch(op.getNombre()){
            case Constante.suma:
                Valor op1=evaluarEXP(op.getHijo(0));
                Valor op2=evaluarEXP(op.getHijo(1));
                Casteo.suma(op1,op2);
                break;
            default:
                return new Valor(op.getTipo(),op.getValor());
        }
        return null;
    }
    public static void asignacionVar(Nodo asig){
        //obtener id
        //buscar variable en el ambito actual
        //obtener el valor almacenado en hijos(1)
        Valor res;
        Valor valor = evaluarEXP(asig.hijos.get(1));
        //asignar valor en TS
        
    }
    
    
}
