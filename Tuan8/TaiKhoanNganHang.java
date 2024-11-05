/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taikhoan;

import java.util.ArrayList;
import java.util.List;

public abstract class TaiKhoanNganHang implements ITaiKhoan {
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private String matKhau;
    private String soDienThoai;
    private double soDu;

    public TaiKhoanNganHang(String soTaiKhoan, String chuTaiKhoan, String matKhau, String soDienThoai) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.matKhau = matKhau;
        this.soDienThoai = soDienThoai;
        this.soDu = 0;
    }

    public void guiTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Gui tien thanh cong. So du hien tai: " + soDu);
        } else {
            System.out.println("So tien gui khong hop le.");
        }
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setPassword(String newPassword) {
        this.matKhau = newPassword;
    }

    // Phương thức trừu tượng để các lớp con phải triển khai
    public abstract boolean rutTien(double soTien);
    public abstract void hienThiMenu();
}

