/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import Extras.Constante;
import java.util.LinkedList;

/**
 *
 * @author Jenny
 */
public class MemoriaHaskell {
    public static Nodo raiz=new Nodo("HK");
    
    public static Nodo buscarFun(String nombre,LinkedList <Valor> par_llamado){            
            for(Nodo sent:raiz.hijos){       
                int cant_par=sent.hijos.get(0).hijos.size();
                if(sent.getValor().equals(nombre) && cant_par==par_llamado.size())  {
                    //se ha encontrado funcion
                    return sent;                    
                }//coincide nombre                
            }//for
            return null;
        }
    
}
