/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

import Analisis.Casteo;
import Analisis.Nodo;
import Analisis.Recorrido;
import Analisis.SemanticoGraphik;
import Analisis.Valor;
import Extras.Constante;
import Reportes.TablaErrores;
import static TablaSimbolos.TS.nuevoALS;
import java.util.LinkedList;

/**
 *
 * @author Jenny
 */
public class TSH {
    public static LinkedList<Ambito>lista_ambitos=new LinkedList<Ambito>();
    public static int cont_ambito = 0;
    
    public static String recorrerListaAmbitos(){
        String s="";
        for(Ambito a: lista_ambitos){
            s+="Ambito "+a.getAmbito_Actual()+" Padre: "+a.getAmbito_Padre()+"\n";
            for(NodoTS n:a.variables){
                s+="---> Variable "+n.getNombre()+" Valor: "+n.getValor()+" Tipo: "+n.getTipo()+" Tals: "+n.getTals()+"\n";
                if(n.ambito!=null){
                    s+=recorrerListaAmbitos(n.ambito,1);
                }
            }
        }
        System.out.println(s);
        return s;
    }  
    public static String recorrerListaAmbitos(Ambito ambito,int i){        
        String s="";
        String t="";
        for(int j=0;j<i;j++){
            t+="-----";
        }
        for(NodoTS n:ambito.variables){
            s+=t+"---> Variable "+n.getNombre()+" Valor: "+n.getValor()+" Tipo: "+n.getTipo()+" Tals: "+n.getTals()+"\n";
            if(n.ambito!=null){
                s+=recorrerListaAmbitos(n.ambito,i+1);
            }
        }        
        return s;
    }
    public static void insertarAmbito(int ambito_padre){
            cont_ambito++;
            Ambito ambito = new Ambito(ambito_padre, cont_ambito);
            lista_ambitos.add(ambito);
        }
    public static void eliminarAmbito(){
            lista_ambitos.remove(cont_ambito);
            cont_ambito--;
        }
    public static void insertarVariable(NodoTS var){
            lista_ambitos.get(cont_ambito).variables.add(var);
        }
    public static void declararVar(Nodo dec){//agrega variable al ultimos ambito que se encuentra en lista_ambitos
            //dec en su primer hijo tiene nombre y tipo de variable a asignar
            int tipo=dec.hijos.get(0).getTipo();
            String tals=dec.hijos.get(0).getTals();
            String nombre=dec.hijos.get(0).getValor();
            int visibilidad=dec.hijos.get(0).getVisibilidad();
            //verificar si es una sola variable y no tiene valor
            if(dec.hijos.size()==1){
                NodoTS variable=new NodoTS(nombre,tipo,null,tals);
                variable.setVisibilidad(visibilidad);
                Ambito busqueda = buscarVarAsig(nombre,cont_ambito);
                if (busqueda == null)
                    lista_ambitos.get(cont_ambito).insertarVariable(variable);
            }else if(dec.hijos.get(1).getNombre().equals(Constante.idl)){
                //verificar si es una lista de id's
                //se inserta la primer variable
                NodoTS variable=new NodoTS(nombre,tipo,null,tals);
                variable.setVisibilidad(visibilidad);
                Ambito busqueda = buscarVarAsig(nombre,cont_ambito);
                if (busqueda == null)
                    lista_ambitos.get(cont_ambito).insertarVariable(variable);
                //recorrer lista de id's
                Nodo lid=dec.hijos.get(1);
                for(Nodo id:lid.hijos){
                    nombre=id.getValor();
                    variable=new NodoTS(nombre,tipo,null,tals);
                    variable.setVisibilidad(id.getVisibilidad());
                    busqueda = buscarVarAsig(nombre,cont_ambito);
                    if (busqueda == null)
                        lista_ambitos.get(cont_ambito).insertarVariable(variable);
                }
            }else{
                //si tiene valor inicial
                //verificar si es objeto o variable
                if(dec.hijos.get(1).getNombre().equals(Constante.nuevo)){
                    //es un objeto, buscar nodo de la clase que se instancia
                    String nombre_obj=dec.hijos.get(1).getValor();
                    Nodo clase=Recorrido.buscarClase(nombre_obj);
                    if(clase!=null){
                        NodoTS variable=new NodoTS(nombre,tipo,null,tals);
                        variable.setVisibilidad(dec.hijos.get(0).getVisibilidad());
                        variable.ambito=new Ambito(-1, cont_ambito);
                        nuevoALS(clase.hijos.get(1),variable.ambito);
                        lista_ambitos.get(cont_ambito).insertarVariable(variable);
                    }else{
                        //clase no ha sido declarada
                        TablaErrores.insertarError("ALS "+nombre_obj+" no ha sido declarado.", 1, 1);
                    }
                    
                }else{                    
                    Valor val = new Valor(tipo, null);
                    Valor val_casteo= new Valor(tipo, null);
                    Nodo v_inicial=dec.hijos.get(1);                
                    //tiene valor inicial
                    val = SemanticoGraphik.evaluarEXP(v_inicial);
                    val_casteo = Casteo.Asignacion(tipo, val,tals);
                    if (val_casteo.getTipo() == Constante.terror){
                        TablaErrores.insertarError(val_casteo.getValor(), 1,1);
                        val_casteo = new Valor(tipo, null);
                    }else{                    
                        NodoTS variable=new NodoTS(nombre,val_casteo.getTipo(),val_casteo.getValor(),tals);
                        variable.setVisibilidad(dec.hijos.get(0).getVisibilidad());
                        if(val_casteo.getTipo()==Constante.tid){
                            variable.setTals(val_casteo.getTals());
                            variable.ambito=(Ambito)val_casteo.ambito;
                        }
                        NodoTS busqueda = lista_ambitos.get(cont_ambito).buscarVariable(nombre);
                        if (busqueda == null)
                            lista_ambitos.get(cont_ambito).insertarVariable(variable);
                    }                                                   
                }                                              
            }//no tiene valor inicial
        }
        public static void declararVar(Nodo dec,Ambito ambito){//agrega variable a un ambito especifico
            //dec en su primer hijo tiene nombre y tipo de variable a asignar
            int tipo=dec.hijos.get(0).getTipo();
            String tals=dec.hijos.get(0).getTals();
            String nombre=dec.hijos.get(0).getValor();
            //verificar si es una sola variable y no tiene valor
            if(dec.hijos.size()==1){
                NodoTS variable=new NodoTS(nombre,tipo,null,tals);
                variable.setVisibilidad(dec.hijos.get(0).getVisibilidad());
                NodoTS busqueda = ambito.buscarVariable(nombre);
                if (busqueda == null)
                    ambito.insertarVariable(variable);
            }else if(dec.hijos.get(1).getNombre().equals(Constante.idl)){
                //verificar si es una lista de id's
                //se inserta la primer variable
                NodoTS variable=new NodoTS(nombre,tipo,null,tals);
                variable.setVisibilidad(dec.hijos.get(0).getVisibilidad());
                NodoTS busqueda = ambito.buscarVariable(nombre);
                if (busqueda == null)
                    ambito.insertarVariable(variable);
                //recorrer lista de id's
                Nodo lid=dec.hijos.get(1);
                for(Nodo id:lid.hijos){
                    nombre=id.getValor();
                    variable=new NodoTS(nombre,tipo,null,tals);
                    variable.setVisibilidad(id.getVisibilidad());
                    busqueda = ambito.buscarVariable(nombre);
                    if (busqueda == null)
                        ambito.insertarVariable(variable);
                }
            }else{
                //si tiene valor inicial
                //verificar si es objeto o variable
                if(dec.hijos.get(1).getNombre().equals(Constante.nuevo)){
                    //es un objeto, buscar nodo de la clase que se instancia
                    String nombre_obj=dec.hijos.get(1).getValor();
                    Nodo clase=Recorrido.buscarClase(nombre_obj);
                    if(clase!=null){
                        NodoTS variable=new NodoTS(nombre,tipo,null,tals);
                        variable.ambito=new Ambito(-1, cont_ambito);
                        variable.setVisibilidad(dec.hijos.get(0).getVisibilidad());
                        nuevoALS(clase.hijos.get(1),variable.ambito);
                        ambito.insertarVariable(variable);
                    }else{
                        //clase no ha sido declarada
                        TablaErrores.insertarError("ALS "+nombre_obj+" no ha sido declarado.", 1, 1);
                    }
                    
                }else{                    
                    Valor val = new Valor(tipo, null);
                    Valor val_casteo= new Valor(tipo, null);
                    Nodo v_inicial=dec.hijos.get(1);                
                    //tiene valor inicial
                    val = SemanticoGraphik.evaluarEXP(v_inicial);
                    val_casteo = Casteo.Asignacion(tipo, val,tals);
                    if (val_casteo.getTipo() == Constante.terror){
                        TablaErrores.insertarError(val_casteo.getValor(), 1,1);
                        val_casteo = new Valor(tipo, null);
                    }else{                    
                        NodoTS variable=new NodoTS(nombre,val_casteo.getTipo(),val_casteo.getValor(),tals);
                        variable.setVisibilidad(dec.hijos.get(0).getVisibilidad());
                        if(val_casteo.getTipo()==Constante.tid){
                            variable.setTals(val_casteo.getTals());
                            variable.ambito=(Ambito)val_casteo.ambito;
                        }
                        NodoTS busqueda = ambito.buscarVariable(nombre);
                        if (busqueda == null)
                            ambito.insertarVariable(variable);
                    }                                                   
                }
            }//no tiene valor inicial
        }       
        public static Ambito buscarVarAsig(String nombre, int ambito){
            if (ambito != -1)
            {
                Ambito actual = lista_ambitos.get(ambito);
                int var = actual.buscarVariablePos(nombre);
                if (var == -1)//buscar ambito anterior                
                    return buscarVarAsig(nombre, actual.getAmbito_Padre());
                else
                    return new Ambito(ambito,var);
            }
            return null;
        }
        public static NodoTS buscarVar(String nombre, int ambito)
        {
            if(ambito != -1)
            {
                Ambito actual = lista_ambitos.get(ambito);
                NodoTS var = actual.buscarVariable(nombre);
                if( var == null)//buscar ambito anterior                
                    return buscarVar(nombre, actual.getAmbito_Padre());
                else
                    return var;
            }
            return null;            
        }
        public static void asignarVar(String nombre, Valor valor)
        {
            //buscar ambito en el cual esta la variable
            Ambito lugar_var = buscarVarAsig(nombre, cont_ambito);
            if(lugar_var!=null){                
                //asignar
                lista_ambitos.get(lugar_var.getAmbito_Padre()).variables.get(lugar_var.getAmbito_Actual()).setValor(valor.getValor());
            }
        }
}
