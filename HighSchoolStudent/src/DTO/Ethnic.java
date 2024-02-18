/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author M S I
 */
public class Ethnic {
    private String ethnicID;
    private String ethnicName;

    public Ethnic() {
    }

    
    public Ethnic(String ethnicID, String ethnicName) {
        this.ethnicID = ethnicID;
        this.ethnicName = ethnicName;
    }

    public String getEthnicID() {
        return ethnicID;
    }

    public void setEthnicID(String ethnicID) {
        this.ethnicID = ethnicID;
    }

    public String getEthnicName() {
        return ethnicName;
    }

    public void setEthnicName(String ethnicName) {
        this.ethnicName = ethnicName;
    }
    
    
    
}
