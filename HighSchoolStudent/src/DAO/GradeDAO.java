/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Grade;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author M S I
 */
public class GradeDAO extends DatabaseConnection{
    public ArrayList<Grade> getAllGrades() {
        ArrayList<Grade> gradeList = new ArrayList<Grade>();
        open();
        try {
            String sql = "SELECT * FROM Grade";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                Grade grade = new Grade();
                grade.setGradeID(rs.getString("Grade_ID"));
                grade.setGradeName(rs.getString("Grade_Name"));
                gradeList.add(grade);
            }
        } catch (Exception e) {
            System.out.println("Lỗi:select grade " + e);
        } finally {
            close();
        }
        return gradeList;
    }
    public boolean addGrade(Grade grade){
        Boolean result =false;
        open();
        String sql = "INSERT INTO Grade VALUES (?, ?)";
        try{
            PreparedStatement pstm= conn.prepareStatement(sql);
            pstm.setString(1, grade.getGradeID());
            pstm.setString(2,grade.getGradeName());
            int n=pstm.executeUpdate();
            if(n>0) result=true;
        }catch(SQLException ex){
            System.out.println("ERROR: loi addGrade"+ex.toString());
        }finally{
            close();
    }
        return result;
    }
    
    public boolean editGrade(Grade grade){
        Boolean result= false;
        String sql= "UPDATE [Grade] SET Grade_Name = ? WHERE Grade_ID= ?";
        open();
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, grade.getGradeName());
            pstm.setString(2, grade.getGradeID());
            int n= pstm.executeUpdate();
            if(n>0) result= true;
        }catch(SQLException ex){
            System.out.println("ERROR: edit Grade"+ ex.toString());
        }finally{
            close();
        }
        return result;
    }
    public boolean deleteGrade(Grade grade) {
        boolean result = false;
        open();
        String sql = "DELETE FROM Grade WHERE Grade_ID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, grade.getGradeID());
            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error deleteGrade: " + ex.toString());
        }
        return result;
    }
    public Grade getGradeByID(String gradeID){
        ArrayList<Grade> gradeList = getAllGrades();
        for(Grade grade:gradeList){
            if(grade.getGradeID().equals(gradeID))
                return grade;
        }
        return null;
    }
//    public boolean addGrade(Grade grade) {
//        Boolean result = false;
//        open();
//        String sql = "INSERT INTO "
//    }
}
