/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.DisciplineDAO;
import DTO.Discipline;
import java.util.ArrayList;

/**
 *
 * @author M S I
 */
public class DisciplineBUS {
    DisciplineDAO disciplineDAO = new DisciplineDAO();
    public ArrayList<Discipline> getAllDiscipline() {
        return disciplineDAO.getAllDiscipline();
    }
    
    public boolean addDiscipline(Discipline discipline) {
        return disciplineDAO.addDiscipline(discipline);
    }
    
    public boolean deleteDiscipline(String Dis_ID) {
        return disciplineDAO.deleteDiscipline(Dis_ID);
    }
    
    public boolean editDiscipline(Discipline discipline) {
        return disciplineDAO.editDiscipline(discipline);
    }
    
    
    
    public ArrayList<String> getAllDis_Content() {
        ArrayList<String> Dis_CotentList = new ArrayList<>();
        for(Discipline discipline : disciplineDAO.getAllDiscipline()) {
            Dis_CotentList.add( discipline.getDis_Content());
        }
        return  Dis_CotentList;
    }
        public ArrayList<String> getAllDis_ID() {
        ArrayList<String> Dis_IDList = new ArrayList<>();
        for(Discipline discipline : disciplineDAO.getAllDiscipline()) {
            Dis_IDList.add( discipline.getDis_ID());
        }
        return Dis_IDList;
    }
        
    public Discipline getDisciplineByID(String Dis_ID) {
        for(Discipline discipline : disciplineDAO.getAllDiscipline()) {
            if(discipline.getDis_ID().equals(Dis_ID)) {
                return discipline;
            }
        }
        return null;
    }

}
