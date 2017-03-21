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
public class Arreglo {
    String nombre;
    public LinkedList<Dim> dimensiones;
    boolean error;
    int cont_dim;

    public Arreglo(String nombre) {
        this.nombre = nombre;
        this.dimensiones=new LinkedList();
        this.error=false;
        this.cont_dim=0;
    }
    public void insertarDim(Dim dim){
        this.dimensiones.add(dim);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean getError() {
        return error;
    }
    public Dim getDim(int cont) {
        return dimensiones.get(cont);
    }
    public void setError(boolean error) {
        this.error = error;
    }
    public int getContDim() {
        return cont_dim;
    }
    public void setContDim() {
        this.cont_dim++;
    }
    public int getTamano(int pos){
        int tam=1;
        for(int i =0;i<pos;i++){
            tam=tam*dimensiones.get(i).getTam();
        }
        return tam;
    }
    
}
