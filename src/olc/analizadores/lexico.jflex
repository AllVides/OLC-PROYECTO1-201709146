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
L = [A-Za-z]([A-Za-z0-9]|"_")*
Caracter =  "!"|"\""|"#"|"$"|"%"|"&"|"\'"|"("|")"|"*"|"+"|","|"."|"\-"|"/"|":"|";"|"<"|">"|"="|"?"|"\@"|"["|"\\"|"]"|"^"|"_"|"`"|"\{"|"\}"|"|"
WhiteSpace     = {LineTerminator} | [ \t\f]
EndOfLineComment     = ("//".*{LineTerminator})
DocumentationComment = "<!""!"*([^!>]|[^!]">"|"!"[^>])*"!"*"!>"
comment = ({EndOfLineComment} | {DocumentationComment})
charas=({Caracter} | [a-zA-Z0-9])
comillas = [\"\']
FLECHA = "-" {WhiteSpace}* ">"
Cadena = \"([^\r\n\"])+\"

%%

\{ {return new Symbol(sym.open, yyline, yychar, yytext());}
\} {return new Symbol(sym.clos, yyline, yychar, yytext());}
"CONJ" {return new Symbol(sym.conj,yyline,yychar, yytext());} 
":" {return new Symbol(sym.detail,yyline,yychar, yytext());} 
{FLECHA} {return new Symbol(sym.assign,yyline,yychar, yytext());} 
"%" {return new Symbol(sym.separate,yyline,yychar, yytext());} 
";" {return new Symbol(sym.end, yyline,yychar, yytext());}




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
{comment} {}
/*{Caracter} {return new Symbol (sym.carac,yyline,yychar,yytext());}*/
{charas} {return new Symbol (sym.charas,yyline,yychar,yytext());}
{L} {return new Symbol(sym.palabra,yyline,yychar, yytext());}
{Cadena} {return new Symbol (sym.cadena,yyline,yychar,yytext().substring(1,yytext().length()-1));}



.  {
	    System.err.println("Error lexico: "+yytext()+ " Linea:"+(yyline)+" Columna:"+(yycolumn));
           
    }


