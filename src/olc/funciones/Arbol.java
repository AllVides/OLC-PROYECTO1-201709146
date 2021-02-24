/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc.funciones;

/**
 *
 * @author Lenovo
 */
public class Arbol {
    public Nodo raiz;
    
    public Arbol (Nodo raiz){
        this.raiz = raiz;
    }
    public void insert(){
        
    }
}

class Nodo{
    public Nodo hizq;
    public Nodo hder;
    public String valor;
    public int id;
    
    public Nodo(Nodo hizq, Nodo hder, String valor, int id){
        this.hizq=hizq;
        this.hder=hder;
        this.valor=valor;
        this.id=id;
    }
    
    public String getCodigoInterno(){
        String etiqueta="";
        if(hizq==null && hder==null){
            etiqueta = "nodo"+id+"[label=\""+valor+"\"];\n";
        }
        else {
            etiqueta = "nodo" + id + " [ label =\"" + valor + "\"];\n";
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
