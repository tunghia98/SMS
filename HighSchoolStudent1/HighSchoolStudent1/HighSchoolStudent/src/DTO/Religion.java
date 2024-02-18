/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author M S I
 */
public class Religion {
    private String religionID;
    private String religionName;

    public Religion() {
    }

    
    public Religion(String religionID, String religionName) {
        this.religionID = religionID;
        this.religionName = religionName;
    }

    public String getReligionID() {
        return religionID;
    }

    public void setReligionID(String religionID) {
        this.religionID = religionID;
    }

    public String getReligionName() {
        return religionName;
    }

    public void setReligionName(String religionName) {
        this.religionName = religionName;
    }
    
    
    
    
}
