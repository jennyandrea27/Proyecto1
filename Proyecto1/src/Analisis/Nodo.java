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

    
    
    
    
}
