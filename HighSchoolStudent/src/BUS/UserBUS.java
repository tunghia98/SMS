/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.UserDAO;
import java.util.ArrayList;
import DTO.User;

/**
 *
 * @author M S I
 */
public class UserBUS {

    UserDAO userDAO = new UserDAO();

    public ArrayList<User> getAllUser() {
        return userDAO.getAllUser();
    }

    public boolean addUser(User user) {
        return userDAO.addUser(user);
    }

    public boolean deleteUser(String userID) {
        return userDAO.deleteUser(userID);
    }
    
    public boolean editUser(User user) {
        return userDAO.editUser(user);
    }

    public boolean login(String username, String password) {
        return userDAO.login(username, password);
    }

    public String getUserRole(String username, String password) {
        return userDAO.getUserRole(username, password);
    }

    public User getUserByID(String userID) {
        for (User user : userDAO.getAllUser()) {
            if (user.getUserID().equals(userID)) {
                return user;
            }
        }
        return null;
    }
    
    

    public String getUserID(String username, String password) {
        return userDAO.getUserID(username, password);
    }

}
