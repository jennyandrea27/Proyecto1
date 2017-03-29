package GenerarArchivos;


import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jenny
 */
public class GenerarLexico {
        
    public static void generarHaskell(String ruta){
        File archivo=new File(ruta);
        jflex.Main.generate(archivo);
    }
    public static void generarHaskellTerminal(String ruta){
        File archivo=new File(ruta);
        jflex.Main.generate(archivo);
    }
    public static void generarGraphik(String ruta){
        File archivo=new File(ruta);
        jflex.Main.generate(archivo);
    }
}
