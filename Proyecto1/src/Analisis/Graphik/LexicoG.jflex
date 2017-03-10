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
dec = [0-9]+("."[0-9]+)?
id=[a-zA-Z]([a-zA-Z] | [0-9] | "_")*
caracter="'"."'"
enter= \r|\n|\r\n
espacio={enter}|[ \t\f]
cadena=\"(\\.|[^\"])*\"
comentario_parrafo=#\/(\\.|[^\/#])*\/#
comentario_linea=#(\\.|[^\n])*\n
//estados
%%

//lexico

//palabras reservadas
<YYINITIAL> {
"var"                      
{return new Symbol (TSGraphik.var, yycolumn, yyline, yytext());}
"'entero'"                   
{return new Symbol (TSGraphik.tentero, yycolumn, yyline, yytext());}
"'cadena'"                    
{return new Symbol (TSGraphik.tcadena, yycolumn, yyline, yytext());}
"'decimal'"                     
{return new Symbol (TSGraphik.tdecimal, yycolumn, yyline, yytext());}
"caracter"             
{return new Symbol (TSGraphik.tcaracter, yycolumn, yyline, yytext());}
"vacio"                   
{return new Symbol (TSGraphik.tvacio, yycolumn, yyline, yytext());}
"bool"                  
{return new Symbol (TSGraphik.tbool, yycolumn, yyline, yytext());}
"publico"                    
{return new Symbol (TSGraphik.publico, yycolumn, yyline, yytext());}
"protegido"                   
{return new Symbol (TSGraphik.protegido, yycolumn, yyline, yytext());}
"privado"                   
{return new Symbol (TSGraphik.privado, yycolumn, yyline, yytext());}
"importar"             
{return new Symbol (TSGraphik.importar, yycolumn, yyline, yytext());}
".gk"             
{return new Symbol (TSGraphik.gk, yycolumn, yyline, yytext());}
"als"               
{return new Symbol (TSGraphik.als, yycolumn, yyline, yytext());}
"hereda"                  
{return new Symbol (TSGraphik.hereda, yycolumn, yyline, yytext());}
"nuevo"                    
{return new Symbol (TSGraphik.nuevo, yycolumn, yyline, yytext());}

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

"?"                 
{return new Symbol (TSGraphik.pregc, yycolumn, yyline, yytext());}
":"          
{return new Symbol (TSGraphik.dospuntos, yycolumn, yyline, yytext());}
"="             
{return new Symbol (TSGraphik.igual, yycolumn, yyline, yytext());}
"{"                
{return new Symbol (TSGraphik.llavea, yycolumn, yyline, yytext());}
"}"            
{return new Symbol (TSGraphik.llavec, yycolumn, yyline, yytext());}
"++"     
{return new Symbol (TSGraphik.masmas, yycolumn, yyline, yytext());}
"--"     
{return new Symbol (TSGraphik.menosmenos, yycolumn, yyline, yytext());}
"+"                
{return new Symbol (TSGraphik.suma, yycolumn, yyline, yytext());}
"-"                 
{return new Symbol (TSGraphik.resta, yycolumn, yyline, yytext());}
"*"             
{return new Symbol (TSGraphik.mult, yycolumn, yyline, yytext());}
"/"               
{return new Symbol (TSGraphik.div, yycolumn, yyline, yytext());}
"^"               
{return new Symbol (TSGraphik.potencia, yycolumn, yyline, yytext());}
"("                
{return new Symbol (TSGraphik.parentesisa, yycolumn, yyline, yytext());}
")"            
{return new Symbol (TSGraphik.parentesisc, yycolumn, yyline, yytext());}
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
"||"                
{return new Symbol (TSGraphik.o, yycolumn, yyline, yytext());}
"&&"               
{return new Symbol (TSGraphik.y, yycolumn, yyline, yytext());}
"&|"                
{return new Symbol (TSGraphik.xor, yycolumn, yyline, yytext());}
"!"
{return new Symbol (TSGraphik.not, yycolumn, yyline, yytext());}
"."               
{return new Symbol (TSGraphik.punto, yycolumn, yyline, yytext());}

"["         
{return new Symbol (TSGraphik.corchetea, yycolumn, yyline, yytext());}
"]"         
{return new Symbol (TSGraphik.corchetec, yycolumn, yyline, yytext());}
","          
{return new Symbol (TSGraphik.coma, yycolumn, yyline, yytext());}
";"          
{return new Symbol (TSGraphik.puntoycoma, yycolumn, yyline, yytext());}
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
{comentario_parrafo}          
{/*se ignora*/}
{comentario_linea}          
{/*se ignora*/}
{espacio}          
{/*se ignora*/}
}

    
[^]             {/*errores lexicos*/}




