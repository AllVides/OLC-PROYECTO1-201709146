/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc.analizadores;

/**
 *
 * @author Lenovo
 */
public class InitAnalizador {
    public static void main(String[] args){
        try {
            String ruta = "src/olc/analizadores/";
            String opcFlex[] = {ruta + "lexico.jflex", "-d", ruta};
            jflex.Main.generate(opcFlex);
            
            String opcCUP[] = {"-destdir", ruta, "-parser", "parser", ruta + "sintaxis.cup"};
            java_cup.Main.main(opcCUP);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
}
