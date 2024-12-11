/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlytrungtam_hung;

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;
import java.util.List;

public class KhoaHoc {
    private String maKhoaHoc; // Ma khoa hoc
    private String tenKhoaHoc; // Ten khoa hoc
    private int thoiLuong; // Thoi luong tinh theo so gio
    private GiaoVien giaoVien; // Giao vien phu trach
    private List<HocVien> danhSachHocVien = new ArrayList<>(); // Danh sach hoc vien

    // Constructor
    public KhoaHoc(String maKhoaHoc, String tenKhoaHoc, int thoiLuong, GiaoVien giaoVien) {
        this.maKhoaHoc = maKhoaHoc;
        this.tenKhoaHoc = tenKhoaHoc;
        this.thoiLuong = thoiLuong;
        this.giaoVien = giaoVien;
    }

    // Getter va Setter
    public String getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public GiaoVien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(GiaoVien giaoVien) {
        this.giaoVien = giaoVien;
    }

    public List<HocVien> getDanhSachHocVien() {
        return danhSachHocVien;
    }

    // Phuong thuc
    public void themHocVien(HocVien hocVien) {
        danhSachHocVien.add(hocVien);
        System.out.println("Hoc vien " + hocVien.getHoTen() + " da duoc them vao khoa hoc " + tenKhoaHoc);
    }

    public void xoaHocVien(HocVien hocVien) {
        danhSachHocVien.remove(hocVien);
        System.out.println("Hoc vien " + hocVien.getHoTen() + " da bi xoa khoi khoa hoc " + tenKhoaHoc);
    }

    public void hienThiThongTin() {
        System.out.println("Khoa hoc: " + tenKhoaHoc + ", Thoi luong: " + thoiLuong + " gio, Giao vien: " + giaoVien.getHoTen());
    }
}

