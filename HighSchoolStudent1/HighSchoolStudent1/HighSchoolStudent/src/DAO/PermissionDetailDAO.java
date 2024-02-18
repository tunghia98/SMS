/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Function;
import DTO.PermissionDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author M S I
 */
public class PermissionDetailDAO extends DatabaseConnection {

    //Lấy danh sách chi tiết quyền
    public ArrayList<PermissionDetail> getAllPermissionDetail() {
        ArrayList<PermissionDetail> permissionDetailList = new ArrayList<PermissionDetail>();
        open();
        try {
            String sql = "SELECT * FROM [Permission_Detail]";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                PermissionDetail permissionDetail = new PermissionDetail();
                permissionDetail.setPermissionDetailID(rs.getString("PermissionDetail_ID"));
                permissionDetail.setRoleID(rs.getString("Role_ID"));
                permissionDetail.setFunctionID(rs.getString("Function_ID"));
                permissionDetail.setAction(rs.getString("Action"));

                permissionDetailList.add(permissionDetail);
            }
            return permissionDetailList;
        } catch (SQLException ex) {
            System.out.println("Lỗi");
        } finally {
            close();
        }

        return permissionDetailList;
    }

    // lấy chi tiết quyền qua mã
    public PermissionDetail getPermissionDetailByID(String permissionDetailID) {
        open();
        PermissionDetail permissionDetail = new PermissionDetail();
        try {
            String sql = "SELECT * FROM [Permission_Detail] WHERE [PermissionDetail_ID] = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                permissionDetail.setPermissionDetailID(rs.getString("PermissionDetail_ID"));
                permissionDetail.setRoleID(rs.getString("Role_ID"));
                permissionDetail.setFunctionID(rs.getString("Function_ID"));
                permissionDetail.setAction(rs.getString("Action"));
            }
            return permissionDetail;
        } catch (SQLException ex) {
            System.out.println("Lỗi");
        } finally {
            close();
        }

        return permissionDetail;
    }

    // Thêm chi tiết quyền
    public boolean addPermissionDetail(PermissionDetail permissionDetail) {
        boolean result = false;
        try {
            String sql = "INSERT INTO [Permission_Detail] VALUES (?, ?, ?, ?)";
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, permissionDetail.getPermissionDetailID());
            pstm.setString(2, permissionDetail.getRoleID());
            pstm.setString(3, permissionDetail.getFunctionID());
            pstm.setString(4, permissionDetail.getAction());

            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return result;

    }

    // Sửa chi tiết quyền
    public boolean editFunction(PermissionDetail permissionDetail) {
        boolean result = false;
        try {
            String sql = "UPDATE [Permission_Detail] SET Role_ID = ?, Function_ID = ?, Action = ? WHERE PermissionDetail_ID = ?";
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(4, permissionDetail.getPermissionDetailID());
            pstm.setString(1, permissionDetail.getRoleID());
            pstm.setString(2, permissionDetail.getFunctionID());
            pstm.setString(3, permissionDetail.getAction());
            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return result;
    }

    // Xóa chi tiết quyền
    public boolean deletePermissionDetail(String permissionDetailID) {
        boolean result = false;
        try {
            String sql = "DELETE FROM [Permission_Detail] WHERE PermissionDetail_ID = ?";
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, permissionDetailID);
            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return result;
    }

    // lấy chức năng từ mã nhóm quyền
    public ArrayList<String> getFunctionByRoleID(String roleID) {
        ArrayList<String> functionNameList = new ArrayList<>();
        String sql = "SELECT DISTINCT Function_ID FROM Permission_Detail WHERE Role_ID = ?";
        try {
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, roleID);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                functionNameList.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return functionNameList;
    }

    // lấy hành động qua mã nhóm quyền, mã chức năng
    public String getAction(String roleID, String functionID) {
        String action = "";
        String sql = "SELECT [Action] FROM PermissionDetail WHERE Role_ID = ? AND Function_ID = ?";
        try {
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, roleID);
            pstm.setString(2, functionID);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                action += rs.getString(0) + "";
                if (action.equals("")) {
                    close();
                    return "";
                } else {
                    close();
                    action = action.substring(0, action.length() - 1);
                }
                return action;
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return null;
    }

    // Kiểm tra hành động
    public boolean checkAction(String roleID, String functionID, String action) {
        try {
            open();
            String sql = "SELECT * FROM [Permission_Detail] WHERE Role_ID = ? AND Function_ID = ? And Action = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, roleID);
            pstm.setString(2, functionID);
            pstm.setString(3, action);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                close();
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("Lỗi");
        } finally {
            close();
        }
        return false;
    }
}
