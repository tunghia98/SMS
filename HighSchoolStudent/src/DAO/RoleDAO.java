/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Role;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author M S I
 */
public class RoleDAO extends DatabaseConnection {

    //Lấy danh sách nhóm quyền
    public ArrayList<Role> getAllRole() {
        ArrayList<Role> roleList = new ArrayList<Role>();
        open();
        try {
            String sql = "SELECT * FROM [Role] WHERE [Status] = 1";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setRoleID(rs.getString("Role_ID"));
                role.setRoleName(rs.getString("Role_Name"));
                role.setStatus(rs.getInt("status"));
                roleList.add(role);
            }
            return roleList;
        } catch (SQLException ex) {
            System.out.println("Lỗi");
        } finally {
            close();
        }

        return roleList;
    }

    // Thêm nhóm quyền
    public boolean addRole(Role role) {
        boolean result = false;
        try {
            String sql = "INSERT INTO ROLE VALUES (?, ?, ?)";
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, role.getRoleID());
            pstm.setString(2, role.getRoleName());
            pstm.setInt(3, role.getStatus());

            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return result;

    }
    
    // Sửa nhóm quyền
    public boolean editRole(Role role) {
        boolean result = false;
        try {
            String sql = "UPDATE Role SET Role_Name = ? WHERE Role_ID = ?";
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, role.getRoleName());
            pstm.setString(2, role.getRoleID());
            int n = pstm.executeUpdate();
            if(n > 0) {
                result = true;
            }
                    
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return result;
    }
    
    // Ẩn nhóm quyền
    public boolean deleteRole(String roleID) {
        boolean result = false;
        try {
            String sql = "UPDATE Role SET Status = 0 WHERE Role_ID = ?";
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
    
    // kiếm tra nhóm quyền
    public boolean checkRole(String roleName) {
        boolean result = false;
        try {
            String sql = "SELECT * FROM Role WHERE RoleName = ?";
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, roleName);
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
