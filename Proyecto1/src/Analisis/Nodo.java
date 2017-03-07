/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import java.util.LinkedList;

/**
 *
 * @author Jenny
 */
public class Nodo {
    String nombre;
    int tipo;
    int fila;
    int columna;
    String valor;
    LinkedList <Nodo>  hijos=new LinkedList<Nodo>();

    public Nodo(String nombre, int tipo, int fila, int columna, String valor) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
    }

    public Nodo(String nombre) {
        this.nombre = nombre;
    }

    public Nodo(String nombre, String valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public void insertarHijo(Nodo hijo){
        this.hijos.add(hijo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
    
}
