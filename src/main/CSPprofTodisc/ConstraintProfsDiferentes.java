package main.CSPprofTodisc;

import java.util.List;
import java.util.ArrayList;
import main.Professor;
import main.aima.*;
/**
 *
 * @author jvss2
 */
public class ConstraintProfsDiferentes implements Constraint<Professor, String> {

    private Professor var1;
    private Professor var2;
    private List<Professor> scope;

    public ConstraintProfsDiferentes(Professor var1, Professor var2) {
            this.var1 = var1;
            this.var2 = var2;
            scope = new ArrayList<>(2);
            scope.add(var1);
            scope.add(var2);
    }

    @Override
    public List<Professor> getScope() {
            return scope;
    }

    @Override
    public boolean isSatisfiedWith(Assignment<Professor, String> assignment) {
            String value1 = assignment.getValue(var1);
            if(value1 == null || !value1.equals(assignment.getValue(var2))){
                return true;
            }else{
                if(value1.equals("a_definir" + var1.getMatricula()))
                    return true; 
                return false;
            }
            
    }
    
}
