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



public class TaiKhoan {
    private static List<HocVien> danhSachHocVien = new ArrayList<>();
    private static List<GiaoVien> danhSachGiaoVien = new ArrayList<>();

    // Đăng ký học viên
    public static void dangKyHocVien(Scanner scanner) {
        System.out.println("=== DANG KY TAI KHOAN HOC VIEN ===");
        System.out.print("Nhap ho ten: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhap gioi tinh: ");
        String gioiTinh = scanner.nextLine();
        System.out.print("Nhap so dien thoai: ");
        String soDienThoai = scanner.nextLine();
        System.out.print("Nhap email: ");
        String email = scanner.nextLine();

        // Nhập mật khẩu và xác nhận mật khẩu
        String matKhau;
        while (true) {
            System.out.print("Nhap mat khau: ");
            matKhau = scanner.nextLine();
            System.out.print("Xac nhan lai mat khau: ");
            String xacNhanMatKhau = scanner.nextLine();
            if (matKhau.equals(xacNhanMatKhau)) {
                break;
            } else {
                System.out.println("Mat khau xac nhan khong khop. Vui long thu lai.");
            }
        }

        HocVien hocVien = new HocVien(hoTen, gioiTinh, soDienThoai, email, new Date());
        hocVien.setMatKhau(matKhau); // Lưu mật khẩu vào đối tượng
        danhSachHocVien.add(hocVien);

        System.out.println("Dang ky thanh cong!");
        System.out.println("Thong tin tai khoan vua dang ky:");
        hocVien.hienThiThongTin();
    }

    // Đăng ký giáo viên
    public static void dangKyGiaoVien(Scanner scanner) {
        System.out.println("=== DANG KY TAI KHOAN GIAO VIEN ===");
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

        // Nhập mật khẩu và xác nhận mật khẩu
        String matKhau;
        while (true) {
            System.out.print("Nhap mat khau: ");
            matKhau = scanner.nextLine();
            System.out.print("Xac nhan lai mat khau: ");
            String xacNhanMatKhau = scanner.nextLine();
            if (matKhau.equals(xacNhanMatKhau)) {
                break;
            } else {
                System.out.println("Mat khau xac nhan khong khop. Vui long thu lai.");
            }
        }

        GiaoVien giaoVien = new GiaoVien(hoTen, gioiTinh, soDienThoai, email, chuyenMon);
        giaoVien.setMatKhau(matKhau); // Lưu mật khẩu vào đối tượng
        danhSachGiaoVien.add(giaoVien);

        System.out.println("Dang ky thanh cong!");
        System.out.println("Thong tin tai khoan vua dang ky:");
        giaoVien.hienThiThongTin();
    }

    // Lấy danh sách học viên
    public static List<HocVien> getDanhSachHocVien() {
        return danhSachHocVien;
    }

    // Lấy danh sách giáo viên
    public static List<GiaoVien> getDanhSachGiaoVien() {
        return danhSachGiaoVien;
    }
}


