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

/**
 *
 * @author Lenovo
 */
public class AFD {
    public Map<String, List<String>> tablasig;
    public Map<String, String> terminales;
    public List<String> inicial;
    public List<String> aceptacion = new ArrayList<String>();
    public String ultimo;
    public Map<List<String>, String> estados = new HashMap<List<String>, String>();
    public Map<List<String>, String> transiciones = new HashMap<List<String>, String>();
    
    public AFD(Map tablasig, Map terminales, List<String> inicial, String ultimo){
        this.tablasig = tablasig;
        this.terminales = terminales;
        this.inicial = inicial; 
        this.ultimo = ultimo;
    }
    
    public void createState(){
        String s = "S";
        int contador = 0;
        this.estados.put(this.inicial, s+contador); contador++;
        for(Map.Entry<String,List<String>> estado : this.tablasig.entrySet() ){
            if (!this.estados.containsKey(estado.getValue())){
                if(!(estado.getKey() == this.ultimo)){
                    this.estados.put(estado.getValue(),s+contador);
                    if(!estado.getValue().contains(this.ultimo)){
                        this.aceptacion.add(this.estados.get(estado.getValue()));
                    }
                    contador++;
                }
            }
        }
    }
    
    
    public void createTrans(){
        for(Map.Entry<List<String>,String> estado : this.estados.entrySet() ){
            for(String value: estado.getKey()){
                if(!(this.ultimo == value)){
                    String pase = this.terminales.get(value);
                    String actual = estado.getValue();
                    String futuro = this.estados.get(this.tablasig.get(value));
                    List<String> llave = new ArrayList<String>();
                    llave.add(actual); llave.add(pase);
                    this.transiciones.put(llave, futuro);
                }
                
            }
        }
    }
    
    public List<String> reducir(){
        List<String> reducidos = new ArrayList<String>();
        for(Map.Entry<String, String> termi : this.terminales.entrySet()){
            if(!reducidos.contains(termi.getValue())){
                reducidos.add(termi.getValue());
            }
        }
        reducidos.remove("#");
        return reducidos;
    }
    
    public String printTabla(){
        String etiqueta = "nodounico[label=\" {Estado";
        for(Map.Entry<List<String>,String> estado : this.estados.entrySet() ){
            etiqueta+= "|";
            etiqueta+= estado.getValue()+" "+estado.getKey();
        }
        etiqueta+="}";
        
        for(String termi : reducir()){
            etiqueta+="|{"+termi;
            List<String> llave = new ArrayList<String>();
            llave.add(""); llave.add(termi);
            for(Map.Entry<List<String>,String> estado : this.estados.entrySet() ){
                etiqueta+= "|";
                llave.set(0, estado.getValue());
                if(this.transiciones.containsKey(llave)){
                    etiqueta+= this.transiciones.get(llave);
                }else{
                    etiqueta+= "---";
                }
            }
            etiqueta += "}";
        }
        etiqueta += "\"];\n";
        return etiqueta;
    }
    
    
    public String printAFD(){
        String etiqueta = "";
        for(Map.Entry<List<String>,String> nodo : this.estados.entrySet()){
            if(this.aceptacion.contains(nodo.getValue())){
                etiqueta += "nodo"+nodo.getValue()+"[shape=doublecircle label=\""+nodo.getValue()+"\"];\n";
            }else{
                etiqueta += "nodo"+nodo.getValue()+"[shape=circle label=\""+nodo.getValue()+"\"];\n";
            }
        }
        
        for(Map.Entry<List<String>, String> trans : this.transiciones.entrySet()){
            etiqueta += "nodo"+trans.getKey().get(0)+"->"+"nodo"+trans.getValue()+"[label=\""+trans.getKey().get(1)+"\"];\n";
        }
        
        return etiqueta;
        
    }
    
    public String charIn(char in, List<String> reducidos){
        String flag = "";
        if (reducidos.contains(""+in)){
            return ""+in;
        }
        for(String termi: reducidos){
            if(parser.conjunto.containsKey(termi)){
                flag = termi;
                if(parser.conjunto.get(flag).contains(""+in)){
                    break;
                }
            }
        }
        return flag;
    }
    
    public String validar(String cadena){
        try{
            String actual = this.estados.get(this.inicial);
            boolean charValido = false;
            List<String> reducidos = reducir();
            List<String> llave = new ArrayList<String>();
            llave.add(actual); llave.add("");
        
            for(int i = 0; i < cadena.length(); i++){
                String transi = charIn(cadena.charAt(i),reducidos);
                llave.set(1, transi);
                if(this.transiciones.containsKey(llave)){
                    actual = this.transiciones.get(llave);
                    llave.set(0, actual);
                    charValido = true;
                }else{
                    charValido = false;
                    break;
                }
            
            }
            if(charValido && this.aceptacion.contains(actual)){
            //denotar como aprobada
                System.out.println(cadena + " aprobada");
                return "Cadena Valida";
            }else{
            //denotar como fallida
                System.out.println(cadena + " reprobada");
                return "Cadena Invalida";
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("por aqui es el nullPointer");
            return "error";
        }
    }
}
