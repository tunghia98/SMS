/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.GradeDAO;
import DTO.Grade;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class GradeBUS {

    private GradeDAO gradeDAO = new GradeDAO();

    public ArrayList<Grade> getAllGrades() {
        return gradeDAO.getAllGrades();
    }

    public boolean addGrade(Grade grade) {
        for (Grade g : gradeDAO.getAllGrades()) {
            if (g.getGradeName().equals(grade.getGradeName())) {
                return false;
            }
        }
        return gradeDAO.addGrade(grade);
    }

    public boolean deleteGrade(Grade grade) {
        return gradeDAO.deleteGrade(grade);
    }

    public boolean editGrade(Grade grade) {
        for (Grade g : gradeDAO.getAllGrades()) {
            if (g.getGradeName().equals(grade.getGradeName())) {
                return false;
            }
        }
        return gradeDAO.editGrade(grade);
    }

    public Grade getGradeByID(String gradeID) {
        return gradeDAO.getGradeByID(gradeID);
    }
    
    public Grade getGradeByName(String gradeName) {
        for(Grade grade : gradeDAO.getAllGrades()) {
            if(grade.getGradeName().equals(gradeName)) {
                return grade;
            }
        }
        return null;
    }
}
