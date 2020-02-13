package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Professor {
    public String nome;
    public String matricula;
    public ArrayList<String> preferencias; 
    boolean matutino;
    boolean vespertino;
    boolean noturno;

    public Professor(String nome, String matricula, boolean matutino, boolean vespertino, boolean noturno, ArrayList<String> preferencias) {
        this.nome = nome;
        this.matricula = matricula;
        this.matutino = matutino;
        this.vespertino = vespertino; 
        this.noturno = noturno; 
        this.preferencias = preferencias;
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
        ArrayList<String> pref = new ArrayList<String>();
        ArrayList<Professor> professores = new ArrayList();
        BufferedReader buffRead = new BufferedReader(new FileReader("professor.txt"));
        String linha = "";
        while (true) {
           
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
    
    
    
    
    
    
}
