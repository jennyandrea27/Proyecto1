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
public class Tabla {
    public static LinkedList<Arreglo> arreglos=new LinkedList<>();
    public static void insertarArreglo(Arreglo arr){
        arreglos.add(arr);
    }
    public static Arreglo getArreglo(String nombre){
        for(Arreglo arr :arreglos ){
            if(arr.getNombre().equals(nombre)){
                return arr;
            }
        }
        return null;
    }
    public static void recorrer(){
        for(Arreglo arr:arreglos){
            System.out.println("Arreglo :"+arr.getNombre());
            System.out.println("----->Dimensiones: ");
            int dim=0;
            for(Dim d:arr.dimensiones){                
                System.out.println("----------> "+dim+" "+d.getPos_inicio()+"-"+d.getPos_fin()+"="+d.getTam());
                dim++;
            }
        }
    }
}
