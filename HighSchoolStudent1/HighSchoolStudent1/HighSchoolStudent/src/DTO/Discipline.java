/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author M S I
 */
public class Discipline {
    private String Dis_ID;
    private String Dis_Content;
    private float Dis_Score;

    public Discipline() {
    }

    public Discipline(String Dis_ID, String Dis_Content,float Dis_Score) {
        this.Dis_ID = Dis_ID;
        this.Dis_Content = Dis_Content;
        this.Dis_Score = Dis_Score;
    }

    public String getDis_ID() {
        return Dis_ID;
    }

    public void setDis_ID(String Dis_ID) {
        this.Dis_ID = Dis_ID;
    }

    public String getDis_Content() {
        return Dis_Content;
    }

    public void setDis_Content(String Dis_Content) {
        this.Dis_Content = Dis_Content;
    }
    
    public float getDis_Score() {
        return Dis_Score;
    }
        
    public void setDis_Score(float Dis_Score) {
        this.Dis_Score = Dis_Score;
    }

    @Override
    public String toString() {
        return "Discipline{" + "Dis_ID=" + Dis_ID + ", Dis_Content=" + Dis_Content + ", Dis_Score=" + Dis_Score + '}';
    }



    
    
}
