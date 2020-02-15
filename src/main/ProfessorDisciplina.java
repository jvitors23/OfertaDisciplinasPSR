package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDisciplina extends CSP<Professor, String>{
    public ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();;
    public List<Professor> professores = new ArrayList<Professor>();
    public ArrayList<String> disc_cods = new ArrayList<String>();

    public ProfessorDisciplina(ArrayList<Disciplina> disciplinas, List<Professor> professores) throws IOException {
        super();
        this.disciplinas = disciplinas;
        this.professores = professores;
                
        for(int i = 0; i<professores.size();i++){
            this.addVariable(professores.get(i));            
        }
        
        for(int i = 0; i<disciplinas.size();i++){
            disc_cods.add(disciplinas.get(i).getCodigo());
        }
        Domain<String> discs_oferta = new Domain<>(disc_cods);
        
        for (Professor var : getVariables())
            setDomain(var, discs_oferta); 
        
        List<Professor> vars;
        vars = getVariables();        
        
        //adicionando constraint de dois professores não podem dar a mesma disciplina 
        //pois uma disciplina só terá uma turma
        for(int i=0; i<vars.size(); i++){
            for(int j=0; j<vars.size(); j++){
                if(!vars.get(i).getName().equals(vars.get(j).getName())){
                    addConstraint(new NotEqualsConstraint<>(vars.get(i), vars.get(j)));     
                    
                }
            }
        }
        
        for(int i=0; i<vars.size(); i++){
            addConstraint(new ConstraintTurno(vars.get(i)));
        }
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
}
