package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Disciplina{
    
    public String nome;
    public String codigo;
    public int creditos; 
    public int semestreObrigatorio;
    
    public static int retornaCreditos(String cod) throws IOException {
        ArrayList<Disciplina> arquivo = retornaDisciplinas();
        for(int i=0; i<arquivo.size(); i++){
            if(arquivo.get(i).getCodigo().equals(cod))
                return arquivo.get(i).getCreditos();
        }
        return 0;       
    }

    public Disciplina(int semestreObrigatorio, String nome, String codigo, int creditos) {
        this.semestreObrigatorio = semestreObrigatorio;
        this.nome = nome;
        this.codigo = codigo;
        this.creditos = creditos;
              
    }
    
    public void cadastrarDisciplina(Disciplina disciplina) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("disciplinas.txt", true));
        buffWrite.append(Integer.toString(disciplina.semestreObrigatorio)+disciplina.nome + ";" + disciplina.codigo + ";" + Integer.toString(disciplina.creditos));
        buffWrite.newLine();
        buffWrite.close();
    }
    
    public static ArrayList<Disciplina> disciplinasSemestre(int semestre) throws IOException{
        ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
        ArrayList<Disciplina> disciplinas_cadastradas = retornaDisciplinas();        
        for(int i = 0; i < disciplinas_cadastradas.size(); i++){
            if(disciplinas_cadastradas.get(i).getSemestreObrigatorio() == semestre){
                disciplinas.add(disciplinas_cadastradas.get(i));
                
            }
        }        
        return disciplinas;
    }
    
    
    public static ArrayList<Disciplina> retornaDisciplinas(){
        String[] disciplina;
        ArrayList<Disciplina> disciplinas = new ArrayList();
        BufferedReader buffRead;
        try {
            buffRead = new BufferedReader(new FileReader("disciplinas.txt"));
        } catch (FileNotFoundException ex) {
            return null;
        }
        String linha = "";
        while (true) {
            try {
                linha = buffRead.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Disciplina.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (linha != null) {
                disciplina = linha.split(";");             
                Disciplina aux = new Disciplina(Integer.parseInt(disciplina[0]), disciplina[2], disciplina[1], Integer.parseInt(disciplina[3]));
                disciplinas.add(aux);                
          
            } else
                break;
        }
        try {
            buffRead.close();
        } catch (IOException ex) {
            Logger.getLogger(Disciplina.class.getName()).log(Level.SEVERE, null, ex);
        }
        return disciplinas;
    }
    
    public static Disciplina retornaDisciplina(String codigo) throws IOException{
        ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
        Disciplina disciplina = null;
        disciplinas = retornaDisciplinas();
        for(int i = 0; i < disciplinas.size(); i++){
            if(disciplinas.get(i).getCodigo().equals(codigo)){
                disciplina = disciplinas.get(i);
                break;
            }
        }        
        return disciplina;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "nome=" + nome + ", codigo=" + codigo + ", creditos=" + creditos + ", semestreObrigatorio=" + semestreObrigatorio + '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getSemestreObrigatorio() {
        return semestreObrigatorio;
    }

    public void setSemestreObrigatorio(int semestreObrigatorio) {
        this.semestreObrigatorio = semestreObrigatorio;
    }
    
}
