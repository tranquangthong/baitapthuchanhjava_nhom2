/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlytrungtam;

/**
 *
 * @author LENOVO
 */
import java.util.*;

public class NguoiQuanLy {
    private String tenQuanLy; // Tên người quản lý

    // Constructor
    public NguoiQuanLy(String tenQuanLy) {
        this.tenQuanLy = tenQuanLy;
    }

    // Getter và Setter
    public String getTenQuanLy() {
        return tenQuanLy;
    }

    public void setTenQuanLy(String tenQuanLy) {
        this.tenQuanLy = tenQuanLy;
    }

    // Đăng ký giáo viên mới
    public void dangKyGiaoVien(Scanner scanner, List<GiaoVien> danhSachGiaoVien) {
        System.out.println("=== DANG KY TAI KHOAN GIAO VIEN ===");
        System.out.print("Nhap ho ten giao vien: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhap gioi tinh giao vien: ");
        String gioiTinh = scanner.nextLine();
        System.out.print("Nhap so dien thoai giao vien: ");
        String soDienThoai = scanner.nextLine();
        System.out.print("Nhap email giao vien: ");
        String email = scanner.nextLine();
        System.out.print("Nhap chuyen mon giao vien: ");
        String chuyenMon = scanner.nextLine();

        GiaoVien giaoVien = new GiaoVien(hoTen, gioiTinh, soDienThoai, email, chuyenMon);
        danhSachGiaoVien.add(giaoVien);
        System.out.println("Dang ky thanh cong! Giao vien " + hoTen + " da duoc them vao he thong.");
    }

    // Hiển thị danh sách giáo viên
    public void hienThiDanhSachGiaoVien(List<GiaoVien> danhSachGiaoVien) {
        System.out.println("=== DANH SACH GIAO VIEN ===");
        if (danhSachGiaoVien.isEmpty()) {
            System.out.println("Khong co giao vien nao trong he thong.");
        } else {
            for (GiaoVien gv : danhSachGiaoVien) {
                System.out.println("- Ho ten: " + gv.getHoTen() + ", Chuyen mon: " + gv.getChuyenMon());
            }
        }
    }
}

