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
COMENT= "//"("/"|[0-9]|[A-Za-z])* 
D=[0-9]+

L = ([A-Za-z])+

%%

"{" {return new Symbol(sym.open, yyline, yychar, yytext());}
"}" {return new Symbol(sym.close, yyline, yychar, yytext());}
"CONJ" {return new Symbol(sym.conj,yyline,yychar, yytext());} 
":" {return new Symbol(sym.detail,yyline,yychar, yytext());} 
""*"->"""* {return new Symbol(sym.assign,yyline,yychar, yytext());} 
"%%" {return new Symbol(sym.separate,yyline,yychar, yytext());} 
";" {return new Symbol(sym.end, yyline,yychar, yytext());}

"+" {return new Symbol(sym.unomas, yyline, yychar, yytext());}
"*" {return new Symbol(sym.ceromas, yyline, yychar, yytext());}
"." {return new Symbol(sym.conc, yyline, yychar, yytext());}
"?" {return new Symbol(sym.cerouno, yyline, yychar, yytext());}
"|" {return new Symbol(sym.estot, yyline, yychar, yytext());}

\n {yychar=1;}

{BLANCOS} {} 
{COMENT} {}
{D} {return new Symbol(sym.entero,yyline,yychar, yytext());} 
{L} {return new Symbol(sym.palabra,yyline,yychar, yytext());}

. {
    System.out.println("Este es un error lexico: "+yytext()+
	", en la linea: "+yyline+", en la columna: "+yychar);

}

