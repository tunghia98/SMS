/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author M S I
 */
public class TeachingAssignment {
    private String id;
    private String teacherID;
    private String classID;
    private String subjectID;
    private String schoolYearID;
    private String dayOfWeek;
    private int period;

    public TeachingAssignment() {
    }

    public TeachingAssignment(String id, String teacherID, String classID, String subjectID, String schoolYearID, String dayOfWeek, int period) {
        this.id = id;
        this.teacherID = teacherID;
        this.classID = classID;
        this.subjectID = subjectID;
        this.schoolYearID = schoolYearID;
        this.dayOfWeek = dayOfWeek;
        this.period = period;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSchoolYearID() {
        return schoolYearID;
    }

    public void setSchoolYearID(String schoolYearID) {
        this.schoolYearID = schoolYearID;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "TeachingAssignment{" + "id=" + id + ", teacherID=" + teacherID + ", classID=" + classID + ", subjectID=" + subjectID + ", schoolYearID=" + schoolYearID + ", dayOfWeek=" + dayOfWeek + ", period=" + period + '}';
    }
    
    

    
    
}

