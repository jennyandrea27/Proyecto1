/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import Extras.Constante;
import Reportes.TablaErrores;
import TablaSimbolos.TS;

/**
 *
 * @author Jenny
 */
public class Casteo {
    //aritmeticas
   public static Valor suma(Valor op1, Valor op2){
        Valor res=new Valor();
        if(op1!=null && op2!=null && op1.getValor()!=null && op2.getValor()!=null)
            switch(op1.getTipo()+op2.getTipo()){
                case 2://numero con numero
                    res=new Valor(Constante.tnum,Integer.parseInt(op1.getValor())+Integer.parseInt(op2.getValor())+"");
                    break;
                case 4: //numero con cadena
                case 6://cadena con cadena    
                case 10://cadena con boolean
                case 13://decimal con cadena
                case 18://cadena con caracter
                case 30://caracter con caracter
                    res=new Valor(Constante.tcadena,op1.getValor()+op2.getValor());
                    break;
                case 8://numero con bool
                    if(op1.getTipo() == Constante.tbool)
                        res=new Valor(Constante.tnum,Integer.parseInt(valBool(op1.getValor()))+Integer.parseInt(op2.getValor())+"");
                    else
                        res=new Valor(Constante.tnum,Integer.parseInt(op1.getValor())+Integer.parseInt(valBool(op2.getValor()))+"");
                    break;
                case 11://numero con decimal
                case 20://decimal con decimal                
                    res=new Valor(Constante.tdecimal,Double.parseDouble(op1.getValor())+Double.parseDouble(op2.getValor())+"");
                    break;
                case 14://bool con bool
                    if(op1.getValor().equals(Constante.falso) && op2.getValor().equals(Constante.falso))                
                        res=new Valor(Constante.tbool,Constante.falso);                
                    else                
                        res=new Valor(Constante.tbool,Constante.verdadero);                
                    break;
                case 16://numero con caracter
                    if(op1.getTipo() == Constante.tcaracter)
                        res = new Valor(Constante.tnum,(int)op1.getValor().charAt(0)+Integer.parseInt(op2.getValor())+"");
                    else
                        res = new Valor(Constante.tnum,Integer.parseInt(op1.getValor())+(int)op2.getValor().charAt(0)+"");                
                        break;
                case 17://bool con decimal
                    if(op1.getTipo()==Constante.tbool)
                        res=new Valor(Constante.tdecimal,Integer.parseInt(valBool(op1.getValor()))+Double.parseDouble(op2.getValor())+"");
                    else
                        res=new Valor(Constante.tdecimal,Double.parseDouble(op1.getValor())+Integer.parseInt(valBool(op2.getValor()))+"");                
                    break;
                case 25://decimal con caracter                
                    if(op1.getTipo() == Constante.tcaracter)
                        res = new Valor(Constante.tdecimal,(int)op1.getValor().charAt(0)+Double.parseDouble(op2.getValor())+"");
                    else
                        res = new Valor(Constante.tdecimal,Double.parseDouble(op1.getValor())+(int)op2.getValor().charAt(0)+"");                
                    break;            
                case 22://boolean con caracter
                    res=new Valor(Constante.terror,"Error semantico, no se puede realizar suma entre: "+valTipo(op1.getTipo())+" y "+valTipo(op2.getTipo()));
                    break;                                
            }
        return res;
    }
   public static Valor resta(Valor op1, Valor op2){
        Valor res=new Valor();
        if(op1!=null && op2!=null && op1.getValor()!=null && op2.getValor()!=null)
            switch(op1.getTipo()+op2.getTipo()){
                case 2://numero con numero
                    res=new Valor(Constante.tnum,Integer.parseInt(op1.getValor())-Integer.parseInt(op2.getValor())+"");
                    break;
                case 8://numero con bool
                    if(op1.getTipo() == Constante.tbool)
                        res=new Valor(Constante.tnum,Integer.parseInt(valBool(op1.getValor()))-Integer.parseInt(op2.getValor())+"");
                    else
                        res=new Valor(Constante.tnum,Integer.parseInt(op1.getValor())-Integer.parseInt(valBool(op2.getValor()))+"");
                    break;
                case 11://numero con decimal
                case 20://decimal con decimal                
                    res=new Valor(Constante.tdecimal,Double.parseDouble(op1.getValor())-Double.parseDouble(op2.getValor())+"");
                    break;
                case 16://numero con caracter
                    if(op1.getTipo() == Constante.tcaracter)
                        res = new Valor(Constante.tnum,(int)op1.getValor().charAt(0)-Integer.parseInt(op2.getValor())+"");
                    else
                        res = new Valor(Constante.tnum,Integer.parseInt(op1.getValor())-(int)op2.getValor().charAt(0)+"");                
                        break;
                case 17://bool con decimal
                    if(op1.getTipo()==Constante.tbool)
                        res=new Valor(Constante.tdecimal,Integer.parseInt(valBool(op1.getValor()))-Double.parseDouble(op2.getValor())+"");
                    else
                        res=new Valor(Constante.tdecimal,Double.parseDouble(op1.getValor())-Integer.parseInt(valBool(op2.getValor()))+"");                
                    break;
                case 25://decimal con caracter                
                    if(op1.getTipo() == Constante.tcaracter)
                        res = new Valor(Constante.tdecimal,(int)op1.getValor().charAt(0)-Double.parseDouble(op2.getValor())+"");
                    else
                        res = new Valor(Constante.tdecimal,Double.parseDouble(op1.getValor())-(int)op2.getValor().charAt(0)+"");                
                    break;
                case 10://cadena con boolean
                case 14://bool con bool               
                case 22://boolean con caracter
                case 4: //numero con cadena
                case 6://cadena con cadena                
                case 13://decimal con cadena
                case 18://cadena con caracter
                case 30://caracter con caracter                
                    res=new Valor(Constante.terror,"Error semantico, no se puede realizar resta entre: "+valTipo(op1.getTipo())+" y "+valTipo(op2.getTipo()));
                    break;                                
            }
        return res;
    }
   public static Valor mult(Valor op1, Valor op2){
        Valor res=new Valor();
        if(op1!=null && op2!=null && op1.getValor()!=null && op2.getValor()!=null)
            switch(op1.getTipo()+op2.getTipo()){
                case 2://numero con numero
                    res=new Valor(Constante.tnum,Integer.parseInt(op1.getValor())*Integer.parseInt(op2.getValor())+"");
                    break;
                case 8://numero con bool
                    if(op1.getTipo() == Constante.tbool)
                        res=new Valor(Constante.tnum,Integer.parseInt(valBool(op1.getValor()))*Integer.parseInt(op2.getValor())+"");
                    else
                        res=new Valor(Constante.tnum,Integer.parseInt(op1.getValor())*Integer.parseInt(valBool(op2.getValor()))+"");
                    break;
                case 11://numero con decimal
                case 20://decimal con decimal                
                    res=new Valor(Constante.tdecimal,Double.parseDouble(op1.getValor())*Double.parseDouble(op2.getValor())+"");
                    break;
                case 14://bool con bool
                    if(op1.getValor().equals(Constante.falso) || op2.getValor().equals(Constante.falso))                
                        res=new Valor(Constante.tbool,Constante.falso);                
                    else                
                        res=new Valor(Constante.tbool,Constante.verdadero);                
                    break;
                case 16://numero con caracter
                    if(op1.getTipo() == Constante.tcaracter)
                        res = new Valor(Constante.tnum,(int)op1.getValor().charAt(0)*Integer.parseInt(op2.getValor())+"");
                    else
                        res = new Valor(Constante.tnum,Integer.parseInt(op1.getValor())*(int)op2.getValor().charAt(0)+"");                
                        break;
                case 17://bool con decimal
                    if(op1.getTipo()==Constante.tbool)
                        res=new Valor(Constante.tdecimal,Integer.parseInt(valBool(op1.getValor()))*Double.parseDouble(op2.getValor())+"");
                    else
                        res=new Valor(Constante.tdecimal,Double.parseDouble(op1.getValor())*Integer.parseInt(valBool(op2.getValor()))+"");                
                    break;
                case 25://decimal con caracter                
                    if(op1.getTipo() == Constante.tcaracter)
                        res = new Valor(Constante.tdecimal,(int)op1.getValor().charAt(0)*Double.parseDouble(op2.getValor())+"");
                    else
                        res = new Valor(Constante.tdecimal,Double.parseDouble(op1.getValor())*(int)op2.getValor().charAt(0)+"");                
                    break;
                case 10://cadena con boolean
                case 22://boolean con caracter
                case 4: //numero con cadena
                case 6://cadena con cadena                
                case 13://decimal con cadena
                case 18://cadena con caracter
                case 30://caracter con caracter                
                    res=new Valor(Constante.terror,"Error semantico, no se puede realizar multiplicacion entre: "+valTipo(op1.getTipo())+" y "+valTipo(op2.getTipo()));
                    break;                                
            }
        return res;
    }    
   public static Valor division(Valor op1, Valor op2){
        Valor res=new Valor();
        if(op1!=null && op2!=null && op1.getValor()!=null && op2.getValor()!=null)
            switch(op1.getTipo()+op2.getTipo()){
                case 2://numero con numero
                    res=new Valor(Constante.tdecimal,Double.parseDouble(op1.getValor())/Double.parseDouble(op2.getValor())+"");
                    break;
                case 8://numero con bool
                    if(op1.getTipo() == Constante.tbool)
                        res=new Valor(Constante.tdecimal,Double.parseDouble(valBool(op1.getValor()))/Double.parseDouble(op2.getValor())+"");
                    else
                        res=new Valor(Constante.tdecimal,Double.parseDouble(op1.getValor())/Double.parseDouble(valBool(op2.getValor()))+"");
                    break;
                case 11://numero con decimal
                case 20://decimal con decimal                
                    res=new Valor(Constante.tdecimal,Double.parseDouble(op1.getValor())/Double.parseDouble(op2.getValor())+"");
                    break;
                case 16://numero con caracter
                    if(op1.getTipo() == Constante.tcaracter)
                        res = new Valor(Constante.tdecimal,(int)op1.getValor().charAt(0)/Double.parseDouble(op2.getValor())+"");
                    else
                        res = new Valor(Constante.tdecimal,Double.parseDouble(op1.getValor())/(int)op2.getValor().charAt(0)+"");                
                        break;
                case 17://bool con decimal
                    if(op1.getTipo()==Constante.tbool)
                        res=new Valor(Constante.tdecimal,Double.parseDouble(valBool(op1.getValor()))/Double.parseDouble(op2.getValor())+"");
                    else
                        res=new Valor(Constante.tdecimal,Double.parseDouble(op1.getValor())/Double.parseDouble(valBool(op2.getValor()))+"");                
                    break;
                case 25://decimal con caracter                
                    if(op1.getTipo() == Constante.tcaracter)
                        res = new Valor(Constante.tdecimal,(int)op1.getValor().charAt(0)/Double.parseDouble(op2.getValor())+"");
                    else
                        res = new Valor(Constante.tdecimal,Double.parseDouble(op1.getValor())/(int)op2.getValor().charAt(0)+"");                
                    break;
                case 10://cadena con boolean
                case 14://bool con bool            
                case 22://boolean con caracter
                case 4: //numero con cadena
                case 6://cadena con cadena                
                case 13://decimal con cadena
                case 18://cadena con caracter
                case 30://caracter con caracter
                    res=new Valor(Constante.terror,"Error semantico, no se puede realizar division entre: "+valTipo(op1.getTipo())+" y "+valTipo(op2.getTipo()));
                    break;                                
            }
        return res;
    }    
   public static Valor mod(Valor op1, Valor op2){
        Valor res=new Valor();
        if(op1!=null && op2!=null && op1.getValor()!=null && op2.getValor()!=null)
            switch(op1.getTipo()+op2.getTipo()){                                  
                case 20://decimal con decimal                
                    res=new Valor(Constante.tdecimal,Double.parseDouble(op1.getValor()) % Double.parseDouble(op2.getValor())+"");
                    break;            
                case 25://decimal con caracter                
                    if(op1.getTipo() == Constante.tcaracter)
                        res = new Valor(Constante.tdecimal,(int)op1.getValor().charAt(0) % Double.parseDouble(op2.getValor())+"");
                    else
                        res = new Valor(Constante.tdecimal,Double.parseDouble(op1.getValor()) % (int)op2.getValor().charAt(0)+"");                
                    break;
                case 17://bool con decimal                
                case 10://cadena con boolean
                case 14://bool con bool            
                case 22://boolean con caracter
                case 4: //numero con cadena
                case 6://cadena con cadena                
                case 13://decimal con cadena
                case 18://cadena con caracter
                case 30://caracter con caracter
                    res=new Valor(Constante.terror,"Error semantico, no se puede realizar division entre: "+valTipo(op1.getTipo())+" y "+valTipo(op2.getTipo()));
                    break;                                
            }
        return res;
    }    
   public static Valor potencia(Valor op1, Valor op2){
        Valor res=new Valor();
        if(op1!=null && op2!=null && op1.getValor()!=null && op2.getValor()!=null)
            switch(op1.getTipo()+op2.getTipo()){
                case 2://numero con numero
                    res=new Valor(Constante.tnum,Math.round(Math.pow(Integer.parseInt(op1.getValor()),Integer.parseInt(op2.getValor())))+"");
                    break;
                case 8://numero con bool
                    if(op1.getTipo() == Constante.tbool)
                        res=new Valor(Constante.tnum,Math.round(Math.pow(Integer.parseInt(valBool(op1.getValor())),Integer.parseInt(op2.getValor())))+"");
                    else
                        res=new Valor(Constante.tnum,Math.round(Math.pow(Integer.parseInt(op1.getValor()),Integer.parseInt(valBool(op2.getValor()))))+"");
                    break;
                case 11://numero con decimal
                case 20://decimal con decimal                
                    res=new Valor(Constante.tdecimal,Math.pow(Double.parseDouble(op1.getValor()),Double.parseDouble(op2.getValor()))+"");
                    break;
                case 16://numero con caracter
                    if(op1.getTipo() == Constante.tcaracter)
                        res = new Valor(Constante.tnum,Math.round(Math.pow((int)op1.getValor().charAt(0),Integer.parseInt(op2.getValor())))+"");
                    else
                        res = new Valor(Constante.tnum,Math.round(Math.pow(Integer.parseInt(op1.getValor()),(int)op2.getValor().charAt(0)))+"");                
                        break;
                case 17://bool con decimal
                    if(op1.getTipo()==Constante.tbool)
                        res=new Valor(Constante.tdecimal,Math.pow(Integer.parseInt(valBool(op1.getValor())),Double.parseDouble(op2.getValor()))+"");
                    else
                        res=new Valor(Constante.tdecimal,Math.pow(Double.parseDouble(op1.getValor()),Integer.parseInt(valBool(op2.getValor())))+"");                
                    break;
                case 25://decimal con caracter                
                    if(op1.getTipo() == Constante.tcaracter)
                        res = new Valor(Constante.tdecimal,Math.pow((int)op1.getValor().charAt(0),Double.parseDouble(op2.getValor()))+"");
                    else
                        res = new Valor(Constante.tdecimal,Math.pow(Double.parseDouble(op1.getValor()),(int)op2.getValor().charAt(0))+"");                
                    break;
                case 10://cadena con boolean
                case 14://bool con bool               
                case 22://boolean con caracter
                case 4: //numero con cadena
                case 6://cadena con cadena                
                case 13://decimal con cadena
                case 18://cadena con caracter
                case 30://caracter con caracter                
                    res=new Valor(Constante.terror,"Error semantico, no se puede realizar multiplicacion entre: "+valTipo(op1.getTipo())+" y "+valTipo(op2.getTipo()));
                    break;                                
            }
        return res;
    }   
   public static Valor sqrt(Valor op1, Valor op2){
        Valor res=new Valor();
        double raiz=0;
        if(op1!=null && op2!=null && op1.getValor()!=null && op2.getValor()!=null)
            switch(op1.getTipo()+op2.getTipo()){               
                case 20://decimal con decimal                
                    raiz=Math.pow(Double.parseDouble(op2.getValor()),1 / Double.parseDouble(op1.getValor()) );
                    res=new Valor(Constante.tdecimal,raiz+"");
                    break;            
                case 25://decimal con caracter                
                    if(op1.getTipo() == Constante.tcaracter){
                        raiz=Math.pow(Double.parseDouble(op2.getValor()),1 / (int)op1.getValor().charAt(0) );
                        res = new Valor(Constante.tdecimal,raiz+"");
                    }else{
                        raiz=Math.pow((int)op2.getValor().charAt(0),1 / Double.parseDouble(op1.getValor()) );
                        res = new Valor(Constante.tdecimal,raiz+"");                
                    }
                    break;
                case 10://cadena con boolean
                case 8://numero con bool                
                case 17://bool con decimal                    
                case 14://bool con bool                                    
                case 22://boolean con caracter
                case 4: //numero con cadena
                case 6://cadena con cadena                
                case 13://decimal con cadena
                case 18://cadena con caracter
                case 30://caracter con caracter                                
                    res=new Valor(Constante.terror,"Error semantico, no se puede realizar multiplicacion entre: "+valTipo(op1.getTipo())+" y "+valTipo(op2.getTipo()));
                    break;                                
            }
        return res;
    }    
   
