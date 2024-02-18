/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author M S I
 */
import DAO.*;
import DTO.*;
import java.util.ArrayList;

public class SubjectBUS {

    private SubjectDAO subjectDAO = new SubjectDAO();

    public ArrayList<Subject> getAllSubjects() {
        return subjectDAO.getAllSubjects();
    }

    public boolean addSubject(Subject subject) {
        for(Subject sb : subjectDAO.getAllSubjects()) {
            if(sb.getSubjectName().equals(subject.getSubjectName())) {
                return false;
            }
        }
        return subjectDAO.addSubject(subject);
    }

    public boolean deleteSubject(Subject subject) {
        return subjectDAO.deleteSubject(subject);
    }

    public boolean editSubject(Subject subject) {
        for(Subject sb : subjectDAO.getAllSubjects()) {
            if(sb.getSubjectName().equals(subject.getSubjectName())) {
                return false;
            }
        }
        return subjectDAO.editSubject(subject);
    }
    
    public Subject getSubjectByID(String subjectID) {
        return subjectDAO.getSubjectByID(subjectID);
    }

    
    public Subject getSubjectByName(String subjectName) {
        for(Subject sb : subjectDAO.getAllSubjects()) {
            if(sb.getSubjectName().equals(subjectName)) {
                return sb;
            }
        }
        return null;
    }
}
