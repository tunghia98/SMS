/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.FunctionDAO;
import DTO.Function;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author M S I
 */
public class FunctionBUS {

    FunctionDAO functionDAO = new FunctionDAO();

    //Lấy danh sách chức năng
    public ArrayList<Function> getAllFunction() {
        return functionDAO.getAllFunction();
    }

    // Thêm chức năng
    public boolean addFunction(Function function) {
        for (Function f : functionDAO.getAllFunction()) {
            if (f.getFunctionName().equals(function.getFunctionName())) {
                return false;
            }
        }
        return functionDAO.addFunction(function);
    }

    // Sửa chức năng
    public boolean editFunction(Function function) {
        for (Function f : functionDAO.getAllFunction()) {
            if (f.getFunctionName().equals(function.getFunctionName())) {
                return false;
            }
        }
        return functionDAO.editFunction(function);
    }

    // Ẩn chức năng
    public boolean deleteFunction(String functionID) {
        return functionDAO.deleteFunction(functionID);
    }

    // kiếm tra chức năng
    public boolean checkFunction(String functionName) {
        return functionDAO.checkFunction(functionName);
    }

    // Lấy chức năng qua mã
    public Function getFunctionByID(String functionID) {
        for (Function function : functionDAO.getAllFunction()) {
            if (function.getFunctionID().equals(functionID)) {
                return function;
            }
        }
        return null;
    }
    
    
    // Lấy chức năng qua tên
    public Function getFunctionByName(String functionName) {
        for (Function function : functionDAO.getAllFunction()) {
            if (function.getFunctionName().equals(functionName)) {
                return function;
            }
        }
        return null;
    }
}
