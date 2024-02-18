/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.DiscliproroleDAO;
import DTO.Discliprorole;
import java.util.ArrayList;

/**
 *
 * @author M S I
 */
public class DiscliproroleBUS {
    DiscliproroleDAO discliproroleDAO = new DiscliproroleDAO();
    public ArrayList<Discliprorole> getAllDiscliprorole() {
        return discliproroleDAO.getAllDiscliprorole();
    }
    
    public boolean addDiscliprorole(Discliprorole discliprorole) {
        return discliproroleDAO.addDiscliprorole(discliprorole);
    }
    
    public boolean deleteDiscliprorole(String roleID) {
        return discliproroleDAO.deleteDiscliprorole(roleID);
    }
    
    public boolean editDiscliprorole(Discliprorole discliprorole) {
        return discliproroleDAO.editDiscliprorole(discliprorole);
    }
    
    
    
    public ArrayList<String> getAllRoleContent() {
        ArrayList<String> roleCotentList = new ArrayList<>();
        for(Discliprorole discliprorole : discliproroleDAO.getAllDiscliprorole()) {
            roleCotentList.add(discliprorole.getRoleContent());
        }
        return roleCotentList;
    }
        public ArrayList<String> getAllRoleID() {
        ArrayList<String> roleIDList = new ArrayList<>();
        for(Discliprorole discliprorole : discliproroleDAO.getAllDiscliprorole()) {
            roleIDList.add(discliprorole.getRoleID());
        }
        return roleIDList;
    }
        
    public Discliprorole getDiscliproroleByID(String roleID) {
        for(Discliprorole discliprorole : discliproroleDAO.getAllDiscliprorole()) {
            if(discliprorole.getRoleID().equals(roleID)) {
                return discliprorole;
            }
        }
        return null;
    }

}
