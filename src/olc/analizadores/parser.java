
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package olc.analizadores;

import java_cup.runtime.*;
import olc.funciones.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import olc.GUI.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\026\000\002\002\004\000\002\002\003\000\002\003" +
    "\004\000\002\003\011\000\002\003\007\000\002\003\007" +
    "\000\002\003\003\000\002\006\003\000\002\006\003\000" +
    "\002\006\003\000\002\004\007\000\002\004\003\000\002" +
    "\004\002\000\002\005\004\000\002\005\004\000\002\005" +
    "\004\000\002\005\005\000\002\005\005\000\002\005\005" +
    "\000\002\005\003\000\002\005\003\000\002\005\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\063\000\014\003\005\004\012\007\007\011\006\022" +
    "\010\001\002\000\004\002\000\001\002\000\004\002\ufffb" +
    "\001\002\000\014\003\005\004\012\007\007\011\006\022" +
    "\010\001\002\000\004\007\053\001\002\000\004\006\025" +
    "\001\002\000\004\002\024\001\002\000\004\005\013\001" +
    "\002\000\004\022\014\001\002\000\004\006\015\001\002" +
    "\000\010\003\020\024\016\025\017\001\002\000\004\010" +
    "\ufff9\001\002\000\004\010\ufffa\001\002\000\004\010\ufff8" +
    "\001\002\000\004\010\022\001\002\000\014\003\005\004" +
    "\012\007\007\011\006\022\010\001\002\000\004\002\ufffe" +
    "\001\002\000\004\002\001\001\002\000\024\003\033\011" +
    "\032\013\030\014\036\015\034\016\027\017\035\021\026" +
    "\023\031\001\002\000\026\003\uffed\010\uffed\011\uffed\013" +
    "\uffed\014\uffed\015\uffed\016\uffed\017\uffed\021\uffed\023\uffed" +
    "\001\002\000\024\003\033\011\032\013\030\014\036\015" +
    "\034\016\027\017\035\021\026\023\031\001\002\000\024" +
    "\003\033\011\032\013\030\014\036\015\034\016\027\017" +
    "\035\021\026\023\031\001\002\000\026\003\uffee\010\uffee" +
    "\011\uffee\013\uffee\014\uffee\015\uffee\016\uffee\017\uffee\021" +
    "\uffee\023\uffee\001\002\000\004\022\047\001\002\000\026" +
    "\003\uffec\010\uffec\011\uffec\013\uffec\014\uffec\015\uffec\016" +
    "\uffec\017\uffec\021\uffec\023\uffec\001\002\000\024\003\033" +
    "\011\032\013\030\014\036\015\034\016\027\017\035\021" +
    "\026\023\031\001\002\000\024\003\033\011\032\013\030" +
    "\014\036\015\034\016\027\017\035\021\026\023\031\001" +
    "\002\000\024\003\033\011\032\013\030\014\036\015\034" +
    "\016\027\017\035\021\026\023\031\001\002\000\004\010" +
    "\040\001\002\000\014\003\005\004\012\007\007\011\006" +
    "\022\010\001\002\000\004\002\ufffd\001\002\000\026\003" +
    "\ufff2\010\ufff2\011\ufff2\013\ufff2\014\ufff2\015\ufff2\016\ufff2" +
    "\017\ufff2\021\ufff2\023\ufff2\001\002\000\024\003\033\011" +
    "\032\013\030\014\036\015\034\016\027\017\035\021\026" +
    "\023\031\001\002\000\026\003\ufff0\010\ufff0\011\ufff0\013" +
    "\ufff0\014\ufff0\015\ufff0\016\ufff0\017\ufff0\021\ufff0\023\ufff0" +
    "\001\002\000\024\003\033\011\032\013\030\014\036\015" +
    "\034\016\027\017\035\021\026\023\031\001\002\000\026" +
    "\003\ufff1\010\ufff1\011\ufff1\013\ufff1\014\ufff1\015\ufff1\016" +
    "\ufff1\017\ufff1\021\ufff1\023\ufff1\001\002\000\004\012\050" +
    "\001\002\000\026\003\uffef\010\uffef\011\uffef\013\uffef\014" +
    "\uffef\015\uffef\016\uffef\017\uffef\021\uffef\023\uffef\001\002" +
    "\000\026\003\ufff3\010\ufff3\011\ufff3\013\ufff3\014\ufff3\015" +
    "\ufff3\016\ufff3\017\ufff3\021\ufff3\023\ufff3\001\002\000\026" +
    "\003\ufff4\010\ufff4\011\ufff4\013\ufff4\014\ufff4\015\ufff4\016" +
    "\ufff4\017\ufff4\021\ufff4\023\ufff4\001\002\000\004\007\054" +
    "\001\002\000\004\007\055\001\002\000\010\002\ufff5\012" +
    "\057\022\060\001\002\000\004\002\ufffc\001\002\000\004" +
    "\002\ufff6\001\002\000\004\005\061\001\002\000\004\023" +
    "\062\001\002\000\004\010\063\001\002\000\010\002\ufff5" +
    "\012\057\022\060\001\002\000\004\002\ufff7\001\002\000" +
    "\004\002\uffff\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\063\000\006\002\010\003\003\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\003\064\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\006\020" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\003\022\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\005\036\001\001\000" +
    "\002\001\001\000\004\005\051\001\001\000\004\005\050" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\005\044\001\001\000\004\005\042\001\001" +
    "\000\004\005\041\001\001\000\002\001\001\000\004\003" +
    "\040\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\005\043\001\001\000\002\001\001\000\004\005\045\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\004\055\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\004\063\001\001\000\002\001\001" +
    "\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    //Codigo que se le agrega al parser
    public static Map<String, Arbol> map = new HashMap<String, Arbol>();
    public int contador = 1;
    public boolean flagi = true;

    public static Map<String, List<String>> conjunto = new HashMap<String, List<String>>();
    public static List<String> cadenas = new ArrayList<String>();

    //Codigo para Errores Sintacticos
    public void syntax_error(Symbol s)
    {
        System.err.println("Error en la Linea " + (s.right+1) +" Columna "+(s.left+1)+ ". Identificador "+s.value + " no reconocido. Se ha recuperado del error." );
        ErrorM nuevoe = new ErrorM("Tipo Sintactico (Recuperado)", s.value.toString(), s.right+1, s.left+1);
        FrameP.listaErrores.add(nuevoe);
        
    }
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception
    {
        System.err.println("Error en la Linea " + (s.right+1)+ " Columna "+(s.left+1)+". Identificador " +s.value + " no reconocido.");
        ErrorM nuevoe = new ErrorM("Tipo Sintactico (Irrecuperable)", s.value.toString(), s.right+1, s.left+1);
        FrameP.listaErrores.add(nuevoe);
        
    }  


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= ABC 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // ABC ::= open ABC 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("ABC",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // ABC ::= conj detail palabra assign CONJ end ABC 
            {
              Object RESULT =null;
		int nombreleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int nombreright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		String nombre = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int listaleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int listaright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		List lista = (List)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		 parser.conjunto.put(nombre, lista); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ABC",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // ABC ::= palabra assign EXP end ABC 
            {
              Object RESULT =null;
		int nombreleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int nombreright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		String nombre = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int var1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int var1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Nodo var1 = (Nodo)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		System.out.println(nombre);parser.map.put(nombre, new Arbol());
                                                parser.map.get(nombre).setRaiz(new Nodo(var1, new Nodo(null, null, "#", parser.contador) ,"." , 0));
                                                parser.contador++;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ABC",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // ABC ::= separate separate separate separate INP 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("ABC",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // ABC ::= error 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("ABC",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // CONJ ::= fromto 
            {
              List RESULT =null;
		int rangoleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rangoright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String rango = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT= Conjuntos.conjRange(rango);  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("CONJ",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // CONJ ::= conjuList 
            {
              List RESULT =null;
		int conjuntoleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int conjuntoright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String conjunto = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT= Conjuntos.conjList(conjunto); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("CONJ",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // CONJ ::= error 
            {
              List RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("CONJ",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // INP ::= palabra detail cadena end INP 
            {
              Object RESULT =null;
		int var1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int var1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		String var1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int var2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int var2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String var2 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		System.out.println(var1 +" es "+ var2);
                                                parser.cadenas.add(var1+":=:!"+var2);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INP",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // INP ::= clos 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("INP",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // INP ::= 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("INP",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // EXP ::= cerouno EXP 
            {
              Nodo RESULT =null;
		int var1left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int var1right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Nodo var1 = (Nodo)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT= new Nodo(var1, null, "?", parser.contador); parser.contador++; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // EXP ::= unomas EXP 
            {
              Nodo RESULT =null;
		int var1left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int var1right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Nodo var1 = (Nodo)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT= new Nodo(var1, null, "+", parser.contador); parser.contador++;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // EXP ::= ceromas EXP 
            {
              Nodo RESULT =null;
		int var1left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int var1right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Nodo var1 = (Nodo)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT= new Nodo(var1, null, "*", parser.contador); parser.contador++;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // EXP ::= conc EXP EXP 
            {
              Nodo RESULT =null;
		int var1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int var1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Nodo var1 = (Nodo)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int var2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int var2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Nodo var2 = (Nodo)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT= new Nodo(var1, var2, ".", parser.contador); parser.contador++;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // EXP ::= estot EXP EXP 
            {
              Nodo RESULT =null;
		int var1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int var1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Nodo var1 = (Nodo)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int var2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int var2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Nodo var2 = (Nodo)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT= new Nodo(var1, var2, "|", parser.contador); parser.contador++;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // EXP ::= open palabra clos 
            {
              Nodo RESULT =null;
		int simbololeft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int simboloright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String simbolo = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT= new Nodo(null, null, simbolo, parser.contador); parser.contador++;System.out.println(simbolo);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // EXP ::= cadena 
            {
              Nodo RESULT =null;
		int simbololeft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int simboloright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String simbolo = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT= new Nodo(null, null, simbolo, parser.contador); parser.contador++;System.out.println(simbolo);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // EXP ::= esp 
            {
              Nodo RESULT =null;
		int simbololeft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int simboloright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String simbolo = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT= new Nodo(null, null, simbolo, parser.contador); parser.contador++;System.out.println(simbolo);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // EXP ::= error 
            {
              Nodo RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
