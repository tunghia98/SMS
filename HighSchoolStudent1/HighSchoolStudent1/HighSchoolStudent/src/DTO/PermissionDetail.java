/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author M S I
 */
public class PermissionDetail {
    private String permissionDetailID ;
    private String roleID;
    private String functionID;
    private String action;

    public PermissionDetail(String permissionDetailID, String roleID, String functionID, String action) {
        this.permissionDetailID = permissionDetailID;
        this.roleID = roleID;
        this.functionID = functionID;
        this.action = action;
    }

    public PermissionDetail() {
    }

    
    public String getPermissionDetailID() {
        return permissionDetailID;
    }

    public void setPermissionDetailID(String permissionDetailID) {
        this.permissionDetailID = permissionDetailID;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getFunctionID() {
        return functionID;
    }

    public void setFunctionID(String functionID) {
        this.functionID = functionID;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "PermissionDetail{" + "permissionDetailID=" + permissionDetailID + ", roleID=" + roleID + ", functionID=" + functionID + ", action=" + action + '}';
    }
    
    
}
