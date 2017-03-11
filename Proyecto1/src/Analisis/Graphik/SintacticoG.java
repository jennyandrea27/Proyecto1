
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Analisis.Graphik;

import java_cup.runtime.Symbol;
import Extras.*;
import Analisis.*;
import Reportes.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class SintacticoG extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return TSGraphik.class;
}

  /** Default constructor. */
  @Deprecated
  public SintacticoG() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public SintacticoG(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public SintacticoG(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\002\000\002\002\004\000\002\002\002" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\003\000\004\002\000\001\002\000\004\002\005\001" +
    "\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\003\000\004\002\003\001\001\000\002\001\001\000" +
    "\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$SintacticoG$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$SintacticoG$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$SintacticoG$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


//Codigo visible

    public void syntax_error(Symbol s){
        TablaErrores.insertarError("Error Sintactico: "+s.value.toString()+" ",s.right,s.left);
        System.out.println(s.value.toString()+" Fila: " +s.right+", Columna: "+s.left);
        HTML.mostrarErrores();
    }

    public void unrecovered_syntax_error(Symbol s){        
        TablaErrores.insertarError("Error Sintactico: "+s.value.toString()+" ",s.right,s.left);
        System.out.println(s.value.toString()+" Fila: " +s.right+", Columna: "+s.left);
        HTML.mostrarErrores();
    }



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$SintacticoG$actions {

//Codigo de acciones
      

  private final SintacticoG parser;

  /** Constructor */
  CUP$SintacticoG$actions(SintacticoG parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$SintacticoG$do_action_part00000000(
    int                        CUP$SintacticoG$act_num,
    java_cup.runtime.lr_parser CUP$SintacticoG$parser,
    java.util.Stack            CUP$SintacticoG$stack,
    int                        CUP$SintacticoG$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$SintacticoG$result;

      /* select the action based on the action number */
      switch (CUP$SintacticoG$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= S EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$SintacticoG$stack.elementAt(CUP$SintacticoG$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$SintacticoG$stack.elementAt(CUP$SintacticoG$top-1)).right;
		Nodo start_val = (Nodo)((java_cup.runtime.Symbol) CUP$SintacticoG$stack.elementAt(CUP$SintacticoG$top-1)).value;
		RESULT = start_val;
              CUP$SintacticoG$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$SintacticoG$stack.elementAt(CUP$SintacticoG$top-1)), ((java_cup.runtime.Symbol)CUP$SintacticoG$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$SintacticoG$parser.done_parsing();
          return CUP$SintacticoG$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // S ::= 
            {
              Nodo RESULT =null;
		
        System.out.println("Archivo finalizado");
        
    
              CUP$SintacticoG$result = parser.getSymbolFactory().newSymbol("S",0, ((java_cup.runtime.Symbol)CUP$SintacticoG$stack.peek()), RESULT);
            }
          return CUP$SintacticoG$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$SintacticoG$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$SintacticoG$do_action(
    int                        CUP$SintacticoG$act_num,
    java_cup.runtime.lr_parser CUP$SintacticoG$parser,
    java.util.Stack            CUP$SintacticoG$stack,
    int                        CUP$SintacticoG$top)
    throws java.lang.Exception
    {
              return CUP$SintacticoG$do_action_part00000000(
                               CUP$SintacticoG$act_num,
                               CUP$SintacticoG$parser,
                               CUP$SintacticoG$stack,
                               CUP$SintacticoG$top);
    }
}

}
