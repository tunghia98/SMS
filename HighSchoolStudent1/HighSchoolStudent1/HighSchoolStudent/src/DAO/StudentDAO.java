/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Student;
import java.util.ArrayList;
import java.sql.*;


public class StudentDAO extends DatabaseConnection {

    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> studentList = new ArrayList<Student>();
        open();
        try {
            String sql = "SELECT * FROM [Student]";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getString("Student_ID"));
                student.setStudentName(rs.getString("Student_Name"));
                student.setDateOfBirth(rs.getString("Date_Of_Birth"));
                student.setGender(rs.getString("Gender"));
                student.setPhone(rs.getString("Phone"));
                student.setEmail(rs.getString("Email"));
                student.setAddress(rs.getString("Address"));
                student.setStatus(rs.getInt("Status"));
                student.setImage(rs.getString("Image"));
                student.setClassID(rs.getString("Class_ID"));
                studentList.add(student);
            }
            return studentList;
        } catch (SQLException ex) {
            System.out.println("Lỗi");
        } finally {
            close();
        }

        return studentList;
    }

    public boolean addStudent(Student student) {
        boolean result = false;
        open();
        String sql = "INSERT INTO Student VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, student.getStudentID());
            pstm.setString(2, student.getStudentName());
            pstm.setString(3, student.getDateOfBirth());
            pstm.setString(4, student.getGender());
            pstm.setString(5, student.getPhone());
            pstm.setString(6, student.getEmail());
            pstm.setString(7, student.getAddress());
            pstm.setInt(8, student.getStatus());
            pstm.setString(9, student.getImage());
            pstm.setString(10, student.getClassID());
            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        } finally {
            close();
        }
        return result;
    }

    public boolean editStudent(Student student) {
        boolean result = false;
        open();
        String sql = "UPDATE STUDENT SET Student_Name = ?, Date_Of_Birth = ?, Gender = ?, Phone = ?, Email= ?, Address= ? ,Image = ?, Class_ID = ? WHERE Student_ID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(9, student.getStudentID());
            pstm.setString(1, student.getStudentName());
            pstm.setString(2, student.getDateOfBirth());
            pstm.setString(3, student.getGender());
            pstm.setString(4, student.getPhone());
            pstm.setString(5, student.getEmail());
            pstm.setString(6, student.getAddress());
            pstm.setString(7, student.getImage());
            pstm.setString(8, student.getClassID());

            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        } finally {
            close();
        }
        return result;
    }

    public boolean deleteStudent(String studentID) {
        try {
            open();
            String sql = "DELETE FROM Student WHERE Student_ID = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, studentID);
            int n = pstm.executeUpdate();
            if (n > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return false;
    }
}
