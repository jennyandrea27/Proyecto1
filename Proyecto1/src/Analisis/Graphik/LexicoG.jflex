package Analisis.Graphik;
import java_cup.runtime.*;

%%
%{//codigo java
StringBuffer string=new StringBuffer();
%}

%public
%class LexicoG
%cupsym TSGraphik
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
{return new Symbol (TSGraphik.mod, yycolumn, yyline, yytext());}
"'sqrt'"                    
{return new Symbol (TSGraphik.sqrt, yycolumn, yyline, yytext());}
"'pot'"                     
{return new Symbol (TSGraphik.pot, yycolumn, yyline, yytext());}
"let"                      
{return new Symbol (TSGraphik.let, yycolumn, yyline, yytext());}
"calcular"             
{return new Symbol (TSGraphik.calcular, yycolumn, yyline, yytext());}
"succ"                   
{return new Symbol (TSGraphik.succ, yycolumn, yyline, yytext());}
"decc"                  
{return new Symbol (TSGraphik.decc, yycolumn, yyline, yytext());}
"min"                    
{return new Symbol (TSGraphik.min, yycolumn, yyline, yytext());}
"max"                   
{return new Symbol (TSGraphik.max, yycolumn, yyline, yytext());}
"sum"                   
{return new Symbol (TSGraphik.sum, yycolumn, yyline, yytext());}
"product"             
{return new Symbol (TSGraphik.product, yycolumn, yyline, yytext());}
"revers"               
{return new Symbol (TSGraphik.revers, yycolumn, yyline, yytext());}
"impr"                  
{return new Symbol (TSGraphik.impr, yycolumn, yyline, yytext());}
"par"                    
{return new Symbol (TSGraphik.par, yycolumn, yyline, yytext());}
"asc"                    
{return new Symbol (TSGraphik.asc, yycolumn, yyline, yytext());}
"desc"                  
{return new Symbol (TSGraphik.desc, yycolumn, yyline, yytext());}
"length"                
{return new Symbol (TSGraphik.length, yycolumn, yyline, yytext());}
"if"                       
{return new Symbol (TSGraphik.si, yycolumn, yyline, yytext());}
"then"                   
{return new Symbol (TSGraphik.entonces, yycolumn, yyline, yytext());}
"end"                    
{return new Symbol (TSGraphik.fin, yycolumn, yyline, yytext());}
"else"                   
{return new Symbol (TSGraphik.sino, yycolumn, yyline, yytext());}
"case"                  
{return new Symbol (TSGraphik.caso, yycolumn, yyline, yytext());}
"++"     
{return new Symbol (TSGraphik.concatenacion, yycolumn, yyline, yytext());}
"+"                
{return new Symbol (TSGraphik.suma, yycolumn, yyline, yytext());}
"-"                 
{return new Symbol (TSGraphik.resta, yycolumn, yyline, yytext());}
"*"             
{return new Symbol (TSGraphik.mult, yycolumn, yyline, yytext());}
"/"               
{return new Symbol (TSGraphik.div, yycolumn, yyline, yytext());}
"||"                
{return new Symbol (TSGraphik.o, yycolumn, yyline, yytext());}
"&&"               
{return new Symbol (TSGraphik.y, yycolumn, yyline, yytext());}
">="  
{return new Symbol (TSGraphik.mayorigual, yycolumn, yyline, yytext());}
"<="     
{return new Symbol (TSGraphik.menorigual, yycolumn, yyline, yytext());}
">"         
{return new Symbol (TSGraphik.mayor, yycolumn, yyline, yytext());}
"<"     
{return new Symbol (TSGraphik.menor, yycolumn, yyline, yytext());}
"=="    
{return new Symbol (TSGraphik.igualacion, yycolumn, yyline, yytext());}
"!="          
{return new Symbol (TSGraphik.distinto, yycolumn, yyline, yytext());}
"="             
{return new Symbol (TSGraphik.igual, yycolumn, yyline, yytext());}
"$"               
{return new Symbol (TSGraphik.dolar, yycolumn, yyline, yytext());}
"["         
{return new Symbol (TSGraphik.corchetea, yycolumn, yyline, yytext());}
"]"         
{return new Symbol (TSGraphik.corchetec, yycolumn, yyline, yytext());}
"{"                
{return new Symbol (TSGraphik.llavea, yycolumn, yyline, yytext());}
"}"            
{return new Symbol (TSGraphik.llavec, yycolumn, yyline, yytext());}
"("                
{return new Symbol (TSGraphik.parentesisa, yycolumn, yyline, yytext());}
")"            
{return new Symbol (TSGraphik.parentesisc, yycolumn, yyline, yytext());}
","          
{return new Symbol (TSGraphik.coma, yycolumn, yyline, yytext());}
";"          
{return new Symbol (TSGraphik.puntoycoma, yycolumn, yyline, yytext());}
":"          
{return new Symbol (TSGraphik.dospuntos, yycolumn, yyline, yytext());}
"!!"          
{return new Symbol (TSGraphik.acceso, yycolumn, yyline, yytext());}
{eol}
{return new Symbol (TSGraphik.eol, yycolumn, yyline, yytext());}
{num}         
{return new Symbol (TSGraphik.num, yycolumn, yyline, yytext());}
{cadena}            
{ return new Symbol(TSGraphik.cadena, yycolumn, yyline, yytext().replace("\"", "")); }
{id}          
{return new Symbol (TSGraphik.id, yycolumn, yyline, yytext());}
{caracter}          
{return new Symbol (TSGraphik.caracter, yycolumn, yyline, yytext());}
{espacio}          
{/*se ignora*/}
}

    
[^]             {/*errores lexicos*/}




