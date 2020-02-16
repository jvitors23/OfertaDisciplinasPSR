
package main.CSPturmaToHorario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main.Disciplina;
import main.Turma;
import main.aima.Assignment;
import main.aima.Constraint;

/**
 *
 * @author jvss2
 */
public class ConstraintTurnoTrabalhoProfessor implements Constraint<Turma, Horario>{
    
    private Turma var1;    
    private List<Turma> scope;
    

    public ConstraintTurnoTrabalhoProfessor(Turma var1) {
            this.var1 = var1;            
            scope = new ArrayList<>(1);
            scope.add(var1);
    }

    @Override
    public List<Turma> getScope() {
            return scope;
    }

    @Override
    public boolean isSatisfiedWith(Assignment<Turma, Horario> assignment) {
        
        Horario value = assignment.getValue(var1);
               
        char turno = value.aulas[0].charAt(1); 
       
        boolean valid = false; 
        if(turno=='M' && var1.professor.isMatutino()){
            valid = true;
        }
        
        if(turno=='T'&& var1.professor.isVespertino()){
            valid = true;
        }
        
        if(turno=='N' && var1.professor.isNoturno()){
            valid = true;
        }
        
        return valid;     
        
    }
    
}
