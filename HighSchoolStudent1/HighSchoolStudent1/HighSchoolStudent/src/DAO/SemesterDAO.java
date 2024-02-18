/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Semester;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author M S I
 */
public class SemesterDAO extends DatabaseConnection {

    public ArrayList<Semester> getAllSemester() {
        ArrayList<Semester> semesterList = new ArrayList<Semester>();
        open();
        try {
            String sql = "SELECT * FROM [Semester]";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Semester semester = new Semester();
                semester.setSemesterID(rs.getString("Semester_ID"));
                semester.setSemesterName(rs.getString("Semester_Name"));
                semester.setStartDate(rs.getString("Start_Date"));
                semester.setEndDate(rs.getString("End_Date"));
                semester.setSchoolYearID(rs.getString("SchoolYear_ID"));
                semesterList.add(semester);
            }
            return semesterList;
        } catch (SQLException ex) {
            System.out.println("Lỗi");
        } finally {
            close();
        }

        return semesterList;
    }

    public boolean addSemester(Semester semester) {
        boolean result = false;
        open();
        String sql = "INSERT INTO Semester VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, semester.getSemesterID());
            pstm.setString(2, semester.getSemesterName());
            pstm.setString(3, semester.getStartDate());
            pstm.setString(4, semester.getEndDate());
            pstm.setString(5, semester.getSchoolYearID());

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
    
    public boolean editSemester(Semester semester) {
        boolean result = false;
        open();
        String sql = "UPDATE Semester SET Semester_Name = ?, Start_Date = ?, End_Date = ?, SchoolYear_ID = ?  Where Semester_ID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(5, semester.getSemesterID());
            pstm.setString(1, semester.getSemesterName());
            pstm.setString(2, semester.getStartDate());
            pstm.setString(3, semester.getEndDate());
            pstm.setString(4, semester.getSchoolYearID());

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
    
    public boolean deleteSemester(Semester semester) {
        boolean result = true;
        open();
        String sql = "DELETE FROM Semester WHERE Semester_ID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, semester.getSemesterID());
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
