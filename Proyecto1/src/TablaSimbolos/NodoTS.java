/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

import Analisis.Valor;
import java.util.LinkedList;

/**
 *
 * @author Jenny
 */
public class NodoTS {
    private String nombre;
    private Valor valor=new Valor();
    public LinkedList<NodoTS> atributos=new LinkedList<>();

    public NodoTS(String nombre) {
        this.nombre = nombre;
    }
    public NodoTS(String nombre, int tipo,String valor) {
        this.nombre = nombre;
        this.valor.setTipo(tipo);
        this.valor.setValor(valor);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setValor(String valor){
        this.valor.setValor(valor);
    }
    public String getValor(){
        return this.valor.getValor();
    }
    public void setTipo(int tipo){
        this.valor.setTipo(tipo);
    }
    public int getTipo(){
        return this.valor.getTipo();
    }
}
