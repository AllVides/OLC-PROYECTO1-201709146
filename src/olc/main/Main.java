/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc.main;

import java.io.StringReader;
import olc.analizadores.*;

/**
 *
 * @author Lenovo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try {
            parser sintactico;
            sintactico = new parser(new lexico(new StringReader("CONJ:daefef->958558 ;")));
            sintactico.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
