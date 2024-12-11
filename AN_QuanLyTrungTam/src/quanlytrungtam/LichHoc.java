/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlytrungtam;

/**
 *
 * @author LENOVO
 */
import java.util.Date;

public class LichHoc {
    private String maLichHoc; // Ma lich hoc
    private KhoaHoc khoaHoc; // Khoa hoc
    private GiaoVien giaoVien; // Giao vien day
    private PhongHoc phongHoc; // Phong hoc
    private Date khungGio; // Thoi gian hoc

    // Constructor
    public LichHoc(String maLichHoc, KhoaHoc khoaHoc, GiaoVien giaoVien, PhongHoc phongHoc, Date khungGio) {
        this.maLichHoc = maLichHoc;
        this.khoaHoc = khoaHoc;
        this.giaoVien = giaoVien;
        this.phongHoc = phongHoc;
        this.khungGio = khungGio;
    }

    // Getter va Setter
    public String getMaLichHoc() {
        return maLichHoc;
    }

    public void setMaLichHoc(String maLichHoc) {
        this.maLichHoc = maLichHoc;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public GiaoVien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(GiaoVien giaoVien) {
        this.giaoVien = giaoVien;
    }

    public PhongHoc getPhongHoc() {
        return phongHoc;
    }

    public void setPhongHoc(PhongHoc phongHoc) {
        this.phongHoc = phongHoc;
    }

    public Date getKhungGio() {
        return khungGio;
    }

    public void setKhungGio(Date khungGio) {
        this.khungGio = khungGio;
    }

    // Phuong thuc tao lich hoc
    public void taoLichHoc(KhoaHoc khoaHoc, GiaoVien giaoVien, PhongHoc phongHoc, Date khungGio) {
        this.khoaHoc = khoaHoc;
        this.giaoVien = giaoVien;
        this.phongHoc = phongHoc;
        this.khungGio = khungGio;
        System.out.println("Da tao lich hoc: ");
        System.out.println(" - Khoa hoc: " + khoaHoc.getTenKhoaHoc());
        System.out.println(" - Giao vien: " + giaoVien.getHoTen());
        System.out.println(" - Phong hoc: " + phongHoc.getMaPhong());
        System.out.println(" - Thoi gian: " + khungGio);
    }

    // Phuong thuc hien thi thong tin lich hoc
    public void hienThiLichHoc() {
        System.out.println("Thong tin lich hoc:");
        System.out.println(" - Ma lich hoc: " + maLichHoc);
        System.out.println(" - Khoa hoc: " + khoaHoc.getTenKhoaHoc());
        System.out.println(" - Giao vien: " + giaoVien.getHoTen());
        System.out.println(" - Phong hoc: " + phongHoc.getMaPhong());
        System.out.println(" - Thoi gian: " + khungGio);
    }

    // Phuong thuc cap nhat lich hoc
    public void capNhatLichHoc(KhoaHoc khoaHoc, GiaoVien giaoVien, PhongHoc phongHoc, Date khungGio) {
        this.khoaHoc = khoaHoc;
        this.giaoVien = giaoVien;
        this.phongHoc = phongHoc;
        this.khungGio = khungGio;
        System.out.println("Lich hoc da duoc cap nhat.");
    }

    // Phuong thuc huy lich hoc
    public void huyLichHoc() {
        this.khoaHoc = null;
        this.giaoVien = null;
        this.phongHoc = null;
        this.khungGio = null;
        System.out.println("Lich hoc da bi huy.");
    }
}
