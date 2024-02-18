/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author M S I
 */
public class Mark {
    private String studentID;
    private String studentName;
    private String TeacherId;
    private Float  Mark_1;
    private Float  Mark_2;
    private Float  Mark_15;
    private Float  Mark_45;
    private Float  Mark_end;
    private Float  Mark_avg;
    public Mark () {
        
    }

    public Mark(String studentID, String studentName, String TeacherId, Float Mark_1, Float Mark_2, Float Mark_15, Float Mark_45, Float Mark_end, Float Mark_avg) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.TeacherId = TeacherId;
        this.Mark_1 = Mark_1;
        this.Mark_2 = Mark_2;
        this.Mark_15 = Mark_15;
        this.Mark_45 = Mark_45;
        this.Mark_end = Mark_end;
        this.Mark_avg = Mark_avg;
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

    public String getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(String TeacherId) {
        this.TeacherId = TeacherId;
    }

    public Float getMark_1() {
        return Mark_1;
    }

    public void setMark_1(Float Mark_1) {
        this.Mark_1 = Mark_1;
    }

    public Float getMark_2() {
        return Mark_2;
    }

    public void setMark_2(Float Mark_2) {
        this.Mark_2 = Mark_2;
    }

    public Float getMark_15() {
        return Mark_15;
    }

    public void setMark_15(Float Mark_15) {
        this.Mark_15 = Mark_15;
    }

    public Float getMark_45() {
        return Mark_45;
    }

    public void setMark_45(Float Mark_45) {
        this.Mark_45 = Mark_45;
    }

    public Float getMark_end() {
        return Mark_end;
    }

    public void setMark_end(Float Mark_end) {
        this.Mark_end = Mark_end;
    }

    public Float getMark_avg() {
        return Mark_avg;
    }

    public void setMark_avg(Float Mark_avg) {
        this.Mark_avg = Mark_avg;
    }
}
