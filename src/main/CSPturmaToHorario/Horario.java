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
    public String[] aulas; 

    public Horario(String[] aulas) {
        this.aulas = aulas; 
    }
    
    
    public static ArrayList<Horario> retornaDominio(int numCreditos){
        ArrayList<Horario> domain = new ArrayList<Horario>();
        
        if(numCreditos == 2 ){
            domain.add(new Horario(new String[]{"2M12","",""}));
            domain.add(new Horario(new String[]{"2M34","",""}));
            domain.add(new Horario(new String[]{"2M56","",""}));
            domain.add(new Horario(new String[]{"3M12","",""}));
            domain.add(new Horario(new String[]{"3M34","",""}));
            domain.add(new Horario(new String[]{"3M56","",""}));
            domain.add(new Horario(new String[]{"4M12","",""}));
            domain.add(new Horario(new String[]{"4M34","",""}));
            domain.add(new Horario(new String[]{"4M56","",""}));
            domain.add(new Horario(new String[]{"5M12","",""}));
            domain.add(new Horario(new String[]{"5M34","",""}));
            domain.add(new Horario(new String[]{"5M56","",""}));
            domain.add(new Horario(new String[]{"6M12","",""}));
            domain.add(new Horario(new String[]{"6M34","",""}));
            domain.add(new Horario(new String[]{"6M56","",""}));
            
            domain.add(new Horario(new String[]{"2T12","",""}));
            domain.add(new Horario(new String[]{"2T34","",""}));
            domain.add(new Horario(new String[]{"2T56","",""}));
            domain.add(new Horario(new String[]{"3T12","",""}));
            domain.add(new Horario(new String[]{"3T34","",""}));
            domain.add(new Horario(new String[]{"3T56","",""}));
            domain.add(new Horario(new String[]{"4T12","",""}));
            domain.add(new Horario(new String[]{"4T34","",""}));
            domain.add(new Horario(new String[]{"4T56","",""}));
            domain.add(new Horario(new String[]{"5T12","",""}));
            domain.add(new Horario(new String[]{"5T34","",""}));
            domain.add(new Horario(new String[]{"5T56","",""}));
            domain.add(new Horario(new String[]{"6T12","",""}));
            domain.add(new Horario(new String[]{"6T34","",""}));
            domain.add(new Horario(new String[]{"6T56","",""}));
            
            domain.add(new Horario(new String[]{"2N12","",""}));
            domain.add(new Horario(new String[]{"2N34","",""}));
            domain.add(new Horario(new String[]{"3N12","",""}));
            domain.add(new Horario(new String[]{"3N34","",""}));
            domain.add(new Horario(new String[]{"4N12","",""}));
            domain.add(new Horario(new String[]{"4N34","",""}));
            domain.add(new Horario(new String[]{"5N12","",""}));
            domain.add(new Horario(new String[]{"5N34","",""}));
            domain.add(new Horario(new String[]{"6N12","",""}));
            domain.add(new Horario(new String[]{"6N34","",""}));
        }else{
            if(numCreditos == 4){
                //manha dois dias diferentes
                domain.add(new Horario(new String[]{"2M12","4M12",""}));
                domain.add(new Horario(new String[]{"2M34","4M34",""}));
                domain.add(new Horario(new String[]{"2M56","4M56",""}));
                domain.add(new Horario(new String[]{"3M12","5M12",""}));
                domain.add(new Horario(new String[]{"3M34","5M34",""}));
                domain.add(new Horario(new String[]{"3M56","5M56",""}));
                domain.add(new Horario(new String[]{"4M12","6M12",""}));
                domain.add(new Horario(new String[]{"4M34","6M34",""}));
                domain.add(new Horario(new String[]{"4M56","6M56",""}));
                
                domain.add(new Horario(new String[]{"2M12","6M12",""}));
                domain.add(new Horario(new String[]{"2M34","6M34",""}));
                domain.add(new Horario(new String[]{"2M56","6M56",""}));
                domain.add(new Horario(new String[]{"2M12","5M12",""}));
                domain.add(new Horario(new String[]{"2M34","5M34",""}));
                domain.add(new Horario(new String[]{"2M56","5M56",""}));
                domain.add(new Horario(new String[]{"3M12","6M12",""}));
                domain.add(new Horario(new String[]{"3M34","6M34",""}));
                domain.add(new Horario(new String[]{"3M56","6M56",""}));
                
                //manha mesmo dia
                domain.add(new Horario(new String[]{"2M12","2M34",""}));
                domain.add(new Horario(new String[]{"2M34","2M56",""}));
                domain.add(new Horario(new String[]{"3M12","3M34",""}));
                domain.add(new Horario(new String[]{"3M34","5M56",""}));
                domain.add(new Horario(new String[]{"4M12","4M34",""}));
                domain.add(new Horario(new String[]{"4M34","4M56",""}));
                domain.add(new Horario(new String[]{"5M12","5M34",""}));
                domain.add(new Horario(new String[]{"5M34","5M56",""}));
                domain.add(new Horario(new String[]{"6M12","6M34",""}));
                domain.add(new Horario(new String[]{"6M34","6M56",""}));
                //tarde dois dias diferentes
                domain.add(new Horario(new String[]{"2T12","4T12",""}));
                domain.add(new Horario(new String[]{"2T34","4T34",""}));
                domain.add(new Horario(new String[]{"2T56","4T56",""}));
                domain.add(new Horario(new String[]{"3T12","5T12",""}));
                domain.add(new Horario(new String[]{"3T34","5T34",""}));
                domain.add(new Horario(new String[]{"3T56","5T56",""}));
                domain.add(new Horario(new String[]{"4T12","6T12",""}));
                domain.add(new Horario(new String[]{"4T34","6T34",""}));
                domain.add(new Horario(new String[]{"4T56","6T56",""}));
                
                domain.add(new Horario(new String[]{"2T12","6T12",""}));
                domain.add(new Horario(new String[]{"2T34","6T34",""}));
                domain.add(new Horario(new String[]{"2T56","6T56",""}));
                domain.add(new Horario(new String[]{"2T12","5T12",""}));
                domain.add(new Horario(new String[]{"2T34","5T34",""}));
                domain.add(new Horario(new String[]{"2T56","5T56",""}));
                domain.add(new Horario(new String[]{"3T12","6T12",""}));
                domain.add(new Horario(new String[]{"3T34","6T34",""}));
                domain.add(new Horario(new String[]{"3T56","6T56",""}));
                //tarde mesmo dia
                domain.add(new Horario(new String[]{"2T12","2T34",""}));
                domain.add(new Horario(new String[]{"2T34","2T56",""}));
                domain.add(new Horario(new String[]{"3T12","3T34",""}));
                domain.add(new Horario(new String[]{"3T34","5T56",""}));
                domain.add(new Horario(new String[]{"4T12","4T34",""}));
                domain.add(new Horario(new String[]{"4T34","4T56",""}));
                domain.add(new Horario(new String[]{"5T12","5T34",""}));
                domain.add(new Horario(new String[]{"5T34","5T56",""}));
                domain.add(new Horario(new String[]{"6T12","6T34",""}));
                domain.add(new Horario(new String[]{"6T34","6T56",""}));
                //noite dois dias diferentes
                domain.add(new Horario(new String[]{"2N12","4N12",""}));
                domain.add(new Horario(new String[]{"2N34","4N34",""}));
                domain.add(new Horario(new String[]{"3N12","5N12",""}));
                domain.add(new Horario(new String[]{"3N34","5N34",""}));
                domain.add(new Horario(new String[]{"4N12","6N12",""}));
                domain.add(new Horario(new String[]{"4N34","6N34",""}));
                
                domain.add(new Horario(new String[]{"2N12","5N12",""}));
                domain.add(new Horario(new String[]{"2N34","5N34",""}));
                domain.add(new Horario(new String[]{"3N12","6N12",""}));
                domain.add(new Horario(new String[]{"3N34","6N34",""}));
                domain.add(new Horario(new String[]{"2N12","6N12",""}));
                domain.add(new Horario(new String[]{"2N34","6N34",""}));
                //noite mesmo dia
                domain.add(new Horario(new String[]{"2N12","2N34",""}));
                domain.add(new Horario(new String[]{"3N12","3N34",""}));
                domain.add(new Horario(new String[]{"4N12","4N34",""}));
                domain.add(new Horario(new String[]{"5N12","5N34",""}));
                domain.add(new Horario(new String[]{"6N12","6N34",""}));
             
            }else{
                if(numCreditos == 6){
                    domain.add(new Horario(new String[]{"2M12","4M12","6M12"}));
                    domain.add(new Horario(new String[]{"2M34","4M34","6M34"}));
                    domain.add(new Horario(new String[]{"2M56","4M56","6M56"}));
                    domain.add(new Horario(new String[]{"3M12","5M12","6M12"}));
                    domain.add(new Horario(new String[]{"3M34","5M34","6M34"}));
                    domain.add(new Horario(new String[]{"3M56","5M56","6M56"}));
                    
                    domain.add(new Horario(new String[]{"2T12","4T12","6T12"}));
                    domain.add(new Horario(new String[]{"2T34","4T34","6T34"}));
                    domain.add(new Horario(new String[]{"2T56","4T56","6T56"}));
                    domain.add(new Horario(new String[]{"3T12","5T12","6T12"}));
                    domain.add(new Horario(new String[]{"3T34","5T34","6T34"}));
                    domain.add(new Horario(new String[]{"3T56","5T56","6T56"}));
                    
                    domain.add(new Horario(new String[]{"2N12","4N12","6N12"}));
                    domain.add(new Horario(new String[]{"2N34","4N34","6N34"}));
                    domain.add(new Horario(new String[]{"3N12","5N12","6N12"}));
                    domain.add(new Horario(new String[]{"3N34","5N34","6N34"}));
                    
                  
                }
            }
        }
        
        return domain;
    }

    
    
}
