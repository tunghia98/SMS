/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author M S I
 */
public class Discliprorole {
    private String roleID;
    private String roleContent;

    public Discliprorole() {
    }

    public Discliprorole(String roleID, String roleContent) {
        this.roleID = roleID;
        this.roleContent = roleContent;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getRoleContent() {
        return roleContent;
    }

    
    public void setRoleContent(String roleContent) {
        this.roleContent = roleContent;
    }



    
    
}
