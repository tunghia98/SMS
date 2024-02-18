/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SchoolYear;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author M S I
 */
public class SchoolYearDAO extends DatabaseConnection {

    public ArrayList<SchoolYear> getAllSchoolYear() {
        ArrayList<SchoolYear> schoolYearList = new ArrayList<SchoolYear>();
        open();
        try {
            String sql = "SELECT * FROM [SchoolYear]";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SchoolYear schoolYear = new SchoolYear();
                schoolYear.setSchoolYearID(rs.getString("SchoolYear_ID"));
                schoolYear.setSchoolYearName(rs.getString("SchoolYear_Name"));
                schoolYear.setStartDate(rs.getString("Start_Date"));
                schoolYear.setEndDate(rs.getString("End_Date"));
                schoolYearList.add(schoolYear);
            }
            return schoolYearList;
        } catch (SQLException ex) {
            System.out.println("Lỗi");
        } finally {
            close();
        }

        return schoolYearList;
    }

    public boolean addSchoolYear(SchoolYear schoolYear) {
        boolean result = false;
        open();
        String sql = "INSERT INTO SchoolYear VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, schoolYear.getSchoolYearID());
            pstm.setString(2, schoolYear.getSchoolYearName());
            pstm.setString(3, schoolYear.getStartDate());
            pstm.setString(4, schoolYear.getEndDate());

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

    public boolean deleteSchoolYear(SchoolYear schoolYear) {
        boolean result = false;
        open();
        String sql = "DELETE FROM [SchoolYear] WHERE SchoolYear_ID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, schoolYear.getSchoolYearID());
            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error : " + ex.toString());
        }
        return result;
    }

    public boolean editSchoolYear(SchoolYear schoolYear) {
        Boolean result = false;
        open();
        String sql = "UPDATE [SchoolYear] SET SchoolYear_Name = ?, Start_Date = ?, End_Date = ?  WHERE SchoolYear_ID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, schoolYear.getSchoolYearName());
            pstm.setString(2, schoolYear.getStartDate());
            pstm.setString(3, schoolYear.getEndDate());
            pstm.setString(4, schoolYear.getSchoolYearID());

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

//    public SchoolYear getSchoolYearByID(String schoolYearID) {
//        ArrayList<SchoolYear> schoolYearList = getAllSchoolYear();
//        for (SchoolYear schoolYear : schoolYearList) {
//            if (schoolYear.getSchoolYearID().equals(schoolYearID)) {
//                return schoolYear;
//            }
//        }
//        return null;
//    }
}
