/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc.funciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import olc.analizadores.parser;
import olc.funciones.Nodo;

/**
 *
 * @author Lenovo
 */
public class Arbol {
    public Nodo raiz;
    public Map<String, List<String>> tablasig= new HashMap<String, List<String>>();
    public Map<String, String> map = new HashMap<String, String>();
    public AFD auto;
    public int contador = 0;
    
    public Arbol (){
    }
    
    public void setRaiz(Nodo raiz){
        this.raiz = raiz;
    }
    public Nodo getRaiz(){
        return this.raiz;
    }
    
    public String afd(){
        return this.auto.printAFD();
    }
    
    public String Automata(){
        Map<String, String> map = new TreeMap<String, String>(this.map);
        Map<String, List<String>> tablasig = new TreeMap<String, List<String>>(this.tablasig);
        this.auto = new AFD(tablasig, map, this.raiz.primeros, this.raiz.hder.leafid);
        this.auto.createState();
        this.auto.createTrans();
        return this.auto.printTabla();
    }
    
    public String Siguientes(){
        getTerminals(this.raiz);
        tablaSiguientes(this.raiz);
        return this.printSig();
    }
    
    public void getTerminals(Nodo nodo){
        if(nodo.hizq != null){
            getTerminals(nodo.hizq);
        }
        if(nodo.hder != null){
            getTerminals(nodo.hder);
        }
        if(nodo.hizq == null && nodo.hder == null){
            this.map.put(String.valueOf(nodo.id),nodo.valor);
        }
    }
    
    public void tablaSiguientes(Nodo nodo){
        if(nodo.hizq !=null){
            tablaSiguientes(nodo.hizq);
        }
        if(nodo.hder!=null){
            tablaSiguientes(nodo.hder);
        }
        if(nodo.hder==null && nodo.hizq == null){
            return;
        }
        
        if(nodo.valor == "."){
            for(String num: nodo.hizq.ultimos){
                if(this.tablasig.containsKey(num)){
                    List aux = nodo.hder.primeros;
                    aux.removeAll(this.tablasig.get(num));
                    this.tablasig.get(num).addAll(aux);
                    
                }
                else{this.tablasig.put(num, nodo.hder.primeros);}
            }
        }else
        if(nodo.valor == "*" || nodo.valor == "+"){
            for(String num: nodo.hizq.ultimos){
                if(this.tablasig.containsKey(num)){
                    List aux = nodo.hizq.primeros;
                    aux.removeAll(this.tablasig.get(num));
                    this.tablasig.get(num).addAll(aux);
                }
                else{this.tablasig.put(num, nodo.hizq.primeros);}
            }
        }
    }
    
    
    public String printSig(){
        String etiqueta = "nodounico[label=\" {Hoja|Siguientes}";
        Map<String, String> map = new TreeMap<String, String>(this.map);
        for(Map.Entry<String, String> nodito: map.entrySet()){
            String siguientes="";
            if(this.tablasig.containsKey(nodito.getKey())){
                siguientes = String.join(",",this.tablasig.get(nodito.getKey()));
            } else {siguientes = "---";}
            etiqueta += "|";
            etiqueta += "{"+nodito.getKey()+" -- "+nodito.getValue()+"|"+
                    siguientes+"}";
        }
        etiqueta += "\"];\n";
        return etiqueta;
    }
    
    public String evaluar(String cadena, String nombre){
        String retorno="\t{\n"
                + "\t\t\"Valor\":\""+cadena+"\",\n"
                + "\t\t\"ExpresionRegular\":\""+nombre+"\",\n"
                + "\t\t\"Resultado\":\""+this.auto.validar(cadena)+"\"\n"
                + "\t},\n";
                
        
        return retorno;
    }
    
    public String AFND(){
        String cont = "";
        int primero = this.contador;
        contador++;
        int ultimo = this.contador;
        contador++;
        cont += primero+"[label=\""+primero+"\"];\n";
        cont += ultimo+"[shape=doublecircle label=\""+ultimo+"\"];\n";
        return AFND(this.raiz, primero, ultimo);
    }
    
    public String AFND(Nodo raiz, int primero, int ultimo){
        String con = "";
        if(raiz.hizq == null && raiz.hder == null){
            return primero +"->"+ultimo+"[label=\""+raiz.valor+"\"];\n";
        }
        
        if(raiz.valor == "."){
            int medio = this.contador;
            this.contador++;
            con += medio+"[label=\""+medio+"\"];\n";
            if(raiz.hizq !=null){
                con += AFND(raiz.hizq, primero, medio);
            }
            if(raiz.hder !=null){
                con += AFND(raiz.hder, medio, ultimo);
            }
            
        }else if(raiz.valor == "|"){
            int arriba1 = this.contador; this.contador++;
            int arriba2 = this.contador; this.contador++;
            int abajo1 = this.contador; this.contador++;
            int abajo2 = this.contador; this.contador++;
            
            con += arriba1+"[label=\""+arriba1+"\"];\n";
            con += arriba2+"[label=\""+arriba2+"\"];\n";
            con += abajo1+"[label=\""+abajo1+"\"];\n";
            con += abajo2+"[label=\""+abajo2+"\"];\n";
            
            con += primero+"->"+arriba1+"[label=\"vacio\"];\n";
            con += primero+"->"+abajo1+"[label=\"vacio\"];\n";
            con += arriba2+"->"+ultimo+"[label=\"vacio\"];\n";
            con += abajo2+"->"+ultimo+"[label=\"vacio\"];\n";
            
            con += AFND(raiz.hizq, arriba1, arriba2);
            con += AFND(raiz.hder, abajo1, abajo2);
            
        }else if(raiz.valor == "?"){
            int medio1 = this.contador; this.contador++;
            int medio2 = this.contador; this.contador++;
            
            con += medio1+"[label=\""+medio1+"\"];\n";
            con += medio2+"[label=\""+medio2+"\"];\n";
            
            con += primero+"->"+medio1+"[label=\"vacio\"];\n";
            con += medio2+"->"+ultimo+"[label=\"vacio\"];\n";

            con += AFND(raiz.hizq, medio1, medio2);
        }else if(raiz.valor == "*"){
            int medio1 = this.contador; this.contador++;
            int medio2 = this.contador; this.contador++;
            
            con += medio1+"[label=\""+medio1+"\"];\n";
            con += medio2+"[label=\""+medio2+"\"];\n";
            
            con += primero+"->"+ultimo+"[label=\"vacio\"];\n";
            con += primero+"->"+medio1+"[label=\"vacio\"];\n";
            con += medio2+"->"+ultimo+"[label=\"vacio\"];\n";
            con += medio2+"->"+medio1+"[label=\"vacio\"];\n"; 
            con += AFND(raiz.hizq, medio1, medio2);
            
        }else if(raiz.valor == "+"){  
            int medio1 = this.contador; this.contador++;
            int medio2 = this.contador; this.contador++;
            
            con += medio1+"[label=\""+medio1+"\"];\n";
            con += medio2+"[label=\""+medio2+"\"];\n";
            
            con += primero+"->"+medio1+"[label=\"vacio\"];\n";
            con += medio2+"->"+ultimo+"[label=\"vacio\"];\n";
            con += medio2+"->"+medio1+"[label=\"vacio\"];\n"; 
            con += AFND(raiz.hizq, medio1, medio2);
        }
        return con;
    }
    
}



