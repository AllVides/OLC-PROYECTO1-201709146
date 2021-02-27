/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc.funciones;

import java.util.ArrayList;
import java.util.List;
import olc.funciones.Nodo;

/**
 *
 * @author Lenovo
 */
public class Arbol {
    public Nodo raiz;
    public int contador = 1;
    
    public Arbol (){
    }
    
    public void setRaiz(Nodo raiz){
        this.raiz = raiz;
    }
    public Nodo getRaiz(){
        return this.raiz;
    }
    
    public void isNulable(){
        isNulable(this.raiz);
    }
    public void isNulable(Nodo nodo){
        if(nodo.hizq != null){
            isNulable(nodo.hizq);}
        if(nodo.hizq != null){
            isNulable(nodo.hder);}
        nodo.isNulable();
    }
    
}



