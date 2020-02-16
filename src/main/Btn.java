
package main;

import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author jvss2
 */
public class Btn extends JTextArea{

    String horario; 
    
    public ArrayList<Turma> turmas_horario = new ArrayList<Turma>();    

    public Btn(String horario) {
        
        this.horario = horario; 
        this.setLayout(null);
        this.setEditable(false);
        
    }
    
    public void setTurmas(String cod, String prof) {
        this.append(cod+"-"+prof+" \n");
        this.setToolTipText(this.getText());
    }

    public ArrayList<Turma> getTurmas_horario() {
        return turmas_horario;
    }

    public void setTurmas_horario(ArrayList<Turma> turmas_horario) {
        this.turmas_horario = turmas_horario;
    }
    
}
