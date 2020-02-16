/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.CSPturmaToHorario;

import java.util.ArrayList;

/**
 *
 * @author helis
 */
public class Horario {
    String aula1, aula2, aula3;

    public Horario(String aula1, String aula2, String aula3) {
        this.aula1 = aula1;
        this.aula2 = aula2;
        this.aula3 = aula3;
    }
    
    
    public ArrayList retornaDominio(int numCreditos, String[] fisica, String[] calculo){
        ArrayList<Horario> domain = new ArrayList<Horario>();
        
        if(numCreditos == 2 ){
            domain.add(new Horario("2M12","",""));
            domain.add(new Horario("2M34","",""));
            domain.add(new Horario("2M56","",""));
            domain.add(new Horario("3M12","",""));
            domain.add(new Horario("3M34","",""));
            domain.add(new Horario("3M56","",""));
            domain.add(new Horario("4M12","",""));
            domain.add(new Horario("4M34","",""));
            domain.add(new Horario("4M56","",""));
            domain.add(new Horario("5M12","",""));
            domain.add(new Horario("5M34","",""));
            domain.add(new Horario("5M56","",""));
            domain.add(new Horario("6M12","",""));
            domain.add(new Horario("6M34","",""));
            domain.add(new Horario("6M56","",""));
            
            domain.add(new Horario("2T12","",""));
            domain.add(new Horario("2T34","",""));
            domain.add(new Horario("2T56","",""));
            domain.add(new Horario("3T12","",""));
            domain.add(new Horario("3T34","",""));
            domain.add(new Horario("3T56","",""));
            domain.add(new Horario("4T12","",""));
            domain.add(new Horario("4T34","",""));
            domain.add(new Horario("4T56","",""));
            domain.add(new Horario("5T12","",""));
            domain.add(new Horario("5T34","",""));
            domain.add(new Horario("5T56","",""));
            domain.add(new Horario("6T12","",""));
            domain.add(new Horario("6T34","",""));
            domain.add(new Horario("6T56","",""));
            
            domain.add(new Horario("2N12","",""));
            domain.add(new Horario("2N34","",""));
            domain.add(new Horario("3N12","",""));
            domain.add(new Horario("3N34","",""));
            domain.add(new Horario("4N12","",""));
            domain.add(new Horario("4N34","",""));
            domain.add(new Horario("5N12","",""));
            domain.add(new Horario("5N34","",""));
            domain.add(new Horario("6N12","",""));
            domain.add(new Horario("6N34","",""));
        }else{
            if(numCreditos == 4){
                //manha dois dias diferentes
                domain.add(new Horario("2M12","4M12",""));
                domain.add(new Horario("2M34","4M34",""));
                domain.add(new Horario("2M56","4M56",""));
                domain.add(new Horario("3M12","5M12",""));
                domain.add(new Horario("3M34","5M34",""));
                domain.add(new Horario("3M56","5M56",""));
                domain.add(new Horario("4M12","6M12",""));
                domain.add(new Horario("4M34","6M34",""));
                domain.add(new Horario("4M56","6M56",""));
                //manha mesmo dia
                domain.add(new Horario("2M12","2M34",""));
                domain.add(new Horario("2M34","2M56",""));
                domain.add(new Horario("3M12","3M34",""));
                domain.add(new Horario("3M34","5M56",""));
                domain.add(new Horario("4M12","4M34",""));
                domain.add(new Horario("4M34","4M56",""));
                domain.add(new Horario("5M12","5M34",""));
                domain.add(new Horario("5M34","5M56",""));
                domain.add(new Horario("6M12","6M34",""));
                domain.add(new Horario("6M34","6M56",""));
                //tarde dois dias diferentes
                domain.add(new Horario("2T12","4T12",""));
                domain.add(new Horario("2T34","4T34",""));
                domain.add(new Horario("2T56","4T56",""));
                domain.add(new Horario("3T12","5T12",""));
                domain.add(new Horario("3T34","5T34",""));
                domain.add(new Horario("3T56","5T56",""));
                domain.add(new Horario("4T12","6T12",""));
                domain.add(new Horario("4T34","6T34",""));
                domain.add(new Horario("4T56","6T56",""));
                //tarde mesmo dia
                domain.add(new Horario("2T12","2T34",""));
                domain.add(new Horario("2T34","2T56",""));
                domain.add(new Horario("3T12","3T34",""));
                domain.add(new Horario("3T34","5T56",""));
                domain.add(new Horario("4T12","4T34",""));
                domain.add(new Horario("4T34","4T56",""));
                domain.add(new Horario("5T12","5T34",""));
                domain.add(new Horario("5T34","5T56",""));
                domain.add(new Horario("6T12","6T34",""));
                domain.add(new Horario("6T34","6T56",""));
                //noite dois dias diferentes
                domain.add(new Horario("2N12","4N12",""));
                domain.add(new Horario("2N34","4N34",""));
                domain.add(new Horario("2N56","4N56",""));
                domain.add(new Horario("3N12","5N12",""));
                domain.add(new Horario("3N34","5N34",""));
                domain.add(new Horario("3N56","5N56",""));
                domain.add(new Horario("4N12","6N12",""));
                domain.add(new Horario("4N34","6N34",""));
                domain.add(new Horario("4N56","6N56",""));
                //noite mesmo dia
                domain.add(new Horario("2N12","2N34",""));
                domain.add(new Horario("3N12","3N34",""));
                domain.add(new Horario("4N12","4N34",""));
                domain.add(new Horario("5N12","5N34",""));
                domain.add(new Horario("6N12","6N34",""));
             
            }else{
                if(numCreditos == 6){
                    domain.add(new Horario("2M12","4M12","6M12"));
                    domain.add(new Horario("2M34","4M34","6M34"));
                    domain.add(new Horario("2M56","4M56","6M56"));
                    domain.add(new Horario("3M12","5M12","6M12"));
                    domain.add(new Horario("3M34","5M34","6M34"));
                    domain.add(new Horario("3M56","5M56","6M56"));
                    
                    domain.add(new Horario("2T12","4T12","6T12"));
                    domain.add(new Horario("2T34","4T34","6T34"));
                    domain.add(new Horario("2T56","4T56","6T56"));
                    domain.add(new Horario("3T12","5T12","6T12"));
                    domain.add(new Horario("3T34","5T34","6T34"));
                    domain.add(new Horario("3T56","5T56","6T56"));
                    
                    domain.add(new Horario("2N12","4N12","6N12"));
                    domain.add(new Horario("2N34","4N34","6N34"));
                    domain.add(new Horario("3N12","5N12","6N12"));
                    domain.add(new Horario("3N34","5N34","6N34"));
                    
                  
                }
            }
        }
        
        if(numCreditos == 4){
            domain.remove(new Horario(calculo[0],calculo[1], ""));
            domain.remove(new Horario(fisica[0],fisica[1], ""));
        }
        
        return domain;
    }
    
}
