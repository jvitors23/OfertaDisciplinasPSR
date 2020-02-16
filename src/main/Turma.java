package main;

import main.aima.*;

public class Turma extends Variable{
    public Disciplina disciplina; 
    public Professor professor;
     public String horario; 

    public Turma(Disciplina d, Professor p) {
        super(d.getCodigo());
        this.disciplina = d;
        this.professor = p;
        this.horario = "";
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Turma{" + "disciplina=" + disciplina + ", professor=" + professor + ", horario=" + horario + '}';
    }
    
    
    
}
