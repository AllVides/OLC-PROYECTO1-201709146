/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc.funciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class Conjuntos {
    public static List conjList(String first){
        List<String> lista = Arrays.asList(first.split(","));
        for(int i = 0; i<lista.size();i++){
            lista.set(i, lista.get(i).replaceAll(" ", ""));
        }
        return lista;
    }
    
    public static List conjRange(String first){
        List<String> lista = new ArrayList<String>();
        char ini = first.charAt(0);
        char end = first.charAt(first.length() -1);
        
        
        if(/*nums*/ini >= 48 && ini <=57 && end >= 48 && end <=57 && ini <= end){
            for(int i = ini; i <= end; i++){
                lista.add(""+(char)(i));
            }
        }else if(/*mayus*/ini >= 65 && ini <=90 && end >= 65 && end <=90 && ini <= end){
            for(int i = ini; i <= end; i++){
                lista.add(""+(char)(i));
            }
        }else if(/*minus*/ini >= 97 && ini <=122 && end >= 97 && end <=122 && ini <= end){
            for(int i = ini; i <= end; i++){
                lista.add(""+(char)(i));
            }
        }else {              
            for(int i = ini; i<=end; i++){
                if(i >= 32 && i <=47){
                    lista.add(""+(char)(i));
                }
                if(i >= 58 && i <=64){
                    lista.add(""+(char)(i));
                }
                if(i >= 91 && i <=96){
                    lista.add(""+(char)(i));
                }
                if(i >= 98 && i <=125){
                    lista.add(""+(char)(i));
                } 
            }
        }
        return lista;
    }
    
    
    
}
