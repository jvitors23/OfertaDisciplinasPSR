package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Oferta {
    public ArrayList<Disciplina> disciplinas;
    public Map<String,ArrayList<Turma>> grade = new HashMap<String,ArrayList<Turma>> ();
    public ArrayList<Professor> professores;
    public ArrayList<Turma> turmas;
    public int numeroSemestre;
    
    public Oferta(int num) throws IOException{
        this.numeroSemestre = num;
        switch(num){
            case 1:
                this.disciplinas = Disciplina.disciplinasSemestre(1);                
                break;
            case 2:
                this.disciplinas = Disciplina.disciplinasSemestre(2);
                break;
            case 3:
                this.disciplinas = Disciplina.disciplinasSemestre(3);
                break;
            case 4:
                this.disciplinas = Disciplina.disciplinasSemestre(4);
                break;
            case 5:
                this.disciplinas = Disciplina.disciplinasSemestre(5);
                break;
            case 6:
                this.disciplinas = Disciplina.disciplinasSemestre(6);
                break;
            case 7:
                this.disciplinas = Disciplina.disciplinasSemestre(7);
                break;
            case 8:
                this.disciplinas = Disciplina.disciplinasSemestre(8);
                break;
            case 9:
                this.disciplinas = Disciplina.disciplinasSemestre(9);
                break;
            case 10:
                this.disciplinas = Disciplina.disciplinasSemestre(10);
                break;
        }
    }
    
    public void addDisciplina(Disciplina disciplina){
        this.disciplinas.add(disciplina);
    }
    
    public void removerDisciplina(Disciplina disciplina){
        this.disciplinas.remove(disciplina);        
    }
}
