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
    
    public static void generar(){
        String [] opciones=new String[7];
        opciones[0]="-destdir";
        opciones[1]="src/Analisis";
        opciones[2]="-symbols";
        opciones[3]="TS";
        opciones[4]="-parser";
        opciones[5]="Sintactico";
        opciones[6]="src/Analisis/Sintactico.cup";
        try{
            java_cup.Main.main(opciones);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
