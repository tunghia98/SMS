/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PermissionDetailDAO;
import DTO.PermissionDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author M S I
 */
public class PermissionDetailBUS {

    PermissionDetailDAO permissionDetailDAO = new PermissionDetailDAO();

    //Lấy danh sách chi tiết quyền
    public ArrayList<PermissionDetail> getAllPermissionDetail() {
        return permissionDetailDAO.getAllPermissionDetail();
    }

    // Thêm chi tiết quyền
    public boolean addPermissionDetail(PermissionDetail permissionDetail) {
        for (PermissionDetail psm : permissionDetailDAO.getAllPermissionDetail()) {
            if (psm.getRoleID().equals(permissionDetail.getRoleID()) && psm.getFunctionID().equals(permissionDetail.getFunctionID()) && psm.getAction().equals(permissionDetail.getAction())) {
                return false;
            }
        }
        return permissionDetailDAO.addPermissionDetail(permissionDetail);

    }

    // Sửa chi tiết quyền
    public boolean editFunction(PermissionDetail permissionDetail) {
        return permissionDetailDAO.editFunction(permissionDetail);
    }

    // Xóa chi tiết quyền
    public boolean deletePermissionDetail(String permissionDetailID) {
        return permissionDetailDAO.deletePermissionDetail(permissionDetailID);
    }

    // lấy chức năng từ mã nhóm quyền
    public ArrayList<String> getFunctionByRoleID(String roleID) {
        return permissionDetailDAO.getFunctionByRoleID(roleID);
    }

    // Kiểm tra hành động
    public boolean checkAction(String roleID, String functionID, String action) {
        return permissionDetailDAO.checkAction(roleID, functionID, action);
    }

    // lấy chi tiết quyền qua mã
    public PermissionDetail getPermissionDetailByID(String permissionDetailID) {
        for(PermissionDetail psm : permissionDetailDAO.getAllPermissionDetail()) {
            if(psm.getPermissionDetailID().equals(permissionDetailID)) {
                return psm;
            }
        }
        return null;
    }
}
