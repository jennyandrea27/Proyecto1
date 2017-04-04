package Analisis.Graphik;
import java_cup.runtime.*;
import Reportes.*;

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
idgk=[a-zA-Z]([a-zA-Z] | [0-9] | "_")*".gk"
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
"entero"                   
{return new Symbol (TSGraphik.tentero, yycolumn, yyline, yytext());}
"cadena"                    
{return new Symbol (TSGraphik.tcadena, yycolumn, yyline, yytext());}
"decimal"                     
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
"als"               
{return new Symbol (TSGraphik.als, yycolumn, yyline, yytext());}
"hereda"                  
{return new Symbol (TSGraphik.hereda, yycolumn, yyline, yytext());}
"nuevo"                    
{return new Symbol (TSGraphik.nuevo, yycolumn, yyline, yytext());}
"retornar"                    
{return new Symbol (TSGraphik.retornar, yycolumn, yyline, yytext());}
"llamarhk"                    
{return new Symbol (TSGraphik.llamarhk, yycolumn, yyline, yytext());}
"llamar"                  
{return new Symbol (TSGraphik.llamar, yycolumn, yyline, yytext());}
"inicio"                
{return new Symbol (TSGraphik.inicio, yycolumn, yyline, yytext());}
"incluir_hk"                       
{return new Symbol (TSGraphik.incluirhk, yycolumn, yyline, yytext());}
"si"                    
{return new Symbol (TSGraphik.si, yycolumn, yyline, yytext());}
"sino"                   
{return new Symbol (TSGraphik.sino, yycolumn, yyline, yytext());}
"seleccion"                  
{return new Symbol (TSGraphik.seleccion, yycolumn, yyline, yytext());}
"caso"                    
{return new Symbol (TSGraphik.caso, yycolumn, yyline, yytext());}
"defecto"                    
{return new Symbol (TSGraphik.defecto, yycolumn, yyline, yytext());}
"para"                    
{return new Symbol (TSGraphik.para, yycolumn, yyline, yytext());}
"mientras"                    
{return new Symbol (TSGraphik.mientras, yycolumn, yyline, yytext());}
"hacer"                    
{return new Symbol (TSGraphik.hacer, yycolumn, yyline, yytext());}
"continuar"                    
{return new Symbol (TSGraphik.continuar, yycolumn, yyline, yytext());}
"terminar"                    
{return new Symbol (TSGraphik.terminar, yycolumn, yyline, yytext());}
"graphikar_funcion"                    
{return new Symbol (TSGraphik.graphikar, yycolumn, yyline, yytext());}
"datos"                    
{return new Symbol (TSGraphik.datos, yycolumn, yyline, yytext());}
"columna"                    
{return new Symbol (TSGraphik.columna, yycolumn, yyline, yytext());}
"procesar"                    
{return new Symbol (TSGraphik.procesar, yycolumn, yyline, yytext());}
"dondecada"                    
{return new Symbol (TSGraphik.dondecada, yycolumn, yyline, yytext());}
"dondetodo"                    
{return new Symbol (TSGraphik.dondetodo, yycolumn, yyline, yytext());}
"donde"                    
{return new Symbol (TSGraphik.donde, yycolumn, yyline, yytext());}
"imprimir"                    
{return new Symbol (TSGraphik.imprimir, yycolumn, yyline, yytext());}
"falso"                    
{return new Symbol (TSGraphik.falso, yycolumn, yyline, yytext());}
"verdadero"                    
{return new Symbol (TSGraphik.verdadero, yycolumn, yyline, yytext());}
"?"                 
{return new Symbol (TSGraphik.pregc, yycolumn, yyline, yytext());}
":"          
{return new Symbol (TSGraphik.dospuntos, yycolumn, yyline, yytext());}
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
"="             
{return new Symbol (TSGraphik.igual, yycolumn, yyline, yytext());}
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
{num}         
{return new Symbol (TSGraphik.num, yycolumn, yyline, yytext());}
{dec}         
{return new Symbol (TSGraphik.decimal, yycolumn, yyline, yytext());}
{cadena}            
{ return new Symbol(TSGraphik.cadena, yycolumn, yyline, yytext().replace("\"", "")); }
{caracter}          
{return new Symbol (TSGraphik.caracter, yycolumn, yyline, yytext().replace("\'", ""));}
{idgk}          
{return new Symbol (TSGraphik.idgk, yycolumn, yyline, yytext());}
{id}          
{return new Symbol (TSGraphik.id, yycolumn, yyline, yytext().toLowerCase());}
{comentario_parrafo}          
{/*se ignora*/}
{comentario_linea}          
{/*se ignora*/}
{espacio}          
{/*se ignora*/}
}

    
[^]             {
                    TablaErrores.insertarError("Error lexico, caracter "+yytext()+" no pertenece al lenguaje.",yyline,yycolumn);                    
                  }