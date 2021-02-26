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

BLANCOS= [ \r\t\n]+
COMENT= "//"({L}|{ESPECIALES})* {BLANCOS}
COMENT1= "<!"({ESPECIALES}|{BLANCOS}|{L})*"!>"
ESPECIALES= [^A-Za-z0-9~\r\t]
L = ([A-Za-z0-9])+
expresion = ({ESPECIALES}|{L})*

%%

"{" {return new Symbol(sym.open, yyline, yychar, yytext());}
"}" {return new Symbol(sym.close, yyline, yychar, yytext());}
"CONJ" {return new Symbol(sym.conj,yyline,yychar, yytext());} 
":" {return new Symbol(sym.detail,yyline,yychar, yytext());} 
""*"->"""* {return new Symbol(sym.assign,yyline,yychar, yytext());} 
"%%" {return new Symbol(sym.separate,yyline,yychar, yytext());} 
";" {return new Symbol(sym.end, yyline,yychar, yytext());}

"\n" {return new Symbol (sym.salli, yyline, yychar, yytext());}
"\"" {return new Symbol (sym.comidob, yyline, yychar, yytext());}
"\'" {return new Symbol (sym.comi, yyline, yychar, yytext());}
"~" {return new Symbol (sym.fromto, yyline, yychar, yytext());}
"," {return new Symbol (sym.coma, yyline, yychar, yytext());}

"+" {return new Symbol(sym.unomas, yyline, yychar, yytext());}
"*" {return new Symbol(sym.ceromas, yyline, yychar, yytext());}
"." {return new Symbol(sym.conc, yyline, yychar, yytext());}
"?" {return new Symbol(sym.cerouno, yyline, yychar, yytext());}
"|" {return new Symbol(sym.estot, yyline, yychar, yytext());}



{BLANCOS} {} 
{COMENT} {}
{COMENT1} {}
{L} {return new Symbol(sym.palabra,yyline,yychar, yytext());}
{ESPECIALES} {return new Symbol(sym.esp,yyline,yychar, yytext());}
{expresion} {return new Symbol(sym.exp,yyline,yychar,yytext());}


