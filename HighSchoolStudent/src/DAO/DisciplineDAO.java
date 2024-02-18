/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Discipline;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author M S I
 */
public class DisciplineDAO extends DatabaseConnection {

    public ArrayList<Discipline> getAllDiscipline() {
        ArrayList<Discipline> disciplineList = new ArrayList<Discipline>();
        open();
        try {
            String sql = "SELECT * FROM [Discipline]";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setDis_ID(rs.getString("Dis_ID"));
                discipline.setDis_Content(rs.getString("Dis_Content"));
                discipline.setDis_Score(rs.getFloat("Dis_Score"));
                disciplineList.add(discipline);
            }
            return disciplineList;
        } catch (SQLException ex) {
            System.out.println("Lỗi ở DAO");
        } finally {
            close();
        }

        return disciplineList;
    }

    public boolean addDiscipline(Discipline discipline) {
        boolean result = false;
        try {
            String sql = "INSERT INTO Discipline VALUES (?, ?, ?)";
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, discipline.getDis_ID());
            pstm.setString(2, discipline.getDis_Content());
            pstm.setFloat(3, discipline.getDis_Score());

            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return result;

    }
    
    public boolean editDiscipline(Discipline discipline) {
        boolean result = false;
        try {
            String sql = "UPDATE Discipline SET Dis_Content = ?, Dis_Score = ? WHERE Dis_ID = ?";
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(3, discipline.getDis_ID());
            pstm.setString(1, discipline.getDis_Content());
            pstm.setFloat(2, discipline.getDis_Score());
            int n = pstm.executeUpdate();
            if(n > 0) {
                result = true;
            }
                    
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return result;
    }
    
    public boolean deleteDiscipline(String Dis_ID) {
        boolean result = false;
        try {
            String sql = "DELETE FROM Discipline WHERE Dis_ID = ?";
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, Dis_ID);
            int n = pstm.executeUpdate();
            if(n > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return result;
    }

}
