/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.StudentDAO;
import DTO.Student;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author M S I
 */
public class StudentBUS {

    StudentDAO studentDAO = new StudentDAO();

    public ArrayList<Student> getAllStudent() {
        return studentDAO.getAllStudent();
    }

    public boolean addStudent(Student student) {
        return studentDAO.addStudent(student);
    }

    public boolean editStudent(Student student) {
        return studentDAO.editStudent(student);
    }
    
    public Student getStudentByID(String studentID) {
        for(Student st : studentDAO.getAllStudent()) {
            if(st.getStudentID().equals(studentID)) {
                return st;
            }
        }
        return null;
    }
    public ArrayList<Student> getStudentByClass(String classID) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        for(Student st : studentDAO.getAllStudent())
        {
            if(st.getClassID().equals(classID))
                studentList.add(st);
        }
        return studentList;
    }
    public boolean deleteStudent(String studentID) {
        return studentDAO.deleteStudent(studentID);
    } 
}
