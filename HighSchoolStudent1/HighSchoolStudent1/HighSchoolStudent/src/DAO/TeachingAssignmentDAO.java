/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TeachingAssignment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author quoca
 */
public class TeachingAssignmentDAO extends DatabaseConnection {

    public ArrayList<TeachingAssignment> getAllTeachingAssignments() {
        ArrayList<TeachingAssignment> teachingAssignmentList = new ArrayList<TeachingAssignment>();
        open();
        try {
            String sql = "SELECT * FROM [TeachingAssignment]";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                TeachingAssignment teachingAssignment = new TeachingAssignment();
                teachingAssignment.setId(rs.getString("Assignment_ID"));
                teachingAssignment.setTeacherID(rs.getString("Teacher_ID"));
                teachingAssignment.setClassID(rs.getString("Class_ID"));
                teachingAssignment.setSubjectID(rs.getString("Subject_ID"));
                teachingAssignment.setSchoolYearID(rs.getString("SchoolYear_ID"));
                teachingAssignment.setDayOfWeek(rs.getString("Day_Of_Week"));
                teachingAssignment.setPeriod(rs.getInt("Period"));
                teachingAssignmentList.add(teachingAssignment);
            }
            return teachingAssignmentList;
        } catch (SQLException ex) {
            System.out.println("Error not define");
        } finally {
            close();
        }

        return teachingAssignmentList;
    }

    public boolean addTeachingAssignment(TeachingAssignment teachingAssignment) {
        Boolean result = false;
        open();
        String sql = "INSERT INTO [TeachingAssignment](Assignment_ID, Teacher_ID, Class_ID, Subject_ID, SchoolYear_ID) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, teachingAssignment.getId());
            pstm.setString(2, teachingAssignment.getTeacherID());
            pstm.setString(3, teachingAssignment.getClassID());
            pstm.setString(4, teachingAssignment.getSubjectID());
            pstm.setString(5, teachingAssignment.getSchoolYearID());

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

    public boolean editTeachingAssignment(TeachingAssignment teachingAssignment) {
        Boolean result = false;
        open();
        String sql = "UPDATE [TeachingAssignment] Teacher_ID = ?, Class_ID = ? , Subject_ID  = ?, Day_Of_Week = ?, Period = ? WHERE Assignment_ID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(6, teachingAssignment.getId());
            pstm.setString(1, teachingAssignment.getTeacherID());
            pstm.setString(2, teachingAssignment.getClassID());
            pstm.setString(3, teachingAssignment.getSubjectID());
            pstm.setString(4, teachingAssignment.getDayOfWeek());
            pstm.setInt(5, teachingAssignment.getPeriod());

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

    public boolean deleteTeachingAssignmentByID(String id) {
        boolean result = false;
        open();
        String sql = "DELETE FROM [TeachingAssignment] WHERE Assignment_ID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);
            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error : " + ex.toString());
        }
        return result;
    }

    public boolean checkTeachingAssignmentExistById(String id) throws SQLException {
        boolean isExist = false;
        open();
        PreparedStatement psm = conn.prepareStatement("SELECT * FROM [TeachingAssignment] WHERE Assignment_ID = ?");
        psm.setString(1, id);
        ResultSet rs = psm.executeQuery();
        if (rs.next()) {
            isExist = true;
        }
        close();
        return isExist;
    }

}
