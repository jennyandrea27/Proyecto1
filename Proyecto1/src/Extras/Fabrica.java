/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extras;
import Analisis.*;

/**
 *
 * @author Jenny
 */
public class Fabrica {
    public static Nodo crearNodoId(String nombre){
        return new Nodo(nombre);
    }
    
}
