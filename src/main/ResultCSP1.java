/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import main.CSPturmaToHorario.Horario;
import main.CSPturmaToHorario.TurmaHorario;
import main.aima.Assignment;
import main.aima.FlexibleBacktrackingSolver;

/**
 *
 * @author jvss2
 */
public class ResultCSP1 extends javax.swing.JFrame {

    private  ArrayList<Professor> professores_oferta; 
    private ArrayList<Disciplina> disciplinas_oferta ; 
    
    private ArrayList<Disciplina> disciplinas_dcomp;
    private ArrayList<Disciplina> disciplinas_outros_deptos ;
    private ArrayList<String> disc_nao_alocadas; 
    
    public ResultCSP1(ArrayList<Professor> professores_oferta, ArrayList<Disciplina> disciplinas_oferta) throws IOException{
        initComponents();
        
        this.disciplinas_oferta = disciplinas_oferta;
        this.professores_oferta = professores_oferta;
        this.disciplinas_dcomp = new ArrayList<Disciplina>();
        this.disciplinas_outros_deptos = new ArrayList<Disciplina>();
        
        String[] itens = new String[28];
        itens[0]= "2T12 e 4T12";
        itens[1]= "2T34 e 4T34";
        itens[2]= "2T56 e 4T56";
        itens[3]= "3T12 e 5T12";
        itens[4]= "3T34 e 5T34";
        itens[5]= "3T56 e 5T56";
        itens[6]= "4T12 e 6T12";
        itens[7]= "4T34 e 6T34";
        itens[8]= "4T56 e 6T56";
        itens[9]= "3T12 e 6T12";   
        itens[10]= "3T34 e 6T34";    
        itens[11]= "3T56 e 6T56";    
        itens[12]= "2T12 e 5T12";    
        itens[13]= "2T34 e 5T34";    
        itens[14]= "2T56 e 5T56";    
        itens[15]= "2T12 e 6T12";    
        itens[16]= "2T34 e 6T34";    
        itens[17]= "2T56 e 6T56";    
        itens[18]= "2T12 e 2T34";    
        itens[19]= "3T12 e 3T34";    
        itens[20]= "4T12 e 4T34";    
        itens[21]= "5T12 e 5T34";            
        itens[22]= "6T12 e 6T34";  
        itens[23]= "2T34 e 2T56";
        itens[24]= "3T34 e 3T56";
        itens[25]= "4T34 e 4T56";
        itens[26]= "5T34 e 5T56";
        itens[27]= "6T34 e 6T56";        
        DefaultComboBoxModel model1 = new DefaultComboBoxModel(itens);
        DefaultComboBoxModel model2 = new DefaultComboBoxModel(itens);
        
        horario_fisica.setModel(model1);
        horario_calculo.setModel(model2);      
        
        this.setResizable(false);
        setTitle("Resultado alocação disciplinas para os professores");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        area_sucesso.setEditable(false);
        area_prof_sem_disc.setEditable(false);
        area_disc_sem_prof.setEditable(false);
        
        //separa as disciplinas do dcomp das de outros deptos
        for(int i=0; i<disciplinas_oferta.size();i++){
            if(disciplinas_oferta.get(i).getCodigo().charAt(0)!='C'){                
                this.disciplinas_outros_deptos.add(disciplinas_oferta.get(i));                            
            }else{
                this.disciplinas_dcomp.add(disciplinas_oferta.get(i));                
            }         
        }  
        ArrayList<String> disc_alocadas = new ArrayList<String>();
        for(int i=0; i<professores_oferta.size(); i++){
            if(professores_oferta.get(i).getLecionadas().get(0).charAt(0)=='a'){
                area_prof_sem_disc.append("=============\n");
                area_prof_sem_disc.append("Nome: "+professores_oferta.get(i).getNome()+"\n");
                area_prof_sem_disc.append("Matricula: "+professores_oferta.get(i).getMatricula()+"\n");
            }else{
                area_sucesso.append("=============\n");
                area_sucesso.append("Nome: "+professores_oferta.get(i).getNome()+"\n");
                for(int j=0; j<professores_oferta.get(i).getLecionadas().size();j++){
                    area_sucesso.append(professores_oferta.get(i).getLecionadas().get(j)+"-"+
                            Disciplina.retornaDisciplina(professores_oferta.get(i).getLecionadas().get(j)).getNome()+"\n");
                    disc_alocadas.add(professores_oferta.get(i).getLecionadas().get(j));
                }                
            }            
        }
        boolean a = false; 
        
        disc_nao_alocadas = new ArrayList<String>();
        for(int i=0; i<disciplinas_dcomp.size(); i++){
            a=false; 
            for(int j=0; j<disc_alocadas.size(); j++){
                if(disciplinas_dcomp.get(i).getCodigo().equals(disc_alocadas.get(j))){
                    a = true; 
                }
                if(a==false && j==disc_alocadas.size()-1){
                    disc_nao_alocadas.add(disciplinas_dcomp.get(i).getCodigo());                    
                }
            }            
        }
        
        for(int i=0; i<disc_nao_alocadas.size(); i++){
            Disciplina d = Disciplina.retornaDisciplina(disc_nao_alocadas.get(i));
            area_disc_sem_prof.append("=======================\n");
            area_disc_sem_prof.append(d.getNome()+"\n");
            area_disc_sem_prof.append(d.getCodigo()+"\n");
            
        }
        
        
        
    }

    private ResultCSP1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area_prof_sem_disc = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        area_disc_sem_prof = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        area_sucesso = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btn_refazer = new javax.swing.JButton();
        btn_iniciar_alocacao = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        horario_fisica = new javax.swing.JComboBox<>();
        horario_calculo = new javax.swing.JComboBox<>();

