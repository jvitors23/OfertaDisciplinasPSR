package main;

import java.util.ArrayList;

public class Professor {
    public String nome;
    public String matricula;
    public ArrayList<String> preferencias; 
    boolean matutino;
    boolean vespertino;
    boolean noturno;
    ArrayList<String> turnoTrabalho;

    public Professor(String nome, String matricula, boolean matutino, boolean vespertino, boolean noturno, ArrayList<String> preferencias) {
        this.nome = nome;
        this.matricula = matricula;
        this.matutino = matutino;
        this.vespertino = vespertino; 
        this.noturno = noturno; 
        this.preferencias = preferencias;
    }
    
    public Professor(){
    
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

  

    public ArrayList<String> getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(ArrayList<String> preferencias) {
        this.preferencias = preferencias;
    }

    public boolean isMatutino() {
        return matutino;
    }

    public void setMatutino(boolean matutino) {
        this.matutino = matutino;
    }

    public boolean isVespertino() {
        return vespertino;
    }

    public void setVespertino(boolean vespertino) {
        this.vespertino = vespertino;
    }

    public boolean isNoturno() {
        return noturno;
    }

    public void setNoturno(boolean noturno) {
        this.noturno = noturno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public ArrayList<String> getTurnoTrabalho() {
        return turnoTrabalho;
    }

    public void setTurnoTrabalho(ArrayList<String> turnoTrabalho) {
        this.turnoTrabalho = turnoTrabalho;
    }
    
    
    
    
    
    
}
