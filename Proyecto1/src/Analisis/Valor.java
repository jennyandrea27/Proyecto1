/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import Extras.Constante;

/**
 *
 * @author Jenny
 */
public class Valor {
    int tipo;
    String valor;
    String tals;

    public Valor() {
        this.tipo = Constante.tvacio;
        this.valor = "";
    }
    
    public Valor(int tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
    public Valor(int tipo, String valor,String tals) {
        this.tipo = tipo;
        this.valor = valor;
        this.tals = tals;
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
