/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import Analisis.Graphik.LexicoG;
import Analisis.Graphik.SintacticoG;
import Analisis.HaskellArchivo.LexicoH;
import Analisis.HaskellArchivo.SintacticoH;
import Extras.Constante;
import Reportes.HTML;
import Reportes.TablaErrores;
import TablaSimbolos.TS;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto1.FormInicio;

/**
 *
 * @author Jenny
 */
public class Recorrido {
    public static String salida = "";
        public static Nodo raiz;
        public static int cont = 1;
        public static void recorrerArbol(Nodo raiz_arbol)
        {
            raiz = raiz_arbol;
            //Ejecutar Importar            
            Nodo encabezado = buscarNodo(raiz, Constante.encabezado);
            ejecutarEncabezado(encabezado,raiz);
        try {
            ArchivoDot.graficar(raiz, "ASTGraphik");
        } catch (IOException ex) {
            Logger.getLogger(Recorrido.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(TablaErrores.error){
            HTML.mostrarErrores();
        }else{  
            //aplicar herencia a los ALS     
            //recorrer als de lista de als y aplicar herencia a cada uno
            for(Nodo als:raiz.hijos.get(1).hijos){                
                herencia(als);
            }
            recorrerInicio(raiz);            
            TS.eliminarAmbito();//elimina ambito 0
        }
        }
        private static Nodo buscarNodo (Nodo padre, String nombre)
        {
            for(Nodo hijo : padre.hijos){
                if (hijo.getNombre().equals(nombre))
                {
                    return hijo;
                }
            }
            return null;
        }
        public static Nodo buscarClase(String nombre){
            for(Nodo hijo : raiz.hijos.get(1).hijos){
                if (hijo.getValor().equals(nombre))                
                    return hijo;                
            }
            return null;
        }
        public static Nodo buscarClaseDeInicio(Nodo lals){
            for(Nodo als : lals.hijos){
                Nodo cuerpo=als.hijos.get(1);
                for(Nodo sent : cuerpo.hijos){
                    if(sent.getNombre().equals(Constante.inicio)){
                        return als;
                    }                   
                }
            }
            return null;
        }
        public static Nodo buscarDatos(){
            Nodo lals=buscarNodo(raiz,Constante.als);
            for(Nodo als : lals.hijos){
                Nodo cuerpo=als.hijos.get(1);
                for(Nodo sent : cuerpo.hijos){
                    if(sent.getValor().equals(Constante.datos)){
                        return sent;
                    }                   
                }
            }
            return null;
        }
        public static void recorrerInicio(Nodo raiz){
            //buscar lista de als
            Nodo lals=buscarNodo(raiz,Constante.als);
            //buscar clase con metodo inicio
            Nodo clase_inicio=buscarClaseDeInicio(lals);
            if(clase_inicio!=null){
                //metodo hereda 
                
                //crear ambito de clase que contiene el metodo inicio e inicializar sus varibales
                TS.AmbitoGlobal(clase_inicio);
                //obtener nodo de metodo inicio
                Nodo inicio=buscarNodo(clase_inicio.hijos.get(1), Constante.inicio);
                Nodo cuerpo_inicio=inicio.getHijo(0);
                //recorrer las sentencias del cuerpo de inicio
                TS.insertarAmbito(TS.cont_ambito);
                recorrerSent(cuerpo_inicio);
                TS.eliminarAmbito();
            }else{
                //error metodo inicio no existe
                TablaErrores.insertarError("Error semantico, metodo Inicio no fue declarado.", 1, 1);
            }
            
        }
        public static Nodo buscarFun(String nombre, String nombre_clase,LinkedList par_llamado){
            Nodo funcion=new Nodo("");
            Nodo lals=buscarNodo(raiz,Constante.als);
            if(nombre_clase==null){
                //se debe buscar en clase que tiene metodo principal
                //buscar lista de als
                //buscar clase con metodo inicio
                Nodo clase_inicio=buscarClaseDeInicio(lals);
                if(clase_inicio!=null){                    
                    Nodo cuerpo_inicio=clase_inicio.getHijo(1);
                    //recorrer cuerpo para encontrar funcion
                    funcion=buscarFun(cuerpo_inicio,nombre,par_llamado);
                    if(funcion==null)
                        TablaErrores.insertarError("Error semantico, funcion "+nombre+" no fue declarada.", 1, 1);
                    else
                        return funcion;                    
                }else{
                    //error metodo inicio no existe
                    TablaErrores.insertarError("Error semantico, metodo Inicio no fue declarado.", 1, 1);
                }
            }else{
                //se debe encontrar en el arbol del ALS que contiene esa funcion
                Nodo clase=buscarClase(nombre_clase);
                if(clase!=null){
                    //buscar funcion
                    Nodo cuerpo_clase=clase.getHijo(1);
                    funcion=buscarFun(cuerpo_clase, nombre, par_llamado);
                    if(funcion!=null)
                        return funcion;
                }else{                    
                    TablaErrores.insertarError("Error semantico, la clase "+nombre_clase+" no ha sido declarada.", cont, cont);               
                }

            }
            return null;            
        }
        public static Nodo buscarFun(Nodo cuerpo,String nombre,LinkedList <Valor> par_llamado){            
            for(Nodo sent:cuerpo.hijos){
                if(sent.getNombre().equals(Constante.decfun)){
                  if(sent.getValor().equals(nombre))  {
                      //se ha encontrado funcion
                      //verificar si coinciden los parametros
                        boolean encontrada = true;                             
                        Nodo lpar = sent.hijos.get(0);
                        if(lpar.hijos.size() == par_llamado.size()){
                            //comparar cada parametro
                            for (int i = 0; i < lpar.hijos.size();i++){                                        
                                if (par_llamado.get(i).getTipo() != lpar.hijos.get(i).getTipo()){
                                    encontrada = false;
                                }
                                if(par_llamado.get(i).getTipo()==Constante.tid){
                                    if(! par_llamado.get(i).getTals().equals(lpar.hijos.get(i).getTals())){
                                        encontrada =false;
                                    }
                                }
                            }
                            if (encontrada){
                                return sent;
                            }
                        }//no coincide cantidad de parametros                      
                  }//coincide nombre
                }//es decfun
            }//for
            return null;
        }
        public static Valor recorrerSent(Nodo cuerpo){
            Valor res=new Valor();
            for(Nodo sent : cuerpo.hijos){
                    switch(sent.getNombre()){
                        case Constante.asig:
                            SemanticoGraphik.asignacionVar(sent);
                            break;
                        case Constante.dec:
                            TS.declararVar(sent);
                            break;
                        case Constante.llamar:
                            res=SemanticoGraphik.llamar(sent);
                            break;
                        case Constante.retornar:                            
                            res=SemanticoGraphik.evaluarEXP(sent.hijos.get(0));    
                            res.setCat_retorno(Constante.cat_retornar);
                            return res;                            
                        case Constante.continuar:                                                        
                            res.setCat_retorno(Constante.cat_continuar);
                            return res;                            
                        case Constante.terminar:                                                        
                            res.setCat_retorno(Constante.cat_terminar);
                            return res;                            
                        case Constante.si:
                            res=SemanticoGraphik.si(sent);
                            if(res.getCat_retorno()==Constante.cat_retornar || res.getCat_retorno()==Constante.cat_continuar || res.getCat_retorno()==Constante.cat_terminar){
                                return res;
                            }
                            break;
                        case Constante.imprimir:
                            SemanticoGraphik.imprimir(sent);
                            break;
                        case Constante.mientras:
                            res=SemanticoGraphik.mientras(sent);
                            if(res.getCat_retorno()==Constante.cat_retornar || res.getCat_retorno()==Constante.cat_continuar || res.getCat_retorno()==Constante.cat_terminar){
                                return res;
                            }
                            break;
                        case Constante.hacermientras:
                            res=SemanticoGraphik.hacerMientras(sent);
                            if(res.getCat_retorno()==Constante.cat_retornar || res.getCat_retorno()==Constante.cat_continuar || res.getCat_retorno()==Constante.cat_terminar){
                                return res;
                            }
                            break;
                        case Constante.caso:
                            res=SemanticoGraphik.seleccion(sent);
                            if(res.getCat_retorno()==Constante.cat_retornar || res.getCat_retorno()==Constante.cat_continuar || res.getCat_retorno()==Constante.cat_terminar){
                                return res;
                            }
                            break;
                        case Constante.para:
                            res=SemanticoGraphik.para(sent);
                            if(res.getCat_retorno()==Constante.cat_retornar || res.getCat_retorno()==Constante.cat_continuar || res.getCat_retorno()==Constante.cat_terminar){
                                return res;
                            }
                            break;       
                        case Constante.llamado:                            
                            res=MemoriaHaskell.llamado(sent);
                            if(res.getTipo()==Constante.terror){
                                TablaErrores.insertarError(res.getValor(), 1, 1);
                            }
                            break;
                        case Constante.graphikar:
                            SemanticoGraphik.graphikar(sent);
                            break;                            
                    }
                }            
            return res;
        }        

    static boolean buscarFunIncluye(String valor) {
        Nodo encabezado=raiz.hijos.get(0);
        for(Nodo enc:encabezado.hijos){            
            if(enc.getNombre().equals(Constante.incluir) && enc.hijos.get(0).getValor().equals(valor)){
                return true;
            }
        }
        return false;
    }

    private static void ejecutarEncabezado(Nodo encabezado,Nodo raiz) {
        for(Nodo hijo:encabezado.hijos){
            if(hijo.getNombre().equals(Constante.importar)){
                //se debe buscar el archivo utilizando la ruta de FormInicio
                String ruta_archivo=FormInicio.ruta+hijo.hijos.get(0).getValor();
                Nodo raiz_archivo=ejecutarArchivoGK(ruta_archivo);
                
                if(raiz_archivo!=null){
                    Nodo encabezado2=raiz_archivo.hijos.get(0);
                    ejecutarEncabezado(encabezado2, raiz_archivo);
                    Nodo lals=raiz_archivo.hijos.get(1);
                    //recorrer als para agregarlos a raiz de Recorrido
                    for(Nodo als:lals.hijos){
                        raiz.hijos.get(1).insertarHijo(als);
                    }
                    
                }
                                                
            }
        }
    }

    public static String cargarArchivo(String ruta_archivo) {                
        BufferedReader br = null;      
        try {
           br =new BufferedReader(new FileReader(ruta_archivo));             
           String lineas= br.readLine();
           String texto="";
           while (lineas!=null) {               
              texto+=lineas+"\n";
              lineas = br.readLine();                
           }
           return texto;
           } catch (Exception e) {
             System.err.println("Error al cargar archivo "+ruta_archivo+"\n"+e.getMessage());
          } 
        return "";
    }

    private static Nodo ejecutarArchivoGK(String ruta_archivo) {
        String entrada=cargarArchivo(ruta_archivo);
        //verificar si es archivo haskell o graphik
                if(ruta_archivo.endsWith(".gk")){//es archivo de grafica                  
                    LexicoG lexico = new LexicoG(new BufferedReader( new StringReader(entrada)));
                    SintacticoG sintactico= new SintacticoG(lexico);
                    try {
                        sintactico.parse();   
                        if(TablaErrores.error){
                            JOptionPane.showMessageDialog(null,"Verifique errores lexicos y sintacticos, en archivo "+ruta_archivo+".");                                                                                
                            return null;
                        }
                        return sintactico.raiz;                        
                    } catch (Exception ex) {
                        System.out.println("Error al ejecutar archivo GK "+ruta_archivo+"\n"+ex.getMessage());
                    }
                }
        return null;
    }

    private static void herencia(Nodo hijo) {
        //recorrer lista de als obteniendo el hijo 0 que es hereda        
            Nodo herencia=hijo.getHijo(0);
            String nombre_hereda=herencia.getValor();
            //verificar si es diferente de ""
            if(!nombre_hereda.equals("")){
                //hereda de otro als
                //buscar als del que se hereda
                Nodo padre=buscarClase(nombre_hereda);
                if(padre!=null){
                    //mandar nodo padre a herencia
                    herencia(padre);
                    //modificar herencia de padre porque ya se ejecuto
                    padre.hijos.get(0).setValor("");
                    //recorrer atributos y metodos de padre y agregarlos a hijo si tiene visibilidad publico o protegido
                    Nodo cuerpo_padre=padre.hijos.get(1);
                    for(Nodo n:cuerpo_padre.hijos){
                        if(n.getNombre().equals(Constante.dec)){
                            //es una declaracion de variable
                            Nodo id=n.hijos.get(0);
                            if(id.getVisibilidad()==Constante.publico || id.getVisibilidad()==Constante.protegido){
                                hijo.hijos.get(1).hijos.add(n);
                            }
                        }else{
                            //es una declaracion de funcion
                            if(n.getVisibilidad()==Constante.publico || n.getVisibilidad()==Constante.protegido){
                                hijo.hijos.get(1).hijos.add(n);
                            }
                        }
                    }
                }
                hijo.hijos.get(0).setValor("");
            }        
    }
}
