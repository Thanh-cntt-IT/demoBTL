/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.MonAn;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DAO.DBConnetion;
public class MonAnDAO {
    private Connection connection;

    public MonAnDAO() {
        // Kết nối đến cơ sở dữ liệu (giả sử bạn đã có hàm kết nối)
        connection = DBConnetion.getConnection();
    }

    // 1. Thêm món ăn
    public boolean addMonAn(MonAn monAn) {
        String sql = "INSERT INTO thucdon (TenMonAn, GiaThanh, Danhmuc) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, monAn.getTenMonAn());
            statement.setDouble(2, monAn.getGia());
            statement.setString(3, monAn.getDanhMuc());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 2. Sửa món ăn
    public boolean updateMonAn(MonAn monAn) {
        String sql = "UPDATE thucdon SET TenMonAn = ?,  GiaThanh = ?, Danhmuc = ? WHERE MaMonAn = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, monAn.getTenMonAn());
            statement.setDouble(2, monAn.getGia());
            statement.setString(3, monAn.getDanhMuc());
            statement.setInt(4, monAn.getMaMonAn());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
public MonAn getMonAnById(int maMonAn) {
    String sql = "SELECT * FROM thucdon WHERE MaMonAn = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, maMonAn);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new MonAn(
                resultSet.getInt("MaMonAn"),
                resultSet.getString("TenMonAn"),
                resultSet.getDouble("GiaThanh"),
                resultSet.getString("Danhmuc")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

    // 3. Xóa món ăn
    public boolean deleteMonAn(int maMonAn) {
        String sql = "DELETE FROM thucdon WHERE MaMonAn = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maMonAn);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 4. Lấy danh sách món ăn
    public List<MonAn> getAllMonAn() {
        List<MonAn> list = new ArrayList<>();
        String sql = "SELECT * FROM thucdon";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                MonAn monAn = new MonAn(
                    resultSet.getInt("MaMonAn"),
                    resultSet.getString("TenMonAn"),
                    resultSet.getDouble("GiaThanh"),
                    resultSet.getString(" Danhmuc")
                );
                list.add(monAn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

