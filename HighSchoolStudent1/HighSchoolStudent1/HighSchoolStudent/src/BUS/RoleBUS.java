/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.RoleDAO;
import DTO.Role;
import java.util.ArrayList;

/**
 *
 * @author M S I
 */
public class RoleBUS {
    RoleDAO roleDAO = new RoleDAO();
    public ArrayList<Role> getAllRole() {
        return roleDAO.getAllRole();
    }
    
    public boolean addRole(Role role) {
        for(Role r : roleDAO.getAllRole()) {
            if(r.getRoleName().equals(role.getRoleName())) {
                    return false;
                } 
            }
        return roleDAO.addRole(role);
    }
    
    public boolean deleteRole(String roleID) {
        String roleName = getRoleByID(roleID).getRoleName();
        if(roleName.equals("Admin")) {
            return false;
        }
        return roleDAO.deleteRole(roleID);
    }
    
    public boolean editRole(Role role) {
        for(Role r : roleDAO.getAllRole()) {
            if(r.getRoleName().equals(role.getRoleName())) {
                return false;
            }
        }
        return roleDAO.editRole(role);
    }
    
    
    

        
    public Role getRoleByID(String roleID) {
        for(Role role : roleDAO.getAllRole()) {
            if(role.getRoleID().equals(roleID)) {
                return role;
            }
        }
        return null;
    }
    
    public Role getRoleByName(String roleName) {
        for(Role role : roleDAO.getAllRole()) {
            if(role.getRoleName().equals(roleName)) {
                return role;
            }
        }
        return null;
    }
    
    public ArrayList<String> getAllRoleName() {
        ArrayList<String> roleNameList = new ArrayList<String>();
        for(Role role : roleDAO.getAllRole()) {
            roleNameList.add(role.getRoleID() + "-" + role.getRoleName());
        }
        return roleNameList;
    }
    
    public ArrayList<String> getOnlyRoleName() {
        ArrayList<String> roleNameList = new ArrayList<String>();
        for(Role role : roleDAO.getAllRole()) {
            roleNameList.add(role.getRoleName());
        }
        return roleNameList;
    }

}
