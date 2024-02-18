/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author M S I
 */
public class StudentDis {

    private String studentID;
    private String studentName;
    private Float Score;
    private String result;

    public StudentDis() {
    }

    public StudentDis(String studentID, String studentName, Float Score, String result) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.Score = Score;
        this.result = result;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Float getScore() {
        return Score;
    }

    public void setScore(Float Score) {
        this.Score = Score;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
