/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import Extras.Constante;
import TablaSimbolos.Ambito;
import java.util.LinkedList;

/**
 *
 * @author Jenny
 */
public class Valor {
    int tipo;
    String valor;
    String tals;
    int cat_retorno;
    public Ambito ambito=null;
    public LinkedList <Valor> valores;
    public LinkedList <Integer> dimensiones;

    public Valor() {
        this.tipo = Constante.tvacio;
        this.valor = "";
        this.tals="";
        this.cat_retorno=-1;
    }
    
    public Valor(int tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.tals="";
        this.cat_retorno=-1;
    }
    public Valor(int tipo, String valor,String tals) {
        this.tipo = tipo;
        this.valor = valor;
        this.tals = tals;
        this.cat_retorno=-1;
    }

    public int getCat_retorno() {
        return cat_retorno;
    }

    public void setCat_retorno(int cat_retorno) {
        this.cat_retorno = cat_retorno;
    }

    public String getTals() {
        return tals;
    }

    public void setTals(String tals) {
        this.tals = tals;
    }
    
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
}
