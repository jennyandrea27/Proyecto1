package Analisis.HaskellArchivo;
import java_cup.runtime.*;

%%
%{//codigo java
StringBuffer string=new StringBuffer();
%}

%public
%class LexicoH
%cupsym TSHaskell
%cup
%char
%column
%line
%full
%ignorecase
%unicode

//expresiones regulares
num = [0-9]+
id=[a-zA-Z]([a-zA-Z] | [0-9] | "_")*
caracter="'"."'"
enter= \r|\n|\r\n
eol=\n
espacio={enter}|[ \t\f]
cadena=\"(\\.|[^\'])*\"
//estados
%%

//lexico

//palabras reservadas
<YYINITIAL> {
"'mod'"                   
{return new Symbol (TSHaskell.mod, yycolumn, yyline, yytext());}
"'sqrt'"                    
{return new Symbol (TSHaskell.sqrt, yycolumn, yyline, yytext());}
"'pot'"                     
{return new Symbol (TSHaskell.pot, yycolumn, yyline, yytext());}
"let"                      
{return new Symbol (TSHaskell.let, yycolumn, yyline, yytext());}
"calcular"             
{return new Symbol (TSHaskell.calcular, yycolumn, yyline, yytext());}
"succ"                   
{return new Symbol (TSHaskell.succ, yycolumn, yyline, yytext());}
"decc"                  
{return new Symbol (TSHaskell.decc, yycolumn, yyline, yytext());}
"min"                    
{return new Symbol (TSHaskell.min, yycolumn, yyline, yytext());}
"max"                   
{return new Symbol (TSHaskell.max, yycolumn, yyline, yytext());}
"sum"                   
{return new Symbol (TSHaskell.sum, yycolumn, yyline, yytext());}
"product"             
{return new Symbol (TSHaskell.product, yycolumn, yyline, yytext());}
"revers"               
{return new Symbol (TSHaskell.revers, yycolumn, yyline, yytext());}
"impr"                  
{return new Symbol (TSHaskell.impr, yycolumn, yyline, yytext());}
"par"                    
{return new Symbol (TSHaskell.par, yycolumn, yyline, yytext());}
"asc"                    
{return new Symbol (TSHaskell.asc, yycolumn, yyline, yytext());}
"desc"                  
{return new Symbol (TSHaskell.desc, yycolumn, yyline, yytext());}
"length"                
{return new Symbol (TSHaskell.length, yycolumn, yyline, yytext());}
"if"                       
{return new Symbol (TSHaskell.si, yycolumn, yyline, yytext());}
"then"                   
{return new Symbol (TSHaskell.entonces, yycolumn, yyline, yytext());}
"end"                    
{return new Symbol (TSHaskell.fin, yycolumn, yyline, yytext());}
"else"                   
{return new Symbol (TSHaskell.sino, yycolumn, yyline, yytext());}
"case"                  
{return new Symbol (TSHaskell.caso, yycolumn, yyline, yytext());}
"++"     
{return new Symbol (TSHaskell.concatenacion, yycolumn, yyline, yytext());}
"+"                
{return new Symbol (TSHaskell.suma, yycolumn, yyline, yytext());}
"-"                 
{return new Symbol (TSHaskell.resta, yycolumn, yyline, yytext());}
"*"             
{return new Symbol (TSHaskell.mult, yycolumn, yyline, yytext());}
"/"               
{return new Symbol (TSHaskell.div, yycolumn, yyline, yytext());}
"||"                
{return new Symbol (TSHaskell.o, yycolumn, yyline, yytext());}
"&&"               
{return new Symbol (TSHaskell.y, yycolumn, yyline, yytext());}
">="  
{return new Symbol (TSHaskell.mayorigual, yycolumn, yyline, yytext());}
"<="     
{return new Symbol (TSHaskell.menorigual, yycolumn, yyline, yytext());}
">"         
{return new Symbol (TSHaskell.mayor, yycolumn, yyline, yytext());}
"<"     
{return new Symbol (TSHaskell.menor, yycolumn, yyline, yytext());}
"=="    
{return new Symbol (TSHaskell.igualacion, yycolumn, yyline, yytext());}
"!="          
{return new Symbol (TSHaskell.distinto, yycolumn, yyline, yytext());}
"="             
{return new Symbol (TSHaskell.igual, yycolumn, yyline, yytext());}
"$"               
{return new Symbol (TSHaskell.dolar, yycolumn, yyline, yytext());}
"["         
{return new Symbol (TSHaskell.corchetea, yycolumn, yyline, yytext());}
"]"         
{return new Symbol (TSHaskell.corchetec, yycolumn, yyline, yytext());}
"{"                
{return new Symbol (TSHaskell.llavea, yycolumn, yyline, yytext());}
"}"            
{return new Symbol (TSHaskell.llavec, yycolumn, yyline, yytext());}
"("                
{return new Symbol (TSHaskell.parentesisa, yycolumn, yyline, yytext());}
")"            
{return new Symbol (TSHaskell.parentesisc, yycolumn, yyline, yytext());}
","          
{return new Symbol (TSHaskell.coma, yycolumn, yyline, yytext());}
";"          
{return new Symbol (TSHaskell.puntoycoma, yycolumn, yyline, yytext());}
":"          
{return new Symbol (TSHaskell.dospuntos, yycolumn, yyline, yytext());}
"!!"          
{return new Symbol (TSHaskell.acceso, yycolumn, yyline, yytext());}
{eol}
{return new Symbol (TSHaskell.eol, yycolumn, yyline, yytext());}
{num}         
{return new Symbol (TSHaskell.num, yycolumn, yyline, yytext());}
{cadena}            
{ return new Symbol(TSHaskell.cadena, yycolumn, yyline, yytext().replace("\"", "")); }
{id}          
{return new Symbol (TSHaskell.id, yycolumn, yyline, yytext());}
{caracter}          
{return new Symbol (TSHaskell.caracter, yycolumn, yyline, yytext());}
{espacio}          
{/*se ignora*/}
}

    
[^]             {/*errores lexicos*/}



