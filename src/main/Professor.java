package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.aima.*;

public class Professor extends Variable {
    public String nome;
    public String matricula;
    public ArrayList<String> preferencias; 
    public ArrayList<String> lecionadas;
    boolean matutino;
    boolean vespertino;
    boolean noturno;
    public int creditos_lecionados = 0;

    public ArrayList<String> getLecionadas() {
        return lecionadas;
    }

    public void setLecionadas(ArrayList<String> lecionadas) {
        this.lecionadas = lecionadas;
    }

    public int getCreditos_lecionados() {
        return creditos_lecionados;
    }

    public void setCreditos_lecionados(int creditos_lecionados) {
        this.creditos_lecionados = creditos_lecionados;
    }

    public Professor(String nome, String matricula, boolean matutino, boolean vespertino, boolean noturno, ArrayList<String> preferencias) {
        super(matricula);
        this.nome = nome;
        this.matricula = matricula;
        this.matutino = matutino;
        this.vespertino = vespertino; 
        this.noturno = noturno; 
        this.preferencias = preferencias;
        this.lecionadas = new ArrayList<String>();
        this.creditos_lecionados = 0; 
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
    
    
     public static ArrayList<Professor> retornaProfessores() throws IOException{
        String[] professor;
        
        ArrayList<Professor> professores = new ArrayList();
        BufferedReader buffRead;
        try {
            buffRead = new BufferedReader(new FileReader("professor.txt"));
        } catch (FileNotFoundException ex) {
            return null;
        }
        String linha = "";
        while (true) {
            ArrayList<String> pref = new ArrayList<String>();
            linha = buffRead.readLine();
            
            if (linha != null) {
                professor = linha.split(",");       
                
                boolean matutino, vespertino, noturno;
                matutino = vespertino = noturno = false;
                if(professor[2].equals("true"))
                    matutino = true;
                if(professor[3].equals("true"))
                    vespertino = true;
                if(professor[4].equals("true"))
                    noturno = true;
                
                for(int i = 5; i<professor.length; i++){
                    pref.add(professor[i]);
                }                
                
                Professor aux;       
                aux = new Professor(professor[1], professor[0], matutino, vespertino, noturno, pref);
                professores.add(aux);
            } else
                break;
        }
        buffRead.close();
        return professores;
    }

    @Override
    public String toString() {
        return "Professor{" + "nome=" + nome + ", matricula=" + matricula + ", preferencias=" + preferencias + ", lecionadas=" + lecionadas + ", matutino=" + matutino + ", vespertino=" + vespertino + ", noturno=" + noturno + ", creditos_lecionados=" + creditos_lecionados + '}';
    }
    
    
    
    
    
    
}
