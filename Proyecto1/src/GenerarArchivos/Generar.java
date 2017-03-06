/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GenerarArchivos;

/**
 *
 * @author Jenny
 */
public class Generar {
    public static void main(String args[]) {
        GenerarLexico.generarHaskell("src/Analisis/HaskellArchivo/LexicoH.jflex");
        GenerarSintactico.generarHaskell();
    }
    
}
