/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

/**
 *
 * @author Jenny
 */
public class Dim {
    int pos_inicio;
    int pos_fin;    
   
    public Dim(int pos_inicio,int pos_fin){
        this.pos_inicio=pos_inicio;
        this.pos_fin=pos_fin;
    }
    public int getTam(){
        return this.pos_fin - this.pos_inicio +1;
    }

    public int getPos_inicio() {
        return pos_inicio;
    }

    public void setPos_inicio(int pos_inicio) {
        this.pos_inicio = pos_inicio;
    }

    public int getPos_fin() {
        return pos_fin;
    }

    public void setPos_fin(int pos_fin) {
        this.pos_fin = pos_fin;
    }
    public boolean correcto(){
        if(this.pos_fin <= this.pos_inicio){
            return false;
        }
        return true;
    }

    
}
