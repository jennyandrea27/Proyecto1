package Analisis;
import java_cup.runtime.*;

%%
%{//codigo java
StringBuffer string=new StringBuffer();
%}

%public
%class Lexico
%cupsym TS
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
enter= \r|\n|\r\n
espacio={enter}|[ \t\f]
//estados
%%

//lexico

//palabras reservadas
<YYINITIAL> {
"arreglo"                      
{return new Symbol (TS.arreglo, yycolumn, yyline, yytext());}
"["                   
{return new Symbol (TS.corchetea, yycolumn, yyline, yytext());}
"]"                    
{return new Symbol (TS.corchetec, yycolumn, yyline, yytext());}
"ubicar"                     
{return new Symbol (TS.ubicar, yycolumn, yyline, yytext());}
".."                     
{return new Symbol (TS.puntopunto, yycolumn, yyline, yytext());}
{num}         
{return new Symbol (TS.num, yycolumn, yyline, yytext());}
{id}          
{return new Symbol (TS.id, yycolumn, yyline, yytext());}
{espacio}          
{/*se ignora*/}
}

    
[^]             {/*errores lexicos*/}
