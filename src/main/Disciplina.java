package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
                    Disciplina aux = new Disciplina(Integer.parseInt(disciplina[0]), disciplina[1], disciplina[2], Integer.parseInt(disciplina[3]), Boolean.parseBoolean(disciplina[4]));
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
    
}
