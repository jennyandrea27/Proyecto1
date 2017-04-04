/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import Analisis.Valor;
import java.util.LinkedList;

/**
 *
 * @author Jenny
 */
public class Dato {
    public LinkedList<Valor> columnas=new LinkedList<>();     
    
    public Dato(Dato d){
        for(Valor v:d.columnas){
            Valor nuevo=new Valor(v.getTipo(), v.getValor());
            this.columnas.add(nuevo);
        }
    }
    public Dato(){
        this.columnas=new LinkedList<>();     
    }
}
