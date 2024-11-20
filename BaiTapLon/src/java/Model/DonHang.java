/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author xuant
 */
import java.util.ArrayList;
import java.util.List;

public class DonHang {
    private int maDonHang;
    private int maBan;
    private List<MonAn> danhSachMonAn;
    private String trangThai; // Trạng thái đơn hàng (VD: "dang xu ly", "hoan thanh")

    // Constructor
    public DonHang(int maBan) {
        this.maBan = maBan;
        this.danhSachMonAn = new ArrayList<>();
        this.trangThai = "dang xu ly";
    }

    // Phương thức thêm món ăn vào đơn hàng
    public void themMonAn(MonAn monAn) {
        this.danhSachMonAn.add(monAn);
    }

    // Getters và Setters
    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public int getMaBan() {
        return maBan;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public List<MonAn> getDanhSachMonAn() {
        return danhSachMonAn;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}

