/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/*
 * @author LENOVO
 */
import DTO.Class;
import java.sql.*;
import java.util.ArrayList;

public class ClassDAO extends DatabaseConnection {

    public ArrayList<Class> getAllClass() {
        ArrayList<Class> classList = new ArrayList<Class>();
        open();
        try {
            String sql = "SELECT * FROM Class ORDER BY SchoolYear_ID desc";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Class class1 = new Class();
                class1.setClassID(rs.getString("Class_ID"));
                class1.setClassName(rs.getString("Class_Name"));
                class1.setGradeID(rs.getString("Grade_ID"));
                class1.setQuantity(rs.getInt("Quantity"));
                class1.setShoolyear(rs.getString("SchoolYear_ID"));
                class1.setTeacherID(rs.getString("Teacher_ID"));
                classList.add(class1);
            }
            return classList;
        } catch (SQLException ex) {
            System.out.println("Lỗi select class");
        } finally {
            close();
        }

        return classList;
    }

    public boolean addClass(Class class1) {
        Boolean result = false;
        open();
        String sql = "INSERT INTO Class VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, class1.getClassID());
            pstm.setString(2, class1.getClassName());
            pstm.setString(3, class1.getGradeID());
            pstm.setInt(4, class1.getQuantity());
            pstm.setString(5, class1.getShoolyear());
            pstm.setString(6, class1.getTeacherID());

            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error insert: " + ex.toString());
        } finally {
            close();
        }
        return result;
    }

    public boolean editClass(Class class1) {
        Boolean result = false;
        open();
        String sql = "UPDATE [Class] SET Class_Name = ?, Grade_ID = ?, Quantity = ?, SchoolYear_ID = ?, Teacher_ID = ?  WHERE Class_ID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, class1.getClassName());
            pstm.setString(2, class1.getGradeID());
            pstm.setInt(3, class1.getQuantity());
            pstm.setString(4, class1.getShoolyear());
            pstm.setString(5, class1.getTeacherID());
            pstm.setString(6, class1.getClassID());

            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error update: " + ex.toString());
        } finally {
            close();
        }
        return result;
    }

    public boolean deleteClass(Class class1) {
        boolean result = false;
        open();
        String sql = "DELETE FROM Class WHERE Class_ID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, class1.getClassID());
            int n = pstm.executeUpdate();
            if (n > 0) {
                result = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error delete : " + ex.toString());
        }
        return result;
    }


    public ArrayList<Class> getClassFactor(String[] factor) {
        ArrayList<Class> classList = new ArrayList<Class>();
        open();
        System.out.println(factor[0] + factor[1] + factor[2] + factor[3]);
        try {
            String sql = "SELECT * FROM Class WHERE SchoolYear_ID LIkE ? AND Grade_ID LIKE ? ";
            String sqlClass_ID = "SELECT * FROM Class WHERE SchoolYear_ID LIkE ? AND Grade_ID LIKE ? ORDER BY Class_ID";
            String sqlClass_ID_D = "SELECT * FROM Class WHERE SchoolYear_ID LIkE ? AND Grade_ID LIKE ? ORDER BY Class_ID DESC";
            String sqlClass_Name = "SELECT * FROM Class WHERE SchoolYear_ID LIkE ? AND Grade_ID LIKE ? ORDER BY Class_Name";
            String sqlClass_Name_D = "SELECT * FROM Class WHERE SchoolYear_ID LIkE ? AND Grade_ID LIKE ? ORDER BY Class_ID DESC";
            String sqlGrade_ID = "SELECT * FROM Class WHERE SchoolYear_ID LIkE ? AND Grade_ID LIKE ? ORDER BY Grade_ID";
            String sqlGrade_ID_D = "SELECT * FROM Class WHERE SchoolYear_ID LIkE ? AND Grade_ID LIKE ? ORDER BY Grade_ID DESC";
            String sqlQuantity = "SELECT * FROM Class WHERE SchoolYear_ID LIkE ? AND Grade_ID LIKE ? ORDER BY Quantity";
            String sqlQuantity_D = "SELECT * FROM Class WHERE SchoolYear_ID LIkE ? AND Grade_ID LIKE ? ORDER BY Quantity DESC";
            String sqlTeacher_ID = "SELECT * FROM Class WHERE SchoolYear_ID LIkE ? AND Grade_ID LIKE ? ORDER BY Teacher_ID";
            String sqlTeacher_ID_D = "SELECT * FROM Class WHERE SchoolYear_ID LIkE ? AND Grade_ID LIKE ? ORDER BY Teacher_ID DESC";
            PreparedStatement pstm;
            if (factor[2] == "Mã Lớp" && factor[3] == "Rise") {
                pstm = conn.prepareStatement(sqlClass_ID);
            } else if (factor[2] == "Mã Lớp" && factor[3] == "Low") {
                pstm = conn.prepareStatement(sqlClass_ID_D);
            } else if (factor[2] == "Tên lớp" && factor[3] == "Rise") {
                pstm = conn.prepareStatement(sqlClass_Name);
            } else if (factor[2] == "Tên lớp" && factor[3] == "Low") {
                pstm = conn.prepareStatement(sqlClass_Name_D);
            } else if (factor[2] == "KHối" && factor[3] == "Rise") {
                pstm = conn.prepareStatement(sqlGrade_ID);
            } else if (factor[2] == "KHối" && factor[3] == "Low") {
                pstm = conn.prepareStatement(sqlGrade_ID_D);
            } else if (factor[2] == "SL Học sinh" && factor[3] == "Rise") {
                pstm = conn.prepareStatement(sqlQuantity);
            } else if (factor[2] == "SL Học sinh" && factor[3] == "Low") {
                pstm = conn.prepareStatement(sqlQuantity_D);
            } else if (factor[2] == "Giáo viên" && factor[3] == "Rise") {
                pstm = conn.prepareStatement(sqlTeacher_ID);
            } else if (factor[2] == "Giáo viên" && factor[3] == "Low") {
                pstm = conn.prepareStatement(sqlTeacher_ID_D);
            } else {
                pstm = conn.prepareStatement(sql);
            }

            if (factor[0] != " ") {
                pstm.setString(1, factor[0]);
            } else {
                pstm.setString(1, "%");
            }
            if (factor[1] != " ") {
                pstm.setString(2, factor[1]);
            } else {
                pstm.setString(2, "%");
            }
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Class class1 = new Class();
                class1.setClassID(rs.getString("Class_ID"));
                class1.setClassName(rs.getString("Class_Name"));
                class1.setGradeID(rs.getString("Grade_ID"));
                class1.setQuantity(rs.getInt("Quantity"));
                class1.setShoolyear(rs.getString("SchoolYear_ID"));
                class1.setTeacherID(rs.getString("Teacher_ID"));
                classList.add(class1);
            }
            return classList;
        } catch (SQLException ex) {
            System.out.println("Lỗi select class");
        } finally {
            close();
        }

        return classList;
    }
    
    
    public boolean updateQuantity(int count, String classID) {
        try {
            open();
            String sql = "UPDATE [Class] SET QUANTITY = ? WHERE Class_ID = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, count);
            pstm.setString(2, classID);
            int n = pstm.executeUpdate();
            return n > 0;
        } 
        catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return false;
    }
