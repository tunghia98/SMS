/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SemesterDAO;
import DTO.Semester;
import java.util.ArrayList;

/**
 *
 * @author M S I
 */
public class SemesterBUS {

    SemesterDAO semesterDAO = new SemesterDAO();

    public ArrayList<Semester> getAllSemester() {
        return semesterDAO.getAllSemester();
    }

    public boolean addSemester(Semester semester) {
        return semesterDAO.addSemester(semester);
    }
    
    public boolean editSemester(Semester semester) {
        return semesterDAO.editSemester(semester);
    }
    
    public boolean deleteSemester(Semester semester) {
        return semesterDAO.deleteSemester(semester);
    }
    
    public Semester getSemesterByID(String semesterID) {
        for(Semester semester : semesterDAO.getAllSemester()) {
            if(semester.getSemesterID().equals(semesterID)) {
                return semester;
            }
        }
        return null;
    }

}
