/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author M S I
 */
public class Subject {
    private String subjectID;
    private String subjectName;
    private int coefficient;
    private int numberOfLesson;

    public Subject() {
    }

    public Subject(String subjectID, String subjectName, int coefficient, int numberOfLesson) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.coefficient = coefficient;
        this.numberOfLesson = numberOfLesson;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getNumberOfLesson() {
        return numberOfLesson;
    }

    public void setNumberOfLesson(int numberOfLesson) {
        this.numberOfLesson = numberOfLesson;
    }

    @Override
    public String toString() {
        return "Subject{" + "subjectID=" + subjectID + ", subjectName=" + subjectName + ", coefficient=" + coefficient + ", numberOfLesson=" + numberOfLesson + '}';
    }

    
        
    
}
