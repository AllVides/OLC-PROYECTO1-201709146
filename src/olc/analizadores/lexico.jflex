package olc.analizadores;
import java_cup.runtime.Symbol;

%% 
%class lexico
%public 
%line 
%char 
%cup 
%unicode
%ignorecase

%init{ 
	yyline = 1; 
	yychar = 1; 
%init} 

BLANCOS=[ \r\t\n]+
COMENT= "//"([0-9]|[A-Za-z])* 
D=[0-9]+
S= ("+" | "*" | "." | "|" | "?")?
L = ([A-Za-z])+

%%

"CONJ" {return new Symbol(sym.conj,yyline,yychar, yytext());} 
"tld" {return new Symbol(sym.tld,yyline,yychar, yytext());} 
":" {return new Symbol(sym.detail,yyline,yychar, yytext());} 
""*"->"""* {return new Symbol(sym.assign,yyline,yychar, yytext());} 
"%%" {return new Symbol(sym.separate,yyline,yychar, yytext());} 
";" {return new Symbol(sym.end, yyline,yychar, yytext());}

\n {yychar=1;}

{BLANCOS} {} 
{COMENT} {}
{D} {return new Symbol(sym.entero,yyline,yychar, yytext());} 
{L} {return new Symbol(sym.palabra,yyline,yychar, yytext());}

. {
    System.out.println("Este es un error lexico: "+yytext()+
	", en la linea: "+yyline+", en la columna: "+yychar);

}

