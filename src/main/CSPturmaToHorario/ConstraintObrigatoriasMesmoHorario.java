/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ConstraintObrigatoriasMesmoHorario implements Constraint<Turma, Horario>{    
    
    private Turma var1;
    private Turma var2;
    private List<Turma> scope;
    private ArrayList<Disciplina> disciplinas_semestre;

    public ConstraintObrigatoriasMesmoHorario(Turma var1, Turma var2) throws IOException {
            this.var1 = var1;
            this.var2 = var2;
            scope = new ArrayList<>(2);
            scope.add(var1);
            scope.add(var2);
            this.disciplinas_semestre = Disciplina.disciplinasSemestre(3);
    }

    @Override
    public List<Turma> getScope() {
            return scope;
    }

    @Override
    public boolean isSatisfiedWith(Assignment<Turma, Horario> assignment) {
        Horario value1 = assignment.getValue(var1);   
        Horario value2 = assignment.getValue(var2); 
        
        boolean achou1 = false;  
        for(int i=0; i<this.disciplinas_semestre.size();i++){
            if(var1.disciplina.getCodigo().equals(this.disciplinas_semestre.get(i).getCodigo())){
                achou1 = true; 
            }            
        }
        
        boolean achou2 = false;  
        for(int i=0; i<this.disciplinas_semestre.size();i++){
            if(var2.disciplina.getCodigo().equals(this.disciplinas_semestre.get(i).getCodigo())){
                achou2 = true; 
            }            
        }
        if(achou1 && achou2){
            
            int tam1 = var1.disciplina.creditos/2;
            int tam2 = var2.disciplina.creditos/2; 

            boolean choque = false;           
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
        //uma ou outra ou as duas não são obrigatórias       
        }else{
            return true; 
        }       
    }    
}
