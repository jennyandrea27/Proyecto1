/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import Extras.Constante;
import Reportes.TablaErrores;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 *
 * @author Jenny
 */
public class SemanticoHaskell {
    public static Nodo raiz;    
    
    public static void graficar() throws IOException{
        String dot=ArchivoDot.getGrafo(raiz);
        //System.out.println(dot);
        try
        {
            FileWriter fw = new FileWriter("C:\\Users\\Jenny\\Desktop\\Haskell.dot");
            PrintWriter pw = new PrintWriter(fw);
            pw.print(dot);
            fw.close();

            String dirImagen = "C:\\Users\\Jenny\\Desktop\\ASTHaskell.png";
            String dirDot = "C:\\Users\\Jenny\\Desktop\\Haskell.dot";
            ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", dirImagen, dirDot );
            pbuilder.redirectErrorStream( true );
            //Ejecuta el proceso
            pbuilder.start();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
    
    public static Valor succ(Nodo succ){
        Valor res=new Valor();
        res=RecorridoHT.ejecutarSent(succ.hijos.get(0));
        res.setValor((Double.parseDouble(res.getValor())+1)+"");
        return res;
    }
    public static Valor decc(Nodo decc){
        Valor res=new Valor();
        res=RecorridoHT.ejecutarSent(decc.hijos.get(0));
        res.setValor((Double.parseDouble(res.getValor())-1)+"");
        return res;
    }
    public static Valor list(Nodo list){
        Valor res=new Valor();    
        res.dimensiones=new LinkedList<>();
        res.valores=new LinkedList<>();
        int tipo=-1;
        //obtener primer hijo de list
        Nodo lasig=list.hijos.get(0);
        //verificar si es arreglo de dos dimensiones
        if(lasig.hijos.get(0).getNombre().equals(Constante.asig)){
            //cantidad de hijos de lasig es la cantidad de dimensiones
            int dim=lasig.hijos.size();
            for(Nodo asig:lasig.hijos){
                //por cada hijo se crea una dimension
                Valor dimension=lista_asig(asig);
                if(dimension.getTipo()!= Constante.terror){
                    res.dimensiones.add(Integer.valueOf(dimension.valores.size()));
                    res.valores.add(dimension);
                    tipo=dimension.getTipo();
                }                
            }
            res.setValor(list.getValor());
            res.setTipo(tipo);
            int tam=res.dimensiones.get(0);
                boolean valido=true;
                for(int i =1;i<res.dimensiones.size();i++){
                    if(tam!=res.dimensiones.get(i)){
                        valido=false;
                    }
                }
                if(!valido){
                    res=new Valor(Constante.terror,"Error semantico, las dimensiones asignadas a lista '"+res.getValor()+"' no coinciden.");
                }
        }else{
            //es de una dimension
            //cada hijo de lasig es calcular, un nuevo valor a agregar en la lista de valores de la lista
            Valor dimension=lista_asig(lasig);
            //verificar si no se encontro un error
            if(dimension.getTipo()==Constante.terror){
                TablaErrores.insertarError(dimension.getValor(), 1, 1);                
            }else{
                //inicializar variable lista
                res=new Valor(dimension.getTipo(), list.getValor());
                res.dimensiones=new LinkedList<>();
                res.valores=new LinkedList<>();
                //agregar tama;o de la dimension
                res.dimensiones.add(Integer.valueOf(dimension.valores.size()));
                //recorrer cada valor para agregarlo a valores de la lista
                res.valores.addAll(dimension.valores);
            }
        }
        return res;
    }
    public static Valor lista_asig(Nodo asig){
        Valor res=new Valor();        
        res.valores=new LinkedList<>();
        //res es una dimension
        //recorrer cada uno de sus hijos que representa un valor que pertenece a esa dimension
        Valor primero=RecorridoHT.ejecutarSent(asig.hijos.get(0));
        res.valores.add(primero);
        int tipo_lista=primero.getTipo();
        //boolean valido indica si los tipos de valores coinciden
        boolean valido=true;
        for(int i=1;i<asig.hijos.size();i++){
            Nodo val=asig.hijos.get(i);
            Valor valor=RecorridoHT.ejecutarSent(val);            
            if(valor.getTipo() != tipo_lista){
                valido=false;
            }
            res.valores.add(valor);
        }
        if(!valido){
            res=new Valor(Constante.terror,"Error semantico; tipos de valores asignados a la lista no coinciden.");
        }
        return res;
    }
}
