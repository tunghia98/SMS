/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.TeacherDAO;
import DTO.Teacher;
import GUI.AlertWarning;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author M S I
 */
public class TeacherBUS {
    TeacherDAO teacherDAO = new TeacherDAO();
    public ArrayList<Teacher> getAllTeachers() {
        return teacherDAO.getAllTeachers();
    }
    
    public boolean addTeacher(Teacher teacher) {
        return teacherDAO.addTeacher(teacher);
    }
    
    public boolean addTeacherWithoutImage(Teacher teacher) {
        for(Teacher tc : teacherDAO.getAllTeachers()) {
            if(tc.getTeacherID().equals(teacher.getTeacherID())) {
                return false;
            }
        }
        return teacherDAO.addTeacherWithoutImage(teacher);
    }
    public ArrayList<String> getAllTeacherName() {
        ArrayList<String> teacherNameList = new ArrayList<String>();
        for(Teacher teacher : teacherDAO.getAllTeachers()) {
            teacherNameList.add(teacher.getTeacherName());
        }
        return teacherNameList;
    }
    
    public Teacher getTeacherByID(String teacherID) {
        for(Teacher teacher : teacherDAO.getAllTeachers()) {
            if(teacher.getTeacherID().equals(teacherID)) {
                return teacher;
            }
        }
        return null;
    }
    
    public Teacher getTeacherByName(String teacherName) {
        for(Teacher teacher : teacherDAO.getAllTeachers()) {
            if(teacher.getTeacherName().equals(teacherName)) {
                return teacher;
            }
        }
        return null;
    }
    
    public boolean editTeacher(Teacher teacher) {
        return teacherDAO.editTeacher(teacher);
    }
    
    
    public boolean deleteTeacher(String teacherID) {
        return teacherDAO.deleteTeacherByID(teacherID);
    }
    


    

}
