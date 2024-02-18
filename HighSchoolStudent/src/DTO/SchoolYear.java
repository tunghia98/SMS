/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 * @author M S I
 */
public class SchoolYear {
    private String schoolYearID;
    private String schoolYearName;
    private String startDate;
    private String endDate;

    public SchoolYear() {
    }

    public SchoolYear(String schoolYearID, String schoolYearName, String startDate, String endDate) {
        this.schoolYearID = schoolYearID;
        this.schoolYearName = schoolYearName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getSchoolYearID() {
        return schoolYearID;
    }

    public void setSchoolYearID(String schoolYearID) {
        this.schoolYearID = schoolYearID;
    }

    public String getSchoolYearName() {
        return schoolYearName;
    }

    public void setSchoolYearName(String schoolYearName) {
        this.schoolYearName = schoolYearName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    
    
}
