/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thuchanhtuan7;

/**
 *
 * @author LENOVO
 */
public class SinhVien {
    private String maSinhVien;
    private String ten;
    private String ngaySinh;
    private double diemTrungBinh;

    // Constructor
    public SinhVien(String maSinhVien, String ten, String ngaySinh, double diemTrungBinh) {
        this.maSinhVien = maSinhVien;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        setDiemTrungBinh(diemTrungBinh);
    }

    // Đảm bảo điểm trung bình hợp lệ
    public void setDiemTrungBinh(double diemTrungBinh) {
        if (diemTrungBinh >= 0 && diemTrungBinh <= 10) {
            this.diemTrungBinh = diemTrungBinh;
        } else {
            System.out.println("Diem trung binh phai lon hon hoac bang 0 va nho hon hoac bang 10!");
        }
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }
    public String xepLoai() {
        if (diemTrungBinh >= 8) {
            return "Giỏi";
        } else if (diemTrungBinh >= 6.5) {
            return "Khá";
        } else if (diemTrungBinh >= 5) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }

}
