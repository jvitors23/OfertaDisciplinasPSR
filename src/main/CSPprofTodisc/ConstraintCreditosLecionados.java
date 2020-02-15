
package main.CSPprofTodisc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Disciplina;
import main.Professor;
import main.aima.Assignment;
import main.aima.Constraint;

/**
 *
 * @author jvss2
 */
public class ConstraintCreditosLecionados implements Constraint<Professor, String> {

    private Professor var1;
    private List<Professor> scope;
   
    
    public ConstraintCreditosLecionados(Professor var1){
        this.var1 = var1;        
        scope = new ArrayList<>(1);
        scope.add(var1);       
    }
    
    @Override
    public List<Professor> getScope() {
        return scope; 
        
    }

    @Override
    public boolean isSatisfiedWith(Assignment<Professor, String> assignment) {
        String atribuida = assignment.getValue(var1);
        int creditos_disc = 0;
        try {
            creditos_disc = Disciplina.retornaCreditos(atribuida);
        } catch (IOException ex) {
            Logger.getLogger(ConstraintCreditosLecionados.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        if(var1.getCreditos_lecionados()+creditos_disc>12)
            return false;
        else{
            var1.setCreditos_lecionados(var1.getCreditos_lecionados()+creditos_disc);
            return true;
        }               
       
       
             
    }   

    
}
