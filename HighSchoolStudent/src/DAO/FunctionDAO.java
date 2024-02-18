/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Function;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author M S I
 */
public class FunctionDAO extends DatabaseConnection{
    //Lấy danh sách chức năng
    public ArrayList<Function> getAllFunction() {
        ArrayList<Function> functionList = new ArrayList<Function>();
        open();
        try {
            String sql = "SELECT * FROM [Function] WHERE [Status] = 1";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Function function = new Function();
                function.setFunctionID(rs.getString("Function_ID"));
                function.setFunctionName(rs.getString("Function_Name"));
                function.setStatus(rs.getInt("status"));
                functionList.add(function);
            }
            return functionList;
        } catch (SQLException ex) {
            System.out.println("Lỗi");
        } finally {
            close();
        }

        return functionList;
    }

    // Thêm chức năng
    public boolean addFunction(Function function) {
        boolean result = false;
        try {
            String sql = "INSERT INTO [Function] VALUES (?, ?, ?)";
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, function.getFunctionID());
            pstm.setString(2, function.getFunctionName());
            pstm.setInt(3, function.getStatus());

            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return result;

    }
    
    // Sửa chức năng
    public boolean editFunction(Function function) {
        boolean result = false;
        try {
            String sql = "UPDATE [Function] SET Function_Name = ? WHERE Function_ID = ?";
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, function.getFunctionName());
            pstm.setString(2, function.getFunctionID());
            int n = pstm.executeUpdate();
            if(n > 0) {
                result = true;
            }
                    
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return result;
    }
    
    // Ẩn chức năng
    public boolean deleteFunction(String functionID) {
        boolean result = false;
        try {
            String sql = "UPDATE [Function] SET Status = 0 WHERE Function_ID = ?";
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, functionID);
            int n = pstm.executeUpdate();
            if(n > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return result;
    }
    
    // kiếm tra chức năng
    public boolean checkFunction(String functionName) {
        boolean result = false;
        try {
            String sql = "SELECT * FROM [Function] WHERE Function_Name = ?";
            open();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, functionName);
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
