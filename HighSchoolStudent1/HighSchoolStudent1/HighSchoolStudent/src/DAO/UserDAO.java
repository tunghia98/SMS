/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.User;
import java.awt.List;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author M S I
 */
public class UserDAO extends DatabaseConnection {

    // lấy toàn bộ người dùng
    public ArrayList<User> getAllUser() {
        ArrayList<User> userList = new ArrayList<User>();
        try {
            String sql = "SELECT * FROM [User]";
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getString("User_ID"));
                user.setRoleID(rs.getString("Role_ID"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                userList.add(user);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return userList;
    }

    // thêm người dùng
    public boolean addUser(User user) {
        boolean result = false;
        try {
            String sql = "INSERT INTO [User] VALUES(?, ?, ?, ?)";
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getUserID());
            pstm.setString(4, user.getRoleID());
            pstm.setString(2, user.getUsername());
            pstm.setString(3, user.getPassword());
            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return result;
    }

    // xóa tài khoản người dùng
    public boolean deleteUser(String userID) {
        boolean result = false;
        try {
            open();
            String sql = "DELETE [User] WHERE User_ID = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, userID);
            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return result;
    }

    
    public boolean editUser(User user) {
        boolean result = false;
        try {
            open();
            String sql = "UPDATE [User] SET [Username] = ?, [Password] = ?, Role_ID = ? WHERE [User_ID] = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getRoleID());
            pstm.setString(4, user.getUserID());
            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return result;
    }
    
    
    public boolean login(String username, String password) {
        boolean result = false;
        try {
            open();
            String sql = "SELECT * FROM [User] WHERE Username = ? AND [Password] = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                result = true;
            } else {
                result = false;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return result;
    }

    public String getUserRole(String username, String password) {
        String result = "";
        try {
            open();
            String sql = "SELECT Role_ID FROM [User] WHERE [Username] = ? AND [Password] = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                result = rs.getString(1);
            } else {
                result = "Không tìm thấy mã";
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        close();
        return result;
    }

    public String getUserID(String username, String password) {
        try {
            open();
            String sql = "SELECT User_ID FROM [User] WHERE [Username] = ? AND [Password] = ? ";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                String userID = rs.getString(1);
                return userID;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return null;
    }
}
