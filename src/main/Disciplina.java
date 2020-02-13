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

public class Disciplina {
    public String nome;
    public String codigo;
    public int creditos;
    public boolean laboratorio;
    public int semestreObrigatorio;

    public Disciplina(int semestreObrigatorio, String nome, String codigo, int creditos, boolean laboratorio) {
        this.semestreObrigatorio = semestreObrigatorio;
        this.nome = nome;
        this.codigo = codigo;
        this.creditos = creditos;
        this.laboratorio = laboratorio;       
    }
    
    public Disciplina(int semestreObrigatorio){
        this.semestreObrigatorio = semestreObrigatorio;
    }
   
    
    public static Disciplina buscaDisciplina(String codigo) throws FileNotFoundException, IOException{
        String[] disciplina = new String[5];
        Disciplina aux = null;
        BufferedReader buffRead = new BufferedReader(new FileReader("disciplinas.txt"));
        String linha = "";
        while (true) {
            try {
                linha = buffRead.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Disciplina.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (linha != null) {
                disciplina = linha.split(";");
              
                if(disciplina[1].equals(codigo)){
                    aux = new Disciplina(Integer.parseInt(disciplina[0]), disciplina[2], disciplina[1], Integer.parseInt(disciplina[3]), Boolean.parseBoolean(disciplina[4]));
                }else{
             
                }
          
            } else
                break;
        }
        buffRead.close();
        return aux;
    }
    
    public void cadastrarDisciplina(Disciplina disciplina) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("disciplinas.txt", true));
        buffWrite.append(Integer.toString(disciplina.semestreObrigatorio)+disciplina.nome + ";" + disciplina.codigo + ";" + Integer.toString(disciplina.creditos) 
                + ";" + Boolean.toString(disciplina.laboratorio));
        buffWrite.newLine();
        buffWrite.close();
    }
    
    public static ArrayList<Disciplina> disciplinasSemestre(int semestre) throws IOException{
        String[] disciplina = new String[5];
        ArrayList<Disciplina> disciplinas = new ArrayList();
        BufferedReader buffRead = new BufferedReader(new FileReader("disciplinas.txt"));
        String linha = "";
        while (true) {
            try {
                linha = buffRead.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Disciplina.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (linha != null) {
                disciplina = linha.split(";");
              
                if(Integer.parseInt(disciplina[0]) == semestre){
                    Disciplina aux = new Disciplina(Integer.parseInt(disciplina[0]), disciplina[2], disciplina[1], Integer.parseInt(disciplina[3]), Boolean.parseBoolean(disciplina[4]));
                    disciplinas.add(aux);
                }else{
             
                }
          
            } else
                break;
        }
        buffRead.close();
        return disciplinas;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "nome=" + nome + ", codigo=" + codigo + ", creditos=" + creditos + ", laboratorio=" + laboratorio + ", semestreObrigatorio=" + semestreObrigatorio + '}';
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

    public boolean isLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(boolean laboratorio) {
        this.laboratorio = laboratorio;
    }

    public int getSemestreObrigatorio() {
        return semestreObrigatorio;
    }

    public void setSemestreObrigatorio(int semestreObrigatorio) {
        this.semestreObrigatorio = semestreObrigatorio;
    }
    
}
