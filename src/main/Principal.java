    package main;

import java.io.IOException;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) throws IOException{
       
        Inicio.main(args);
        
        ArrayList<Turma>  turmasAlocadas = new ArrayList<Turma>();
        AlocadorProfTurma alocador = new AlocadorProfTurma();
        turmasAlocadas = alocador.aloca(5);
        
        System.out.println(turmasAlocadas.size());
        Turma turma = new Turma();
        turma = turmasAlocadas.get(2);
        System.out.println(turma);

        
    }
}
