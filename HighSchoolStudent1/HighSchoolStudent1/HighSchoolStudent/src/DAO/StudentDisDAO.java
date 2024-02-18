/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.StudentDis;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author M S I
 */
public class StudentDisDAO extends DatabaseConnection {

    public ArrayList<StudentDis> getAllStudentDis() {
        ArrayList<StudentDis> studentDisList = new ArrayList<StudentDis>();
        open();
        try {
            String sql = "SELECT * FROM [Student_Dis_Result]";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                StudentDis studentDis = new StudentDis();
                studentDis.setStudentID(rs.getString("Student_ID"));
                studentDis.setStudentName(rs.getString("Student_Name"));
                studentDis.setScore(rs.getFloat("Score"));
                studentDis.setResult(rs.getString("Result"));
                studentDisList.add(studentDis);
            }
            return studentDisList;
        } catch (SQLException ex) {
            System.out.print("Loi o day");
            System.out.println("Lỗi");
        } finally {
            close();
        }
        return studentDisList;
    }

    public boolean addStudentDis(StudentDis studentDis) {
        boolean result = false;
        open();
        String sql = "INSERT INTO [Student_Dis_Result] VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, studentDis.getStudentID());
            pstm.setString(2, studentDis.getStudentName());
            pstm.setFloat(3, studentDis.getScore());
            pstm.setString(4, studentDis.getResult());
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
    
    public boolean editStudentDis(StudentDis studentDis) {
        boolean result = false;
        open();
        String sql = "UPDATE [Student_Dis_Result] SET Score = ?, Result = ?  Where Student_ID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(3, studentDis.getStudentID());
            pstm.setFloat(1, studentDis.getScore());
            pstm.setString(2, studentDis.getResult());
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
    
    public boolean deleteStudentDis(StudentDis studentDis) {
        boolean result = true;
        open();
        String sql = "DELETE FROM [Student_Dis_Result] WHERE Student_ID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(2, studentDis.getStudentID());
            int n = pstm.executeUpdate();
            if(n > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        } finally {
            close();
        }
        return result;
        
    }
}
