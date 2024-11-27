/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlytrungtam;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
// Lớp Nguoi không cần mã người chung
public abstract class Nguoi {
    private String hoTen;
    private String gioiTinh;
    private String soDienThoai;
    private String email;
    private String matKhau;

    public Nguoi(String hoTen, String gioiTinh, String soDienThoai, String email) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getMatKhau(){
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    // Phương thức đổi mật khẩu
    public void doiMatKhau(Scanner scanner) {
        System.out.print("Nhap mat khau hien tai: ");
        String matKhauHienTai = scanner.nextLine();
        if (!matKhauHienTai.equals(matKhau)) {
            System.out.println("Mat khau hien tai khong chinh xac!");
            return;
        }

        System.out.print("Nhap mat khau moi: ");
        String matKhauMoi = scanner.nextLine();
        System.out.print("Xac nhan mat khau moi: ");
        String xacNhanMatKhauMoi = scanner.nextLine();

        if (matKhauMoi.equals(xacNhanMatKhauMoi)) {
            setMatKhau(matKhauMoi);
            System.out.println("Doi mat khau thanh cong!");
        } else {
            System.out.println("Mat khau moi va xac nhan mat khau khong khop!");
        }
    }
    public abstract void hienThiThongTin();
}

