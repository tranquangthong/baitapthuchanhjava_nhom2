/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taikhoan;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class HeThongNganHang {
    private Map<String, TaiKhoanTietKiem> danhSachTaiKhoanTietKiem = new HashMap<>();
    private Map<String, TaiKhoanThanhToan> danhSachTaiKhoanThanhToan = new HashMap<>();

    // Đăng ký tài khoản mới
    public boolean dangKi() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ban muon dang ki loai tai khoan nao?");
        System.out.println("1. Tai khoan tiet kiem");
        System.out.println("2. Tai khoan thanh toan");
        int loaiTaiKhoan = sc.nextInt();
        sc.nextLine();

        System.out.println("Nhap ten chu tai khoan:");
        String chuTaiKhoan = sc.nextLine();

        String soTaiKhoan;
        do {
            System.out.println("Nhap so tai khoan (8 chu so):");
            soTaiKhoan = sc.nextLine();
            if (!soTaiKhoan.matches("\\d{8}") || danhSachTaiKhoanTietKiem.containsKey(soTaiKhoan) || danhSachTaiKhoanThanhToan.containsKey(soTaiKhoan)) {
                System.out.println("So tai khoan khong hop le hoac da ton tai.");
            } else {
                break;
            }
        } while (true);

        System.out.println("Nhap mat khau:");
        String matKhau = sc.nextLine();
        
        System.out.println("Nhap so dien thoai:");
        String soDienThoai;
        do {
            soDienThoai = sc.nextLine();
            if (!soDienThoai.matches("\\d{10,11}")) {
                System.out.println("So dien thoai khong hop le! Vui long nhap lai.");
            } else {
                break;
            }
        } while (true);

        int otp = taoOTP();
        System.out.println("Ma OTP cua ban la: " + otp);
        int userOTP;
        do {
            System.out.print("Nhap ma OTP: ");
            userOTP = sc.nextInt();
            sc.nextLine();
            if (userOTP != otp) {
            System.out.println("Ma OTP khong chinh xac.Vui long nhap lai ma OTP!");
            }
            else {
                break;
        }
        } while(userOTP != otp);

        if (loaiTaiKhoan == 1) {
            System.out.println("Chon loai tiet kiem:");
            System.out.println("1. 1 nam (lai suat 5%)");
            System.out.println("2. 6 thang (lai suat 3%)");
            int kyHan = sc.nextInt();
            sc.nextLine();
            double laiSuat = (kyHan == 1) ? 5 : 3;
            TaiKhoanTietKiem tkTietKiem = new TaiKhoanTietKiem(soTaiKhoan, chuTaiKhoan, matKhau, soDienThoai, laiSuat, 5);
            danhSachTaiKhoanTietKiem.put(soTaiKhoan, tkTietKiem);
            System.out.println("Dang ki tai khoan tiet kiem thanh cong!");
        } else {
            System.out.print("Nhap han muc thau chi cho tai khoan thanh toan: ");
            double hanMucThauChi = sc.nextDouble();
            sc.nextLine();
            TaiKhoanThanhToan tkThanhToan = new TaiKhoanThanhToan(soTaiKhoan, chuTaiKhoan, matKhau, soDienThoai, hanMucThauChi);
            danhSachTaiKhoanThanhToan.put(soTaiKhoan, tkThanhToan);
            System.out.println("Dang ki tai khoan thanh toan thanh cong!");
        }

        return true;
    }

    // Đăng nhập tài khoản
    public TaiKhoanNganHang dangNhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ban muon dang nhap vao tai khoan nao?");
        System.out.println("1. Tai khoan tiet kiem");
        System.out.println("2. Tai khoan thanh toan");
        int loaiTaiKhoan = sc.nextInt();
        sc.nextLine();

        System.out.println("Nhap so tai khoan:");
        String soTaiKhoan = sc.nextLine();

        TaiKhoanNganHang taiKhoan = (loaiTaiKhoan == 1) ? danhSachTaiKhoanTietKiem.get(soTaiKhoan) : danhSachTaiKhoanThanhToan.get(soTaiKhoan);

        if (taiKhoan == null) {
            System.out.println("Tai khoan khong ton tai.");
            return null;
        }

        int soLanThu = 0;
        while (soLanThu < 5) {
            System.out.print("Nhap mat khau: ");
            String matKhau = sc.nextLine();
            if (taiKhoan.getMatKhau().equals(matKhau)) {
                System.out.println("Dang nhap thanh cong.");
                return taiKhoan;
            } else {
                soLanThu++;
                System.out.println("Mat khau khong chinh xac. Con " + (5 - soLanThu) + " lan thu.");
            }
        }
        System.out.println("Dang nhap that bai!");
        return null;
    }

    // Tạo OTP ngẫu nhiên
    public int taoOTP() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }

    // Đổi mật khẩu
    public boolean doiMatKhau(TaiKhoanNganHang taiKhoan) {
        Scanner sc = new Scanner(System.in);
        int soLanThu = 0;

        while (soLanThu < 5) {
            System.out.print("Nhap mat khau cu: ");
            String matKhauCu = sc.nextLine();

            if (taiKhoan.getMatKhau().equals(matKhauCu)) {
                System.out.print("Nhap mat khau moi: ");
                String matKhauMoi = sc.nextLine();
                taiKhoan.setPassword(matKhauMoi);
                System.out.println("Doi mat khau thanh cong.");
                return true;
            } else {
                soLanThu++;
                System.out.println("Mat khau cu khong chinh xac. Vui long thu lai.");
            }
        }

        System.out.println("Ban da nhap sai qua nhieu lan.");
        return false;
    }

    // Tìm tài khoản theo số tài khoản
    public TaiKhoanNganHang timTaiKhoan(String soTaiKhoan) {
        if (danhSachTaiKhoanTietKiem.containsKey(soTaiKhoan)) {
            return danhSachTaiKhoanTietKiem.get(soTaiKhoan);
        } else if (danhSachTaiKhoanThanhToan.containsKey(soTaiKhoan)) {
            return danhSachTaiKhoanThanhToan.get(soTaiKhoan);
        }
        return null;
    }
}
