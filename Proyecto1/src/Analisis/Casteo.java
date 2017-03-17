/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import Extras.Constante;

/**
 *
 * @author Jenny
 */
public class Casteo {
    //aritmeticas
   public static Valor suma(Valor op1, Valor op2){
        Valor res=new Valor();
        switch(op1.getTipo()+op2.getTipo()){
            case 2://numero con numero
                res=new Valor(Constante.tnum,Integer.parseInt(op1.getValor())+Integer.parseInt(op2.getValor())+"");
                break;
            case 4: //numero con cadena
            case 6://cadena con cadena                
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
            case 10://cadena con boolean
            case 22://boolean con caracter
                res=new Valor(Constante.terror,"Error semantico, no se puede realizar suma entre: "+valTipo(op1.getTipo())+" y "+valTipo(op2.getTipo()));
                break;                                
        }
        return res;
    }
   public static Valor resta(Valor op1, Valor op2){
        Valor res=new Valor();
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
   public static Valor potencia(Valor op1, Valor op2){
        Valor res=new Valor();
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
   public static Valor restaUnaria(Valor op1){
        Valor res=new Valor();
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
       switch(op1.tipo + op2.tipo){
           case 14: //bool con bool
               if(op1.getValor().equals(Constante.verdadero) && op2.getValor().equals(Constante.verdadero))
                   res.setValor(Constante.verdadero);
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
            }
            return "-1";
        }
}
