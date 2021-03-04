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
import olc.funciones.Nodo;

/**
 *
 * @author Lenovo
 */
public class Arbol {
    public Nodo raiz;
    public Map<String, List<String>> tablasig= new HashMap<String, List<String>>();
    public Map<String, String> map = new HashMap<String, String>();
    
    public Arbol (){
    }
    
    public void setRaiz(Nodo raiz){
        this.raiz = raiz;
    }
    public Nodo getRaiz(){
        return this.raiz;
    }
    
    public String Siguientes(){
        getTerminals(this.raiz);
        tablaSiguientes(this.raiz);
        return this.printSig();
    }
    
    public void getTerminals(Nodo nodo){
        if(nodo.hizq != null){
            getTerminals(nodo.hizq);}
        if(nodo.hder != null){
            getTerminals(nodo.hder);}
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
}



