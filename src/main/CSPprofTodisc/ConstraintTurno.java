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
public class ConstraintTurno implements Constraint<Professor, String> {

    private Professor var1;
    private List<Professor> scope;
    private ArrayList<Disciplina> disciplinas_semestre;
    
    public ConstraintTurno(Professor var1) throws IOException {
        this.var1 = var1;
        this.disciplinas_semestre = Disciplina.disciplinasSemestre(3);
        scope = new ArrayList<>(1);
        scope.add(var1);       
    }
    
    @Override
    public List<Professor> getScope() {
        return scope; 
        
    }

    @Override
    public boolean isSatisfiedWith(Assignment<Professor, String> assignment) {
        String value = assignment.getValue(var1);
        boolean achou = false;  
        for(int i=0; i<this.disciplinas_semestre.size();i++){
            if(value.equals(this.disciplinas_semestre.get(i).getCodigo())){
                achou = true; 
            }            
        }        
        if(achou){
            if(var1.isVespertino() || value.equals("a_definir" + var1.getMatricula()))
                return true;
            else               
                return false;            
        }else{
            if((var1.isMatutino() || var1.isNoturno()) || value.equals("a_definir" + var1.getMatricula())){
                return true;
            }
            return false;  
        }
             
    }    
}
