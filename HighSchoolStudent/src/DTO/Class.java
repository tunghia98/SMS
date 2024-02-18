/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author M S I
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Class {
    private String classID;
    private String className;
    private String gradeID;
    private int quantity;
    private String shoolyear;
    private String teacherID;
    
    
    public Class() {
    }

    public Class(String classID, String className, String gradeID, int quantity, String shoolyear, String teacherID) {
        this.classID = classID;
        this.className = className;
        this.gradeID = gradeID;
        this.quantity = quantity;
        this.shoolyear = shoolyear;
        this.teacherID = teacherID;
    }
    

    
    
    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getGradeID() {
        return gradeID;
    }

    public void setGradeID(String gradeID) {
        this.gradeID = gradeID;
    }

    public String getShoolyear() {
        return shoolyear;
    }

    public void setShoolyear(String shoolyear) {
        this.shoolyear = shoolyear;
    }

    @Override
    public String toString() {
        return "Class{" + "classID=" + classID + ", className=" + className + ", gradeID=" + gradeID + ", quantity=" + quantity + ", shoolyear=" + shoolyear + ", teacherID=" + teacherID + '}';
    }
    
    
    

}
