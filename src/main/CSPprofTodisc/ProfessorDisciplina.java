package main.CSPprofTodisc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main.Disciplina;
import main.Professor;
import main.aima.*;

/*
Nosso problema foi dividido em dois CSP's onde o primeiro aloca os professores a uma disciplina, 
essa classe é a definição desse CSP. 

 - As variáveis desse problema são os professores onde o nome de cada variável é a matrícula do professor.

 - O domínio das variáveis são as disciplinas que serão ofertadas no semestre e algumas disciplinas extra 
genéricas "A definir" para professores que não conseguirem ter disciplinas alocadas para eles.

 - As restrições consideradas para esse primeiro problema foram: 
    - ConstraintTurno: é a constraint que o professor só pode trbalhar no seu turno de trabalho.
É necessária pois as disciplinas obrigatórias do semestre são lecionadas someente no turno vespertino,
desse modo o professor alocado pra essas disciplinas deve trabalhar a tarde. 
    - ConstraintProfsDiferentes: Como cada disciplina só terá uma turma, essa restrição é para inpedir que
dois professores sejam alocados pra mesma disciplina. 
    - ConstraintCreditosLecionados: Serve para limitar os créditos lecionados por um professor a 12. 
    - ConstraintPreferencia: Aloca as disciplinas apenas se esta for preferencia do professor, caso 
nenhuma disciplina ainda não alocada a algum professor, não esteja entre as preferencias de um professor 
sem uma disciplina, este professor ficará com sua disciplina a definir. 
*/
public class ProfessorDisciplina extends CSP<Professor, String>{
    public ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();;
    public List<Professor> professores = new ArrayList<Professor>();
    public ArrayList<String> disc_cods = new ArrayList<String>();

    public ProfessorDisciplina(ArrayList<Disciplina> disciplinas, List<Professor> professores) throws IOException {
        super();
        this.disciplinas = disciplinas;
        this.professores = professores;
        
        //adição das variáveis ao problema
        for(int i = 0; i<professores.size();i++){
            this.addVariable(professores.get(i));            
        }
        
        for(int i = 0; i<disciplinas.size();i++){
            disc_cods.add(disciplinas.get(i).getCodigo());
        }
        //criação do domínio
        Domain<String> discs_oferta = new Domain<>(disc_cods);
        
        //definição do domínio para cada variável
        for (Professor var : getVariables())
            setDomain(var, discs_oferta); 
        
        List<Professor> vars;
        vars = getVariables();        
        
        //adicionando constraint de dois professores não podem dar a mesma disciplina 
        //pois uma disciplina só terá uma turma
        for(int i=0; i<vars.size(); i++){
            for(int j=0; j<vars.size(); j++){
                if(!vars.get(i).getName().equals(vars.get(j).getName())){
                    addConstraint(new ConstraintProfsDiferentes(vars.get(i), vars.get(j)));     
                    
                }
            }
        }
        
        //adição do restante das constraints
        for(int i=0; i<vars.size(); i++){
            addConstraint(new ConstraintTurno(vars.get(i)));
            addConstraint(new ConstraintPreferencia(vars.get(i)));
            addConstraint(new ConstraintCreditosLecionados(vars.get(i)));
        } 
        
    }
    
    
    
    
}
