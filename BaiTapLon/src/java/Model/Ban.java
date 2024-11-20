/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author xuant
 */
public class Ban {
    private int maBan;
    private String trangThai; // Trạng thái của bàn (VD: "trong", "co khach")

    // Constructor
    public Ban(int maBan, String trangThai) {
        this.maBan = maBan;
        this.trangThai = trangThai;
    }

    // Getters và Setters
    public int getMaBan() {
        return maBan;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}

