
package main.CSPturmaToHorario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main.CSPprofTodisc.ConstraintProfsDiferentes;
import main.Professor;
import main.Turma;
import main.aima.*;
/**
 *
 * @author jvss2
 */
public class TurmaHorario extends CSP<Turma, Horario>{
    public ArrayList<Turma> turmas_oferta = new ArrayList<Turma>();
   
    public TurmaHorario(ArrayList<Turma> turmas, String[] fisica, String[] calculo) throws IOException{
        super();
        this.turmas_oferta = turmas; 
        
        for(int i=0; i<turmas_oferta.size(); i++)
            this.addVariable(turmas_oferta.get(i));
        
        
        Domain<Horario> dominio2cr =  new Domain<>(Horario.retornaDominio(2));
        Domain<Horario> dominio4cr =  new Domain<>(Horario.retornaDominio(4));
        Domain<Horario> dominio6cr =  new Domain<>(Horario.retornaDominio(6));
                        
        
        //definição do domínio para cada variável
        for (Turma var : getVariables()){
            if(var.disciplina.creditos==2)
                setDomain(var, dominio2cr); 
            if(var.disciplina.creditos==4)
                setDomain(var, dominio4cr); 
            if(var.disciplina.creditos==6)
                setDomain(var, dominio6cr); 
        } 
        List<Turma> vars;
        vars = getVariables();   
        
        for(int i=0; i<vars.size(); i++){
            addConstraint(new ConstraintTurnoTrabalhoProfessor(vars.get(i)));
            addConstraint(new ConstraintObrigatoriasTurnoVespertino(vars.get(i)));
            addConstraint(new ConstraintHorarioOutrosDeptos(vars.get(i), calculo, fisica));
        }
        
        for(int i=0; i<vars.size(); i++){
            for(int j=0; j<vars.size(); j++){
                if(!vars.get(i).getName().equals(vars.get(j).getName())){
                    addConstraint(new ConstraintProfessorMesmoHorario(vars.get(i), vars.get(j)));
                    addConstraint(new ConstraintObrigatoriasMesmoHorario(vars.get(i), vars.get(j)));
                }
            }
        }
        
    }
    
    
}
