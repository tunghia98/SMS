/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Subject;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author M S I
 */
public class SubjectDAO extends DatabaseConnection {

    public ArrayList<Subject> getAllSubjects() {
        ArrayList<Subject> subjectList = new ArrayList<Subject>();
        open();
        try {
            String sql = "SELECT * FROM [Subject]";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectID(rs.getString("Subject_ID"));
                subject.setSubjectName(rs.getString("Subject_Name"));
                subject.setCoefficient(rs.getInt("Coefficient"));
                subject.setNumberOfLesson(rs.getInt("Number_Of_Lesson"));
                subjectList.add(subject);
            }
            return subjectList;
        } catch (SQLException ex) {
            System.out.println("Lỗi");
        } finally {
            close();
        }

        return subjectList;
    }

    public boolean addSubject(Subject subject) {
        Boolean result = false;
        open();
        String sql = "INSERT INTO [Subject] VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, subject.getSubjectID());
            pstm.setString(2, subject.getSubjectName());
            pstm.setInt(3, subject.getCoefficient());
            pstm.setInt(4, subject.getNumberOfLesson());

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

    public boolean editSubject(Subject subject) {
        Boolean result = false;
        open();
        String sql = "UPDATE [Subject] SET Subject_Name = ?, Coefficient = ?, Number_Of_Lesson = ?  WHERE Subject_ID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, subject.getSubjectName());
            pstm.setInt(2, subject.getCoefficient());
            pstm.setInt(3, subject.getNumberOfLesson());
            pstm.setString(4, subject.getSubjectID());

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

    public boolean deleteSubject(Subject subject) {
        boolean result = false;
        open();
        String sql = "DELETE FROM [Subject] WHERE Subject_ID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, subject.getSubjectID());
            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error : " + ex.toString());
        }
        return result;
    }

    public Subject getSubjectByID(String subjectID) {
        ArrayList<Subject> subjectList = getAllSubjects();
        for(Subject subject : subjectList) {
            if(subject.getSubjectID().equals(subjectID)) {
                return subject;
            }
        }
        return null;
    }
}
