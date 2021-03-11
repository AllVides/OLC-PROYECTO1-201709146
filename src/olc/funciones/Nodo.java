/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc.funciones;

import java.util.ArrayList;
import java.util.List;
import olc.GUI.FrameP;

/**
 *
 * @author Lenovo
 */
public class Nodo {
    public Nodo hizq;
    public Nodo hder;
    public String valor;
    public List<String> ultimos = new ArrayList<String>();
    public List<String> primeros = new ArrayList<String>();
    public String nulable;
    public int id;
    
    public Nodo(Nodo hizq, Nodo hder, String valor, int id){
        this.hizq=hizq;
        this.hder=hder;
        this.valor=valor;
        this.id=id;
        try{
            this.isNulable();
            this.setPrimeros();
            this.setUltimos();}
        catch(Exception e){
            ErrorM nuevoe = new ErrorM("Inicalizacoin de Nodo", valor, 0, 0);
            FrameP.listaErrores.add(nuevoe);
        }
    }
    
    
    
    public void isNulable(){
        if(this.hder == null && this.hizq == null){
            this.nulable = "N";
            return;
        }
        if (this.valor == "*" || this.valor == "?"){
            this.nulable = "A";
        }else if(this.valor == "|"){
            this.nulable = (this.hizq.nulable == "A"||this.hder.nulable =="A")?"A":"N";
        }else if(this.valor == "."){
            this.nulable = (this.hizq.nulable == "A"&&this.hder.nulable =="A")?"A":"N";
        }else if(this.valor == "+"){
            this.nulable = this.hizq.nulable;
        }
    }
    
    public void setPrimeros(){
        if(this.hder == null && this.hizq == null){
            this.primeros.add(String.valueOf(this.id));
            return;
        }
        if (this.valor == "*" || this.valor == "?"||this.valor == "+"){
            this.primeros = this.hizq.primeros;
        }else if(this.valor == "|"){
            this.primeros.addAll(this.hizq.primeros); 
            this.primeros.addAll(this.hder.primeros);
        }else if(this.valor == "."){
            if(this.hizq.nulable == "A"){
                this.primeros.addAll(this.hizq.primeros); 
                this.primeros.addAll(this.hder.primeros);
            } else{
                this.primeros.addAll(this.hizq.primeros); 
            }
        }
    }
    
    public void setUltimos(){
        if(this.hder == null && this.hizq == null){
            this.ultimos.add(String.valueOf(this.id));
            return;
        }
        if (this.valor == "*" || this.valor == "?"||this.valor == "+"){
            this.ultimos = this.hizq.ultimos;
        }else if(this.valor == "|"){
            this.ultimos.addAll(this.hizq.ultimos); 
            this.ultimos.addAll(this.hder.ultimos);
        }else if(this.valor == "."){
            if(this.hder.nulable == "A"){
                this.ultimos.addAll(this.hizq.ultimos); 
                this.ultimos.addAll(this.hder.ultimos);
            } else{
                this.ultimos.addAll(this.hder.ultimos); 
            }
        }
    }
    
    public String getCodigoInterno(){
        String etiqueta="";
        String pri = String.join(",", this.primeros);
        String ult = String.join(",", this.ultimos);
        String valor = (this.valor.equals("|"))?"\\|":this.valor;
        
        if(hizq==null && hder==null){
            etiqueta = "nodo"+id+"[label=\"<f0> "+pri+"|{<f1>"+this.nulable+" |<f2> "+valor+"|<f3> id: "+this.id+"}|<f5>"+ult+"\"];\n";
        }
        else {
            etiqueta = "nodo"+id+"[label=\"<f0> "+pri+"|{<f1>"+this.nulable+" |<f2> "+valor+"|<f3> id: "+this.id+"}|<f5>"+ult+"\"];\n";
        }
        if(hizq !=null){
            etiqueta+=hizq.getCodigoInterno()+"nodo"+id+"->nodo"+hizq.id+";\n";
        }
        if(hder!=null){
            etiqueta+=hder.getCodigoInterno()+"nodo"+id+"->nodo"+hder.id+";\n";
        }
        return etiqueta;
        
         
    }
}
