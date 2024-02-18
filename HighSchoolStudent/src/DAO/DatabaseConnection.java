/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author M S I
 */
public class DatabaseConnection {
    protected Connection conn;
    
    public void open() {
        try {
            // Đăng ký driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SMS_Java;user=sa;password=123456@@;serverTimezone=UTC");
            System.out.println("Kết nối thành công" + this.conn.getCatalog());

        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi : " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Lỗi : " + ex.toString());
        }
    }

    public void close() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            System.out.println("Lỗi : " + ex.toString());
        }
    }
}
