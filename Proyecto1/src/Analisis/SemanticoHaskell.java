/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import static Analisis.SemanticoGraphik.evaluarEXP;
import Extras.Constante;
import Reportes.TablaErrores;
import TablaSimbolos.NodoTS;
import TablaSimbolos.TSH;
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
        res.setTipo(Constante.tdecimal);
        return res;
    }
    public static Valor decc(Nodo decc){
        Valor res=new Valor();
        res=RecorridoHT.ejecutarSent(decc.hijos.get(0));
        res.setValor((Double.parseDouble(res.getValor())-1)+"");
        res.setTipo(Constante.tdecimal);
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
                res.dimensiones.add(dimension.valores.size());
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
    public static Valor sum(Nodo sum) {
        Nodo lasig=sum.hijos.get(0);
        Valor res=new Valor();
        double total=0;
        if(lasig.getNombre().equals(Constante.lasig)){
            res=sum_lista(lasig);
        }else{
            //es un id de un arreglo ya declarado
            //buscar variable en ambito
            NodoTS var=TSH.buscarVar(lasig.hijos.get(0).getValor(), TSH.cont_ambito);
            if(var!=null){
                if(var.dimensiones.size()==1){
                    //es de una dimension
                    for(Valor v:var.valores){
                        if(v.getTipo()==Constante.tcaracter){                            
                            total+=Double.parseDouble(((int)v.getValor().charAt(0))+"");
                        }else{                            
                            total+=Double.parseDouble(v.getValor());
                        }
                    }
                }else{
                    //es de dos dimensiones
                    for(Valor d:var.valores){
                    //por cada hijo se crea una dimension                        
                        for(Valor v:d.valores){
                            if(v.getTipo()==Constante.tcaracter){                            
                            total+=Double.parseDouble(((int)v.getValor().charAt(0))+"");
                            }else{                                
                                    total+=Double.parseDouble(v.getValor());
                            }
                        }                        
                    }            
                }                
                res=new Valor(Constante.tdecimal,total+"");
            }else{
                //la variable no existe
                res=new Valor(Constante.terror,"Error semantic, la lista "+lasig.hijos.get(0).getValor()+" no ha sido declarada.");                
            }
            return res;
        }        
        return res;
    }
    public static Valor sum_lista(Nodo lasig){
        double total=0;
        Valor res=new Valor();
        if(lasig.hijos.get(0).getNombre().equals(Constante.asig)){
            //tiene dos dimensiones
            for(Nodo asig:lasig.hijos){
                //por cada hijo se crea una dimension
                Valor dimension=lista_asig(asig);
                if(dimension.getTipo()!= Constante.terror){
                    for(Valor v:dimension.valores){
                        if(v.getTipo()==Constante.tcaracter){                            
                            total+=Double.parseDouble(((int)v.getValor().charAt(0))+"");
                        }else{
                            total+=Double.parseDouble(v.getValor());
                        }
                    }
                }                
            }            
        }else{
            //tiene una dimension
            Valor dimension=lista_asig(lasig);
            //verificar si no se encontro un error
            if(dimension.getTipo()==Constante.terror){
                TablaErrores.insertarError(dimension.getValor(), 1, 1);                
            }else{
                //sumar cada valor que trae la dimension
                for(Valor v:dimension.valores){
                    if(v.getTipo()==Constante.tcaracter){                            
                            total+=Double.parseDouble(((int)v.getValor().charAt(0))+"");
                        }else{                        
                            total+=Double.parseDouble(v.getValor());
                        }
                }
            }
        }
        res=new Valor(Constante.tdecimal,total+"");
        return res;
    }
    public static Valor product(Nodo product) {
        Nodo lasig=product.hijos.get(0);
        Valor res=new Valor();
        double total=1;
        if(lasig.getNombre().equals(Constante.lasig)){
            res=product_lista(lasig);
        }else{
            //es un id de un arreglo ya declarado
            //buscar variable en ambito
            NodoTS var=TSH.buscarVar(lasig.hijos.get(0).getValor(), TSH.cont_ambito);
            if(var!=null){
                if(var.dimensiones.size()==1){
                    //es de una dimension
                    for(Valor v:var.valores){
                        if(v.getTipo()==Constante.tcaracter){                            
                            total*=Double.parseDouble(((int)v.getValor().charAt(0))+"");
                        }else{                            
                            total*=Double.parseDouble(v.getValor());
                        }
                    }
                }else{
                    //es de dos dimensiones
                    for(Valor d:var.valores){
                    //por cada hijo se crea una dimension                        
                        for(Valor v:d.valores){
                            if(v.getTipo()==Constante.tcaracter){                            
                                total*=Double.parseDouble(((int)v.getValor().charAt(0))+"");
                            }else{                                
                                total*=Double.parseDouble(v.getValor());
                            }
                        }                        
                    }            
                }                
                res=new Valor(Constante.tdecimal,total+"");
            }else{
                //la variable no existe
                res=new Valor(Constante.terror,"Error semantic, la lista "+lasig.hijos.get(0).getValor()+" no ha sido declarada.");                
            }            
        }        
        return res;
    }
    public static Valor product_lista(Nodo lasig){
        double total=1;
        Valor res=new Valor();
        if(lasig.hijos.get(0).getNombre().equals(Constante.asig)){
            //tiene dos dimensiones
            for(Nodo asig:lasig.hijos){
                //por cada hijo se crea una dimension
                Valor dimension=lista_asig(asig);
                if(dimension.getTipo()!= Constante.terror){
                    for(Valor v:dimension.valores){
                        if(v.getTipo()==Constante.tcaracter){                            
                            total*=Double.parseDouble(((int)v.getValor().charAt(0))+"");
                        }else{
                            total*=Double.parseDouble(v.getValor());
                        }
                    }
                }                
            }            
        }else{
            //tiene una dimension
            Valor dimension=lista_asig(lasig);
            //verificar si no se encontro un error
            if(dimension.getTipo()==Constante.terror){
                TablaErrores.insertarError(dimension.getValor(), 1, 1);                
            }else{
                //sumar cada valor que trae la dimension
                for(Valor v:dimension.valores){
                    if(v.getTipo()==Constante.tcaracter){                            
                            total*=Double.parseDouble(((int)v.getValor().charAt(0))+"");
                        }else{                        
                            total*=Double.parseDouble(v.getValor());
                        }
                }
            }
        }
        res=new Valor(Constante.tdecimal,total+"");
        return res;
    }
    public static Valor max(Nodo max) {
        Nodo lasig=max.hijos.get(0);
        Valor res=new Valor();
        double m=0;
        if(lasig.getNombre().equals(Constante.lasig)){
            res=max_lista(lasig);
        }else{
            //es un id de un arreglo ya declarado
            //buscar variable en ambito
            NodoTS var=TSH.buscarVar(lasig.hijos.get(0).getValor(), TSH.cont_ambito);
            if(var!=null){
                if(var.dimensiones.size()==1){
                    //es de una dimension
                    for(Valor v:var.valores){
                        double actual=0;
                        if(v.getTipo()==Constante.tcaracter){                            
                            actual=Double.parseDouble(((int)v.getValor().charAt(0))+"");
                        }else{                            
                            actual=Double.parseDouble(v.getValor());
                        }
                        if(actual>m){
                            m=actual;
                        }
                    }
                }else{
                    //es de dos dimensiones
                    for(Valor d:var.valores){
                    //por cada hijo se crea una dimension                        
                        for(Valor v:d.valores){
                            double actual=0;
                            if(v.getTipo()==Constante.tcaracter){                            
                                actual=Double.parseDouble(((int)v.getValor().charAt(0))+"");
                            }else{                            
                                actual=Double.parseDouble(v.getValor());
                            }
                            if(actual>m){
                                m=actual;
                            }
                        }                        
                    }            
                }                
                res=new Valor(Constante.tdecimal,m+"");
            }else{
                //la variable no existe
                res=new Valor(Constante.terror,"Error semantic, la lista "+lasig.hijos.get(0).getValor()+" no ha sido declarada.");                
            }            
        }        
        return res;
    }
    public static Valor max_lista(Nodo lasig){
        double m=1;
        Valor res=new Valor();
        if(lasig.hijos.get(0).getNombre().equals(Constante.asig)){
            //tiene dos dimensiones
            for(Nodo asig:lasig.hijos){
                //por cada hijo se crea una dimension
                Valor dimension=lista_asig(asig);
                if(dimension.getTipo()!= Constante.terror){
                    for(Valor v:dimension.valores){
                        double actual=0;
                        if(v.getTipo()==Constante.tcaracter){                            
                            actual=Double.parseDouble(((int)v.getValor().charAt(0))+"");
                        }else{                            
                            actual=Double.parseDouble(v.getValor());
                        }
                        if(actual>m){
                            m=actual;
                        }
                    }
                }                
            }            
        }else{
            //tiene una dimension
            Valor dimension=lista_asig(lasig);
            //verificar si no se encontro un error
            if(dimension.getTipo()==Constante.terror){
                TablaErrores.insertarError(dimension.getValor(), 1, 1);                
            }else{
                //sumar cada valor que trae la dimension
                for(Valor v:dimension.valores){
                    double actual=0;
                        if(v.getTipo()==Constante.tcaracter){                            
                            actual=Double.parseDouble(((int)v.getValor().charAt(0))+"");
                        }else{                            
                            actual=Double.parseDouble(v.getValor());
                        }
                        if(actual>m){
                            m=actual;
                        }
                }
            }
        }
        res=new Valor(Constante.tdecimal,m+"");
        return res;
    }
    public static Valor length(Nodo length) {
        Nodo lasig=length.hijos.get(0);
        Valor res=new Valor();
        double l=0;
        if(lasig.getNombre().equals(Constante.lasig)){
            res=length_lista(lasig);
        }else{
            //es un id de un arreglo ya declarado
            //buscar variable en ambito
            NodoTS var=TSH.buscarVar(lasig.hijos.get(0).getValor(), TSH.cont_ambito);
            if(var!=null){
                if(var.dimensiones.size()==1){
                    //es de una dimension
                    l+=var.valores.size();
                }else{
                    //es de dos dimensiones
                    for(Valor d:var.valores){
                    //por cada hijo se crea una dimension                        
                        l+=d.valores.size();
                    }            
                }                
                res=new Valor(Constante.tdecimal,l+"");
            }else{
                //la variable no existe
                res=new Valor(Constante.terror,"Error semantic, la lista "+lasig.hijos.get(0).getValor()+" no ha sido declarada.");                
            }            
        }        
        return res;
    }
    public static Valor length_lista(Nodo lasig){
        double l=0;
        Valor res=new Valor();
        if(lasig.hijos.get(0).getNombre().equals(Constante.asig)){
            //tiene dos dimensiones
            for(Nodo asig:lasig.hijos){
                //por cada hijo se crea una dimension
                Valor dimension=lista_asig(asig);
                if(dimension.getTipo()!= Constante.terror){
                    l+=dimension.valores.size();
                }                
            }            
        }else{
            //tiene una dimension
            Valor dimension=lista_asig(lasig);
            //verificar si no se encontro un error
            if(dimension.getTipo()==Constante.terror){
                TablaErrores.insertarError(dimension.getValor(), 1, 1);                
            }else{
                //sumar cada valor que trae la dimension
                l+=dimension.valores.size();
            }
        }
        res=new Valor(Constante.tdecimal,l+"");
        return res;
    }

    static Valor acceso(Nodo r) {
        Valor res=new Valor();
        //buscar lista
        Nodo id=r.hijos.get(0);
        Nodo acceso=r.hijos.get(1);
        if(id.getNombre().equals(Constante.id)){
            res=acceso_id(id,acceso);
        }else{
            res=acceso_lasig(id,acceso);
        }
        return res;
    }
    public static Valor acceso_id(Nodo id,Nodo acceso){
        Valor res=new Valor();
        String nombre=id.hijos.get(0).getValor();
        NodoTS var=TSH.buscarVar(nombre, TSH.cont_ambito);
        Valor indice=RecorridoHT.ejecutarSent(acceso.hijos.get(0));
            if(var!=null){
                //obtener indice
                //verificar cuantas dimensiones tiene el acceso
                if(acceso.hijos.size()==1){
                    //es acceso a una dimension
                    res=var.valores.get(Integer.parseInt(indice.getValor()));
                    res.setTipo(var.getTipo());
                }else{
                    //es acceso a dos dimensiones
                    if(var.dimensiones.size()==2){                        
                        Valor pos=var.valores.get(Integer.parseInt(indice.getValor()));
                        Valor indice2=RecorridoHT.ejecutarSent(acceso.hijos.get(1));
                        Valor pos2=pos.valores.get(Integer.parseInt(indice2.getValor()));
                        res=new Valor(pos2.getTipo(),pos2.getValor());
                    }else{
                        res=new Valor(Constante.terror,"Error semantico, la lista "+nombre+" no ha sido declarada de dos dimensiones.");
                    }                    
                }
            }
            return res;
    }

    private static Valor acceso_lasig(Nodo lasig, Nodo acceso) {
        Valor res = new Valor();
        Valor indice=RecorridoHT.ejecutarSent(acceso.hijos.get(0));
        if(lasig.hijos.get(0).getNombre().equals(Constante.asig)){
            //es de dos dimensiones
            if(acceso.hijos.size()==1){
                //acceso es de una dimension
                res=lista_asig(lasig.hijos.get(Integer.parseInt(indice.getValor())));
            }else{
                Valor pos =lista_asig(lasig.hijos.get(Integer.parseInt(indice.getValor())));
                Valor indice2=RecorridoHT.ejecutarSent(acceso.hijos.get(1));
                Valor pos2=pos.valores.get(Integer.parseInt(indice2.getValor()));
                res=new Valor(pos2.getTipo(),pos2.getValor());
            }
        }else{            
            //es de una dimension
            if(acceso.hijos.size()==1){
                res=RecorridoHT.ejecutarSent(lasig.hijos.get(Integer.parseInt(indice.getValor())));                
            }else{
                res=new Valor(Constante.terror,"Error semantico, la lista no ha sido declarada de dos dimensiones.");
            }
        }
        return res;
    }
    public static Valor si(Nodo si){
        Valor cond=evaluarEXP(si.hijos.get(0));
        Valor res=new Valor();
        if(cond.getTipo()==Constante.tbool){
            if(cond.getValor().equals(Constante.verdadero)){
                //ejecutar sentencias verdaderas
                res=RecorridoHT.ejecutarCuerpo(si.hijos.get(1));
            }else{
                //ejecutar sentencias falsas                
                res=RecorridoHT.ejecutarCuerpo(si.hijos.get(2));                                    
            }
        }else{
            //la expresion no es de tipo bool
            TablaErrores.insertarError("Error semantico, no puede evaluarse "+Casteo.valTipo(cond.getTipo())+" como condicion en sentencia Si.", 0, 0);
        }
        return res;
    }
}
