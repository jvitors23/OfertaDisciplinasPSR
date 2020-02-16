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
public class ConstraintHorarioOutrosDeptos implements Constraint<Turma, Horario>{
    private Turma var1;    
    private List<Turma> scope;
    private ArrayList<Disciplina> disciplinas_semestre;
    private String[] calculo;
    private String[] fisica;

    public ConstraintHorarioOutrosDeptos(Turma var1, String[] calculo, String[] fisica) throws IOException {
            this.var1 = var1;            
            scope = new ArrayList<>(1);
            scope.add(var1);            
            this.disciplinas_semestre = Disciplina.disciplinasSemestre(3);
            this.calculo = calculo;
            this.fisica = fisica;           
    }

    @Override
    public List<Turma> getScope() {
            return scope;
    }

    @Override
    public boolean isSatisfiedWith(Assignment<Turma, Horario> assignment) {
        
        Horario value = assignment.getValue(var1);
        int tam = var1.disciplina.creditos/2;
        
        boolean achou = false;  
        for(int i=0; i<this.disciplinas_semestre.size();i++){
            if(var1.disciplina.getCodigo().equals(this.disciplinas_semestre.get(i).getCodigo())){
                achou = true; 
            }            
        }
        boolean choque = false;
        if(achou){   
            for (int i = 0; i < tam; i++) {
                for (int j = 0; j < 2; j++) {
                    if(value!=null && (value.aulas[i].equals(calculo[j]) || value.aulas[i].equals(fisica[j])) ){
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