        jLabel1.setText("jLabel1");

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel2.setText("Resultado alocação de disciplinas para os professores");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        area_prof_sem_disc.setColumns(20);
        area_prof_sem_disc.setRows(5);
        jScrollPane1.setViewportView(area_prof_sem_disc);

        jLabel3.setText("Professores sem disciplinas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        area_disc_sem_prof.setColumns(20);
        area_disc_sem_prof.setRows(5);
        jScrollPane2.setViewportView(area_disc_sem_prof);

        jLabel4.setText("Disciplinas sem professores");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        area_sucesso.setColumns(20);
        area_sucesso.setRows(5);
        jScrollPane4.setViewportView(area_sucesso);

        jLabel5.setText("Professores e disciplinas alocados");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_refazer.setText("Refazer alocação de Disciplinas aos Professores");
        btn_refazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refazerActionPerformed(evt);
            }
        });

        btn_iniciar_alocacao.setText("Iniciar alocação de horários");
        btn_iniciar_alocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciar_alocacaoActionPerformed(evt);
            }
        });

        jLabel6.setText("* A alocação será feita considerando apenas os professores");

        jLabel7.setText("que tiveram disciplinas alocadas.");

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        jLabel8.setText("FISI0262");

        jLabel9.setText("Selecione o horário das disciplinas de outros departamentos:");

        jLabel10.setText("MAT0153");

        horario_fisica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        horario_calculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(73, 73, 73))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(btn_refazer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btn_iniciar_alocacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btn_cancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(horario_fisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(31, 31, 31)
                                        .addComponent(horario_calculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel9))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(77, 77, 77))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(horario_fisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(horario_calculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_refazer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(btn_iniciar_alocacao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refazerActionPerformed
        // TODO add your handling code here:
        this.dispose();
        try {
            new ConfigOferta().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(ResultCSP1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_refazerActionPerformed

    private void btn_iniciar_alocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciar_alocacaoActionPerformed
        // TODO add your handling code here:
        
        if(horario_fisica.getSelectedItem().equals(horario_calculo.getSelectedItem())){
            JOptionPane.showMessageDialog(this.rootPane, "Disciplinas FISI0262 e MAT0153 devem ter horarios distintos!");
            
        }else{            
            String[] aulas_fisica;
            aulas_fisica = horario_fisica.getModel().getElementAt(horario_fisica.getSelectedIndex()).split(" e ");
            
            String[] aulas_calculo;
            aulas_calculo = horario_calculo.getModel().getElementAt(horario_calculo.getSelectedIndex()).split(" e ");
            
            boolean choque = false;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if(aulas_fisica[i].equals(aulas_calculo[j])){
                        choque = true;
                    }
                }
            }
            
            if(choque){
                JOptionPane.showMessageDialog(this.rootPane, "Os horários de FISI0262 e MAT0153 não devem chocar!");
                
            }else{                
                ArrayList<Turma> turmas_oferta = new ArrayList<Turma>();
                for(int i=0; i<professores_oferta.size(); i++){
                    for (int j = 0; j < professores_oferta.get(i).lecionadas.size(); j++) {
                        if(professores_oferta.get(i).lecionadas.get(j).charAt(0)=='C'){
                            try {
                                turmas_oferta.add(new Turma(Disciplina.retornaDisciplina(professores_oferta.get(i).lecionadas.get(j)),professores_oferta.get(i) ));
                            } catch (IOException ex) {
                                Logger.getLogger(ResultCSP1.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }                
                }      

                TurmaHorario csp2 = null; 

                FlexibleBacktrackingSolver strategy = new FlexibleBacktrackingSolver<Turma, Horario>();
                Assignment<Turma, Horario> resultado = null;
                Optional<Assignment<Turma, Horario>> solucao; 


                try {
                    csp2 = new TurmaHorario(turmas_oferta, aulas_fisica, aulas_calculo);
                } catch (IOException ex) {
                    Logger.getLogger(ResultCSP1.class.getName()).log(Level.SEVERE, null, ex);
                }

                solucao = strategy.solve(csp2);


                try{
                    resultado = solucao.get();               



                }catch(java.util.NoSuchElementException e){

                    System.out.println("Não foi possível alocar");

                }   

                Horario aux; 
                String horario; 
                for (int i = 0; i < turmas_oferta.size() ; i++) {
                    aux = resultado.getValue(turmas_oferta.get(i));
                    horario = aux.aulas[0]+" "+aux.aulas[1]+" "+aux.aulas[2];
                    turmas_oferta.get(i).horario = horario;


                }

                for (int i = 0; i < professores_oferta.size(); i++) {
                    for (int j = 0; j < turmas_oferta.size(); j++) {
                        if(professores_oferta.get(i).getNome().equals(turmas_oferta.get(j).professor.nome)){
                            professores_oferta.get(i).setCreditos_lecionados(turmas_oferta.get(j).professor.getCreditos_lecionados());
                        }
                    }
                }


                this.dispose();

                try {
                    new ResultadoCSP2(professores_oferta, disciplinas_oferta, turmas_oferta, disc_nao_alocadas, aulas_fisica, aulas_calculo).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ResultCSP1.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        
    }//GEN-LAST:event_btn_iniciar_alocacaoActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        try {
            new Inicio().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(ResultCSP1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_cancelarActionPerformed

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
            java.util.logging.Logger.getLogger(ResultCSP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultCSP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultCSP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultCSP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultCSP1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_disc_sem_prof;
    private javax.swing.JTextArea area_prof_sem_disc;
    private javax.swing.JTextArea area_sucesso;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_iniciar_alocacao;
    private javax.swing.JButton btn_refazer;
    private javax.swing.JComboBox<String> horario_calculo;
    private javax.swing.JComboBox<String> horario_fisica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}
