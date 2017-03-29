
package Analisis.HaskellTerminal;
import java_cup.runtime.*;
import Reportes.*;

%%
%{//codigo java
StringBuffer string=new StringBuffer();
%}

%public
%class LexicoHT
%cupsym TSHT
%cup
%char
%column
%line
%full
%ignorecase
%unicode

//expresiones regulares
num = [0-9]+("."[0-9]+)?
id=[a-zA-Z]([a-zA-Z] | [0-9] | "_")*
caracter="'"."'"
enter= \r|\n|\r\n
espacio={enter}|[ \t\f]
cadena=\"(\\.|[^\"])*\"
//estados
%%

//lexico

//palabras reservadas
<YYINITIAL> {
"'mod'"                   
{return new Symbol (TSHT.mod, yycolumn, yyline, yytext());}
"'sqrt'"                    
{return new Symbol (TSHT.sqrt, yycolumn, yyline, yytext());}
"'pot'"                     
{return new Symbol (TSHT.pot, yycolumn, yyline, yytext());}
"let"                      
{return new Symbol (TSHT.let, yycolumn, yyline, yytext());}
"calcular"             
{return new Symbol (TSHT.calcular, yycolumn, yyline, yytext());}
"succ"                   
{return new Symbol (TSHT.succ, yycolumn, yyline, yytext());}
"decc"                  
{return new Symbol (TSHT.decc, yycolumn, yyline, yytext());}
"min"                    
{return new Symbol (TSHT.min, yycolumn, yyline, yytext());}
"max"                   
{return new Symbol (TSHT.max, yycolumn, yyline, yytext());}
"sum"                   
{return new Symbol (TSHT.sum, yycolumn, yyline, yytext());}
"product"             
{return new Symbol (TSHT.product, yycolumn, yyline, yytext());}
"revers"               
{return new Symbol (TSHT.revers, yycolumn, yyline, yytext());}
"impr"                  
{return new Symbol (TSHT.impr, yycolumn, yyline, yytext());}
"par"                    
{return new Symbol (TSHT.par, yycolumn, yyline, yytext());}
"asc"                    
{return new Symbol (TSHT.asc, yycolumn, yyline, yytext());}
"desc"                  
{return new Symbol (TSHT.desc, yycolumn, yyline, yytext());}
"length"                
{return new Symbol (TSHT.length, yycolumn, yyline, yytext());}
"++"     
{return new Symbol (TSHT.concatenacion, yycolumn, yyline, yytext());}
"+"                
{return new Symbol (TSHT.suma, yycolumn, yyline, yytext());}
"-"                 
{return new Symbol (TSHT.resta, yycolumn, yyline, yytext());}
"*"             
{return new Symbol (TSHT.mult, yycolumn, yyline, yytext());}
"/"               
{return new Symbol (TSHT.div, yycolumn, yyline, yytext());}
"%"               
{return new Symbol (TSHT.porcentaje, yycolumn, yyline, yytext());}
"="             
{return new Symbol (TSHT.igual, yycolumn, yyline, yytext());}
"$"               
{return new Symbol (TSHT.dolar, yycolumn, yyline, yytext());}
"["         
{return new Symbol (TSHT.corchetea, yycolumn, yyline, yytext());}
"]"         
{return new Symbol (TSHT.corchetec, yycolumn, yyline, yytext());}
"{"                
{return new Symbol (TSHT.llavea, yycolumn, yyline, yytext());}
"}"            
{return new Symbol (TSHT.llavec, yycolumn, yyline, yytext());}
"("                
{return new Symbol (TSHT.parentesisa, yycolumn, yyline, yytext());}
")"            
{return new Symbol (TSHT.parentesisc, yycolumn, yyline, yytext());}
","          
{return new Symbol (TSHT.coma, yycolumn, yyline, yytext());}
"!!"          
{return new Symbol (TSHT.acceso, yycolumn, yyline, yytext());}
{num}         
{return new Symbol (TSHT.num, yycolumn, yyline, yytext());}
{cadena}            
{ return new Symbol(TSHT.cadena, yycolumn, yyline, yytext().replace("\"", "")); }
{id}          
{return new Symbol (TSHT.id, yycolumn, yyline, yytext().toLowerCase());}
{caracter}          
{return new Symbol (TSHT.caracter, yycolumn, yyline, yytext().replace("'", ""));}
{espacio}          
{/*se ignora*/}
}

    
[^]             {
                    TablaErrores.insertarError("Error lexico, caracter "+yytext()+" no pertenece al lenguaje.",yyline,yycolumn);                    
                  }