//    public ArrayList<Class> getClassFactors(String[] factor ) {
//        ArrayList<Class> classList = new ArrayList<Class>();
//        open();
//        try {
//            String sql = "SELECT * FROM Class WHERE SchoolYear_ID LIkE ? AND Grade_ID LIKE ? ";
//            PreparedStatement pstm = conn.prepareStatement(sql);
//            String a="desc";
////            pstm.setString(3, a);
//            if(factor[0] != " ")
//                pstm.setString(1, factor[0]);
//            else
//                pstm.setString(1, "%");
//            if(factor[1] != " "){
//                pstm.setString(2,factor[1]);
//            }else
//                pstm.setString(2, "%");
//            ResultSet rs = pstm.executeQuery();
//            while (rs.next()) {
//                Class class1 = new Class();
//                class1.setClassID(rs.getString("Class_ID"));
//                class1.setClassName(rs.getString("Class_Name"));
//                class1.setGradeID(rs.getString("Grade_ID"));
//                class1.setQuantity(rs.getInt("Quantity"));
//                class1.setShoolyear(rs.getString("SchoolYear_ID"));
//                class1.setTeacherID(rs.getString("Teacher_ID"));
//                classList.add(class1);
//            }
//            return classList;
//        } catch (SQLException ex) {
//            System.out.println("Lỗi select class");
//        } finally {
//            close();
//        }
//
//        return classList;
//    }

}
