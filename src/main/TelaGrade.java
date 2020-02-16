package main;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.Border;

/**
 *
 * @author jvss2
 */
public class TelaGrade extends JFrame{
    
    public Btn[][] grade;
    ArrayList<Turma> resultado_oferta;
    public TelaGrade(ArrayList<Turma> resultado_oferta) {
        this.resultado_oferta = resultado_oferta;
        grade = new Btn[8][5];
        
        this.setTitle("Grade Alocada");
        this.setSize(760, 590);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        
        JPanel telaGrade = new JPanel();
        telaGrade.setSize(760,590);
        telaGrade.setVisible(true);
        telaGrade.setLayout(null);
        
        JLabel segunda = new JLabel("Segunda");
        segunda.setBounds(95,28, 50, 50);
        telaGrade.add(segunda);
        
        JLabel terca = new JLabel("Terça");
        terca.setBounds(240, 28, 50, 50);
        telaGrade.add(terca);
        
        JLabel quarta = new JLabel("Quarta");
        quarta.setBounds(385, 28, 50, 50);
        telaGrade.add(quarta);
        
        JLabel quinta = new JLabel("Quinta");
        quinta.setBounds(385+145, 28, 50, 50);
        telaGrade.add(quinta);
        
        JLabel sexta = new JLabel("Sexta");
        sexta.setBounds(385+145+145, 28, 50, 50);
        telaGrade.add(sexta);
        
        JLabel m12 = new JLabel("M12");
        m12.setBounds(10,515,30,30);
        telaGrade.add(m12);
        
        JLabel m34 = new JLabel("M34");
        m34.setBounds(10,515-65,30,30);
        telaGrade.add(m34);
        
        JLabel m56 = new JLabel("M56");
        m56.setBounds(10,515-65-65,30,30);
        telaGrade.add(m56);
        
        JLabel T12 = new JLabel("T12");
        T12.setBounds(10,515-65-65-60,30,30);
        telaGrade.add(T12);
        
        JLabel T34 = new JLabel("T34");
        T34.setBounds(10,515-65-65-65-60,30,30);
        telaGrade.add(T34);
        
        JLabel T56 = new JLabel("T56");
        T56.setBounds(10,515-65-65-65-65-60,30,30);
        telaGrade.add(T56);
        
        JLabel N12 = new JLabel("N12");
        N12.setBounds(10,515-65-65-65-60-65-60,30,30);
        telaGrade.add(N12);
        
        JLabel N34 = new JLabel("N34");
        N34.setBounds(10,515-65-65-65-65-60-60-65,30,30);
        telaGrade.add(N34);
        
        
        JLabel titulo = new JLabel("Grade Alocada");
        titulo.setBounds(350,10,150,20);
        titulo.setFont(new Font(titulo.getName(), Font.BOLD, 14));
        telaGrade.add(titulo);
        
        
        
        
        
        
        grade[0][0] = new Btn("2N34");   
        grade[1][0] = new Btn("2N12"); 
        grade[2][0] = new Btn("2T56");
        grade[3][0] = new Btn("2T34");
        grade[4][0] = new Btn("2T12");
        grade[5][0] = new Btn("2M56");
        grade[6][0] = new Btn("2M34");
        grade[7][0] = new Btn("2M12");
        
        grade[0][1] = new Btn("3N34");   
        grade[1][1] = new Btn("3N12"); 
        grade[2][1] = new Btn("3T56");
        grade[3][1] = new Btn("3T34");
        grade[4][1] = new Btn("3T12");
        grade[5][1] = new Btn("3M56");
        grade[6][1] = new Btn("3M34");
        grade[7][1] = new Btn("3M12");
        
        grade[0][2] = new Btn("4N34");   
        grade[1][2] = new Btn("4N12"); 
        grade[2][2] = new Btn("4T56");
        grade[3][2] = new Btn("4T34");
        grade[4][2] = new Btn("4T12");
        grade[5][2] = new Btn("4M56");
        grade[6][2] = new Btn("4M34");
        grade[7][2] = new Btn("4M12");
        
        grade[0][3] = new Btn("5N34");   
        grade[1][3] = new Btn("5N12"); 
        grade[2][3] = new Btn("5T56");
        grade[3][3] = new Btn("5T34");
        grade[4][3] = new Btn("5T12");
        grade[5][3] = new Btn("5M56");
        grade[6][3] = new Btn("5M34");
        grade[7][3] = new Btn("5M12");
        
        grade[0][4] = new Btn("6N34");   
        grade[1][4] = new Btn("6N12"); 
        grade[2][4] = new Btn("6T56");
        grade[3][4] = new Btn("6T34");
        grade[4][4] = new Btn("6T12");
        grade[5][4] = new Btn("6M56");
        grade[6][4] = new Btn("6M34");
        grade[7][4] = new Btn("6M12"); 
        
        int height = 500/8;
        int width = 700/5; 
        
        int x=50;
        int y =0;  
        
        for (int i = 0; i < 8; i++) {
            y=y+height;            
            for (int j = 0; j < 5; j++) {
                grade[i][j].setBounds(x, y, width, height);
                grade[i][j].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                telaGrade.add(grade[i][j]);
                this.add(telaGrade);
                x=x+width;
            } 
            x=50;
        }
        
        for (int i = 0; i < resultado_oferta.size(); i++) {
            String[] horario = resultado_oferta.get(i).horario.split(" ");
            for (int j = 0; j < horario.length; j++) {
                String aula = horario[j];
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 5; l++) {
                        if(aula.equals(grade[k][l].horario)){
                            grade[k][l].setTurmas(resultado_oferta.get(i).disciplina.codigo,resultado_oferta.get(i).professor.nome.split(" ")[0] );
                            grade[k][l].turmas_horario.add(resultado_oferta.get(i));
                        }                     
                    }
                }
            }            
        }
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < grade[i][j].turmas_horario.size(); k++) {
                    if(grade[i][j].turmas_horario.get(k).disciplina.semestreObrigatorio==3){
                        grade[i][j].setBackground(Color.lightGray);
                        
                    }
                }
                
            }
        }
        
        
        
        
        
        
        
        
    }
    
    
    
}
