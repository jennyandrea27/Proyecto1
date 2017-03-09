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
public class GenerarSintactico {                
    
    public static void generarHaskell(){
        String [] opciones=new String[7];
        opciones[0]="-destdir";
        opciones[1]="src/Analisis/HaskellArchivo";
        opciones[2]="-symbols";
        opciones[3]="TSHaskell";
        opciones[4]="-parser";
        opciones[5]="SintacticoH";
        opciones[6]="src/Analisis/HaskellArchivo/SintacticoH.cup";
        try{
            java_cup.Main.main(opciones);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void generarGraphik(){
        String [] opciones=new String[7];
        opciones[0]="-destdir";
        opciones[1]="src/Analisis/Graphik";
        opciones[2]="-symbols";
        opciones[3]="TSGraphik";
        opciones[4]="-parser";
        opciones[5]="SintacticoG";
        opciones[6]="src/Analisis/Graphik/SintacticoG.cup";
        try{
            java_cup.Main.main(opciones);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
