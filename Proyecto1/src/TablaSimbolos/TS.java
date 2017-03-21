/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

import Extras.Constante;
import Analisis.*;
import Reportes.TablaErrores;
import java.util.LinkedList;

/**
 *
 * @author Jenny
 */
public class TS {
    public static LinkedList<Ambito>lista_ambitos=new LinkedList<Ambito>();
        public static int cont_ambito = 0;

        public static void AmbitoGlobal(Nodo als)
        {
            lista_ambitos.clear();
            cont_ambito=0;
            //se agrega ambito de clase que contiene metodo inicio
            Ambito clase_inicio = new Ambito(-1, cont_ambito);            
            lista_ambitos.add(clase_inicio);   
            Nodo cuerpo=als.hijos.get(1);            
            nuevoALS(cuerpo,clase_inicio);
        }
        public static void nuevoALS(Nodo cuerpo, Ambito ambito){
            for (Nodo hijo : cuerpo.hijos){
                if (hijo.getNombre().equals(Constante.dec)){
                    //metodo declarar var
                    declararVar(hijo,ambito);
                }//es declaracion
            }//foreach            
        }
        public static void declararVar(Nodo dec){//agrega variable al ultimos ambito que se encuentra en lista_ambitos
            //dec en su primer hijo tiene nombre y tipo de variable a asignar
            int tipo=dec.hijos.get(0).getTipo();
            String nombre=dec.hijos.get(0).getValor();
            //verificar si es una sola variable y no tiene valor
            if(dec.hijos.size()==1){
                NodoTS variable=new NodoTS(nombre,tipo,null);
                Ambito busqueda = buscarVarAsig(nombre,cont_ambito);
                if (busqueda == null)
                    lista_ambitos.get(cont_ambito).insertarVariable(variable);
            }else if(dec.hijos.get(1).getNombre().equals(Constante.lid)){
                //verificar si es una lista de id's
                //se inserta la primer variable
                NodoTS variable=new NodoTS(nombre,tipo,null);
                Ambito busqueda = buscarVarAsig(nombre,cont_ambito);
                if (busqueda == null)
                    lista_ambitos.get(cont_ambito).insertarVariable(variable);
                //recorrer lista de id's
                Nodo lid=dec.hijos.get(1);
                for(Nodo id:lid.hijos){
                    nombre=id.getValor();
                    variable=new NodoTS(nombre,tipo,null);
                    busqueda = buscarVarAsig(nombre,cont_ambito);
                    if (busqueda == null)
                        lista_ambitos.get(cont_ambito).insertarVariable(variable);
                }
            }else{
                //si tiene valor inicial
                Valor val = new Valor(tipo, null);
                Valor val_casteo= new Valor(tipo, null);
                Nodo v_inicial=dec.hijos.get(1);                
                //tiene valor inicial
                val = SemanticoGraphik.evaluarEXP(v_inicial);
                val_casteo = Casteo.Asignacion(tipo, val);
                if (val_casteo.getTipo() == Constante.terror){
                    TablaErrores.insertarError(val_casteo.getValor(), 1,1);
                    val_casteo = new Valor(tipo, null);
                }else{                    
                    NodoTS variable=new NodoTS(nombre,val_casteo.getTipo(),val_casteo.getValor());
                    Ambito busqueda = buscarVarAsig(nombre,cont_ambito);
                    if (busqueda == null)
                        lista_ambitos.get(cont_ambito).insertarVariable(variable);
                }                                                   
            }//no tiene valor inicial
        }
        public static void declararVar(Nodo dec,Ambito ambito){//agrega variable al ultimos ambito que se encuentra en lista_ambitos
            //dec en su primer hijo tiene nombre y tipo de variable a asignar
            int tipo=dec.hijos.get(0).getTipo();
            String nombre=dec.hijos.get(0).getValor();
            //verificar si es una sola variable y no tiene valor
            if(dec.hijos.size()==1){
                NodoTS variable=new NodoTS(nombre,tipo,null);
                NodoTS busqueda = ambito.buscarVariable(nombre);
                if (busqueda == null)
                    ambito.insertarVariable(variable);
            }else if(dec.hijos.get(1).getNombre().equals(Constante.lid)){
                //verificar si es una lista de id's
                //se inserta la primer variable
                NodoTS variable=new NodoTS(nombre,tipo,"");
                NodoTS busqueda = ambito.buscarVariable(nombre);
                if (busqueda == null)
                    ambito.insertarVariable(variable);
                //recorrer lista de id's
                Nodo lid=dec.hijos.get(1);
                for(Nodo id:lid.hijos){
                    nombre=id.getValor();
                    variable=new NodoTS(nombre,tipo,"");
                    busqueda = ambito.buscarVariable(nombre);
                    if (busqueda == null)
                        ambito.insertarVariable(variable);
                }
            }else{
                //si tiene valor inicial
                Valor val = new Valor(tipo, null);
                Valor val_casteo= new Valor(tipo, null);
                Nodo v_inicial=dec.hijos.get(1);                
                //tiene valor inicial
                val = SemanticoGraphik.evaluarEXP(v_inicial);
                val_casteo = Casteo.Asignacion(tipo, val);
                if (val_casteo.getTipo() == Constante.terror){
                    TablaErrores.insertarError(val_casteo.getValor(), 1,1);
                    val_casteo = new Valor(tipo, null);
                }else{                    
                    NodoTS variable=new NodoTS(nombre,val_casteo.getTipo(),val_casteo.getValor());
                    NodoTS busqueda = ambito.buscarVariable(nombre);
                    if (busqueda == null)
                        ambito.insertarVariable(variable);
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
    public static void recorrerListaAmbitos(){
        for(Ambito a: lista_ambitos){
            System.out.println("Ambito "+a.getAmbito_Actual()+" Padre: "+a.getAmbito_Padre());
            for(NodoTS n:a.variables){
                System.out.println("-----> Variable "+n.getNombre()+" Valor: "+n.getValor()+" Tipo: "+n.getTipo());
            }
        }
    }        

}
