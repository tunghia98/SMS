/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Mark;
import java.util.ArrayList;
import java.sql.*;

public class MarkDAO extends DatabaseConnection {

    public ArrayList<Mark> getAllMark() {
        System.out.println("Hay ở đây");
        ArrayList<Mark> markList = new ArrayList<Mark>();
        open();
        try {
            String sql = "SELECT * FROM [Student_Mark_Subject]";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Mark mark = new Mark();
                mark.setStudentID(rs.getString("std_id"));
                mark.setStudentName(rs.getString("std_name"));
                mark.setTeacherId(rs.getString("teacher_id"));
                mark.setMark_1(rs.getFloat("Mark_1"));
                mark.setMark_2(rs.getFloat("Mark_2"));
                mark.setMark_15(rs.getFloat("Mark_15"));
                mark.setMark_45(rs.getFloat("Mark_45"));
                mark.setMark_end(rs.getFloat("Mark_end"));
                mark.setMark_avg(rs.getFloat("Mark_avg"));
                markList.add(mark);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi");
        } finally {
            close();
        }

        return markList;
    }

    public boolean addMark(Mark mark) {
        boolean result = false;
        open();
        String sql = "INSERT INTO Student_Mark_Subject VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, mark.getStudentID());
            pstm.setString(2, mark.getStudentName());
            pstm.setString(3, mark.getTeacherId());
            pstm.setFloat(4, mark.getMark_1());
            pstm.setFloat(5, mark.getMark_2());
            pstm.setFloat(6, mark.getMark_15());
            pstm.setFloat(7, mark.getMark_45());
            pstm.setFloat(8, mark.getMark_end());
            pstm.setFloat(9, mark.getMark_avg());
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

    public boolean editmark(Mark mark) {
        boolean result = false;
        open();
        String sql = "UPDATE STUDENT SET mark_1 = ?,mark_2 = ?,mark_15 = ?,mark_45 = ?,mark_end = ?,mark_avg = ? WHERE std_id = ? AND teacher_id =?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(7, mark.getStudentID());
            pstm.setString(8, mark.getTeacherId());
            pstm.setFloat(1, mark.getMark_1());
            pstm.setFloat(2, mark.getMark_2());
            pstm.setFloat(3, mark.getMark_15());
            pstm.setFloat(4, mark.getMark_45());
            pstm.setFloat(5, mark.getMark_end());
            pstm.setFloat(6, mark.getMark_avg());
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

 

}
