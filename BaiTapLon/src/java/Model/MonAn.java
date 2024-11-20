/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author xuant
 */
public class MonAn {
    private int maMonAn;
    private String tenMonAn;
    private double gia;
    private String danhMuc; // Danh mục của món ăn (VD: "do uong", "mon chinh")

    public MonAn() {
    }

    // Constructor
    public MonAn(int maMonAn, String tenMonAn, double gia, String danhMuc) {
        this.maMonAn = maMonAn;
        this.tenMonAn = tenMonAn;
        this.gia = gia;
        this.danhMuc = danhMuc;
    }

    // Getters và Setters
    public int getMaMonAn() {
        return maMonAn;
    }

    public void setMaMonAn(int maMonAn) {
        this.maMonAn = maMonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }
}
