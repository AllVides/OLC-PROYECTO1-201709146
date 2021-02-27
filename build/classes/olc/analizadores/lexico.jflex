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

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "<!" {InputCharacter}| {WhiteSpace} "!"+ ">"
ESPECIALES= _|"."

comillas = [\"]
FLECHA = "-" {WhiteSpace}* ">"
L = ([A-Z]|[a-z]|[0-9])+

%%

\{ {return new Symbol(sym.open, yyline, yychar, yytext());}
\} {return new Symbol(sym.clos, yyline, yychar, yytext());}
"CONJ" {return new Symbol(sym.conj,yyline,yychar, yytext());} 
":" {return new Symbol(sym.detail,yyline,yychar, yytext());} 
{FLECHA} {return new Symbol(sym.assign,yyline,yychar, yytext());} 
"%" {return new Symbol(sym.separate,yyline,yychar, yytext());} 
";" {return new Symbol(sym.end, yyline,yychar, yytext());}

/*"\n" {return new Symbol (sym.salli, yyline, yychar, yytext());}*/
{comillas} {return new Symbol (sym.comidob, yyline, yychar, yytext());}


\' {return new Symbol (sym.comi, yyline, yychar, yytext());}
"~" {return new Symbol (sym.fromto, yyline, yychar, yytext());}
"," {return new Symbol (sym.coma, yyline, yychar, yytext());}

"+" {return new Symbol(sym.unomas, yyline, yychar, yytext());}
"*" {return new Symbol(sym.ceromas, yyline, yychar, yytext());}
"." {return new Symbol(sym.conc, yyline, yychar, yytext());}
"?" {return new Symbol(sym.cerouno, yyline, yychar, yytext());}
"|" {return new Symbol(sym.estot, yyline, yychar, yytext());}

\n          {yycolumn=1;}

{WhiteSpace} {} 
{LineTerminator} {}
{EndOfLineComment} {}
{DocumentationComment} {}
{L} {return new Symbol(sym.palabra,yyline,yychar, yytext());}
{ESPECIALES} {return new Symbol(sym.esp,yyline,yychar, yytext());}

.  {
	    System.err.println("Error lexico: "+yytext()+ " Linea:"+(yyline)+" Columna:"+(yycolumn));
           
    }


