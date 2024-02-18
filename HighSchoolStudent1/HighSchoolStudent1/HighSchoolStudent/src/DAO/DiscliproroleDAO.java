/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.DatabaseConnection;
import DTO.Discliprorole;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author M S I
 */
public class DiscliproroleDAO extends DatabaseConnection {

    public ArrayList<Discliprorole> getAllDiscliprorole() {
        ArrayList<Discliprorole> DiscliproroleList = new ArrayList<Discliprorole>();
        open();
        try {
            String sql = "SELECT * FROM [Discliprorole]";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Discliprorole Discliprorole = new Discliprorole();
                Discliprorole.setRoleID(rs.getString("Role_ID"));
                Discliprorole.setRoleContent(rs.getString("Role_Content"));
                DiscliproroleList.add(Discliprorole);
            }
            return DiscliproroleList;
        } catch (SQLException ex) {
            System.out.println("Lỗi");
        } finally {
            close();
        }

        return DiscliproroleList;
    }

    public boolean addDiscliprorole(Discliprorole Discliprorole) {
        boolean result = false;
        try {
            String sql = "INSERT INTO Discliprorole VALUES (?, ?)";
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, Discliprorole.getRoleID());
            pstm.setString(2, Discliprorole.getRoleContent());
            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return result;

    }
    
    public boolean editDiscliprorole(Discliprorole Discliprorole) {
        boolean result = false;
        try {
            String sql = "UPDATE Discliprorole SET Role_Content = ? WHERE Role_ID = ?";
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, Discliprorole.getRoleContent());
            pstm.setString(2, Discliprorole.getRoleID());
            int n = pstm.executeUpdate();
            if(n > 0) {
                result = true;
            }
                    
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return result;
    }
    
    public boolean deleteDiscliprorole(String roleID) {
        boolean result = false;
        try {
            String sql = "DELETE FROM Discliprorole WHERE Role_ID = ?";
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, roleID);
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
