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
public class ConstraintObrigatoriasTurnoVespertino implements Constraint<Turma, Horario> {
    
    private Turma var1;    
    private List<Turma> scope;
    private ArrayList<Disciplina> disciplinas_semestre;

    public ConstraintObrigatoriasTurnoVespertino(Turma var1) throws IOException {
            this.var1 = var1;            
            scope = new ArrayList<>(1);
            scope.add(var1);            
            this.disciplinas_semestre = Disciplina.disciplinasSemestre(3);
            
           
        
    }

    @Override
    public List<Turma> getScope() {
            return scope;
    }

    @Override
    public boolean isSatisfiedWith(Assignment<Turma, Horario> assignment) {
        
        Horario value = assignment.getValue(var1);
        
        boolean achou = false;  
        for(int i=0; i<this.disciplinas_semestre.size();i++){
            if(var1.disciplina.getCodigo().equals(this.disciplinas_semestre.get(i).getCodigo())){
                achou = true; 
            }            
        }
        char turno = value.aulas[0].charAt(1); 
             
        if(achou){     
            if(turno=='M' || turno=='N'){
                return false;
            }else{                
                return true;                                
            }            
        }else{
            return true; 
        }       
        
       
        
    }
}
