/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ClassDAO;
import DTO.Class;
import java.util.ArrayList;

public class ClassBUS {

    private ClassDAO classDAO = new ClassDAO();

    public ArrayList<Class> getAllClass() {
        return classDAO.getAllClass();
    }

    public boolean addClass(Class class1) {
        for (Class cl : classDAO.getAllClass()) {
            if (cl.getClassName().equals(class1.getClassName())) {
                if (cl.getShoolyear().equals(class1.getShoolyear())) {
                    return false;
                } else {
                    return classDAO.addClass(class1);
                }
            } else {
                if (cl.getShoolyear().equals(class1.getShoolyear())) {
                    if (cl.getTeacherID().equals(class1.getTeacherID())) {
                        return false;
                    }
                }
            }
        }
        return classDAO.addClass(class1);
    }

    public boolean deleteClass(Class class1) {
        return classDAO.deleteClass(class1);
    }

    public boolean editClass(Class class1) {
        return classDAO.editClass(class1);
    }

    public Class getClassByID(String classID) {
        for (Class class1 : classDAO.getAllClass()) {
            if (class1.getClassID().equals(classID)) {
                return class1;
            }
        }
        return null;
    }

    public Class getClassByTeacherID(String teacherID) {
        for (Class class1 : classDAO.getAllClass()) {
            if (class1.getTeacherID().equals(teacherID)) {
                return class1;
            }
        }
        return null;
    }

    public ArrayList<Class> getClassFactor(String[] factor) {
        return classDAO.getClassFactor(factor);
    }

    public boolean updateQuantity(int count, String classID) {
        {
            return classDAO.updateQuantity(count, classID);
        }
    }
}
