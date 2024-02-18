/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.StudentDisDAO;
import DTO.StudentDis;
import java.util.ArrayList;

/**
 *
 * @author M S I
 */
public class StudentDisBUS {

    StudentDisDAO studentDisDAO = new StudentDisDAO();

    public ArrayList<StudentDis> getAllStudentDis() {
        return studentDisDAO.getAllStudentDis();
    }

    public boolean addStudentDis(StudentDis studentDis) {
        return studentDisDAO.addStudentDis(studentDis);
    }
    
    public boolean editStudentDis(StudentDis studentDis) {
        return studentDisDAO.editStudentDis(studentDis);
    }
    
    public boolean deleteStudentDis(StudentDis studentDis) {
        return studentDisDAO.deleteStudentDis(studentDis);
    }
    
    public StudentDis getStudentDisByID(String studentDisID) {
        for(StudentDis studentDis : studentDisDAO.getAllStudentDis()) {
            if(studentDis.getStudentID().equals(studentDisID)) {
                
                return studentDis;
            }
        }
        return null;
    }

}
