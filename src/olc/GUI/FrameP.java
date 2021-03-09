/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc.GUI;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.filechooser.FileNameExtensionFilter;
import olc.analizadores.lexico;
import olc.analizadores.parser;
import olc.funciones.Arbol;
import olc.funciones.Nodo;
import olc.funciones.ErrorM;


/**
 *
 * @author Lenovo
 */
public class FrameP extends javax.swing.JFrame {

    /**
     * Creates new form FrameP
     */
    public static ArrayList<ErrorM> listaErrores = new ArrayList<ErrorM>();
    
    public FrameP() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "INPUT"));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setText("Cargar Archivo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Guardar Archivo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Generar AFD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Analizar Expr.");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Guardar como...");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)))
                        .addGap(0, 379, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "OUTPUT"));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();

        chooser.setFileFilter(new FileNameExtensionFilter("Archivos html", "html"));

        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

            String path = chooser.getSelectedFile().getPath();
            //crearHTML(path.endsWith(".html") ? path : path + ".html");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();

        chooser.setFileFilter(new FileNameExtensionFilter("Archivos html", "html"));

        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

            String path = chooser.getSelectedFile().getPath();
            //crearHTML(path.endsWith(".html") ? path : path + ".html");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();

        chooser.setFileFilter(new FileNameExtensionFilter("Archivos html", "html"));
        
        
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

            String path = chooser.getSelectedFile().getPath();
            //crearHTML(path.endsWith(".html") ? path : path + ".html");
            
            
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        checkDir();
        try {
            parser sintaxis;
            sintaxis = new parser(new lexico(new StringReader(this.jTextArea1.getText())));
            sintaxis.parse();
            for (Map.Entry<String, java.util.List<String>> entry : sintaxis.conjunto.entrySet()) {
                System.out.println(entry.getValue() +" es "+entry.getKey());
            }
            try{
                for (Map.Entry<String, Arbol> entry : sintaxis.map.entrySet()) {
                    try{
                        String acto = entry.getValue().raiz.getCodigoInterno();
                        graficar(acto,"OUTPUT/ARBOLES_201709146/"+entry.getKey());
                        acto = entry.getValue().Siguientes();
                        graficar(acto,"OUTPUT/SIGUIENTES_201709146/"+entry.getKey());
                        acto = entry.getValue().Automata();
                        graficar(acto, "OUTPUT/TRANSICIONES_201709146/"+entry.getKey());
                        acto = entry.getValue().afd();
                        graficar(acto, "OUTPUT/AFD_201709146/"+entry.getKey());
                        generarHTML();
                        for(int i = 0; i<sintaxis.cadenas.size();i++){
                            String[] eval = sintaxis.cadenas.get(i).split(":=:!");
                            try{
                                parser.map.get(eval[0]).evaluar(eval[1]);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }catch(Exception f){
                        generarHTML();
                    }
                }
                parser.map = new HashMap<String, Arbol>();
            
            }catch(Exception r){r.printStackTrace();}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton5ActionPerformed

    public static void generarHTML() throws IOException{
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("../OUTPUT/ERRORES_201709146/errores.html");
            pw = new PrintWriter(fichero);
            //comenzamos a escribir el html
            pw.println("<html>");
            pw.println("<head><title>REPORTE DE ERRORES</title></head>");
            pw.println("<body>");
            pw.println("<div align=\"center\">");
            pw.println("<h1>Reporte de Errores</h1>");
            pw.println("<br></br>");
            pw.println("<table border=1>");
            pw.println("<tr>");
            pw.println("<td bgcolor=blue>TIPO</td>");
            pw.println("<td bgcolor=blue>VALOR</td>");
            pw.println("<td bgcolor=blue>FILA</td>");
            pw.println("<td bgcolor=blue>COLUMNA</td>");
            pw.println("</tr>");
            for(int i=0;i<listaErrores.size();i++){
                pw.println("<tr>");
                pw.println("<td>"+listaErrores.get(i).getTipoError()+"</td>");
                pw.println("<td>"+listaErrores.get(i).getValorError()+"</td>");
                pw.println("<td>"+listaErrores.get(i).getFila()+"</td>");
                pw.println("<td>"+listaErrores.get(i).getColumna()+"</td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("</div");
            pw.println("</body>");
            pw.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(null!=fichero){
                fichero.close();
            }
        }
    }
    
    public void graficar(String act, String nombre){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("../" + nombre + ".dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph G{");
            pw.println("rankdir=UD");
            pw.println("node[shape=record]");
            pw.println("concentrate=true");
            pw.println(act);
            pw.println("}");
        } catch (Exception e) {
            System.out.println("error, no se realizo el archivo");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try{       
            ProcessBuilder pbuilder;
		pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", "../" + nombre + ".png", "../" + nombre + ".dot" );
		pbuilder.redirectErrorStream( true );			//Ejecuta el proceso
		pbuilder.start();
		    
	} catch (Exception e) { e.printStackTrace(); }
        
        
       
         
    }
    
    public void checkDir(){
        File direct = new File("../OUTPUT");
        if (!direct.exists()) {
            direct.mkdirs(); 
        }
        File directorio = new File("../OUTPUT/ARBOLES_201709146");
        if (!directorio.exists()) {
            directorio.mkdirs(); 
        }
        directorio = new File("../OUTPUT/AFND_201709146");
        if (!directorio.exists()) {
            directorio.mkdirs(); 
        }
        directorio = new File("../OUTPUT/SIGUIENTES_201709146");
        if (!directorio.exists()) {
            directorio.mkdirs(); 
        }
        directorio = new File("../OUTPUT/TRANSICIONES_201709146");
        if (!directorio.exists()) {
            directorio.mkdirs(); 
        }
        directorio = new File("../OUTPUT/AFD_201709146");
        if (!directorio.exists()) {
            directorio.mkdirs(); 
        }
        directorio = new File("../OUTPUT/ERRORES_201709146");
        if (!directorio.exists()) {
            directorio.mkdirs(); 
        }
        directorio = new File("../OUTPUT/SALIDAS_201709146");
        if (!directorio.exists()) {
            directorio.mkdirs(); 
        }
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
