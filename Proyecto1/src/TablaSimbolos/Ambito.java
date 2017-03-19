/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

import java.util.LinkedList;

/**
 *
 * @author Jenny
 */
public class Ambito {
    private int ambito_padre;
    private int ambito_actual;
    public  LinkedList<NodoTS> variables=new LinkedList<>();

    public Ambito(int ambito_padre, int ambito_actual) {
        this.ambito_padre = ambito_padre;
        this.ambito_actual = ambito_actual;
    }
    public void insertarVariable(NodoTS var){
        this.variables.add(var);
    }
    public void setAmbito_Padre(int ambito_padre){
        this.ambito_padre = ambito_padre;
    }
    public int getAmbito_Padre(){
        return this.ambito_padre;
    }
    public void setAmbito_Actual(int ambito_actual){
        this.ambito_actual = ambito_actual;
    }
    public int getAmbito_Actual(){
        return this.ambito_actual;
    }
    public NodoTS buscarVariable(String nombre){
        for(NodoTS v : this.variables)
        {
            if (v.getNombre().equals(nombre))                
                return v;                
        }
        return null;
    }
    public int buscarVariablePos(String nombre){
        for(int i = 0; i < this.variables.size(); i++) {
            NodoTS v = this.variables.get(i);
            if (v.getNombre().equals(nombre))
                return i;
        }
        return -1;
    }

}
