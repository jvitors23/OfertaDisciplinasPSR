package main.CSPprofTodisc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main.Disciplina;
import main.Professor;
import main.aima.*;

/**
 *
 * @author jvss2
 */
public class ConstraintPreferencia implements Constraint<Professor, String>{

    private Professor var1;
    private List<Professor> scope;
   
    
    public ConstraintPreferencia(Professor var1){
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
        boolean achou = false; 
        for(int i =0; i<var1.preferencias.size(); i++){
            if(var1.preferencias.get(i).equals(atribuida)){
                achou = true; 
                break; 
            }  
        }
        if(achou){
            return true; 
        }else{
            if(atribuida.equals("a_definir" + var1.getMatricula()))
                return true;
            return false;
        }
             
    }   
    
}
