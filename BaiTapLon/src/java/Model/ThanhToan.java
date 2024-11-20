/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author xuant
 */
public class ThanhToan {
    private int maThanhToan;
    private double soTien;
    private int maDonHang;
    private String trangThai; // Trạng thái thanh toán (VD: "chua thanh toan", "da thanh toan")

    // Constructor
    public ThanhToan(int maThanhToan, double soTien, int maDonHang, String trangThai) {
        this.maThanhToan = maThanhToan;
        this.soTien = soTien;
        this.maDonHang = maDonHang;
        this.trangThai = trangThai;
    }

    // Getters và Setters
    public int getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(int maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}

