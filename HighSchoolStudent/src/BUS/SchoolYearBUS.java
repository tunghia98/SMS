/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SchoolYearDAO;
import DTO.SchoolYear;
import java.util.ArrayList;

/**
 *
 * @author M S I
 */
public class SchoolYearBUS {

    SchoolYearDAO schoolYearDAO = new SchoolYearDAO();

    public boolean addSchoolYear(SchoolYear schoolYear) {
        for (SchoolYear sc : schoolYearDAO.getAllSchoolYear()) {
            if (sc.getSchoolYearName().equals(schoolYear)) {
                return false;
            }
        }
        return schoolYearDAO.addSchoolYear(schoolYear);
    }

    public ArrayList<SchoolYear> getAllSchoolYear() {
        return schoolYearDAO.getAllSchoolYear();
    }

    public SchoolYear getSchoolYearByID(String schoolYearID) {
        for (SchoolYear schoolYear : schoolYearDAO.getAllSchoolYear()) {
            if (schoolYear.getSchoolYearID().equals(schoolYearID)) {
                return schoolYear;
            }
        }
        return null;
    }

    public SchoolYear getSchoolYearByName(String schoolYearName) {
        for (SchoolYear schoolYear : schoolYearDAO.getAllSchoolYear()) {
            if (schoolYear.getSchoolYearName().equals(schoolYearName)) {
                return schoolYear;
            }
        }
        return null;
    }

    public boolean deleteSchoolYear(SchoolYear schoolYear) {
        return schoolYearDAO.deleteSchoolYear(schoolYear);
    }

    public boolean editSchoolYear(SchoolYear schoolYear) {
        return schoolYearDAO.editSchoolYear(schoolYear);
    }
    
    public boolean checkDublicate(SchoolYear sc) {
        for(SchoolYear schoolYear : schoolYearDAO.getAllSchoolYear()) {
            if(sc.getSchoolYearID().equals(schoolYear.getSchoolYearID())) {
                return true;
            }
        }
        return false;
    }

}
