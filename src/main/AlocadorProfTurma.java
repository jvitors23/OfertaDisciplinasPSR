package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlocadorProfTurma {
    ArrayList<Disciplina> listaDisciplinaSemestre;
    ArrayList<Professor> listaProfessor = new ArrayList<Professor>();
    Professor professorObj = new Professor();
    ArrayList<String> turno;
    ArrayList<String> listaPreferencia;
    ArrayList<String> disciplinasAlocadas = new ArrayList<String>();
    Turma turma;
    Random r = new Random();
    
    public void preencheListaProfessor() throws FileNotFoundException, IOException{
        String[] professor;        
        BufferedReader buffRead = new BufferedReader(new FileReader("professor.txt"));
        String linha = "";
        ArrayList<String> preferencias = null; 
        while (true) {
            try {
                linha = buffRead.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Disciplina.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (linha != null) {
                professor = linha.split(",");              
                
                turno = new ArrayList<String>();
                
                if(professor[2].equals("true"))
                    turno.add("Matutino");
                if(professor[3].equals("true"))
                    turno.add("Vespertino");
                if(professor[4].equals("true"))
                    turno.add("Noturno");
                
                  
                professorObj.setNome(professor[1]);
                professorObj.setTurnoTrabalho(turno);
                
                listaPreferencia = new ArrayList<String>();
                
                for(int i=5; i<professor.length; i++){
                    listaPreferencia.add(professor[i]);                    
                }
                
                professorObj.setPreferencias(listaPreferencia);
                listaProfessor.add(professorObj);
                
            }else
                break;
        }
        buffRead.close(); 
    }
    
    public ArrayList<Turma> aloca(int semestre) throws IOException{
        ArrayList<Turma> alocacao = new ArrayList<Turma>();
        Professor professorAux = new Professor();
        listaDisciplinaSemestre = Disciplina.disciplinasSemestre(semestre);
        preencheListaProfessor();
        
        for(int i = 0; i < listaProfessor.size(); i++){
            professorAux = listaProfessor.get(i);
            System.out.println(professorAux);
            if(professorAux.getPreferencias().size() > 0){
                int preferenciaIndex = r.nextInt(professorAux.getPreferencias().size());
                System.out.println(professorAux.getPreferencias().get(preferenciaIndex));
                if(listaDisciplinaSemestre.contains(professorAux.getPreferencias().get(preferenciaIndex)) &&
                   !disciplinasAlocadas.contains(professorAux.getPreferencias().get(preferenciaIndex)))
                {
                   Turma turmaAux = new Turma();
                   turma.setDisciplina(Disciplina.buscaDisciplina(professorAux.getPreferencias().get(preferenciaIndex)));
                   turma.setProfessor(professorAux);
                    //turma.setHorario();
                   professorAux.getPreferencias().remove(preferenciaIndex);
                   disciplinasAlocadas.add(professorAux.getPreferencias().get(preferenciaIndex));
                   System.out.println(turma.disciplina.nome);
                   alocacao.add(turma);
                }else{
                   professorAux.getPreferencias().remove(preferenciaIndex);
                }
            }else{
                String disciplinaAux = listaDisciplinaSemestre.get(r.nextInt(listaDisciplinaSemestre.size())).getNome();
                if(!disciplinasAlocadas.contains(disciplinaAux)){
                   Turma turmaAux = new Turma();
                   turmaAux.setDisciplina(Disciplina.buscaDisciplina(disciplinaAux));
                   turmaAux.setProfessor(professorAux);
                   disciplinasAlocadas.add(disciplinaAux);
                   alocacao.add(turma);
                    System.out.println("bbbbbbbbbbb");
                }
            }
            
            if(i == listaProfessor.size() - 1 && disciplinasAlocadas.size() < listaDisciplinaSemestre.size()){
                i = 0;
                System.out.println("aaaaaaaaaaaaaaaaaa");
            }
            
        }      
        return alocacao;
    }
}
