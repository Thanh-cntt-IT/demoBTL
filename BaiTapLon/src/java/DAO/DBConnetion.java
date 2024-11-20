/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnetion {
    private static String URL = "jdbc:mysql://localhost:3306/restaurant"; // Địa chỉ CSDL
    private static String USERNAME = "root"; // Tên đăng nhập CSDL
    private static String PASSWORD = ""; // Mật khẩu CSDL

    // Phương thức kết nối đến cơ sở dữ liệu
    public static Connection getConnection() {
      Connection conn=null;
        try {
            // Tải driver của MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Khởi tạo kết nối
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Phương thức đóng kết nối
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

