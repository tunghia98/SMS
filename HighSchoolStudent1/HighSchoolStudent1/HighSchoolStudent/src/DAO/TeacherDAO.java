/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Teacher;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author quoca
 */
public class TeacherDAO extends DatabaseConnection {

    public ArrayList<Teacher> getAllTeachers() {
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        open();
        try {
            String sql = "SELECT * FROM [Teacher]";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacherID(rs.getString("Teacher_ID"));
                teacher.setTeacherName(rs.getString("Teacher_Name"));
                teacher.setDateOfBirth(rs.getString("Date_Of_Birth"));
                teacher.setGender(rs.getString("Gender"));
                teacher.setPhone(rs.getString("Phone"));
                teacher.setEmail(rs.getString("Email"));
                teacher.setAddress(rs.getString("Address"));
                teacher.setStatus(rs.getInt("Status"));
                teacher.setImage(rs.getString("Image"));
                teacher.setSubjectID(rs.getString("Subject_ID"));
                teacherList.add(teacher);
            }
            return teacherList;
        } catch (SQLException ex) {
            System.out.println("Error not define");
        } finally {
            close();
        }

        return teacherList;
    }

    public boolean addTeacher(Teacher teacher) {
        Boolean result = false;
        open();
        String sql = "INSERT INTO [Teacher] (Teacher_ID, Teacher_Name, Date_Of_Birth, Gender, Phone, Email, Address, status, Image, Subject_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, teacher.getTeacherID());
            pstm.setString(2, teacher.getTeacherName());
            pstm.setString(3, teacher.getDateOfBirth());
            pstm.setString(4, teacher.getGender());
            pstm.setString(5, teacher.getPhone());
            pstm.setString(6, teacher.getEmail());
            pstm.setString(7, teacher.getAddress());
            pstm.setInt(8, 1);
            pstm.setString(9, teacher.getImage());
            pstm.setString(10, teacher.getSubjectID());
            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.toString());
        } finally {
            close();
        }
        return result;
    }
    
    
    public boolean addTeacherWithoutImage(Teacher teacher) {
        Boolean result = false;
        open();
        String sql = "INSERT INTO [Teacher] (Teacher_ID, Teacher_Name, status, Subject_ID) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, teacher.getTeacherID());
            pstm.setString(2, teacher.getTeacherName());
//            pstm.setString(3, teacher.getDateOfBirth());
//            pstm.setString(4, teacher.getGender());
//            pstm.setString(5, teacher.getPhone());
//            pstm.setString(6, teacher.getEmail());
//            pstm.setString(7, teacher.getAddress());
            pstm.setInt(8, 1);
            pstm.setString(9, teacher.getSubjectID());
            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.toString());
        } finally {
            close();
        }
        return result;
    }
    

    public boolean editTeacher(Teacher teacher) {
        Boolean result = false;
        open();
        String sql = "UPDATE TEACHER SET Teacher_Name = ?, Date_Of_Birth = ?, Gender = ?, Phone = ?, Email = ?, Address = ?, Image = ? WHERE Teacher_ID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, teacher.getTeacherName());
            pstm.setString(2, teacher.getDateOfBirth());
            pstm.setString(3, teacher.getGender());
            pstm.setString(4, teacher.getPhone());
            pstm.setString(5, teacher.getEmail());
            pstm.setString(6, teacher.getAddress());
            pstm.setString(7, teacher.getImage());
            pstm.setString(8, teacher.getTeacherID());
            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.toString());
        } finally {
            close();
        }
        return result;
    }

    public boolean deleteTeacherByID(String teacherID) {
        boolean result = false;
        open();
        String sql = "DELETE FROM [Teacher] WHERE Teacher_ID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, teacherID);
            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error : " + ex.toString());
        }
        return result;
    }

}
