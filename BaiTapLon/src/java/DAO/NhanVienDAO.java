/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author xuant
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import DAO.DBConnetion;
import Model.NhanVien;
public class NhanVienDAO {

    // Phương thức thêm mới nhân viên
    public boolean addEmployee(NhanVien nhanVien) {
        String sql = "INSERT INTO nhanvien (hoTen, ngaySinh, diaChi, trinhDoChuyenMon, maKhoa, chucVu) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnetion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nhanVien.getHoTen());
            stmt.setDate(2, new Date(nhanVien.getNgaySinh().getTime()));
            stmt.setString(3, nhanVien.getDiaChi());
            stmt.setString(4, nhanVien.getTrinhDoChuyenMon());
            stmt.setInt(5, nhanVien.getMaKhoa());
            stmt.setString(6, nhanVien.getChucVu());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Phương thức lấy thông tin nhân viên theo ID
    public NhanVien getEmployeeById(int id) {
        String sql = "SELECT * FROM nhanvien WHERE MaNhanVien = ?";
        try (Connection conn = DBConnetion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new NhanVien(
                    rs.getInt("maNhanVien"),
                    rs.getString("hoTen"),
                    rs.getDate("ngaySinh"),
                    rs.getString("diaChi"),
                    rs.getString("trinhDoChuyenMon"),
                    rs.getInt("maKhoa"),
                    rs.getString("chucVu")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Phương thức lấy danh sách tất cả nhân viên
    public List<NhanVien> getAllEmployees() {
        List<NhanVien> employees = new ArrayList<>();
        String sql = "SELECT * FROM nhanvien";
        try (Connection conn = DBConnetion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                NhanVien employee = new NhanVien(
                    rs.getInt("MaNhanVien"),
                    rs.getString("HoTen"),
                    rs.getDate("NgaySinh"),
                    rs.getString("DiaChi"),
                    rs.getString("trinhDoChuyenMon"),
                    rs.getInt("MaKhoa"),
                    rs.getString("ChucVu")
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Phương thức cập nhật thông tin nhân viên
    public boolean updateEmployee(NhanVien nhanVien) {
        String sql = "UPDATE nhanvien SET HoTen = ?, NgaySinh = ?, DiaChi = ?, trinhDoChuyenMon = ?, MaKhoa = ?, ChucVu = ? WHERE MaNhanVien = ?";
        try (Connection conn = DBConnetion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nhanVien.getHoTen());
            stmt.setDate(2, new Date(nhanVien.getNgaySinh().getTime()));
            stmt.setString(3, nhanVien.getDiaChi());
            stmt.setString(4, nhanVien.getTrinhDoChuyenMon());
            stmt.setInt(5, nhanVien.getMaKhoa());
            stmt.setString(6, nhanVien.getChucVu());
            stmt.setInt(7, nhanVien.getMaNhanVien());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Phương thức xóa nhân viên
    public boolean deleteEmployee(int maNhanVien) {
        String sql = "DELETE FROM nhanvien WHERE MaNhanVien = ?";
        try (Connection conn = DBConnetion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maNhanVien);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