   public static Valor restaUnaria(Valor op1){
        Valor res=new Valor();
            if(op1!=null && op1.getValor()!=null)
            switch(op1.getTipo()){
                case Constante.tnum:
                    res = new Valor(Constante.tnum,Integer.parseInt(op1.getValor())*-1+"");
                    break;
                case Constante.tdecimal:
                    res = new Valor(Constante.tdecimal,Double.parseDouble(op1.getValor())*-1+"");
                    break;
                case Constante.tbool:
                case Constante.tcadena:
                case Constante.tcaracter:
                case Constante.tid:
                case Constante.tvacio:            
                    res=new Valor(Constante.terror,"Error semantico, no se puede realizar resta unaria a valor tipo : "+valTipo(op1.getTipo()));
                    break;                                
            }
        return res;
    }
   //relacionales
   public static Valor mayor(Valor op1, Valor op2){       
       if(op1.getTipo() == Constante.tbool){
           op1.setValor(valBool(op1.getValor()));
       }
       if(op2.getTipo() == Constante.tbool){
           op2.setValor(valBool(op2.getValor()));
       }
       Valor res=new Valor(Constante.tbool, Constante.falso);
       switch(op1.tipo + op2.tipo){
           case 2://numero con numero
           case 8: //numero con bool
           case 11: // numero con decimal
           case 14: //bool con bool
           case 17: //decimal con bool
           case 20: //decimal con decimal
                if (Double.parseDouble(op1.getValor()) > Double.parseDouble(op2.getValor()))
                    res.setValor(Constante.verdadero);                
               break;
           case 16: //numero con caracter           
           case 25:  //decimal con caracter
               if(op1.getTipo() == Constante.tcaracter){
                   if((int)op1.getValor().charAt(0) > Double.parseDouble(op2.getValor()))
                       res.setValor(Constante.verdadero);                   
               }else{
                   if(Double.parseDouble(op1.getValor()) > (int)op2.getValor().charAt(0) )
                       res.setValor(Constante.verdadero);                   
               }                   
               break;
           case 6: //cadena con cadena
           case 18: // cadena con caracter
           case 30: //caracter con caracter
               if(op1.getValor().compareTo(op2.getValor()) > 0 )
                   res.setValor(Constante.verdadero);               
               break;
           case 4://numero con cadena
           case 10://cadena con bool
           case 22://boolean con caracter
           case 13: //decimal con cadena
               res=new Valor(Constante.terror,"Error semantico, no se puede realizar operacion mayor entre: "+valTipo(op1.getTipo())+" y "+valTipo(op2.getTipo()));
                break;
       }
       return res;
   }
   public static Valor menor(Valor op1, Valor op2){       
       if(op1.getTipo() == Constante.tbool){
           op1.setValor(valBool(op1.getValor()));
       }
       if(op2.getTipo() == Constante.tbool){
           op2.setValor(valBool(op2.getValor()));
       }
       Valor res=new Valor(Constante.tbool, Constante.falso);
       switch(op1.tipo + op2.tipo){
           case 2://numero con numero
           case 8: //numero con bool
           case 11: // numero con decimal
           case 14: //bool con bool
           case 17: //decimal con bool
           case 20: //decimal con decimal
                if (Double.parseDouble(op1.getValor()) < Double.parseDouble(op2.getValor()))
                    res.setValor(Constante.verdadero);                
               break;
           case 16: //numero con caracter           
           case 25:  //decimal con caracter
               if(op1.getTipo() == Constante.tcaracter){
                   if((int)op1.getValor().charAt(0) < Double.parseDouble(op2.getValor()))
                       res.setValor(Constante.verdadero);                   
               }else{
                   if(Double.parseDouble(op1.getValor()) < (int)op2.getValor().charAt(0) )
                       res.setValor(Constante.verdadero);                   
               }                   
               break;
           case 6: //cadena con cadena
           case 18: // cadena con caracter
           case 30: //caracter con caracter
               if(op1.getValor().compareTo(op2.getValor()) < 0 )
                   res.setValor(Constante.verdadero);               
               break;
           case 4://numero con cadena
           case 10://cadena con bool
           case 22://boolean con caracter
           case 13: //decimal con cadena
               res=new Valor(Constante.terror,"Error semantico, no se puede realizar operacion menor entre: "+valTipo(op1.getTipo())+" y "+valTipo(op2.getTipo()));
                break;
       }
       return res;
   }   
   public static Valor mayorigual(Valor op1, Valor op2){       
       if(op1.getTipo() == Constante.tbool){
           op1.setValor(valBool(op1.getValor()));
       }
       if(op2.getTipo() == Constante.tbool){
           op2.setValor(valBool(op2.getValor()));
       }
       Valor res=new Valor(Constante.tbool, Constante.falso);
       switch(op1.tipo + op2.tipo){
           case 2://numero con numero
           case 8: //numero con bool
           case 11: // numero con decimal
           case 14: //bool con bool
           case 17: //decimal con bool
           case 20: //decimal con decimal
                if (Double.parseDouble(op1.getValor()) >= Double.parseDouble(op2.getValor()))
                    res.setValor(Constante.verdadero);                
               break;
           case 16: //numero con caracter           
           case 25:  //decimal con caracter
               if(op1.getTipo() == Constante.tcaracter){
                   if((int)op1.getValor().charAt(0) >= Double.parseDouble(op2.getValor()))
                       res.setValor(Constante.verdadero);                   
               }else{
                   if(Double.parseDouble(op1.getValor()) >= (int)op2.getValor().charAt(0) )
                       res.setValor(Constante.verdadero);                   
               }                   
               break;
           case 6: //cadena con cadena
           case 18: // cadena con caracter
           case 30: //caracter con caracter
               if(op1.getValor().compareTo(op2.getValor()) >= 0 )
                   res.setValor(Constante.verdadero);               
               break;
           case 4://numero con cadena
           case 10://cadena con bool
           case 22://boolean con caracter
           case 13: //decimal con cadena
               res=new Valor(Constante.terror,"Error semantico, no se puede realizar operacion mayorigual entre: "+valTipo(op1.getTipo())+" y "+valTipo(op2.getTipo()));
                break;
       }
       return res;
   }   
   public static Valor menorigual(Valor op1, Valor op2){       
       if(op1.getTipo() == Constante.tbool){
           op1.setValor(valBool(op1.getValor()));
       }
       if(op2.getTipo() == Constante.tbool){
           op2.setValor(valBool(op2.getValor()));
       }
       Valor res=new Valor(Constante.tbool, Constante.falso);
       switch(op1.tipo + op2.tipo){
           case 2://numero con numero
           case 8: //numero con bool
           case 11: // numero con decimal
           case 14: //bool con bool
           case 17: //decimal con bool
           case 20: //decimal con decimal
                if (Double.parseDouble(op1.getValor()) <= Double.parseDouble(op2.getValor()))
                    res.setValor(Constante.verdadero);                
               break;
           case 16: //numero con caracter           
           case 25:  //decimal con caracter
               if(op1.getTipo() == Constante.tcaracter){
                   if((int)op1.getValor().charAt(0) <= Double.parseDouble(op2.getValor()))
                       res.setValor(Constante.verdadero);                   
               }else{
                   if(Double.parseDouble(op1.getValor()) <= (int)op2.getValor().charAt(0) )
                       res.setValor(Constante.verdadero);                   
               }                   
               break;
           case 6: //cadena con cadena
           case 18: // cadena con caracter
           case 30: //caracter con caracter
               if(op1.getValor().compareTo(op2.getValor()) <= 0 )
                   res.setValor(Constante.verdadero);               
               break;
           case 4://numero con cadena
           case 10://cadena con bool
           case 22://boolean con caracter
           case 13: //decimal con cadena
               res=new Valor(Constante.terror,"Error semantico, no se puede realizar operacion menorigual entre: "+valTipo(op1.getTipo())+" y "+valTipo(op2.getTipo()));
                break;
       }
       return res;
   }   
   public static Valor igualacion(Valor op1, Valor op2){       
       if(op1.getTipo() == Constante.tbool){
           op1.setValor(valBool(op1.getValor()));
       }
       if(op2.getTipo() == Constante.tbool){
           op2.setValor(valBool(op2.getValor()));
       }
       Valor res=new Valor(Constante.tbool, Constante.falso);
       switch(op1.tipo + op2.tipo){
           case 2://numero con numero
           case 8: //numero con bool
           case 11: // numero con decimal
           case 14: //bool con bool
           case 17: //decimal con bool
           case 20: //decimal con decimal
                if (Double.parseDouble(op1.getValor()) == Double.parseDouble(op2.getValor()))
                    res.setValor(Constante.verdadero);                
               break;
           case 16: //numero con caracter           
           case 25:  //decimal con caracter
               if(op1.getTipo() == Constante.tcaracter){
                   if((int)op1.getValor().charAt(0) == Double.parseDouble(op2.getValor()))
                       res.setValor(Constante.verdadero);                   
               }else{
                   if(Double.parseDouble(op1.getValor()) == (int)op2.getValor().charAt(0) )
                       res.setValor(Constante.verdadero);                   
               }                   
               break;
           case 6: //cadena con cadena
           case 18: // cadena con caracter
           case 30: //caracter con caracter
               if(op1.getValor().compareTo(op2.getValor()) == 0 )
                   res.setValor(Constante.verdadero);               
               break;
           case 4://numero con cadena
           case 10://cadena con bool
           case 22://boolean con caracter
           case 13: //decimal con cadena
               res=new Valor(Constante.terror,"Error semantico, no se puede realizar operacion igualacion entre: "+valTipo(op1.getTipo())+" y "+valTipo(op2.getTipo()));
                break;
       }
       return res;
   }   
   public static Valor distinto(Valor op1, Valor op2){       
       if(op1.getTipo() != Constante.tbool){
           op1.setValor(valBool(op1.getValor()));
       }
       if(op2.getTipo() != Constante.tbool){
           op2.setValor(valBool(op2.getValor()));
       }
       Valor res=new Valor(Constante.tbool, Constante.falso);
       switch(op1.tipo + op2.tipo){
           case 2://numero con numero
           case 8: //numero con bool
           case 11: // numero con decimal
           case 14: //bool con bool
           case 17: //decimal con bool
           case 20: //decimal con decimal
                if (Double.parseDouble(op1.getValor()) != Double.parseDouble(op2.getValor()))
                    res.setValor(Constante.verdadero);                
               break;
           case 16: //numero con caracter           
           case 25:  //decimal con caracter
               if(op1.getTipo() != Constante.tcaracter){
                   if((int)op1.getValor().charAt(0) != Double.parseDouble(op2.getValor()))
                       res.setValor(Constante.verdadero);                   
               }else{
                   if(Double.parseDouble(op1.getValor()) != (int)op2.getValor().charAt(0) )
                       res.setValor(Constante.verdadero);                   
               }                   
               break;
           case 6: //cadena con cadena
           case 18: // cadena con caracter
           case 30: //caracter con caracter
               if(op1.getValor().compareTo(op2.getValor()) != 0 )
                   res.setValor(Constante.verdadero);               
               break;
           case 4://numero con cadena
           case 10://cadena con bool
           case 22://boolean con caracter
           case 13: //decimal con cadena
               res=new Valor(Constante.terror,"Error semantico, no se puede realizar operacion distinto entre: "+valTipo(op1.getTipo())+" y "+valTipo(op2.getTipo()));
                break;
       }
       return res;
   }   
   //logicos
   public static Valor or(Valor op1, Valor op2){       
       Valor res=new Valor(Constante.tbool, Constante.falso);
       switch(op1.tipo + op2.tipo){
           case 14: //bool con bool
               if(op1.getValor().equals(Constante.verdadero) || op2.getValor().equals(Constante.verdadero))
                   res.setValor(Constante.verdadero);
               break;
           case 2://numero con numero
           case 8: //numero con bool
           case 11: // numero con decimal
           case 17: //decimal con bool
           case 20: //decimal con decimal
           case 16: //numero con caracter           
           case 25:  //decimal con caracter
           case 6: //cadena con cadena
           case 18: // cadena con caracter
           case 30: //caracter con caracter           
           case 4://numero con cadena
           case 10://cadena con bool
           case 22://boolean con caracter
           case 13: //decimal con cadena
               res=new Valor(Constante.terror,"Error semantico, no se puede realizar operacion OR entre: "+valTipo(op1.getTipo())+" y "+valTipo(op2.getTipo()));
                break;
       }
       return res;
   }
   public static Valor and(Valor op1, Valor op2){       
       Valor res=new Valor(Constante.tbool, Constante.falso);
       if(op1!=null && op2!=null && op1.getValor()!=null && op2.getValor()!=null)
            switch(op1.tipo + op2.tipo){
                case 14: //bool con bool
                    if(op1.getValor().equals(Constante.verdadero) && op2.getValor().equals(Constante.verdadero))
                        res.setValor(Constante.verdadero);
                    break;
                case 2://numero con numero
                case 8: //numero con bool
                case 11: // numero con decimal
                case 17: //decimal con bool
                case 20: //decimal con decimal
                case 16: //numero con caracter           
                case 25:  //decimal con caracter
                case 6: //cadena con cadena
                case 18: // cadena con caracter
                case 30: //caracter con caracter           
                case 4://numero con cadena
                case 10://cadena con bool
                case 22://boolean con caracter
                case 13: //decimal con cadena
                    res=new Valor(Constante.terror,"Error semantico, no se puede realizar operacion AND entre: "+valTipo(op1.getTipo())+" y "+valTipo(op2.getTipo()));
                     break;
            }
        return res;
    }
    public static Valor xor(Valor op1, Valor op2){       
        Valor res=new Valor(Constante.tbool, Constante.falso);
        switch(op1.tipo + op2.tipo){
            case 14: //bool con bool
                if(op1.getValor().equals(Constante.verdadero) && op2.getValor().equals(Constante.falso))
                    res.setValor(Constante.verdadero);
                if(op1.getValor().equals(Constante.falso) && op2.getValor().equals(Constante.verdadero))
                    res.setValor(Constante.verdadero);
                break;
            case 2://numero con numero
            case 8: //numero con bool
            case 11: // numero con decimal
            case 17: //decimal con bool
            case 20: //decimal con decimal
            case 16: //numero con caracter           
            case 25:  //decimal con caracter
            case 6: //cadena con cadena
            case 18: // cadena con caracter
            case 30: //caracter con caracter           
            case 4://numero con cadena
            case 10://cadena con bool
            case 22://boolean con caracter
            case 13: //decimal con cadena
                res=new Valor(Constante.terror,"Error semantico, no se puede realizar operacion XOR entre: "+valTipo(op1.getTipo())+" y "+valTipo(op2.getTipo()));
                 break;
        }
       return res;
   }
   public static Valor not(Valor op1){       
       Valor res=new Valor(Constante.tbool, Constante.falso);
       switch(op1.tipo){
           case Constante.tbool: //bool con bool
               if(op1.getValor().equals(Constante.falso))
                   res.setValor(Constante.verdadero);
               break;
           default:
               res=new Valor(Constante.terror,"Error semantico, no se puede realizar operacion Not a valor tipo: "+valTipo(op1.getTipo()));
                break;
       }
       return res;
   }
   private static String valBool(String val)
        {
            if (val.equals(Constante.verdadero))
            {
                return "1";
            }
            return "0";
        }
    public static String valTipo(int tipo)
        {
            switch (tipo)
            {
                case Constante.tnum:
                    return Constante.num;
                case Constante.tcadena:
                    return Constante.cadena;
                case Constante.tbool:
                    return Constante.bool;
                case Constante.terror:
                    return Constante.error;
                case Constante.tvacio:
                    return Constante.vacio;
                case Constante.tdecimal:
                    return Constante.decimal;
                case Constante.tcaracter:
                    return Constante.caracter;
                case Constante.tid:
                    return Constante.id;
            }
            return "-1";
        }
    public static Valor Asignacion(int tipo1, Valor valor2,String tals){                
        switch (tipo1){
                case Constante.tnum:
                    switch (valor2.getTipo()){                        
                        case Constante.tcadena:
                        case Constante.tid:
                            valor2.setValor("Error semantico, no se puede asignar un tipo "+valTipo(valor2.getTipo())+" a un tipo Entero.");
                            valor2.setTipo(Constante.terror);
                            break;
                        case Constante.tdecimal:
                            //verificar si puede obtenerse unicamente la parte entera
                            Double temp=Double.parseDouble(valor2.getValor());
                            int temp2=temp.intValue();                            
                            //se puede asignar a tipo entero
                            valor2.setTipo(Constante.tnum);
                            valor2.setValor(temp2+"");
                            break;
                        case Constante.tbool:
                            valor2.setTipo(Constante.tnum);
                            valor2.setValor(valBool(valor2.getValor()));
                            break;
                        case Constante.tcaracter:
                            valor2.setTipo(Constante.tnum);
                            valor2.setValor((int)valor2.getValor().charAt(0)+"");
                            break;                                                       
                    }
                    break;
                case Constante.tcadena:
                    switch (valor2.getTipo()){
                        case Constante.tnum:
                        case Constante.tcaracter:
                        case Constante.tdecimal:                            
                            valor2.setTipo(Constante.tcadena);
                            break;                        
                        case Constante.tbool:
                            valor2.setTipo(Constante.tcadena);
                            valor2.setValor(valBool(valor2.getValor()));
                            break;
                        case Constante.tid:                            
                            valor2.setValor("Error semantico, no se puede asignar un tipo "+valTipo(valor2.getTipo())+" a un tipo Cadena.");
                            valor2.setTipo(Constante.terror);
                            break;
                            
                    }
                    break;
                case Constante.tbool:
                    switch (valor2.getTipo()){
                        case Constante.tnum:
                        case Constante.tcadena:
                        case Constante.tcaracter:
                        case Constante.tdecimal:
                        case Constante.tid:
                            valor2.setValor("Error semantico, no se puede asignar un tipo "+valTipo(valor2.getTipo())+" a un tipo Bool.");
                            valor2.setTipo(Constante.terror);
                            break;                            
                    }
                    break;
                case Constante.tcaracter:
                    switch (valor2.getTipo()){
                        case Constante.tnum:
                            valor2.setTipo(Constante.tcaracter);
                            int v=Integer.parseInt(valor2.getValor());
                            char c;
                            if(v>0 && v<256){//es valido para ascci
                                c=(char)v;
                                valor2.setValor(c+"");
                            }else{
                                valor2.setValor("Error semantico, no se puede asignar un tipo "+valTipo(valor2.getTipo())+" a un tipo Caracter.");
                                valor2.setTipo(Constante.terror);
                            }
                        case Constante.tcadena:
                        case Constante.tcaracter:
                        case Constante.tdecimal:
                        case Constante.tid:
                            valor2.setValor("Error semantico, no se puede asignar un tipo "+valTipo(valor2.getTipo())+" a un tipo Caracter.");
                            valor2.setTipo(Constante.terror);
                            break;                            
                    }
                    break;
                case Constante.tdecimal:
                    switch (valor2.getTipo()){                        
                        case Constante.tcadena:
                        case Constante.tid:
                            valor2.setValor("Error semantico, no se puede asignar un tipo "+valTipo(valor2.getTipo())+" a un tipo Entero.");
                            valor2.setTipo(Constante.terror);
                            break;
                        case Constante.tnum:
                            valor2.setTipo(Constante.tdecimal);
                            valor2.setValor(Double.parseDouble(valor2.getValor())+"");
                            break;
                        case Constante.tbool:
                            valor2.setTipo(Constante.tnum);
                            valor2.setValor(valBool(valor2.getValor()));
                            break;
                        case Constante.tcaracter:
                            valor2.setTipo(Constante.tnum);
                            valor2.setValor((int)valor2.getValor().charAt(0)+"");
                            break;                                                       
                    }
                    break;
                case Constante.tid:
                    switch (valor2.getTipo()){                        
                        case Constante.tcadena:
                        //case Constante.tid:
                        case Constante.tnum:
                        case Constante.tbool:
                        case Constante.tcaracter:                                                                              
                            valor2.setValor("Error semantico, no se puede asignar un tipo "+valTipo(valor2.getTipo())+" a un tipo ALS.");
                            valor2.setTipo(Constante.terror);
                            break;
                    }
                    break;
            }
            if(tipo1==valor2.getTipo()){
                if(tipo1 == Constante.tid){
                    if(!tals.equals(valor2.getTals())){
                        valor2.setValor("Error semantico, no se puede asignar un tipo "+valor2.getTals()+" a un tipo "+tals);
                        valor2.setTipo(Constante.terror);
                    }
                }
            }
            return valor2; 
        }        
public static int Tipo(String tipo)
        {
            switch (tipo)
            {
                case Constante.num:
                    return Constante.tnum;                    
                case Constante.cadena:
                    return Constante.tcadena;
                case Constante.caracter:
                    return Constante.tcaracter;                
                case Constante.bool:
                    return Constante.tbool;                
                case Constante.vacio:
                    return Constante.tvacio;
                case Constante.decimal:
                    return Constante.tdecimal;
                case Constante.id:
                    return Constante.tid;
            }
            return -1;            
        }    
}
