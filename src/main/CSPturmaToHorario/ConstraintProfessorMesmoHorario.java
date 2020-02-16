
package main.CSPturmaToHorario;

import java.util.ArrayList;
import java.util.List;
import main.Professor;
import main.Turma;
import main.aima.Assignment;
import main.aima.Constraint;

/**
 *
 * @author jvss2
 */
public class ConstraintProfessorMesmoHorario implements Constraint<Turma, Horario>{

    private Turma var1;
    private Turma var2;
    private List<Turma> scope;

    public ConstraintProfessorMesmoHorario(Turma var1, Turma var2) {
            this.var1 = var1;
            this.var2 = var2;
            scope = new ArrayList<>(2);
            scope.add(var1);
            scope.add(var2);
    }

    @Override
    public List<Turma> getScope() {
            return scope;
    }

    @Override
    public boolean isSatisfiedWith(Assignment<Turma, Horario> assignment) {
        Horario value1 = assignment.getValue(var1);   
        Horario value2 = assignment.getValue(var2); 
        int tam1 = var1.disciplina.creditos/2;
        int tam2 = var2.disciplina.creditos/2; 
        
        boolean choque = false; 
        
        if(var1.professor.getMatricula().equals(var2.professor.getMatricula())){
            for (int i = 0; i < tam1; i++) {
                for (int j = 0; j < tam2; j++) {                    
                    if((value1!=null && value2!=null) && value1.aulas[i].equals(value2.aulas[j])){                        
                        choque = true; 
                    }
                       
                }
            }
         
            if(choque)
                return false;
            else
                return true;         
            
        }else{
            return true; 
        }
    }
    
}
