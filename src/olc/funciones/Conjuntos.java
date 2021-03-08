/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc.funciones;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class Conjuntos {
    public Map<String, List<String>> conjutos = new HashMap<String, List<String>>();
    
    public Conjuntos(){
        
    }

    public Map<String, List<String>> getConjutos() {
        return conjutos;
    }

    public void setConjutos(String nombre, List<String> lista) {
        this.conjutos = conjutos;
    }
    
    
}
