/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jvss2
 */
public class ListarProfessores extends javax.swing.JFrame {

    /**
     * Creates new form ListarProfessores
     */
    public ListarProfessores() throws FileNotFoundException, IOException {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setTitle("Listar Professores");

    
        text_area.setLayout(null);
        text_area.setEditable(false);
        
        PrintStream outputPrintStream = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                text_area.append(String.valueOf((char) b));
            }
        });
        System.setOut(outputPrintStream);      
        
        String[] professor;        
        BufferedReader buffRead = new BufferedReader(new FileReader("professor.txt"));
        String linha = "";
        ArrayList<String> preferencias = null; 
        while (true) {
            try {
                linha = buffRead.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Disciplina.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (linha != null) {
                professor = linha.split(",");              
                
                String matutino = "";
                String vespertino = ""; 
                String noturno = "";
             
                if(professor[2].equals("true"))
                    matutino = "Matutino";
                if(professor[3].equals("true"))
                    vespertino = "Vespertino";
                if(professor[4].equals("true"))
                    noturno = "Noturno";              
                
                System.out.println("=============");  
                System.out.println("Nome: "+professor[1]);
                System.out.println("Matricula: "+professor[0]+
                        "\nTurnos de trabalho: "+matutino+" "+ vespertino+" "+noturno);
                System.out.println("Preferencias: ");
                for(int i=5; i<professor.length; i++){
                    System.out.println(professor[i]);                    
                }               
                
            }else
                break;
        }
        buffRead.close();        
    }

    ListarProfessores(boolean menu) throws IOException {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
        setTitle("Listar Professores");
        btn_menu.setVisible(false);
    
        text_area.setLayout(null);
        text_area.setEditable(false);
        
        PrintStream outputPrintStream = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                text_area.append(String.valueOf((char) b));
            }
        });
        System.setOut(outputPrintStream);      
        
        String[] professor;        
        BufferedReader buffRead = new BufferedReader(new FileReader("professor.txt"));
        String linha = "";
        ArrayList<String> preferencias = null; 
        while (true) {
            try {
                linha = buffRead.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Disciplina.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (linha != null) {
                professor = linha.split(",");              
                
                String matutino = "";
                String vespertino = ""; 
                String noturno = "";
             
                if(professor[2].equals("true"))
                    matutino = "Matutino";
                if(professor[3].equals("true"))
                    vespertino = "Vespertino";
                if(professor[4].equals("true"))
                    noturno = "Noturno";              
                
                System.out.println("=============");  
                System.out.println("Nome: "+professor[1]);
                System.out.println("Matricula: "+professor[0]+
                        "\nTurnos de trabalho: "+matutino+" "+ vespertino+" "+noturno);
                System.out.println("Preferencias: ");
                for(int i=5; i<professor.length; i++){
                    System.out.println(professor[i]);                    
                }               
                
            }else
                break;
        }
        buffRead.close();        
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
        lbl_listar_prof = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text_area = new javax.swing.JTextArea();
        btn_menu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_listar_prof.setText("Listagem de  Professores");

        text_area.setColumns(20);
        text_area.setRows(5);
        jScrollPane1.setViewportView(text_area);

        btn_menu.setText("Menu");
        btn_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_menu)
                .addGap(278, 278, 278))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(lbl_listar_prof)
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_listar_prof)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_menu)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Inicio().setVisible(true);
        
    }//GEN-LAST:event_btn_menuActionPerformed

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
            java.util.logging.Logger.getLogger(ListarProfessores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarProfessores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarProfessores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarProfessores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ListarProfessores().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ListarProfessores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_menu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_listar_prof;
    private javax.swing.JTextArea text_area;
    // End of variables declaration//GEN-END:variables
}
