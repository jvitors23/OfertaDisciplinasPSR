package main;

import java.util.ArrayList;

public class Professor {
    public String nome;
    public int matricula;
    public String turno;
    public ArrayList<String> preferencias; 

    public Professor(String nome, int matricula, String turno, ArrayList<String> preferencias) {
        this.nome = nome;
        this.matricula = matricula;
        this.turno = turno;
        this.preferencias = preferencias;
    }    
    
    
    
}
