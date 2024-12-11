/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlytrungtam_hung;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TaiKhoan {
    private static List<HocVien> danhSachHocVien = new ArrayList<>();
    private static List<GiaoVien> danhSachGiaoVien = new ArrayList<>();

    // Dang ky tai khoan hoc vien
    public static void dangKyHocVien(Scanner scanner) {
        System.out.println("\n=== DANG KY TAI KHOAN HOC VIEN ===");
        System.out.print("Nhap ho ten: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhap gioi tinh: ");
        String gioiTinh = scanner.nextLine();
        System.out.print("Nhap so dien thoai: ");
        String soDienThoai = scanner.nextLine();
        System.out.print("Nhap email: ");
        String email = scanner.nextLine();
        System.out.print("Nhap mat khau: ");
        String matKhau = scanner.nextLine();

        HocVien hocVien = new HocVien(hoTen, gioiTinh, soDienThoai, email, new Date());
        hocVien.setMatKhau(matKhau);
        danhSachHocVien.add(hocVien);
        System.out.println("Dang ky thanh cong!");
        hocVien.hienThiThongTin();
    }

    // Dang ky tai khoan giao vien
    public static void dangKyGiaoVien(Scanner scanner) {
        System.out.println("\n=== DANG KY TAI KHOAN GIAO VIEN ===");
        System.out.print("Nhap ho ten: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhap gioi tinh: ");
        String gioiTinh = scanner.nextLine();
        System.out.print("Nhap so dien thoai: ");
        String soDienThoai = scanner.nextLine();
        System.out.print("Nhap email: ");
        String email = scanner.nextLine();
        System.out.print("Nhap chuyen mon: ");
        String chuyenMon = scanner.nextLine();
        System.out.print("Nhap mat khau: ");
        String matKhau = scanner.nextLine();

        GiaoVien giaoVien = new GiaoVien(hoTen, gioiTinh, soDienThoai, email, chuyenMon);
        giaoVien.setMatKhau(matKhau);
        danhSachGiaoVien.add(giaoVien);

        System.out.println("Dang ky thanh cong!");
        giaoVien.hienThiThongTin();
    }

    // Lay danh sach hoc vien
    public static List<HocVien> getDanhSachHocVien() {
        return danhSachHocVien;
    }

    // Lay danh sach giao vien
    public static List<GiaoVien> getDanhSachGiaoVien() {
        return danhSachGiaoVien;
    }
}



